package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by laptoplenovo on 9/6/2018.
 */

public class Contact extends RealmObject {

    /*@SerializedName("secuenciaContactoCliente")
    private Integer secuenciaContactoCliente;
    @SerializedName("codigoLocalidad")
    private Integer codigoLocalidad;
    @SerializedName("codigoCliente")
    private Integer codigoCliente;
    @SerializedName("nombreContacto")
    private String nombreContacto;*/
    @SerializedName("telefono1")
    private String telefono1;
    /*@SerializedName("telefono2")
    private String telefono2;
    @SerializedName("telefono3")
    private String telefono3;
    @SerializedName("eMailPrincipal")
    private String eMailPrincipal;
    @SerializedName("eMailFacturacion")
    private String eMailFacturacion;
    @SerializedName("eMailCobranzas")
    private String eMailCobranzas;*/

    public Contact() {
    }

   /* public Integer getSecuenciaContactoCliente() {
        return secuenciaContactoCliente;
    }

    public void setSecuenciaContactoCliente(Integer secuenciaContactoCliente) {
        this.secuenciaContactoCliente = secuenciaContactoCliente;
    }

    public Integer getCodigoLocalidad() {
        return codigoLocalidad;
    }

    public void setCodigoLocalidad(Integer codigoLocalidad) {
        this.codigoLocalidad = codigoLocalidad;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }*/

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }
/*
    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getTelefono3() {
        return telefono3;
    }

    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }

    public String geteMailPrincipal() {
        return eMailPrincipal;
    }

    public void seteMailPrincipal(String eMailPrincipal) {
        this.eMailPrincipal = eMailPrincipal;
    }

    public String geteMailFacturacion() {
        return eMailFacturacion;
    }

    public void seteMailFacturacion(String eMailFacturacion) {
        this.eMailFacturacion = eMailFacturacion;
    }

    public String geteMailCobranzas() {
        return eMailCobranzas;
    }

    public void seteMailCobranzas(String eMailCobranzas) {
        this.eMailCobranzas = eMailCobranzas;
    }*/
}
