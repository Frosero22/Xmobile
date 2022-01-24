package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laptoplenovo on 26/11/2018.
 */

public class ComprobantesDeCobroPorCliente {

    @SerializedName("codigoCliente")
    private String clientId;
    @SerializedName("nombreCliente")
    private String clientName;
    @SerializedName("secuenciaComprobante")
    private Integer seqDoc;
    @SerializedName("nombreTipoComprobante")
    private String type;
    @SerializedName("codigoComprobante")
    private String codeDoc;
    @SerializedName("totalFactura")
    private Double totalInvoice;
    @SerializedName("totalCancelado")
    private Integer totalCancel;
    @SerializedName("deuda")
    private Double due;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public String getCodeDoc() {
        return codeDoc;
    }

    public void setCodeDoc(String codeDoc) {
        this.codeDoc = codeDoc;
    }

    public Double getTotalInvoice() {
        return totalInvoice;
    }

    public void setTotalInvoice(Double totalInvoice) {
        this.totalInvoice = totalInvoice;
    }

    public Integer getTotalCancel() {
        return totalCancel;
    }

    public void setTotalCancel(Integer totalCancel) {
        this.totalCancel = totalCancel;
    }

    public Double getDue() {
        return due;
    }

    public void setDue(Double due) {
        this.due = due;
    }
}
