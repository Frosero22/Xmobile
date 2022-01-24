package com.mobile.polux.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.polux.R;
import com.mobile.polux.app.App;
import com.mobile.polux.models.Account;
import com.mobile.polux.models.Client;

import io.realm.Realm;

import static io.realm.log.RealmLog.clear;

/**
 * Created by laptoplenovo on 5/6/2018.
 */

public class ClientActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llSearch;
    private LinearLayout llInfo;
    private LinearLayout llOptions;
    private LinearLayout llLocalities;
    private LinearLayout llCreditHistory;
    private LinearLayout llAccounts;
    private LinearLayout llPhone;

    public static Client client;
    public static Account account;

    private TextView tvName;
    private TextView tvBusinessName;
    private TextView tvRuc;
    private TextView tvType;
    private TextView tvPhone;
    private TextView tvMessage;

    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_client);

        getSupportActionBar().setTitle("Cliente");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }

        bindUI();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int id = bundle.getInt("id", 0);
            getClient(new Integer("" + id));
        }

        if (client != null) {
            setValues();
            llInfo.setVisibility(View.VISIBLE);
            llOptions.setVisibility(View.VISIBLE);
            tvMessage.setVisibility(View.GONE);
        } else {
            tvMessage.setText(R.string.message_client);
            tvMessage.setVisibility(View.VISIBLE);
            llOptions.setVisibility(View.GONE);
            llInfo.setVisibility(View.GONE);
        }

    }



    private void bindUI() {
        tvMessage = (TextView) findViewById(R.id.tv_message_client);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvBusinessName = (TextView) findViewById(R.id.tv_business_name);
        tvRuc = (TextView) findViewById(R.id.tv_ruc);
        tvType = (TextView) findViewById(R.id.tv_type);
        tvPhone = (TextView) findViewById(R.id.tv_phone);
        llSearch = (LinearLayout) findViewById(R.id.ll_search);
        llSearch.setOnClickListener(this);
        llPhone = (LinearLayout) findViewById(R.id.ll_phone);
        llInfo = (LinearLayout) findViewById(R.id.ll_info_client);
        llOptions = (LinearLayout) findViewById(R.id.ll_options);
        llLocalities = (LinearLayout) findViewById(R.id.ll_localities);
        llLocalities.setOnClickListener(this);
        llCreditHistory= (LinearLayout) findViewById(R.id.ll_credit_history);
        llCreditHistory.setOnClickListener(this);
        llAccounts = (LinearLayout) findViewById(R.id.ll_accounts);
        llAccounts.setOnClickListener(this);
        llPhone.setVisibility(View.VISIBLE);

        LinearLayout content = (LinearLayout) findViewById(R.id.ll_content_sp);
        content.setVisibility(View.GONE);
        View contentSpLoc = findViewById(R.id.content_sp_localidad);
        contentSpLoc.setVisibility(View.GONE);

        Button btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setVisibility(View.GONE);
    }

    private void getClient(int id) {
        this.client = realm.where(Client.class).equalTo("id", id).findFirst();
    }
    private void getCuenta(String permiteModificarDiasPedido){
        this.account = realm.where(Account.class).equalTo("permiteModificarDiasPedido",permiteModificarDiasPedido).findFirst();

    }

    private void setValues() {
        tvName.setText(client.getName());
        tvBusinessName.setText(client.getBusinessName());
        tvRuc.setText(client.getIdentification());
        tvType.setText(client.getTypeName());
        tvPhone.setText(client.getPhone());

    }

    private void goToSearch() {
        Intent intent = new Intent(this, SearchClientActivity.class);
        intent.putExtra("order", false);
        startActivity(intent);
        finish();
    }

    private void goToLocalities() {
        Intent intent = new Intent(this, LocalitiesActivity.class);
        intent.putExtra("clientId", client.getId());
        startActivity(intent);
    }

    private void goToCreditHistory() {
        Intent intent = new Intent(this, CreditHistoryActivity.class);
        intent.putExtra("clientId", client.getId());
        startActivity(intent);
    }

    private void goToAccounts() {
        Intent intent = new Intent(this, AccountsActivity.class);
        intent.putExtra("clientId", client.getId());
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_search:
                goToSearch();
                break;
            case R.id.ll_localities:
                goToLocalities();
                break;
            case R.id.ll_credit_history:
                goToCreditHistory();
                break;
            case R.id.ll_accounts:
                goToAccounts();
                break;
            case R.id.ll_pay:
                showToast("En construcción");
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {
            return true;

        }else {

            reset();
        }
                return super.onOptionsItemSelected(item);
        }


    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    private void comeBackMain(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        client = null;
        finish();
       // Toast.makeText(this, "ACTIVIDAD CERRADA CORRECTAMENTE", Toast.LENGTH_SHORT).show();
    }

    private void reset() {
        try {
           comeBackMain();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("ERROR","ERRORRR -----> " +e);
        }
    }


    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }
}
