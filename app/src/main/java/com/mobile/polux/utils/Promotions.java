package com.mobile.polux.utils;

import android.util.Log;

import com.mobile.polux.app.App;
import com.mobile.polux.models.Client;
import com.mobile.polux.models.Order;
import com.mobile.polux.models.Product;
import com.mobile.polux.models.ProductOrder;
import com.mobile.polux.models.PromotionBodyRequest;
import com.mobile.polux.models.PromotionBodyResponse;
import com.mobile.polux.models.PromotionRequest;
import com.mobile.polux.models.PromotionResponse;
import com.mobile.polux.models.PromotionRuleResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by laptoplenovo on 2/8/2018.
 */

public class Promotions {

    private Realm realm;

    private double totalDiscount;
    private double totalIva;
    private double totalOrder;
    private double subtotal;

    private List<ProductOrder> productsOrder;
    private List<ProductOrder> productsFree;

    private String message;

    private String division;
    private String strValidaXRules;
    private int version;

    public Promotions(Realm realm, String strValidaXRules) {
        this.realm = realm;
        this.strValidaXRules = strValidaXRules;
    }

    public Promotions(Realm realm) {
        this.realm = realm;
    }

    public Promotions(Realm realm, String division, int version, String strValidaXRules) {
        this.realm = realm;
        this.division = division;
        this.version = version;
        this.strValidaXRules = strValidaXRules;
    }

    public void setClient(String division, int version){
        this.division = division;
        this.version = version;
    }
/*
    public PromotionRequest preparePromotionRequest(int productId, int cant, double price,
                                                    int clientId, int clientType, double percentIva,
                                                    int group, int subGroup, int provider, int article) {

        double sub = cant * price;
        double iva = sub * percentIva;

        List<PromotionBodyRequest> productsPromotion = new ArrayList();

        productsPromotion.add(new PromotionBodyRequest(
                productId,
                App.companyCode,
                App.subCompanyCode,
                clientId,
                clientType,
                productId,
                group,
                sub + iva, //total = subtotalDiscount + iva;
                cant,
                provider, subGroup, article
        ));

        PromotionRequest promotionRequest = new PromotionRequest(App.getValueOfPreferencesUser(App.KEY_PROMOTION_ID,""), productsPromotion);
        promotionRequest.setDireccionIpWsBrms(App.getValueOfPreferencesUser(App.KEY_WS_BRMS_IP,""));
        promotionRequest.setNombreWarWsBrms(App.getValueOfPreferencesUser(App.KEY_WS_BRMS_NAME,""));
        return promotionRequest;
    } */

    public PromotionRequest preparePromotionRequestSurtitodo(Order order) {
        Product p;
        List<PromotionBodyRequest> productsPromotion = new ArrayList<>();

        for (ProductOrder product : order.getLsDafDetallesOrdens()) {

            Client client = UtilDB.getClient(realm, order.getCodigoCliente());
            if (!"S".equals(product.getEsPromocion())) {
                p = UtilDB.getProduct(realm, product.getCodigoPrestacion(), division, product.getNumeroVersion());
                productsPromotion.add(new PromotionBodyRequest(
                        product.getCodigoPrestacion(),
                        App.companyCode,
                        App.subCompanyCode,
                        order.getCodigoCliente(),
                        client.getType(),
                        p.getCodigoExistencia(),
                        p.getGroup(),
                        product.getValorTotal(),
                        product.getCantidad(),
                        p.getProvider(),
                        p.getSubGroup(),
                        p.getArticle()
                ));
            }
        }

        PromotionRequest promotionRequest = new PromotionRequest(App.getValueOfPreferencesUser(App.KEY_PROMOTION_ID,""), productsPromotion);
        promotionRequest.setDireccionIpWsBrms(App.getValueOfPreferencesUser(App.KEY_WS_BRMS_IP,""));
        promotionRequest.setNombreWarWsBrms(App.getValueOfPreferencesUser(App.KEY_WS_BRMS_NAME,""));



        return promotionRequest;
    }

