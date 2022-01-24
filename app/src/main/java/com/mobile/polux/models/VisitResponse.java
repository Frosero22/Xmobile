package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 14/6/2018.
 */

public class VisitResponse {

    @SerializedName("secuenciaVisitasEfectivas")
    private int secuenciaVisita;
    @SerializedName("mensaje")
    private String message;
    @SerializedName("mensaje ok")
    private String messageOk;
    @SerializedName("causa")
    private String causa;


    public int getSecuenciaVisita() {
        return secuenciaVisita;
    }

    public void setSecuenciaVisita(int secuenciaVisita) {
        this.secuenciaVisita = secuenciaVisita;
    }

    public String getMessageOk() {
        return messageOk;
    }

    public void setMessageOk(String messageOk) {
        this.messageOk = messageOk;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
