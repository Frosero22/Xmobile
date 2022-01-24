package com.mobile.polux.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mobile.polux.R;
import com.mobile.polux.app.App;
import com.mobile.polux.models.FinalizeResponse;
import com.mobile.polux.service.Services;
import com.mobile.polux.utils.Util;
import com.squareup.picasso.Target;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class    FinishInstallationActivity extends AppCompatActivity {

    private EditText etRuc;
    private Button btnFinalize;
    private View mProgressView;
    private View mLoginFormView;
    private Retrofit retrofit;

    private Util util;

    public Services services;
    private int shortAnimTime;

    private Target target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_installation);

        if (checkFinalizeInstall()) {
            goToLogin();
            return;
        }

        bindUI();

        btnFinalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalizeInstall();
            }
        });

    }

    private void bindUI() {
        etRuc = (EditText) findViewById(R.id.et_ruc);
        btnFinalize = (Button) findViewById(R.id.bt_finalize);

        mLoginFormView = findViewById(R.id.finish_form);
        mProgressView = findViewById(R.id.finish_progress);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(70, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS).build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://magkaz.neu360.com:8080/X-uitWSRest/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        services = retrofit.create(Services.class);
        util = new Util();

        shortAnimTime = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        }
    }

    private boolean checkFinalizeInstall() {
        return !(App.getValueOfPreferencesUser(App.KEY_WS_COMPANY).isEmpty());
    }

    private void goToLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void finalizeInstall() {
        String ruc = etRuc.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(ruc) || !isValid(ruc)) {
            etRuc.setError(getString(R.string.error_invalid_ruc));
            focusView = etRuc;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            util.showProgress(true, mProgressView, mLoginFormView, shortAnimTime);
            callFinalize(ruc);
        }
    }

    private boolean isValid(String text) {
        return text.length() >= 9;
    }

    private void callFinalize(final String ruc) {

        //LoginRequest requestLogin = new LoginRequest(email, password, mac);
        Call<FinalizeResponse> response = services.finalizeInstall(ruc);

        response.enqueue(new Callback<FinalizeResponse>() {
            @Override
            public void onResponse(Call<FinalizeResponse> call, Response<FinalizeResponse> response) {

                try {

                    FinalizeResponse finalizeResponse = response.body();

                    if (finalizeResponse == null) {
                        Gson gson = new Gson();
                        TypeAdapter<FinalizeResponse> adapter = gson.getAdapter(FinalizeResponse.class);
                        try {
                            if (response.errorBody() != null)
                                finalizeResponse =
                                        adapter.fromJson(
                                                response.errorBody().string());
                        } catch (IOException e) {
                        }
                    }
                    if (finalizeResponse == null) {
                        util.showProgress(false, mProgressView, mLoginFormView, shortAnimTime);
                        showToast("Ocurrió un error, No se obtuvo respuesta del servicio Login, por favor intente mas tarde");
                        return;
                    }

                    if ("OK".equals(finalizeResponse.getMessage()) && finalizeResponse.getDafEmpresasMovil() != null) {
                        String ws = finalizeResponse.getDafEmpresasMovil().getIp();
                        ws = ws + "/" + finalizeResponse.getDafEmpresasMovil().getContextRoot();
                        App.saveValueOnPreferencesUser(App.KEY_COMPANY_CODE, response.body().getDafEmpresasMovil().getCompanyCode());
                        App.saveValueOnPreferencesUser(App.KEY_WS_COMPANY, ws);

                        //String wsBrms = finalizeResponse.getDafEmpresasMovil().getDireccionIpWsBrms();
                        //wsBrms = wsBrms + "/" + finalizeResponse.getDafEmpresasMovil().getNombreWarWsBrms();
                        App.saveValueOnPreferencesUser(App.KEY_WS_BRMS_IP, finalizeResponse.getDafEmpresasMovil().getDireccionIpWsBrms());
                        App.saveValueOnPreferencesUser(App.KEY_WS_BRMS_NAME, finalizeResponse.getDafEmpresasMovil().getNombreWarWsBrms());
                        Log.e("API","KEY "+finalizeResponse.getDafEmpresasMovil().getApiKeyRules());

                        download(finalizeResponse.getDafEmpresasMovil().getLogo());
                        goToLogin();
                        showToast("Felicidades completaste la instalación");
                    } else {
                        etRuc.setError(getString(R.string.error_ws_ruc));
                        etRuc.requestFocus();
                    }


                } catch (Exception e) {
                    etRuc.setError(getString(R.string.error_ws_ruc));
                    etRuc.requestFocus();
                } finally {
                    util.showProgress(false, mProgressView, mLoginFormView, shortAnimTime);
                }


            }

            @Override
            public void onFailure(Call<FinalizeResponse> call, Throwable t) {
                util.showProgress(false, mProgressView, mLoginFormView, shortAnimTime);
                showToast("Ocurrió un error, por favor verifique su acceso a internet");
            }
        });
    }

    public void saveImage(Context context, Bitmap b, String imageName) {
        FileOutputStream foStream;
        try {
            foStream = context.openFileOutput(imageName, Context.MODE_PRIVATE);
            b.compress(Bitmap.CompressFormat.PNG, 100, foStream);
            foStream.close();
        } catch (Exception e) {
        }

    }


    private void download(String url) {
        new DownloadImage().execute(url);
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        private Bitmap downloadImageBitmap(String sUrl) {
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new URL(sUrl).openStream();   // Download Image from URL
                bitmap = BitmapFactory.decodeStream(inputStream);       // Decode Bitmap
                inputStream.close();
            } catch (Exception e) {
            }
            return bitmap;
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            return downloadImageBitmap(params[0]);
        }

        protected void onPostExecute(Bitmap result) {
            saveImage(getApplicationContext(), result, "icon_company.png");
        }
    }
}
