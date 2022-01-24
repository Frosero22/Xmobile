package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 9/6/2018.
 */

public class LocalitiesResponse {

    @SerializedName("lsLocalidadesXClientes")
    private List<Location> localities;
    @SerializedName("mensaje")
    private String message;

    public LocalitiesResponse() {
    }

    public List<Location> getLocalities() {
        return localities;
    }

    public void setLocalities(List<Location> localities) {
        this.localities = localities;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
