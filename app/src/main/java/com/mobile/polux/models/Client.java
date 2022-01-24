package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 22/5/2018.
 */

public class Client extends RealmObject {

    @PrimaryKey
    @SerializedName("codigoCliente")
    private int id;
    @SerializedName("numeroIdentificacionCliente")
    private String identification;
    @SerializedName("razonSocial")
    private String businessName;
    @SerializedName("nombreCliente")
    private String name;
    @SerializedName("codTipoCliente")
    private int type;
    @SerializedName("nombreTipoCliente")
    private String typeName;
    @SerializedName("telefonoCliente")
    private String phone;
    @SerializedName("codigoTipoPago")
    private String paymentType;
    @SerializedName("lsCuentasClientes")
    private RealmList<Account> accounts;
    @SerializedName("lsTarifarioXClientes")
    private RealmList<Rate> rate;
    @SerializedName("lsLocalidadesXClientes")
    private RealmList<Location> locations;
    @SerializedName("permiteModificarDiasPedido")
    private String permiteModificarDiasPedido;


    transient private int version;

    public Client() {
    }

    public Client(int id, String identification, String businessName, String name, int type, String typeName, String permiteModificarDiasPedido) {
        this.id = id;
        this.identification = identification;
        this.businessName = businessName;
        this.name = name;
        this.type = type;
        this.typeName = typeName;
        this.permiteModificarDiasPedido = permiteModificarDiasPedido;
    }


    public String getPermiteModificarDiasPedido() {
        return permiteModificarDiasPedido;
    }

    public void setPermiteModificarDiasPedido(String permiteModificarDiasPedido) {
        this.permiteModificarDiasPedido = permiteModificarDiasPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public RealmList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(RealmList<Account> accounts) {
        this.accounts = accounts;
    }

    public RealmList<Rate> getRate() {
        return rate;
    }

    public void setRate(RealmList<Rate> rate) {
        this.rate = rate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public RealmList<Location> getLocations() {
        return locations;
    }

    public void setLocations(RealmList<Location> locations) {
        this.locations = locations;
    }
}
