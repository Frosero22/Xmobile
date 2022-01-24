package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laptoplenovo on 30/5/2018.
 */

public class DafEmpresasMovil {

    @SerializedName("numeroIdentificacion")
    private String identification;
    @SerializedName("codigoEmpresa")
    private Integer companyCode;
    @SerializedName("direccionIp")
    private String ip;
    @SerializedName("nombreWarWsApp")
    private String contextRoot;
    @SerializedName("logoEmpresaApp")
    private String logo;
    @SerializedName("esActivo")
    private String active;
    @SerializedName("fechaIngreso")
    private String fechaIngreso;
    @SerializedName("usuarioIngreso")
    private String user;
    @SerializedName("fechaModificacion")
    private String fechaModificacion;
    @SerializedName("usuarioModificacion")
    private String usuarioModificacion;
    @SerializedName("direccionIpWsBrms")
    private String direccionIpWsBrms;
    @SerializedName("nombreWarWsBrms")
    private String nombreWarWsBrms;
    @SerializedName("apiKeyRules")
    private String apiKeyRules;

    public DafEmpresasMovil() {
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Integer getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(Integer codeCompany) {
        this.companyCode = codeCompany;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContextRoot() {
        return contextRoot;
    }

    public void setContextRoot(String contextRoot) {
        this.contextRoot = contextRoot;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
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

    public String getApiKeyRules() {
        return apiKeyRules;
    }

    public void setApiKeyRules(String apiKeyRules) {
        this.apiKeyRules = apiKeyRules;
    }
}
