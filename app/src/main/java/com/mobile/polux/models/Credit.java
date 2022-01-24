package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laptoplenovo on 12/6/2018.
 */

public class Credit {

    @SerializedName("totalFacturas")
    private double totalFacturas;
    @SerializedName("totalNotasCredito")
    private double totalNotasCredito;
    @SerializedName("totalNotasDebito")
    private double totalNotasDebito;
    @SerializedName("valorTotalDeuda")
    private double valorTotalDeuda;
    @SerializedName("totalFacturado")
    private double totalFacturado;
    @SerializedName("valorPagado")
    private double valorPagado;
    @SerializedName("valorCredito")
    private double valorCredito;
    @SerializedName("valorDeudaPorVencer")
    private double valorDeudaPorVencer;
    @SerializedName("valorDeudaVencida")
    private double valorDeudaVencida;
    @SerializedName("codigoCalificacion")
    private double codigoCalificacion;
    @SerializedName("descripcionCalificacion")
    private String descripcionCalificacion;

    public double getTotalFacturas() {
        return totalFacturas;
    }

    public void setTotalFacturas(Double totalFacturas) {
        this.totalFacturas = totalFacturas;
    }

    public double getTotalNotasCredito() {
        return totalNotasCredito;
    }

    public void setTotalNotasCredito(Double totalNotasCredito) {
        this.totalNotasCredito = totalNotasCredito;
    }

    public double getTotalNotasDebito() {
        return totalNotasDebito;
    }

    public void setTotalNotasDebito(Double totalNotasDebito) {
        this.totalNotasDebito = totalNotasDebito;
    }

    public double getValorTotalDeuda() {
        return valorTotalDeuda;
    }

    public void setValorTotalDeuda(Double valorTotalDeuda) {
        this.valorTotalDeuda = valorTotalDeuda;
    }

    public double getTotalFacturado() {
        return totalFacturado;
    }

    public void setTotalFacturado(Double totalFacturado) {
        this.totalFacturado = totalFacturado;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void setValorPagado(Double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public void setValorCredito(Double valorCredito) {
        this.valorCredito = valorCredito;
    }

    public double getValorDeudaPorVencer() {
        return valorDeudaPorVencer;
    }

    public void setValorDeudaPorVencer(double valorDeudaPorVencer) {
        this.valorDeudaPorVencer = valorDeudaPorVencer;
    }

    public double getValorDeudaVencida() {
        return valorDeudaVencida;
    }

    public void setValorDeudaVencida(Double valorDeudaVencida) {
        this.valorDeudaVencida = valorDeudaVencida;
    }

    public double getCodigoCalificacion() {
        return codigoCalificacion;
    }

    public void setCodigoCalificacion(double codigoCalificacion) {
        this.codigoCalificacion = codigoCalificacion;
    }

    public String getDescripcionCalificacion() {
        return descripcionCalificacion;
    }

    public void setDescripcionCalificacion(String descripcionCalificacion) {
        this.descripcionCalificacion = descripcionCalificacion;
    }
}
