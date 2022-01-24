package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BankResponse {

    @SerializedName("mensaje")
    private String message;
    @SerializedName("bancos")
    private List<Bank> banks;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }
}
