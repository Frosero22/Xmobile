package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;


import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by laptoplenovo on 9/6/2018.
 */

public class Location extends RealmObject {

    @SerializedName("codigoLocalidad")
    private Integer id;
    @SerializedName("codigoCliente")
    private Integer codigoCliente;
    @SerializedName("nombreLocalidad")
    private String name;
    @SerializedName("direccionLocalidad")
    private String address;
    @SerializedName("direccionEntregaMercaderia")
    private String direccionEntregaMercaderia;
    @SerializedName("direccionMapa")
    private String direccionMapa;
    @SerializedName("esPrincipal")
    private String esPrincipal;
    @SerializedName("latitud")
    private String latitude;
    @SerializedName("longitud")
    private String longitude;
    @SerializedName("nombreArchivoImagen")
    private String img;
    @SerializedName("cantidadMaximaPedidos")
    private Integer maxOrdenes;
    @SerializedName("lsContactosXClientesXLocalidades")
    private RealmList<Contact> contacts;

    public Location() {
    }

    public Location(Integer id, String direccionEntregaMercaderia) {
        this.id = id;
        this.direccionEntregaMercaderia = direccionEntregaMercaderia;
        this.address = direccionEntregaMercaderia;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDireccionEntregaMercaderia() {
        return direccionEntregaMercaderia;
    }

    public void setDireccionEntregaMercaderia(String direccionEntregaMercaderia) {
        this.direccionEntregaMercaderia = direccionEntregaMercaderia;
    }

    public String getDireccionMapa() {
        return direccionMapa;
    }

    public void setDireccionMapa(String direccionMapa) {
        this.direccionMapa = direccionMapa;
    }

    public String getEsPrincipal() {
        return esPrincipal;
    }

    public void setEsPrincipal(String esPrincipal) {
        this.esPrincipal = esPrincipal;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public RealmList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(RealmList<Contact> contacts) {
        this.contacts = contacts;
    }

    public Integer getMaxOrdenes() {
        return maxOrdenes;
    }

    public void setMaxOrdenes(Integer maxOrdenes) {
        this.maxOrdenes = maxOrdenes;
    }

    @Override
    public String toString() {
        return ""+address;
    }
}
