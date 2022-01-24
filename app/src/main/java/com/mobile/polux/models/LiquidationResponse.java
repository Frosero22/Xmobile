package com.mobile.polux.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by laptoplenovo on 16/1/2019.
 */

public class LiquidationResponse {

    @Expose
    private String result;
    @Expose
    private String mensaje;
    @Expose
    private String causa;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }
}
