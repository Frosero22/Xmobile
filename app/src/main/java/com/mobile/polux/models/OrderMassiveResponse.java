package com.mobile.polux.models;

import com.google.gson.annotations.Expose;

import java.util.List;

public class OrderMassiveResponse {

    @Expose
    private String mensaje;
    @Expose
    private String userError;
    @Expose
    private String causa;
    @Expose
    private String errorSistemas;
    @Expose
    private List<Order> lstDafOrdenesAuxiliar;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getUserError() {
        return userError;
    }

    public void setUserError(String userError) {
        this.userError = userError;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getErrorSistemas() {
        return errorSistemas;
    }

    public void setErrorSistemas(String errorSistemas) {
        this.errorSistemas = errorSistemas;
    }

    public List<Order> getLstDafOrdenesAuxiliar() {
        return lstDafOrdenesAuxiliar;
    }

    public void setLstDafOrdenesAuxiliar(List<Order> lstDafOrdenesAuxiliar) {
        this.lstDafOrdenesAuxiliar = lstDafOrdenesAuxiliar;
    }
}
