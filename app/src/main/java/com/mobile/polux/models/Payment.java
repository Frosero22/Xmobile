package com.mobile.polux.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 22/10/2018.
 */

public class Payment extends RealmObject {

    @SerializedName("codigo")
    @Expose
    @PrimaryKey
    private Integer codigo;
    @SerializedName("codigoCliente")
    @Expose
    private int clientId;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("numCuenta")
    @Expose
    private String numCuenta;
    @SerializedName("valor")
    @Expose
    private double valor;
    @SerializedName("reciboCobro")
    @Expose
    private String voucher;
    @SerializedName("banco")
    @Expose
    private int banco;
    @SerializedName("observaciones")
    @Expose
    private String observaciones;
    @SerializedName("fecha")
    @Expose
    private String fecha;
    private String name;
    private double residuary;
    @Expose
    @SerializedName("secuencia")
    private Integer secuencia;

    private long guide;

    public Payment() {
    }

    public Payment(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
        this.residuary = valor;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getResiduary() {
        return residuary;
    }

    public void setResiduary(double residuary) {
        this.residuary = residuary;
    }

    public long getGuide() {
        return guide;
    }

    public void setGuide(long guide) {
        this.guide = guide;
    }

    public Payment toUnManaged(Realm realm) {
        return isManaged() ? realm.copyFromRealm(this) : this;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }
}
