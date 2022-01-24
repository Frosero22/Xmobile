package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class ProductInvoice extends RealmObject {

    @SerializedName("codigoPrestacion")
    private int id;
    @SerializedName("codigoEmpresa")
    private Integer codigoEmpresa;
    @SerializedName("codigoExistencia")
    private Integer codigoExistencia;
    @SerializedName("nombrePrestacion")
    private String name;
    @SerializedName("cantidad")
    private Integer cant;
    @SerializedName("precioUnitarioVenta")
    private double price;
    @SerializedName("valorTotal")
    private double total;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Integer getCodigoExistencia() {
        return codigoExistencia;
    }

    public void setCodigoExistencia(Integer codigoExistencia) {
        this.codigoExistencia = codigoExistencia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
