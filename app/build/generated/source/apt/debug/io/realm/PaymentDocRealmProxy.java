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

public class PaymentDocRealmProxy extends com.mobile.polux.models.PaymentDoc
    implements RealmObjectProxy, PaymentDocRealmProxyInterface {

    static final class PaymentDocColumnInfo extends ColumnInfo {
        long idIndex;
        long valueIndex;
        long dateIndex;
        long tipoIndex;
        long numCuentaIndex;
        long bancoIndex;

        PaymentDocColumnInfo(SharedRealm realm, Table table) {
            super(6);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.valueIndex = addColumnDetails(table, "value", RealmFieldType.DOUBLE);
            this.dateIndex = addColumnDetails(table, "date", RealmFieldType.STRING);
            this.tipoIndex = addColumnDetails(table, "tipo", RealmFieldType.STRING);
            this.numCuentaIndex = addColumnDetails(table, "numCuenta", RealmFieldType.STRING);
            this.bancoIndex = addColumnDetails(table, "banco", RealmFieldType.INTEGER);
        }

        PaymentDocColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PaymentDocColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PaymentDocColumnInfo src = (PaymentDocColumnInfo) rawSrc;
            final PaymentDocColumnInfo dst = (PaymentDocColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.valueIndex = src.valueIndex;
            dst.dateIndex = src.dateIndex;
            dst.tipoIndex = src.tipoIndex;
            dst.numCuentaIndex = src.numCuentaIndex;
            dst.bancoIndex = src.bancoIndex;
        }
    }

    private PaymentDocColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.PaymentDoc> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("value");
        fieldNames.add("date");
        fieldNames.add("tipo");
        fieldNames.add("numCuenta");
        fieldNames.add("banco");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PaymentDocRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PaymentDocColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.PaymentDoc>(this);
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
    public double realmGet$value() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.valueIndex);
    }

    @Override
    public void realmSet$value(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.valueIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.valueIndex, value);
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
    @SuppressWarnings("cast")
    public String realmGet$tipo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tipoIndex);
    }

    @Override
    public void realmSet$tipo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tipoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tipoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tipoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tipoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$numCuenta() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.numCuentaIndex);
    }

    @Override
    public void realmSet$numCuenta(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.numCuentaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.numCuentaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.numCuentaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.numCuentaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$banco() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.bancoIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.bancoIndex);
    }

    @Override
    public void realmSet$banco(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.bancoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.bancoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.bancoIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.bancoIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("PaymentDoc")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("PaymentDoc");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("value", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("date", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("tipo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("numCuenta", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("banco", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("PaymentDoc");
    }

    public static PaymentDocColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_PaymentDoc")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'PaymentDoc' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_PaymentDoc");
        final long columnCount = table.getColumnCount();
        if (columnCount != 6) {
            if (columnCount < 6) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 6 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 6 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 6 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final PaymentDocColumnInfo columnInfo = new PaymentDocColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
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
        if (!columnTypes.containsKey("value")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'value' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("value") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'value' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.valueIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'value' does support null values in the existing Realm file. Use corresponding boxed type for field 'value' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("tipo")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'tipo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("tipo") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'tipo' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.tipoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'tipo' is required. Either set @Required to field 'tipo' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("numCuenta")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numCuenta' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("numCuenta") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'numCuenta' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.numCuentaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'numCuenta' is required. Either set @Required to field 'numCuenta' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("banco")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'banco' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("banco") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'banco' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.bancoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'banco' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'banco' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_PaymentDoc";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.PaymentDoc createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mobile.polux.models.PaymentDoc obj = realm.createObjectInternal(com.mobile.polux.models.PaymentDoc.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((PaymentDocRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("value")) {
            if (json.isNull("value")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'value' to null.");
            } else {
                ((PaymentDocRealmProxyInterface) obj).realmSet$value((double) json.getDouble("value"));
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                ((PaymentDocRealmProxyInterface) obj).realmSet$date(null);
            } else {
                ((PaymentDocRealmProxyInterface) obj).realmSet$date((String) json.getString("date"));
            }
        }
        if (json.has("tipo")) {
            if (json.isNull("tipo")) {
                ((PaymentDocRealmProxyInterface) obj).realmSet$tipo(null);
            } else {
                ((PaymentDocRealmProxyInterface) obj).realmSet$tipo((String) json.getString("tipo"));
            }
        }
        if (json.has("numCuenta")) {
            if (json.isNull("numCuenta")) {
                ((PaymentDocRealmProxyInterface) obj).realmSet$numCuenta(null);
            } else {
                ((PaymentDocRealmProxyInterface) obj).realmSet$numCuenta((String) json.getString("numCuenta"));
            }
        }
        if (json.has("banco")) {
            if (json.isNull("banco")) {
                ((PaymentDocRealmProxyInterface) obj).realmSet$banco(null);
            } else {
                ((PaymentDocRealmProxyInterface) obj).realmSet$banco((int) json.getInt("banco"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.PaymentDoc createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.mobile.polux.models.PaymentDoc obj = new com.mobile.polux.models.PaymentDoc();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((PaymentDocRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("value")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'value' to null.");
                } else {
                    ((PaymentDocRealmProxyInterface) obj).realmSet$value((double) reader.nextDouble());
                }
            } else if (name.equals("date")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentDocRealmProxyInterface) obj).realmSet$date(null);
                } else {
                    ((PaymentDocRealmProxyInterface) obj).realmSet$date((String) reader.nextString());
                }
            } else if (name.equals("tipo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentDocRealmProxyInterface) obj).realmSet$tipo(null);
                } else {
                    ((PaymentDocRealmProxyInterface) obj).realmSet$tipo((String) reader.nextString());
                }
            } else if (name.equals("numCuenta")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentDocRealmProxyInterface) obj).realmSet$numCuenta(null);
                } else {
                    ((PaymentDocRealmProxyInterface) obj).realmSet$numCuenta((String) reader.nextString());
                }
            } else if (name.equals("banco")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentDocRealmProxyInterface) obj).realmSet$banco(null);
                } else {
                    ((PaymentDocRealmProxyInterface) obj).realmSet$banco((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.PaymentDoc copyOrUpdate(Realm realm, com.mobile.polux.models.PaymentDoc object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.PaymentDoc) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.mobile.polux.models.PaymentDoc copy(Realm realm, com.mobile.polux.models.PaymentDoc newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.PaymentDoc) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.PaymentDoc realmObject = realm.createObjectInternal(com.mobile.polux.models.PaymentDoc.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((PaymentDocRealmProxyInterface) realmObject).realmSet$id(((PaymentDocRealmProxyInterface) newObject).realmGet$id());
            ((PaymentDocRealmProxyInterface) realmObject).realmSet$value(((PaymentDocRealmProxyInterface) newObject).realmGet$value());
            ((PaymentDocRealmProxyInterface) realmObject).realmSet$date(((PaymentDocRealmProxyInterface) newObject).realmGet$date());
            ((PaymentDocRealmProxyInterface) realmObject).realmSet$tipo(((PaymentDocRealmProxyInterface) newObject).realmGet$tipo());
            ((PaymentDocRealmProxyInterface) realmObject).realmSet$numCuenta(((PaymentDocRealmProxyInterface) newObject).realmGet$numCuenta());
            ((PaymentDocRealmProxyInterface) realmObject).realmSet$banco(((PaymentDocRealmProxyInterface) newObject).realmGet$banco());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.PaymentDoc object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.PaymentDoc.class);
        long tableNativePtr = table.getNativePtr();
        PaymentDocColumnInfo columnInfo = (PaymentDocColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.PaymentDoc.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((PaymentDocRealmProxyInterface)object).realmGet$id(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.valueIndex, rowIndex, ((PaymentDocRealmProxyInterface)object).realmGet$value(), false);
        String realmGet$date = ((PaymentDocRealmProxyInterface)object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        }
        String realmGet$tipo = ((PaymentDocRealmProxyInterface)object).realmGet$tipo();
        if (realmGet$tipo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tipoIndex, rowIndex, realmGet$tipo, false);
        }
        String realmGet$numCuenta = ((PaymentDocRealmProxyInterface)object).realmGet$numCuenta();
        if (realmGet$numCuenta != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, realmGet$numCuenta, false);
        }
        Number realmGet$banco = ((PaymentDocRealmProxyInterface)object).realmGet$banco();
        if (realmGet$banco != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.bancoIndex, rowIndex, realmGet$banco.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.PaymentDoc.class);
        long tableNativePtr = table.getNativePtr();
        PaymentDocColumnInfo columnInfo = (PaymentDocColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.PaymentDoc.class);
        com.mobile.polux.models.PaymentDoc object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.PaymentDoc) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((PaymentDocRealmProxyInterface)object).realmGet$id(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.valueIndex, rowIndex, ((PaymentDocRealmProxyInterface)object).realmGet$value(), false);
                String realmGet$date = ((PaymentDocRealmProxyInterface)object).realmGet$date();
                if (realmGet$date != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
                }
                String realmGet$tipo = ((PaymentDocRealmProxyInterface)object).realmGet$tipo();
                if (realmGet$tipo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.tipoIndex, rowIndex, realmGet$tipo, false);
                }
                String realmGet$numCuenta = ((PaymentDocRealmProxyInterface)object).realmGet$numCuenta();
                if (realmGet$numCuenta != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, realmGet$numCuenta, false);
                }
                Number realmGet$banco = ((PaymentDocRealmProxyInterface)object).realmGet$banco();
                if (realmGet$banco != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.bancoIndex, rowIndex, realmGet$banco.longValue(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.PaymentDoc object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.PaymentDoc.class);
        long tableNativePtr = table.getNativePtr();
        PaymentDocColumnInfo columnInfo = (PaymentDocColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.PaymentDoc.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((PaymentDocRealmProxyInterface)object).realmGet$id(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.valueIndex, rowIndex, ((PaymentDocRealmProxyInterface)object).realmGet$value(), false);
        String realmGet$date = ((PaymentDocRealmProxyInterface)object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
        }
        String realmGet$tipo = ((PaymentDocRealmProxyInterface)object).realmGet$tipo();
        if (realmGet$tipo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tipoIndex, rowIndex, realmGet$tipo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tipoIndex, rowIndex, false);
        }
        String realmGet$numCuenta = ((PaymentDocRealmProxyInterface)object).realmGet$numCuenta();
        if (realmGet$numCuenta != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, realmGet$numCuenta, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, false);
        }
        Number realmGet$banco = ((PaymentDocRealmProxyInterface)object).realmGet$banco();
        if (realmGet$banco != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.bancoIndex, rowIndex, realmGet$banco.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.bancoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.PaymentDoc.class);
        long tableNativePtr = table.getNativePtr();
        PaymentDocColumnInfo columnInfo = (PaymentDocColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.PaymentDoc.class);
        com.mobile.polux.models.PaymentDoc object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.PaymentDoc) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((PaymentDocRealmProxyInterface)object).realmGet$id(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.valueIndex, rowIndex, ((PaymentDocRealmProxyInterface)object).realmGet$value(), false);
                String realmGet$date = ((PaymentDocRealmProxyInterface)object).realmGet$date();
                if (realmGet$date != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
                }
                String realmGet$tipo = ((PaymentDocRealmProxyInterface)object).realmGet$tipo();
                if (realmGet$tipo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.tipoIndex, rowIndex, realmGet$tipo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.tipoIndex, rowIndex, false);
                }
                String realmGet$numCuenta = ((PaymentDocRealmProxyInterface)object).realmGet$numCuenta();
                if (realmGet$numCuenta != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, realmGet$numCuenta, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, false);
                }
                Number realmGet$banco = ((PaymentDocRealmProxyInterface)object).realmGet$banco();
                if (realmGet$banco != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.bancoIndex, rowIndex, realmGet$banco.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.bancoIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.mobile.polux.models.PaymentDoc createDetachedCopy(com.mobile.polux.models.PaymentDoc realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.PaymentDoc unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.PaymentDoc)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.PaymentDoc)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.PaymentDoc();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((PaymentDocRealmProxyInterface) unmanagedObject).realmSet$id(((PaymentDocRealmProxyInterface) realmObject).realmGet$id());
        ((PaymentDocRealmProxyInterface) unmanagedObject).realmSet$value(((PaymentDocRealmProxyInterface) realmObject).realmGet$value());
        ((PaymentDocRealmProxyInterface) unmanagedObject).realmSet$date(((PaymentDocRealmProxyInterface) realmObject).realmGet$date());
        ((PaymentDocRealmProxyInterface) unmanagedObject).realmSet$tipo(((PaymentDocRealmProxyInterface) realmObject).realmGet$tipo());
        ((PaymentDocRealmProxyInterface) unmanagedObject).realmSet$numCuenta(((PaymentDocRealmProxyInterface) realmObject).realmGet$numCuenta());
        ((PaymentDocRealmProxyInterface) unmanagedObject).realmSet$banco(((PaymentDocRealmProxyInterface) realmObject).realmGet$banco());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("PaymentDoc = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{value:");
        stringBuilder.append(realmGet$value());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date() != null ? realmGet$date() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tipo:");
        stringBuilder.append(realmGet$tipo() != null ? realmGet$tipo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numCuenta:");
        stringBuilder.append(realmGet$numCuenta() != null ? realmGet$numCuenta() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{banco:");
        stringBuilder.append(realmGet$banco() != null ? realmGet$banco() : "null");
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
        PaymentDocRealmProxy aPaymentDoc = (PaymentDocRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPaymentDoc.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPaymentDoc.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPaymentDoc.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
