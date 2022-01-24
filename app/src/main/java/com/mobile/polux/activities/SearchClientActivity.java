package com.mobile.polux.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.adapters.ClientAdapter;
import com.mobile.polux.adapters.FilterAdapter;
import com.mobile.polux.models.Account;
import com.mobile.polux.models.Client;
import com.mobile.polux.models.Filter;

import java.util.ArrayList;
import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.Sort;

public class SearchClientActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<Client> clients;

    private ListView lvClients;
    private ListView lvFilters;

    private ClientAdapter adapter;
    private FilterAdapter filterAdapter;

    private Realm realm;
    private List<String> filters;

    private SearchView searchView;
    private TextView tvMessage;


    private boolean isOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_client);

        getSupportActionBar().setTitle("Cliente");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        if (realm == null || realm.isClosed()) {
            realm = Realm.getDefaultInstance();
        }

        tvMessage = (TextView) findViewById(R.id.message);

        bindUI();

        if (filters == null) {
            allFilters();
        }

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            isOrder = bundle.getBoolean("order");
        }

    }



    private void bindUI() {
        lvClients = (ListView) findViewById(R.id.lv_clients);
        lvFilters = (ListView) findViewById(R.id.lv_filters);
        visibleFilters();

        lvClients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = null;
                if (isOrder) {
                    intent = new Intent(getApplicationContext(), OrderClientActivity.class);
                    OrderProductsActivity.initialize();
                    OrderProductsActivity.isEdit = false;

                } else {
                    intent = new Intent(getApplicationContext(), ClientActivity.class);
                }

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Client client = adapter.getClient(position);

                intent.putExtra("id", client.getId());
                startActivity(intent);
            }
        });

        lvFilters.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = (String) filterAdapter.getItem(position);

                MenuItemCompat.expandActionView(item);
                setFilter(text);
                searchView.setQuery(text, false);
                searchView.requestFocus();
                resultSearch(text);
            }
        });
    }

    private void allFilters() {
        filters = new ArrayList<>();
        List<Filter> filtersDb = realm.where(Filter.class).equalTo("type", "CL")
                .findAllSorted("date", Sort.DESCENDING);
        for (Filter f : filtersDb) {
            filters.add(f.getText());
        }
        filterAdapter = new FilterAdapter(this, R.layout.item_filter, filters);
        lvFilters.setAdapter(filterAdapter);
    }

    private void setFilter(String text) {
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(new Filter(text, "CL"));
            realm.commitTransaction();
        } catch (Exception e) {
        }
    }

    private void visibleResults() {
        lvClients.setVisibility(View.VISIBLE);
        lvFilters.setVisibility(View.GONE);
        tvMessage.setVisibility(View.GONE);
    }

    private void visibleFilters() {
        lvClients.setVisibility(View.GONE);
        lvFilters.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.GONE);
    }

    private void visibleMessage() {
        lvClients.setVisibility(View.GONE);
        lvFilters.setVisibility(View.GONE);
        tvMessage.setVisibility(View.VISIBLE);
    }

    private void resultSearch(String text) {
        callClientsDB(text);
    }

    private void callClientsDB(String text) {
        boolean isNumber;
        int number = 0;
        try {
            number = new Integer(text);
            isNumber = true;
        } catch (Exception e) {
            isNumber = false;
        }
        if (isNumber) {
            clients = realm.where(Client.class).contains("name", text.toUpperCase(), Case.INSENSITIVE)
                    .or().contains("identification", text.toUpperCase(), Case.INSENSITIVE)
                    .or().contains("businessName", text.toUpperCase(), Case.INSENSITIVE)
                    .or().equalTo("id", number)
                    .findAll();
        } else {
            clients = realm.where(Client.class).contains("name", text.toUpperCase(), Case.INSENSITIVE)
                    .or().contains("identification", text.toUpperCase(), Case.INSENSITIVE)
                    .or().contains("businessName", text.toUpperCase(), Case.INSENSITIVE)
                    .findAll();
        }

        if (clients == null || clients.isEmpty()) {
            visibleMessage();
        } else {
            adapter = null;
            adapter = new ClientAdapter(this, R.layout.item_client, clients);
            lvClients.setAdapter(adapter);
            visibleResults();
        }
    }

    private List<String> filter(String newText) {
        List<String> filtered = new ArrayList<>();
        for (String filter : filters) {
            if (filter.contains(newText.toLowerCase())) {
                filtered.add(filter);
            }
        }
        return filtered;
    }

    private SupportMenuItem item;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        item = (SupportMenuItem) menu.findItem(R.id.search);
        searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(this);

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

        }else if(isOrder){
           Intent intent = new Intent(this, OrderClientActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
           startActivity(intent);
           finish();

        }else{

            Intent intent = new Intent(this, ClientActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchView.setQuery(query, false);
        setFilter(query.trim());

        resultSearch(query.trim());

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        try {
            visibleFilters();
            filterAdapter.clear();
            filterAdapter.addAll(filter(newText));
            filterAdapter.notifyDataSetChanged();

        } catch (Exception e) {
        }
        return false;
    }


}
