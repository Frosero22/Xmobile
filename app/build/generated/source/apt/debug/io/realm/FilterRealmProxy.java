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

public class FilterRealmProxy extends com.mobile.polux.models.Filter
    implements RealmObjectProxy, FilterRealmProxyInterface {

    static final class FilterColumnInfo extends ColumnInfo {
        long idIndex;
        long textIndex;
        long typeIndex;
        long dateIndex;

        FilterColumnInfo(SharedRealm realm, Table table) {
            super(4);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.STRING);
            this.textIndex = addColumnDetails(table, "text", RealmFieldType.STRING);
            this.typeIndex = addColumnDetails(table, "type", RealmFieldType.STRING);
            this.dateIndex = addColumnDetails(table, "date", RealmFieldType.DATE);
        }

        FilterColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new FilterColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final FilterColumnInfo src = (FilterColumnInfo) rawSrc;
            final FilterColumnInfo dst = (FilterColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.textIndex = src.textIndex;
            dst.typeIndex = src.typeIndex;
            dst.dateIndex = src.dateIndex;
        }
    }

    private FilterColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Filter> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("text");
        fieldNames.add("type");
        fieldNames.add("date");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    FilterRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (FilterColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Filter>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$text() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.textIndex);
    }

    @Override
    public void realmSet$text(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.textIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.textIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.textIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.textIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$type() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.typeIndex);
    }

    @Override
    public void realmSet$type(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.typeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.typeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.typeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.dateIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.dateIndex);
    }

    @Override
    public void realmSet$date(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.dateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.dateIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.dateIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Filter")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Filter");
            realmObjectSchema.add("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("text", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("type", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("date", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Filter");
    }

    public static FilterColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Filter")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Filter' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Filter");
        final long columnCount = table.getColumnCount();
        if (columnCount != 4) {
            if (columnCount < 4) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 4 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 4 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 4 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final FilterColumnInfo columnInfo = new FilterColumnInfo(sharedRealm, table);

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
        if (columnTypes.get("id") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("text")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'text' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("text") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'text' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.textIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'text' is required. Either set @Required to field 'text' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("type")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("type") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'type' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.typeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'type' is required. Either set @Required to field 'type' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("date")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'date' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("date") != RealmFieldType.DATE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Date' for field 'date' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.dateIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'date' is required. Either set @Required to field 'date' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Filter";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Filter createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mobile.polux.models.Filter obj = null;
        if (update) {
            Table table = realm.getTable(com.mobile.polux.models.Filter.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Filter.class), false, Collections.<String> emptyList());
                    obj = new io.realm.FilterRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.FilterRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Filter.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.FilterRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Filter.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("text")) {
            if (json.isNull("text")) {
                ((FilterRealmProxyInterface) obj).realmSet$text(null);
            } else {
                ((FilterRealmProxyInterface) obj).realmSet$text((String) json.getString("text"));
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                ((FilterRealmProxyInterface) obj).realmSet$type(null);
            } else {
                ((FilterRealmProxyInterface) obj).realmSet$type((String) json.getString("type"));
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                ((FilterRealmProxyInterface) obj).realmSet$date(null);
            } else {
                Object timestamp = json.get("date");
                if (timestamp instanceof String) {
                    ((FilterRealmProxyInterface) obj).realmSet$date(JsonUtils.stringToDate((String) timestamp));
                } else {
                    ((FilterRealmProxyInterface) obj).realmSet$date(new Date(json.getLong("date")));
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Filter createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mobile.polux.models.Filter obj = new com.mobile.polux.models.Filter();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FilterRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((FilterRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("text")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FilterRealmProxyInterface) obj).realmSet$text(null);
                } else {
                    ((FilterRealmProxyInterface) obj).realmSet$text((String) reader.nextString());
                }
            } else if (name.equals("type")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FilterRealmProxyInterface) obj).realmSet$type(null);
                } else {
                    ((FilterRealmProxyInterface) obj).realmSet$type((String) reader.nextString());
                }
            } else if (name.equals("date")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((FilterRealmProxyInterface) obj).realmSet$date(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        ((FilterRealmProxyInterface) obj).realmSet$date(new Date(timestamp));
                    }
                } else {
                    ((FilterRealmProxyInterface) obj).realmSet$date(JsonUtils.stringToDate(reader.nextString()));
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

    public static com.mobile.polux.models.Filter copyOrUpdate(Realm realm, com.mobile.polux.models.Filter object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Filter) cachedRealmObject;
        } else {
            com.mobile.polux.models.Filter realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.mobile.polux.models.Filter.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((FilterRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Filter.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.FilterRealmProxy();
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

    public static com.mobile.polux.models.Filter copy(Realm realm, com.mobile.polux.models.Filter newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Filter) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Filter realmObject = realm.createObjectInternal(com.mobile.polux.models.Filter.class, ((FilterRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((FilterRealmProxyInterface) realmObject).realmSet$text(((FilterRealmProxyInterface) newObject).realmGet$text());
            ((FilterRealmProxyInterface) realmObject).realmSet$type(((FilterRealmProxyInterface) newObject).realmGet$type());
            ((FilterRealmProxyInterface) realmObject).realmSet$date(((FilterRealmProxyInterface) newObject).realmGet$date());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Filter object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Filter.class);
        long tableNativePtr = table.getNativePtr();
        FilterColumnInfo columnInfo = (FilterColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Filter.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((FilterRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$text = ((FilterRealmProxyInterface)object).realmGet$text();
        if (realmGet$text != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
        }
        String realmGet$type = ((FilterRealmProxyInterface)object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        }
        java.util.Date realmGet$date = ((FilterRealmProxyInterface)object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Filter.class);
        long tableNativePtr = table.getNativePtr();
        FilterColumnInfo columnInfo = (FilterColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Filter.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Filter object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Filter) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((FilterRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, primaryKeyValue);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$text = ((FilterRealmProxyInterface)object).realmGet$text();
                if (realmGet$text != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
                }
                String realmGet$type = ((FilterRealmProxyInterface)object).realmGet$type();
                if (realmGet$type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
                }
                java.util.Date realmGet$date = ((FilterRealmProxyInterface)object).realmGet$date();
                if (realmGet$date != null) {
                    Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Filter object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Filter.class);
        long tableNativePtr = table.getNativePtr();
        FilterColumnInfo columnInfo = (FilterColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Filter.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((FilterRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$text = ((FilterRealmProxyInterface)object).realmGet$text();
        if (realmGet$text != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.textIndex, rowIndex, false);
        }
        String realmGet$type = ((FilterRealmProxyInterface)object).realmGet$type();
        if (realmGet$type != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
        }
        java.util.Date realmGet$date = ((FilterRealmProxyInterface)object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Filter.class);
        long tableNativePtr = table.getNativePtr();
        FilterColumnInfo columnInfo = (FilterColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Filter.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Filter object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Filter) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((FilterRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$text = ((FilterRealmProxyInterface)object).realmGet$text();
                if (realmGet$text != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.textIndex, rowIndex, realmGet$text, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.textIndex, rowIndex, false);
                }
                String realmGet$type = ((FilterRealmProxyInterface)object).realmGet$type();
                if (realmGet$type != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.typeIndex, rowIndex, realmGet$type, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.typeIndex, rowIndex, false);
                }
                java.util.Date realmGet$date = ((FilterRealmProxyInterface)object).realmGet$date();
                if (realmGet$date != null) {
                    Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date.getTime(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.mobile.polux.models.Filter createDetachedCopy(com.mobile.polux.models.Filter realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Filter unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Filter)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Filter)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Filter();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((FilterRealmProxyInterface) unmanagedObject).realmSet$id(((FilterRealmProxyInterface) realmObject).realmGet$id());
        ((FilterRealmProxyInterface) unmanagedObject).realmSet$text(((FilterRealmProxyInterface) realmObject).realmGet$text());
        ((FilterRealmProxyInterface) unmanagedObject).realmSet$type(((FilterRealmProxyInterface) realmObject).realmGet$type());
        ((FilterRealmProxyInterface) unmanagedObject).realmSet$date(((FilterRealmProxyInterface) realmObject).realmGet$date());
        return unmanagedObject;
    }

    static com.mobile.polux.models.Filter update(Realm realm, com.mobile.polux.models.Filter realmObject, com.mobile.polux.models.Filter newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((FilterRealmProxyInterface) realmObject).realmSet$text(((FilterRealmProxyInterface) newObject).realmGet$text());
        ((FilterRealmProxyInterface) realmObject).realmSet$type(((FilterRealmProxyInterface) newObject).realmGet$type());
        ((FilterRealmProxyInterface) realmObject).realmSet$date(((FilterRealmProxyInterface) newObject).realmGet$date());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Filter = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{text:");
        stringBuilder.append(realmGet$text() != null ? realmGet$text() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type() != null ? realmGet$type() : "null");
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
        FilterRealmProxy aFilter = (FilterRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aFilter.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aFilter.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aFilter.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