    public PromotionRequest preparePromotionRequestV2(int productId, int cant, double price,
                                                    int clientId, int clientType, double percentIva,
                                                    int group, int subGroup, int provider, int article) {

        double sub = cant * price;
        double iva = sub * percentIva;

        List<PromotionBodyRequest> productsPromotion = new ArrayList();

        productsPromotion.add(new PromotionBodyRequest(
                productId,
                App.companyCode,
                App.subCompanyCode,
                clientId,
                clientType,
                productId,
                group,
                sub + iva, //total = subtotalDiscount + iva;
                cant,
                provider, subGroup, article
        ));

        PromotionRequest promotionRequest = new PromotionRequest(App.getValueOfPreferencesUser(App.KEY_PROMOTION_ID,""), productsPromotion);
        promotionRequest.setDireccionIpWsBrms(App.getValueOfPreferencesUser(App.KEY_WS_BRMS_IP,""));
        promotionRequest.setNombreWarWsBrms(App.getValueOfPreferencesUser(App.KEY_WS_BRMS_NAME,""));
        promotionRequest.setApiKey(App.getValueOfPreferencesUser(App.KEY_API_RULES,""));
        return promotionRequest;
    }

    public PromotionRequest preparePromotionRequest(Order order) {
        Product p;
        List<PromotionBodyRequest> productsPromotion = new ArrayList<>();

        for (ProductOrder product : order.getLsDafDetallesOrdens()) {

            Client client = UtilDB.getClient(realm, order.getCodigoCliente());
            if (!"S".equals(product.getEsPromocion())) {
                p = UtilDB.getProduct(realm, product.getCodigoPrestacion(), division, product.getNumeroVersion());
                productsPromotion.add(new PromotionBodyRequest(
                        product.getCodigoPrestacion(),
                        App.companyCode,
                        App.subCompanyCode,
                        order.getCodigoCliente(),
                        client.getType(),
                        p.getCodigoExistencia(),
                        p.getGroup(),
                        product.getValorTotal(),
                        product.getCantidad(),
                        p.getProvider(),
                        p.getSubGroup(),
                        p.getArticle()
                ));
            }
        }

        PromotionRequest promotionRequest = new PromotionRequest(App.getValueOfPreferencesUser(App.KEY_PROMOTION_ID,""), productsPromotion);
        promotionRequest.setDireccionIpWsBrms(App.getValueOfPreferencesUser(App.KEY_WS_BRMS_IP,""));
        promotionRequest.setNombreWarWsBrms(App.getValueOfPreferencesUser(App.KEY_WS_BRMS_NAME,""));
        promotionRequest.setApiKey(App.getValueOfPreferencesUser(App.KEY_API_RULES,""));



        return promotionRequest;
    }

    public ProductOrder prepareAddProduct(int code, String name, double price,
                                           int cant, int boxes, int units,
                                           String applyIva, double percentIva, int serviceCode, int version, double unitCost,
                                           double percentDiscount,
                                           boolean isPromotion,
                                           boolean isFree) {
        double total;
        double iva = 0;
        double subtotal;
        double subtotalDiscount;
        price = format(price, 6);
        subtotal = cant * price;
        subtotal = format(subtotal, 6);
        double discount = 0;




        if (percentDiscount > 0) {
            discount = (subtotal * percentDiscount) / 100;
        }
        discount = format(discount, 6);


        subtotalDiscount = subtotal - discount;



        if ("S".equals(applyIva)) {
            iva = subtotalDiscount * percentIva;
        }


        subtotalDiscount = format(subtotalDiscount, 6);
        total = subtotalDiscount + iva;

        iva = format(iva, 6);
        subtotal = format(subtotal, 6);
        total = format(total, 6);
        discount = format(discount, 6);

        ProductOrder productOrder = new ProductOrder(code, name, boxes, units, cant,
                price, subtotal, applyIva, percentIva,
                iva, total, App.userCode, App.subCompanyCode,
                serviceCode, version, unitCost);

        productOrder.setSubtotalBaseImponible(subtotal - discount);
        productOrder.setPorcentajeDescuento(percentDiscount);
        productOrder.setValorDescuento(discount);

        if (isPromotion) {
            productOrder.setEsPromocionAutomatica("S");
        }
        if (isFree) {
            productOrder.setEsPromocion("S");
        }


        totalDiscount += discount;
        totalIva += iva;
        totalOrder += total;
        this.subtotal += subtotal;

        return productOrder;
    }

    private double format(double value, int decimals){
        BigDecimal decimal = new BigDecimal(String.valueOf(value));
        BigDecimal newDecimal = decimal.setScale(decimals, RoundingMode.HALF_UP);
        return newDecimal.doubleValue();
    }

