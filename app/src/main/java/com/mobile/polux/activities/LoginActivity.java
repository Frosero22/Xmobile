package com.mobile.polux.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.polux.R;
import com.mobile.polux.app.App;
import com.mobile.polux.models.DafSucursal;
import com.mobile.polux.models.LoginResponse;
import com.mobile.polux.models.SubCompaniesResponse;
import com.mobile.polux.utils.Util;
import com.mobile.polux.utils.UtilDB;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    // UI references.
    private EditText etEmail;
    private EditText etPassword;
    private Button btnLogin;

    private View mProgressView;
    private View mLoginFormView;
    String EmpresaPermiteDias;
    private Util util;
    private int shortAnimTime;


    private DafSucursal[] spinnerArraySucursales;
    private List<DafSucursal> sucursales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (!checkFinalizeInstall()) {
            goToFinish();
            return;
        }

        bindUI();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        App.prepareCallService();

    }

    private void bindUI() {
        etEmail = (EditText) findViewById(R.id.et_email);
        etPassword = (EditText) findViewById(R.id.et_pass);
        etPassword.setTypeface(Typeface.DEFAULT);
        btnLogin = (Button) findViewById(R.id.bt_login);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        if (util == null) {
            util = new Util();
        }

        shortAnimTime = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        }

    }

    private void setArraySpinner() {
        spinnerArraySucursales = new DafSucursal[sucursales.size()];
        for (int i = 0; i < sucursales.size(); i++) {
            spinnerArraySucursales[i] = sucursales.get(i);
        }
    }

    private void goToFinish() {
        Intent intent = new Intent(this, FinishInstallationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    private void login() {

        // Reset errors.
        etEmail.setError(null);
        etPassword.setError(null);

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(password) || !isValidPassword(password)) {
            etPassword.setError(getString(R.string.error_invalid_password));
            focusView = etPassword;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            etEmail.setError(getString(R.string.error_field_required));
            focusView = etEmail;
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
            email = email.trim();
            callLogin(email, password);
        }
    }

    private void callLogin(final String userCode, String password) {

        Call<LoginResponse> response = App.services.login(userCode, password);

        response.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                try {

                    if (response.body() != null) {

                        String message = response.body().getMessage();

                        if ("OK".equals(message) && response.body().getDafUsuariosSistema() != null) {

                            if (!App.getValueOfPreferencesUser(App.KEY_USER_CODE).isEmpty() && !userCode.equals(App.getValueOfPreferencesUser(App.KEY_USER_CODE))) {
                                Realm realm = Realm.getDefaultInstance();
                                UtilDB.deleteAll(realm);
                            }
                            App.saveValueOnPreferencesUser(App.KEY_USER_CODE, userCode);
                            App.saveValueOnPreferencesUser(App.KEY_USER_MAIL, response.body().getDafUsuariosSistema().getCuentaMail());
                            App.saveValueOnPreferencesUser(App.KEY_USER_NAME, response.body().getDafUsuariosSistema().getNombreCompleto());
                            App.saveValueOnPreferencesUser(App.KEY_USER_SEQUENCE, response.body().getDafUsuariosSistema().getSecuenciaPersonal());

                            callSubCompanies(userCode);
                            return;
                        }
                    }
                } catch (Exception e) {
                    Log.e("Login", "Error en la autenticación de usuario Error: "+e);
                }
                etEmail.setError(getString(R.string.error_incorrect_password));
                etPassword.setError(getString(R.string.error_incorrect_password));
                etPassword.requestFocus();
                Toast.makeText(getApplicationContext(), R.string.error_incorrect_password, Toast.LENGTH_LONG).show();

                util.showProgress(false, mProgressView, mLoginFormView, shortAnimTime);

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                util.showProgress(false, mProgressView, mLoginFormView, shortAnimTime);
                Toast.makeText(getApplicationContext(), "Ocurrió un error, por favor verifique su acceso a internet", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void callSubCompanies(final String user) {


        Call<SubCompaniesResponse> response = App.services.subCompanies(user, App.getValueOfPreferencesUser(App.KEY_COMPANY_CODE, 00));

        response.enqueue(new Callback<SubCompaniesResponse>() {
            @Override
            public void onResponse(Call<SubCompaniesResponse> call, Response<SubCompaniesResponse> response) {

                if (response.body() != null) {

                    String message = response.body().getMessage();

                    if ("OK".equals(message) && response.body().getCompany() != null && response.body().getDafSucursales() != null) {

                        try {


                            App.saveValueOnPreferencesUser(App.KEY_COMPANY_NAME, response.body().getCompany().getNombreEmpresa());
                            App.saveValueOnPreferencesUser(App.KEY_USE_PROMOTION, response.body().getCompany().getUsaPromocion());
                            App.saveValueOnPreferencesUser(App.KEY_USE_EQUIV, response.body().getCompany().getUsaEquivalencias());
                            App.saveValueOnPreferencesUser(App.KEY_DAYS_ORDER, new Integer(response.body().getCompany().getCantDaysOrder()));
                            App.saveValueOnPreferencesUser(App.KEY_DIAS_PEDIDO, response.body().getCompany().getPermiteModificarDiasPedido());
                            App.saveValueOnPreferencesUser(App.KEY_TYPE_ORDER, response.body().getCompany().getUniqueTypeOrder());

                            App.saveValueOnPreferencesUser(App.KEY_TYPE_ORDER_TYPE_PAYMENT, response.body().getCompany().getTipoOrdenTipoPago());
                            App.saveValueOnPreferencesUser(App.KEY_PROMOTION_GROUP, response.body().getCompany().getPromotionGroup());
                            App.saveValueOnPreferencesUser(App.KEY_PROMOTION_SUBGROUP, response.body().getCompany().getPromotionSubGroup());
                            App.saveValueOnPreferencesUser(App.KEY_PROMOTION_ARTICLE, response.body().getCompany().getPromotionArticle());

                        } catch (Exception e) {}

                        if ("S".equals(response.body().getCompany().getUsaPromocion())){
                            App.saveValueOnPreferencesUser(App.KEY_PROMOTION_ID, response.body().getCompany().getNemonicoPromociones());
                        }

                        if (response.body().getDafSucursales().size() == 1) {
                            App.saveValueOnPreferencesUser(App.KEY_SUB_COMPANY_CODE, response.body().getDafSucursales().get(0).getCodigoSucursal());
                            App.saveValueOnPreferencesUser(App.KEY_SUB_COMPANY_NAME, response.body().getDafSucursales().get(0).getNombreSucursal());
                            App.saveValueOnPreferencesUser(App.KEY_API_RULES,response.body().getDafSucursales().get(0).getApiKeyRules());
                            App.saveValueOnPreferencesUser(App.KEY_APLICA_EDICION_XRULES,response.body().getDafSucursales().get(0).getAplicaEdicionXRules());
                            App.saveValueOnPreferencesUser(App.KEY_ELIM_PROM_AUTO,response.body().getDafSucursales().get(0).getElimPromAutOrdenPedido());

                            Log.e("API","RULES KEY "+response.body().getDafSucursales().get(0).getApiKeyRules());

                            goToMain();
                        } else {
                            sucursales = response.body().getDafSucursales();
                            showDialog();
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "Ocurrio un problema al intentar obtener sucursales", Toast.LENGTH_LONG).show();
                    }
                }
                util.showProgress(false, mProgressView, mLoginFormView, shortAnimTime);
            }

            @Override
            public void onFailure(Call<SubCompaniesResponse> call, Throwable t) {
                util.showProgress(false, mProgressView, mLoginFormView, shortAnimTime);
                Log.e("Login", "failure " + t);
                Toast.makeText(getApplicationContext(), "Ocurrió un error, por favor verifique su acceso a internet", Toast.LENGTH_LONG).show();
            }
        });

    }

    private boolean isValidPassword(String password) {
        return password.length() >= 3;
    }

    private boolean checkFinalizeInstall() {
        return !(App.getValueOfPreferencesUser(App.KEY_WS_COMPANY).isEmpty());
    }

    private void goToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    private void showDialog() {

        final View view = getLayoutInflater().inflate(R.layout.sucursales, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
        alertDialog.setTitle("Selecciona la sucursal");
        alertDialog.setCancelable(false);

        setArraySpinner();

        final Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArraySucursales);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                DafSucursal sub = (DafSucursal)spinner.getSelectedItem();

                if (sub == null ){
                    Toast.makeText(getApplicationContext(), "Selecciona la sucursal", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    App.saveValueOnPreferencesUser(App.KEY_SUB_COMPANY_CODE, sub.getCodigoSucursal());
                    App.saveValueOnPreferencesUser(App.KEY_SUB_COMPANY_NAME, sub.getNombreSucursal());
                    App.saveValueOnPreferencesUser(App.KEY_API_RULES,sub.getApiKeyRules());
                    App.saveValueOnPreferencesUser(App.KEY_APLICA_EDICION_XRULES,sub.getAplicaEdicionXRules());
                    App.saveValueOnPreferencesUser(App.KEY_ELIM_PROM_AUTO,sub.getElimPromAutOrdenPedido());



                    goToMain();
                }


            }
        });


        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();
            }
        });


        alertDialog.setView(view);
        alertDialog.show();
    }

}
