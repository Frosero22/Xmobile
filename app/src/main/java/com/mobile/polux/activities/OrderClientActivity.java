package com.mobile.polux.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.polux.R;
import com.mobile.polux.adapters.AccountClientAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.Account;
import com.mobile.polux.models.Client;
import com.mobile.polux.models.Location;
import com.mobile.polux.models.OrderType;
import com.mobile.polux.models.Rate;
import com.mobile.polux.utils.UtilDB;

import io.realm.Realm;



public class OrderClientActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llSearch;
    private LinearLayout llInfo;
    private LinearLayout llAccountClient;
    private TextView tvMessage;
    private Button btnNext;

    public static Client client;
    public static Account account;

    private TextView tvName;
    private TextView tvBusinessName;
    private TextView tvRuc;
    private TextView tvType;
    private Spinner spType;
    private Spinner spLocalidades;

    String PermiteEditarEdias;
    Integer Dias;
    private OrderType[] spinnerArrayTypes;

    private Realm realm;

    private ListView lvAccounts;
    private AccountClientAdapter adapter;

    private int accountId;
    private int position;
    public static Integer codigoLocalidad;

    private boolean isClientValid;

    private String original;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_client);

        getSupportActionBar().setTitle("Pedido - Cliente");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (realm == null || realm.isClosed()) {
            // Get a Realm instance for this thread
            realm = Realm.getDefaultInstance();
        }

        position = -1;
        accountId = -1;
        codigoLocalidad = -1;

        bindUI();

        disableButton();
        if (client != null) {
            setValues();
            llInfo.setVisibility(View.VISIBLE);
            tvMessage.setVisibility(View.GONE);
        } else {
            tvMessage.setText(R.string.message_client_order);
            tvMessage.setVisibility(View.VISIBLE);
            llInfo.setVisibility(View.GONE);
        }
    }

    private void bindUI() {
        tvMessage = (TextView) findViewById(R.id.tv_message_client);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvBusinessName = (TextView) findViewById(R.id.tv_business_name);
        tvRuc = (TextView) findViewById(R.id.tv_ruc);
        tvType = (TextView) findViewById(R.id.tv_type);
        TextView tvTitle = (TextView) findViewById(R.id.tv_title_type); ;
        tvTitle.setVisibility(View.GONE);
        tvType.setVisibility(View.GONE);
        spType = (Spinner) findViewById(R.id.sp_type);
        llInfo = (LinearLayout) findViewById(R.id.ll_info_client);
        llSearch = (LinearLayout) findViewById(R.id.ll_search);
        llSearch.setOnClickListener(this);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);




        llAccountClient = (LinearLayout) findViewById(R.id.ll_accounts_client);
        lvAccounts = (ListView) findViewById(R.id.lv_accounts);
        spLocalidades = (Spinner) findViewById(R.id.sp_localidades);
        TextView tvRazonS = (TextView) findViewById(R.id.tv_rs); ;
        tvRazonS.setVisibility(View.GONE);
        TextView tvRazonSv = (TextView) findViewById(R.id.tv_business_name); ;
        tvRazonSv.setVisibility(View.GONE);
        if (OrderProductsActivity.isEdit && !OrderProductsActivity.isOff) {
            spType.setEnabled(false);
            lvAccounts.setEnabled(false);
        }

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int id = bundle.getInt("id", 0);
            getClient(id);
            accountId = bundle.getInt("accountId", -1);
        }

        String typeAllowed = "";
        String typeOrder = App.getValueOfPreferencesUser(App.KEY_TYPE_ORDER,"");
        if ((typeOrder == null || typeOrder.isEmpty()) && "S".equals( App.getValueOfPreferencesUser(App.KEY_TYPE_ORDER_TYPE_PAYMENT,"")) && client!=null) {
            typeAllowed = client.getPaymentType();
        } else {
            typeAllowed = typeOrder;
        }

        if ("CRE".equals(typeAllowed)) {
            spType.setEnabled(false);
            spinnerArrayTypes = new OrderType[1];
            spinnerArrayTypes[0] = new OrderType("CREDITO","CRE");
        } else if ("CON".equals(typeAllowed)) {
            spType.setEnabled(false);
            spinnerArrayTypes = new OrderType[1];
            spinnerArrayTypes[0] = new OrderType("CONTADO","CON");
        } else {
                   spType.setEnabled(true);
        spinnerArrayTypes = new OrderType[2];
        spinnerArrayTypes[0] = new OrderType("CREDITO","CRE");
        spinnerArrayTypes[1] = new OrderType("CONTADO","CON");
    }

        original = OrderProductsActivity.type;

        ArrayAdapter adapterType = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayTypes);
        adapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spType.setAdapter(adapterType);

        if (OrderProductsActivity.type != null && !OrderProductsActivity.type.isEmpty()) {
            int position = 0;
            for(int i=0; i < spinnerArrayTypes.length; i++){
                if (OrderProductsActivity.type.equals(spinnerArrayTypes[i].getValue())){
                    position = i;
                    break;
                }
            }
            spType.setSelection(position);
        }

        lvAccounts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                adapter.allDisable();

                adapter.enableAccount(position);

                account = adapter.getAccount(position);

                showToastL("account tipo: " + account.getNameSale() + "  account cupo: " + account.getQuota());

                PermiteEditarEdias = account.getPermiteModificarDiasPedido();
                Dias = account.getDiasPlazo();
                Log.e("PERMITE DIAS"," PERMITE DIAS " +PermiteEditarEdias);
                Log.e("LOS DIAS","QUE TIENE DE PLAZO " +Dias);

               /* if (UtilDB.existOrderClientAccount(realm, client.getId(), account.getId(), codigoLocalidad)){
                    disableButton();
                    showToastL("Ya existe una orden creada con este cliente y esta cuenta");
                } else {*/
                    if (isClientValid) {
                        enableButton();
                    }
               // }
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void getClient(int id) {
        this.client = realm.where(Client.class).equalTo("id", id).findFirst();
    }

    private void setValues() {
        tvName.setText(client.getName());
        tvBusinessName.setText(client.getBusinessName());
        tvRuc.setText(client.getIdentification());

        iniciarLocalidades();

        if (account != null){
            accountId = account.getId();
        }

        callAccounts();

        isClientValid = !(client.getRate() == null || client.getRate().isEmpty());
        if (isClientValid) {
            client.setVersion(client.getRate().get(0).getVersion());

        } else {
            showDialog("El cliente " + client.getIdentification() + ", no tiene tarifario asignado");
        }

    }

    private void iniciarLocalidades(){
        Location[] spinnerArrayLocations;

        if (client.getLocations() != null && !client.getLocations().isEmpty()) {
            spinnerArrayLocations = new Location[client.getLocations().size()+1];
            spinnerArrayLocations[0] = new Location(0, " - Selecciona - ");
            for (int i = 1; i <= client.getLocations().size(); i++) {
                spinnerArrayLocations[i] = client.getLocations().get(i-1);
            }
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArrayLocations);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spLocalidades.setAdapter(adapter);
            spLocalidades.setVisibility(View.VISIBLE);

            if (codigoLocalidad > -1) {
                int position = -1;
                for (int i = 0; i < spinnerArrayLocations.length; i++) {
                    if (codigoLocalidad.equals(spinnerArrayLocations[i].getId())) {
                        position = i;
                    }
                }
                if (position > -1) {
                    spLocalidades.setSelection(position);
                }
            } else {
                if (client.getLocations().size()<2) {
                    spLocalidades.setSelection(1);
                }
            }
        } else {
            showToastL("Este Cliente no tiene localidades asignadas, contacte con el administrador");
        }
    }

    private int getVersionClient(){
        OrderType orderType = (OrderType) spType.getSelectedItem();
        OrderProductsActivity.type = orderType.getValue();
        if (client.getRate().size() == 1){
            return client.getRate().get(0).getVersion();
        }
        for (Rate rate : client.getRate()) {
            if ("CRE".equals(OrderProductsActivity.type) && "S".equals(rate.getEsCredito())) {
                return rate.getVersion();
            } else if ("CON".equals(OrderProductsActivity.type) && "S".equals(rate.getEsContado())) {
                return rate.getVersion();
            }
        }

        return client.getRate().get(0).getVersion();
    }

    private void goToSearch() {
        Intent intent = new Intent(this, SearchClientActivity.class);
        intent.putExtra("order", true);
        startActivity(intent);
    }



    private void goToOrderProducts() {
        Log.e("TIPO","PEDIDO ESCOGIDO--> "+client.getVersion());

        System.out.println(" INFORMACION --->  " +OrderClientActivity.account.getPermiteModificarDiasPedido());
        Intent intent = new Intent(this, OrderProductsActivity.class);
        startActivity(intent);
    }

    private void visibleMessage() {
        llAccountClient.setVisibility(View.GONE);
    }

    private void visibleAccounts() {
        llAccountClient.setVisibility(View.VISIBLE);
    }

    private void disableButton() {
        btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDisable));
        btnNext.setEnabled(false);
    }

    private void enableButton() {
        if (isClientValid) {
            btnNext.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            btnNext.setEnabled(true);
        }
    }

    private void callAccounts() {

        if (client.getAccounts() != null) {
            adapter = new AccountClientAdapter(getApplicationContext(),
                    client.getAccounts(), R.layout.item_account_client);
            lvAccounts.setAdapter(adapter);
            adapter.allDisable();
            visibleAccounts();
            if (accountId > -1) {
                position = adapter.getPositionId(accountId);
            }
            if (position > -1) {
                adapter.enableAccount(position);
                account = adapter.getAccount(position);
                adapter.notifyDataSetChanged();
                lvAccounts.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        enableButton();
                    }
                }, 100);

            }
        } else {
            visibleMessage();
        }
    }

    private void showDialog(String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(OrderClientActivity.this).create();
        alertDialog.setTitle("Aviso");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_search:
                if (OrderProductsActivity.isEdit) {
                    showToastL("No es posible cambiar de cliente para una orden existente");
                } else {
                    goToSearch();
                }
                break;
            case R.id.btn_next:
                next();
                break;
            default:
                break;
        }
    }

    private void next() {
        try {
            if (client == null || ("" + client.getId()).isEmpty()) {
                showToastL("Selecciona un cliente para continuar con el pedido");
            } else if (account == null || account.getId() == null || account.getId() == 0) {
                showToastL("Selecciona una cuenta del cliente para continuar con el pedido");
            } else {
                if (client.getLocations() !=null && !client.getLocations().isEmpty()) {
                    Location l = (Location)spLocalidades.getSelectedItem();
                    if (l.getId() == 0 || l.getId().equals(0)) {
                        throw new Exception("Debes seleccionar la dirección de entrega del pedido");
                    }
                    if (l.getMaxOrdenes() == null) {
                        throw new Exception("El cliente no tiene asignado un límite de ordenes para esta localidad");
                    }

                    codigoLocalidad = l.getId();
                    if (!OrderProductsActivity.isEdit && !OrderProductsActivity.isOff) {
                        if (UtilDB.existOrderClientAccount(realm, client.getId(), account.getId(), codigoLocalidad) >= l.getMaxOrdenes()){
                            throw new Exception("Ha superado el límite máximo asignado a este cliente para realizar pedidos");
                        }
                    }
                }
                client.setVersion(getVersionClient());
                if (!OrderProductsActivity.type.equals(""+original)) {
                    OrderProductsActivity.initialize();
                }

                goToOrderProducts();
            }
        } catch (Exception e) {
            showToastL(e.getMessage());
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // todo: goto back activity from here

                Intent intent = new Intent(this, OrdersActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                //navigateUp();
                //finish();
                overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, OrdersActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        overridePendingTransition(R.animator.left_to_right, R.animator.right_to_left);
    }

    private void showToastL(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
