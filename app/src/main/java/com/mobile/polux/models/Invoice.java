package com.mobile.polux.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 22/10/2018.
 */

public class Invoice extends RealmObject {


    @PrimaryKey
    private int pk;
    @Expose
    @SerializedName("secuenciaComprobante")
    private int id;
    private Integer order;
    private String codigoComprobante;
    private double iva;
    private double discount;
    private double subTotal;
    private double total;
    private double due;
    private double pay;
    private String state;
    private long guide;
    private String fechaVencimiento;
    @Expose
    private String fecha;
    @Expose
    private RealmList<PaymentDoc> pago;
    private RealmList<ProductInvoice> products;

    public Invoice() {
    }

    public Invoice(int id, String codigoComprobante, double total, double due, String state, String fecha, RealmList<ProductInvoice> products) {
        this.id = id;
        this.codigoComprobante = codigoComprobante;
        this.total = total;
        this.due = due;
        this.state = state;
        this.fecha = fecha;
        this.products = products;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoComprobante() {
        return codigoComprobante;
    }

    public void setCodigoComprobante(String codigoComprobante) {
        this.codigoComprobante = codigoComprobante;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public RealmList<PaymentDoc> getPago() {
        return pago;
    }

    public void setPago(RealmList<PaymentDoc> pago) {
        this.pago = pago;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public RealmList<ProductInvoice> getProducts() {
        return products;
    }

    public void setProducts(RealmList<ProductInvoice> products) {
        this.products = products;
    }

    public long getGuide() {
        return guide;
    }

    public void setGuide(long guide) {
        this.guide = guide;
    }

    public Invoice toUnManaged(Realm realm) {
        return isManaged() ? realm.copyFromRealm(this) : this;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
