package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.OsObject;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InvoiceRealmProxy extends com.mobile.polux.models.Invoice
    implements RealmObjectProxy, InvoiceRealmProxyInterface {

    static final class InvoiceColumnInfo extends ColumnInfo {
        long pkIndex;
        long idIndex;
        long orderIndex;
        long codigoComprobanteIndex;
        long ivaIndex;
        long discountIndex;
        long subTotalIndex;
        long totalIndex;
        long dueIndex;
        long payIndex;
        long stateIndex;
        long guideIndex;
        long fechaVencimientoIndex;
        long fechaIndex;
        long pagoIndex;
        long productsIndex;

        InvoiceColumnInfo(SharedRealm realm, Table table) {
            super(16);
            this.pkIndex = addColumnDetails(table, "pk", RealmFieldType.INTEGER);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.orderIndex = addColumnDetails(table, "order", RealmFieldType.INTEGER);
            this.codigoComprobanteIndex = addColumnDetails(table, "codigoComprobante", RealmFieldType.STRING);
            this.ivaIndex = addColumnDetails(table, "iva", RealmFieldType.DOUBLE);
            this.discountIndex = addColumnDetails(table, "discount", RealmFieldType.DOUBLE);
            this.subTotalIndex = addColumnDetails(table, "subTotal", RealmFieldType.DOUBLE);
            this.totalIndex = addColumnDetails(table, "total", RealmFieldType.DOUBLE);
            this.dueIndex = addColumnDetails(table, "due", RealmFieldType.DOUBLE);
            this.payIndex = addColumnDetails(table, "pay", RealmFieldType.DOUBLE);
            this.stateIndex = addColumnDetails(table, "state", RealmFieldType.STRING);
            this.guideIndex = addColumnDetails(table, "guide", RealmFieldType.INTEGER);
            this.fechaVencimientoIndex = addColumnDetails(table, "fechaVencimiento", RealmFieldType.STRING);
            this.fechaIndex = addColumnDetails(table, "fecha", RealmFieldType.STRING);
            this.pagoIndex = addColumnDetails(table, "pago", RealmFieldType.LIST);
            this.productsIndex = addColumnDetails(table, "products", RealmFieldType.LIST);
        }

        InvoiceColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new InvoiceColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final InvoiceColumnInfo src = (InvoiceColumnInfo) rawSrc;
            final InvoiceColumnInfo dst = (InvoiceColumnInfo) rawDst;
            dst.pkIndex = src.pkIndex;
            dst.idIndex = src.idIndex;
            dst.orderIndex = src.orderIndex;
            dst.codigoComprobanteIndex = src.codigoComprobanteIndex;
            dst.ivaIndex = src.ivaIndex;
            dst.discountIndex = src.discountIndex;
            dst.subTotalIndex = src.subTotalIndex;
            dst.totalIndex = src.totalIndex;
            dst.dueIndex = src.dueIndex;
            dst.payIndex = src.payIndex;
            dst.stateIndex = src.stateIndex;
            dst.guideIndex = src.guideIndex;
            dst.fechaVencimientoIndex = src.fechaVencimientoIndex;
            dst.fechaIndex = src.fechaIndex;
            dst.pagoIndex = src.pagoIndex;
            dst.productsIndex = src.productsIndex;
        }
    }

    private InvoiceColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Invoice> proxyState;
    private RealmList<com.mobile.polux.models.PaymentDoc> pagoRealmList;
    private RealmList<com.mobile.polux.models.ProductInvoice> productsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("pk");
        fieldNames.add("id");
        fieldNames.add("order");
        fieldNames.add("codigoComprobante");
        fieldNames.add("iva");
        fieldNames.add("discount");
        fieldNames.add("subTotal");
        fieldNames.add("total");
        fieldNames.add("due");
        fieldNames.add("pay");
        fieldNames.add("state");
        fieldNames.add("guide");
        fieldNames.add("fechaVencimiento");
        fieldNames.add("fecha");
        fieldNames.add("pago");
        fieldNames.add("products");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    InvoiceRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (InvoiceColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Invoice>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$pk() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.pkIndex);
    }

    @Override
    public void realmSet$pk(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'pk' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$order() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.orderIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.orderIndex);
    }

    @Override
    public void realmSet$order(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.orderIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.orderIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.orderIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.orderIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$codigoComprobante() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.codigoComprobanteIndex);
    }

    @Override
    public void realmSet$codigoComprobante(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoComprobanteIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.codigoComprobanteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoComprobanteIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.codigoComprobanteIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$iva() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.ivaIndex);
    }

    @Override
    public void realmSet$iva(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.ivaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.ivaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$discount() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.discountIndex);
    }

    @Override
    public void realmSet$discount(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.discountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.discountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$subTotal() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.subTotalIndex);
    }

    @Override
    public void realmSet$subTotal(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.subTotalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.subTotalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$total() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.totalIndex);
    }

    @Override
    public void realmSet$total(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.totalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.totalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$due() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.dueIndex);
    }

    @Override
    public void realmSet$due(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.dueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.dueIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$pay() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.payIndex);
    }

    @Override
    public void realmSet$pay(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.payIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.payIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$state() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stateIndex);
    }

    @Override
    public void realmSet$state(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.stateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.stateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$guide() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.guideIndex);
    }

    @Override
    public void realmSet$guide(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.guideIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.guideIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fechaVencimiento() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fechaVencimientoIndex);
    }

    @Override
    public void realmSet$fechaVencimiento(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fechaVencimientoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fechaVencimientoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fechaVencimientoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fechaVencimientoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fechaIndex);
    }

    @Override
    public void realmSet$fecha(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fechaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fechaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fechaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fechaIndex, value);
    }

    @Override
    public RealmList<com.mobile.polux.models.PaymentDoc> realmGet$pago() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (pagoRealmList != null) {
            return pagoRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.pagoIndex);
            pagoRealmList = new RealmList<com.mobile.polux.models.PaymentDoc>(com.mobile.polux.models.PaymentDoc.class, linkView, proxyState.getRealm$realm());
            return pagoRealmList;
        }
    }

    @Override
    public void realmSet$pago(RealmList<com.mobile.polux.models.PaymentDoc> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("pago")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.mobile.polux.models.PaymentDoc> original = value;
                value = new RealmList<com.mobile.polux.models.PaymentDoc>();
                for (com.mobile.polux.models.PaymentDoc item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.pagoIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    @Override
    public RealmList<com.mobile.polux.models.ProductInvoice> realmGet$products() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (productsRealmList != null) {
            return productsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.productsIndex);
            productsRealmList = new RealmList<com.mobile.polux.models.ProductInvoice>(com.mobile.polux.models.ProductInvoice.class, linkView, proxyState.getRealm$realm());
            return productsRealmList;
        }
    }

    @Override
    public void realmSet$products(RealmList<com.mobile.polux.models.ProductInvoice> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("products")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.mobile.polux.models.ProductInvoice> original = value;
                value = new RealmList<com.mobile.polux.models.ProductInvoice>();
                for (com.mobile.polux.models.ProductInvoice item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.productsIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Invoice")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Invoice");
            realmObjectSchema.add("pk", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("order", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoComprobante", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("iva", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("discount", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("subTotal", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("total", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("due", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("pay", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("state", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("guide", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("fechaVencimiento", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("fecha", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("PaymentDoc")) {
                PaymentDocRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("pago", RealmFieldType.LIST, realmSchema.get("PaymentDoc"));
            if (!realmSchema.contains("ProductInvoice")) {
                ProductInvoiceRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("products", RealmFieldType.LIST, realmSchema.get("ProductInvoice"));
            return realmObjectSchema;
        }
        return realmSchema.get("Invoice");
    }

    public static InvoiceColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Invoice")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Invoice' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Invoice");
        final long columnCount = table.getColumnCount();
        if (columnCount != 16) {
            if (columnCount < 16) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 16 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 16 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 16 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final InvoiceColumnInfo columnInfo = new InvoiceColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'pk' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.pkIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field pk");
            }
        }

        if (!columnTypes.containsKey("pk")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'pk' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("pk") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'pk' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.pkIndex) && table.findFirstNull(columnInfo.pkIndex) != Table.NO_MATCH) {
            throw new IllegalStateException("Cannot migrate an object with null value in field 'pk'. Either maintain the same type for primary key field 'pk', or remove the object with null value before migration.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("pk"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'pk' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'id' does support null values in the existing Realm file. Use corresponding boxed type for field 'id' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("order")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'order' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("order") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'order' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.orderIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'order' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'order' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoComprobante")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoComprobante' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoComprobante") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'codigoComprobante' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoComprobanteIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'codigoComprobante' is required. Either set @Required to field 'codigoComprobante' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("iva")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iva' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("iva") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'iva' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.ivaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iva' does support null values in the existing Realm file. Use corresponding boxed type for field 'iva' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("discount")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'discount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("discount") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'discount' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.discountIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'discount' does support null values in the existing Realm file. Use corresponding boxed type for field 'discount' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("subTotal")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'subTotal' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("subTotal") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'subTotal' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.subTotalIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'subTotal' does support null values in the existing Realm file. Use corresponding boxed type for field 'subTotal' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("total")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'total' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("total") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'total' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'total' does support null values in the existing Realm file. Use corresponding boxed type for field 'total' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("due")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'due' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("due") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'due' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.dueIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'due' does support null values in the existing Realm file. Use corresponding boxed type for field 'due' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("pay")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'pay' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("pay") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'pay' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.payIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'pay' does support null values in the existing Realm file. Use corresponding boxed type for field 'pay' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("state")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'state' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("state") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'state' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.stateIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'state' is required. Either set @Required to field 'state' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("guide")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'guide' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("guide") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'guide' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.guideIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'guide' does support null values in the existing Realm file. Use corresponding boxed type for field 'guide' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("fechaVencimiento")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fechaVencimiento' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fechaVencimiento") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fechaVencimiento' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.fechaVencimientoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fechaVencimiento' is required. Either set @Required to field 'fechaVencimiento' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("fecha")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fecha' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fecha") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fecha' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.fechaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fecha' is required. Either set @Required to field 'fecha' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("pago")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'pago'");
        }
        if (columnTypes.get("pago") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'PaymentDoc' for field 'pago'");
        }
        if (!sharedRealm.hasTable("class_PaymentDoc")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_PaymentDoc' for field 'pago'");
        }
        Table table_14 = sharedRealm.getTable("class_PaymentDoc");
        if (!table.getLinkTarget(columnInfo.pagoIndex).hasSameSchema(table_14)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'pago': '" + table.getLinkTarget(columnInfo.pagoIndex).getName() + "' expected - was '" + table_14.getName() + "'");
        }
        if (!columnTypes.containsKey("products")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'products'");
        }
        if (columnTypes.get("products") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'ProductInvoice' for field 'products'");
        }
        if (!sharedRealm.hasTable("class_ProductInvoice")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_ProductInvoice' for field 'products'");
        }
        Table table_15 = sharedRealm.getTable("class_ProductInvoice");
        if (!table.getLinkTarget(columnInfo.productsIndex).hasSameSchema(table_15)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'products': '" + table.getLinkTarget(columnInfo.productsIndex).getName() + "' expected - was '" + table_15.getName() + "'");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Invoice";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Invoice createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(2);
        com.mobile.polux.models.Invoice obj = null;
        if (update) {
            Table table = realm.getTable(com.mobile.polux.models.Invoice.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("pk")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("pk"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Invoice.class), false, Collections.<String> emptyList());
                    obj = new io.realm.InvoiceRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("pago")) {
                excludeFields.add("pago");
            }
            if (json.has("products")) {
                excludeFields.add("products");
            }
            if (json.has("pk")) {
                if (json.isNull("pk")) {
                    obj = (io.realm.InvoiceRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Invoice.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.InvoiceRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Invoice.class, json.getInt("pk"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pk'.");
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("order")) {
            if (json.isNull("order")) {
                ((InvoiceRealmProxyInterface) obj).realmSet$order(null);
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$order((int) json.getInt("order"));
            }
        }
        if (json.has("codigoComprobante")) {
            if (json.isNull("codigoComprobante")) {
                ((InvoiceRealmProxyInterface) obj).realmSet$codigoComprobante(null);
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$codigoComprobante((String) json.getString("codigoComprobante"));
            }
        }
        if (json.has("iva")) {
            if (json.isNull("iva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'iva' to null.");
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$iva((double) json.getDouble("iva"));
            }
        }
        if (json.has("discount")) {
            if (json.isNull("discount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'discount' to null.");
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$discount((double) json.getDouble("discount"));
            }
        }
        if (json.has("subTotal")) {
            if (json.isNull("subTotal")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'subTotal' to null.");
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$subTotal((double) json.getDouble("subTotal"));
            }
        }
        if (json.has("total")) {
            if (json.isNull("total")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'total' to null.");
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$total((double) json.getDouble("total"));
            }
        }
        if (json.has("due")) {
            if (json.isNull("due")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'due' to null.");
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$due((double) json.getDouble("due"));
            }
        }
        if (json.has("pay")) {
            if (json.isNull("pay")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'pay' to null.");
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$pay((double) json.getDouble("pay"));
            }
        }
        if (json.has("state")) {
            if (json.isNull("state")) {
                ((InvoiceRealmProxyInterface) obj).realmSet$state(null);
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$state((String) json.getString("state"));
            }
        }
        if (json.has("guide")) {
            if (json.isNull("guide")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'guide' to null.");
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$guide((long) json.getLong("guide"));
            }
        }
        if (json.has("fechaVencimiento")) {
            if (json.isNull("fechaVencimiento")) {
                ((InvoiceRealmProxyInterface) obj).realmSet$fechaVencimiento(null);
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$fechaVencimiento((String) json.getString("fechaVencimiento"));
            }
        }
        if (json.has("fecha")) {
            if (json.isNull("fecha")) {
                ((InvoiceRealmProxyInterface) obj).realmSet$fecha(null);
            } else {
                ((InvoiceRealmProxyInterface) obj).realmSet$fecha((String) json.getString("fecha"));
            }
        }
        if (json.has("pago")) {
            if (json.isNull("pago")) {
                ((InvoiceRealmProxyInterface) obj).realmSet$pago(null);
            } else {
                ((InvoiceRealmProxyInterface) obj).realmGet$pago().clear();
                JSONArray array = json.getJSONArray("pago");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.PaymentDoc item = PaymentDocRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((InvoiceRealmProxyInterface) obj).realmGet$pago().add(item);
                }
            }
        }
        if (json.has("products")) {
            if (json.isNull("products")) {
                ((InvoiceRealmProxyInterface) obj).realmSet$products(null);
            } else {
                ((InvoiceRealmProxyInterface) obj).realmGet$products().clear();
                JSONArray array = json.getJSONArray("products");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.ProductInvoice item = ProductInvoiceRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((InvoiceRealmProxyInterface) obj).realmGet$products().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Invoice createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mobile.polux.models.Invoice obj = new com.mobile.polux.models.Invoice();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("pk")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'pk' to null.");
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$pk((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("order")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InvoiceRealmProxyInterface) obj).realmSet$order(null);
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$order((int) reader.nextInt());
                }
            } else if (name.equals("codigoComprobante")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InvoiceRealmProxyInterface) obj).realmSet$codigoComprobante(null);
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$codigoComprobante((String) reader.nextString());
                }
            } else if (name.equals("iva")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'iva' to null.");
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$iva((double) reader.nextDouble());
                }
            } else if (name.equals("discount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'discount' to null.");
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$discount((double) reader.nextDouble());
                }
            } else if (name.equals("subTotal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'subTotal' to null.");
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$subTotal((double) reader.nextDouble());
                }
            } else if (name.equals("total")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'total' to null.");
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$total((double) reader.nextDouble());
                }
            } else if (name.equals("due")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'due' to null.");
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$due((double) reader.nextDouble());
                }
            } else if (name.equals("pay")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'pay' to null.");
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$pay((double) reader.nextDouble());
                }
            } else if (name.equals("state")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InvoiceRealmProxyInterface) obj).realmSet$state(null);
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$state((String) reader.nextString());
                }
            } else if (name.equals("guide")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'guide' to null.");
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$guide((long) reader.nextLong());
                }
            } else if (name.equals("fechaVencimiento")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InvoiceRealmProxyInterface) obj).realmSet$fechaVencimiento(null);
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$fechaVencimiento((String) reader.nextString());
                }
            } else if (name.equals("fecha")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InvoiceRealmProxyInterface) obj).realmSet$fecha(null);
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$fecha((String) reader.nextString());
                }
            } else if (name.equals("pago")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InvoiceRealmProxyInterface) obj).realmSet$pago(null);
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$pago(new RealmList<com.mobile.polux.models.PaymentDoc>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.PaymentDoc item = PaymentDocRealmProxy.createUsingJsonStream(realm, reader);
                        ((InvoiceRealmProxyInterface) obj).realmGet$pago().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("products")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InvoiceRealmProxyInterface) obj).realmSet$products(null);
                } else {
                    ((InvoiceRealmProxyInterface) obj).realmSet$products(new RealmList<com.mobile.polux.models.ProductInvoice>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.ProductInvoice item = ProductInvoiceRealmProxy.createUsingJsonStream(realm, reader);
                        ((InvoiceRealmProxyInterface) obj).realmGet$products().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pk'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.Invoice copyOrUpdate(Realm realm, com.mobile.polux.models.Invoice object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Invoice) cachedRealmObject;
        } else {
            com.mobile.polux.models.Invoice realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.mobile.polux.models.Invoice.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((InvoiceRealmProxyInterface) object).realmGet$pk());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Invoice.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.InvoiceRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.mobile.polux.models.Invoice copy(Realm realm, com.mobile.polux.models.Invoice newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Invoice) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Invoice realmObject = realm.createObjectInternal(com.mobile.polux.models.Invoice.class, ((InvoiceRealmProxyInterface) newObject).realmGet$pk(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((InvoiceRealmProxyInterface) realmObject).realmSet$id(((InvoiceRealmProxyInterface) newObject).realmGet$id());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$order(((InvoiceRealmProxyInterface) newObject).realmGet$order());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$codigoComprobante(((InvoiceRealmProxyInterface) newObject).realmGet$codigoComprobante());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$iva(((InvoiceRealmProxyInterface) newObject).realmGet$iva());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$discount(((InvoiceRealmProxyInterface) newObject).realmGet$discount());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$subTotal(((InvoiceRealmProxyInterface) newObject).realmGet$subTotal());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$total(((InvoiceRealmProxyInterface) newObject).realmGet$total());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$due(((InvoiceRealmProxyInterface) newObject).realmGet$due());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$pay(((InvoiceRealmProxyInterface) newObject).realmGet$pay());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$state(((InvoiceRealmProxyInterface) newObject).realmGet$state());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$guide(((InvoiceRealmProxyInterface) newObject).realmGet$guide());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$fechaVencimiento(((InvoiceRealmProxyInterface) newObject).realmGet$fechaVencimiento());
            ((InvoiceRealmProxyInterface) realmObject).realmSet$fecha(((InvoiceRealmProxyInterface) newObject).realmGet$fecha());

            RealmList<com.mobile.polux.models.PaymentDoc> pagoList = ((InvoiceRealmProxyInterface) newObject).realmGet$pago();
            if (pagoList != null) {
                RealmList<com.mobile.polux.models.PaymentDoc> pagoRealmList = ((InvoiceRealmProxyInterface) realmObject).realmGet$pago();
                for (int i = 0; i < pagoList.size(); i++) {
                    com.mobile.polux.models.PaymentDoc pagoItem = pagoList.get(i);
                    com.mobile.polux.models.PaymentDoc cachepago = (com.mobile.polux.models.PaymentDoc) cache.get(pagoItem);
                    if (cachepago != null) {
                        pagoRealmList.add(cachepago);
                    } else {
                        pagoRealmList.add(PaymentDocRealmProxy.copyOrUpdate(realm, pagoList.get(i), update, cache));
                    }
                }
            }


            RealmList<com.mobile.polux.models.ProductInvoice> productsList = ((InvoiceRealmProxyInterface) newObject).realmGet$products();
            if (productsList != null) {
                RealmList<com.mobile.polux.models.ProductInvoice> productsRealmList = ((InvoiceRealmProxyInterface) realmObject).realmGet$products();
                for (int i = 0; i < productsList.size(); i++) {
                    com.mobile.polux.models.ProductInvoice productsItem = productsList.get(i);
                    com.mobile.polux.models.ProductInvoice cacheproducts = (com.mobile.polux.models.ProductInvoice) cache.get(productsItem);
                    if (cacheproducts != null) {
                        productsRealmList.add(cacheproducts);
                    } else {
                        productsRealmList.add(ProductInvoiceRealmProxy.copyOrUpdate(realm, productsList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Invoice object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Invoice.class);
        long tableNativePtr = table.getNativePtr();
        InvoiceColumnInfo columnInfo = (InvoiceColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Invoice.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((InvoiceRealmProxyInterface) object).realmGet$pk();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((InvoiceRealmProxyInterface) object).realmGet$pk());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((InvoiceRealmProxyInterface) object).realmGet$pk());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$id(), false);
        Number realmGet$order = ((InvoiceRealmProxyInterface)object).realmGet$order();
        if (realmGet$order != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.orderIndex, rowIndex, realmGet$order.longValue(), false);
        }
        String realmGet$codigoComprobante = ((InvoiceRealmProxyInterface)object).realmGet$codigoComprobante();
        if (realmGet$codigoComprobante != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigoComprobanteIndex, rowIndex, realmGet$codigoComprobante, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$iva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$discount(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.subTotalIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$subTotal(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$total(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.dueIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$due(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.payIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$pay(), false);
        String realmGet$state = ((InvoiceRealmProxyInterface)object).realmGet$state();
        if (realmGet$state != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.guideIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$guide(), false);
        String realmGet$fechaVencimiento = ((InvoiceRealmProxyInterface)object).realmGet$fechaVencimiento();
        if (realmGet$fechaVencimiento != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaVencimientoIndex, rowIndex, realmGet$fechaVencimiento, false);
        }
        String realmGet$fecha = ((InvoiceRealmProxyInterface)object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
        }

        RealmList<com.mobile.polux.models.PaymentDoc> pagoList = ((InvoiceRealmProxyInterface) object).realmGet$pago();
        if (pagoList != null) {
            long pagoNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.pagoIndex, rowIndex);
            for (com.mobile.polux.models.PaymentDoc pagoItem : pagoList) {
                Long cacheItemIndexpago = cache.get(pagoItem);
                if (cacheItemIndexpago == null) {
                    cacheItemIndexpago = PaymentDocRealmProxy.insert(realm, pagoItem, cache);
                }
                LinkView.nativeAdd(pagoNativeLinkViewPtr, cacheItemIndexpago);
            }
        }


        RealmList<com.mobile.polux.models.ProductInvoice> productsList = ((InvoiceRealmProxyInterface) object).realmGet$products();
        if (productsList != null) {
            long productsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productsIndex, rowIndex);
            for (com.mobile.polux.models.ProductInvoice productsItem : productsList) {
                Long cacheItemIndexproducts = cache.get(productsItem);
                if (cacheItemIndexproducts == null) {
                    cacheItemIndexproducts = ProductInvoiceRealmProxy.insert(realm, productsItem, cache);
                }
                LinkView.nativeAdd(productsNativeLinkViewPtr, cacheItemIndexproducts);
            }
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Invoice.class);
        long tableNativePtr = table.getNativePtr();
        InvoiceColumnInfo columnInfo = (InvoiceColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Invoice.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Invoice object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Invoice) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((InvoiceRealmProxyInterface) object).realmGet$pk();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((InvoiceRealmProxyInterface) object).realmGet$pk());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((InvoiceRealmProxyInterface) object).realmGet$pk());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$id(), false);
                Number realmGet$order = ((InvoiceRealmProxyInterface)object).realmGet$order();
                if (realmGet$order != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.orderIndex, rowIndex, realmGet$order.longValue(), false);
                }
                String realmGet$codigoComprobante = ((InvoiceRealmProxyInterface)object).realmGet$codigoComprobante();
                if (realmGet$codigoComprobante != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codigoComprobanteIndex, rowIndex, realmGet$codigoComprobante, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$iva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$discount(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.subTotalIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$subTotal(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$total(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.dueIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$due(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.payIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$pay(), false);
                String realmGet$state = ((InvoiceRealmProxyInterface)object).realmGet$state();
                if (realmGet$state != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.guideIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$guide(), false);
                String realmGet$fechaVencimiento = ((InvoiceRealmProxyInterface)object).realmGet$fechaVencimiento();
                if (realmGet$fechaVencimiento != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaVencimientoIndex, rowIndex, realmGet$fechaVencimiento, false);
                }
                String realmGet$fecha = ((InvoiceRealmProxyInterface)object).realmGet$fecha();
                if (realmGet$fecha != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
                }

                RealmList<com.mobile.polux.models.PaymentDoc> pagoList = ((InvoiceRealmProxyInterface) object).realmGet$pago();
                if (pagoList != null) {
                    long pagoNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.pagoIndex, rowIndex);
                    for (com.mobile.polux.models.PaymentDoc pagoItem : pagoList) {
                        Long cacheItemIndexpago = cache.get(pagoItem);
                        if (cacheItemIndexpago == null) {
                            cacheItemIndexpago = PaymentDocRealmProxy.insert(realm, pagoItem, cache);
                        }
                        LinkView.nativeAdd(pagoNativeLinkViewPtr, cacheItemIndexpago);
                    }
                }


                RealmList<com.mobile.polux.models.ProductInvoice> productsList = ((InvoiceRealmProxyInterface) object).realmGet$products();
                if (productsList != null) {
                    long productsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productsIndex, rowIndex);
                    for (com.mobile.polux.models.ProductInvoice productsItem : productsList) {
                        Long cacheItemIndexproducts = cache.get(productsItem);
                        if (cacheItemIndexproducts == null) {
                            cacheItemIndexproducts = ProductInvoiceRealmProxy.insert(realm, productsItem, cache);
                        }
                        LinkView.nativeAdd(productsNativeLinkViewPtr, cacheItemIndexproducts);
                    }
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Invoice object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Invoice.class);
        long tableNativePtr = table.getNativePtr();
        InvoiceColumnInfo columnInfo = (InvoiceColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Invoice.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((InvoiceRealmProxyInterface) object).realmGet$pk();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((InvoiceRealmProxyInterface) object).realmGet$pk());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((InvoiceRealmProxyInterface) object).realmGet$pk());
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$id(), false);
        Number realmGet$order = ((InvoiceRealmProxyInterface)object).realmGet$order();
        if (realmGet$order != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.orderIndex, rowIndex, realmGet$order.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.orderIndex, rowIndex, false);
        }
        String realmGet$codigoComprobante = ((InvoiceRealmProxyInterface)object).realmGet$codigoComprobante();
        if (realmGet$codigoComprobante != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigoComprobanteIndex, rowIndex, realmGet$codigoComprobante, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoComprobanteIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$iva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$discount(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.subTotalIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$subTotal(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$total(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.dueIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$due(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.payIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$pay(), false);
        String realmGet$state = ((InvoiceRealmProxyInterface)object).realmGet$state();
        if (realmGet$state != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stateIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.guideIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$guide(), false);
        String realmGet$fechaVencimiento = ((InvoiceRealmProxyInterface)object).realmGet$fechaVencimiento();
        if (realmGet$fechaVencimiento != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaVencimientoIndex, rowIndex, realmGet$fechaVencimiento, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaVencimientoIndex, rowIndex, false);
        }
        String realmGet$fecha = ((InvoiceRealmProxyInterface)object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
        }

        long pagoNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.pagoIndex, rowIndex);
        LinkView.nativeClear(pagoNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.PaymentDoc> pagoList = ((InvoiceRealmProxyInterface) object).realmGet$pago();
        if (pagoList != null) {
            for (com.mobile.polux.models.PaymentDoc pagoItem : pagoList) {
                Long cacheItemIndexpago = cache.get(pagoItem);
                if (cacheItemIndexpago == null) {
                    cacheItemIndexpago = PaymentDocRealmProxy.insertOrUpdate(realm, pagoItem, cache);
                }
                LinkView.nativeAdd(pagoNativeLinkViewPtr, cacheItemIndexpago);
            }
        }


        long productsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productsIndex, rowIndex);
        LinkView.nativeClear(productsNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.ProductInvoice> productsList = ((InvoiceRealmProxyInterface) object).realmGet$products();
        if (productsList != null) {
            for (com.mobile.polux.models.ProductInvoice productsItem : productsList) {
                Long cacheItemIndexproducts = cache.get(productsItem);
                if (cacheItemIndexproducts == null) {
                    cacheItemIndexproducts = ProductInvoiceRealmProxy.insertOrUpdate(realm, productsItem, cache);
                }
                LinkView.nativeAdd(productsNativeLinkViewPtr, cacheItemIndexproducts);
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Invoice.class);
        long tableNativePtr = table.getNativePtr();
        InvoiceColumnInfo columnInfo = (InvoiceColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Invoice.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Invoice object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Invoice) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((InvoiceRealmProxyInterface) object).realmGet$pk();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((InvoiceRealmProxyInterface) object).realmGet$pk());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((InvoiceRealmProxyInterface) object).realmGet$pk());
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$id(), false);
                Number realmGet$order = ((InvoiceRealmProxyInterface)object).realmGet$order();
                if (realmGet$order != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.orderIndex, rowIndex, realmGet$order.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.orderIndex, rowIndex, false);
                }
                String realmGet$codigoComprobante = ((InvoiceRealmProxyInterface)object).realmGet$codigoComprobante();
                if (realmGet$codigoComprobante != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codigoComprobanteIndex, rowIndex, realmGet$codigoComprobante, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoComprobanteIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$iva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$discount(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.subTotalIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$subTotal(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$total(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.dueIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$due(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.payIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$pay(), false);
                String realmGet$state = ((InvoiceRealmProxyInterface)object).realmGet$state();
                if (realmGet$state != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.stateIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.guideIndex, rowIndex, ((InvoiceRealmProxyInterface)object).realmGet$guide(), false);
                String realmGet$fechaVencimiento = ((InvoiceRealmProxyInterface)object).realmGet$fechaVencimiento();
                if (realmGet$fechaVencimiento != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaVencimientoIndex, rowIndex, realmGet$fechaVencimiento, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.fechaVencimientoIndex, rowIndex, false);
                }
                String realmGet$fecha = ((InvoiceRealmProxyInterface)object).realmGet$fecha();
                if (realmGet$fecha != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
                }

                long pagoNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.pagoIndex, rowIndex);
                LinkView.nativeClear(pagoNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.PaymentDoc> pagoList = ((InvoiceRealmProxyInterface) object).realmGet$pago();
                if (pagoList != null) {
                    for (com.mobile.polux.models.PaymentDoc pagoItem : pagoList) {
                        Long cacheItemIndexpago = cache.get(pagoItem);
                        if (cacheItemIndexpago == null) {
                            cacheItemIndexpago = PaymentDocRealmProxy.insertOrUpdate(realm, pagoItem, cache);
                        }
                        LinkView.nativeAdd(pagoNativeLinkViewPtr, cacheItemIndexpago);
                    }
                }


                long productsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.productsIndex, rowIndex);
                LinkView.nativeClear(productsNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.ProductInvoice> productsList = ((InvoiceRealmProxyInterface) object).realmGet$products();
                if (productsList != null) {
                    for (com.mobile.polux.models.ProductInvoice productsItem : productsList) {
                        Long cacheItemIndexproducts = cache.get(productsItem);
                        if (cacheItemIndexproducts == null) {
                            cacheItemIndexproducts = ProductInvoiceRealmProxy.insertOrUpdate(realm, productsItem, cache);
                        }
                        LinkView.nativeAdd(productsNativeLinkViewPtr, cacheItemIndexproducts);
                    }
                }

            }
        }
    }

    public static com.mobile.polux.models.Invoice createDetachedCopy(com.mobile.polux.models.Invoice realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Invoice unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Invoice)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Invoice)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Invoice();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$pk(((InvoiceRealmProxyInterface) realmObject).realmGet$pk());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$id(((InvoiceRealmProxyInterface) realmObject).realmGet$id());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$order(((InvoiceRealmProxyInterface) realmObject).realmGet$order());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$codigoComprobante(((InvoiceRealmProxyInterface) realmObject).realmGet$codigoComprobante());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$iva(((InvoiceRealmProxyInterface) realmObject).realmGet$iva());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$discount(((InvoiceRealmProxyInterface) realmObject).realmGet$discount());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$subTotal(((InvoiceRealmProxyInterface) realmObject).realmGet$subTotal());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$total(((InvoiceRealmProxyInterface) realmObject).realmGet$total());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$due(((InvoiceRealmProxyInterface) realmObject).realmGet$due());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$pay(((InvoiceRealmProxyInterface) realmObject).realmGet$pay());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$state(((InvoiceRealmProxyInterface) realmObject).realmGet$state());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$guide(((InvoiceRealmProxyInterface) realmObject).realmGet$guide());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$fechaVencimiento(((InvoiceRealmProxyInterface) realmObject).realmGet$fechaVencimiento());
        ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$fecha(((InvoiceRealmProxyInterface) realmObject).realmGet$fecha());

        // Deep copy of pago
        if (currentDepth == maxDepth) {
            ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$pago(null);
        } else {
            RealmList<com.mobile.polux.models.PaymentDoc> managedpagoList = ((InvoiceRealmProxyInterface) realmObject).realmGet$pago();
            RealmList<com.mobile.polux.models.PaymentDoc> unmanagedpagoList = new RealmList<com.mobile.polux.models.PaymentDoc>();
            ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$pago(unmanagedpagoList);
            int nextDepth = currentDepth + 1;
            int size = managedpagoList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.PaymentDoc item = PaymentDocRealmProxy.createDetachedCopy(managedpagoList.get(i), nextDepth, maxDepth, cache);
                unmanagedpagoList.add(item);
            }
        }

        // Deep copy of products
        if (currentDepth == maxDepth) {
            ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$products(null);
        } else {
            RealmList<com.mobile.polux.models.ProductInvoice> managedproductsList = ((InvoiceRealmProxyInterface) realmObject).realmGet$products();
            RealmList<com.mobile.polux.models.ProductInvoice> unmanagedproductsList = new RealmList<com.mobile.polux.models.ProductInvoice>();
            ((InvoiceRealmProxyInterface) unmanagedObject).realmSet$products(unmanagedproductsList);
            int nextDepth = currentDepth + 1;
            int size = managedproductsList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.ProductInvoice item = ProductInvoiceRealmProxy.createDetachedCopy(managedproductsList.get(i), nextDepth, maxDepth, cache);
                unmanagedproductsList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.mobile.polux.models.Invoice update(Realm realm, com.mobile.polux.models.Invoice realmObject, com.mobile.polux.models.Invoice newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((InvoiceRealmProxyInterface) realmObject).realmSet$id(((InvoiceRealmProxyInterface) newObject).realmGet$id());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$order(((InvoiceRealmProxyInterface) newObject).realmGet$order());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$codigoComprobante(((InvoiceRealmProxyInterface) newObject).realmGet$codigoComprobante());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$iva(((InvoiceRealmProxyInterface) newObject).realmGet$iva());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$discount(((InvoiceRealmProxyInterface) newObject).realmGet$discount());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$subTotal(((InvoiceRealmProxyInterface) newObject).realmGet$subTotal());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$total(((InvoiceRealmProxyInterface) newObject).realmGet$total());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$due(((InvoiceRealmProxyInterface) newObject).realmGet$due());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$pay(((InvoiceRealmProxyInterface) newObject).realmGet$pay());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$state(((InvoiceRealmProxyInterface) newObject).realmGet$state());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$guide(((InvoiceRealmProxyInterface) newObject).realmGet$guide());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$fechaVencimiento(((InvoiceRealmProxyInterface) newObject).realmGet$fechaVencimiento());
        ((InvoiceRealmProxyInterface) realmObject).realmSet$fecha(((InvoiceRealmProxyInterface) newObject).realmGet$fecha());
        RealmList<com.mobile.polux.models.PaymentDoc> pagoList = ((InvoiceRealmProxyInterface) newObject).realmGet$pago();
        RealmList<com.mobile.polux.models.PaymentDoc> pagoRealmList = ((InvoiceRealmProxyInterface) realmObject).realmGet$pago();
        pagoRealmList.clear();
        if (pagoList != null) {
            for (int i = 0; i < pagoList.size(); i++) {
                com.mobile.polux.models.PaymentDoc pagoItem = pagoList.get(i);
                com.mobile.polux.models.PaymentDoc cachepago = (com.mobile.polux.models.PaymentDoc) cache.get(pagoItem);
                if (cachepago != null) {
                    pagoRealmList.add(cachepago);
                } else {
                    pagoRealmList.add(PaymentDocRealmProxy.copyOrUpdate(realm, pagoList.get(i), true, cache));
                }
            }
        }
        RealmList<com.mobile.polux.models.ProductInvoice> productsList = ((InvoiceRealmProxyInterface) newObject).realmGet$products();
        RealmList<com.mobile.polux.models.ProductInvoice> productsRealmList = ((InvoiceRealmProxyInterface) realmObject).realmGet$products();
        productsRealmList.clear();
        if (productsList != null) {
            for (int i = 0; i < productsList.size(); i++) {
                com.mobile.polux.models.ProductInvoice productsItem = productsList.get(i);
                com.mobile.polux.models.ProductInvoice cacheproducts = (com.mobile.polux.models.ProductInvoice) cache.get(productsItem);
                if (cacheproducts != null) {
                    productsRealmList.add(cacheproducts);
                } else {
                    productsRealmList.add(ProductInvoiceRealmProxy.copyOrUpdate(realm, productsList.get(i), true, cache));
                }
            }
        }
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Invoice = proxy[");
        stringBuilder.append("{pk:");
        stringBuilder.append(realmGet$pk());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{order:");
        stringBuilder.append(realmGet$order() != null ? realmGet$order() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoComprobante:");
        stringBuilder.append(realmGet$codigoComprobante() != null ? realmGet$codigoComprobante() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iva:");
        stringBuilder.append(realmGet$iva());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{discount:");
        stringBuilder.append(realmGet$discount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subTotal:");
        stringBuilder.append(realmGet$subTotal());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total:");
        stringBuilder.append(realmGet$total());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{due:");
        stringBuilder.append(realmGet$due());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pay:");
        stringBuilder.append(realmGet$pay());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{state:");
        stringBuilder.append(realmGet$state() != null ? realmGet$state() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{guide:");
        stringBuilder.append(realmGet$guide());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fechaVencimiento:");
        stringBuilder.append(realmGet$fechaVencimiento() != null ? realmGet$fechaVencimiento() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha:");
        stringBuilder.append(realmGet$fecha() != null ? realmGet$fecha() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pago:");
        stringBuilder.append("RealmList<PaymentDoc>[").append(realmGet$pago().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{products:");
        stringBuilder.append("RealmList<ProductInvoice>[").append(realmGet$products().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceRealmProxy aInvoice = (InvoiceRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aInvoice.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aInvoice.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aInvoice.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
