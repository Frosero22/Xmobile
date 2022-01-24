package com.mobile.polux.utils;

import com.mobile.polux.app.App;
import com.mobile.polux.models.Bank;
import com.mobile.polux.models.Client;
import com.mobile.polux.models.GeoLocation;
import com.mobile.polux.models.Order;
import com.mobile.polux.models.Product;
import com.mobile.polux.models.ProductOrder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by laptoplenovo on 7/6/2018.
 */

public class Synchronize {

    public static void clients(Realm realm, List<Client> clients){
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(clients);
            realm.commitTransaction();
        } catch (Exception e) {
        }
    }

    public static void products(Realm realm, List<Product> products){
        try {
            for (Product p : products) {
                p.setPkId(p.getId()+"_"+p.getVersion()+"_"+p.getnDivision());
            }
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(products);
            realm.commitTransaction();
        } catch (Exception e) {
        }
    }

    public static void banks(Realm realm, List<Bank> banks){
        try {
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(banks);
            realm.commitTransaction();
        } catch (Exception e) {
        }
    }

    public static void visits(Realm realm, List<GeoLocation> geoLocations, String date){
        try {
            realm.beginTransaction();
            for (GeoLocation g : geoLocations) {

                if (realm.where(GeoLocation.class).equalTo("clientId", g.getClientId()).findFirst() == null) {
                    g.setDate(date);
                    realm.copyToRealmOrUpdate(g);
                }
            }
            realm.commitTransaction();

        } catch (Exception e) {
        }
    }

    public static void orders(Realm realm, List<Order> orders, boolean conAuxiliar){
        try {
            for (Order o : orders) {
                if (conAuxiliar && (o.getError()== null || o.getError().isEmpty())) {
                    if ("S".equals(o.getAprobada())){
                        o.setState("ON");
                        UtilDB.updateNumOrders(realm, o.getCodigoCliente());
                    }
                    setLineDetail(realm, o, conAuxiliar);

                } else if (!conAuxiliar){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTimeInMillis(new Long(o.getFechaOrden()));
                        o.setFechaOrden(sdf.format(calendar.getTime()));
                    } catch (Exception e) {
                        o.setFechaOrden(sdf.format(new Date()));
                    }
                    setLineDetail(realm, o, conAuxiliar);
                }

            }
        } catch (Exception e) {
        }
    }

    private static void setLineDetail(Realm realm, Order o, boolean conAuxiliar){
        String state;
        state = o.getCodigoEstado();
        if (conAuxiliar || (("ING".equals(state) || "APB".equals(state)) && notExistOrder(realm, o.getNumeroOrden()))) {
            try {
                if (!realm.isInTransaction()) {
                    realm.beginTransaction();
                }
                Order order;
                if (conAuxiliar) {
                    order = realm.where(Order.class).equalTo("id", o.getNumeroOrdenAuxiliar()).findFirst();
                } else {
                    order = new Order(o);
                    order.setId(App.orderId.incrementAndGet());
                }
                order.setName(getClientName(realm, o.getCodigoCliente()));
                order.setFechaOrden(o.getFechaOrden());
                double subtotal = 0;
                double discount = 0;
                double iva = 0;
                double total = 0;
                for (ProductOrder p : o.getLsDafDetallesOrdens()) {
                    p.setName(getProductName(realm, p.getCodigoPrestacion()));
                    p.setUnits(p.getCantidad());
                    subtotal += p.getSubtotalVenta();
                    iva += p.getValorIva();
                    discount += p.getValorDescuento();
                    total += p.getValorTotal();
                    for (ProductOrder promo : p.getLstDafDetallesOrden()) {
                        promo.setName(getProductName(realm, p.getCodigoPrestacion()));
                        promo.setUnits(promo.getCantidad());
                    }
                }
                RealmList<ProductOrder> productsOrderList = new RealmList<>();
                for (ProductOrder p : o.getLsDafDetallesOrdens()) {
                    productsOrderList.add(p);
                    if (p.getLstDafDetallesOrden() != null) {
                        for (ProductOrder promo : p.getLstDafDetallesOrden()) {
                            promo.setProductRelation(p.getCodigoPrestacion());
                            //productsOrderList.add(promo);
                        }
                    }
                }
                order.setTotal(total);
                order.setSubtotal(subtotal);
                order.setIva(iva);
                order.setDiscount(discount);
                order.setState("ON");
                if ("ING".equals(state)) {
                    order.setApproved(false);
                } else {
                    order.setApproved(true);
                }
                order.setLsDafDetallesOrdens(productsOrderList);

                realm.copyToRealmOrUpdate(order);
                realm.commitTransaction();
            } catch (Exception e) {}
        }
    }

    private static String getProductName(Realm realm, int id) {
        try {
            return realm.where(Product.class).equalTo("id", id)
                    .findFirst().getName();
        } catch (Exception e) {
            return "";
        }
    }

    private static String getClientName(Realm realm, int id) {
        try {
            return realm.where(Client.class).equalTo("id", id)
                    .findFirst().getName();
        } catch (Exception e) {
            return "";
        }
    }

    private static boolean notExistOrder(Realm realm, long order) {
        try {
            return realm.where(Order.class).equalTo("numeroOrden", order)
                    .findAll().isEmpty();
        } catch (Exception e) {
            return true;
        }
    }

}
