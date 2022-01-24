package com.mobile.polux.activities;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.content.FileProvider;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mobile.polux.BuildConfig;
import com.mobile.polux.R;
import com.mobile.polux.adapters.LocationAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.LocalitiesResponse;
import com.mobile.polux.models.UpdateResponse;
import com.mobile.polux.utils.Dialog;
import com.mobile.polux.utils.Util;
import com.squareup.picasso.Picasso;
//import com.squareup.picasso.Callback;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import id.zelory.compressor.Compressor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

public class LocationActivity extends AppCompatActivity implements View.OnClickListener, OnConnectionFailedListener {

    private TextView tvName;
    private TextView tvAddress;
    private TextView tvAddressDelivery;
    private TextView tvLocation;
    private TextView tvPhone;
    private LinearLayout llLocation;
    private LinearLayout llImage;

    private final int PLACE_PIKER = 1;

    private int clientId;
    private int id;

    private GoogleApiClient mGoogleApiClient;

    private double latitude;
    private double longitude;

    private View mProgressView;
    private Util util;
    private int shortAnimTime;

    private static String APP_DIRECTORY = "MyPictureApp/";
    private static String MEDIA_DIRECTORY = APP_DIRECTORY + "PictureApp";

    private final int MY_PERMISSIONS = 100;
    private final int PHOTO_CODE = 200;
    //private final int SELECT_PICTURE = 300;

    private String mPath;
    public ImageView imageView;
    private RelativeLayout mRlView;
    private ScrollView scrollView;

    private Dialog dialogUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mGoogleApiClient = new GoogleApiClient
                .Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addApi(Places.PLACE_DETECTION_API)
                .enableAutoManage(this, this)
                .build();

