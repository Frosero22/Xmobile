package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by laptoplenovo on 2/6/2018.
 */

public class Company {

    @SerializedName("codigoEmpresa")
    private Integer codigoEmpresa;
    
    @SerializedName("nombreEmpresa")
    private String nombreEmpresa;

    @SerializedName("codigoTipoIdentificacion")
    private Integer codigoTipoIdentificacion;

    @SerializedName("numeroIdentificacion")
    private String numeroIdentificacion;

    @SerializedName("tituloParaReporte")
    private String tituloParaReporte;

    @SerializedName("ruc")
    private String ruc;
    @SerializedName("nombreComercial")
    private String nombreComercial;

    @SerializedName("logoEmpresa")
    private String logoEmpresa;

    @SerializedName("logoCabeceraEmpresa")
    private String logoCabeceraEmpresa;

    @SerializedName("usaEquivalencias")
    private String usaEquivalencias;

    @SerializedName("usaPromocion")
    private String usaPromocion;

    @SerializedName("nemonicoPromociones")
    private String nemonicoPromociones;

    @SerializedName("cantidadDiasEntregaPedido")
    private String cantDaysOrder;

    @SerializedName("codigoTipoOrdenUnico")
    private String uniqueTypeOrder;

    @SerializedName("codigoGrupoItemPromociones")
    private Integer promotionGroup;

    @SerializedName("codigoSubGrupoPromociones")
    private Integer promotionSubGroup;

    @SerializedName("codigoArticulo")
    private Integer promotionArticle;

    @SerializedName("codigoTipoOrdenXTipoPago")
    private String tipoOrdenTipoPago;

    public String getPermiteModificarDiasPedido() {
        return permiteModificarDiasPedido;
    }

    public void setPermiteModificarDiasPedido(String permiteModificarDiasPedido) {
        this.permiteModificarDiasPedido = permiteModificarDiasPedido;
    }

    @SerializedName("permiteModificarDiasPedido")
    private String permiteModificarDiasPedido;

    public Integer getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public Integer getCodigoTipoIdentificacion() {
        return codigoTipoIdentificacion;
    }

    public void setCodigoTipoIdentificacion(Integer codigoTipoIdentificacion) {
        this.codigoTipoIdentificacion = codigoTipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getTituloParaReporte() {
        return tituloParaReporte;
    }

    public void setTituloParaReporte(String tituloParaReporte) {
        this.tituloParaReporte = tituloParaReporte;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getLogoEmpresa() {
        return logoEmpresa;
    }

    public void setLogoEmpresa(String logoEmpresa) {
        this.logoEmpresa = logoEmpresa;
    }

    public String getLogoCabeceraEmpresa() {
        return logoCabeceraEmpresa;
    }

    public void setLogoCabeceraEmpresa(String logoCabeceraEmpresa) {
        this.logoCabeceraEmpresa = logoCabeceraEmpresa;
    }

    public String getUsaEquivalencias() {
        return usaEquivalencias;
    }

    public void setUsaEquivalencias(String usaEquivalencias) {
        this.usaEquivalencias = usaEquivalencias;
    }

    public String getUsaPromocion() {
        return usaPromocion;
    }

    public void setUsaPromocion(String usaPromocion) {
        this.usaPromocion = usaPromocion;
    }

    public String getNemonicoPromociones() {
        return nemonicoPromociones;
    }

    public void setNemonicoPromociones(String nemonicoPromociones) {
        this.nemonicoPromociones = nemonicoPromociones;
    }

    public String getCantDaysOrder() {
        return cantDaysOrder;
    }

    public void setCantDaysOrder(String cantDaysOrder) {
        this.cantDaysOrder = cantDaysOrder;
    }

    public String getUniqueTypeOrder() {
        return uniqueTypeOrder;
    }

    public void setUniqueTypeOrder(String uniqueTypeOrder) {
        this.uniqueTypeOrder = uniqueTypeOrder;
    }

    public Integer getPromotionGroup() {
        return promotionGroup;
    }

    public void setPromotionGroup(Integer promotionGroup) {
        this.promotionGroup = promotionGroup;
    }

    public Integer getPromotionSubGroup() {
        return promotionSubGroup;
    }

    public void setPromotionSubGroup(Integer promotionSubGroup) {
        this.promotionSubGroup = promotionSubGroup;
    }

    public Integer getPromotionArticle() {
        return promotionArticle;
    }

    public void setPromotionArticle(Integer promotionArticle) {
        this.promotionArticle = promotionArticle;
    }

    public String getTipoOrdenTipoPago() {
        return tipoOrdenTipoPago;
    }

    public void setTipoOrdenTipoPago(String tipoOrdenTipoPago) {
        this.tipoOrdenTipoPago = tipoOrdenTipoPago;
    }
}
