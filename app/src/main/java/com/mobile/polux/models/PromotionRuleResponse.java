package com.mobile.polux.models;

/**
 * Created by laptoplenovo on 1/8/2018.
 */

public class PromotionRuleResponse {

    private Double porcentaje_descuento;
    private Integer item_regalo;
    private Integer cantidad_item_regalo;
    private Integer cantidad_base_multiplo;
    private Integer rule_id;
    private Integer productId;

    public Double getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(Double porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public Integer getItem_regalo() {
        return item_regalo;
    }

    public void setItem_regalo(Integer item_regalo) {
        this.item_regalo = item_regalo;
    }

    public Integer getCantidad_item_regalo() {
        return cantidad_item_regalo;
    }

    public void setCantidad_item_regalo(Integer cantidad_item_regalo) {
        this.cantidad_item_regalo = cantidad_item_regalo;
    }

    public Integer getRule_id() {
        return rule_id;
    }

    public void setRule_id(Integer rule_id) {
        this.rule_id = rule_id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCantidad_base_multiplo() {
        return cantidad_base_multiplo;
    }

    public void setCantidad_base_multiplo(Integer cantidad_base_multiplo) {
        this.cantidad_base_multiplo = cantidad_base_multiplo;
    }
}
