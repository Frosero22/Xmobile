package com.mobile.polux.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by laptoplenovo on 28/5/2018.
 */

public class ProductOrder extends RealmObject {

    //@PrimaryKey
    private int id;



    @Expose
    private int codigoPrestacion;
    private int codigoExistencia;
    private String name;
    private int boxes;
    private int units;
    @Expose
    private Integer codigoSucursal;
    @Expose
    private Integer codigoServicio;
    @Expose
    private Integer cantidad;
    @Expose
    private double precioUnitarioVenta;
    @Expose
    private double subtotalVenta;
    @Expose
    private Double porcentajeDescuento;
    @Expose
    private Double valorDescuento;
    @Expose
    private double subtotalBaseImponible;
    @Expose
    private String aplicaIva;
    @Expose
    private double porcentajeIva;
    @Expose
    private double valorIva;
    @Expose
    private double valorTotal;
    @Expose
    private String esActivo;
    @Expose
    private String codigoEstado;
    @Expose
    private String usuarioIngreso;
    @Expose
    private String tieneStockDisponible;
    @Expose
    private String esPromocion;
    @Expose
    private double costoUnitario;
    @Expose
    private double costoTotal;
    @Expose
    private double costoPromedio;
    @Expose
    private Integer numeroVersion;
    @Expose
    private String esPromocionAutomatica;
    @Expose
    private Integer codigoReglaNegocio;
    @Expose
    private Integer lineaDetalle;
    @Expose
    private String aplicaXRules;
    @Expose
    private Double porcentajeDescuentoXRules;
    @Expose
    private Double valorDescuentoXRules;
    @Expose
    private Double porcentajeDescuentoManual;
    @Expose
    private Double valorDescuentoManual;
    @Expose
    private Integer cantidadEnCajas;
    @Expose
    private Integer cantidadEnUnidades;



    private Integer productRelation;
    @Expose
    private RealmList<ProductOrder> lstDafDetallesOrden;

    private int provider;
    private int group;
    private int subGroup;
    private int article;

    public ProductOrder() {
    }



