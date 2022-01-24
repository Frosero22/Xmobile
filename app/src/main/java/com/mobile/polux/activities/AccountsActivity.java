package com.mobile.polux.activities;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.adapters.AccountAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.AccountsResponse;
import com.mobile.polux.models.CreditHistoryResponse;
import com.mobile.polux.utils.Util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountsActivity extends AppCompatActivity {

    private View mProgressView;
    private TextView tvMessage;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

    private Util util;
    private int shortAnimTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts);

        getSupportActionBar().setTitle("Cuentas");

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
            int id = bundle.getInt("clientId", 0);
            //callAccounts(id);
            callAccounts();
        }
    }

    private void bindUI(){
        tvMessage = (TextView) findViewById(R.id.message);
        tvMessage.setText("No se encontraron cuentas para el cliente");
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mProgressView = findViewById(R.id.progress);
    }

    private void visibleMessage() {
        recyclerView.setVisibility(View.GONE);
        tvMessage.setVisibility(View.VISIBLE);
    }

    private void visibleResults() {
        recyclerView.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.GONE);
    }

    private void callAccounts(){
        if (ClientActivity.client.getAccounts() != null ) {
            mAdapter = new AccountAdapter(ClientActivity.client.getAccounts(), R.layout.item_account);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(mAdapter);
            visibleResults();
        } else {
            visibleMessage();
        }
    }

    //ClientActivity
    private void callAccounts(int clientId){

        Call<AccountsResponse> response = App.services.accounts(App.companyCode,clientId);

        util.showProgress(true, mProgressView, shortAnimTime);

        response.enqueue(new Callback<AccountsResponse>() {
            @Override
            public void onResponse(Call<AccountsResponse> call, Response<AccountsResponse> response) {

                if (response.body() != null) {

                    String message = response.body().getMessage();

                    if ("OK".equals(message) && response.body().getAccounts() != null ) {
                        mAdapter = new AccountAdapter(response.body().getAccounts(), R.layout.item_account);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setAdapter(mAdapter);
                        visibleResults();
                    } else {
                        visibleMessage();
                    }
                }
                util.showProgress(false, mProgressView, shortAnimTime);
            }

            @Override
            public void onFailure(Call<AccountsResponse> call, Throwable t) {
                util.showProgress(false, mProgressView, shortAnimTime);
                Log.e("Locali", "failure " + t);
                visibleMessage();
                //showToastL("Ocurrió un error, por favor verifique su acceso a internet");
            }
        });
    }
}
