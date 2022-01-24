package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laptoplenovo on 30/5/2018.
 */

public class LoginResponse {

    @SerializedName("dafFotos")
    private DafFotos dafFotos;
    @SerializedName("mensaje")
    private String message;
    @SerializedName("dafUsuariosSistema")
    private DafUsuariosSistema dafUsuariosSistema;

    public LoginResponse() {
    }

    public DafFotos getDafFotos() {
        return dafFotos;
    }

    public void setDafFotos(DafFotos dafFotos) {
        this.dafFotos = dafFotos;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DafUsuariosSistema getDafUsuariosSistema() {
        return dafUsuariosSistema;
    }

    public void setDafUsuariosSistema(DafUsuariosSistema dafUsuariosSistema) {
        this.dafUsuariosSistema = dafUsuariosSistema;
    }
}