    public ProductOrder(int code,String name, int boxes, int units,
                        Integer cant, double price, double subtotal, String applyIva,
                        double percentIva, double iva, double total, String user,
                        Integer codeSubCompany, int serviceCode, int version, double unitCost, Double percentXRules, Double valueXRules, Double percentManual, Double valueManual) {
        this.name = name;
        this.boxes = boxes;
        this.units = units;
        this.codigoPrestacion = code;
        this.cantidad = cant;
        this.precioUnitarioVenta = price;
        this.subtotalVenta = subtotal;
        this.subtotalBaseImponible = subtotal;
        this.aplicaIva = applyIva;
        this.porcentajeIva = percentIva;
        this.valorIva = iva;
        this.valorTotal = total;
        this.usuarioIngreso = user;
        this.codigoSucursal = codeSubCompany;
        this.codigoServicio = serviceCode;
        this.numeroVersion = version;
        this.costoUnitario = unitCost;
        this.porcentajeDescuentoXRules = percentXRules;
        this.valorDescuentoXRules = valueXRules;
        this.porcentajeDescuentoManual = percentManual;
        this.valorDescuentoManual = valueManual;
        costoTotal = unitCost * cant;
        esPromocion = "N";
        esActivo = "S";
        codigoEstado = "ING";
        tieneStockDisponible = "S";
        porcentajeDescuento = 0.0;
        valorDescuento = 0.0;
        aplicaXRules = "N";
        this.cantidadEnUnidades = units;
        this.cantidadEnCajas = boxes;
        esPromocionAutomatica = esPromocion;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoPrestacion() {
        return codigoPrestacion;
    }

    public void setCodigoPrestacion(int codigoPrestacion) {
        this.codigoPrestacion = codigoPrestacion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBoxes() {
        return boxes;
    }

    public void setBoxes(int boxes) {
        this.boxes = boxes;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Integer getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Integer codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public Integer getCodigoServicio() {
        return codigoServicio;
    }

    public void setCodigoServicio(Integer codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    public void setPrecioUnitarioVenta(double precioUnitarioVenta) {
        this.precioUnitarioVenta = precioUnitarioVenta;
    }

    public double getSubtotalVenta() {
        return subtotalVenta;
    }

    public void setSubtotalVenta(double subtotalVenta) {
        this.subtotalVenta = subtotalVenta;
    }

    public Double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Double getValorDescuento() {
        return valorDescuento;
    }

    public void setValorDescuento(Double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    public double getSubtotalBaseImponible() {
        return subtotalBaseImponible;
    }

    public void setSubtotalBaseImponible(double subtotalBaseImponible) {
        this.subtotalBaseImponible = subtotalBaseImponible;
    }

    public String getAplicaIva() {
        return aplicaIva;
    }

    public void setAplicaIva(String aplicaIva) {
        this.aplicaIva = aplicaIva;
    }

    public double getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public double getValorIva() {
        return valorIva;
    }

    public void setValorIva(double valorIva) {
        this.valorIva = valorIva;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(String esActivo) {
        this.esActivo = esActivo;
    }

    public String getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getUsuarioIngreso() {
        return usuarioIngreso;
    }

    public void setUsuarioIngreso(String usuarioIngreso) {
        this.usuarioIngreso = usuarioIngreso;
    }

    public String getTieneStockDisponible() {
        return tieneStockDisponible;
    }

    public void setTieneStockDisponible(String tieneStockDisponible) {
        this.tieneStockDisponible = tieneStockDisponible;
    }

    public String getEsPromocion() {
        return esPromocion;
    }

    public void setEsPromocion(String esPromocion) {
        this.esPromocion = esPromocion;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Integer getNumeroVersion() {
        return numeroVersion;
    }

    public void setNumeroVersion(Integer numeroVersion) {
        this.numeroVersion = numeroVersion;
    }

    public double getCostoPromedio() {
        return costoPromedio;
    }

    public void setCostoPromedio(double costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    public String getEsPromocionAutomatica() {
        return esPromocionAutomatica;
    }

    public void setEsPromocionAutomatica(String esPromocionAutomatica) {
        this.esPromocionAutomatica = esPromocionAutomatica;
    }

    public Integer getCodigoReglaNegocio() {
        return codigoReglaNegocio;
    }

    public void setCodigoReglaNegocio(Integer codigoReglaNegocio) {
        this.codigoReglaNegocio = codigoReglaNegocio;
    }

    public Integer getProductRelation() {
        return productRelation;
    }

    public void setProductRelation(Integer productRelation) {
        this.productRelation = productRelation;
    }

    public Integer getLineaDetalle() {
        return lineaDetalle;
    }

    public void setLineaDetalle(Integer lineaDetalle) {
        this.lineaDetalle = lineaDetalle;
    }

    public RealmList<ProductOrder> getLstDafDetallesOrden() {
        return lstDafDetallesOrden;
    }

    public void setLstDafDetallesOrden(RealmList<ProductOrder> lstDafDetallesOrden) {
        this.lstDafDetallesOrden = lstDafDetallesOrden;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public int getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(int subGroup) {
        this.subGroup = subGroup;
    }

    public int getArticle() {
        return article;
    }

    public void setArticle(int article) {
        this.article = article;
    }

    public int getProvider() {
        return provider;
    }

    public void setProvider(int provider) {
        this.provider = provider;
    }

    public String getAplicaXRules() {
        return aplicaXRules;
    }

    public void setAplicaXRules(String aplicaXRules) {
        this.aplicaXRules = aplicaXRules;
    }

    public Double getPorcentajeDescuentoXRules() {
        return porcentajeDescuentoXRules;
    }

    public void setPorcentajeDescuentoXRules(Double porcentajeDescuentoXRules) {
        this.porcentajeDescuentoXRules = porcentajeDescuentoXRules;
    }

    public Double getValorDescuentoXRules() {
        return valorDescuentoXRules;
    }

    public void setValorDescuentoXRules(double valorDescuentoXRules) {
        this.valorDescuentoXRules = valorDescuentoXRules;
    }

    public Double getPorcentajeDescuentoManual() {
        return porcentajeDescuentoManual;
    }

    public void setPorcentajeDescuentoManual(Double porcentajeDescuentoManual) {
        this.porcentajeDescuentoManual = porcentajeDescuentoManual;
    }

    public Double getValorDescuentoManual() {
        return valorDescuentoManual;
    }

    public void setValorDescuentoManual(Double valorDescuentoManual) {
        this.valorDescuentoManual = valorDescuentoManual;
    }

    public Integer getCantidadEnCajas() {
        return cantidadEnCajas;
    }

    public void setCantidadEnCajas(Integer cantidadEnCajas) {
        this.cantidadEnCajas = cantidadEnCajas;
    }

    public Integer getCantidadEnUnidades() {
        return cantidadEnUnidades;
    }

    public void setCantidadEnUnidades(Integer cantidadEnUnidades) {
        this.cantidadEnUnidades = cantidadEnUnidades;
    }
}
