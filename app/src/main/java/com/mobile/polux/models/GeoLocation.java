package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 17/7/2018.
 */

public class GeoLocation extends RealmObject {

    @PrimaryKey
    @SerializedName("codigoCliente")
    private Integer clientId;
    @SerializedName("nombreCliente")
    private String clientName;
    @SerializedName("codigoLocalidad")
    private Integer codigoLocalidad;
    @SerializedName("direccionLocalidad")
    private String address;
    @SerializedName("latitud")
    private String latitude;
    @SerializedName("longitud")
    private String longitude;
    @SerializedName("nombreZona")
    private String zone;
    @SerializedName("nombreDiaVisita")
    private String day;
    @SerializedName("codigoReferencialCliente")
    private String reference;
    @SerializedName("descripcionTipoCliente")
    private String clientType;
    @SerializedName("descripcionTipoNegocio")
    private String businessType;

    private int numVisits;

    private int numOrders;

    private int type;
    private int cant;

    private String date;

    public GeoLocation() {}

    public GeoLocation(String day, int type, int cant) {
        this.day = day;
        this.type = type;
        this.cant = cant;
    }

    public GeoLocation(Integer clientId, String clientName, String address, String latitude, String longitude, String zone, String day, String date, int numVisits, int type) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.zone = zone;
        this.day = day;
        this.date = date;
        this.numVisits = numVisits;
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getClientId() {
        return clientId;
    }

    public Integer getCodigoLocalidad() {
        return codigoLocalidad;
    }

    public void setCodigoLocalidad(Integer codigoLocalidad) {
        this.codigoLocalidad = codigoLocalidad;
    }
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public int getNumVisits() {
        return numVisits;
    }

    public void setNumVisits(int numVisits) {
        this.numVisits = numVisits;
    }

    public int getNumOrders() {
        return numOrders;
    }

    public void setNumOrders(int numOrders) {
        this.numOrders = numOrders;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
}
