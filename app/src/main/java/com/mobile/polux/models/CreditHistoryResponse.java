package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 12/6/2018.
 */

public class CreditHistoryResponse {

    @SerializedName("mensaje")
    private String message;
    @SerializedName("historialCrediticioCliente")
    private List<Credit> creditHistory;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Credit> getCreditHistory() {
        return creditHistory;
    }

    public void setCreditHistory(List<Credit> creditHistory) {
        this.creditHistory = creditHistory;
    }
}