        bindUI();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getInt("locationId");
            clientId = bundle.getInt("clientId");
            setValues(
                    bundle.getString("name", ""),
                    bundle.getString("address", ""),
                    bundle.getString("addressDelivery", ""),
                    bundle.getString("latitude", ""),
                    bundle.getString("longitude", ""),
                    bundle.getString("img", ""),
                    bundle.getString("phone", "")
            );
        }

        mProgressView = findViewById(R.id.progress);
        if (util == null) {
            util = new Util();
        }
        shortAnimTime = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        }

        mayRequestStoragePermission();
    }

    private void bindUI() {
        dialogUtil = new Dialog();
        tvName = (TextView) findViewById(R.id.tv_name);
        tvAddress = (TextView) findViewById(R.id.tv_address);
        tvAddressDelivery = (TextView) findViewById(R.id.tv_address_delivery);
        tvPhone = (TextView) findViewById(R.id.tv_phone);
        tvLocation = (TextView) findViewById(R.id.tv_location);
        llLocation = (LinearLayout) findViewById(R.id.ll_location);
        llLocation.setOnClickListener(this);
        llImage = (LinearLayout) findViewById(R.id.ll_image);
        llImage.setOnClickListener(this);
        mRlView = (RelativeLayout) findViewById(R.id.activity_location);
        imageView = (ImageView) findViewById(R.id.iv_image);
        scrollView  = (ScrollView) findViewById(R.id.scrollView);
    }

    private void setValues(String name, String address, String addressDelivery, String latitude, String longitude, String img, String phone) {
        tvName.setText(name);
        tvAddress.setText(address);
        tvAddressDelivery.setText(addressDelivery);
        tvPhone.setText(phone);
        if (latitude == null || latitude.isEmpty()) {
            tvLocation.setText("No tiene registrada una ubicación");
            this.latitude = 0;
            this.longitude = 0;
        } else {
            tvLocation.setText(latitude + " , " + longitude);
            this.latitude = Double.parseDouble(latitude);
            this.longitude = Double.parseDouble(longitude);
        }

        if (img !=null && !img.isEmpty()){
            final ProgressBar  progressBar = (ProgressBar) findViewById(R.id.loading);
            //imageView.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
            Picasso.with(getApplicationContext())
                    .load(img)
                    .fit().centerInside()
                    .rotate(90)
                    .into(imageView, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {
                            //imageView.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                        }

                        @Override
                        public void onError() {
                           // imageView.setVisibility(View.VISIBLE);
                            progressBar.setVisibility(View.GONE);
                        }
                    });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.save) {
            updateLocation();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_location:
                map();
                break;
            case R.id.ll_image:
                openCamera();
                break;
            default:
                break;
        }
    }

    private void map() {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();

        try {
            if (latitude != 0 && longitude != 0) {
                LatLngBounds latLngBounds = new LatLngBounds(new LatLng(latitude, longitude),
                        new LatLng(latitude, longitude));
                builder.setLatLngBounds(latLngBounds);
            }

            startActivityForResult(builder.build(this), PLACE_PIKER);
        } catch (GooglePlayServicesRepairableException e) {
        } catch (GooglePlayServicesNotAvailableException e) {
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (resultCode == RESULT_OK) {
            switch (requestCode) {

                case PLACE_PIKER:
                    Place place = PlacePicker.getPlace(data, this);

                    latitude = place.getLatLng().latitude;
                    longitude = place.getLatLng().longitude;

                    tvLocation.setText(latitude + " , " + longitude);
                    break;
                case PHOTO_CODE:
                    MediaScannerConnection.scanFile(this,
                            new String[]{mPath}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    //Log.i("ExternalStorage", "Scanned " + path + ":");
                                    //Log.i("ExternalStorage", "-> Uri = " + uri);
                                }
                            });

                    File f = new File(mPath);
                    Picasso.with(getApplicationContext())
                            .load(f)
                            .fit()
                            .centerInside()
                            .into(imageView);
                    break;
                default:
                    break;

            }
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {}

    private void openCamera() {
        File file = new File(Environment.getExternalStorageDirectory(), MEDIA_DIRECTORY);
        boolean isDirectoryCreated = file.exists();

        if (!isDirectoryCreated)
            isDirectoryCreated = file.mkdirs();

        if (isDirectoryCreated) {
            Long timestamp = System.currentTimeMillis() / 1000;
            String imageName = timestamp.toString() + ".jpg";

            mPath = Environment.getExternalStorageDirectory() + File.separator + MEDIA_DIRECTORY
                    + File.separator + imageName;

            File newFile = new File(mPath);

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            //new 18-01-2018
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);//these flags didn't work on Android Nougat.
            intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);

                Uri photoURI = FileProvider.getUriForFile(LocationActivity.this,
                        BuildConfig.APPLICATION_ID + ".provider",
                        newFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            } else {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(newFile));
            }
            startActivityForResult(intent, PHOTO_CODE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("file_path", mPath);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mPath = savedInstanceState.getString("file_path");
    }

    private boolean mayRequestStoragePermission() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return true;

        if ((checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) &&
                (checkSelfPermission(CAMERA) == PackageManager.PERMISSION_GRANTED) &&
                (checkSelfPermission(ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED))
            return true;

        if ((shouldShowRequestPermissionRationale(WRITE_EXTERNAL_STORAGE)) || (shouldShowRequestPermissionRationale(CAMERA))
                || (shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION))) {
            Snackbar.make(mRlView, "Los permisos son necesarios para poder usar la aplicación",
                    Snackbar.LENGTH_INDEFINITE).setAction(android.R.string.ok, new View.OnClickListener() {
                @TargetApi(Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {
                    requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, CAMERA, ACCESS_FINE_LOCATION}, MY_PERMISSIONS);
                }
            });
        } else {
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, CAMERA, ACCESS_FINE_LOCATION}, MY_PERMISSIONS);
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_PERMISSIONS) {
            if (grantResults.length == 4 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED
                    && grantResults[2] == PackageManager.PERMISSION_GRANTED && grantResults[3] == PackageManager.PERMISSION_GRANTED
                    ) {
                Toast.makeText(LocationActivity.this, "Permisos aceptados", Toast.LENGTH_SHORT).show();
            }
        } else {
            showExplanation();
        }
    }

    private void showExplanation() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LocationActivity.this);
        builder.setTitle("Permisos denegados");
        builder.setMessage("Para usar las funciones de la app necesitas aceptar los permisos");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", getPackageName(), null);
                intent.setData(uri);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                finish();
            }
        });

        builder.show();
    }

    private void updateLocation(){
        if (mPath == null || mPath.isEmpty()) {
            callUpdateLocation();
        } else {
            callUpdateLocationImg();
        }

    }

    private void callUpdateLocation() {

        Call<UpdateResponse> response = App.services.updateLocation(clientId, id, ""+longitude, ""+latitude, App.companyCode, App.userCode);

        util.showProgress(true, mProgressView, shortAnimTime);


        try {
            scrollView.setVisibility(View.GONE);
            response.enqueue(new Callback<UpdateResponse>() {
                @Override
                public void onResponse(Call<UpdateResponse> call, Response<UpdateResponse> response) {
                    scrollView.setVisibility(View.VISIBLE);

                    UpdateResponse updateResponse = response.body();

                    if (updateResponse == null) {
                        Gson gson = new Gson();
                        TypeAdapter<UpdateResponse> adapter = gson.getAdapter(UpdateResponse.class);
                        try {
                            if (response.errorBody() != null)
                                updateResponse =
                                        adapter.fromJson(
                                                response.errorBody().string());
                        } catch (IOException e) {
                        }
                    }
                    if (updateResponse == null) {
                        util.showProgress(false, mProgressView, shortAnimTime);
                        showToast("Ocurrió un error, No se obtuvo respuesta del servicio actualizar ubicación");
                        return;
                    }

                    if ("OK".equals(updateResponse.getMessage())) {
                        showToast("Se actualizo la ubicación del local con éxito");
                    } else {
                        dialogUtil.showDialog("Fallo la actualización de la ubicación gps", "mensaje obtenido: " + updateResponse.getMessage()
                                + "\ncausa: " + updateResponse.getCause(), LocationActivity.this);
                    }

                    util.showProgress(false, mProgressView, shortAnimTime);
                }

                @Override
                public void onFailure(Call<UpdateResponse> call, Throwable t) {
                    showToast("Fallo la actualización de la ubicación gps, problema para conectar con el servicio");
                    scrollView.setVisibility(View.VISIBLE);
                    util.showProgress(false, mProgressView, shortAnimTime);
                }
            });
        } catch (Exception e) {
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void callUpdateLocationImg() {
        File compressedImageFile = null;
        try {
            compressedImageFile = new Compressor(LocationActivity.this)
                    .compressToFile(new File(mPath));
        } catch (Exception e) {
            try {
            compressedImageFile = new File(mPath);
            } catch (Exception ex) { }
        }

        if (compressedImageFile == null) {
            Toast.makeText(LocationActivity.this, "No se pudo obtener la imagen", Toast.LENGTH_LONG).show();
        }

        Map<String, RequestBody> map = new HashMap<>();
        String fileName = compressedImageFile.getName();
        if (fileName == null){
            fileName = "polux.jpg";
        }
        RequestBody fileBody = RequestBody.create(MediaType.parse("image/png"), compressedImageFile);
        map.put("file\"; filename=\""+fileName+"\"", fileBody);
        //Call<UpdateResponse> response = App.services.updateLocationImage(clientId, id, ""+longitude, ""+latitude, App.companyCode, App.userCode, body, reqImg);
        Call<UpdateResponse> response = App.services.updateLocationImage(clientId, id, ""+longitude, ""+latitude, App.companyCode, App.userCode, map);


        util.showProgress(true, mProgressView, shortAnimTime);

        try {
            scrollView.setVisibility(View.GONE);
            response.enqueue(new Callback<UpdateResponse>() {
                @Override
                public void onResponse(Call<UpdateResponse> call, Response<UpdateResponse> response) {
                    scrollView.setVisibility(View.VISIBLE);

                    UpdateResponse updateResponse = response.body();

                    if (updateResponse == null) {
                        Gson gson = new Gson();
                        TypeAdapter<UpdateResponse> adapter = gson.getAdapter(UpdateResponse.class);
                        try {
                            if (response.errorBody() != null)
                                updateResponse =
                                        adapter.fromJson(
                                                response.errorBody().string());
                        } catch (IOException e) {
                        }
                    }
                    if (updateResponse == null) {
                        util.showProgress(false, mProgressView, shortAnimTime);
                        showToast("Ocurrió un error, No se obtuvo respuesta del servicio actualizar imagen y ubicación");
                        return;
                    }

                    if ("OK".equals(updateResponse.getMessage())) {
                        showToast("Se actualizo la imagen y ubicación del local con éxito");
                    } else {
                        dialogUtil.showDialog("Fallo la actualización de la imagen y ubicación gps", "mensaje obtenido: " + updateResponse.getMessage()
                                + "\ncausa: " + updateResponse.getCause(), LocationActivity.this);
                    }
                    util.showProgress(false, mProgressView, shortAnimTime);
                }

                @Override
                public void onFailure(Call<UpdateResponse> call, Throwable t) {
                    showToast("Fallo la actualización de imagen y ubicación del local, problema para conectar con el servicio");
                    scrollView.setVisibility(View.VISIBLE);
                    util.showProgress(false, mProgressView, shortAnimTime);
                }
            });
        } catch (Exception e) {
            scrollView.setVisibility(View.VISIBLE);
        }
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
