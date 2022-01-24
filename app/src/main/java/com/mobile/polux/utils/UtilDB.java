package com.mobile.polux.utils;

import com.mobile.polux.models.Account;
import com.mobile.polux.models.Bank;
import com.mobile.polux.models.CashingGuideDetail;
import com.mobile.polux.models.Client;
import com.mobile.polux.models.GeoLocation;
import com.mobile.polux.models.InfoGuia;
import com.mobile.polux.models.Invoice;
import com.mobile.polux.models.Order;
import com.mobile.polux.models.Payment;
import com.mobile.polux.models.Product;
import com.mobile.polux.models.ProductOrder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;

/**
 * Created by laptoplenovo on 8/9/2018.
 */

public class UtilDB {

    public static void updateNumOrders(Realm realm, int clientId) {
        try {
            if (!realm.isInTransaction()) {
                realm.beginTransaction();
            }
            GeoLocation geo = realm.where(GeoLocation.class).equalTo("clientId", clientId).findFirst();
            if (geo != null) {
                int numOrders = geo.getNumOrders();
                numOrders++;
                geo.setNumOrders(numOrders);
            }
            realm.copyToRealmOrUpdate(geo);
            realm.commitTransaction();
        } catch (Exception e) {
            try {
                realm.cancelTransaction();
            } catch (Exception e1) {}
        }
    }

    public static Product getProduct(Realm realm, int id, String nDivision, int version) {
        return realm.where(Product.class).equalTo("id", id)
                .equalTo("nDivision", nDivision)
                .equalTo("version", version)
                .findFirst();
    }

    public static Product getProduct(Realm realm, int id, int cant, String nDivision, int version) {
        return realm.where(Product.class).equalTo("id", id)
                .equalTo("nDivision", nDivision)
                .equalTo("version", version)

                .findFirst();
    }

    public static Product getProductFree(Realm realm, int codigoExistencia, int cant, String nDivision, int version) {
        return realm.where(Product.class).equalTo("codigoExistencia", codigoExistencia)
                .equalTo("nDivision", nDivision)
                .equalTo("version", version)

                .findFirst();
    }

    public static Account geAccount(Realm realm, int id) {
        return realm.where(Account.class).equalTo("id", id).findFirst();
    }

    public static Client getClient(Realm realm, int id) {
        return realm.where(Client.class).equalTo("id", id).findFirst();
    }

    public static int geClientVersion(Realm realm, int id) {
        return realm.where(Client.class).equalTo("id", id).findFirst().getRate().get(0).getVersion();
    }

    public static RealmResults<Payment> paymentsByGuide(Realm realm, long guide) {
        return realm.where(Payment.class).equalTo("guide", guide).findAll();
    }

    public static RealmResults<Payment> paymentsByClientId(Realm realm, long guide, int clientId) {
        return realm.where(Payment.class).equalTo("guide", guide).equalTo("clientId", clientId).findAll();
    }

    public static RealmResults<Bank> banks(Realm realm) {
        return realm.where(Bank.class).findAll();
    }

    public static long countPayment(Realm realm, int codigo) {
        return realm.where(Payment.class).equalTo("codigo", codigo).count();
    }

    public static Order getOrder(Realm realm, int id) {
        return realm.where(Order.class).equalTo("id", id).findFirst();
    }

    public static RealmResults<Order> getOrdersState(Realm realm, String state) {
        return realm.where(Order.class).equalTo("state", state).findAll();
    }

    public static RealmResults<Order> getOrdersChecked(Realm realm) {
        return realm.where(Order.class).equalTo("checked", true).findAll();
    }

    public static void removeOrder(Realm realm, Integer id) {
        if (!realm.isInTransaction()) {
            realm.beginTransaction();
        }
            Order od = realm.where(Order.class)
                    .equalTo("id", id)
                    .findFirst();
            if (od != null) {
                od.deleteFromRealm();
            }
        realm.commitTransaction();
    }

    public static void removeOrder(Realm realm, List<Order> orders) {
        if (!realm.isInTransaction()) {
            realm.beginTransaction();
        }
        for (Order o : orders) {
            Order od = realm.where(Order.class)
                    .equalTo("numeroOrden", o.getNumeroOrden())
                    .findFirst();
            if (od != null) {
                od.deleteFromRealm();
            }
        }
        realm.commitTransaction();
    }

