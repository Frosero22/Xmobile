package com.mobile.polux.activities.recaudaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.models.Invoice;

public class InvoiceActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llSearch;
    public static Invoice invoice;

    private LinearLayout llInfoClient;
    private LinearLayout llProducts;

    private TextView tvMessage;

    private TextView tvName;
    private TextView tvRuc;

    private TextView tvTotal;
    private TextView tvSubtotal;
    private TextView tvIva;
    private TextView tvDiscount;

    private Button btnPay;

    private ListView lvProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        getSupportActionBar().setTitle("Factura");

        bindUI();

        if (invoice == null) {
            visibleMessage();
        } else {
           visibleInvoice();
            setValues();
        }


    }

    private void bindUI() {
        llInfoClient = (LinearLayout) findViewById(R.id.ll_info_client);
        llProducts = (LinearLayout) findViewById(R.id.ll_products);

        tvMessage = (TextView) findViewById(R.id.message);
        tvMessage.setText("Busca una factura para ver su información");
        tvName = (TextView) findViewById(R.id.tv_name);
        tvRuc = (TextView) findViewById(R.id.tv_ruc);
        tvSubtotal = (TextView) findViewById(R.id.tv_subtotal);
        tvIva = (TextView) findViewById(R.id.tv_iva);
        tvDiscount = (TextView) findViewById(R.id.tv_discount);
        tvTotal = (TextView) findViewById(R.id.tv_total);

        llSearch = (LinearLayout) findViewById(R.id.ll_search);
        llSearch.setOnClickListener(this);

        btnPay = (Button) findViewById(R.id.btn_pay);
        btnPay.setOnClickListener(this);
        // btnNext = (Button) findViewById(R.id.btn_next);
        // btnNext.setOnClickListener(this);
    }

    private void setValues(){
        tvName.setText("KEVIN SALVATIERRA ESPINOZA");
        tvRuc.setText("09505848457");
        tvDiscount.setText("$ 0.00");
        tvIva.setText("$ 0.00");
        tvSubtotal.setText("$ "+invoice.getTotal());
        tvTotal.setText("$ "+invoice.getTotal());
    }

    private void visibleMessage() {
        tvMessage.setVisibility(View.VISIBLE);
        llInfoClient.setVisibility(View.GONE);
        llProducts.setVisibility(View.GONE);
    }

    private void visibleInvoice() {
        llInfoClient.setVisibility(View.VISIBLE);
        llProducts.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.GONE);
    }

    private void goToSearch() {
        Intent intent = new Intent(this, SearchInvoiceActivity.class);
        startActivity(intent);
    }

    private void goToCashings() {
        Intent intent = new Intent(this, GuideActivity.class);
        intent.putExtra("isPay", true);
        startActivity(intent);
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_search:
                goToSearch();
                break;
            case R.id.btn_pay:
                goToCashings();
                break;
            default:
                break;
        }
    }
}
