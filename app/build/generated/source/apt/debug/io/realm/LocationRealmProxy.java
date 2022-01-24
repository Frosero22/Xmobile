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

public class LocationRealmProxy extends com.mobile.polux.models.Location
    implements RealmObjectProxy, LocationRealmProxyInterface {

    static final class LocationColumnInfo extends ColumnInfo {
        long idIndex;
        long codigoClienteIndex;
        long nameIndex;
        long addressIndex;
        long direccionEntregaMercaderiaIndex;
        long direccionMapaIndex;
        long esPrincipalIndex;
        long latitudeIndex;
        long longitudeIndex;
        long imgIndex;
        long maxOrdenesIndex;
        long contactsIndex;

        LocationColumnInfo(SharedRealm realm, Table table) {
            super(12);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.codigoClienteIndex = addColumnDetails(table, "codigoCliente", RealmFieldType.INTEGER);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.addressIndex = addColumnDetails(table, "address", RealmFieldType.STRING);
            this.direccionEntregaMercaderiaIndex = addColumnDetails(table, "direccionEntregaMercaderia", RealmFieldType.STRING);
            this.direccionMapaIndex = addColumnDetails(table, "direccionMapa", RealmFieldType.STRING);
            this.esPrincipalIndex = addColumnDetails(table, "esPrincipal", RealmFieldType.STRING);
            this.latitudeIndex = addColumnDetails(table, "latitude", RealmFieldType.STRING);
            this.longitudeIndex = addColumnDetails(table, "longitude", RealmFieldType.STRING);
            this.imgIndex = addColumnDetails(table, "img", RealmFieldType.STRING);
            this.maxOrdenesIndex = addColumnDetails(table, "maxOrdenes", RealmFieldType.INTEGER);
            this.contactsIndex = addColumnDetails(table, "contacts", RealmFieldType.LIST);
        }

        LocationColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new LocationColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final LocationColumnInfo src = (LocationColumnInfo) rawSrc;
            final LocationColumnInfo dst = (LocationColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.codigoClienteIndex = src.codigoClienteIndex;
            dst.nameIndex = src.nameIndex;
            dst.addressIndex = src.addressIndex;
            dst.direccionEntregaMercaderiaIndex = src.direccionEntregaMercaderiaIndex;
            dst.direccionMapaIndex = src.direccionMapaIndex;
            dst.esPrincipalIndex = src.esPrincipalIndex;
            dst.latitudeIndex = src.latitudeIndex;
            dst.longitudeIndex = src.longitudeIndex;
            dst.imgIndex = src.imgIndex;
            dst.maxOrdenesIndex = src.maxOrdenesIndex;
            dst.contactsIndex = src.contactsIndex;
        }
    }

    private LocationColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Location> proxyState;
    private RealmList<com.mobile.polux.models.Contact> contactsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("codigoCliente");
        fieldNames.add("name");
        fieldNames.add("address");
        fieldNames.add("direccionEntregaMercaderia");
        fieldNames.add("direccionMapa");
        fieldNames.add("esPrincipal");
        fieldNames.add("latitude");
        fieldNames.add("longitude");
        fieldNames.add("img");
        fieldNames.add("maxOrdenes");
        fieldNames.add("contacts");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    LocationRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (LocationColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Location>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.idIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoCliente() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoClienteIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoClienteIndex);
    }

    @Override
    public void realmSet$codigoCliente(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoClienteIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoClienteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoClienteIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoClienteIndex, value);
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
    public String realmGet$direccionEntregaMercaderia() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.direccionEntregaMercaderiaIndex);
    }

    @Override
    public void realmSet$direccionEntregaMercaderia(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.direccionEntregaMercaderiaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.direccionEntregaMercaderiaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.direccionEntregaMercaderiaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.direccionEntregaMercaderiaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$direccionMapa() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.direccionMapaIndex);
    }

    @Override
    public void realmSet$direccionMapa(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.direccionMapaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.direccionMapaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.direccionMapaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.direccionMapaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$esPrincipal() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.esPrincipalIndex);
    }

    @Override
    public void realmSet$esPrincipal(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.esPrincipalIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.esPrincipalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.esPrincipalIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.esPrincipalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$latitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.latitudeIndex);
    }

    @Override
    public void realmSet$latitude(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.latitudeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.latitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.latitudeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.latitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$longitude() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.longitudeIndex);
    }

    @Override
    public void realmSet$longitude(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.longitudeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.longitudeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.longitudeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.longitudeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$img() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.imgIndex);
    }

    @Override
    public void realmSet$img(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.imgIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.imgIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.imgIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.imgIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$maxOrdenes() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.maxOrdenesIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.maxOrdenesIndex);
    }

    @Override
    public void realmSet$maxOrdenes(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.maxOrdenesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.maxOrdenesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.maxOrdenesIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.maxOrdenesIndex, value);
    }

    @Override
    public RealmList<com.mobile.polux.models.Contact> realmGet$contacts() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (contactsRealmList != null) {
            return contactsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.contactsIndex);
            contactsRealmList = new RealmList<com.mobile.polux.models.Contact>(com.mobile.polux.models.Contact.class, linkView, proxyState.getRealm$realm());
            return contactsRealmList;
        }
    }

    @Override
    public void realmSet$contacts(RealmList<com.mobile.polux.models.Contact> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("contacts")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.mobile.polux.models.Contact> original = value;
                value = new RealmList<com.mobile.polux.models.Contact>();
                for (com.mobile.polux.models.Contact item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.contactsIndex);
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
        if (!realmSchema.contains("Location")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Location");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoCliente", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("direccionEntregaMercaderia", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("direccionMapa", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("esPrincipal", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("latitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("longitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("img", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("maxOrdenes", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("Contact")) {
                ContactRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("contacts", RealmFieldType.LIST, realmSchema.get("Contact"));
            return realmObjectSchema;
        }
        return realmSchema.get("Location");
    }

    public static LocationColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Location")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Location' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Location");
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

        final LocationColumnInfo columnInfo = new LocationColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("id")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("id") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'id' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'id' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoCliente")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoCliente' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoCliente") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoCliente' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoClienteIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoCliente' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoCliente' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("direccionEntregaMercaderia")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'direccionEntregaMercaderia' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("direccionEntregaMercaderia") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'direccionEntregaMercaderia' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.direccionEntregaMercaderiaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'direccionEntregaMercaderia' is required. Either set @Required to field 'direccionEntregaMercaderia' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("direccionMapa")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'direccionMapa' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("direccionMapa") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'direccionMapa' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.direccionMapaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'direccionMapa' is required. Either set @Required to field 'direccionMapa' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("esPrincipal")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'esPrincipal' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("esPrincipal") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'esPrincipal' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.esPrincipalIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'esPrincipal' is required. Either set @Required to field 'esPrincipal' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("latitude")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'latitude' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("latitude") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'latitude' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.latitudeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'latitude' is required. Either set @Required to field 'latitude' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("longitude")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'longitude' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("longitude") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'longitude' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.longitudeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'longitude' is required. Either set @Required to field 'longitude' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("img")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'img' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("img") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'img' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.imgIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'img' is required. Either set @Required to field 'img' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("maxOrdenes")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'maxOrdenes' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("maxOrdenes") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'maxOrdenes' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.maxOrdenesIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'maxOrdenes' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'maxOrdenes' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("contacts")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'contacts'");
        }
        if (columnTypes.get("contacts") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Contact' for field 'contacts'");
        }
        if (!sharedRealm.hasTable("class_Contact")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Contact' for field 'contacts'");
        }
        Table table_11 = sharedRealm.getTable("class_Contact");
        if (!table.getLinkTarget(columnInfo.contactsIndex).hasSameSchema(table_11)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'contacts': '" + table.getLinkTarget(columnInfo.contactsIndex).getName() + "' expected - was '" + table_11.getName() + "'");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Location";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Location createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("contacts")) {
            excludeFields.add("contacts");
        }
        com.mobile.polux.models.Location obj = realm.createObjectInternal(com.mobile.polux.models.Location.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                ((LocationRealmProxyInterface) obj).realmSet$id(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("codigoCliente")) {
            if (json.isNull("codigoCliente")) {
                ((LocationRealmProxyInterface) obj).realmSet$codigoCliente(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$codigoCliente((int) json.getInt("codigoCliente"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((LocationRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                ((LocationRealmProxyInterface) obj).realmSet$address(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$address((String) json.getString("address"));
            }
        }
        if (json.has("direccionEntregaMercaderia")) {
            if (json.isNull("direccionEntregaMercaderia")) {
                ((LocationRealmProxyInterface) obj).realmSet$direccionEntregaMercaderia(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$direccionEntregaMercaderia((String) json.getString("direccionEntregaMercaderia"));
            }
        }
        if (json.has("direccionMapa")) {
            if (json.isNull("direccionMapa")) {
                ((LocationRealmProxyInterface) obj).realmSet$direccionMapa(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$direccionMapa((String) json.getString("direccionMapa"));
            }
        }
        if (json.has("esPrincipal")) {
            if (json.isNull("esPrincipal")) {
                ((LocationRealmProxyInterface) obj).realmSet$esPrincipal(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$esPrincipal((String) json.getString("esPrincipal"));
            }
        }
        if (json.has("latitude")) {
            if (json.isNull("latitude")) {
                ((LocationRealmProxyInterface) obj).realmSet$latitude(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$latitude((String) json.getString("latitude"));
            }
        }
        if (json.has("longitude")) {
            if (json.isNull("longitude")) {
                ((LocationRealmProxyInterface) obj).realmSet$longitude(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$longitude((String) json.getString("longitude"));
            }
        }
        if (json.has("img")) {
            if (json.isNull("img")) {
                ((LocationRealmProxyInterface) obj).realmSet$img(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$img((String) json.getString("img"));
            }
        }
        if (json.has("maxOrdenes")) {
            if (json.isNull("maxOrdenes")) {
                ((LocationRealmProxyInterface) obj).realmSet$maxOrdenes(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmSet$maxOrdenes((int) json.getInt("maxOrdenes"));
            }
        }
        if (json.has("contacts")) {
            if (json.isNull("contacts")) {
                ((LocationRealmProxyInterface) obj).realmSet$contacts(null);
            } else {
                ((LocationRealmProxyInterface) obj).realmGet$contacts().clear();
                JSONArray array = json.getJSONArray("contacts");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.Contact item = ContactRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((LocationRealmProxyInterface) obj).realmGet$contacts().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Location createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.mobile.polux.models.Location obj = new com.mobile.polux.models.Location();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("codigoCliente")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$codigoCliente(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$codigoCliente((int) reader.nextInt());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("address")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$address(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$address((String) reader.nextString());
                }
            } else if (name.equals("direccionEntregaMercaderia")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$direccionEntregaMercaderia(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$direccionEntregaMercaderia((String) reader.nextString());
                }
            } else if (name.equals("direccionMapa")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$direccionMapa(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$direccionMapa((String) reader.nextString());
                }
            } else if (name.equals("esPrincipal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$esPrincipal(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$esPrincipal((String) reader.nextString());
                }
            } else if (name.equals("latitude")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$latitude(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$latitude((String) reader.nextString());
                }
            } else if (name.equals("longitude")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$longitude(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$longitude((String) reader.nextString());
                }
            } else if (name.equals("img")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$img(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$img((String) reader.nextString());
                }
            } else if (name.equals("maxOrdenes")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$maxOrdenes(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$maxOrdenes((int) reader.nextInt());
                }
            } else if (name.equals("contacts")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((LocationRealmProxyInterface) obj).realmSet$contacts(null);
                } else {
                    ((LocationRealmProxyInterface) obj).realmSet$contacts(new RealmList<com.mobile.polux.models.Contact>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.Contact item = ContactRealmProxy.createUsingJsonStream(realm, reader);
                        ((LocationRealmProxyInterface) obj).realmGet$contacts().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.Location copyOrUpdate(Realm realm, com.mobile.polux.models.Location object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Location) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.mobile.polux.models.Location copy(Realm realm, com.mobile.polux.models.Location newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Location) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Location realmObject = realm.createObjectInternal(com.mobile.polux.models.Location.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((LocationRealmProxyInterface) realmObject).realmSet$id(((LocationRealmProxyInterface) newObject).realmGet$id());
            ((LocationRealmProxyInterface) realmObject).realmSet$codigoCliente(((LocationRealmProxyInterface) newObject).realmGet$codigoCliente());
            ((LocationRealmProxyInterface) realmObject).realmSet$name(((LocationRealmProxyInterface) newObject).realmGet$name());
            ((LocationRealmProxyInterface) realmObject).realmSet$address(((LocationRealmProxyInterface) newObject).realmGet$address());
            ((LocationRealmProxyInterface) realmObject).realmSet$direccionEntregaMercaderia(((LocationRealmProxyInterface) newObject).realmGet$direccionEntregaMercaderia());
            ((LocationRealmProxyInterface) realmObject).realmSet$direccionMapa(((LocationRealmProxyInterface) newObject).realmGet$direccionMapa());
            ((LocationRealmProxyInterface) realmObject).realmSet$esPrincipal(((LocationRealmProxyInterface) newObject).realmGet$esPrincipal());
            ((LocationRealmProxyInterface) realmObject).realmSet$latitude(((LocationRealmProxyInterface) newObject).realmGet$latitude());
            ((LocationRealmProxyInterface) realmObject).realmSet$longitude(((LocationRealmProxyInterface) newObject).realmGet$longitude());
            ((LocationRealmProxyInterface) realmObject).realmSet$img(((LocationRealmProxyInterface) newObject).realmGet$img());
            ((LocationRealmProxyInterface) realmObject).realmSet$maxOrdenes(((LocationRealmProxyInterface) newObject).realmGet$maxOrdenes());

            RealmList<com.mobile.polux.models.Contact> contactsList = ((LocationRealmProxyInterface) newObject).realmGet$contacts();
            if (contactsList != null) {
                RealmList<com.mobile.polux.models.Contact> contactsRealmList = ((LocationRealmProxyInterface) realmObject).realmGet$contacts();
                for (int i = 0; i < contactsList.size(); i++) {
                    com.mobile.polux.models.Contact contactsItem = contactsList.get(i);
                    com.mobile.polux.models.Contact cachecontacts = (com.mobile.polux.models.Contact) cache.get(contactsItem);
                    if (cachecontacts != null) {
                        contactsRealmList.add(cachecontacts);
                    } else {
                        contactsRealmList.add(ContactRealmProxy.copyOrUpdate(realm, contactsList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Location object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Location.class);
        long tableNativePtr = table.getNativePtr();
        LocationColumnInfo columnInfo = (LocationColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Location.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((LocationRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        }
        Number realmGet$codigoCliente = ((LocationRealmProxyInterface)object).realmGet$codigoCliente();
        if (realmGet$codigoCliente != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoClienteIndex, rowIndex, realmGet$codigoCliente.longValue(), false);
        }
        String realmGet$name = ((LocationRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$address = ((LocationRealmProxyInterface)object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        }
        String realmGet$direccionEntregaMercaderia = ((LocationRealmProxyInterface)object).realmGet$direccionEntregaMercaderia();
        if (realmGet$direccionEntregaMercaderia != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.direccionEntregaMercaderiaIndex, rowIndex, realmGet$direccionEntregaMercaderia, false);
        }
        String realmGet$direccionMapa = ((LocationRealmProxyInterface)object).realmGet$direccionMapa();
        if (realmGet$direccionMapa != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.direccionMapaIndex, rowIndex, realmGet$direccionMapa, false);
        }
        String realmGet$esPrincipal = ((LocationRealmProxyInterface)object).realmGet$esPrincipal();
        if (realmGet$esPrincipal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esPrincipalIndex, rowIndex, realmGet$esPrincipal, false);
        }
        String realmGet$latitude = ((LocationRealmProxyInterface)object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
        }
        String realmGet$longitude = ((LocationRealmProxyInterface)object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
        }
        String realmGet$img = ((LocationRealmProxyInterface)object).realmGet$img();
        if (realmGet$img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imgIndex, rowIndex, realmGet$img, false);
        }
        Number realmGet$maxOrdenes = ((LocationRealmProxyInterface)object).realmGet$maxOrdenes();
        if (realmGet$maxOrdenes != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.maxOrdenesIndex, rowIndex, realmGet$maxOrdenes.longValue(), false);
        }

        RealmList<com.mobile.polux.models.Contact> contactsList = ((LocationRealmProxyInterface) object).realmGet$contacts();
        if (contactsList != null) {
            long contactsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.contactsIndex, rowIndex);
            for (com.mobile.polux.models.Contact contactsItem : contactsList) {
                Long cacheItemIndexcontacts = cache.get(contactsItem);
                if (cacheItemIndexcontacts == null) {
                    cacheItemIndexcontacts = ContactRealmProxy.insert(realm, contactsItem, cache);
                }
                LinkView.nativeAdd(contactsNativeLinkViewPtr, cacheItemIndexcontacts);
            }
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Location.class);
        long tableNativePtr = table.getNativePtr();
        LocationColumnInfo columnInfo = (LocationColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Location.class);
        com.mobile.polux.models.Location object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Location) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Number realmGet$id = ((LocationRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
                }
                Number realmGet$codigoCliente = ((LocationRealmProxyInterface)object).realmGet$codigoCliente();
                if (realmGet$codigoCliente != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoClienteIndex, rowIndex, realmGet$codigoCliente.longValue(), false);
                }
                String realmGet$name = ((LocationRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$address = ((LocationRealmProxyInterface)object).realmGet$address();
                if (realmGet$address != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
                }
                String realmGet$direccionEntregaMercaderia = ((LocationRealmProxyInterface)object).realmGet$direccionEntregaMercaderia();
                if (realmGet$direccionEntregaMercaderia != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.direccionEntregaMercaderiaIndex, rowIndex, realmGet$direccionEntregaMercaderia, false);
                }
                String realmGet$direccionMapa = ((LocationRealmProxyInterface)object).realmGet$direccionMapa();
                if (realmGet$direccionMapa != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.direccionMapaIndex, rowIndex, realmGet$direccionMapa, false);
                }
                String realmGet$esPrincipal = ((LocationRealmProxyInterface)object).realmGet$esPrincipal();
                if (realmGet$esPrincipal != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esPrincipalIndex, rowIndex, realmGet$esPrincipal, false);
                }
                String realmGet$latitude = ((LocationRealmProxyInterface)object).realmGet$latitude();
                if (realmGet$latitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
                }
                String realmGet$longitude = ((LocationRealmProxyInterface)object).realmGet$longitude();
                if (realmGet$longitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
                }
                String realmGet$img = ((LocationRealmProxyInterface)object).realmGet$img();
                if (realmGet$img != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imgIndex, rowIndex, realmGet$img, false);
                }
                Number realmGet$maxOrdenes = ((LocationRealmProxyInterface)object).realmGet$maxOrdenes();
                if (realmGet$maxOrdenes != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.maxOrdenesIndex, rowIndex, realmGet$maxOrdenes.longValue(), false);
                }

                RealmList<com.mobile.polux.models.Contact> contactsList = ((LocationRealmProxyInterface) object).realmGet$contacts();
                if (contactsList != null) {
                    long contactsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.contactsIndex, rowIndex);
                    for (com.mobile.polux.models.Contact contactsItem : contactsList) {
                        Long cacheItemIndexcontacts = cache.get(contactsItem);
                        if (cacheItemIndexcontacts == null) {
                            cacheItemIndexcontacts = ContactRealmProxy.insert(realm, contactsItem, cache);
                        }
                        LinkView.nativeAdd(contactsNativeLinkViewPtr, cacheItemIndexcontacts);
                    }
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Location object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Location.class);
        long tableNativePtr = table.getNativePtr();
        LocationColumnInfo columnInfo = (LocationColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Location.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((LocationRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        Number realmGet$codigoCliente = ((LocationRealmProxyInterface)object).realmGet$codigoCliente();
        if (realmGet$codigoCliente != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoClienteIndex, rowIndex, realmGet$codigoCliente.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoClienteIndex, rowIndex, false);
        }
        String realmGet$name = ((LocationRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$address = ((LocationRealmProxyInterface)object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
        }
        String realmGet$direccionEntregaMercaderia = ((LocationRealmProxyInterface)object).realmGet$direccionEntregaMercaderia();
        if (realmGet$direccionEntregaMercaderia != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.direccionEntregaMercaderiaIndex, rowIndex, realmGet$direccionEntregaMercaderia, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.direccionEntregaMercaderiaIndex, rowIndex, false);
        }
        String realmGet$direccionMapa = ((LocationRealmProxyInterface)object).realmGet$direccionMapa();
        if (realmGet$direccionMapa != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.direccionMapaIndex, rowIndex, realmGet$direccionMapa, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.direccionMapaIndex, rowIndex, false);
        }
        String realmGet$esPrincipal = ((LocationRealmProxyInterface)object).realmGet$esPrincipal();
        if (realmGet$esPrincipal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esPrincipalIndex, rowIndex, realmGet$esPrincipal, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.esPrincipalIndex, rowIndex, false);
        }
        String realmGet$latitude = ((LocationRealmProxyInterface)object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.latitudeIndex, rowIndex, false);
        }
        String realmGet$longitude = ((LocationRealmProxyInterface)object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.longitudeIndex, rowIndex, false);
        }
        String realmGet$img = ((LocationRealmProxyInterface)object).realmGet$img();
        if (realmGet$img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.imgIndex, rowIndex, realmGet$img, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.imgIndex, rowIndex, false);
        }
        Number realmGet$maxOrdenes = ((LocationRealmProxyInterface)object).realmGet$maxOrdenes();
        if (realmGet$maxOrdenes != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.maxOrdenesIndex, rowIndex, realmGet$maxOrdenes.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.maxOrdenesIndex, rowIndex, false);
        }

        long contactsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.contactsIndex, rowIndex);
        LinkView.nativeClear(contactsNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.Contact> contactsList = ((LocationRealmProxyInterface) object).realmGet$contacts();
        if (contactsList != null) {
            for (com.mobile.polux.models.Contact contactsItem : contactsList) {
                Long cacheItemIndexcontacts = cache.get(contactsItem);
                if (cacheItemIndexcontacts == null) {
                    cacheItemIndexcontacts = ContactRealmProxy.insertOrUpdate(realm, contactsItem, cache);
                }
                LinkView.nativeAdd(contactsNativeLinkViewPtr, cacheItemIndexcontacts);
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Location.class);
        long tableNativePtr = table.getNativePtr();
        LocationColumnInfo columnInfo = (LocationColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Location.class);
        com.mobile.polux.models.Location object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Location) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Number realmGet$id = ((LocationRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
                }
                Number realmGet$codigoCliente = ((LocationRealmProxyInterface)object).realmGet$codigoCliente();
                if (realmGet$codigoCliente != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoClienteIndex, rowIndex, realmGet$codigoCliente.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoClienteIndex, rowIndex, false);
                }
                String realmGet$name = ((LocationRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$address = ((LocationRealmProxyInterface)object).realmGet$address();
                if (realmGet$address != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
                }
                String realmGet$direccionEntregaMercaderia = ((LocationRealmProxyInterface)object).realmGet$direccionEntregaMercaderia();
                if (realmGet$direccionEntregaMercaderia != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.direccionEntregaMercaderiaIndex, rowIndex, realmGet$direccionEntregaMercaderia, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.direccionEntregaMercaderiaIndex, rowIndex, false);
                }
                String realmGet$direccionMapa = ((LocationRealmProxyInterface)object).realmGet$direccionMapa();
                if (realmGet$direccionMapa != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.direccionMapaIndex, rowIndex, realmGet$direccionMapa, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.direccionMapaIndex, rowIndex, false);
                }
                String realmGet$esPrincipal = ((LocationRealmProxyInterface)object).realmGet$esPrincipal();
                if (realmGet$esPrincipal != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esPrincipalIndex, rowIndex, realmGet$esPrincipal, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.esPrincipalIndex, rowIndex, false);
                }
                String realmGet$latitude = ((LocationRealmProxyInterface)object).realmGet$latitude();
                if (realmGet$latitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.latitudeIndex, rowIndex, false);
                }
                String realmGet$longitude = ((LocationRealmProxyInterface)object).realmGet$longitude();
                if (realmGet$longitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.longitudeIndex, rowIndex, false);
                }
                String realmGet$img = ((LocationRealmProxyInterface)object).realmGet$img();
                if (realmGet$img != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.imgIndex, rowIndex, realmGet$img, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.imgIndex, rowIndex, false);
                }
                Number realmGet$maxOrdenes = ((LocationRealmProxyInterface)object).realmGet$maxOrdenes();
                if (realmGet$maxOrdenes != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.maxOrdenesIndex, rowIndex, realmGet$maxOrdenes.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.maxOrdenesIndex, rowIndex, false);
                }

                long contactsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.contactsIndex, rowIndex);
                LinkView.nativeClear(contactsNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.Contact> contactsList = ((LocationRealmProxyInterface) object).realmGet$contacts();
                if (contactsList != null) {
                    for (com.mobile.polux.models.Contact contactsItem : contactsList) {
                        Long cacheItemIndexcontacts = cache.get(contactsItem);
                        if (cacheItemIndexcontacts == null) {
                            cacheItemIndexcontacts = ContactRealmProxy.insertOrUpdate(realm, contactsItem, cache);
                        }
                        LinkView.nativeAdd(contactsNativeLinkViewPtr, cacheItemIndexcontacts);
                    }
                }

            }
        }
    }

    public static com.mobile.polux.models.Location createDetachedCopy(com.mobile.polux.models.Location realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Location unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Location)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Location)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Location();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$id(((LocationRealmProxyInterface) realmObject).realmGet$id());
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$codigoCliente(((LocationRealmProxyInterface) realmObject).realmGet$codigoCliente());
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$name(((LocationRealmProxyInterface) realmObject).realmGet$name());
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$address(((LocationRealmProxyInterface) realmObject).realmGet$address());
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$direccionEntregaMercaderia(((LocationRealmProxyInterface) realmObject).realmGet$direccionEntregaMercaderia());
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$direccionMapa(((LocationRealmProxyInterface) realmObject).realmGet$direccionMapa());
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$esPrincipal(((LocationRealmProxyInterface) realmObject).realmGet$esPrincipal());
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$latitude(((LocationRealmProxyInterface) realmObject).realmGet$latitude());
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$longitude(((LocationRealmProxyInterface) realmObject).realmGet$longitude());
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$img(((LocationRealmProxyInterface) realmObject).realmGet$img());
        ((LocationRealmProxyInterface) unmanagedObject).realmSet$maxOrdenes(((LocationRealmProxyInterface) realmObject).realmGet$maxOrdenes());

        // Deep copy of contacts
        if (currentDepth == maxDepth) {
            ((LocationRealmProxyInterface) unmanagedObject).realmSet$contacts(null);
        } else {
            RealmList<com.mobile.polux.models.Contact> managedcontactsList = ((LocationRealmProxyInterface) realmObject).realmGet$contacts();
            RealmList<com.mobile.polux.models.Contact> unmanagedcontactsList = new RealmList<com.mobile.polux.models.Contact>();
            ((LocationRealmProxyInterface) unmanagedObject).realmSet$contacts(unmanagedcontactsList);
            int nextDepth = currentDepth + 1;
            int size = managedcontactsList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.Contact item = ContactRealmProxy.createDetachedCopy(managedcontactsList.get(i), nextDepth, maxDepth, cache);
                unmanagedcontactsList.add(item);
            }
        }
        return unmanagedObject;
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
        LocationRealmProxy aLocation = (LocationRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aLocation.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aLocation.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aLocation.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
