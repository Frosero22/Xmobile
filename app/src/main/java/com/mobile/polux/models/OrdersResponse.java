package com.mobile.polux.models;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by laptoplenovo on 9/1/2019.
 */

public class OrdersResponse {

    @Expose
    private List<Order> Ordenes;
    @Expose
    private String mensaje;
    @Expose
    private String causa;
    @Expose
    private String errorSistemas;

    public List<Order> getOrdenes() {
        return Ordenes;
    }

    public void setOrdenes(List<Order> ordenes) {
        Ordenes = ordenes;
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

    public String getErrorSistemas() {
        return errorSistemas;
    }

    public void setErrorSistemas(String errorSistemas) {
        this.errorSistemas = errorSistemas;
    }
}
