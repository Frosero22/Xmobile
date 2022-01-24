package com.mobile.polux.models;

/**
 * Created by laptoplenovo on 1/8/2018.
 */

public class PromotionBodyRequest {

    private Integer request_detail_id;
    private Integer empresa;
    private Integer sucursal;
    private Integer cliente;
    private Integer tipo_cliente;
    private Integer item;
    private Integer grupo_item;
    private Double monto;
    private Integer cantidad;
    private Integer proveedor;
    private Integer sub_grupo;
    private Integer articulo;

    public PromotionBodyRequest() {
    }

    public PromotionBodyRequest(Integer request_detail_id, Integer empresa, Integer sucursal, Integer cliente, Integer tipo_cliente, Integer item, Integer grupo_item, Double monto, Integer cantidad,
                                Integer proveedor, Integer sub_grupo, Integer articulo) {
        this.request_detail_id = request_detail_id;
        this.empresa = empresa;
        this.sucursal = sucursal;
        this.cliente = cliente;
        this.tipo_cliente = tipo_cliente;
        this.item = item;
        this.grupo_item = grupo_item;
        this.monto = monto;
        this.cantidad = cantidad;
        this.proveedor = proveedor;
        this.sub_grupo = sub_grupo;
        this.articulo = articulo;
    }



    public Integer getRequest_detail_id() {
        return request_detail_id;
    }

    public void setRequest_detail_id(Integer request_detail_id) {
        this.request_detail_id = request_detail_id;
    }

    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(Integer tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getGrupo_item() {
        return grupo_item;
    }

    public void setGrupo_item(Integer grupo_item) {
        this.grupo_item = grupo_item;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getProveedor() {
        return proveedor;
    }

    public void setProveedor(Integer proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getSub_grupo() {
        return sub_grupo;
    }

    public void setSub_grupo(Integer sub_grupo) {
        this.sub_grupo = sub_grupo;
    }

    public Integer getArticulo() {
        return articulo;
    }

    public void setArticulo(Integer articulo) {
        this.articulo = articulo;
    }
}
