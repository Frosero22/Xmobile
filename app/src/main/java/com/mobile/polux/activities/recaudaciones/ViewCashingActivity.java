package com.mobile.polux.activities.recaudaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mobile.polux.R;
import com.mobile.polux.activities.recaudaciones.CashingActivity;
import com.mobile.polux.activities.recaudaciones.GuideActivity;
import com.mobile.polux.adapters.InvoiceAdapter;
import com.mobile.polux.app.App;
import com.mobile.polux.fragments.FullScreenDialog;
import com.mobile.polux.models.CashingGuideDetail;
import com.mobile.polux.models.Invoice;
import com.mobile.polux.utils.UtilDB;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;


/**
 * Created by laptoplenovo on 28/11/2018.
 */

public class ViewCashingActivity extends AppCompatActivity {

    private TextView tvClient;
    private TextView tvTotal;
    private TextView tvSelect;
    private TextView tvCredit;
    private ListView lvInvoices;

    private InvoiceAdapter adapter;
    private List<Invoice> invoices;

    private CashingGuideDetail cashingGuideDetail;

    public double credit;


    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashing_register);

        getSupportActionBar().setTitle("Facturas pendientes");

        try {
            if (realm == null || realm.isClosed()) {
                realm = Realm.getDefaultInstance();
            }

            if (cashingGuideDetail == null) {
                findCashingGuide();
            }

            bindUI();
        } catch (Exception e) {
        }
    }

    private void findCashingGuide() {
        try {
            cashingGuideDetail = UtilDB.guideById(realm, GuideActivity.guide).getDetails().where().equalTo("clientId", GuideActivity.guideClientId).findFirst();
            cashingGuideDetail = cashingGuideDetail.toUnManaged(realm);
            credit = cashingGuideDetail.getCredit();
        } catch (Exception e) {
        }
    }

    private void bindUI() {
        tvClient = (TextView) findViewById(R.id.tv_client);
        tvTotal = (TextView) findViewById(R.id.tv_total);
        //tvCancel = (TextView) findViewById(R.id.tv_cancel);
        //tvBalance = (TextView) findViewById(R.id.tv_balance);
        tvCredit = (TextView) findViewById(R.id.tv_credit);
        tvCredit.setText("$ " + App.DECIMAL_FORMAT.format(credit));
        tvSelect = (TextView) findViewById(R.id.tv_select);
        lvInvoices = (ListView) findViewById(R.id.lv_invoices);

        tvSelect.setVisibility(View.GONE);
        TextView tvInv = (TextView) findViewById(R.id.tv_title_invoice);
        tvInv.setText("Facturas pendientes");
        Button btn = (Button) findViewById(R.id.btn_next);
        btn.setVisibility(View.VISIBLE);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNext();
            }
        });

        tvClient.setText(cashingGuideDetail.getClientId() + " - " + cashingGuideDetail.getName());
        tvTotal.setText("$ "+ App.DECIMAL_FORMAT.format(cashingGuideDetail.getTotalDue()));

        if (invoices == null) {
            invoices = cashingGuideDetail.getDocXcobrar();
        }

        if (invoices == null) {
            invoices = new ArrayList<>();
        }

        adapter = new InvoiceAdapter(this, R.layout.item_invoice, invoices);
        lvInvoices.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        registerForContextMenu(lvInvoices);

    }



    /*private void goToCashing(){
        Intent intent = new Intent(this, CashingActivity.class);
        startActivity(intent);
    }*/

    private void goToNext() {
        Intent intent = new Intent(this, CashingActivity.class);
        startActivity(intent);
    }

    private void showProducts(Invoice invoice){
        FullScreenDialog dialog = new FullScreenDialog();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FullScreenDialog.ORDER = null;
        FullScreenDialog.products = invoice.getProducts();
        FullScreenDialog.numOrder = ""+invoice.getOrder();
        FullScreenDialog.iva = invoice.getIva();
        FullScreenDialog.discount = invoice.getDiscount();
        FullScreenDialog.subTotal = invoice.getSubTotal();
        FullScreenDialog.total = invoice.getTotal();
        dialog.show(ft, FullScreenDialog.TAG);
    }

    private void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_invoice, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {
            case R.id.item_view:
                showProducts(invoices.get(info.position).toUnManaged(realm));
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
