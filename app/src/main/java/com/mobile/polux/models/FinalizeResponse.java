package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laptoplenovo on 30/5/2018.
 */

public class FinalizeResponse {

    @SerializedName("dafEmpresasMovil")
    private DafEmpresasMovil dafEmpresasMovil;
    @SerializedName("mensaje")
    private String message;

    public FinalizeResponse() {
    }

    public DafEmpresasMovil getDafEmpresasMovil() {
        return dafEmpresasMovil;
    }

    public void setDafEmpresasMovil(DafEmpresasMovil dafEmpresasMovil) {
        this.dafEmpresasMovil = dafEmpresasMovil;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

