package com.mobile.polux.models;

import com.google.gson.annotations.Expose;

/**
 * Created by laptoplenovo on 24/6/2018.
 */

public class OrderResponse {

    @Expose
    private String mensaje;
    @Expose
    private Long numeroOrden;
    @Expose
    private String error;
    @Expose
    private String aprobada;
    @Expose
    private String observaciones;
    @Expose
    private String userError;
    @Expose
    private String causa;
    @Expose
    private String errorSistemas;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(Long numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getAprobada() {
        return aprobada;
    }

    public void setAprobada(String aprobada) {
        this.aprobada = aprobada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
}
