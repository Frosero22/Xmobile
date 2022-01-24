package com.mobile.polux.activities.recaudaciones;

import android.content.Intent;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.mobile.polux.R;
import com.mobile.polux.activities.recaudaciones.InvoiceActivity;
import com.mobile.polux.adapters.InvoiceAdapter;
import com.mobile.polux.models.Invoice;

import java.util.ArrayList;
import java.util.List;

public class SearchInvoiceActivity extends AppCompatActivity {

    private List<Invoice> invoices;

    private ListView lvInvoices;

    private SearchView searchView;

    private InvoiceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_invoice);

        getSupportActionBar().setTitle("Buscar Factura");

        bindUI();
    }

    private void bindUI() {
        if (invoices == null) {
            invoices = new ArrayList<>();
            /*invoices.add(new Invoice("001-0848", 150.57, 150.57, "PEN", "23/11/2018"));
            invoices.add(new Invoice("001-0741", 130.57, 77.20, "PAR", "24/11/2018"));
            invoices.add(new Invoice("001-1154", 90.57, 90.57, "PEN", "28/11/2018"));*/
        }
        lvInvoices = (ListView) findViewById(R.id.lv_invoices);

        adapter = new InvoiceAdapter(this, R.layout.item_invoice, invoices);
        lvInvoices.setAdapter(adapter);

        lvInvoices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), InvoiceActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                InvoiceActivity.invoice = invoices.get(position);
                startActivity(intent);
            }
        });
    }

    private SupportMenuItem item;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        item = (SupportMenuItem) menu.findItem(R.id.search);
        searchView = (SearchView) item.getActionView();
        //searchView.setOnQueryTextListener(this);

        /*MenuItemCompat.setOnActionExpandListener(item, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                return true;
            }
        });*/

        item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
