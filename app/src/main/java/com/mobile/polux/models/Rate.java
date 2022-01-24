package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by laptoplenovo on 11/7/2018.
 */

public class Rate extends RealmObject {

    // numeroVersion
    @SerializedName("numeroVersion")
    private int version;
    @SerializedName("esContado")
    private String esContado;
    @SerializedName("esCredito")
    private String esCredito;

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getEsContado() {
        return esContado;
    }

    public void setEsContado(String esContado) {
        this.esContado = esContado;
    }

    public String getEsCredito() {
        return esCredito;
    }

    public void setEsCredito(String esCredito) {
        this.esCredito = esCredito;
    }
}
