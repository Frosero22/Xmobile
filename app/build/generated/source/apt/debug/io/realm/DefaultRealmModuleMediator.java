package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.mobile.polux.models.CashingGuideDetail.class);
        modelClasses.add(com.mobile.polux.models.PaymentDoc.class);
        modelClasses.add(com.mobile.polux.models.Client.class);
        modelClasses.add(com.mobile.polux.models.Payment.class);
        modelClasses.add(com.mobile.polux.models.Contact.class);
        modelClasses.add(com.mobile.polux.models.Bank.class);
        modelClasses.add(com.mobile.polux.models.ProductInvoice.class);
        modelClasses.add(com.mobile.polux.models.Location.class);
        modelClasses.add(com.mobile.polux.models.Order.class);
        modelClasses.add(com.mobile.polux.models.Parameter.class);
        modelClasses.add(com.mobile.polux.models.ProductPromotionOrder.class);
        modelClasses.add(com.mobile.polux.models.Filter.class);
        modelClasses.add(com.mobile.polux.models.Rate.class);
        modelClasses.add(com.mobile.polux.models.InfoGuia.class);
        modelClasses.add(com.mobile.polux.models.Account.class);
        modelClasses.add(com.mobile.polux.models.Guide.class);
        modelClasses.add(com.mobile.polux.models.Invoice.class);
        modelClasses.add(com.mobile.polux.models.ProductOrder.class);
        modelClasses.add(com.mobile.polux.models.GeoLocation.class);
        modelClasses.add(com.mobile.polux.models.Product.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
            return io.realm.CashingGuideDetailRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
            return io.realm.PaymentDocRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Client.class)) {
            return io.realm.ClientRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Payment.class)) {
            return io.realm.PaymentRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Contact.class)) {
            return io.realm.ContactRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Bank.class)) {
            return io.realm.BankRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
            return io.realm.ProductInvoiceRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Location.class)) {
            return io.realm.LocationRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Order.class)) {
            return io.realm.OrderRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
            return io.realm.ParameterRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
            return io.realm.ProductPromotionOrderRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Filter.class)) {
            return io.realm.FilterRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Rate.class)) {
            return io.realm.RateRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
            return io.realm.InfoGuiaRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Account.class)) {
            return io.realm.AccountRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Guide.class)) {
            return io.realm.GuideRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
            return io.realm.InvoiceRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
            return io.realm.ProductOrderRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
            return io.realm.GeoLocationRealmProxy.createRealmObjectSchema(realmSchema);
        }
        if (clazz.equals(com.mobile.polux.models.Product.class)) {
            return io.realm.ProductRealmProxy.createRealmObjectSchema(realmSchema);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
            return io.realm.CashingGuideDetailRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
            return io.realm.PaymentDocRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Client.class)) {
            return io.realm.ClientRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Payment.class)) {
            return io.realm.PaymentRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Contact.class)) {
            return io.realm.ContactRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Bank.class)) {
            return io.realm.BankRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
            return io.realm.ProductInvoiceRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Location.class)) {
            return io.realm.LocationRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Order.class)) {
            return io.realm.OrderRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
            return io.realm.ParameterRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
            return io.realm.ProductPromotionOrderRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Filter.class)) {
            return io.realm.FilterRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Rate.class)) {
            return io.realm.RateRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
            return io.realm.InfoGuiaRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Account.class)) {
            return io.realm.AccountRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Guide.class)) {
            return io.realm.GuideRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
            return io.realm.InvoiceRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
            return io.realm.ProductOrderRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
            return io.realm.GeoLocationRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        if (clazz.equals(com.mobile.polux.models.Product.class)) {
            return io.realm.ProductRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
            return io.realm.CashingGuideDetailRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
            return io.realm.PaymentDocRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Client.class)) {
            return io.realm.ClientRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Payment.class)) {
            return io.realm.PaymentRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Contact.class)) {
            return io.realm.ContactRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Bank.class)) {
            return io.realm.BankRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
            return io.realm.ProductInvoiceRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Location.class)) {
            return io.realm.LocationRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Order.class)) {
            return io.realm.OrderRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
            return io.realm.ParameterRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
            return io.realm.ProductPromotionOrderRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Filter.class)) {
            return io.realm.FilterRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Rate.class)) {
            return io.realm.RateRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
            return io.realm.InfoGuiaRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Account.class)) {
            return io.realm.AccountRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Guide.class)) {
            return io.realm.GuideRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
            return io.realm.InvoiceRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
            return io.realm.ProductOrderRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
            return io.realm.GeoLocationRealmProxy.getFieldNames();
        }
        if (clazz.equals(com.mobile.polux.models.Product.class)) {
            return io.realm.ProductRealmProxy.getFieldNames();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
            return io.realm.CashingGuideDetailRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
            return io.realm.PaymentDocRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Client.class)) {
            return io.realm.ClientRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Payment.class)) {
            return io.realm.PaymentRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Contact.class)) {
            return io.realm.ContactRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Bank.class)) {
            return io.realm.BankRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
            return io.realm.ProductInvoiceRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Location.class)) {
            return io.realm.LocationRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Order.class)) {
            return io.realm.OrderRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
            return io.realm.ParameterRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
            return io.realm.ProductPromotionOrderRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Filter.class)) {
            return io.realm.FilterRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Rate.class)) {
            return io.realm.RateRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
            return io.realm.InfoGuiaRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Account.class)) {
            return io.realm.AccountRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Guide.class)) {
            return io.realm.GuideRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
            return io.realm.InvoiceRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
            return io.realm.ProductOrderRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
            return io.realm.GeoLocationRealmProxy.getTableName();
        }
        if (clazz.equals(com.mobile.polux.models.Product.class)) {
            return io.realm.ProductRealmProxy.getTableName();
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
                return clazz.cast(new io.realm.CashingGuideDetailRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
                return clazz.cast(new io.realm.PaymentDocRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Client.class)) {
                return clazz.cast(new io.realm.ClientRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Payment.class)) {
                return clazz.cast(new io.realm.PaymentRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Contact.class)) {
                return clazz.cast(new io.realm.ContactRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Bank.class)) {
                return clazz.cast(new io.realm.BankRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
                return clazz.cast(new io.realm.ProductInvoiceRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Location.class)) {
                return clazz.cast(new io.realm.LocationRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Order.class)) {
                return clazz.cast(new io.realm.OrderRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
                return clazz.cast(new io.realm.ParameterRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
                return clazz.cast(new io.realm.ProductPromotionOrderRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Filter.class)) {
                return clazz.cast(new io.realm.FilterRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Rate.class)) {
                return clazz.cast(new io.realm.RateRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
                return clazz.cast(new io.realm.InfoGuiaRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Account.class)) {
                return clazz.cast(new io.realm.AccountRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Guide.class)) {
                return clazz.cast(new io.realm.GuideRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
                return clazz.cast(new io.realm.InvoiceRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
                return clazz.cast(new io.realm.ProductOrderRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
                return clazz.cast(new io.realm.GeoLocationRealmProxy());
            }
            if (clazz.equals(com.mobile.polux.models.Product.class)) {
                return clazz.cast(new io.realm.ProductRealmProxy());
            }
            throw getMissingProxyClassException(clazz);
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
            return clazz.cast(io.realm.CashingGuideDetailRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.CashingGuideDetail) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
            return clazz.cast(io.realm.PaymentDocRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.PaymentDoc) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Client.class)) {
            return clazz.cast(io.realm.ClientRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Client) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Payment.class)) {
            return clazz.cast(io.realm.PaymentRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Payment) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Contact.class)) {
            return clazz.cast(io.realm.ContactRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Contact) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Bank.class)) {
            return clazz.cast(io.realm.BankRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Bank) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
            return clazz.cast(io.realm.ProductInvoiceRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.ProductInvoice) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Location.class)) {
            return clazz.cast(io.realm.LocationRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Location) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Order.class)) {
            return clazz.cast(io.realm.OrderRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Order) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
            return clazz.cast(io.realm.ParameterRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Parameter) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
            return clazz.cast(io.realm.ProductPromotionOrderRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.ProductPromotionOrder) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Filter.class)) {
            return clazz.cast(io.realm.FilterRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Filter) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Rate.class)) {
            return clazz.cast(io.realm.RateRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Rate) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
            return clazz.cast(io.realm.InfoGuiaRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.InfoGuia) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Account.class)) {
            return clazz.cast(io.realm.AccountRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Account) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Guide.class)) {
            return clazz.cast(io.realm.GuideRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Guide) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
            return clazz.cast(io.realm.InvoiceRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Invoice) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
            return clazz.cast(io.realm.ProductOrderRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.ProductOrder) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
            return clazz.cast(io.realm.GeoLocationRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.GeoLocation) obj, update, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Product.class)) {
            return clazz.cast(io.realm.ProductRealmProxy.copyOrUpdate(realm, (com.mobile.polux.models.Product) obj, update, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
            io.realm.CashingGuideDetailRealmProxy.insert(realm, (com.mobile.polux.models.CashingGuideDetail) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
            io.realm.PaymentDocRealmProxy.insert(realm, (com.mobile.polux.models.PaymentDoc) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Client.class)) {
            io.realm.ClientRealmProxy.insert(realm, (com.mobile.polux.models.Client) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Payment.class)) {
            io.realm.PaymentRealmProxy.insert(realm, (com.mobile.polux.models.Payment) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Contact.class)) {
            io.realm.ContactRealmProxy.insert(realm, (com.mobile.polux.models.Contact) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Bank.class)) {
            io.realm.BankRealmProxy.insert(realm, (com.mobile.polux.models.Bank) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
            io.realm.ProductInvoiceRealmProxy.insert(realm, (com.mobile.polux.models.ProductInvoice) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Location.class)) {
            io.realm.LocationRealmProxy.insert(realm, (com.mobile.polux.models.Location) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Order.class)) {
            io.realm.OrderRealmProxy.insert(realm, (com.mobile.polux.models.Order) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
            io.realm.ParameterRealmProxy.insert(realm, (com.mobile.polux.models.Parameter) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
            io.realm.ProductPromotionOrderRealmProxy.insert(realm, (com.mobile.polux.models.ProductPromotionOrder) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Filter.class)) {
            io.realm.FilterRealmProxy.insert(realm, (com.mobile.polux.models.Filter) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Rate.class)) {
            io.realm.RateRealmProxy.insert(realm, (com.mobile.polux.models.Rate) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
            io.realm.InfoGuiaRealmProxy.insert(realm, (com.mobile.polux.models.InfoGuia) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Account.class)) {
            io.realm.AccountRealmProxy.insert(realm, (com.mobile.polux.models.Account) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Guide.class)) {
            io.realm.GuideRealmProxy.insert(realm, (com.mobile.polux.models.Guide) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
            io.realm.InvoiceRealmProxy.insert(realm, (com.mobile.polux.models.Invoice) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
            io.realm.ProductOrderRealmProxy.insert(realm, (com.mobile.polux.models.ProductOrder) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
            io.realm.GeoLocationRealmProxy.insert(realm, (com.mobile.polux.models.GeoLocation) object, cache);
        } else if (clazz.equals(com.mobile.polux.models.Product.class)) {
            io.realm.ProductRealmProxy.insert(realm, (com.mobile.polux.models.Product) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
                io.realm.CashingGuideDetailRealmProxy.insert(realm, (com.mobile.polux.models.CashingGuideDetail) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
                io.realm.PaymentDocRealmProxy.insert(realm, (com.mobile.polux.models.PaymentDoc) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Client.class)) {
                io.realm.ClientRealmProxy.insert(realm, (com.mobile.polux.models.Client) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Payment.class)) {
                io.realm.PaymentRealmProxy.insert(realm, (com.mobile.polux.models.Payment) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Contact.class)) {
                io.realm.ContactRealmProxy.insert(realm, (com.mobile.polux.models.Contact) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Bank.class)) {
                io.realm.BankRealmProxy.insert(realm, (com.mobile.polux.models.Bank) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
                io.realm.ProductInvoiceRealmProxy.insert(realm, (com.mobile.polux.models.ProductInvoice) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Location.class)) {
                io.realm.LocationRealmProxy.insert(realm, (com.mobile.polux.models.Location) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Order.class)) {
                io.realm.OrderRealmProxy.insert(realm, (com.mobile.polux.models.Order) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
                io.realm.ParameterRealmProxy.insert(realm, (com.mobile.polux.models.Parameter) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
                io.realm.ProductPromotionOrderRealmProxy.insert(realm, (com.mobile.polux.models.ProductPromotionOrder) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Filter.class)) {
                io.realm.FilterRealmProxy.insert(realm, (com.mobile.polux.models.Filter) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Rate.class)) {
                io.realm.RateRealmProxy.insert(realm, (com.mobile.polux.models.Rate) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
                io.realm.InfoGuiaRealmProxy.insert(realm, (com.mobile.polux.models.InfoGuia) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Account.class)) {
                io.realm.AccountRealmProxy.insert(realm, (com.mobile.polux.models.Account) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Guide.class)) {
                io.realm.GuideRealmProxy.insert(realm, (com.mobile.polux.models.Guide) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
                io.realm.InvoiceRealmProxy.insert(realm, (com.mobile.polux.models.Invoice) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
                io.realm.ProductOrderRealmProxy.insert(realm, (com.mobile.polux.models.ProductOrder) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
                io.realm.GeoLocationRealmProxy.insert(realm, (com.mobile.polux.models.GeoLocation) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Product.class)) {
                io.realm.ProductRealmProxy.insert(realm, (com.mobile.polux.models.Product) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
                    io.realm.CashingGuideDetailRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
                    io.realm.PaymentDocRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Client.class)) {
                    io.realm.ClientRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Payment.class)) {
                    io.realm.PaymentRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Contact.class)) {
                    io.realm.ContactRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Bank.class)) {
                    io.realm.BankRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
                    io.realm.ProductInvoiceRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Location.class)) {
                    io.realm.LocationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Order.class)) {
                    io.realm.OrderRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
                    io.realm.ParameterRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
                    io.realm.ProductPromotionOrderRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Filter.class)) {
                    io.realm.FilterRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Rate.class)) {
                    io.realm.RateRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
                    io.realm.InfoGuiaRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Account.class)) {
                    io.realm.AccountRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Guide.class)) {
                    io.realm.GuideRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
                    io.realm.InvoiceRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
                    io.realm.ProductOrderRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
                    io.realm.GeoLocationRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Product.class)) {
                    io.realm.ProductRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
            io.realm.CashingGuideDetailRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.CashingGuideDetail) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
            io.realm.PaymentDocRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.PaymentDoc) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Client.class)) {
            io.realm.ClientRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Client) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Payment.class)) {
            io.realm.PaymentRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Payment) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Contact.class)) {
            io.realm.ContactRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Contact) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Bank.class)) {
            io.realm.BankRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Bank) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
            io.realm.ProductInvoiceRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.ProductInvoice) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Location.class)) {
            io.realm.LocationRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Location) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Order.class)) {
            io.realm.OrderRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Order) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
            io.realm.ParameterRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Parameter) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
            io.realm.ProductPromotionOrderRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.ProductPromotionOrder) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Filter.class)) {
            io.realm.FilterRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Filter) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Rate.class)) {
            io.realm.RateRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Rate) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
            io.realm.InfoGuiaRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.InfoGuia) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Account.class)) {
            io.realm.AccountRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Account) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Guide.class)) {
            io.realm.GuideRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Guide) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
            io.realm.InvoiceRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Invoice) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
            io.realm.ProductOrderRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.ProductOrder) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
            io.realm.GeoLocationRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.GeoLocation) obj, cache);
        } else if (clazz.equals(com.mobile.polux.models.Product.class)) {
            io.realm.ProductRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Product) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
                io.realm.CashingGuideDetailRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.CashingGuideDetail) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
                io.realm.PaymentDocRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.PaymentDoc) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Client.class)) {
                io.realm.ClientRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Client) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Payment.class)) {
                io.realm.PaymentRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Payment) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Contact.class)) {
                io.realm.ContactRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Contact) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Bank.class)) {
                io.realm.BankRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Bank) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
                io.realm.ProductInvoiceRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.ProductInvoice) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Location.class)) {
                io.realm.LocationRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Location) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Order.class)) {
                io.realm.OrderRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Order) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
                io.realm.ParameterRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Parameter) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
                io.realm.ProductPromotionOrderRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.ProductPromotionOrder) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Filter.class)) {
                io.realm.FilterRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Filter) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Rate.class)) {
                io.realm.RateRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Rate) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
                io.realm.InfoGuiaRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.InfoGuia) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Account.class)) {
                io.realm.AccountRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Account) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Guide.class)) {
                io.realm.GuideRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Guide) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
                io.realm.InvoiceRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Invoice) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
                io.realm.ProductOrderRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.ProductOrder) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
                io.realm.GeoLocationRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.GeoLocation) object, cache);
            } else if (clazz.equals(com.mobile.polux.models.Product.class)) {
                io.realm.ProductRealmProxy.insertOrUpdate(realm, (com.mobile.polux.models.Product) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
                    io.realm.CashingGuideDetailRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
                    io.realm.PaymentDocRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Client.class)) {
                    io.realm.ClientRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Payment.class)) {
                    io.realm.PaymentRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Contact.class)) {
                    io.realm.ContactRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Bank.class)) {
                    io.realm.BankRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
                    io.realm.ProductInvoiceRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Location.class)) {
                    io.realm.LocationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Order.class)) {
                    io.realm.OrderRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
                    io.realm.ParameterRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
                    io.realm.ProductPromotionOrderRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Filter.class)) {
                    io.realm.FilterRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Rate.class)) {
                    io.realm.RateRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
                    io.realm.InfoGuiaRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Account.class)) {
                    io.realm.AccountRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Guide.class)) {
                    io.realm.GuideRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
                    io.realm.InvoiceRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
                    io.realm.ProductOrderRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
                    io.realm.GeoLocationRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.mobile.polux.models.Product.class)) {
                    io.realm.ProductRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
            return clazz.cast(io.realm.CashingGuideDetailRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
            return clazz.cast(io.realm.PaymentDocRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Client.class)) {
            return clazz.cast(io.realm.ClientRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Payment.class)) {
            return clazz.cast(io.realm.PaymentRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Contact.class)) {
            return clazz.cast(io.realm.ContactRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Bank.class)) {
            return clazz.cast(io.realm.BankRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
            return clazz.cast(io.realm.ProductInvoiceRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Location.class)) {
            return clazz.cast(io.realm.LocationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Order.class)) {
            return clazz.cast(io.realm.OrderRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
            return clazz.cast(io.realm.ParameterRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
            return clazz.cast(io.realm.ProductPromotionOrderRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Filter.class)) {
            return clazz.cast(io.realm.FilterRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Rate.class)) {
            return clazz.cast(io.realm.RateRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
            return clazz.cast(io.realm.InfoGuiaRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Account.class)) {
            return clazz.cast(io.realm.AccountRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Guide.class)) {
            return clazz.cast(io.realm.GuideRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
            return clazz.cast(io.realm.InvoiceRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
            return clazz.cast(io.realm.ProductOrderRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
            return clazz.cast(io.realm.GeoLocationRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        if (clazz.equals(com.mobile.polux.models.Product.class)) {
            return clazz.cast(io.realm.ProductRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
            return clazz.cast(io.realm.CashingGuideDetailRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
            return clazz.cast(io.realm.PaymentDocRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Client.class)) {
            return clazz.cast(io.realm.ClientRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Payment.class)) {
            return clazz.cast(io.realm.PaymentRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Contact.class)) {
            return clazz.cast(io.realm.ContactRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Bank.class)) {
            return clazz.cast(io.realm.BankRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
            return clazz.cast(io.realm.ProductInvoiceRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Location.class)) {
            return clazz.cast(io.realm.LocationRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Order.class)) {
            return clazz.cast(io.realm.OrderRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
            return clazz.cast(io.realm.ParameterRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
            return clazz.cast(io.realm.ProductPromotionOrderRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Filter.class)) {
            return clazz.cast(io.realm.FilterRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Rate.class)) {
            return clazz.cast(io.realm.RateRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
            return clazz.cast(io.realm.InfoGuiaRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Account.class)) {
            return clazz.cast(io.realm.AccountRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Guide.class)) {
            return clazz.cast(io.realm.GuideRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
            return clazz.cast(io.realm.InvoiceRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
            return clazz.cast(io.realm.ProductOrderRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
            return clazz.cast(io.realm.GeoLocationRealmProxy.createUsingJsonStream(realm, reader));
        }
        if (clazz.equals(com.mobile.polux.models.Product.class)) {
            return clazz.cast(io.realm.ProductRealmProxy.createUsingJsonStream(realm, reader));
        }
        throw getMissingProxyClassException(clazz);
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.mobile.polux.models.CashingGuideDetail.class)) {
            return clazz.cast(io.realm.CashingGuideDetailRealmProxy.createDetachedCopy((com.mobile.polux.models.CashingGuideDetail) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.PaymentDoc.class)) {
            return clazz.cast(io.realm.PaymentDocRealmProxy.createDetachedCopy((com.mobile.polux.models.PaymentDoc) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Client.class)) {
            return clazz.cast(io.realm.ClientRealmProxy.createDetachedCopy((com.mobile.polux.models.Client) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Payment.class)) {
            return clazz.cast(io.realm.PaymentRealmProxy.createDetachedCopy((com.mobile.polux.models.Payment) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Contact.class)) {
            return clazz.cast(io.realm.ContactRealmProxy.createDetachedCopy((com.mobile.polux.models.Contact) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Bank.class)) {
            return clazz.cast(io.realm.BankRealmProxy.createDetachedCopy((com.mobile.polux.models.Bank) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.ProductInvoice.class)) {
            return clazz.cast(io.realm.ProductInvoiceRealmProxy.createDetachedCopy((com.mobile.polux.models.ProductInvoice) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Location.class)) {
            return clazz.cast(io.realm.LocationRealmProxy.createDetachedCopy((com.mobile.polux.models.Location) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Order.class)) {
            return clazz.cast(io.realm.OrderRealmProxy.createDetachedCopy((com.mobile.polux.models.Order) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Parameter.class)) {
            return clazz.cast(io.realm.ParameterRealmProxy.createDetachedCopy((com.mobile.polux.models.Parameter) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.ProductPromotionOrder.class)) {
            return clazz.cast(io.realm.ProductPromotionOrderRealmProxy.createDetachedCopy((com.mobile.polux.models.ProductPromotionOrder) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Filter.class)) {
            return clazz.cast(io.realm.FilterRealmProxy.createDetachedCopy((com.mobile.polux.models.Filter) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Rate.class)) {
            return clazz.cast(io.realm.RateRealmProxy.createDetachedCopy((com.mobile.polux.models.Rate) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.InfoGuia.class)) {
            return clazz.cast(io.realm.InfoGuiaRealmProxy.createDetachedCopy((com.mobile.polux.models.InfoGuia) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Account.class)) {
            return clazz.cast(io.realm.AccountRealmProxy.createDetachedCopy((com.mobile.polux.models.Account) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Guide.class)) {
            return clazz.cast(io.realm.GuideRealmProxy.createDetachedCopy((com.mobile.polux.models.Guide) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Invoice.class)) {
            return clazz.cast(io.realm.InvoiceRealmProxy.createDetachedCopy((com.mobile.polux.models.Invoice) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.ProductOrder.class)) {
            return clazz.cast(io.realm.ProductOrderRealmProxy.createDetachedCopy((com.mobile.polux.models.ProductOrder) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.GeoLocation.class)) {
            return clazz.cast(io.realm.GeoLocationRealmProxy.createDetachedCopy((com.mobile.polux.models.GeoLocation) realmObject, 0, maxDepth, cache));
        }
        if (clazz.equals(com.mobile.polux.models.Product.class)) {
            return clazz.cast(io.realm.ProductRealmProxy.createDetachedCopy((com.mobile.polux.models.Product) realmObject, 0, maxDepth, cache));
        }
        throw getMissingProxyClassException(clazz);
    }

}
