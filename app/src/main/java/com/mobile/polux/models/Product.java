package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 26/5/2018.
 */

public class Product extends RealmObject {

    @PrimaryKey
    private String pkId;
    @SerializedName("codigoPrestacion")
    private int id;
    @SerializedName("codigoEmpresa")
    private Integer codigoEmpresa;
    @SerializedName("codigoExistencia")
    private Integer codigoExistencia;
    @SerializedName("codigoReferencial")
    private String codigoReferencial;
    @SerializedName("nombrePrestacion")
    private String name;
    @SerializedName("unidadesXCajas")
    private Integer unidadesXCajas;
    @SerializedName("saldoActualExistencia")
    private Integer stock;
    @SerializedName("precioUnitario")
    private double price;
    @SerializedName("aplicaIva")
    private String aplicaIva;
    @SerializedName("porcentajeIva")
    private Double porcentajeIva;
    @SerializedName("costoUnitario")
    private double cost;
    @SerializedName("codigoServicio")
    private Integer serviceCode;
    @SerializedName("numeroVersion")
    private Integer  version;
    @SerializedName("nemonico")
    private String nDivision;
    @SerializedName("codigoGrupoItem")
    private int group;
    @SerializedName("codigoProveedor")
    private int provider;
    @SerializedName("codigoSubGrupoItem")
    private int subGroup;
    @SerializedName("codigoArticulo")
    private int article;
    @SerializedName("aplicaDescuentoManual")
    private String aplicaDescuentoManual;

    public Product() {
    }

    public Product(int id, String name, double price, Integer stock, int codigoExistencia) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.codigoExistencia = codigoExistencia;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Integer getUnidadesXCajas() {
        return unidadesXCajas;
    }

    public void setUnidadesXCajas(Integer unidadesXCajas) {
        this.unidadesXCajas = unidadesXCajas;
    }

    public Integer getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Integer getCodigoExistencia() {
        return codigoExistencia;
    }

    public void setCodigoExistencia(Integer codigoExistencia) {
        this.codigoExistencia = codigoExistencia;
    }

    public String getCodigoReferencial() {
        return codigoReferencial;
    }

    public void setCodigoReferencial(String codigoReferencial) {
        this.codigoReferencial = codigoReferencial;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getAplicaIva() {
        return aplicaIva;
    }

    public void setAplicaIva(String aplicaIva) {
        this.aplicaIva = aplicaIva;
    }

    public Double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(Double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(Integer serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getnDivision() {
        return nDivision;
    }

    public void setnDivision(String nDivision) {
        this.nDivision = nDivision;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public int getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(int subGroup) {
        this.subGroup = subGroup;
    }

    public int getProvider() {
        return provider;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getAplicaDescuentoManual() {
        return aplicaDescuentoManual;
    }

    public void setAplicaDescuentoManual(String aplicaDescuentoManual) {
        this.aplicaDescuentoManual = aplicaDescuentoManual;
    }
}
