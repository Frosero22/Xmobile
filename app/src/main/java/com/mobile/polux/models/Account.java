package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by laptoplenovo on 14/6/2018.
 */

public class Account extends RealmObject {

    @SerializedName("codigoCuentaCliente")
    private Integer id;
   /* @SerializedName("codigoCliente")
    private Integer clientId;*/
    @SerializedName("codigoTipoVenta")
    private Integer saleTypeCode;
    @SerializedName("nombreTipoVenta")
    private String nameSale;
    @SerializedName("cupoActual")
    private Double quota;

    @SerializedName("diasGracia")
    private Integer daysGrace;
    @SerializedName("estado")
    private String state;
    @SerializedName("comentarios")
    private String comments;
    @SerializedName("codigoDivision")
    private Integer divisionCode;
    @SerializedName("codigoCuentaXDZV")
    private Integer XDZVCode;
    @SerializedName("nemonicoDivision")
    private String nDivision;
    @SerializedName("nombreDivision")
    private String division;
    @SerializedName("permiteModificarDiasPedido")
    private String permiteModificarDiasPedido;


    @SerializedName("diasPlazo")
    private Integer diasPlazo;


    @Ignore
    private boolean select;





    public Account() {
    }



    public Account(Integer id, Double quota, String nameSale, Integer saleTypeCode, Integer divisionCode, String nDivision, Integer XDZVCode, String division, String permiteModificarDiasPedido, Integer diasPlazo){
        this.id = id;
        this.quota = quota;
        this.nameSale = nameSale;
        this.saleTypeCode = saleTypeCode;
        this.divisionCode = divisionCode;
        this.nDivision = nDivision;
        this.XDZVCode = XDZVCode;
        this.division = division;
        this.permiteModificarDiasPedido = permiteModificarDiasPedido;
        this.diasPlazo = diasPlazo;
    }

    public Integer getDiasPlazo() {
        return diasPlazo;
    }

    public void setDiasPlazo(Integer diasPlazo) {
        this.diasPlazo = diasPlazo;
    }

    public String getPermiteModificarDiasPedido() {
        return permiteModificarDiasPedido;
    }

    public void setPermiteModificarDiasPedido(String permiteModificarDiasPedido) {
        this.permiteModificarDiasPedido = permiteModificarDiasPedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  /*  public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }*/

    public Integer getSaleTypeCode() {
        return saleTypeCode;
    }

    public void setSaleTypeCode(Integer saleTypeCode) {
        this.saleTypeCode = saleTypeCode;
    }

    public String getNameSale() {
        return nameSale;
    }

    public void setNameSale(String nameSale) {
        this.nameSale = nameSale;
    }

    public Double getQuota() {
        return quota;
    }

    public void setQuota(Double quota) {
        this.quota = quota;
    }



    public Integer getDaysGrace() {
        return daysGrace;
    }

    public void setDaysGrace(Integer daysGrace) {
        this.daysGrace = daysGrace;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Integer getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(Integer divisionCode) {
        this.divisionCode = divisionCode;
    }

    public Integer getXDZVCode() {
        return XDZVCode;
    }

    public void setXDZVCode(Integer XDZVCode) {
        this.XDZVCode = XDZVCode;
    }

    public String getnDivision() {
        return nDivision;
    }

    public void setnDivision(String nDivision) {
        this.nDivision = nDivision;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
