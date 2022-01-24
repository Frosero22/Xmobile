package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 2/6/2018.
 */

public class SubCompaniesResponse {

    @SerializedName("dafEmpresas")
    private Company company;
    @SerializedName("dafSucursales")
    private List<DafSucursal> dafSucursales;
    @SerializedName("mensaje")
    private String message;

    public SubCompaniesResponse() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<DafSucursal> getDafSucursales() {
        return dafSucursales;
    }

    public void setDafSucursales(List<DafSucursal> dafSucursales) {
        this.dafSucursales = dafSucursales;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
