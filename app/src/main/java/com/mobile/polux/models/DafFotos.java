package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laptoplenovo on 30/5/2018.
 */

public class DafFotos {

    @SerializedName("secuenciaPersonal")
    private Integer secuenciaPersonal;
    @SerializedName("foto")
    private String foto;
    @SerializedName("fechaIngreso")
    private String fechaIngreso;
    @SerializedName("usuarioIngreso")
    private String usuarioIngreso;
    @SerializedName("fechaModificacion")
    private String fechaModificacion;
    @SerializedName("usuarioModificacion")
    private String usuarioModificacion;

    public DafFotos() {
    }

    public Integer getSecuenciaPersonal() {
        return secuenciaPersonal;
    }

    public void setSecuenciaPersonal(Integer secuenciaPersonal) {
        this.secuenciaPersonal = secuenciaPersonal;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getUsuarioIngreso() {
        return usuarioIngreso;
    }

    public void setUsuarioIngreso(String usuarioIngreso) {
        this.usuarioIngreso = usuarioIngreso;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}
