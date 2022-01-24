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

public class RateRealmProxy extends com.mobile.polux.models.Rate
    implements RealmObjectProxy, RateRealmProxyInterface {

    static final class RateColumnInfo extends ColumnInfo {
        long versionIndex;
        long esContadoIndex;
        long esCreditoIndex;

        RateColumnInfo(SharedRealm realm, Table table) {
            super(3);
            this.versionIndex = addColumnDetails(table, "version", RealmFieldType.INTEGER);
            this.esContadoIndex = addColumnDetails(table, "esContado", RealmFieldType.STRING);
            this.esCreditoIndex = addColumnDetails(table, "esCredito", RealmFieldType.STRING);
        }

        RateColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new RateColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final RateColumnInfo src = (RateColumnInfo) rawSrc;
            final RateColumnInfo dst = (RateColumnInfo) rawDst;
            dst.versionIndex = src.versionIndex;
            dst.esContadoIndex = src.esContadoIndex;
            dst.esCreditoIndex = src.esCreditoIndex;
        }
    }

    private RateColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Rate> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("version");
        fieldNames.add("esContado");
        fieldNames.add("esCredito");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    RateRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (RateColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Rate>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$version() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.versionIndex);
    }

    @Override
    public void realmSet$version(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.versionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.versionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$esContado() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.esContadoIndex);
    }

    @Override
    public void realmSet$esContado(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.esContadoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.esContadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.esContadoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.esContadoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$esCredito() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.esCreditoIndex);
    }

    @Override
    public void realmSet$esCredito(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.esCreditoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.esCreditoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.esCreditoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.esCreditoIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Rate")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Rate");
            realmObjectSchema.add("version", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("esContado", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("esCredito", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Rate");
    }

    public static RateColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Rate")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Rate' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Rate");
        final long columnCount = table.getColumnCount();
        if (columnCount != 3) {
            if (columnCount < 3) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 3 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 3 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 3 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final RateColumnInfo columnInfo = new RateColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("version")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'version' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("version") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'version' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.versionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'version' does support null values in the existing Realm file. Use corresponding boxed type for field 'version' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("esContado")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'esContado' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("esContado") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'esContado' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.esContadoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'esContado' is required. Either set @Required to field 'esContado' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("esCredito")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'esCredito' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("esCredito") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'esCredito' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.esCreditoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'esCredito' is required. Either set @Required to field 'esCredito' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Rate";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Rate createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mobile.polux.models.Rate obj = realm.createObjectInternal(com.mobile.polux.models.Rate.class, true, excludeFields);
        if (json.has("version")) {
            if (json.isNull("version")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'version' to null.");
            } else {
                ((RateRealmProxyInterface) obj).realmSet$version((int) json.getInt("version"));
            }
        }
        if (json.has("esContado")) {
            if (json.isNull("esContado")) {
                ((RateRealmProxyInterface) obj).realmSet$esContado(null);
            } else {
                ((RateRealmProxyInterface) obj).realmSet$esContado((String) json.getString("esContado"));
            }
        }
        if (json.has("esCredito")) {
            if (json.isNull("esCredito")) {
                ((RateRealmProxyInterface) obj).realmSet$esCredito(null);
            } else {
                ((RateRealmProxyInterface) obj).realmSet$esCredito((String) json.getString("esCredito"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Rate createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.mobile.polux.models.Rate obj = new com.mobile.polux.models.Rate();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("version")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'version' to null.");
                } else {
                    ((RateRealmProxyInterface) obj).realmSet$version((int) reader.nextInt());
                }
            } else if (name.equals("esContado")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RateRealmProxyInterface) obj).realmSet$esContado(null);
                } else {
                    ((RateRealmProxyInterface) obj).realmSet$esContado((String) reader.nextString());
                }
            } else if (name.equals("esCredito")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((RateRealmProxyInterface) obj).realmSet$esCredito(null);
                } else {
                    ((RateRealmProxyInterface) obj).realmSet$esCredito((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.Rate copyOrUpdate(Realm realm, com.mobile.polux.models.Rate object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Rate) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.mobile.polux.models.Rate copy(Realm realm, com.mobile.polux.models.Rate newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Rate) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Rate realmObject = realm.createObjectInternal(com.mobile.polux.models.Rate.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((RateRealmProxyInterface) realmObject).realmSet$version(((RateRealmProxyInterface) newObject).realmGet$version());
            ((RateRealmProxyInterface) realmObject).realmSet$esContado(((RateRealmProxyInterface) newObject).realmGet$esContado());
            ((RateRealmProxyInterface) realmObject).realmSet$esCredito(((RateRealmProxyInterface) newObject).realmGet$esCredito());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Rate object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Rate.class);
        long tableNativePtr = table.getNativePtr();
        RateColumnInfo columnInfo = (RateColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Rate.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, ((RateRealmProxyInterface)object).realmGet$version(), false);
        String realmGet$esContado = ((RateRealmProxyInterface)object).realmGet$esContado();
        if (realmGet$esContado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esContadoIndex, rowIndex, realmGet$esContado, false);
        }
        String realmGet$esCredito = ((RateRealmProxyInterface)object).realmGet$esCredito();
        if (realmGet$esCredito != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esCreditoIndex, rowIndex, realmGet$esCredito, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Rate.class);
        long tableNativePtr = table.getNativePtr();
        RateColumnInfo columnInfo = (RateColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Rate.class);
        com.mobile.polux.models.Rate object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Rate) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, ((RateRealmProxyInterface)object).realmGet$version(), false);
                String realmGet$esContado = ((RateRealmProxyInterface)object).realmGet$esContado();
                if (realmGet$esContado != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esContadoIndex, rowIndex, realmGet$esContado, false);
                }
                String realmGet$esCredito = ((RateRealmProxyInterface)object).realmGet$esCredito();
                if (realmGet$esCredito != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esCreditoIndex, rowIndex, realmGet$esCredito, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Rate object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Rate.class);
        long tableNativePtr = table.getNativePtr();
        RateColumnInfo columnInfo = (RateColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Rate.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, ((RateRealmProxyInterface)object).realmGet$version(), false);
        String realmGet$esContado = ((RateRealmProxyInterface)object).realmGet$esContado();
        if (realmGet$esContado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esContadoIndex, rowIndex, realmGet$esContado, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.esContadoIndex, rowIndex, false);
        }
        String realmGet$esCredito = ((RateRealmProxyInterface)object).realmGet$esCredito();
        if (realmGet$esCredito != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esCreditoIndex, rowIndex, realmGet$esCredito, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.esCreditoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Rate.class);
        long tableNativePtr = table.getNativePtr();
        RateColumnInfo columnInfo = (RateColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Rate.class);
        com.mobile.polux.models.Rate object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Rate) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, ((RateRealmProxyInterface)object).realmGet$version(), false);
                String realmGet$esContado = ((RateRealmProxyInterface)object).realmGet$esContado();
                if (realmGet$esContado != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esContadoIndex, rowIndex, realmGet$esContado, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.esContadoIndex, rowIndex, false);
                }
                String realmGet$esCredito = ((RateRealmProxyInterface)object).realmGet$esCredito();
                if (realmGet$esCredito != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esCreditoIndex, rowIndex, realmGet$esCredito, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.esCreditoIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.mobile.polux.models.Rate createDetachedCopy(com.mobile.polux.models.Rate realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Rate unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Rate)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Rate)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Rate();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((RateRealmProxyInterface) unmanagedObject).realmSet$version(((RateRealmProxyInterface) realmObject).realmGet$version());
        ((RateRealmProxyInterface) unmanagedObject).realmSet$esContado(((RateRealmProxyInterface) realmObject).realmGet$esContado());
        ((RateRealmProxyInterface) unmanagedObject).realmSet$esCredito(((RateRealmProxyInterface) realmObject).realmGet$esCredito());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Rate = proxy[");
        stringBuilder.append("{version:");
        stringBuilder.append(realmGet$version());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{esContado:");
        stringBuilder.append(realmGet$esContado() != null ? realmGet$esContado() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{esCredito:");
        stringBuilder.append(realmGet$esCredito() != null ? realmGet$esCredito() : "null");
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
        RateRealmProxy aRate = (RateRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aRate.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aRate.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aRate.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
