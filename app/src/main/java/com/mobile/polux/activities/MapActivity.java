package com.mobile.polux.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mobile.polux.R;
import com.mobile.polux.models.GeoLocation;

import java.util.List;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private boolean showAll;
    private double latitude;
    private double longitude;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            showAll = bundle.getBoolean("showAll", false);
            latitude = bundle.getDouble("latitude", 0);
            longitude = bundle.getDouble("longitude", 0);
            name = bundle.getString("name", "");
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (showAll) {
            paint(GeolocationDayActivity.geoLocalities);
        } else {
            LatLng latLng = new LatLng(latitude, longitude);
            mMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(name)
            );
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
        }

    }

    private void paint(List<GeoLocation> geoLocalities) {
        int i = 0;
        for (GeoLocation location : geoLocalities) {
            if (location.getLatitude() != null && location.getLongitude() != null) {

                LatLng latLng = new LatLng(Double.parseDouble(location.getLatitude()), Double.parseDouble(location.getLongitude()));
                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title(location.getClientName())
                        .snippet(location.getZone())
                );
                if (i == 0) {
                    i++;
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                }

            }
        }
    }

}