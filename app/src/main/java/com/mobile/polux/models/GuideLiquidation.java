package com.mobile.polux.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 26/12/2018.
 */

public class GuideLiquidation {

    @Expose
    private InfoGuia guiaCobro;
    @Expose
    @SerializedName("clientes")
    private List<CashingGuideDetail> clients;
    @Expose
    @SerializedName("cobros")
    private List<Payment> payments;

    public InfoGuia getGuiaCobro() {
        return guiaCobro;
    }

    public void setGuiaCobro(InfoGuia guiaCobro) {
        this.guiaCobro = guiaCobro;
    }

    public List<CashingGuideDetail> getClients() {
        return clients;
    }

    public void setClients(List<CashingGuideDetail> clients) {
        this.clients = clients;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}