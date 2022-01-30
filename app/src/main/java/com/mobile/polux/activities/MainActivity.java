package com.mobile.polux.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.polux.BuildConfig;
import com.mobile.polux.R;
import com.mobile.polux.activities.recaudaciones.GuideListActivity;
import com.mobile.polux.activities.recaudaciones.InvoiceActivity;
import com.mobile.polux.app.App;
import com.mobile.polux.models.AplicaDescuentoResponse;
import com.mobile.polux.models.BankResponse;
import com.mobile.polux.models.ClientsResponse;
import com.mobile.polux.models.GeoLocation;
import com.mobile.polux.models.GeolocationResponse;
import com.mobile.polux.models.OrdersResponse;
import com.mobile.polux.models.Parameter;
import com.mobile.polux.models.Product;
import com.mobile.polux.models.ProductsResponse;
import com.mobile.polux.utils.Dialog;
import com.mobile.polux.utils.Synchronize;
import com.mobile.polux.utils.Util;
import com.mobile.polux.utils.UtilDB;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private Toolbar toolbar;

    private ImageView ivIconCompany;
    private TextView tvUserName;
    private TextView tvCompany;
    private TextView tvSubCompany;
    private TextView tvVersion;
    private TextView Sucursal;
    private TextView tvLastUpdate;
    private TextView textV;

    private LinearLayout llMap;
    private LinearLayout llClients;
    private LinearLayout llOrders;
    private LinearLayout llPending;
    private LinearLayout llCashing;
    private LinearLayout llDelivery;
    private LinearLayout llInvoices;
    private ProgressDialog progressDialog;


    private Realm realm;

    private Util util;

    private boolean syncClient;
    private boolean syncProduct;
    private Integer codigoHttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if (util == null) {
            util = new Util();
        }
        //shortAnimTime = 0;
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
        //   shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        // }

        bindUI();
        initMenuMain();

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        checkLastUpdate();

        Bundle bundle = getIntent().getExtras();

        if (App.getValueOfPreferencesUser(App.KEY_USE_PROMOTION).equalsIgnoreCase("S")) {
            if (bundle != null && bundle.containsKey("messageOrder")) {
                showDialogOrder(
                        bundle.getLong("numOrder", 0l),
                        bundle.getString("messageOrder", ""),
                        bundle.getString("messagePromotion", "No hay promociones para esta orden"),
                        "Información del Pedido",
                        bundle.getInt("codigoHttp"));

            }
        }else{
            if (bundle != null && bundle.containsKey("messageOrder")) {
                showDialogOrder(
                        bundle.getLong("numOrder", 0l),
                        bundle.getString("messageOrder", ""),
                        bundle.getString("messagePromotion", "Pedido Enviado Correctamente, revisa tu bandeja de pedidos para confirmar"),
                        "Información del Pedido",
                        bundle.getInt("codigoHttp"));

            }
        }
    }

    private void bindUI() {
        App.prepareCompanyData();
        App.prepareUserData();
        App.prepareCallService();
        App.prepareCallServiceOrder();
        tvUserName = (TextView) findViewById(R.id.tv_user);
        Sucursal = (TextView) findViewById(R.id.txt_sucursal);
        tvLastUpdate = (TextView) findViewById(R.id.tv_last_update);
        textV = (TextView)findViewById(R.id.textV);
        llMap = (LinearLayout) findViewById(R.id.ll_map);
        llMap.setOnClickListener(this);
        llClients = (LinearLayout) findViewById(R.id.ll_clients);
        llClients.setOnClickListener(this);
        llOrders = (LinearLayout) findViewById(R.id.ll_orders);
        llOrders.setOnClickListener(this);
        llPending = (LinearLayout) findViewById(R.id.ll_pending);
        llPending.setOnClickListener(this);
        llCashing = (LinearLayout) findViewById(R.id.ll_cashing);
        llCashing.setOnClickListener(this);
        llDelivery = (LinearLayout) findViewById(R.id.ll_delivery);
        llDelivery.setOnClickListener(this);
        llInvoices = (LinearLayout) findViewById(R.id.ll_invoices);
        llInvoices.setOnClickListener(this);

        tvUserName.setText(App.userName);
        Sucursal.setText(App.subCompanyName);


        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }
    }



    private void initMenuMain() {
        try {
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            View headerView = navigationView.getHeaderView(0);
            ivIconCompany = (ImageView) headerView.findViewById(R.id.iv_icon);
            tvCompany = (TextView) headerView.findViewById(R.id.tv_company);
            tvSubCompany = (TextView) headerView.findViewById(R.id.tv_sub_company);
            tvCompany.setText(App.companyName);
            tvSubCompany.setText(App.subCompanyName);
            tvVersion = (TextView) headerView.findViewById(R.id.tv_version);
            PackageInfo pinfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            tvVersion.setText("v "+ BuildConfig.VERSION_NAME);
            textV.setText("v. "+BuildConfig.VERSION_NAME);

            Bitmap bitmap = loadImageBitmap(getApplicationContext(), "icon_company.png");
            ivIconCompany.setImageBitmap(bitmap);

        } catch (Exception e) {
        }

    }

    public Bitmap loadImageBitmap(Context context, String imageName) {
        Bitmap bitmap = null;
        FileInputStream fiStream;
        try {
            fiStream    = context.openFileInput(imageName);
            bitmap      = BitmapFactory.decodeStream(fiStream);
            fiStream.close();
        } catch (Exception e) {
        }
        return bitmap;
    }

    private void showDialogOrder(Long order, String message, String promotions, String titulo,Integer codigoHttp) {
        final View view = getLayoutInflater().inflate(R.layout.order, null);
        final android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(titulo);


        alertDialog.setCancelable(false);

        TextView tvOrder = (TextView) view.findViewById(R.id.tv_order);
        TextView tvMessage = (TextView) view.findViewById(R.id.tv_message);
        LinearLayout llPromotion = (LinearLayout)  view.findViewById(R.id.ll_promotion);
        final TextView tvPromotions = (TextView) view.findViewById(R.id.tv_promotions);

        if(codigoHttp == 200){
            if(App.getValueOfPreferencesUser(App.KEY_USE_PROMOTION).equalsIgnoreCase("S")) {
                tvOrder.setText("" + order);
                tvMessage.setText("" + message);
                llPromotion.setVisibility(View.VISIBLE);
                tvPromotions.setText("" + promotions);
                alertDialog.setIcon(R.drawable.garrapata);
            }else{
                tvOrder.setText("" + order);
                tvMessage.setText("" + message);
                llPromotion.setVisibility(View.GONE);
                tvPromotions.setText("" + promotions);
            }
        }else{
            tvOrder.setText("" + order);
            tvMessage.setText("" + message);
            tvMessage.setTextColor(Color.RED);
            llPromotion.setVisibility(View.GONE);
            tvPromotions.setText("" + promotions);
            alertDialog.setIcon(R.drawable.advertencia);
        }


        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "ACEPTAR",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alertDialog.setView(view);
        alertDialog.show();
    }

    private void goToGeolocation() {
        Intent intent = new Intent(this, GeolocationDayActivity.class);
        startActivity(intent);
    }

    private void goToClients() {
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
        finish();
    }

    private void goToOrders() {
        Intent intent = new Intent(this, OrdersActivity.class);
        startActivity(intent);
    }

    private void goToNewOrders() {
        OrderProductsActivity.initialize();
        OrderClientActivity.account = null;
        OrderClientActivity.client = null;
        OrderProductsActivity.isEdit = false;
        Intent intent = new Intent(this, OrderClientActivity.class);
        startActivity(intent);
    }

    private void goToOrdersOff() {
        Intent intent = new Intent(this, OrdersOffActivity.class);
        startActivity(intent);
    }

    private void goToDelivery() {
        Intent intent = new Intent(this, DeliveryActivity.class);
        startActivity(intent);
    }

    private void goToGuides() {
        Intent intent = new Intent(this, GuideListActivity.class);
        startActivity(intent);
    }

    private void goToInvoices() {
        Intent intent = new Intent(this, InvoiceActivity.class);
        startActivity(intent);
    }


    private void reset() {
        try {
            App.removeAllSharedPreferences();
            clear();
            realm.beginTransaction();
            realm.deleteAll();
            realm.commitTransaction();
        } catch (Exception e) {
        }
        restartApp();
    }

    private void clear() {
        ClientActivity.client = null;
        OrderClientActivity.account = null;
        OrderClientActivity.client = null;
        OrderProductsActivity.initialize();
    }

    private void preLogout() {
        long cant = UtilDB.cantOrdenerPendientes(realm);
        if (cant < 1) {
            UtilDB.deleteAll(realm);
            App.saveValueOnPreferencesUser(App.KEY_USER_CODE, "");
            logout();
        } else {
            showDialogConfirm();
        }
    }

    private void logout() {

        App.saveValueOnPreferencesUser(App.KEY_SUB_COMPANY_CODE, 0);
        App.saveValueOnPreferencesUser(App.KEY_lAST_UPDATE, "");
        clear();
        restartApp();
    }

    private void restartApp() {
        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    private void deleteAllVisits() {
        try {
            RealmResults<GeoLocation> results = realm.where(GeoLocation.class).findAll();
            realm.beginTransaction();
            results.deleteAllFromRealm();
            realm.commitTransaction();
        } catch (Exception e) {
        }
    }

    private ProgressDialog progress;

    private void synchronize() {
        progress = Util.barraCargando(MainActivity.this,"Descargando Clientes...");
        progress.setCancelable(false);
        progress.show();

        callClients();
    }

    private void checkLastUpdate() {

        boolean sync = false;
        Parameter parameter = realm.where(Parameter.class).equalTo("name", App.KEY_lAST_UPDATE).findFirst();
        if (parameter == null || parameter.getValue() == null || parameter.getValue().isEmpty()) {
            sync = true;
            synchronize();

        } else {
            tvLastUpdate.setText(parameter.getValue());
        }
        if (!sync) {

            Parameter lastUpdateDay = realm.where(Parameter.class).equalTo("name", App.KEY_lAST_UPDATE_DAY).findFirst();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String date = dateFormat.format(new Date());
            if (lastUpdateDay == null || lastUpdateDay.getValue() == null || !date.equals(lastUpdateDay.getValue())) {
              /*  progress = new ProgressDialog(this);
                progress.setMessage("Obteniendo clientes a visitar para hoy, por favor espere...");
                progress.show(); */
                deleteAllVisits();
                callVisits();
                //progress.dismiss();
            }
        }
    }

    DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private void callClients() {

        Call<ClientsResponse> response = App.services.allClients(App.companyCode, App.userSequence, "NOMBRE_CLIENTE", "");

        response.enqueue(new Callback<ClientsResponse>() {
            @Override
            public void onResponse(Call<ClientsResponse> call, Response<ClientsResponse> response) {

                if (response.body() != null) {

                    String message = response.body().getMessage();

                    if ("OK".equals(message) && response.body().getClients() != null) {
                        Log.e("NOMBRE "," CLIENTE ---> " +response.body().getClients());

                        Synchronize.clients(realm, response.body().getClients());
                        syncClient = true;
                        showToastL("Clientes Descargados de Manera Correcta");
                    } else {
                        showToastL("No se encontraron clientes");
                    }
                } else {

                    showToastL("El servicio retorno un error, No se encontraron clientes");
                }
                progress.dismiss();
                callProducts();
            }

            @Override
            public void onFailure(Call<ClientsResponse> call, Throwable t) {
                progress.dismiss();
                callProducts();
                showToastL("Ocurrió un error al Descargar Clientes "+t);
            }

        });
    }

    private void callProducts() {
        progress = Util.barraCargando(MainActivity.this,"Descargando Productos ...");
        Call<ProductsResponse> response = App.services.allProducts(App.companyCode, App.subCompanyCode);

        response.enqueue(new Callback<ProductsResponse>() {
            @Override
            public void onResponse(Call<ProductsResponse> call, Response<ProductsResponse> response) {

                if (response.body() != null) {

                    String message = response.body().getMessage();

                    if ("OK".equals(message) && response.body().getProducts() != null) {
                        Synchronize.products(realm, response.body().getProducts());
                        syncProduct = true;
                        showToastL("Productos Descargados de Manera Exitosa");
                    } else {
                        showToastL("No se encontraron productos");
                    }
                } else {
                    showToastL("El servicio retorno un error, No se encontraron productos");
                }
                //callVisits();
                progress.dismiss();
                callAplicaDescuento();
                saveLast();
            }

            @Override
            public void onFailure(Call<ProductsResponse> call, Throwable t) {
                //callVisits();
                progress.dismiss();
                callAplicaDescuento();
                showToastL("Ocurrió un error al Descargar los Productos " +t);
                saveLast();
            }
        });
    }

    private void callAplicaDescuento() {
        progress = Util.barraCargando(MainActivity.this,"Validando Productos que Aplican Descuentos...");
        Call<AplicaDescuentoResponse> response = App.services.consultaAplicaDescuento(App.companyCode);

        response.enqueue(new Callback<AplicaDescuentoResponse>() {
            @Override
            public void onResponse(Call<AplicaDescuentoResponse> call, Response<AplicaDescuentoResponse> response) {

                if (response.body() != null) {

                    String message = response.body().getMensaje();

                    if ("OK".equals(message) ) {
                         App.saveValueOnPreferencesUser(App.KEY_DISCOUNT , response.body().getPermiteModificarDescuentoApp());
                         App.saveValueOnPreferencesUser(App.KEY_DISCOUNT_VALUE , response.body().getPermiteModificarValorDescuento());
                         App.saveValueOnPreferencesUser(App.KEY_DISCOUNT_PERCENT , response.body().getPermiteModificarPorcentajeDescuento());


                    } else {
                        showToastL("No se encontraron parámetros para descuentos");
                    }
                } else {
                    showToastL("El servicio retorno un error, No se encontraron parámetros para descuentos");
                }
                //callVisits();
                progress.dismiss();
                callOrders();
            }

            @Override
            public void onFailure(Call<AplicaDescuentoResponse> call, Throwable t) {
                //callVisits();
                progress.dismiss();
                callOrders();
                showToastL("Ocurrió un error al Descargar Descuentos "+t);
            }
        });
    }

    private void callVisits() {
        progress = Util.barraCargando(MainActivity.this,"Descargando Visitas a Realizar ...");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final String date = dateFormat.format(new Date());

        Call<GeolocationResponse> response = App.services.geolocationDays(App.companyCode, App.userSequence, date, date);

        response.enqueue(new Callback<GeolocationResponse>() {
            @Override
            public void onResponse(Call<GeolocationResponse> call, Response<GeolocationResponse> response) {
                progress.dismiss();
                if (response.body() != null) {

                    String message = response.body().getMessage();

                    if ("OK".equals(message)) {
                        saveParameter(App.KEY_lAST_UPDATE_DAY, date);
                        if (response.body().getGeolocalities() != null) {
                            Synchronize.visits(realm, response.body().getGeolocalities(), date);
                            progress.dismiss();
                            showToastL("Visitas Cargadas de Manera Exitosa");

                        } else {
                            progress.dismiss();

                            showToastL("No se encontraron clientes a visitar hoy");
                        }
                    }
                }
                //callOrders();
            }

            @Override
            public void onFailure(Call<GeolocationResponse> call, Throwable t) {
                progress.dismiss();
                //callOrders();
                showToastL("Ocurrió un error al Descargar Visitas "+t);
            }

        });
    }

    private void callBanks() {
        progress = Util.barraCargando(MainActivity.this,"Descargando Bancos...");
        Call<BankResponse> response = App.services.banks(App.companyCode);
        response.enqueue(new Callback<BankResponse>() {
            @Override
            public void onResponse(Call<BankResponse> call, Response<BankResponse> response) {
                if (response.body() != null) {
                    String message = response.body().getMessage();
                    if ("OK".equals(message) && response.body().getBanks() != null && !response.body().getBanks().isEmpty()) {
                        Synchronize.banks(realm, response.body().getBanks());
                        showToastL("Bancos Cargado de Manera Exitosa");
                    }
                }
                progress.dismiss();
                callVisits();
            }

            @Override
            public void onFailure(Call<BankResponse> call, Throwable t) {
                progress.dismiss();
                callVisits();
                showToastL("Ocurrió un error al descargar Bancos "+t);
            }

        });
    }

    private void callOrders() {
    progress = Util.barraCargando(MainActivity.this,"Descargando Ordenes ...");
        Call<OrdersResponse> response = App.servicesOrder.orders(App.companyCode, App.userSequence);

        response.enqueue(new Callback<OrdersResponse>() {
            @Override
            public void onResponse(Call<OrdersResponse> call, Response<OrdersResponse> response) {
                //progress.dismiss();
                if (response.body() != null) {

                    if ("OK".equals(response.body().getMensaje())) {
                        if (response.body().getOrdenes() != null && !response.body().getOrdenes().isEmpty()) {
                            Synchronize.orders(realm, response.body().getOrdenes(), false);
                            showToastL("Ordenes Descargadas de Manera Exitosa");

                        } else {
                            showToastL("No se encontraron ordenes");
                        }
                    }
                } else {
                    showToastL("El servicio Ordenes retorno un error, No se encontraron ordenes del usuario");
                }
                progress.dismiss();
                callBanks();
            }

            @Override
            public void onFailure(Call<OrdersResponse> call, Throwable t) {
                progress.dismiss();
                callBanks();
                //progress.dismiss();
                showToastL("Ocurrió un error al Descargar sus Ordenes "+t);
            }

        });
    }

    private void saveLast() {
        if (syncClient || syncProduct) {

            String value = df.format(new Date());
            saveParameter(App.KEY_lAST_UPDATE, value);
            tvLastUpdate.setText(value);
        }
    }

    private void saveParameter(String name, String value) {
        try {
            Parameter parameter = new Parameter();
            parameter.setName(name);
            parameter.setValue(value);
            if (!realm.isInTransaction()) {
                realm.beginTransaction();
            }
            realm.copyToRealmOrUpdate(parameter);
            realm.commitTransaction();
        } catch (Exception e) {
        }
    }

    private void showToastL(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_new_client:
                showToastL("Proximamente...");
                break;
            case R.id.nav_new_order:
                goToNewOrders();
                break;
            case R.id.nav_sync:
                synchronize();
                break;
            case R.id.nav_reset:
                reset();
                break;
            case R.id.nav_logout:
                preLogout();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_map:
                goToGeolocation();
                break;
            case R.id.ll_clients:
                goToClients();
                break;
            case R.id.ll_orders:
                goToOrders();
                break;
            case R.id.ll_pending:
                goToOrdersOff();
                break;
            case R.id.ll_delivery:
                //goToDelivery();
                break;
            case R.id.ll_cashing:
                goToGuides();
                break;
            case R.id.ll_invoices:
                //goToInvoices();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.close();
        }
        util = null;
    }

    private void showDialogConfirm() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Aviso");
        alertDialog.setIcon(R.drawable.pedidos);
        alertDialog.setMessage("Hay pedidos pendientes de envío ¿Desea conservarlos?");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "SI",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        UtilDB.deleteAllNoOrderOff(realm);
                        logout();
                    }
                });
        alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        UtilDB.deleteAll(realm);
                        App.saveValueOnPreferencesUser(App.KEY_USER_CODE, "");
                        logout();
                    }
                });
        alertDialog.show();
    }
}
