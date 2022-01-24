package com.mobile.polux.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.mobile.polux.R;
import com.mobile.polux.adapters.VisitAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.Client;
import com.mobile.polux.models.GeoLocation;
import com.mobile.polux.models.GeolocationResponse;
import com.mobile.polux.models.VisitResponse;
import com.mobile.polux.utils.Dialog;
import com.mobile.polux.utils.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.realm.Case;
import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GeolocationDayActivity extends AppCompatActivity implements View.OnClickListener,LocationListener {

    private ProgressDialog progress;

    private final DateFormat dateFormatView = new SimpleDateFormat("dd/MM/yyyy");
    private final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private GoogleApiClient mGoogleApiClient;
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 1000;

    public static List<GeoLocation> geoLocalities;

    public static int total;
    public static long countVisit;
    public static long countOrder;
    private String message;
    private ListView lvVisits;
    private VisitAdapter adapter;
    private Util util;
    private TextView tvMessage;

    private EditText etDateIni;
    private EditText etDateEnd;

    private TextView tvTotal;
    private TextView tvPending;
    private TextView tvVisits;
    private TextView tvOrders;
    private Integer codigoLocalidad;
    private Integer codigoCliente;
    private EditText etSearch;
    private Button btnSearch;
    private int clientId;
    private int id;
    private Date ini;
    private Date end;
    private String date,codigoEmpresa,Usuario;
    private int itemPosition;
    private LocationRequest mLocationRequest;
    static String iphost;

    private Location loc;
    final String TAG = "GPS";
    private final static int ALL_PERMISSIONS_RESULT = 101;
    ArrayList<String> permissions = new ArrayList<>();
    ArrayList<String> permissionsToRequest;
    ArrayList<String> permissionsRejected = new ArrayList<>();
    boolean isGPS = false;
    boolean isNetwork = false;
    boolean canGetLocation = true;
    double latOri = 0.00, lonOri = 0.00, latDes = 0.00, lonDes = 0.00;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1;//1 Metro
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;//1 minuto
    private Map<String, Integer> counts;

    private Realm realm;
    private LocationManager locationManager;
    private Location location;
    private FusedLocationProviderClient fusedLocationClient;

    private boolean isWS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geolocation_day);

        getSupportActionBar().setTitle("Visitas a clientes");

        bindUI();

        ini = new Date();
        end = new Date();

        allVisitDay();
        prepareListView(geoLocalities);
        visibleResults();
        Bundle bundle = getIntent().getExtras();


        if (geoLocalities.isEmpty()) {
            visibleMessage();
        }

        if (util == null) {
            util = new Util();
        }
    }
    private ArrayList findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList result = new ArrayList();
        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }
        return result;
    }

    private boolean hasPermission(String permission) {
        if (canAskPermission()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private boolean canAskPermission() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    private void bindUI() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);

        Task<LocationSettingsResponse> result =
                LocationServices.getSettingsClient(this).checkLocationSettings(builder.build());



        result.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                try {
                    LocationSettingsResponse response = task.getResult(ApiException.class);
                    // All location settings are satisfied. The client can initialize location
                    // requests here.
                } catch (ApiException exception) {
                    switch (exception.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                            // Location settings are not satisfied. But could be fixed by showing the
                            // user a dialog.
                            try {
                                // Cast to a resolvable exception.
                                ResolvableApiException resolvable = (ResolvableApiException) exception;
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
                                resolvable.startResolutionForResult(
                                        GeolocationDayActivity.this,
                                        LocationRequest.PRIORITY_HIGH_ACCURACY);
                            } catch (IntentSender.SendIntentException e) {
                                // Ignore the error.
                            } catch (ClassCastException e) {
                                // Ignore, should be an impossible error.
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            // Location settings are not satisfied. However, we have no way to fix the
                            // settings so we won't show the dialog.
                            break;
                    }
                }
            }
        });




        locationManager = (LocationManager) getSystemService(Service.LOCATION_SERVICE);
        boolean permissionGranted = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
        if(permissionGranted) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, GeolocationDayActivity.this);

        } else {
            ActivityCompat.requestPermissions(  this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 200);
        }


        isGPS = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        isNetwork = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        permissionsToRequest = findUnAskedPermissions(permissions);

        if (!isGPS && !isNetwork) {
            Log.d(TAG, "Connection off");
            Dialog.dialogo("Advertencia","Tu GPS esta desactivado, por favor activalo para continuar",GeolocationDayActivity.this);
        } else {
            Log.d(TAG, "Connection on");
            // check permissions
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (permissionsToRequest.size() > 0) {
                    requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]),
                            ALL_PERMISSIONS_RESULT);
                    Log.d(TAG, "Permission requests");
                    canGetLocation = false;
                }
            }

        }


        isWS = false;
        tvMessage = (TextView) findViewById(R.id.message);
        lvVisits = (ListView) findViewById(R.id.lv_visits);

        tvTotal = (TextView) findViewById(R.id.tv_total);
        tvPending = (TextView) findViewById(R.id.tv_pending);
        tvVisits = (TextView) findViewById(R.id.tv_visits);
        tvOrders = (TextView) findViewById(R.id.tv_orders);

        etSearch = (EditText) findViewById(R.id.et_search);
        btnSearch = (Button) findViewById(R.id.btn_search);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        registerForContextMenu(lvVisits);

        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }

        lvVisits.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    if (adapter.getItemViewType(position) == VisitAdapter.TYPE_ITEM) {
                        itemPosition = position;
                        lvVisits.showContextMenu();
                    }
                } catch (Exception e) {
                    showToastL("Ocurrió un problema, intenta mas tarde");
                }
                return true;
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getInt("locationId");
            clientId = bundle.getInt("clientId", 0);
        }
    }


    private String text;

    private void search() {
        if (!etSearch.getText().toString().isEmpty()) {
            if (isWS) {
                text = etSearch.getText().toString();
                List<GeoLocation> geoLocalitiesFilters = new ArrayList<>();
                for (GeoLocation data : geoLocalities) {
                    if (data.getClientName().toLowerCase().contains(text.toLowerCase())) {
                        geoLocalitiesFilters.add(data);
                    }
                }
                prepareListView(geoLocalitiesFilters);
            } else {
                text = etSearch.getText().toString();
                geoLocalities = realm.where(GeoLocation.class)
                        .equalTo("date", dateFormat.format(new Date()))
                        .contains("clientName", text, Case.INSENSITIVE)
                        .findAll();
                total = geoLocalities.size();

                prepareListView(geoLocalities);
            }

        } else if (text != null && !text.isEmpty()) {
            if (isWS) {
                prepareListView(geoLocalities);
            } else {
                text = "";
                geoLocalities = realm.where(GeoLocation.class)
                        .equalTo("date", dateFormat.format(new Date()))
                        .findAll();
                prepareListView(geoLocalities);
            }
        }
    }

    private void setValuesToView() {
        String date = dateFormat.format(new Date());
        countVisit = realm.where(GeoLocation.class).equalTo("date", date).greaterThan("numVisits", 0).count();
        countOrder = realm.where(GeoLocation.class).equalTo("date", date).greaterThan("numOrders", 0).count();
        tvTotal.setText("" + total);
        tvPending.setText("" + (total - countVisit));
        tvVisits.setText("" + countVisit);
        tvOrders.setText("" + countOrder);
    }

    private void allVisitDay() {
        date = dateFormat.format(new Date());
        geoLocalities = realm.where(GeoLocation.class).equalTo("date", date).findAll();
        total = geoLocalities.size();

        setValuesToView();
    }

    private void prepareListView(List<GeoLocation> geoLocalities) {
        adapter = new VisitAdapter(GeolocationDayActivity.this);
        String lastDay = "";
        counts = new HashMap<>();
        int count = 0;
        for (GeoLocation geo : geoLocalities) {
            if (!lastDay.equals(geo.getDay())) {

                if (count > 0) {
                    counts.put(lastDay, count);
                    count = 0;
                }
                lastDay = geo.getDay();
            }
            count++;
        }
        counts.put(lastDay, count);
        lastDay = "";
        for (GeoLocation geo : geoLocalities) {

            if (!lastDay.equals(geo.getDay())) {
                lastDay = geo.getDay();
                int cant = 0;
                try {
                    cant = counts.get(lastDay);
                } catch (Exception e) {
                }
                adapter.addSectionHeaderItem(new GeoLocation(lastDay, 0, cant));
            }

            adapter.addItem(geo);
        }

        lvVisits.setAdapter(adapter);
    }

    private void visibleMessage() {
        lvVisits.setVisibility(View.GONE);
        tvMessage.setVisibility(View.VISIBLE);
    }

    private void visibleResults() {
        lvVisits.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.GONE);
    }

    private void goToMap(double latitude, double longitude, String name) {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("latitude", latitude);
        intent.putExtra("longitude", longitude);
        intent.putExtra("name", name);
        startActivity(intent);
    }

    private void goToClient(int id) {
        Intent intent = new Intent(this, ClientActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    private void goToOrder(int id) {
        Intent intent = new Intent(this, OrderClientActivity.class);
        intent.putExtra("id", id);
        OrderProductsActivity.initialize();
        OrderClientActivity.codigoLocalidad = -1;
        OrderClientActivity.account = null;
        OrderClientActivity.client = null;
        OrderProductsActivity.isEdit = false;
        OrderProductsActivity.isOff = false;
        startActivity(intent);
    }

    private void goToMap() {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("showAll", true);
        startActivity(intent);
    }

    private boolean getLocation() {
        try {
            if (canGetLocation) {
                isGPS=false;
                if (isGPS) {
                    // from GPS
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, (LocationListener) this);

                    if (locationManager != null) {
                        loc = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        return true;
                    }
                } else if (isNetwork) {
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATES, (LocationListener) this);

                    if (locationManager != null) {
                        loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        return true;
                    }
                } else {
                    if (loc==null) {
                        loc= locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        //     loc.setLatitude(-2.1480438);
                        //  loc.setLongitude(0.0);
                    }
                    return false;
                }
            } else {
                Toast.makeText(this, "No se pudo obtener la ubicación", Toast.LENGTH_SHORT).show();
                return false;
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return false;
    }


    private void updateVisits(GeoLocation geo, final int num) {
        final GeoLocation Geo = geo;

        geo = realm.where(GeoLocation.class).equalTo("clientId", geo.getClientId()).findFirst();
        if (geo == null) {
            showToastL("El cliente no esta planificado para el día de hoy, no es posible registrar visita");
            return;
        }

        getLocation();
        if (loc!=null) {
            latOri = loc.getLatitude();
            lonOri = loc.getLongitude();
            codigoLocalidad = geo.getCodigoLocalidad();
            codigoCliente = geo.getClientId();
        }else{
            latOri = 0.0;
            lonOri = 0.0;
        }

        if(util.existInternet(this)){

            RegistraVisitaWS(codigoLocalidad,codigoCliente,latOri,lonOri);
            realm.beginTransaction();
            Geo.setNumVisits(num);
            realm.copyToRealmOrUpdate(Geo);
            realm.commitTransaction();
            setValuesToView();

        }else {


            realm.beginTransaction();
            Geo.setNumVisits(num);
            realm.copyToRealmOrUpdate(Geo);
            realm.commitTransaction();
            Dialog.confirmacion("Advertencia","La Visita se Registro Localmente de Manera Correcta, Cuando tenga acceso a internet, por favor vuelva a registrarla en el sistema.",GeolocationDayActivity.this);
            setValuesToView();
        }








           }


    public void RegistraVisitaWS(Integer codigoLocalidad, Integer codigoCliente, Double latOri, Double lonOri ){
        progress = Util.barraCargando(GeolocationDayActivity.this, "Registrando Visita ...");

        try {




            Log.e("CODIGO LOCALIDAD","-----> "+codigoLocalidad);
            Log.e("CODIGO CLIENTE","-----> "+codigoCliente);
            Log.e("CODIGO EMPRESA","-----> "+App.companyCode);
            Log.e("USUARIO","----> "+App.userCode);
            Log.e("LATITUD ---> ","LATITUD ---> "+latOri);
            Log.e("LONGITUD ----> ","LONGITUD ---> "+lonOri);




            Call<VisitResponse> response = App.services.visit(codigoLocalidad,codigoCliente,App.companyCode,date,App.userCode,String.valueOf(latOri),String.valueOf(lonOri));

            response.enqueue(new Callback<VisitResponse>() {
                @Override
                public void onResponse(Call<VisitResponse> call, Response<VisitResponse> response) {
                    try {
                        progress.dismiss();
                        if (response.body() != null && response.isSuccessful()) {

                            message = response.body().getMessage();
                            if (message.equalsIgnoreCase("OK")) {

                                Dialog.confirmacion("Secuencia " + response.body().getSecuenciaVisita(), "Visita Registrada con Exito, "+response.body().getMessageOk() , GeolocationDayActivity.this);

                            }else{
                                Dialog.dialogo("Algo falló...", "Ocurrio un problema al momento de Registrar la Visita " + response.body().getCausa(), GeolocationDayActivity.this);
                            }

                        }else if (!response.isSuccessful()){
                            Dialog.recordatorio("Advertencia","El cliente ya tiene registrado una visita en esta localidad.",GeolocationDayActivity.this);
                        }
                    }catch (Exception e){
                        Dialog.dialogo("Algo Falló...","Excepcion Desconocida "+e,GeolocationDayActivity.this);
                    }
                }

                @Override
                public void onFailure(Call<VisitResponse> call, Throwable t) {
                    progress.dismiss();
                    Dialog.dialogo("Servicio de Visitas","Fallo al Ejecutar Servicio Web para Registrar Visita, mensaje obtenido: "+t,GeolocationDayActivity.this);

                }
            });


        } catch (Exception e) {
            progress.dismiss();
            e.printStackTrace();
            Dialog.recordatorio("Ocurrio un error","Se presento un error al registrar la visita --> "+e,GeolocationDayActivity.this);
        }

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_visit, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.item_register_visit:
                try {

                    GeoLocation geo = (GeoLocation) adapter.getItem(itemPosition);
                    int n = geo.getNumVisits();
                    n++;
                    updateVisits(geo, n);
                    adapter.notifyDataSetChanged();

                } catch (Exception e) {
                    Dialog.dialogo("Ocurrio un Error","Se Presento el Siguiente Error al Tomar la Visita -->  " +e,GeolocationDayActivity.this);

                    Log.e("error","obtenido --> " +e);
                }
                return true;
            case R.id.item_map:
                GeoLocation location = (GeoLocation) adapter.getItem(itemPosition);
                if (location.getLatitude() != null && location.getLongitude() != null) {
                    goToMap(
                            Double.parseDouble(location.getLatitude()),
                            Double.parseDouble(location.getLongitude()),
                            location.getClientName()
                    );
                } else {
                    Dialog.dialogo("Ocurrio un Problema...","El Cliente Seleccionado no cuenta con las Coordenadas X y Y para Su Busqueda",GeolocationDayActivity.this);
                }
                return true;
            case R.id.item_view:
                try {
                    goToClient(((GeoLocation) adapter.getItem(itemPosition)).getClientId());
                } catch (Exception e) {
                    Dialog.dialogo("Ocurrio un Problema...","El Cliente Seleccionado se encuentra mal Configurado, por favor comunicarse con Matriz " +e,GeolocationDayActivity.this);
                }
                return true;
            case R.id.item_order:
                try {
                    goToOrder(((GeoLocation) adapter.getItem(itemPosition)).getClientId());
                } catch (Exception e) {
                    Dialog.dialogo("Ocurrio un Problema...","El Cliente Seleccionado se encuentra mal Configurado, por favor comunicarse con Matriz " +e,GeolocationDayActivity.this);
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private MenuItem item;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_visit, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.item_search:
                showDialogDate();
                return true;
            case R.id.item_all:
                if (geoLocalities == null || geoLocalities.isEmpty()) {
                    showToastL("No hay ubicaciones para mostrar en el mapa");
                } else {
                    goToMap();
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    private void callGeolocationDays(String dateIni, String dateEnd) {

        progress = new ProgressDialog(this);
        progress.setIcon(R.drawable.espera);
        progress.setMessage("Obteniendo clientes a visitar, por favor espere...");
        progress.show();


        Call<GeolocationResponse> response = App.services.geolocationDays(App.companyCode, App.userSequence, dateIni, dateEnd);

        response.enqueue(new Callback<GeolocationResponse>() {
            @Override
            public void onResponse(Call<GeolocationResponse> call, Response<GeolocationResponse> response) {

                if (response.body() != null) {

                    String message = response.body().getMessage();

                    if ("OK".equals(message) && response.body().getGeolocalities() != null) {

                        isWS = true;
                        geoLocalities = response.body().getGeolocalities();

                        prepareListView(geoLocalities);
                        visibleResults();

                    } else {
                        visibleMessage();
                        showToastL("No se encontraron clientes");
                    }
                } else {
                    visibleMessage();
                }
                progress.dismiss();
            }

            @Override
            public void onFailure(Call<GeolocationResponse> call, Throwable t) {
                progress.dismiss();
                visibleMessage();
                showToastL("Ocurrió un error, por favor verifique su acceso a internet");
            }

        });
    }

    private void showDialogDate() {

        final View view = getLayoutInflater().inflate(R.layout.conten_search, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(GeolocationDayActivity.this).create();
        alertDialog.setTitle("Nueva búsqueda");
        alertDialog.setCancelable(false);

        etDateIni = (EditText) view.findViewById(R.id.et_date_ini);
        etDateEnd = (EditText) view.findViewById(R.id.et_date_end);

        etDateIni.setText(dateFormatView.format(ini));
        etDateEnd.setText(dateFormatView.format(end));

        etDateIni.setOnClickListener(GeolocationDayActivity.this);
        etDateEnd.setOnClickListener(GeolocationDayActivity.this);

        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.dismiss();

                try {
                    ini = dateFormatView.parse(etDateIni.getText().toString());
                    end = dateFormatView.parse(etDateEnd.getText().toString());
                    Log.e("FECHA","INICIO ---> "+dateFormat.format(ini));
                    Log.e("FECHA","FIN ---> "+dateFormat.format(end));

                    callGeolocationDays(
                            dateFormat.format(ini),
                            dateFormat.format(end)
                    );
                } catch (ParseException e) {
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

    private void showDialogDate(final boolean isDateIni, String date) {
        int month, day, year;
        if (date.isEmpty()) {
            day = 1;
            month = 1;
            year = 2018;
        } else {
            day = Integer.valueOf(date.substring(0, 2));
            month = Integer.valueOf(date.substring(3, 5));
            year = Integer.valueOf(date.substring(6, 10));
            month--;
        }

        DatePickerDialog.OnDateSetListener datePickerListener =
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                        selectedMonth++;
                        String month = selectedMonth < 10 ? "0" + selectedMonth : "" + selectedMonth;
                        String day = selectedDay < 10 ? "0" + selectedDay : "" + selectedDay;

                        if (isDateIni) {
                            etDateIni.setText(day + "/" + month + "/" + selectedYear);
                        } else {
                            etDateEnd.setText(day + "/" + month + "/" + selectedYear);
                        }
                    }
                };
        DatePickerDialog d = new DatePickerDialog(GeolocationDayActivity.this, datePickerListener, year, month, day);
        d.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_date_ini:
                showDialogDate(true, "" + etDateIni.getText());

                break;
            case R.id.et_date_end:
                showDialogDate(false, "" + etDateEnd.getText());
                break;
            default:
                break;
        }
    }

    private void showToastL(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            realm.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {
        getLocation();
    }

    @Override
    public void onProviderDisabled(String s) {
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
    }
}
