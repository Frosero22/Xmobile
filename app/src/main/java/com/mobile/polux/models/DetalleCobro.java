package com.mobile.polux.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmList;

/**
 * Created by laptoplenovo on 26/11/2018.
 */

public class DetalleCobro {

    @Expose
    @SerializedName("codigoCliente")
    private int clientId;
    @SerializedName("nombreCliente")
    private String nombreCliente;
    @SerializedName("direccion")
    private String address;
    @SerializedName("secuenciaComprobante")
    private Integer seqDoc;
    @SerializedName("nombreTipoComprobante")
    private String type;
    @SerializedName("codigoComprobante")
    private String docId;
    @SerializedName("fechaEmision")
    private String date;
    @SerializedName("fechaPlazoPago")
    private String datePay;
    @SerializedName("totalIva")
    private Double iva;
    @SerializedName("totalDescuentos")
    private Double discount;
    @SerializedName("subtotal")
    private Double subtotal;
    @SerializedName("totalFactura")
    private Double totalDoc;
    @SerializedName("totalCancelado")
    private Double totalCanceled;
    @SerializedName("deuda")
    private Double due;
    @SerializedName("numerOrden")
    private Integer order;
    @SerializedName("detallesCompVenta")
    private RealmList<ProductInvoice> products;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSeqDoc() {
        return seqDoc;
    }

    public void setSeqDoc(Integer seqDoc) {
        this.seqDoc = seqDoc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public Double getTotalDoc() {
        return totalDoc;
    }

    public void setTotalDoc(Double totalDoc) {
        this.totalDoc = totalDoc;
    }

    public Double getTotalCanceled() {
        return totalCanceled;
    }

    public void setTotalCanceled(Double totalCanceled) {
        this.totalCanceled = totalCanceled;
    }

    public Double getDue() {

        return due;
    }

    public void setDue(Double due) {
        this.due = due;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDatePay() {
        return datePay;
    }

    public void setDatePay(String datePay) {
        this.datePay = datePay;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public RealmList<ProductInvoice> getProducts() {
        return products;
    }

    public void setProducts(RealmList<ProductInvoice> products) {
        this.products = products;
    }
}