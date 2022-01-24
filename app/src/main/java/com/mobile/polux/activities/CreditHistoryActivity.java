package com.mobile.polux.activities;

import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.adapters.LocationAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.models.Credit;
import com.mobile.polux.models.CreditHistoryResponse;
import com.mobile.polux.models.LocalitiesResponse;
import com.mobile.polux.utils.Util;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreditHistoryActivity extends AppCompatActivity {

    private ScrollView scrollView;
    private View mProgressView;
    private TextView tvMessage;

    private TextView tvQualification;
    private TextView tvTotalF;
    private TextView tvTotalC;
    private TextView tvTotalD;
    private TextView tvDue;
    private TextView tvValueF;
    private TextView tvValueP;
    private TextView tvValueC;
    private TextView tvDuePv;
    private TextView tvDueV;

    private Util util;
    private int shortAnimTime;

    DecimalFormat df = new DecimalFormat("####,###,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_history);

        getSupportActionBar().setTitle("Historial Crediticio");

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
            callCreditHistory(id);
        }

    }

    private void bindUI() {
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        tvMessage = (TextView) findViewById(R.id.message);
        tvMessage.setText("No se encontró historial crediticio para este cliente");

        tvQualification = (TextView) findViewById(R.id.tv_qualification);
        tvTotalF = (TextView) findViewById(R.id.tv_total_f);
        tvTotalC = (TextView) findViewById(R.id.tv_total_c);
        tvTotalD = (TextView) findViewById(R.id.tv_total_d);
        tvDue = (TextView) findViewById(R.id.tv_due);
        tvValueF = (TextView) findViewById(R.id.tv_value_f);
        tvValueC = (TextView) findViewById(R.id.tv_value_c);
        tvValueP = (TextView) findViewById(R.id.tv_value_p);
        tvDuePv = (TextView) findViewById(R.id.tv_due_pv);
        tvDueV = (TextView) findViewById(R.id.tv_due_v);
    }

    private void visibleMessage() {
        scrollView.setVisibility(View.GONE);
        tvMessage.setVisibility(View.VISIBLE);
    }

    private void visibleResults() {
        scrollView.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.GONE);
    }

    private void setValues(Credit credit){
        tvQualification.setText(credit.getDescripcionCalificacion());
        tvTotalF.setText("$ "+df.format(credit.getTotalFacturas()));
        tvTotalC.setText("$ "+df.format(credit.getTotalNotasCredito()));
        tvTotalD.setText("$ "+df.format(credit.getTotalNotasDebito()));
        tvDue.setText("$ "+df.format(credit.getValorTotalDeuda()));
        tvValueF.setText("$ "+df.format(credit.getTotalFacturado()));
        tvValueC.setText("$ "+df.format(credit.getValorCredito()));
        tvValueP.setText("$ "+df.format(credit.getValorPagado()));
        tvDuePv.setText("$ "+df.format(credit.getValorDeudaPorVencer()));
        tvDueV.setText("$ "+df.format(credit.getValorDeudaVencida()));
    }

    private void callCreditHistory(int clientId) {

        Call<CreditHistoryResponse> response = App.services.creditHistory(App.companyCode,clientId);

        util.showProgress(true, mProgressView, shortAnimTime);

        response.enqueue(new Callback<CreditHistoryResponse>() {
            @Override
            public void onResponse(Call<CreditHistoryResponse> call, Response<CreditHistoryResponse> response) {

                if (response.body() != null) {

                    String message = response.body().getMessage();

                    if ("OK".equals(message) && response.body().getCreditHistory() != null  && !response.body().getCreditHistory().isEmpty()) {
                        //adapter = new LocationAdapter(getApplicationContext(), response.body().getLocalities());
                        //lvLocalities.setAdapter(adapter);
                        setValues(response.body().getCreditHistory().get(0));
                        visibleResults();
                    } else {
                        visibleMessage();
                    }
                }
                util.showProgress(false, mProgressView, shortAnimTime);
            }

            @Override
            public void onFailure(Call<CreditHistoryResponse> call, Throwable t) {
                util.showProgress(false, mProgressView, shortAnimTime);
                //Log.e("Locali", "failure " + t);
                visibleMessage();
                //showToastL("Ocurrió un error, por favor verifique su acceso a internet");
            }
        });
    }
}
