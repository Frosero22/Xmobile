package com.mobile.polux.models;

import java.util.List;

/**
 * Created by laptoplenovo on 1/8/2018.
 */

public class PromotionRequest {

    private String request_id;
    private String direccionIpWsBrms;
    private String nombreWarWsBrms;
    private String apiKey;

    private List<PromotionBodyRequest> request_body;

    public PromotionRequest() {
    }

    public PromotionRequest(String request_id, List<PromotionBodyRequest> request_body) {
        this.request_id = request_id;
        this.request_body = request_body;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getDireccionIpWsBrms() {
        return direccionIpWsBrms;
    }

    public void setDireccionIpWsBrms(String direccionIpWsBrms) {
        this.direccionIpWsBrms = direccionIpWsBrms;
    }

    public String getNombreWarWsBrms() {
        return nombreWarWsBrms;
    }

    public void setNombreWarWsBrms(String nombreWarWsBrms) {
        this.nombreWarWsBrms = nombreWarWsBrms;
    }

    public List<PromotionBodyRequest> getRequest_body() {
        return request_body;
    }

    public void setRequest_body(List<PromotionBodyRequest> request_body) {
        this.request_body = request_body;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
}
