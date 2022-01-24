package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 14/6/2018.
 */

public class AccountsResponse {

    @SerializedName("lsCuentasClientes")
    private List<Account> accounts = null;
    @SerializedName("mensaje")
    private String message;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
