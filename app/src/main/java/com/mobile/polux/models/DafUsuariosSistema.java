package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laptoplenovo on 30/5/2018.
 */

public class DafUsuariosSistema {

    @SerializedName("codigoUsuario")
    private String codigoUsuario;
    @SerializedName("cuentaMail")
    private String cuentaMail;
    @SerializedName("secuenciaPersonal")
    private Integer secuenciaPersonal;
    @SerializedName("fechaIngreso")
    private String fechaIngreso;
    @SerializedName("imagenFirma")
    private Object imagenFirma;
    @SerializedName("nombreCompleto")
    private String nombreCompleto;
    @SerializedName("sexo")
    private String sexo;

    public DafUsuariosSistema() {
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getCuentaMail() {
        return cuentaMail;
    }

    public void setCuentaMail(String cuentaMail) {
        this.cuentaMail = cuentaMail;
    }

    public Integer getSecuenciaPersonal() {
        return secuenciaPersonal;
    }

    public void setSecuenciaPersonal(Integer secuenciaPersonal) {
        this.secuenciaPersonal = secuenciaPersonal;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Object getImagenFirma() {
        return imagenFirma;
    }

    public void setImagenFirma(Object imagenFirma) {
        this.imagenFirma = imagenFirma;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
