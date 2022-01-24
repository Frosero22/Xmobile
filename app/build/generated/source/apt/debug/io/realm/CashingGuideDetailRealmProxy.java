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

public class CashingGuideDetailRealmProxy extends com.mobile.polux.models.CashingGuideDetail
    implements RealmObjectProxy, CashingGuideDetailRealmProxyInterface {

    static final class CashingGuideDetailColumnInfo extends ColumnInfo {
        long idIndex;
        long clientIdIndex;
        long nameIndex;
        long addressIndex;
        long stateIndex;
        long collectedIndex;
        long pendingIndex;
        long totalDueIndex;
        long creditIndex;
        long dateIndex;
        long docXcobrarIndex;

        CashingGuideDetailColumnInfo(SharedRealm realm, Table table) {
            super(11);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.clientIdIndex = addColumnDetails(table, "clientId", RealmFieldType.INTEGER);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.addressIndex = addColumnDetails(table, "address", RealmFieldType.STRING);
            this.stateIndex = addColumnDetails(table, "state", RealmFieldType.STRING);
            this.collectedIndex = addColumnDetails(table, "collected", RealmFieldType.DOUBLE);
            this.pendingIndex = addColumnDetails(table, "pending", RealmFieldType.DOUBLE);
            this.totalDueIndex = addColumnDetails(table, "totalDue", RealmFieldType.DOUBLE);
            this.creditIndex = addColumnDetails(table, "credit", RealmFieldType.DOUBLE);
            this.dateIndex = addColumnDetails(table, "date", RealmFieldType.STRING);
            this.docXcobrarIndex = addColumnDetails(table, "docXcobrar", RealmFieldType.LIST);
        }

        CashingGuideDetailColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new CashingGuideDetailColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final CashingGuideDetailColumnInfo src = (CashingGuideDetailColumnInfo) rawSrc;
            final CashingGuideDetailColumnInfo dst = (CashingGuideDetailColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.clientIdIndex = src.clientIdIndex;
            dst.nameIndex = src.nameIndex;
            dst.addressIndex = src.addressIndex;
            dst.stateIndex = src.stateIndex;
            dst.collectedIndex = src.collectedIndex;
            dst.pendingIndex = src.pendingIndex;
            dst.totalDueIndex = src.totalDueIndex;
            dst.creditIndex = src.creditIndex;
            dst.dateIndex = src.dateIndex;
            dst.docXcobrarIndex = src.docXcobrarIndex;
        }
    }

    private CashingGuideDetailColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.CashingGuideDetail> proxyState;
    private RealmList<com.mobile.polux.models.Invoice> docXcobrarRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("clientId");
        fieldNames.add("name");
        fieldNames.add("address");
        fieldNames.add("state");
        fieldNames.add("collected");
        fieldNames.add("pending");
        fieldNames.add("totalDue");
        fieldNames.add("credit");
        fieldNames.add("date");
        fieldNames.add("docXcobrar");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CashingGuideDetailRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CashingGuideDetailColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.CashingGuideDetail>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$clientId() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.clientIdIndex);
    }

    @Override
    public void realmSet$clientId(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.clientIdIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.clientIdIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$name() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    @Override
    public void realmSet$name(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$address() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.addressIndex);
    }

    @Override
    public void realmSet$address(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.addressIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.addressIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.addressIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.addressIndex, value);
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
    public Double realmGet$collected() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.collectedIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.collectedIndex);
    }

    @Override
    public void realmSet$collected(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.collectedIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.collectedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.collectedIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.collectedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$pending() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.pendingIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.pendingIndex);
    }

    @Override
    public void realmSet$pending(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.pendingIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.pendingIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pendingIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.pendingIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$totalDue() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.totalDueIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.totalDueIndex);
    }

    @Override
    public void realmSet$totalDue(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.totalDueIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.totalDueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.totalDueIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.totalDueIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$credit() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.creditIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.creditIndex);
    }

    @Override
    public void realmSet$credit(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.creditIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.creditIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.creditIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.creditIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dateIndex);
    }

    @Override
    public void realmSet$date(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dateIndex, value);
    }

    @Override
    public RealmList<com.mobile.polux.models.Invoice> realmGet$docXcobrar() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (docXcobrarRealmList != null) {
            return docXcobrarRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.docXcobrarIndex);
            docXcobrarRealmList = new RealmList<com.mobile.polux.models.Invoice>(com.mobile.polux.models.Invoice.class, linkView, proxyState.getRealm$realm());
            return docXcobrarRealmList;
        }
    }

    @Override
    public void realmSet$docXcobrar(RealmList<com.mobile.polux.models.Invoice> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("docXcobrar")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.mobile.polux.models.Invoice> original = value;
                value = new RealmList<com.mobile.polux.models.Invoice>();
                for (com.mobile.polux.models.Invoice item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.docXcobrarIndex);
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
        if (!realmSchema.contains("CashingGuideDetail")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("CashingGuideDetail");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("clientId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("state", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("collected", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("pending", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("totalDue", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("credit", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("date", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("Invoice")) {
                InvoiceRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("docXcobrar", RealmFieldType.LIST, realmSchema.get("Invoice"));
            return realmObjectSchema;
        }
        return realmSchema.get("CashingGuideDetail");
    }

    public static CashingGuideDetailColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_CashingGuideDetail")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'CashingGuideDetail' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_CashingGuideDetail");
        final long columnCount = table.getColumnCount();
        if (columnCount != 11) {
            if (columnCount < 11) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 11 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 11 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 11 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final CashingGuideDetailColumnInfo columnInfo = new CashingGuideDetailColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.idIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field id");
            }
        }

        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'id' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.idIndex) && table.findFirstNull(columnInfo.idIndex) != Table.NO_MATCH) {
            throw new IllegalStateException("Cannot migrate an object with null value in field 'id'. Either maintain the same type for primary key field 'id', or remove the object with null value before migration.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("clientId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'clientId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("clientId") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'clientId' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.clientIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'clientId' does support null values in the existing Realm file. Use corresponding boxed type for field 'clientId' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("name")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("name") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("address")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'address' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("address") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'address' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.addressIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'address' is required. Either set @Required to field 'address' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("collected")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'collected' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("collected") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'collected' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.collectedIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'collected' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'collected' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("pending")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'pending' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("pending") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'pending' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.pendingIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'pending' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'pending' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("totalDue")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'totalDue' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("totalDue") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'totalDue' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.totalDueIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'totalDue' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'totalDue' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("credit")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'credit' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("credit") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'credit' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.creditIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'credit' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'credit' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("date")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'date' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("date") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'date' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.dateIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'date' is required. Either set @Required to field 'date' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("docXcobrar")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'docXcobrar'");
        }
        if (columnTypes.get("docXcobrar") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Invoice' for field 'docXcobrar'");
        }
        if (!sharedRealm.hasTable("class_Invoice")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Invoice' for field 'docXcobrar'");
        }
        Table table_10 = sharedRealm.getTable("class_Invoice");
        if (!table.getLinkTarget(columnInfo.docXcobrarIndex).hasSameSchema(table_10)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'docXcobrar': '" + table.getLinkTarget(columnInfo.docXcobrarIndex).getName() + "' expected - was '" + table_10.getName() + "'");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_CashingGuideDetail";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.CashingGuideDetail createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.mobile.polux.models.CashingGuideDetail obj = null;
        if (update) {
            Table table = realm.getTable(com.mobile.polux.models.CashingGuideDetail.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.CashingGuideDetail.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CashingGuideDetailRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("docXcobrar")) {
                excludeFields.add("docXcobrar");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.CashingGuideDetailRealmProxy) realm.createObjectInternal(com.mobile.polux.models.CashingGuideDetail.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CashingGuideDetailRealmProxy) realm.createObjectInternal(com.mobile.polux.models.CashingGuideDetail.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("clientId")) {
            if (json.isNull("clientId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clientId' to null.");
            } else {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$clientId((int) json.getInt("clientId"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$address(null);
            } else {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$address((String) json.getString("address"));
            }
        }
        if (json.has("state")) {
            if (json.isNull("state")) {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$state(null);
            } else {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$state((String) json.getString("state"));
            }
        }
        if (json.has("collected")) {
            if (json.isNull("collected")) {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$collected(null);
            } else {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$collected((double) json.getDouble("collected"));
            }
        }
        if (json.has("pending")) {
            if (json.isNull("pending")) {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$pending(null);
            } else {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$pending((double) json.getDouble("pending"));
            }
        }
        if (json.has("totalDue")) {
            if (json.isNull("totalDue")) {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$totalDue(null);
            } else {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$totalDue((double) json.getDouble("totalDue"));
            }
        }
        if (json.has("credit")) {
            if (json.isNull("credit")) {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$credit(null);
            } else {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$credit((double) json.getDouble("credit"));
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$date(null);
            } else {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$date((String) json.getString("date"));
            }
        }
        if (json.has("docXcobrar")) {
            if (json.isNull("docXcobrar")) {
                ((CashingGuideDetailRealmProxyInterface) obj).realmSet$docXcobrar(null);
            } else {
                ((CashingGuideDetailRealmProxyInterface) obj).realmGet$docXcobrar().clear();
                JSONArray array = json.getJSONArray("docXcobrar");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.Invoice item = InvoiceRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((CashingGuideDetailRealmProxyInterface) obj).realmGet$docXcobrar().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.CashingGuideDetail createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mobile.polux.models.CashingGuideDetail obj = new com.mobile.polux.models.CashingGuideDetail();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("clientId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clientId' to null.");
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$clientId((int) reader.nextInt());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("address")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$address(null);
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$address((String) reader.nextString());
                }
            } else if (name.equals("state")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$state(null);
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$state((String) reader.nextString());
                }
            } else if (name.equals("collected")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$collected(null);
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$collected((double) reader.nextDouble());
                }
            } else if (name.equals("pending")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$pending(null);
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$pending((double) reader.nextDouble());
                }
            } else if (name.equals("totalDue")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$totalDue(null);
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$totalDue((double) reader.nextDouble());
                }
            } else if (name.equals("credit")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$credit(null);
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$credit((double) reader.nextDouble());
                }
            } else if (name.equals("date")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$date(null);
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$date((String) reader.nextString());
                }
            } else if (name.equals("docXcobrar")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$docXcobrar(null);
                } else {
                    ((CashingGuideDetailRealmProxyInterface) obj).realmSet$docXcobrar(new RealmList<com.mobile.polux.models.Invoice>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.Invoice item = InvoiceRealmProxy.createUsingJsonStream(realm, reader);
                        ((CashingGuideDetailRealmProxyInterface) obj).realmGet$docXcobrar().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.CashingGuideDetail copyOrUpdate(Realm realm, com.mobile.polux.models.CashingGuideDetail object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.CashingGuideDetail) cachedRealmObject;
        } else {
            com.mobile.polux.models.CashingGuideDetail realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.mobile.polux.models.CashingGuideDetail.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((CashingGuideDetailRealmProxyInterface) object).realmGet$id());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.CashingGuideDetail.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CashingGuideDetailRealmProxy();
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

    public static com.mobile.polux.models.CashingGuideDetail copy(Realm realm, com.mobile.polux.models.CashingGuideDetail newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.CashingGuideDetail) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.CashingGuideDetail realmObject = realm.createObjectInternal(com.mobile.polux.models.CashingGuideDetail.class, ((CashingGuideDetailRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$clientId(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$clientId());
            ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$name(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$name());
            ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$address(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$address());
            ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$state(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$state());
            ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$collected(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$collected());
            ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$pending(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$pending());
            ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$totalDue(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$totalDue());
            ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$credit(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$credit());
            ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$date(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$date());

            RealmList<com.mobile.polux.models.Invoice> docXcobrarList = ((CashingGuideDetailRealmProxyInterface) newObject).realmGet$docXcobrar();
            if (docXcobrarList != null) {
                RealmList<com.mobile.polux.models.Invoice> docXcobrarRealmList = ((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$docXcobrar();
                for (int i = 0; i < docXcobrarList.size(); i++) {
                    com.mobile.polux.models.Invoice docXcobrarItem = docXcobrarList.get(i);
                    com.mobile.polux.models.Invoice cachedocXcobrar = (com.mobile.polux.models.Invoice) cache.get(docXcobrarItem);
                    if (cachedocXcobrar != null) {
                        docXcobrarRealmList.add(cachedocXcobrar);
                    } else {
                        docXcobrarRealmList.add(InvoiceRealmProxy.copyOrUpdate(realm, docXcobrarList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.CashingGuideDetail object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.CashingGuideDetail.class);
        long tableNativePtr = table.getNativePtr();
        CashingGuideDetailColumnInfo columnInfo = (CashingGuideDetailColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.CashingGuideDetail.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((CashingGuideDetailRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CashingGuideDetailRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((CashingGuideDetailRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clientIdIndex, rowIndex, ((CashingGuideDetailRealmProxyInterface)object).realmGet$clientId(), false);
        String realmGet$name = ((CashingGuideDetailRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$address = ((CashingGuideDetailRealmProxyInterface)object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        }
        String realmGet$state = ((CashingGuideDetailRealmProxyInterface)object).realmGet$state();
        if (realmGet$state != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
        }
        Double realmGet$collected = ((CashingGuideDetailRealmProxyInterface)object).realmGet$collected();
        if (realmGet$collected != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.collectedIndex, rowIndex, realmGet$collected, false);
        }
        Double realmGet$pending = ((CashingGuideDetailRealmProxyInterface)object).realmGet$pending();
        if (realmGet$pending != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.pendingIndex, rowIndex, realmGet$pending, false);
        }
        Double realmGet$totalDue = ((CashingGuideDetailRealmProxyInterface)object).realmGet$totalDue();
        if (realmGet$totalDue != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.totalDueIndex, rowIndex, realmGet$totalDue, false);
        }
        Double realmGet$credit = ((CashingGuideDetailRealmProxyInterface)object).realmGet$credit();
        if (realmGet$credit != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.creditIndex, rowIndex, realmGet$credit, false);
        }
        String realmGet$date = ((CashingGuideDetailRealmProxyInterface)object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        }

        RealmList<com.mobile.polux.models.Invoice> docXcobrarList = ((CashingGuideDetailRealmProxyInterface) object).realmGet$docXcobrar();
        if (docXcobrarList != null) {
            long docXcobrarNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.docXcobrarIndex, rowIndex);
            for (com.mobile.polux.models.Invoice docXcobrarItem : docXcobrarList) {
                Long cacheItemIndexdocXcobrar = cache.get(docXcobrarItem);
                if (cacheItemIndexdocXcobrar == null) {
                    cacheItemIndexdocXcobrar = InvoiceRealmProxy.insert(realm, docXcobrarItem, cache);
                }
                LinkView.nativeAdd(docXcobrarNativeLinkViewPtr, cacheItemIndexdocXcobrar);
            }
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.CashingGuideDetail.class);
        long tableNativePtr = table.getNativePtr();
        CashingGuideDetailColumnInfo columnInfo = (CashingGuideDetailColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.CashingGuideDetail.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.CashingGuideDetail object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.CashingGuideDetail) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((CashingGuideDetailRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CashingGuideDetailRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((CashingGuideDetailRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.clientIdIndex, rowIndex, ((CashingGuideDetailRealmProxyInterface)object).realmGet$clientId(), false);
                String realmGet$name = ((CashingGuideDetailRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$address = ((CashingGuideDetailRealmProxyInterface)object).realmGet$address();
                if (realmGet$address != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
                }
                String realmGet$state = ((CashingGuideDetailRealmProxyInterface)object).realmGet$state();
                if (realmGet$state != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
                }
                Double realmGet$collected = ((CashingGuideDetailRealmProxyInterface)object).realmGet$collected();
                if (realmGet$collected != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.collectedIndex, rowIndex, realmGet$collected, false);
                }
                Double realmGet$pending = ((CashingGuideDetailRealmProxyInterface)object).realmGet$pending();
                if (realmGet$pending != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.pendingIndex, rowIndex, realmGet$pending, false);
                }
                Double realmGet$totalDue = ((CashingGuideDetailRealmProxyInterface)object).realmGet$totalDue();
                if (realmGet$totalDue != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.totalDueIndex, rowIndex, realmGet$totalDue, false);
                }
                Double realmGet$credit = ((CashingGuideDetailRealmProxyInterface)object).realmGet$credit();
                if (realmGet$credit != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.creditIndex, rowIndex, realmGet$credit, false);
                }
                String realmGet$date = ((CashingGuideDetailRealmProxyInterface)object).realmGet$date();
                if (realmGet$date != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
                }

                RealmList<com.mobile.polux.models.Invoice> docXcobrarList = ((CashingGuideDetailRealmProxyInterface) object).realmGet$docXcobrar();
                if (docXcobrarList != null) {
                    long docXcobrarNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.docXcobrarIndex, rowIndex);
                    for (com.mobile.polux.models.Invoice docXcobrarItem : docXcobrarList) {
                        Long cacheItemIndexdocXcobrar = cache.get(docXcobrarItem);
                        if (cacheItemIndexdocXcobrar == null) {
                            cacheItemIndexdocXcobrar = InvoiceRealmProxy.insert(realm, docXcobrarItem, cache);
                        }
                        LinkView.nativeAdd(docXcobrarNativeLinkViewPtr, cacheItemIndexdocXcobrar);
                    }
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.CashingGuideDetail object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.CashingGuideDetail.class);
        long tableNativePtr = table.getNativePtr();
        CashingGuideDetailColumnInfo columnInfo = (CashingGuideDetailColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.CashingGuideDetail.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((CashingGuideDetailRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CashingGuideDetailRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((CashingGuideDetailRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clientIdIndex, rowIndex, ((CashingGuideDetailRealmProxyInterface)object).realmGet$clientId(), false);
        String realmGet$name = ((CashingGuideDetailRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$address = ((CashingGuideDetailRealmProxyInterface)object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
        }
        String realmGet$state = ((CashingGuideDetailRealmProxyInterface)object).realmGet$state();
        if (realmGet$state != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stateIndex, rowIndex, false);
        }
        Double realmGet$collected = ((CashingGuideDetailRealmProxyInterface)object).realmGet$collected();
        if (realmGet$collected != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.collectedIndex, rowIndex, realmGet$collected, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.collectedIndex, rowIndex, false);
        }
        Double realmGet$pending = ((CashingGuideDetailRealmProxyInterface)object).realmGet$pending();
        if (realmGet$pending != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.pendingIndex, rowIndex, realmGet$pending, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pendingIndex, rowIndex, false);
        }
        Double realmGet$totalDue = ((CashingGuideDetailRealmProxyInterface)object).realmGet$totalDue();
        if (realmGet$totalDue != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.totalDueIndex, rowIndex, realmGet$totalDue, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.totalDueIndex, rowIndex, false);
        }
        Double realmGet$credit = ((CashingGuideDetailRealmProxyInterface)object).realmGet$credit();
        if (realmGet$credit != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.creditIndex, rowIndex, realmGet$credit, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.creditIndex, rowIndex, false);
        }
        String realmGet$date = ((CashingGuideDetailRealmProxyInterface)object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
        }

        long docXcobrarNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.docXcobrarIndex, rowIndex);
        LinkView.nativeClear(docXcobrarNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.Invoice> docXcobrarList = ((CashingGuideDetailRealmProxyInterface) object).realmGet$docXcobrar();
        if (docXcobrarList != null) {
            for (com.mobile.polux.models.Invoice docXcobrarItem : docXcobrarList) {
                Long cacheItemIndexdocXcobrar = cache.get(docXcobrarItem);
                if (cacheItemIndexdocXcobrar == null) {
                    cacheItemIndexdocXcobrar = InvoiceRealmProxy.insertOrUpdate(realm, docXcobrarItem, cache);
                }
                LinkView.nativeAdd(docXcobrarNativeLinkViewPtr, cacheItemIndexdocXcobrar);
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.CashingGuideDetail.class);
        long tableNativePtr = table.getNativePtr();
        CashingGuideDetailColumnInfo columnInfo = (CashingGuideDetailColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.CashingGuideDetail.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.CashingGuideDetail object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.CashingGuideDetail) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((CashingGuideDetailRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((CashingGuideDetailRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((CashingGuideDetailRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.clientIdIndex, rowIndex, ((CashingGuideDetailRealmProxyInterface)object).realmGet$clientId(), false);
                String realmGet$name = ((CashingGuideDetailRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$address = ((CashingGuideDetailRealmProxyInterface)object).realmGet$address();
                if (realmGet$address != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
                }
                String realmGet$state = ((CashingGuideDetailRealmProxyInterface)object).realmGet$state();
                if (realmGet$state != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.stateIndex, rowIndex, false);
                }
                Double realmGet$collected = ((CashingGuideDetailRealmProxyInterface)object).realmGet$collected();
                if (realmGet$collected != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.collectedIndex, rowIndex, realmGet$collected, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.collectedIndex, rowIndex, false);
                }
                Double realmGet$pending = ((CashingGuideDetailRealmProxyInterface)object).realmGet$pending();
                if (realmGet$pending != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.pendingIndex, rowIndex, realmGet$pending, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.pendingIndex, rowIndex, false);
                }
                Double realmGet$totalDue = ((CashingGuideDetailRealmProxyInterface)object).realmGet$totalDue();
                if (realmGet$totalDue != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.totalDueIndex, rowIndex, realmGet$totalDue, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.totalDueIndex, rowIndex, false);
                }
                Double realmGet$credit = ((CashingGuideDetailRealmProxyInterface)object).realmGet$credit();
                if (realmGet$credit != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.creditIndex, rowIndex, realmGet$credit, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.creditIndex, rowIndex, false);
                }
                String realmGet$date = ((CashingGuideDetailRealmProxyInterface)object).realmGet$date();
                if (realmGet$date != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
                }

                long docXcobrarNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.docXcobrarIndex, rowIndex);
                LinkView.nativeClear(docXcobrarNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.Invoice> docXcobrarList = ((CashingGuideDetailRealmProxyInterface) object).realmGet$docXcobrar();
                if (docXcobrarList != null) {
                    for (com.mobile.polux.models.Invoice docXcobrarItem : docXcobrarList) {
                        Long cacheItemIndexdocXcobrar = cache.get(docXcobrarItem);
                        if (cacheItemIndexdocXcobrar == null) {
                            cacheItemIndexdocXcobrar = InvoiceRealmProxy.insertOrUpdate(realm, docXcobrarItem, cache);
                        }
                        LinkView.nativeAdd(docXcobrarNativeLinkViewPtr, cacheItemIndexdocXcobrar);
                    }
                }

            }
        }
    }

    public static com.mobile.polux.models.CashingGuideDetail createDetachedCopy(com.mobile.polux.models.CashingGuideDetail realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.CashingGuideDetail unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.CashingGuideDetail)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.CashingGuideDetail)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.CashingGuideDetail();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$id(((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$id());
        ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$clientId(((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$clientId());
        ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$name(((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$name());
        ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$address(((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$address());
        ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$state(((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$state());
        ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$collected(((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$collected());
        ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$pending(((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$pending());
        ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$totalDue(((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$totalDue());
        ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$credit(((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$credit());
        ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$date(((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$date());

        // Deep copy of docXcobrar
        if (currentDepth == maxDepth) {
            ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$docXcobrar(null);
        } else {
            RealmList<com.mobile.polux.models.Invoice> manageddocXcobrarList = ((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$docXcobrar();
            RealmList<com.mobile.polux.models.Invoice> unmanageddocXcobrarList = new RealmList<com.mobile.polux.models.Invoice>();
            ((CashingGuideDetailRealmProxyInterface) unmanagedObject).realmSet$docXcobrar(unmanageddocXcobrarList);
            int nextDepth = currentDepth + 1;
            int size = manageddocXcobrarList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.Invoice item = InvoiceRealmProxy.createDetachedCopy(manageddocXcobrarList.get(i), nextDepth, maxDepth, cache);
                unmanageddocXcobrarList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.mobile.polux.models.CashingGuideDetail update(Realm realm, com.mobile.polux.models.CashingGuideDetail realmObject, com.mobile.polux.models.CashingGuideDetail newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$clientId(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$clientId());
        ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$name(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$name());
        ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$address(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$address());
        ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$state(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$state());
        ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$collected(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$collected());
        ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$pending(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$pending());
        ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$totalDue(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$totalDue());
        ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$credit(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$credit());
        ((CashingGuideDetailRealmProxyInterface) realmObject).realmSet$date(((CashingGuideDetailRealmProxyInterface) newObject).realmGet$date());
        RealmList<com.mobile.polux.models.Invoice> docXcobrarList = ((CashingGuideDetailRealmProxyInterface) newObject).realmGet$docXcobrar();
        RealmList<com.mobile.polux.models.Invoice> docXcobrarRealmList = ((CashingGuideDetailRealmProxyInterface) realmObject).realmGet$docXcobrar();
        docXcobrarRealmList.clear();
        if (docXcobrarList != null) {
            for (int i = 0; i < docXcobrarList.size(); i++) {
                com.mobile.polux.models.Invoice docXcobrarItem = docXcobrarList.get(i);
                com.mobile.polux.models.Invoice cachedocXcobrar = (com.mobile.polux.models.Invoice) cache.get(docXcobrarItem);
                if (cachedocXcobrar != null) {
                    docXcobrarRealmList.add(cachedocXcobrar);
                } else {
                    docXcobrarRealmList.add(InvoiceRealmProxy.copyOrUpdate(realm, docXcobrarList.get(i), true, cache));
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
        StringBuilder stringBuilder = new StringBuilder("CashingGuideDetail = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clientId:");
        stringBuilder.append(realmGet$clientId());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? realmGet$address() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{state:");
        stringBuilder.append(realmGet$state() != null ? realmGet$state() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{collected:");
        stringBuilder.append(realmGet$collected() != null ? realmGet$collected() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{pending:");
        stringBuilder.append(realmGet$pending() != null ? realmGet$pending() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{totalDue:");
        stringBuilder.append(realmGet$totalDue() != null ? realmGet$totalDue() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{credit:");
        stringBuilder.append(realmGet$credit() != null ? realmGet$credit() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date() != null ? realmGet$date() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{docXcobrar:");
        stringBuilder.append("RealmList<Invoice>[").append(realmGet$docXcobrar().size()).append("]");
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
        CashingGuideDetailRealmProxy aCashingGuideDetail = (CashingGuideDetailRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCashingGuideDetail.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCashingGuideDetail.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCashingGuideDetail.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
