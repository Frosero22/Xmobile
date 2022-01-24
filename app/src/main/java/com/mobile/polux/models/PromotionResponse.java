package com.mobile.polux.models;

import java.util.List;

/**
 * Created by laptoplenovo on 1/8/2018.
 */

public class PromotionResponse {

    private String mensaje;
    private String causa;
    private String errorSistemas;
    private String response_id;
    private List<PromotionBodyResponse> response_body;

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

    public String getResponse_id() {
        return response_id;
    }

    public void setResponse_id(String response_id) {
        this.response_id = response_id;
    }

    public List<PromotionBodyResponse> getResponse_body() {
        return response_body;
    }

    public void setResponse_body(List<PromotionBodyResponse> response_body) {
        this.response_body = response_body;
    }
}
