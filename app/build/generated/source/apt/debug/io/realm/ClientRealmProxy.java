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

public class ClientRealmProxy extends com.mobile.polux.models.Client
    implements RealmObjectProxy, ClientRealmProxyInterface {

    static final class ClientColumnInfo extends ColumnInfo {
        long idIndex;
        long identificationIndex;
        long businessNameIndex;
        long nameIndex;
        long typeIndex;
        long typeNameIndex;
        long phoneIndex;
        long paymentTypeIndex;
        long accountsIndex;
        long rateIndex;
        long locationsIndex;
        long permiteModificarDiasPedidoIndex;

        ClientColumnInfo(SharedRealm realm, Table table) {
            super(12);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.identificationIndex = addColumnDetails(table, "identification", RealmFieldType.STRING);
            this.businessNameIndex = addColumnDetails(table, "businessName", RealmFieldType.STRING);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.typeIndex = addColumnDetails(table, "type", RealmFieldType.INTEGER);
            this.typeNameIndex = addColumnDetails(table, "typeName", RealmFieldType.STRING);
            this.phoneIndex = addColumnDetails(table, "phone", RealmFieldType.STRING);
            this.paymentTypeIndex = addColumnDetails(table, "paymentType", RealmFieldType.STRING);
            this.accountsIndex = addColumnDetails(table, "accounts", RealmFieldType.LIST);
            this.rateIndex = addColumnDetails(table, "rate", RealmFieldType.LIST);
            this.locationsIndex = addColumnDetails(table, "locations", RealmFieldType.LIST);
            this.permiteModificarDiasPedidoIndex = addColumnDetails(table, "permiteModificarDiasPedido", RealmFieldType.STRING);
        }

        ClientColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ClientColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ClientColumnInfo src = (ClientColumnInfo) rawSrc;
            final ClientColumnInfo dst = (ClientColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.identificationIndex = src.identificationIndex;
            dst.businessNameIndex = src.businessNameIndex;
            dst.nameIndex = src.nameIndex;
            dst.typeIndex = src.typeIndex;
            dst.typeNameIndex = src.typeNameIndex;
            dst.phoneIndex = src.phoneIndex;
            dst.paymentTypeIndex = src.paymentTypeIndex;
            dst.accountsIndex = src.accountsIndex;
            dst.rateIndex = src.rateIndex;
            dst.locationsIndex = src.locationsIndex;
            dst.permiteModificarDiasPedidoIndex = src.permiteModificarDiasPedidoIndex;
        }
    }

    private ClientColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Client> proxyState;
    private RealmList<com.mobile.polux.models.Account> accountsRealmList;
    private RealmList<com.mobile.polux.models.Rate> rateRealmList;
    private RealmList<com.mobile.polux.models.Location> locationsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("identification");
        fieldNames.add("businessName");
        fieldNames.add("name");
        fieldNames.add("type");
        fieldNames.add("typeName");
        fieldNames.add("phone");
        fieldNames.add("paymentType");
        fieldNames.add("accounts");
        fieldNames.add("rate");
        fieldNames.add("locations");
        fieldNames.add("permiteModificarDiasPedido");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ClientRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ClientColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Client>(this);
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
    public String realmGet$identification() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.identificationIndex);
    }

    @Override
    public void realmSet$identification(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.identificationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.identificationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.identificationIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.identificationIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$businessName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.businessNameIndex);
    }

    @Override
    public void realmSet$businessName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.businessNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.businessNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.businessNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.businessNameIndex, value);
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
    public int realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.typeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$typeName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeNameIndex);
    }

    @Override
    public void realmSet$typeName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$phone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.phoneIndex);
    }

    @Override
    public void realmSet$phone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.phoneIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.phoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.phoneIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.phoneIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$paymentType() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.paymentTypeIndex);
    }

    @Override
    public void realmSet$paymentType(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.paymentTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.paymentTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.paymentTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.paymentTypeIndex, value);
    }

    @Override
    public RealmList<com.mobile.polux.models.Account> realmGet$accounts() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (accountsRealmList != null) {
            return accountsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.accountsIndex);
            accountsRealmList = new RealmList<com.mobile.polux.models.Account>(com.mobile.polux.models.Account.class, linkView, proxyState.getRealm$realm());
            return accountsRealmList;
        }
    }

    @Override
    public void realmSet$accounts(RealmList<com.mobile.polux.models.Account> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("accounts")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.mobile.polux.models.Account> original = value;
                value = new RealmList<com.mobile.polux.models.Account>();
                for (com.mobile.polux.models.Account item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.accountsIndex);
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
    public RealmList<com.mobile.polux.models.Rate> realmGet$rate() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (rateRealmList != null) {
            return rateRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.rateIndex);
            rateRealmList = new RealmList<com.mobile.polux.models.Rate>(com.mobile.polux.models.Rate.class, linkView, proxyState.getRealm$realm());
            return rateRealmList;
        }
    }

    @Override
    public void realmSet$rate(RealmList<com.mobile.polux.models.Rate> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("rate")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.mobile.polux.models.Rate> original = value;
                value = new RealmList<com.mobile.polux.models.Rate>();
                for (com.mobile.polux.models.Rate item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.rateIndex);
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
    public RealmList<com.mobile.polux.models.Location> realmGet$locations() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (locationsRealmList != null) {
            return locationsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.locationsIndex);
            locationsRealmList = new RealmList<com.mobile.polux.models.Location>(com.mobile.polux.models.Location.class, linkView, proxyState.getRealm$realm());
            return locationsRealmList;
        }
    }

    @Override
    public void realmSet$locations(RealmList<com.mobile.polux.models.Location> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("locations")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.mobile.polux.models.Location> original = value;
                value = new RealmList<com.mobile.polux.models.Location>();
                for (com.mobile.polux.models.Location item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.locationsIndex);
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
    @SuppressWarnings("cast")
    public String realmGet$permiteModificarDiasPedido() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.permiteModificarDiasPedidoIndex);
    }

    @Override
    public void realmSet$permiteModificarDiasPedido(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.permiteModificarDiasPedidoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.permiteModificarDiasPedidoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.permiteModificarDiasPedidoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.permiteModificarDiasPedidoIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Client")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Client");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("identification", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("businessName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("typeName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("phone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("paymentType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("Account")) {
                AccountRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("accounts", RealmFieldType.LIST, realmSchema.get("Account"));
            if (!realmSchema.contains("Rate")) {
                RateRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("rate", RealmFieldType.LIST, realmSchema.get("Rate"));
            if (!realmSchema.contains("Location")) {
                LocationRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("locations", RealmFieldType.LIST, realmSchema.get("Location"));
            realmObjectSchema.add("permiteModificarDiasPedido", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Client");
    }

    public static ClientColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Client")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Client' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Client");
        final long columnCount = table.getColumnCount();
        if (columnCount != 12) {
            if (columnCount < 12) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 12 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 12 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 12 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ClientColumnInfo columnInfo = new ClientColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("identification")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'identification' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("identification") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'identification' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.identificationIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'identification' is required. Either set @Required to field 'identification' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("businessName")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'businessName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("businessName") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'businessName' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.businessNameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'businessName' is required. Either set @Required to field 'businessName' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("type")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("type") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'type' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.typeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'type' does support null values in the existing Realm file. Use corresponding boxed type for field 'type' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("typeName")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'typeName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("typeName") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'typeName' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.typeNameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'typeName' is required. Either set @Required to field 'typeName' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("phone")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'phone' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("phone") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'phone' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.phoneIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'phone' is required. Either set @Required to field 'phone' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("paymentType")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'paymentType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("paymentType") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'paymentType' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.paymentTypeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'paymentType' is required. Either set @Required to field 'paymentType' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("accounts")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'accounts'");
        }
        if (columnTypes.get("accounts") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Account' for field 'accounts'");
        }
        if (!sharedRealm.hasTable("class_Account")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Account' for field 'accounts'");
        }
        Table table_8 = sharedRealm.getTable("class_Account");
        if (!table.getLinkTarget(columnInfo.accountsIndex).hasSameSchema(table_8)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'accounts': '" + table.getLinkTarget(columnInfo.accountsIndex).getName() + "' expected - was '" + table_8.getName() + "'");
        }
        if (!columnTypes.containsKey("rate")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'rate'");
        }
        if (columnTypes.get("rate") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Rate' for field 'rate'");
        }
        if (!sharedRealm.hasTable("class_Rate")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Rate' for field 'rate'");
        }
        Table table_9 = sharedRealm.getTable("class_Rate");
        if (!table.getLinkTarget(columnInfo.rateIndex).hasSameSchema(table_9)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'rate': '" + table.getLinkTarget(columnInfo.rateIndex).getName() + "' expected - was '" + table_9.getName() + "'");
        }
        if (!columnTypes.containsKey("locations")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'locations'");
        }
        if (columnTypes.get("locations") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Location' for field 'locations'");
        }
        if (!sharedRealm.hasTable("class_Location")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Location' for field 'locations'");
        }
        Table table_10 = sharedRealm.getTable("class_Location");
        if (!table.getLinkTarget(columnInfo.locationsIndex).hasSameSchema(table_10)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'locations': '" + table.getLinkTarget(columnInfo.locationsIndex).getName() + "' expected - was '" + table_10.getName() + "'");
        }
        if (!columnTypes.containsKey("permiteModificarDiasPedido")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'permiteModificarDiasPedido' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("permiteModificarDiasPedido") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'permiteModificarDiasPedido' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.permiteModificarDiasPedidoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'permiteModificarDiasPedido' is required. Either set @Required to field 'permiteModificarDiasPedido' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Client";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Client createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(3);
        com.mobile.polux.models.Client obj = null;
        if (update) {
            Table table = realm.getTable(com.mobile.polux.models.Client.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("id")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Client.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ClientRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("accounts")) {
                excludeFields.add("accounts");
            }
            if (json.has("rate")) {
                excludeFields.add("rate");
            }
            if (json.has("locations")) {
                excludeFields.add("locations");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.ClientRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Client.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ClientRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Client.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("identification")) {
            if (json.isNull("identification")) {
                ((ClientRealmProxyInterface) obj).realmSet$identification(null);
            } else {
                ((ClientRealmProxyInterface) obj).realmSet$identification((String) json.getString("identification"));
            }
        }
        if (json.has("businessName")) {
            if (json.isNull("businessName")) {
                ((ClientRealmProxyInterface) obj).realmSet$businessName(null);
            } else {
                ((ClientRealmProxyInterface) obj).realmSet$businessName((String) json.getString("businessName"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((ClientRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((ClientRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
            } else {
                ((ClientRealmProxyInterface) obj).realmSet$type((int) json.getInt("type"));
            }
        }
        if (json.has("typeName")) {
            if (json.isNull("typeName")) {
                ((ClientRealmProxyInterface) obj).realmSet$typeName(null);
            } else {
                ((ClientRealmProxyInterface) obj).realmSet$typeName((String) json.getString("typeName"));
            }
        }
        if (json.has("phone")) {
            if (json.isNull("phone")) {
                ((ClientRealmProxyInterface) obj).realmSet$phone(null);
            } else {
                ((ClientRealmProxyInterface) obj).realmSet$phone((String) json.getString("phone"));
            }
        }
        if (json.has("paymentType")) {
            if (json.isNull("paymentType")) {
                ((ClientRealmProxyInterface) obj).realmSet$paymentType(null);
            } else {
                ((ClientRealmProxyInterface) obj).realmSet$paymentType((String) json.getString("paymentType"));
            }
        }
        if (json.has("accounts")) {
            if (json.isNull("accounts")) {
                ((ClientRealmProxyInterface) obj).realmSet$accounts(null);
            } else {
                ((ClientRealmProxyInterface) obj).realmGet$accounts().clear();
                JSONArray array = json.getJSONArray("accounts");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.Account item = AccountRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((ClientRealmProxyInterface) obj).realmGet$accounts().add(item);
                }
            }
        }
        if (json.has("rate")) {
            if (json.isNull("rate")) {
                ((ClientRealmProxyInterface) obj).realmSet$rate(null);
            } else {
                ((ClientRealmProxyInterface) obj).realmGet$rate().clear();
                JSONArray array = json.getJSONArray("rate");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.Rate item = RateRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((ClientRealmProxyInterface) obj).realmGet$rate().add(item);
                }
            }
        }
        if (json.has("locations")) {
            if (json.isNull("locations")) {
                ((ClientRealmProxyInterface) obj).realmSet$locations(null);
            } else {
                ((ClientRealmProxyInterface) obj).realmGet$locations().clear();
                JSONArray array = json.getJSONArray("locations");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.Location item = LocationRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((ClientRealmProxyInterface) obj).realmGet$locations().add(item);
                }
            }
        }
        if (json.has("permiteModificarDiasPedido")) {
            if (json.isNull("permiteModificarDiasPedido")) {
                ((ClientRealmProxyInterface) obj).realmSet$permiteModificarDiasPedido(null);
            } else {
                ((ClientRealmProxyInterface) obj).realmSet$permiteModificarDiasPedido((String) json.getString("permiteModificarDiasPedido"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Client createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mobile.polux.models.Client obj = new com.mobile.polux.models.Client();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("identification")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ClientRealmProxyInterface) obj).realmSet$identification(null);
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$identification((String) reader.nextString());
                }
            } else if (name.equals("businessName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ClientRealmProxyInterface) obj).realmSet$businessName(null);
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$businessName((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ClientRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("type")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$type((int) reader.nextInt());
                }
            } else if (name.equals("typeName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ClientRealmProxyInterface) obj).realmSet$typeName(null);
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$typeName((String) reader.nextString());
                }
            } else if (name.equals("phone")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ClientRealmProxyInterface) obj).realmSet$phone(null);
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$phone((String) reader.nextString());
                }
            } else if (name.equals("paymentType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ClientRealmProxyInterface) obj).realmSet$paymentType(null);
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$paymentType((String) reader.nextString());
                }
            } else if (name.equals("accounts")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ClientRealmProxyInterface) obj).realmSet$accounts(null);
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$accounts(new RealmList<com.mobile.polux.models.Account>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.Account item = AccountRealmProxy.createUsingJsonStream(realm, reader);
                        ((ClientRealmProxyInterface) obj).realmGet$accounts().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("rate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ClientRealmProxyInterface) obj).realmSet$rate(null);
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$rate(new RealmList<com.mobile.polux.models.Rate>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.Rate item = RateRealmProxy.createUsingJsonStream(realm, reader);
                        ((ClientRealmProxyInterface) obj).realmGet$rate().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("locations")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ClientRealmProxyInterface) obj).realmSet$locations(null);
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$locations(new RealmList<com.mobile.polux.models.Location>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.Location item = LocationRealmProxy.createUsingJsonStream(realm, reader);
                        ((ClientRealmProxyInterface) obj).realmGet$locations().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("permiteModificarDiasPedido")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ClientRealmProxyInterface) obj).realmSet$permiteModificarDiasPedido(null);
                } else {
                    ((ClientRealmProxyInterface) obj).realmSet$permiteModificarDiasPedido((String) reader.nextString());
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

    public static com.mobile.polux.models.Client copyOrUpdate(Realm realm, com.mobile.polux.models.Client object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Client) cachedRealmObject;
        } else {
            com.mobile.polux.models.Client realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.mobile.polux.models.Client.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((ClientRealmProxyInterface) object).realmGet$id());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Client.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ClientRealmProxy();
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

    public static com.mobile.polux.models.Client copy(Realm realm, com.mobile.polux.models.Client newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Client) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Client realmObject = realm.createObjectInternal(com.mobile.polux.models.Client.class, ((ClientRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ClientRealmProxyInterface) realmObject).realmSet$identification(((ClientRealmProxyInterface) newObject).realmGet$identification());
            ((ClientRealmProxyInterface) realmObject).realmSet$businessName(((ClientRealmProxyInterface) newObject).realmGet$businessName());
            ((ClientRealmProxyInterface) realmObject).realmSet$name(((ClientRealmProxyInterface) newObject).realmGet$name());
            ((ClientRealmProxyInterface) realmObject).realmSet$type(((ClientRealmProxyInterface) newObject).realmGet$type());
            ((ClientRealmProxyInterface) realmObject).realmSet$typeName(((ClientRealmProxyInterface) newObject).realmGet$typeName());
            ((ClientRealmProxyInterface) realmObject).realmSet$phone(((ClientRealmProxyInterface) newObject).realmGet$phone());
            ((ClientRealmProxyInterface) realmObject).realmSet$paymentType(((ClientRealmProxyInterface) newObject).realmGet$paymentType());

            RealmList<com.mobile.polux.models.Account> accountsList = ((ClientRealmProxyInterface) newObject).realmGet$accounts();
            if (accountsList != null) {
                RealmList<com.mobile.polux.models.Account> accountsRealmList = ((ClientRealmProxyInterface) realmObject).realmGet$accounts();
                for (int i = 0; i < accountsList.size(); i++) {
                    com.mobile.polux.models.Account accountsItem = accountsList.get(i);
                    com.mobile.polux.models.Account cacheaccounts = (com.mobile.polux.models.Account) cache.get(accountsItem);
                    if (cacheaccounts != null) {
                        accountsRealmList.add(cacheaccounts);
                    } else {
                        accountsRealmList.add(AccountRealmProxy.copyOrUpdate(realm, accountsList.get(i), update, cache));
                    }
                }
            }


            RealmList<com.mobile.polux.models.Rate> rateList = ((ClientRealmProxyInterface) newObject).realmGet$rate();
            if (rateList != null) {
                RealmList<com.mobile.polux.models.Rate> rateRealmList = ((ClientRealmProxyInterface) realmObject).realmGet$rate();
                for (int i = 0; i < rateList.size(); i++) {
                    com.mobile.polux.models.Rate rateItem = rateList.get(i);
                    com.mobile.polux.models.Rate cacherate = (com.mobile.polux.models.Rate) cache.get(rateItem);
                    if (cacherate != null) {
                        rateRealmList.add(cacherate);
                    } else {
                        rateRealmList.add(RateRealmProxy.copyOrUpdate(realm, rateList.get(i), update, cache));
                    }
                }
            }


            RealmList<com.mobile.polux.models.Location> locationsList = ((ClientRealmProxyInterface) newObject).realmGet$locations();
            if (locationsList != null) {
                RealmList<com.mobile.polux.models.Location> locationsRealmList = ((ClientRealmProxyInterface) realmObject).realmGet$locations();
                for (int i = 0; i < locationsList.size(); i++) {
                    com.mobile.polux.models.Location locationsItem = locationsList.get(i);
                    com.mobile.polux.models.Location cachelocations = (com.mobile.polux.models.Location) cache.get(locationsItem);
                    if (cachelocations != null) {
                        locationsRealmList.add(cachelocations);
                    } else {
                        locationsRealmList.add(LocationRealmProxy.copyOrUpdate(realm, locationsList.get(i), update, cache));
                    }
                }
            }

            ((ClientRealmProxyInterface) realmObject).realmSet$permiteModificarDiasPedido(((ClientRealmProxyInterface) newObject).realmGet$permiteModificarDiasPedido());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Client object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Client.class);
        long tableNativePtr = table.getNativePtr();
        ClientColumnInfo columnInfo = (ClientColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Client.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((ClientRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ClientRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ClientRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$identification = ((ClientRealmProxyInterface)object).realmGet$identification();
        if (realmGet$identification != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identificationIndex, rowIndex, realmGet$identification, false);
        }
        String realmGet$businessName = ((ClientRealmProxyInterface)object).realmGet$businessName();
        if (realmGet$businessName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.businessNameIndex, rowIndex, realmGet$businessName, false);
        }
        String realmGet$name = ((ClientRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((ClientRealmProxyInterface)object).realmGet$type(), false);
        String realmGet$typeName = ((ClientRealmProxyInterface)object).realmGet$typeName();
        if (realmGet$typeName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeNameIndex, rowIndex, realmGet$typeName, false);
        }
        String realmGet$phone = ((ClientRealmProxyInterface)object).realmGet$phone();
        if (realmGet$phone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
        }
        String realmGet$paymentType = ((ClientRealmProxyInterface)object).realmGet$paymentType();
        if (realmGet$paymentType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paymentTypeIndex, rowIndex, realmGet$paymentType, false);
        }

        RealmList<com.mobile.polux.models.Account> accountsList = ((ClientRealmProxyInterface) object).realmGet$accounts();
        if (accountsList != null) {
            long accountsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.accountsIndex, rowIndex);
            for (com.mobile.polux.models.Account accountsItem : accountsList) {
                Long cacheItemIndexaccounts = cache.get(accountsItem);
                if (cacheItemIndexaccounts == null) {
                    cacheItemIndexaccounts = AccountRealmProxy.insert(realm, accountsItem, cache);
                }
                LinkView.nativeAdd(accountsNativeLinkViewPtr, cacheItemIndexaccounts);
            }
        }


        RealmList<com.mobile.polux.models.Rate> rateList = ((ClientRealmProxyInterface) object).realmGet$rate();
        if (rateList != null) {
            long rateNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.rateIndex, rowIndex);
            for (com.mobile.polux.models.Rate rateItem : rateList) {
                Long cacheItemIndexrate = cache.get(rateItem);
                if (cacheItemIndexrate == null) {
                    cacheItemIndexrate = RateRealmProxy.insert(realm, rateItem, cache);
                }
                LinkView.nativeAdd(rateNativeLinkViewPtr, cacheItemIndexrate);
            }
        }


        RealmList<com.mobile.polux.models.Location> locationsList = ((ClientRealmProxyInterface) object).realmGet$locations();
        if (locationsList != null) {
            long locationsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.locationsIndex, rowIndex);
            for (com.mobile.polux.models.Location locationsItem : locationsList) {
                Long cacheItemIndexlocations = cache.get(locationsItem);
                if (cacheItemIndexlocations == null) {
                    cacheItemIndexlocations = LocationRealmProxy.insert(realm, locationsItem, cache);
                }
                LinkView.nativeAdd(locationsNativeLinkViewPtr, cacheItemIndexlocations);
            }
        }

        String realmGet$permiteModificarDiasPedido = ((ClientRealmProxyInterface)object).realmGet$permiteModificarDiasPedido();
        if (realmGet$permiteModificarDiasPedido != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, realmGet$permiteModificarDiasPedido, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Client.class);
        long tableNativePtr = table.getNativePtr();
        ClientColumnInfo columnInfo = (ClientColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Client.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Client object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Client) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((ClientRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ClientRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ClientRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$identification = ((ClientRealmProxyInterface)object).realmGet$identification();
                if (realmGet$identification != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identificationIndex, rowIndex, realmGet$identification, false);
                }
                String realmGet$businessName = ((ClientRealmProxyInterface)object).realmGet$businessName();
                if (realmGet$businessName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.businessNameIndex, rowIndex, realmGet$businessName, false);
                }
                String realmGet$name = ((ClientRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((ClientRealmProxyInterface)object).realmGet$type(), false);
                String realmGet$typeName = ((ClientRealmProxyInterface)object).realmGet$typeName();
                if (realmGet$typeName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.typeNameIndex, rowIndex, realmGet$typeName, false);
                }
                String realmGet$phone = ((ClientRealmProxyInterface)object).realmGet$phone();
                if (realmGet$phone != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
                }
                String realmGet$paymentType = ((ClientRealmProxyInterface)object).realmGet$paymentType();
                if (realmGet$paymentType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paymentTypeIndex, rowIndex, realmGet$paymentType, false);
                }

                RealmList<com.mobile.polux.models.Account> accountsList = ((ClientRealmProxyInterface) object).realmGet$accounts();
                if (accountsList != null) {
                    long accountsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.accountsIndex, rowIndex);
                    for (com.mobile.polux.models.Account accountsItem : accountsList) {
                        Long cacheItemIndexaccounts = cache.get(accountsItem);
                        if (cacheItemIndexaccounts == null) {
                            cacheItemIndexaccounts = AccountRealmProxy.insert(realm, accountsItem, cache);
                        }
                        LinkView.nativeAdd(accountsNativeLinkViewPtr, cacheItemIndexaccounts);
                    }
                }


                RealmList<com.mobile.polux.models.Rate> rateList = ((ClientRealmProxyInterface) object).realmGet$rate();
                if (rateList != null) {
                    long rateNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.rateIndex, rowIndex);
                    for (com.mobile.polux.models.Rate rateItem : rateList) {
                        Long cacheItemIndexrate = cache.get(rateItem);
                        if (cacheItemIndexrate == null) {
                            cacheItemIndexrate = RateRealmProxy.insert(realm, rateItem, cache);
                        }
                        LinkView.nativeAdd(rateNativeLinkViewPtr, cacheItemIndexrate);
                    }
                }


                RealmList<com.mobile.polux.models.Location> locationsList = ((ClientRealmProxyInterface) object).realmGet$locations();
                if (locationsList != null) {
                    long locationsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.locationsIndex, rowIndex);
                    for (com.mobile.polux.models.Location locationsItem : locationsList) {
                        Long cacheItemIndexlocations = cache.get(locationsItem);
                        if (cacheItemIndexlocations == null) {
                            cacheItemIndexlocations = LocationRealmProxy.insert(realm, locationsItem, cache);
                        }
                        LinkView.nativeAdd(locationsNativeLinkViewPtr, cacheItemIndexlocations);
                    }
                }

                String realmGet$permiteModificarDiasPedido = ((ClientRealmProxyInterface)object).realmGet$permiteModificarDiasPedido();
                if (realmGet$permiteModificarDiasPedido != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, realmGet$permiteModificarDiasPedido, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Client object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Client.class);
        long tableNativePtr = table.getNativePtr();
        ClientColumnInfo columnInfo = (ClientColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Client.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((ClientRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ClientRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ClientRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$identification = ((ClientRealmProxyInterface)object).realmGet$identification();
        if (realmGet$identification != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.identificationIndex, rowIndex, realmGet$identification, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.identificationIndex, rowIndex, false);
        }
        String realmGet$businessName = ((ClientRealmProxyInterface)object).realmGet$businessName();
        if (realmGet$businessName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.businessNameIndex, rowIndex, realmGet$businessName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.businessNameIndex, rowIndex, false);
        }
        String realmGet$name = ((ClientRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((ClientRealmProxyInterface)object).realmGet$type(), false);
        String realmGet$typeName = ((ClientRealmProxyInterface)object).realmGet$typeName();
        if (realmGet$typeName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeNameIndex, rowIndex, realmGet$typeName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeNameIndex, rowIndex, false);
        }
        String realmGet$phone = ((ClientRealmProxyInterface)object).realmGet$phone();
        if (realmGet$phone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneIndex, rowIndex, false);
        }
        String realmGet$paymentType = ((ClientRealmProxyInterface)object).realmGet$paymentType();
        if (realmGet$paymentType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.paymentTypeIndex, rowIndex, realmGet$paymentType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.paymentTypeIndex, rowIndex, false);
        }

        long accountsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.accountsIndex, rowIndex);
        LinkView.nativeClear(accountsNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.Account> accountsList = ((ClientRealmProxyInterface) object).realmGet$accounts();
        if (accountsList != null) {
            for (com.mobile.polux.models.Account accountsItem : accountsList) {
                Long cacheItemIndexaccounts = cache.get(accountsItem);
                if (cacheItemIndexaccounts == null) {
                    cacheItemIndexaccounts = AccountRealmProxy.insertOrUpdate(realm, accountsItem, cache);
                }
                LinkView.nativeAdd(accountsNativeLinkViewPtr, cacheItemIndexaccounts);
            }
        }


        long rateNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.rateIndex, rowIndex);
        LinkView.nativeClear(rateNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.Rate> rateList = ((ClientRealmProxyInterface) object).realmGet$rate();
        if (rateList != null) {
            for (com.mobile.polux.models.Rate rateItem : rateList) {
                Long cacheItemIndexrate = cache.get(rateItem);
                if (cacheItemIndexrate == null) {
                    cacheItemIndexrate = RateRealmProxy.insertOrUpdate(realm, rateItem, cache);
                }
                LinkView.nativeAdd(rateNativeLinkViewPtr, cacheItemIndexrate);
            }
        }


        long locationsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.locationsIndex, rowIndex);
        LinkView.nativeClear(locationsNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.Location> locationsList = ((ClientRealmProxyInterface) object).realmGet$locations();
        if (locationsList != null) {
            for (com.mobile.polux.models.Location locationsItem : locationsList) {
                Long cacheItemIndexlocations = cache.get(locationsItem);
                if (cacheItemIndexlocations == null) {
                    cacheItemIndexlocations = LocationRealmProxy.insertOrUpdate(realm, locationsItem, cache);
                }
                LinkView.nativeAdd(locationsNativeLinkViewPtr, cacheItemIndexlocations);
            }
        }

        String realmGet$permiteModificarDiasPedido = ((ClientRealmProxyInterface)object).realmGet$permiteModificarDiasPedido();
        if (realmGet$permiteModificarDiasPedido != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, realmGet$permiteModificarDiasPedido, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Client.class);
        long tableNativePtr = table.getNativePtr();
        ClientColumnInfo columnInfo = (ClientColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Client.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Client object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Client) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((ClientRealmProxyInterface) object).realmGet$id();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ClientRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((ClientRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                String realmGet$identification = ((ClientRealmProxyInterface)object).realmGet$identification();
                if (realmGet$identification != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.identificationIndex, rowIndex, realmGet$identification, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.identificationIndex, rowIndex, false);
                }
                String realmGet$businessName = ((ClientRealmProxyInterface)object).realmGet$businessName();
                if (realmGet$businessName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.businessNameIndex, rowIndex, realmGet$businessName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.businessNameIndex, rowIndex, false);
                }
                String realmGet$name = ((ClientRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((ClientRealmProxyInterface)object).realmGet$type(), false);
                String realmGet$typeName = ((ClientRealmProxyInterface)object).realmGet$typeName();
                if (realmGet$typeName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.typeNameIndex, rowIndex, realmGet$typeName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.typeNameIndex, rowIndex, false);
                }
                String realmGet$phone = ((ClientRealmProxyInterface)object).realmGet$phone();
                if (realmGet$phone != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.phoneIndex, rowIndex, realmGet$phone, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.phoneIndex, rowIndex, false);
                }
                String realmGet$paymentType = ((ClientRealmProxyInterface)object).realmGet$paymentType();
                if (realmGet$paymentType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.paymentTypeIndex, rowIndex, realmGet$paymentType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.paymentTypeIndex, rowIndex, false);
                }

                long accountsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.accountsIndex, rowIndex);
                LinkView.nativeClear(accountsNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.Account> accountsList = ((ClientRealmProxyInterface) object).realmGet$accounts();
                if (accountsList != null) {
                    for (com.mobile.polux.models.Account accountsItem : accountsList) {
                        Long cacheItemIndexaccounts = cache.get(accountsItem);
                        if (cacheItemIndexaccounts == null) {
                            cacheItemIndexaccounts = AccountRealmProxy.insertOrUpdate(realm, accountsItem, cache);
                        }
                        LinkView.nativeAdd(accountsNativeLinkViewPtr, cacheItemIndexaccounts);
                    }
                }


                long rateNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.rateIndex, rowIndex);
                LinkView.nativeClear(rateNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.Rate> rateList = ((ClientRealmProxyInterface) object).realmGet$rate();
                if (rateList != null) {
                    for (com.mobile.polux.models.Rate rateItem : rateList) {
                        Long cacheItemIndexrate = cache.get(rateItem);
                        if (cacheItemIndexrate == null) {
                            cacheItemIndexrate = RateRealmProxy.insertOrUpdate(realm, rateItem, cache);
                        }
                        LinkView.nativeAdd(rateNativeLinkViewPtr, cacheItemIndexrate);
                    }
                }


                long locationsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.locationsIndex, rowIndex);
                LinkView.nativeClear(locationsNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.Location> locationsList = ((ClientRealmProxyInterface) object).realmGet$locations();
                if (locationsList != null) {
                    for (com.mobile.polux.models.Location locationsItem : locationsList) {
                        Long cacheItemIndexlocations = cache.get(locationsItem);
                        if (cacheItemIndexlocations == null) {
                            cacheItemIndexlocations = LocationRealmProxy.insertOrUpdate(realm, locationsItem, cache);
                        }
                        LinkView.nativeAdd(locationsNativeLinkViewPtr, cacheItemIndexlocations);
                    }
                }

                String realmGet$permiteModificarDiasPedido = ((ClientRealmProxyInterface)object).realmGet$permiteModificarDiasPedido();
                if (realmGet$permiteModificarDiasPedido != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, realmGet$permiteModificarDiasPedido, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.mobile.polux.models.Client createDetachedCopy(com.mobile.polux.models.Client realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Client unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Client)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Client)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Client();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ClientRealmProxyInterface) unmanagedObject).realmSet$id(((ClientRealmProxyInterface) realmObject).realmGet$id());
        ((ClientRealmProxyInterface) unmanagedObject).realmSet$identification(((ClientRealmProxyInterface) realmObject).realmGet$identification());
        ((ClientRealmProxyInterface) unmanagedObject).realmSet$businessName(((ClientRealmProxyInterface) realmObject).realmGet$businessName());
        ((ClientRealmProxyInterface) unmanagedObject).realmSet$name(((ClientRealmProxyInterface) realmObject).realmGet$name());
        ((ClientRealmProxyInterface) unmanagedObject).realmSet$type(((ClientRealmProxyInterface) realmObject).realmGet$type());
        ((ClientRealmProxyInterface) unmanagedObject).realmSet$typeName(((ClientRealmProxyInterface) realmObject).realmGet$typeName());
        ((ClientRealmProxyInterface) unmanagedObject).realmSet$phone(((ClientRealmProxyInterface) realmObject).realmGet$phone());
        ((ClientRealmProxyInterface) unmanagedObject).realmSet$paymentType(((ClientRealmProxyInterface) realmObject).realmGet$paymentType());

        // Deep copy of accounts
        if (currentDepth == maxDepth) {
            ((ClientRealmProxyInterface) unmanagedObject).realmSet$accounts(null);
        } else {
            RealmList<com.mobile.polux.models.Account> managedaccountsList = ((ClientRealmProxyInterface) realmObject).realmGet$accounts();
            RealmList<com.mobile.polux.models.Account> unmanagedaccountsList = new RealmList<com.mobile.polux.models.Account>();
            ((ClientRealmProxyInterface) unmanagedObject).realmSet$accounts(unmanagedaccountsList);
            int nextDepth = currentDepth + 1;
            int size = managedaccountsList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.Account item = AccountRealmProxy.createDetachedCopy(managedaccountsList.get(i), nextDepth, maxDepth, cache);
                unmanagedaccountsList.add(item);
            }
        }

        // Deep copy of rate
        if (currentDepth == maxDepth) {
            ((ClientRealmProxyInterface) unmanagedObject).realmSet$rate(null);
        } else {
            RealmList<com.mobile.polux.models.Rate> managedrateList = ((ClientRealmProxyInterface) realmObject).realmGet$rate();
            RealmList<com.mobile.polux.models.Rate> unmanagedrateList = new RealmList<com.mobile.polux.models.Rate>();
            ((ClientRealmProxyInterface) unmanagedObject).realmSet$rate(unmanagedrateList);
            int nextDepth = currentDepth + 1;
            int size = managedrateList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.Rate item = RateRealmProxy.createDetachedCopy(managedrateList.get(i), nextDepth, maxDepth, cache);
                unmanagedrateList.add(item);
            }
        }

        // Deep copy of locations
        if (currentDepth == maxDepth) {
            ((ClientRealmProxyInterface) unmanagedObject).realmSet$locations(null);
        } else {
            RealmList<com.mobile.polux.models.Location> managedlocationsList = ((ClientRealmProxyInterface) realmObject).realmGet$locations();
            RealmList<com.mobile.polux.models.Location> unmanagedlocationsList = new RealmList<com.mobile.polux.models.Location>();
            ((ClientRealmProxyInterface) unmanagedObject).realmSet$locations(unmanagedlocationsList);
            int nextDepth = currentDepth + 1;
            int size = managedlocationsList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.Location item = LocationRealmProxy.createDetachedCopy(managedlocationsList.get(i), nextDepth, maxDepth, cache);
                unmanagedlocationsList.add(item);
            }
        }
        ((ClientRealmProxyInterface) unmanagedObject).realmSet$permiteModificarDiasPedido(((ClientRealmProxyInterface) realmObject).realmGet$permiteModificarDiasPedido());
        return unmanagedObject;
    }

    static com.mobile.polux.models.Client update(Realm realm, com.mobile.polux.models.Client realmObject, com.mobile.polux.models.Client newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ClientRealmProxyInterface) realmObject).realmSet$identification(((ClientRealmProxyInterface) newObject).realmGet$identification());
        ((ClientRealmProxyInterface) realmObject).realmSet$businessName(((ClientRealmProxyInterface) newObject).realmGet$businessName());
        ((ClientRealmProxyInterface) realmObject).realmSet$name(((ClientRealmProxyInterface) newObject).realmGet$name());
        ((ClientRealmProxyInterface) realmObject).realmSet$type(((ClientRealmProxyInterface) newObject).realmGet$type());
        ((ClientRealmProxyInterface) realmObject).realmSet$typeName(((ClientRealmProxyInterface) newObject).realmGet$typeName());
        ((ClientRealmProxyInterface) realmObject).realmSet$phone(((ClientRealmProxyInterface) newObject).realmGet$phone());
        ((ClientRealmProxyInterface) realmObject).realmSet$paymentType(((ClientRealmProxyInterface) newObject).realmGet$paymentType());
        RealmList<com.mobile.polux.models.Account> accountsList = ((ClientRealmProxyInterface) newObject).realmGet$accounts();
        RealmList<com.mobile.polux.models.Account> accountsRealmList = ((ClientRealmProxyInterface) realmObject).realmGet$accounts();
        accountsRealmList.clear();
        if (accountsList != null) {
            for (int i = 0; i < accountsList.size(); i++) {
                com.mobile.polux.models.Account accountsItem = accountsList.get(i);
                com.mobile.polux.models.Account cacheaccounts = (com.mobile.polux.models.Account) cache.get(accountsItem);
                if (cacheaccounts != null) {
                    accountsRealmList.add(cacheaccounts);
                } else {
                    accountsRealmList.add(AccountRealmProxy.copyOrUpdate(realm, accountsList.get(i), true, cache));
                }
            }
        }
        RealmList<com.mobile.polux.models.Rate> rateList = ((ClientRealmProxyInterface) newObject).realmGet$rate();
        RealmList<com.mobile.polux.models.Rate> rateRealmList = ((ClientRealmProxyInterface) realmObject).realmGet$rate();
        rateRealmList.clear();
        if (rateList != null) {
            for (int i = 0; i < rateList.size(); i++) {
                com.mobile.polux.models.Rate rateItem = rateList.get(i);
                com.mobile.polux.models.Rate cacherate = (com.mobile.polux.models.Rate) cache.get(rateItem);
                if (cacherate != null) {
                    rateRealmList.add(cacherate);
                } else {
                    rateRealmList.add(RateRealmProxy.copyOrUpdate(realm, rateList.get(i), true, cache));
                }
            }
        }
        RealmList<com.mobile.polux.models.Location> locationsList = ((ClientRealmProxyInterface) newObject).realmGet$locations();
        RealmList<com.mobile.polux.models.Location> locationsRealmList = ((ClientRealmProxyInterface) realmObject).realmGet$locations();
        locationsRealmList.clear();
        if (locationsList != null) {
            for (int i = 0; i < locationsList.size(); i++) {
                com.mobile.polux.models.Location locationsItem = locationsList.get(i);
                com.mobile.polux.models.Location cachelocations = (com.mobile.polux.models.Location) cache.get(locationsItem);
                if (cachelocations != null) {
                    locationsRealmList.add(cachelocations);
                } else {
                    locationsRealmList.add(LocationRealmProxy.copyOrUpdate(realm, locationsList.get(i), true, cache));
                }
            }
        }
        ((ClientRealmProxyInterface) realmObject).realmSet$permiteModificarDiasPedido(((ClientRealmProxyInterface) newObject).realmGet$permiteModificarDiasPedido());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Client = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{identification:");
        stringBuilder.append(realmGet$identification() != null ? realmGet$identification() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{businessName:");
        stringBuilder.append(realmGet$businessName() != null ? realmGet$businessName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{typeName:");
        stringBuilder.append(realmGet$typeName() != null ? realmGet$typeName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phone:");
        stringBuilder.append(realmGet$phone() != null ? realmGet$phone() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{paymentType:");
        stringBuilder.append(realmGet$paymentType() != null ? realmGet$paymentType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{accounts:");
        stringBuilder.append("RealmList<Account>[").append(realmGet$accounts().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rate:");
        stringBuilder.append("RealmList<Rate>[").append(realmGet$rate().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{locations:");
        stringBuilder.append("RealmList<Location>[").append(realmGet$locations().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{permiteModificarDiasPedido:");
        stringBuilder.append(realmGet$permiteModificarDiasPedido() != null ? realmGet$permiteModificarDiasPedido() : "null");
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
        ClientRealmProxy aClient = (ClientRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aClient.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aClient.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aClient.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
