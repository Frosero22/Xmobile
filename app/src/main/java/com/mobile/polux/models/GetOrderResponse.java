package com.mobile.polux.models;

import com.google.gson.annotations.Expose;

/**
 * Created by laptoplenovo on 29/8/2018.
 */

public class GetOrderResponse {

    @Expose
    private Order ordenes;
    @Expose
    private String mensaje;

    public Order getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(Order ordenes) {
        this.ordenes = ordenes;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
