package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laptoplenovo on 2/6/2018.
 */

public class DafSucursal {

    @SerializedName("codigoSucursal")
    private Integer codigoSucursal;

    @SerializedName("nombreSucursal")
    private String nombreSucursal;

    @SerializedName("tituloParaReporte")
    private String tituloParaReporte;

    @SerializedName("numeroLocalidad")
    private Integer numeroLocalidad;

    @SerializedName("tituloParaFactura")
    private String tituloParaFactura;

    @SerializedName("apiKeyRules")
    private String apiKeyRules;

    @SerializedName("usaXRulesAlHacerPedido")
    private String aplicaEdicionXRules;

    @SerializedName("elimPromAutOrdenPedido")
    private String elimPromAutOrdenPedido;

    @SerializedName("mostrarValorDescuentoManual")
    private String mostrarValorDescuentoManual;

    @SerializedName("mostrarValoresXRulesOrdenesPedidos")
    private String mostrarValoresXRulesOrdenesPedidos;

    @SerializedName("mostrarCheckAplicaRulesOrdenesPedido")
    private String mostrarCheckAplicaRulesOrdenesPedido;

    public Integer getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Integer codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getTituloParaReporte() {
        return tituloParaReporte;
    }

    public void setTituloParaReporte(String tituloParaReporte) {
        this.tituloParaReporte = tituloParaReporte;
    }

    public Integer getNumeroLocalidad() {
        return numeroLocalidad;
    }

    public void setNumeroLocalidad(Integer numeroLocalidad) {
        this.numeroLocalidad = numeroLocalidad;
    }

    public String getTituloParaFactura() {
        return tituloParaFactura;
    }

    public void setTituloParaFactura(String tituloParaFactura) {
        this.tituloParaFactura = tituloParaFactura;
    }

    public String getApiKeyRules() {
        return apiKeyRules;
    }

    public void setApiKeyRules(String apiKeyRules) {
        this.apiKeyRules = apiKeyRules;
    }

    public String getAplicaEdicionXRules() {
        return aplicaEdicionXRules;
    }

    public void setAplicaEdicionXRules(String aplicaEdicionXRules) {
        this.aplicaEdicionXRules = aplicaEdicionXRules;
    }

    public String getElimPromAutOrdenPedido() {
        return elimPromAutOrdenPedido;
    }

    public void setElimPromAutOrdenPedido(String elimPromAutOrdenPedido) {
        this.elimPromAutOrdenPedido = elimPromAutOrdenPedido;
    }

    public String getMostrarValorDescuentoManual() {
        return mostrarValorDescuentoManual;
    }

    public void setMostrarValorDescuentoManual(String mostrarValorDescuentoManual) {
        this.mostrarValorDescuentoManual = mostrarValorDescuentoManual;
    }

    public String getMostrarValoresXRulesOrdenesPedidos() {
        return mostrarValoresXRulesOrdenesPedidos;
    }

    public void setMostrarValoresXRulesOrdenesPedidos(String mostrarValoresXRulesOrdenesPedidos) {
        this.mostrarValoresXRulesOrdenesPedidos = mostrarValoresXRulesOrdenesPedidos;
    }

    public String getMostrarCheckAplicaRulesOrdenesPedido() {
        return mostrarCheckAplicaRulesOrdenesPedido;
    }

    public void setMostrarCheckAplicaRulesOrdenesPedido(String mostrarCheckAplicaRulesOrdenesPedido) {
        this.mostrarCheckAplicaRulesOrdenesPedido = mostrarCheckAplicaRulesOrdenesPedido;
    }

    public String toString() {
        return ""+nombreSucursal;
    }
}