    public Order setPromotionOrder(Order order, PromotionResponse promotionResponse) {
        message = "";
        productsOrder = new ArrayList<>();
        productsFree = new ArrayList<>();
        totalDiscount = 0;
        totalIva = 0;
        totalOrder = 0;
        subtotal = 0;
        if (promotionResponse.getResponse_body() == null) {
            return order;
        }

        for (ProductOrder product : order.getLsDafDetallesOrdens()) {

            if (!"S".equals(product.getEsPromocion()) && product.getProductRelation() == null /*&& product.getCodigoReglaNegocio() == null*/) {
                percentDiscount = 0;

                for (PromotionBodyResponse bodyResponse : promotionResponse.getResponse_body()) {
                    promotionProduct(bodyResponse, product.getCodigoPrestacion(), product.getName());
                }


                ProductOrder productOrder = prepareAddProduct(
                        product.getCodigoPrestacion(), product.getName(),
                        product.getPrecioUnitarioVenta(), product.getCantidad(),
                        product.getBoxes(), product.getUnits(),
                        product.getAplicaIva(), product.getPorcentajeIva(),
                        product.getCodigoServicio(), product.getNumeroVersion(),
                        product.getCostoUnitario(), percentDiscount, false, false
                );
                if (percentDiscount > 0) {
                    productOrder.setCodigoReglaNegocio(ruleId);
                    productOrder.setEsPromocionAutomatica("S");
                }
                productsOrder.add(productOrder);

                productsOrder.addAll(productsFree);
                productsFree = new ArrayList<>();
            }
        }

        order.setLsDafDetallesOrdens(new RealmList<ProductOrder>());
        order.setLsDafDetallesOrdens(prepareOrderProducts(productsOrder));
        order.setDiscount(totalDiscount);
        order.setTotal(totalOrder);
        order.setIva(totalIva);
        order.setSubtotal(subtotal);
        return order;
    }


    Integer ruleId = null;
    double percentDiscount;

    private void promotionProduct(PromotionBodyResponse bodyResponse, int productId, String name) {

        if (bodyResponse.getResponse_detail_id() == productId && bodyResponse.getResponse_rule() != null) {
            //productsFree = new ArrayList<>();

            for (PromotionRuleResponse promotion : bodyResponse.getResponse_rule()) {
                if (promotion.getItem_regalo() != null) {
                    //agregar producto gratis
                    Product productFree = UtilDB.getProductFree(realm, promotion
                            .getItem_regalo(), promotion.getCantidad_item_regalo(),
                            division, version);
                    if (productFree != null) {
                        message += "Regla #   "  +promotion.getRule_id() +  "  GRATIS  " + promotion.getCantidad_item_regalo() + " " + getName(productFree.getName()) + "\n";
                        ProductOrder free = prepareAddProduct(
                                productFree.getId(), productFree.getName(),
                                productFree.getPrice(), promotion.getCantidad_item_regalo(), 0, promotion.getCantidad_item_regalo(),
                                productFree.getAplicaIva(), productFree.getPorcentajeIva(),
                                productFree.getServiceCode(), productFree.getVersion(),
                                productFree.getCost(), 100, true, true
                        );
                        free.setProductRelation(productId);
                        free.setCodigoReglaNegocio(promotion.getRule_id());
                        productsFree.add(free);
                    }

                }
                if (promotion.getPorcentaje_descuento() != null) {
                    //descuento al producto
                    message += "Regla #  " +promotion.getRule_id() +  " " + promotion.getPorcentaje_descuento() + " % DE DESCUENTO EN " + getName(name) + "\n";
                    percentDiscount = promotion.getPorcentaje_descuento();
                    ruleId = promotion.getRule_id();
                }
            }

        }
    }

    private String getName(String name) {
        int length = name.length();
        if (length > 30) {
            return name.substring(0, 30);
        } else {
            return name;
        }
    }

    public String getMessage() {
        return message;
    }


    public RealmList<ProductOrder> prepareOrderProducts(List<ProductOrder> productsOr) {
        RealmList<ProductOrder> products = new RealmList<>();

        for (ProductOrder p : productsOr) {
            if (p.getProductRelation() == null) {
                p.setLstDafDetallesOrden(getProductRelation(p.getCodigoPrestacion(), productsOr));
                products.add(p);
            }
        }

        return products;
    }

    private RealmList<ProductOrder> getProductRelation(int productId, List<ProductOrder> productsOrder) {
        RealmList<ProductOrder> products = new RealmList<>();
        for (ProductOrder p : productsOrder) {

            if (p.getProductRelation() != null && productId == p.getProductRelation()) {
                products.add(p);
            }
        }

        return products;
    }
}