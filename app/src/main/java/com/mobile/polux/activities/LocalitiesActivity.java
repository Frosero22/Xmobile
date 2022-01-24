package com.mobile.polux.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.adapters.LocationAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.LocalitiesResponse;
import com.mobile.polux.models.Location;
import com.mobile.polux.utils.Util;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocalitiesActivity extends AppCompatActivity {


    private ListView lvLocalities;

    private LocationAdapter adapter;

    private TextView tvMessage;

    private View mProgressView;
    private Util util;
    private int shortAnimTime;

    private int clientId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        getSupportActionBar().setTitle("Localidades");

        mProgressView = findViewById(R.id.progress);
        if (util == null) {
            util = new Util();
        }
        shortAnimTime = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);
        }

        bindUI();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            clientId = bundle.getInt("clientId", 0);
            callLocalities(clientId);
        }

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (clientId != 0) {
            callLocalities(clientId);
        }
    }

    private void bindUI() {
        lvLocalities = (ListView) findViewById(R.id.lv_values);
        ListView lv = (ListView) findViewById(R.id.lv_filters);
        lv.setVisibility(View.GONE);
        tvMessage = (TextView) findViewById(R.id.message);
        visibleMessage();
        lvLocalities.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Location location = adapter.getLocation(position);

                Intent intent = new Intent(getApplicationContext(), LocationActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.putExtra("clientId", clientId);
                intent.putExtra("locationId", location.getId());
                intent.putExtra("name", location.getName());
                intent.putExtra("address", location.getAddress());
                intent.putExtra("addressDelivery", location.getDireccionEntregaMercaderia());
                intent.putExtra("latitude", location.getLatitude());
                intent.putExtra("longitude", location.getLongitude());
                intent.putExtra("img", location.getImg());
                if (location.getContacts() != null && !location.getContacts().isEmpty()) {
                    intent.putExtra("phone", location.getContacts().get(0).getTelefono1());
                }
                startActivity(intent);
            }
        });

    }

    private void visibleResults() {
        lvLocalities.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.GONE);
    }

    private void visibleMessage() {
        lvLocalities.setVisibility(View.GONE);
        tvMessage.setText("No se encontraron localidades");
        tvMessage.setVisibility(View.VISIBLE);
    }

    private void callLocalities(int clientId) {

        Call<LocalitiesResponse> response = App.services.localities(clientId, App.companyCode);

        util.showProgress(true, mProgressView, shortAnimTime);

        response.enqueue(new Callback<LocalitiesResponse>() {
            @Override
            public void onResponse(Call<LocalitiesResponse> call, Response<LocalitiesResponse> response) {

                if (response.body() != null) {

                    String message = response.body().getMessage();

                    if ("OK".equals(message) && response.body().getLocalities() != null) {
                        adapter = new LocationAdapter(getApplicationContext(), response.body().getLocalities());
                        lvLocalities.setAdapter(adapter);
                        visibleResults();
                    } else {
                        visibleMessage();
                    }
                }
                util.showProgress(false, mProgressView, shortAnimTime);
            }

            @Override
            public void onFailure(Call<LocalitiesResponse> call, Throwable t) {
                util.showProgress(false, mProgressView, shortAnimTime);
                //Log.e("Locali", "failure " + t);
                visibleMessage();
                //showToastL("Ocurrió un error, por favor verifique su acceso a internet");
            }
        });
    }
}
