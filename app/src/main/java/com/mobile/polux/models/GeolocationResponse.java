package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 17/7/2018.
 */

public class GeolocationResponse {

    @SerializedName("mensaje")
    private String message;
    @SerializedName("lsDiasVisitas")
    private List<GeoLocation> geolocalities;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GeoLocation> getGeolocalities() {
        return geolocalities;
    }

    public void setGeolocalities(List<GeoLocation> geolocalities) {
        this.geolocalities = geolocalities;
    }
}
