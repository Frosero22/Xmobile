package com.mobile.polux.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by laptoplenovo on 31/12/2018.
 */

public class PaymentDoc extends RealmObject {

    @Expose
    @SerializedName("codigoCobro")
    private int id;
    @Expose
    @SerializedName("valor")
    private double value;
    @Expose
    @SerializedName("fecha")
    private String date;
    @Expose
    @SerializedName("tipo")
    private String tipo;
    @Expose
    @SerializedName("numCuenta")
    private String numCuenta;
    @Expose
    @SerializedName("banco")
    private Integer banco;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Integer getBanco() {
        return banco;
    }

    public void setBanco(Integer banco) {
        this.banco = banco;
    }
}
