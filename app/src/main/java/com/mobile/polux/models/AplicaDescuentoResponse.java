package com.mobile.polux.models;

import com.google.gson.annotations.Expose;

public class AplicaDescuentoResponse {

    @Expose
    private String permiteModificarPorcentajeDescuento;
    @Expose
    private String permiteModificarValorDescuento;
    @Expose
    private String mensaje;
    @Expose
    private String permiteModificarDescuentoApp;

    public String getPermiteModificarPorcentajeDescuento() {
        return permiteModificarPorcentajeDescuento;
    }

    public void setPermiteModificarPorcentajeDescuento(String permiteModificarPorcentajeDescuento) {
        this.permiteModificarPorcentajeDescuento = permiteModificarPorcentajeDescuento;
    }

    public String getPermiteModificarValorDescuento() {
        return permiteModificarValorDescuento;
    }

    public void setPermiteModificarValorDescuento(String permiteModificarValorDescuento) {
        this.permiteModificarValorDescuento = permiteModificarValorDescuento;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPermiteModificarDescuentoApp() {
        return permiteModificarDescuentoApp;
    }

    public void setPermiteModificarDescuentoApp(String permiteModificarDescuentoApp) {
        this.permiteModificarDescuentoApp = permiteModificarDescuentoApp;
    }
}
