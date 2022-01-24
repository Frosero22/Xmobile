package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by laptoplenovo on 23/6/2018.
 */

public class ProductPromotionOrder extends RealmObject  {

    @SerializedName("codigoPrestacion")
    private int code;
    private String name;
    @SerializedName("codigoSucursal")
    private Integer codeSubCompany;
    @SerializedName("codigoServicio")
    private Integer codeService;
    @SerializedName("codigoEmpresaTarifa")
    private Integer codeCompanyRate;
    @SerializedName("codigoMoneda")
    private Integer codeMoney;
    @SerializedName("cantidad")
    private Integer cant;
    @SerializedName("price")
    private double price;
    @SerializedName("subtotal")
    private double subtotal;
    @SerializedName("porcentajeDescuento")
    private double percentDiscount;
    @SerializedName("valorDescuento")
    private double discount;
    @SerializedName("subtotalBaseImponible")
    private double subtotalBaseImp;
    @SerializedName("aplicaIva")
    private String applyIva;
    @SerializedName("porcentajeIva")
    private double percentIva;
    @SerializedName("valorIva")
    private double iva;
    @SerializedName("total")
    private double total;
    @SerializedName("esActivo")
    private String active;
    @SerializedName("codigoEstado")
    private String codeState;
    @SerializedName("valorFacturado")
    private double fact;
    @SerializedName("valorXFacturar")
    private double xFact;
    //@SerializedName("total")
    private String user;
    @SerializedName("esPreFactura")
    private String preFact;
    @SerializedName("cantidadFacturada")
    private Integer cantFact;
    //@SerializedName("tieneStockDisponible")
    // private String tieneStockDisponible;
    @SerializedName("esPromocion")
    private String promotion;
    @SerializedName("costoUnitario")
    private double unitCost;
    // @SerializedName("costoTotal")
    //  private double costoTotal;
    //  @SerializedName("costoPromedio")
    //  private double costoPromedio;
    @SerializedName("numeroVersion")
    private Integer version;

    public ProductPromotionOrder() {}

    public ProductPromotionOrder(int code, Integer cant, double price, double subtotal, String applyIva, double percentIva, double iva, double total, String user, Integer codeSubCompany) {
        this.code = code;
        this.cant = cant;
        this.price = price;
        this.subtotal = subtotal;
        this.applyIva = applyIva;
        this.percentIva = percentIva;
        this.iva = iva;
        this.total = total;
        this.user = user;
        this.codeSubCompany = codeSubCompany;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Integer getCodeSubCompany() {
        return codeSubCompany;
    }

    public void setCodeSubCompany(Integer codeSubCompany) {
        this.codeSubCompany = codeSubCompany;
    }

    public Integer getCodeService() {
        return codeService;
    }

    public void setCodeService(Integer codeService) {
        this.codeService = codeService;
    }

    public Integer getCodeMoney() {
        return codeMoney;
    }

    public void setCodeMoney(Integer codeMoney) {
        this.codeMoney = codeMoney;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getPercentDiscount() {
        return percentDiscount;
    }

    public void setPercentDiscount(double percentDiscount) {
        this.percentDiscount = percentDiscount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getSubtotalBaseImp() {
        return subtotalBaseImp;
    }

    public void setSubtotalBaseImp(double subtotalBaseImp) {
        this.subtotalBaseImp = subtotalBaseImp;
    }

    public String getApplyIva() {
        return applyIva;
    }

    public void setApplyIva(String applyIva) {
        this.applyIva = applyIva;
    }

    public double getPercentIva() {
        return percentIva;
    }

    public void setPercentIva(double percentIva) {
        this.percentIva = percentIva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCodeState() {
        return codeState;
    }

    public void setCodeState(String codeState) {
        this.codeState = codeState;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPreFact() {
        return preFact;
    }

    public void setPreFact(String preFact) {
        this.preFact = preFact;
    }

    public Integer getCantFact() {
        return cantFact;
    }

    public void setCantFact(Integer cantFact) {
        this.cantFact = cantFact;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getCodeCompanyRate() {
        return codeCompanyRate;
    }

    public void setCodeCompanyRate(Integer codeCompanyRate) {
        this.codeCompanyRate = codeCompanyRate;
    }

    public double getFact() {
        return fact;
    }

    public void setFact(double fact) {
        this.fact = fact;
    }

    public double getxFact() {
        return xFact;
    }

    public void setxFact(double xFact) {
        this.xFact = xFact;
    }
}
