package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 26/11/2018.
 */

public class GuideResponse {

    @SerializedName("guiasDeCobros")
    private List<GuiaDeCobro> guiasDeCobros = null;
    @SerializedName("comprobantesDeCobroPorCliente")
    private List<DetalleCobro> docPaymentClient = null;
    @SerializedName("mensaje")
    private String message;
    @SerializedName("causa")
    private String cause;

    public List<GuiaDeCobro> getGuiasDeCobros() {
        return guiasDeCobros;
    }

    public void setGuiasDeCobros(List<GuiaDeCobro> guiasDeCobros) {
        this.guiasDeCobros = guiasDeCobros;
    }

    public List<DetalleCobro> getDocPaymentClient() {
        return docPaymentClient;
    }

    public void setDocPaymentClient(List<DetalleCobro> docPaymentClient) {
        this.docPaymentClient = docPaymentClient;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
