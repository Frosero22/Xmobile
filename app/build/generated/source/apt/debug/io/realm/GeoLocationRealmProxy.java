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

public class GeoLocationRealmProxy extends com.mobile.polux.models.GeoLocation
    implements RealmObjectProxy, GeoLocationRealmProxyInterface {

    static final class GeoLocationColumnInfo extends ColumnInfo {
        long clientIdIndex;
        long clientNameIndex;
        long codigoLocalidadIndex;
        long addressIndex;
        long latitudeIndex;
        long longitudeIndex;
        long zoneIndex;
        long dayIndex;
        long referenceIndex;
        long clientTypeIndex;
        long businessTypeIndex;
        long numVisitsIndex;
        long numOrdersIndex;
        long typeIndex;
        long cantIndex;
        long dateIndex;

        GeoLocationColumnInfo(SharedRealm realm, Table table) {
            super(16);
            this.clientIdIndex = addColumnDetails(table, "clientId", RealmFieldType.INTEGER);
            this.clientNameIndex = addColumnDetails(table, "clientName", RealmFieldType.STRING);
            this.codigoLocalidadIndex = addColumnDetails(table, "codigoLocalidad", RealmFieldType.INTEGER);
            this.addressIndex = addColumnDetails(table, "address", RealmFieldType.STRING);
            this.latitudeIndex = addColumnDetails(table, "latitude", RealmFieldType.STRING);
            this.longitudeIndex = addColumnDetails(table, "longitude", RealmFieldType.STRING);
            this.zoneIndex = addColumnDetails(table, "zone", RealmFieldType.STRING);
            this.dayIndex = addColumnDetails(table, "day", RealmFieldType.STRING);
            this.referenceIndex = addColumnDetails(table, "reference", RealmFieldType.STRING);
            this.clientTypeIndex = addColumnDetails(table, "clientType", RealmFieldType.STRING);
            this.businessTypeIndex = addColumnDetails(table, "businessType", RealmFieldType.STRING);
            this.numVisitsIndex = addColumnDetails(table, "numVisits", RealmFieldType.INTEGER);
            this.numOrdersIndex = addColumnDetails(table, "numOrders", RealmFieldType.INTEGER);
            this.typeIndex = addColumnDetails(table, "type", RealmFieldType.INTEGER);
            this.cantIndex = addColumnDetails(table, "cant", RealmFieldType.INTEGER);
            this.dateIndex = addColumnDetails(table, "date", RealmFieldType.STRING);
        }

        GeoLocationColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GeoLocationColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GeoLocationColumnInfo src = (GeoLocationColumnInfo) rawSrc;
            final GeoLocationColumnInfo dst = (GeoLocationColumnInfo) rawDst;
            dst.clientIdIndex = src.clientIdIndex;
            dst.clientNameIndex = src.clientNameIndex;
            dst.codigoLocalidadIndex = src.codigoLocalidadIndex;
            dst.addressIndex = src.addressIndex;
            dst.latitudeIndex = src.latitudeIndex;
            dst.longitudeIndex = src.longitudeIndex;
            dst.zoneIndex = src.zoneIndex;
            dst.dayIndex = src.dayIndex;
            dst.referenceIndex = src.referenceIndex;
            dst.clientTypeIndex = src.clientTypeIndex;
            dst.businessTypeIndex = src.businessTypeIndex;
            dst.numVisitsIndex = src.numVisitsIndex;
            dst.numOrdersIndex = src.numOrdersIndex;
            dst.typeIndex = src.typeIndex;
            dst.cantIndex = src.cantIndex;
            dst.dateIndex = src.dateIndex;
        }
    }

    private GeoLocationColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.GeoLocation> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("clientId");
        fieldNames.add("clientName");
        fieldNames.add("codigoLocalidad");
        fieldNames.add("address");
        fieldNames.add("latitude");
        fieldNames.add("longitude");
        fieldNames.add("zone");
        fieldNames.add("day");
        fieldNames.add("reference");
        fieldNames.add("clientType");
        fieldNames.add("businessType");
        fieldNames.add("numVisits");
        fieldNames.add("numOrders");
        fieldNames.add("type");
        fieldNames.add("cant");
        fieldNames.add("date");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    GeoLocationRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GeoLocationColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.GeoLocation>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$clientId() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.clientIdIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.clientIdIndex);
    }

    @Override
    public void realmSet$clientId(Integer value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'clientId' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$clientName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.clientNameIndex);
    }

    @Override
    public void realmSet$clientName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.clientNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.clientNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.clientNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.clientNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoLocalidad() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoLocalidadIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoLocalidadIndex);
    }

    @Override
    public void realmSet$codigoLocalidad(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoLocalidadIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoLocalidadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoLocalidadIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoLocalidadIndex, value);
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
    public String realmGet$zone() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.zoneIndex);
    }

    @Override
    public void realmSet$zone(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.zoneIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.zoneIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.zoneIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.zoneIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$day() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.dayIndex);
    }

    @Override
    public void realmSet$day(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dayIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.dayIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dayIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.dayIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$reference() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.referenceIndex);
    }

    @Override
    public void realmSet$reference(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.referenceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.referenceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.referenceIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.referenceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$clientType() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.clientTypeIndex);
    }

    @Override
    public void realmSet$clientType(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.clientTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.clientTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.clientTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.clientTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$businessType() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.businessTypeIndex);
    }

    @Override
    public void realmSet$businessType(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.businessTypeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.businessTypeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.businessTypeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.businessTypeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$numVisits() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.numVisitsIndex);
    }

    @Override
    public void realmSet$numVisits(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.numVisitsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.numVisitsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$numOrders() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.numOrdersIndex);
    }

    @Override
    public void realmSet$numOrders(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.numOrdersIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.numOrdersIndex, value);
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
    public int realmGet$cant() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cantIndex);
    }

    @Override
    public void realmSet$cant(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cantIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cantIndex, value);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("GeoLocation")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("GeoLocation");
            realmObjectSchema.add("clientId", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("clientName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoLocalidad", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("address", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("latitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("longitude", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("zone", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("day", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("reference", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("clientType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("businessType", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("numVisits", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("numOrders", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("cant", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("date", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("GeoLocation");
    }

    public static GeoLocationColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_GeoLocation")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'GeoLocation' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_GeoLocation");
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

        final GeoLocationColumnInfo columnInfo = new GeoLocationColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'clientId' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.clientIdIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field clientId");
            }
        }

        if (!columnTypes.containsKey("clientId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'clientId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("clientId") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'clientId' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.clientIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'clientId' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("clientId"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'clientId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("clientName")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'clientName' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("clientName") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'clientName' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.clientNameIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'clientName' is required. Either set @Required to field 'clientName' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoLocalidad")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoLocalidad' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoLocalidad") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoLocalidad' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoLocalidadIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoLocalidad' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoLocalidad' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("zone")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'zone' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("zone") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'zone' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.zoneIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'zone' is required. Either set @Required to field 'zone' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("day")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'day' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("day") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'day' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.dayIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'day' is required. Either set @Required to field 'day' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("reference")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'reference' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("reference") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'reference' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.referenceIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'reference' is required. Either set @Required to field 'reference' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("clientType")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'clientType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("clientType") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'clientType' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.clientTypeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'clientType' is required. Either set @Required to field 'clientType' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("businessType")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'businessType' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("businessType") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'businessType' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.businessTypeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'businessType' is required. Either set @Required to field 'businessType' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("numVisits")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numVisits' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("numVisits") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'numVisits' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.numVisitsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'numVisits' does support null values in the existing Realm file. Use corresponding boxed type for field 'numVisits' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("numOrders")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numOrders' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("numOrders") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'numOrders' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.numOrdersIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'numOrders' does support null values in the existing Realm file. Use corresponding boxed type for field 'numOrders' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("cant")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cant' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("cant") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cant' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.cantIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cant' does support null values in the existing Realm file. Use corresponding boxed type for field 'cant' or migrate using RealmObjectSchema.setNullable().");
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

        return columnInfo;
    }

    public static String getTableName() {
        return "class_GeoLocation";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.GeoLocation createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mobile.polux.models.GeoLocation obj = null;
        if (update) {
            Table table = realm.getTable(com.mobile.polux.models.GeoLocation.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("clientId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("clientId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.GeoLocation.class), false, Collections.<String> emptyList());
                    obj = new io.realm.GeoLocationRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("clientId")) {
                if (json.isNull("clientId")) {
                    obj = (io.realm.GeoLocationRealmProxy) realm.createObjectInternal(com.mobile.polux.models.GeoLocation.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.GeoLocationRealmProxy) realm.createObjectInternal(com.mobile.polux.models.GeoLocation.class, json.getInt("clientId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'clientId'.");
            }
        }
        if (json.has("clientName")) {
            if (json.isNull("clientName")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$clientName(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$clientName((String) json.getString("clientName"));
            }
        }
        if (json.has("codigoLocalidad")) {
            if (json.isNull("codigoLocalidad")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$codigoLocalidad(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$codigoLocalidad((int) json.getInt("codigoLocalidad"));
            }
        }
        if (json.has("address")) {
            if (json.isNull("address")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$address(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$address((String) json.getString("address"));
            }
        }
        if (json.has("latitude")) {
            if (json.isNull("latitude")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$latitude(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$latitude((String) json.getString("latitude"));
            }
        }
        if (json.has("longitude")) {
            if (json.isNull("longitude")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$longitude(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$longitude((String) json.getString("longitude"));
            }
        }
        if (json.has("zone")) {
            if (json.isNull("zone")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$zone(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$zone((String) json.getString("zone"));
            }
        }
        if (json.has("day")) {
            if (json.isNull("day")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$day(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$day((String) json.getString("day"));
            }
        }
        if (json.has("reference")) {
            if (json.isNull("reference")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$reference(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$reference((String) json.getString("reference"));
            }
        }
        if (json.has("clientType")) {
            if (json.isNull("clientType")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$clientType(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$clientType((String) json.getString("clientType"));
            }
        }
        if (json.has("businessType")) {
            if (json.isNull("businessType")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$businessType(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$businessType((String) json.getString("businessType"));
            }
        }
        if (json.has("numVisits")) {
            if (json.isNull("numVisits")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'numVisits' to null.");
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$numVisits((int) json.getInt("numVisits"));
            }
        }
        if (json.has("numOrders")) {
            if (json.isNull("numOrders")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'numOrders' to null.");
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$numOrders((int) json.getInt("numOrders"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$type((int) json.getInt("type"));
            }
        }
        if (json.has("cant")) {
            if (json.isNull("cant")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cant' to null.");
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$cant((int) json.getInt("cant"));
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                ((GeoLocationRealmProxyInterface) obj).realmSet$date(null);
            } else {
                ((GeoLocationRealmProxyInterface) obj).realmSet$date((String) json.getString("date"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.GeoLocation createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mobile.polux.models.GeoLocation obj = new com.mobile.polux.models.GeoLocation();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("clientId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$clientId(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$clientId((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("clientName")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$clientName(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$clientName((String) reader.nextString());
                }
            } else if (name.equals("codigoLocalidad")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$codigoLocalidad(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$codigoLocalidad((int) reader.nextInt());
                }
            } else if (name.equals("address")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$address(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$address((String) reader.nextString());
                }
            } else if (name.equals("latitude")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$latitude(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$latitude((String) reader.nextString());
                }
            } else if (name.equals("longitude")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$longitude(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$longitude((String) reader.nextString());
                }
            } else if (name.equals("zone")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$zone(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$zone((String) reader.nextString());
                }
            } else if (name.equals("day")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$day(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$day((String) reader.nextString());
                }
            } else if (name.equals("reference")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$reference(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$reference((String) reader.nextString());
                }
            } else if (name.equals("clientType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$clientType(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$clientType((String) reader.nextString());
                }
            } else if (name.equals("businessType")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$businessType(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$businessType((String) reader.nextString());
                }
            } else if (name.equals("numVisits")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'numVisits' to null.");
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$numVisits((int) reader.nextInt());
                }
            } else if (name.equals("numOrders")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'numOrders' to null.");
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$numOrders((int) reader.nextInt());
                }
            } else if (name.equals("type")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$type((int) reader.nextInt());
                }
            } else if (name.equals("cant")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cant' to null.");
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$cant((int) reader.nextInt());
                }
            } else if (name.equals("date")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GeoLocationRealmProxyInterface) obj).realmSet$date(null);
                } else {
                    ((GeoLocationRealmProxyInterface) obj).realmSet$date((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'clientId'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.GeoLocation copyOrUpdate(Realm realm, com.mobile.polux.models.GeoLocation object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.GeoLocation) cachedRealmObject;
        } else {
            com.mobile.polux.models.GeoLocation realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.mobile.polux.models.GeoLocation.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((GeoLocationRealmProxyInterface) object).realmGet$clientId();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.GeoLocation.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.GeoLocationRealmProxy();
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

    public static com.mobile.polux.models.GeoLocation copy(Realm realm, com.mobile.polux.models.GeoLocation newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.GeoLocation) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.GeoLocation realmObject = realm.createObjectInternal(com.mobile.polux.models.GeoLocation.class, ((GeoLocationRealmProxyInterface) newObject).realmGet$clientId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$clientName(((GeoLocationRealmProxyInterface) newObject).realmGet$clientName());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$codigoLocalidad(((GeoLocationRealmProxyInterface) newObject).realmGet$codigoLocalidad());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$address(((GeoLocationRealmProxyInterface) newObject).realmGet$address());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$latitude(((GeoLocationRealmProxyInterface) newObject).realmGet$latitude());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$longitude(((GeoLocationRealmProxyInterface) newObject).realmGet$longitude());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$zone(((GeoLocationRealmProxyInterface) newObject).realmGet$zone());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$day(((GeoLocationRealmProxyInterface) newObject).realmGet$day());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$reference(((GeoLocationRealmProxyInterface) newObject).realmGet$reference());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$clientType(((GeoLocationRealmProxyInterface) newObject).realmGet$clientType());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$businessType(((GeoLocationRealmProxyInterface) newObject).realmGet$businessType());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$numVisits(((GeoLocationRealmProxyInterface) newObject).realmGet$numVisits());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$numOrders(((GeoLocationRealmProxyInterface) newObject).realmGet$numOrders());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$type(((GeoLocationRealmProxyInterface) newObject).realmGet$type());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$cant(((GeoLocationRealmProxyInterface) newObject).realmGet$cant());
            ((GeoLocationRealmProxyInterface) realmObject).realmSet$date(((GeoLocationRealmProxyInterface) newObject).realmGet$date());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.GeoLocation object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.GeoLocation.class);
        long tableNativePtr = table.getNativePtr();
        GeoLocationColumnInfo columnInfo = (GeoLocationColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.GeoLocation.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((GeoLocationRealmProxyInterface) object).realmGet$clientId();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GeoLocationRealmProxyInterface) object).realmGet$clientId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((GeoLocationRealmProxyInterface) object).realmGet$clientId());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$clientName = ((GeoLocationRealmProxyInterface)object).realmGet$clientName();
        if (realmGet$clientName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.clientNameIndex, rowIndex, realmGet$clientName, false);
        }
        Number realmGet$codigoLocalidad = ((GeoLocationRealmProxyInterface)object).realmGet$codigoLocalidad();
        if (realmGet$codigoLocalidad != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, realmGet$codigoLocalidad.longValue(), false);
        }
        String realmGet$address = ((GeoLocationRealmProxyInterface)object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        }
        String realmGet$latitude = ((GeoLocationRealmProxyInterface)object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
        }
        String realmGet$longitude = ((GeoLocationRealmProxyInterface)object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
        }
        String realmGet$zone = ((GeoLocationRealmProxyInterface)object).realmGet$zone();
        if (realmGet$zone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.zoneIndex, rowIndex, realmGet$zone, false);
        }
        String realmGet$day = ((GeoLocationRealmProxyInterface)object).realmGet$day();
        if (realmGet$day != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dayIndex, rowIndex, realmGet$day, false);
        }
        String realmGet$reference = ((GeoLocationRealmProxyInterface)object).realmGet$reference();
        if (realmGet$reference != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.referenceIndex, rowIndex, realmGet$reference, false);
        }
        String realmGet$clientType = ((GeoLocationRealmProxyInterface)object).realmGet$clientType();
        if (realmGet$clientType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.clientTypeIndex, rowIndex, realmGet$clientType, false);
        }
        String realmGet$businessType = ((GeoLocationRealmProxyInterface)object).realmGet$businessType();
        if (realmGet$businessType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.businessTypeIndex, rowIndex, realmGet$businessType, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.numVisitsIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$numVisits(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.numOrdersIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$numOrders(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$type(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$cant(), false);
        String realmGet$date = ((GeoLocationRealmProxyInterface)object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.GeoLocation.class);
        long tableNativePtr = table.getNativePtr();
        GeoLocationColumnInfo columnInfo = (GeoLocationColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.GeoLocation.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.GeoLocation object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.GeoLocation) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((GeoLocationRealmProxyInterface) object).realmGet$clientId();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GeoLocationRealmProxyInterface) object).realmGet$clientId());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((GeoLocationRealmProxyInterface) object).realmGet$clientId());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$clientName = ((GeoLocationRealmProxyInterface)object).realmGet$clientName();
                if (realmGet$clientName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.clientNameIndex, rowIndex, realmGet$clientName, false);
                }
                Number realmGet$codigoLocalidad = ((GeoLocationRealmProxyInterface)object).realmGet$codigoLocalidad();
                if (realmGet$codigoLocalidad != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, realmGet$codigoLocalidad.longValue(), false);
                }
                String realmGet$address = ((GeoLocationRealmProxyInterface)object).realmGet$address();
                if (realmGet$address != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
                }
                String realmGet$latitude = ((GeoLocationRealmProxyInterface)object).realmGet$latitude();
                if (realmGet$latitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
                }
                String realmGet$longitude = ((GeoLocationRealmProxyInterface)object).realmGet$longitude();
                if (realmGet$longitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
                }
                String realmGet$zone = ((GeoLocationRealmProxyInterface)object).realmGet$zone();
                if (realmGet$zone != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.zoneIndex, rowIndex, realmGet$zone, false);
                }
                String realmGet$day = ((GeoLocationRealmProxyInterface)object).realmGet$day();
                if (realmGet$day != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dayIndex, rowIndex, realmGet$day, false);
                }
                String realmGet$reference = ((GeoLocationRealmProxyInterface)object).realmGet$reference();
                if (realmGet$reference != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.referenceIndex, rowIndex, realmGet$reference, false);
                }
                String realmGet$clientType = ((GeoLocationRealmProxyInterface)object).realmGet$clientType();
                if (realmGet$clientType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.clientTypeIndex, rowIndex, realmGet$clientType, false);
                }
                String realmGet$businessType = ((GeoLocationRealmProxyInterface)object).realmGet$businessType();
                if (realmGet$businessType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.businessTypeIndex, rowIndex, realmGet$businessType, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.numVisitsIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$numVisits(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.numOrdersIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$numOrders(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$type(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$cant(), false);
                String realmGet$date = ((GeoLocationRealmProxyInterface)object).realmGet$date();
                if (realmGet$date != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.GeoLocation object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.GeoLocation.class);
        long tableNativePtr = table.getNativePtr();
        GeoLocationColumnInfo columnInfo = (GeoLocationColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.GeoLocation.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((GeoLocationRealmProxyInterface) object).realmGet$clientId();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GeoLocationRealmProxyInterface) object).realmGet$clientId());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((GeoLocationRealmProxyInterface) object).realmGet$clientId());
        }
        cache.put(object, rowIndex);
        String realmGet$clientName = ((GeoLocationRealmProxyInterface)object).realmGet$clientName();
        if (realmGet$clientName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.clientNameIndex, rowIndex, realmGet$clientName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.clientNameIndex, rowIndex, false);
        }
        Number realmGet$codigoLocalidad = ((GeoLocationRealmProxyInterface)object).realmGet$codigoLocalidad();
        if (realmGet$codigoLocalidad != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, realmGet$codigoLocalidad.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, false);
        }
        String realmGet$address = ((GeoLocationRealmProxyInterface)object).realmGet$address();
        if (realmGet$address != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
        }
        String realmGet$latitude = ((GeoLocationRealmProxyInterface)object).realmGet$latitude();
        if (realmGet$latitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.latitudeIndex, rowIndex, false);
        }
        String realmGet$longitude = ((GeoLocationRealmProxyInterface)object).realmGet$longitude();
        if (realmGet$longitude != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.longitudeIndex, rowIndex, false);
        }
        String realmGet$zone = ((GeoLocationRealmProxyInterface)object).realmGet$zone();
        if (realmGet$zone != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.zoneIndex, rowIndex, realmGet$zone, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.zoneIndex, rowIndex, false);
        }
        String realmGet$day = ((GeoLocationRealmProxyInterface)object).realmGet$day();
        if (realmGet$day != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dayIndex, rowIndex, realmGet$day, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dayIndex, rowIndex, false);
        }
        String realmGet$reference = ((GeoLocationRealmProxyInterface)object).realmGet$reference();
        if (realmGet$reference != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.referenceIndex, rowIndex, realmGet$reference, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.referenceIndex, rowIndex, false);
        }
        String realmGet$clientType = ((GeoLocationRealmProxyInterface)object).realmGet$clientType();
        if (realmGet$clientType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.clientTypeIndex, rowIndex, realmGet$clientType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.clientTypeIndex, rowIndex, false);
        }
        String realmGet$businessType = ((GeoLocationRealmProxyInterface)object).realmGet$businessType();
        if (realmGet$businessType != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.businessTypeIndex, rowIndex, realmGet$businessType, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.businessTypeIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.numVisitsIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$numVisits(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.numOrdersIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$numOrders(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$type(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$cant(), false);
        String realmGet$date = ((GeoLocationRealmProxyInterface)object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.GeoLocation.class);
        long tableNativePtr = table.getNativePtr();
        GeoLocationColumnInfo columnInfo = (GeoLocationColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.GeoLocation.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.GeoLocation object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.GeoLocation) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((GeoLocationRealmProxyInterface) object).realmGet$clientId();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GeoLocationRealmProxyInterface) object).realmGet$clientId());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((GeoLocationRealmProxyInterface) object).realmGet$clientId());
                }
                cache.put(object, rowIndex);
                String realmGet$clientName = ((GeoLocationRealmProxyInterface)object).realmGet$clientName();
                if (realmGet$clientName != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.clientNameIndex, rowIndex, realmGet$clientName, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.clientNameIndex, rowIndex, false);
                }
                Number realmGet$codigoLocalidad = ((GeoLocationRealmProxyInterface)object).realmGet$codigoLocalidad();
                if (realmGet$codigoLocalidad != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, realmGet$codigoLocalidad.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, false);
                }
                String realmGet$address = ((GeoLocationRealmProxyInterface)object).realmGet$address();
                if (realmGet$address != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.addressIndex, rowIndex, realmGet$address, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.addressIndex, rowIndex, false);
                }
                String realmGet$latitude = ((GeoLocationRealmProxyInterface)object).realmGet$latitude();
                if (realmGet$latitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.latitudeIndex, rowIndex, realmGet$latitude, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.latitudeIndex, rowIndex, false);
                }
                String realmGet$longitude = ((GeoLocationRealmProxyInterface)object).realmGet$longitude();
                if (realmGet$longitude != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.longitudeIndex, rowIndex, realmGet$longitude, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.longitudeIndex, rowIndex, false);
                }
                String realmGet$zone = ((GeoLocationRealmProxyInterface)object).realmGet$zone();
                if (realmGet$zone != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.zoneIndex, rowIndex, realmGet$zone, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.zoneIndex, rowIndex, false);
                }
                String realmGet$day = ((GeoLocationRealmProxyInterface)object).realmGet$day();
                if (realmGet$day != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dayIndex, rowIndex, realmGet$day, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dayIndex, rowIndex, false);
                }
                String realmGet$reference = ((GeoLocationRealmProxyInterface)object).realmGet$reference();
                if (realmGet$reference != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.referenceIndex, rowIndex, realmGet$reference, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.referenceIndex, rowIndex, false);
                }
                String realmGet$clientType = ((GeoLocationRealmProxyInterface)object).realmGet$clientType();
                if (realmGet$clientType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.clientTypeIndex, rowIndex, realmGet$clientType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.clientTypeIndex, rowIndex, false);
                }
                String realmGet$businessType = ((GeoLocationRealmProxyInterface)object).realmGet$businessType();
                if (realmGet$businessType != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.businessTypeIndex, rowIndex, realmGet$businessType, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.businessTypeIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.numVisitsIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$numVisits(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.numOrdersIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$numOrders(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$type(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, ((GeoLocationRealmProxyInterface)object).realmGet$cant(), false);
                String realmGet$date = ((GeoLocationRealmProxyInterface)object).realmGet$date();
                if (realmGet$date != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.mobile.polux.models.GeoLocation createDetachedCopy(com.mobile.polux.models.GeoLocation realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.GeoLocation unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.GeoLocation)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.GeoLocation)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.GeoLocation();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$clientId(((GeoLocationRealmProxyInterface) realmObject).realmGet$clientId());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$clientName(((GeoLocationRealmProxyInterface) realmObject).realmGet$clientName());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$codigoLocalidad(((GeoLocationRealmProxyInterface) realmObject).realmGet$codigoLocalidad());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$address(((GeoLocationRealmProxyInterface) realmObject).realmGet$address());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$latitude(((GeoLocationRealmProxyInterface) realmObject).realmGet$latitude());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$longitude(((GeoLocationRealmProxyInterface) realmObject).realmGet$longitude());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$zone(((GeoLocationRealmProxyInterface) realmObject).realmGet$zone());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$day(((GeoLocationRealmProxyInterface) realmObject).realmGet$day());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$reference(((GeoLocationRealmProxyInterface) realmObject).realmGet$reference());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$clientType(((GeoLocationRealmProxyInterface) realmObject).realmGet$clientType());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$businessType(((GeoLocationRealmProxyInterface) realmObject).realmGet$businessType());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$numVisits(((GeoLocationRealmProxyInterface) realmObject).realmGet$numVisits());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$numOrders(((GeoLocationRealmProxyInterface) realmObject).realmGet$numOrders());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$type(((GeoLocationRealmProxyInterface) realmObject).realmGet$type());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$cant(((GeoLocationRealmProxyInterface) realmObject).realmGet$cant());
        ((GeoLocationRealmProxyInterface) unmanagedObject).realmSet$date(((GeoLocationRealmProxyInterface) realmObject).realmGet$date());
        return unmanagedObject;
    }

    static com.mobile.polux.models.GeoLocation update(Realm realm, com.mobile.polux.models.GeoLocation realmObject, com.mobile.polux.models.GeoLocation newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$clientName(((GeoLocationRealmProxyInterface) newObject).realmGet$clientName());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$codigoLocalidad(((GeoLocationRealmProxyInterface) newObject).realmGet$codigoLocalidad());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$address(((GeoLocationRealmProxyInterface) newObject).realmGet$address());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$latitude(((GeoLocationRealmProxyInterface) newObject).realmGet$latitude());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$longitude(((GeoLocationRealmProxyInterface) newObject).realmGet$longitude());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$zone(((GeoLocationRealmProxyInterface) newObject).realmGet$zone());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$day(((GeoLocationRealmProxyInterface) newObject).realmGet$day());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$reference(((GeoLocationRealmProxyInterface) newObject).realmGet$reference());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$clientType(((GeoLocationRealmProxyInterface) newObject).realmGet$clientType());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$businessType(((GeoLocationRealmProxyInterface) newObject).realmGet$businessType());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$numVisits(((GeoLocationRealmProxyInterface) newObject).realmGet$numVisits());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$numOrders(((GeoLocationRealmProxyInterface) newObject).realmGet$numOrders());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$type(((GeoLocationRealmProxyInterface) newObject).realmGet$type());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$cant(((GeoLocationRealmProxyInterface) newObject).realmGet$cant());
        ((GeoLocationRealmProxyInterface) realmObject).realmSet$date(((GeoLocationRealmProxyInterface) newObject).realmGet$date());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("GeoLocation = proxy[");
        stringBuilder.append("{clientId:");
        stringBuilder.append(realmGet$clientId() != null ? realmGet$clientId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clientName:");
        stringBuilder.append(realmGet$clientName() != null ? realmGet$clientName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoLocalidad:");
        stringBuilder.append(realmGet$codigoLocalidad() != null ? realmGet$codigoLocalidad() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{address:");
        stringBuilder.append(realmGet$address() != null ? realmGet$address() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{latitude:");
        stringBuilder.append(realmGet$latitude() != null ? realmGet$latitude() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitude:");
        stringBuilder.append(realmGet$longitude() != null ? realmGet$longitude() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{zone:");
        stringBuilder.append(realmGet$zone() != null ? realmGet$zone() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{day:");
        stringBuilder.append(realmGet$day() != null ? realmGet$day() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{reference:");
        stringBuilder.append(realmGet$reference() != null ? realmGet$reference() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clientType:");
        stringBuilder.append(realmGet$clientType() != null ? realmGet$clientType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{businessType:");
        stringBuilder.append(realmGet$businessType() != null ? realmGet$businessType() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numVisits:");
        stringBuilder.append(realmGet$numVisits());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numOrders:");
        stringBuilder.append(realmGet$numOrders());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cant:");
        stringBuilder.append(realmGet$cant());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date() != null ? realmGet$date() : "null");
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
        GeoLocationRealmProxy aGeoLocation = (GeoLocationRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGeoLocation.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGeoLocation.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGeoLocation.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
