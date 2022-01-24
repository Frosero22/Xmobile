package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 6/6/2018.
 */

public class ClientsResponse {

    @SerializedName("lsClientes")
    private List<Client> clients;
    @SerializedName("mensaje")
    private String message;
    @SerializedName("totalClientes")
    private Integer total;


    public ClientsResponse() {
    }

    public List<Client> getClients() {
        return clients;
    }


    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }




}
