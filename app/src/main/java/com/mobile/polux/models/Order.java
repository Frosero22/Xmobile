package com.mobile.polux.models;

import com.google.gson.annotations.Expose;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 15/6/2018.
 */

public class Order extends RealmObject {

    @PrimaryKey
    private Integer id;
    @Expose
    private Long numeroOrden;
    @Expose
    private Integer numeroOrdenAuxiliar;
    @Expose
    private String aprobada;
    @Expose
    private String observaciones;
    @Expose
    private String error;

    @Expose
    private int codigoCliente;
    private String name;
    private double total;
    private double subtotal;
    private double iva;
    private double discount;
    private String state;
    private boolean approved;
    @Expose
    private String fechaOrden;

    @Expose
    private Integer codigoEmpresa;
    @Expose
    private Integer codigoSucursal;

    @Expose
    private String fechaEntrega;
    @Expose
    private String fechaCompromisoPago;
    @Expose
    private Integer codigoTipoVenta;

    @Expose
    private String codigoEstado;
    @Expose
    private String observacion;
    @Expose
    private String aplicaConsignacion;
    @Expose
    private String codigoTipoOrden;
    @Expose
    private String aplicaFacturaSinStock;
    @Expose
    private Integer codigoBodega;
    @Expose
    private String usuarioIngreso;
    @Expose
    private Integer codigoCuentaCliente;
    @Expose
    private Integer codigoDivision;
    @Expose
    private Integer codigoCuentaXDZV;
    @Expose
    private Integer codigoLocalidad;


   // @Expose
   // private Integer diasPlazo;

    @Expose
    private RealmList<ProductOrder> lsDafDetallesOrdens;

    private transient boolean checked;

    public Order() {
    }

    public Order(Order o) {
        this.numeroOrden = o.numeroOrden;
        this.codigoCliente = o.codigoCliente;
        this.approved = o.approved;
        this.codigoEmpresa = o.codigoEmpresa;
        this.codigoSucursal = o.codigoSucursal;
        this.fechaEntrega = o.fechaEntrega;
        this.fechaCompromisoPago = o.fechaCompromisoPago;
        this.codigoTipoVenta = o.codigoTipoVenta;
        this.codigoEstado = o.codigoEstado;
        this.observacion = o.observacion;
        this.aplicaConsignacion = o.aplicaConsignacion;
        this.codigoTipoOrden = o.codigoTipoOrden;
        this.aplicaFacturaSinStock = o.aplicaFacturaSinStock;
        this.codigoBodega = o.codigoBodega;
        this.usuarioIngreso = o.usuarioIngreso;
        this.codigoCuentaCliente = o.codigoCuentaCliente;
        this.codigoDivision = o.codigoDivision;
        this.codigoCuentaXDZV = o.codigoCuentaXDZV;
        this.codigoLocalidad = o.codigoLocalidad;
     //   this.diasPlazo = o.diasPlazo;
    }

  //  public Integer getDiasPlazo() {
      //  return diasPlazo;
   // }

  //  public void setDiasPlazo(Integer diasPlazo) {
    //    this.diasPlazo = diasPlazo;
   // }

    public Order toUnManaged(Realm realm) {
        return isManaged() ? realm.copyFromRealm(this) : this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<ProductOrder> getLsDafDetallesOrdens() {
        return lsDafDetallesOrdens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getFechaCompromisoPago() {
        return fechaCompromisoPago;
    }

    public void setFechaCompromisoPago(String fechaCompromisoPago) {
        this.fechaCompromisoPago = fechaCompromisoPago;
    }

    public Integer getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(Integer codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public Integer getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(Integer codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public Integer getCodigoTipoVenta() {
        return codigoTipoVenta;
    }

    public void setCodigoTipoVenta(Integer codigoTipoVenta) {
        this.codigoTipoVenta = codigoTipoVenta;
    }

    /* public Integer getDiasValidez() {
         return diasValidez;
     }

     public void setDiasValidez(Integer diasValidez) {
         this.diasValidez = diasValidez;
     }

     public String getEsActivo() {
         return active;
     }

     public void setEsActivo(String active) {
         this.active = active;
     }
 */

     public String getCodigoEstado() {
         return codigoEstado;
     }

     public void setCodigoEstado(String codigoEstado) {
         this.codigoEstado = codigoEstado;
     }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getAplicaConsignacion() {
        return aplicaConsignacion;
    }

    public void setAplicaConsignacion(String aplicaConsignacion) {
        this.aplicaConsignacion = aplicaConsignacion;
    }

    public String getCodigoTipoOrden() {
        return codigoTipoOrden;
    }

    public void setCodigoTipoOrden(String codigoTipoOrden) {
        this.codigoTipoOrden = codigoTipoOrden;
    }

    public String getAplicaFacturaSinStock() {
        return aplicaFacturaSinStock;
    }

    public void setAplicaFacturaSinStock(String aplicaFacturaSinStock) {
        this.aplicaFacturaSinStock = aplicaFacturaSinStock;
    }

    public Integer getCodigoBodega() {
        return codigoBodega;
    }

    public void setCodigoBodega(Integer codigoBodega) {
        this.codigoBodega = codigoBodega;
    }

    public String getUsuarioIngreso() {
        return usuarioIngreso;
    }

    public void setUsuarioIngreso(String usuarioIngreso) {
        this.usuarioIngreso = usuarioIngreso;
    }

    public Integer getCodigoCuentaCliente() {
        return codigoCuentaCliente;
    }

    public void setCodigoCuentaCliente(Integer codigoCuentaCliente) {
        this.codigoCuentaCliente = codigoCuentaCliente;
    }

    public Integer getCodigoDivision() {
        return codigoDivision;
    }

    public void setCodigoDivision(Integer codigoDivision) {
        this.codigoDivision = codigoDivision;
    }

    public Integer getCodigoCuentaXDZV() {
        return codigoCuentaXDZV;
    }

    public Integer getCodigoLocalidad() {
        return codigoLocalidad;
    }

    public void setCodigoLocalidad(Integer codigoLocalidad) {
        this.codigoLocalidad = codigoLocalidad;
    }

    public void setCodigoCuentaXDZV(Integer codigoCuentaXDZV) {
        this.codigoCuentaXDZV = codigoCuentaXDZV;
    }

    public void setLsDafDetallesOrdens(RealmList<ProductOrder> lsDafDetallesOrdens) {
        this.lsDafDetallesOrdens = lsDafDetallesOrdens;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Long getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(Long numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(String fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Integer getNumeroOrdenAuxiliar() {
        return numeroOrdenAuxiliar;
    }

    public void setNumeroOrdenAuxiliar(Integer numeroOrdenAuxiliar) {
        this.numeroOrdenAuxiliar = numeroOrdenAuxiliar;
    }

    public String getAprobada() {
        return aprobada;
    }

    public void setAprobada(String aprobada) {
        this.aprobada = aprobada;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
