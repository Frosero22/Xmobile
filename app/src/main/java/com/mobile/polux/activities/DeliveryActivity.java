package com.mobile.polux.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.mobile.polux.R;
import com.mobile.polux.adapters.DeliveryAdapter;
import com.mobile.polux.adapters.VisitAdapter;
import com.mobile.polux.models.Delivery;

import java.util.List;

import io.realm.Realm;

public class DeliveryActivity extends AppCompatActivity {

    private List<Delivery> deliveryList;
    private ListView lvDelivery;
    private DeliveryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        getSupportActionBar().setTitle("Guía de Despacho");

        bindUI();
    }

    private void bindUI() {
        //tvMessage = (TextView) findViewById(R.id.message);
        lvDelivery = (ListView) findViewById(R.id.lv_delivery);
        adapter = new DeliveryAdapter(DeliveryActivity.this, R.layout.item_delivery, deliveryList);
        lvDelivery.setAdapter(adapter);

        //registerForContextMenu(lvDelivery);

        /*
        lvDelivery.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return true;
            }
        });*/
    }
}