    public static InfoGuia guideById(Realm realm, long guide){
        return realm.where(InfoGuia.class).equalTo("codigoGuiasCobro", guide).findFirst();
    }

    public static double totalCollectedByGuide(Realm realm, long guide){
        try {
            Number number = realm.where(InfoGuia.class).equalTo("codigoGuiasCobro", guide).findFirst().getDetails().where().equalTo("state", "REC").sum("collected");
            return number.doubleValue();
        } catch (Exception e) {return 0;}
    }

    public static int countCollectedByGuide(Realm realm, long guide){
        try {
            Number number = realm.where(InfoGuia.class).equalTo("codigoGuiasCobro", guide).findFirst().getDetails().where().equalTo("state", "REC").count();
            return number.intValue();
        } catch (Exception e) {return 0;}
    }

    public static int countInvoiceByGuide(Realm realm, long guide){
        try {
            return realm.where(Invoice.class).equalTo("guide", guide).findAll().size();
        } catch (Exception e) {return 0;}
    }

    public static double totalInvoiceDueByGuide(Realm realm, long guide){
        try {
            Number number = realm.where(Invoice.class).equalTo("guide", guide).sum("due");
            return number.doubleValue();
        } catch (Exception e) {return 0;}
    }

    public static long existOrderClientAccount(Realm realm, int clientId, int accountId, int codigoLocalidad) {
        DateFormat dateFormatView = new SimpleDateFormat("yyyy-MM-dd");
        Long l = realm.where(Order.class)
                .equalTo("codigoCliente", clientId)
                .equalTo("codigoCuentaCliente", accountId)
                .equalTo("codigoLocalidad", codigoLocalidad)
                .equalTo("fechaOrden", dateFormatView.format(new Date()))
                .count();
        return l;
    }

    public static long cantOrdenerPendientes(Realm realm){
        return realm.where(Order.class).equalTo("state", "OFF").count();
    }

    public static void deleteAll(Realm realm){
        if (!realm.isInTransaction()) {
            realm.beginTransaction();
        }
        realm.deleteAll();
        realm.commitTransaction();
    }

    public static void deleteAllNoOrderOff(Realm realm){
        if (!realm.isInTransaction()) {
            realm.beginTransaction();
        }
        for(Class<? extends RealmModel> clazz : realm.getConfiguration().getRealmObjectClasses()) {
            if(clazz != Order.class && clazz != ProductOrder.class) {
                realm.delete(clazz);
            }
        }
        try {
            realm.where(Order.class).equalTo("state", "ON").findAll().deleteAllFromRealm();
        } catch (Exception e) {}
        realm.commitTransaction();
    }

    public static void editOrderError(Realm realm, long id, String observaciones, String error){
        if (!realm.isInTransaction()) {
            realm.beginTransaction();
        }
        Order o = realm.where(Order.class).equalTo("id", id).findFirst();
        o.setObservaciones(observaciones);
        o.setError(error);
        realm.copyToRealmOrUpdate(o);
        realm.commitTransaction();
    }

    public static RealmResults<InfoGuia> guides(Realm realm) {
        return realm.where(InfoGuia.class).findAll();
    }

    public static long guidesCount(Realm realm) {
        return realm.where(InfoGuia.class).count();
    }

    public static void deleteGuides(Realm realm) {
        //Realm realm = Realm.getDefaultInstance();
        try {
            if (!realm.isInTransaction()) {
                realm.beginTransaction();
            }
            RealmResults<CashingGuideDetail> l = realm.where(CashingGuideDetail.class).findAll();
            l.deleteAllFromRealm();
            RealmResults<Payment> l2 = realm.where(Payment.class).findAll();
            l2.deleteAllFromRealm();
            RealmResults<Invoice> l3 = realm.where(Invoice.class).findAll();
            l3.deleteAllFromRealm();
            try {
                realm.where(InfoGuia.class).findAll().deleteAllFromRealm();
            } catch (Exception e) {}
            realm.commitTransaction();
        } catch (Exception e) {
            try {
                realm.cancelTransaction();
            } catch (Exception e1) {
            }
        }
    }
}
