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

public class ContactRealmProxy extends com.mobile.polux.models.Contact
    implements RealmObjectProxy, ContactRealmProxyInterface {

    static final class ContactColumnInfo extends ColumnInfo {
        long telefono1Index;

        ContactColumnInfo(SharedRealm realm, Table table) {
            super(1);
            this.telefono1Index = addColumnDetails(table, "telefono1", RealmFieldType.STRING);
        }

        ContactColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ContactColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ContactColumnInfo src = (ContactColumnInfo) rawSrc;
            final ContactColumnInfo dst = (ContactColumnInfo) rawDst;
            dst.telefono1Index = src.telefono1Index;
        }
    }

    private ContactColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Contact> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("telefono1");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ContactRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ContactColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Contact>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$telefono1() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.telefono1Index);
    }

    @Override
    public void realmSet$telefono1(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.telefono1Index, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.telefono1Index, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.telefono1Index);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.telefono1Index, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Contact")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Contact");
            realmObjectSchema.add("telefono1", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Contact");
    }

    public static ContactColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Contact")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Contact' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Contact");
        final long columnCount = table.getColumnCount();
        if (columnCount != 1) {
            if (columnCount < 1) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 1 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 1 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 1 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ContactColumnInfo columnInfo = new ContactColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("telefono1")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'telefono1' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("telefono1") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'telefono1' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.telefono1Index)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'telefono1' is required. Either set @Required to field 'telefono1' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Contact";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Contact createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mobile.polux.models.Contact obj = realm.createObjectInternal(com.mobile.polux.models.Contact.class, true, excludeFields);
        if (json.has("telefono1")) {
            if (json.isNull("telefono1")) {
                ((ContactRealmProxyInterface) obj).realmSet$telefono1(null);
            } else {
                ((ContactRealmProxyInterface) obj).realmSet$telefono1((String) json.getString("telefono1"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Contact createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.mobile.polux.models.Contact obj = new com.mobile.polux.models.Contact();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("telefono1")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ContactRealmProxyInterface) obj).realmSet$telefono1(null);
                } else {
                    ((ContactRealmProxyInterface) obj).realmSet$telefono1((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.Contact copyOrUpdate(Realm realm, com.mobile.polux.models.Contact object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Contact) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.mobile.polux.models.Contact copy(Realm realm, com.mobile.polux.models.Contact newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Contact) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Contact realmObject = realm.createObjectInternal(com.mobile.polux.models.Contact.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ContactRealmProxyInterface) realmObject).realmSet$telefono1(((ContactRealmProxyInterface) newObject).realmGet$telefono1());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Contact object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Contact.class);
        long tableNativePtr = table.getNativePtr();
        ContactColumnInfo columnInfo = (ContactColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Contact.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        String realmGet$telefono1 = ((ContactRealmProxyInterface)object).realmGet$telefono1();
        if (realmGet$telefono1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.telefono1Index, rowIndex, realmGet$telefono1, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Contact.class);
        long tableNativePtr = table.getNativePtr();
        ContactColumnInfo columnInfo = (ContactColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Contact.class);
        com.mobile.polux.models.Contact object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Contact) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                String realmGet$telefono1 = ((ContactRealmProxyInterface)object).realmGet$telefono1();
                if (realmGet$telefono1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.telefono1Index, rowIndex, realmGet$telefono1, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Contact object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Contact.class);
        long tableNativePtr = table.getNativePtr();
        ContactColumnInfo columnInfo = (ContactColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Contact.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        String realmGet$telefono1 = ((ContactRealmProxyInterface)object).realmGet$telefono1();
        if (realmGet$telefono1 != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.telefono1Index, rowIndex, realmGet$telefono1, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.telefono1Index, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Contact.class);
        long tableNativePtr = table.getNativePtr();
        ContactColumnInfo columnInfo = (ContactColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Contact.class);
        com.mobile.polux.models.Contact object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Contact) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                String realmGet$telefono1 = ((ContactRealmProxyInterface)object).realmGet$telefono1();
                if (realmGet$telefono1 != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.telefono1Index, rowIndex, realmGet$telefono1, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.telefono1Index, rowIndex, false);
                }
            }
        }
    }

    public static com.mobile.polux.models.Contact createDetachedCopy(com.mobile.polux.models.Contact realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Contact unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Contact)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Contact)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Contact();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ContactRealmProxyInterface) unmanagedObject).realmSet$telefono1(((ContactRealmProxyInterface) realmObject).realmGet$telefono1());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Contact = proxy[");
        stringBuilder.append("{telefono1:");
        stringBuilder.append(realmGet$telefono1() != null ? realmGet$telefono1() : "null");
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
        ContactRealmProxy aContact = (ContactRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aContact.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aContact.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aContact.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
