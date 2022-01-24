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

public class GuideRealmProxy extends com.mobile.polux.models.Guide
    implements RealmObjectProxy, GuideRealmProxyInterface {

    static final class GuideColumnInfo extends ColumnInfo {
        long idIndex;
        long dateIndex;
        long salesmanIndex;
        long detailsIndex;

        GuideColumnInfo(SharedRealm realm, Table table) {
            super(4);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.dateIndex = addColumnDetails(table, "date", RealmFieldType.STRING);
            this.salesmanIndex = addColumnDetails(table, "salesman", RealmFieldType.STRING);
            this.detailsIndex = addColumnDetails(table, "details", RealmFieldType.LIST);
        }

        GuideColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GuideColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GuideColumnInfo src = (GuideColumnInfo) rawSrc;
            final GuideColumnInfo dst = (GuideColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.dateIndex = src.dateIndex;
            dst.salesmanIndex = src.salesmanIndex;
            dst.detailsIndex = src.detailsIndex;
        }
    }

    private GuideColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Guide> proxyState;
    private RealmList<com.mobile.polux.models.CashingGuideDetail> detailsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("date");
        fieldNames.add("salesman");
        fieldNames.add("details");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    GuideRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GuideColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Guide>(this);
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
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
    public String realmGet$salesman() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.salesmanIndex);
    }

    @Override
    public void realmSet$salesman(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.salesmanIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.salesmanIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.salesmanIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.salesmanIndex, value);
    }

    @Override
    public RealmList<com.mobile.polux.models.CashingGuideDetail> realmGet$details() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (detailsRealmList != null) {
            return detailsRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.detailsIndex);
            detailsRealmList = new RealmList<com.mobile.polux.models.CashingGuideDetail>(com.mobile.polux.models.CashingGuideDetail.class, linkView, proxyState.getRealm$realm());
            return detailsRealmList;
        }
    }

    @Override
    public void realmSet$details(RealmList<com.mobile.polux.models.CashingGuideDetail> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("details")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.mobile.polux.models.CashingGuideDetail> original = value;
                value = new RealmList<com.mobile.polux.models.CashingGuideDetail>();
                for (com.mobile.polux.models.CashingGuideDetail item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.detailsIndex);
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
        if (!realmSchema.contains("Guide")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Guide");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("date", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("salesman", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("CashingGuideDetail")) {
                CashingGuideDetailRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("details", RealmFieldType.LIST, realmSchema.get("CashingGuideDetail"));
            return realmObjectSchema;
        }
        return realmSchema.get("Guide");
    }

    public static GuideColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Guide")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Guide' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Guide");
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

        final GuideColumnInfo columnInfo = new GuideColumnInfo(sharedRealm, table);

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
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'id' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.idIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
        if (!columnTypes.containsKey("salesman")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'salesman' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("salesman") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'salesman' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.salesmanIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'salesman' is required. Either set @Required to field 'salesman' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("details")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'details'");
        }
        if (columnTypes.get("details") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'CashingGuideDetail' for field 'details'");
        }
        if (!sharedRealm.hasTable("class_CashingGuideDetail")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_CashingGuideDetail' for field 'details'");
        }
        Table table_3 = sharedRealm.getTable("class_CashingGuideDetail");
        if (!table.getLinkTarget(columnInfo.detailsIndex).hasSameSchema(table_3)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'details': '" + table.getLinkTarget(columnInfo.detailsIndex).getName() + "' expected - was '" + table_3.getName() + "'");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Guide";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Guide createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.mobile.polux.models.Guide obj = null;
        if (update) {
            Table table = realm.getTable(com.mobile.polux.models.Guide.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("id"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Guide.class), false, Collections.<String> emptyList());
                    obj = new io.realm.GuideRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("details")) {
                excludeFields.add("details");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.GuideRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Guide.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.GuideRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Guide.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                ((GuideRealmProxyInterface) obj).realmSet$date(null);
            } else {
                ((GuideRealmProxyInterface) obj).realmSet$date((String) json.getString("date"));
            }
        }
        if (json.has("salesman")) {
            if (json.isNull("salesman")) {
                ((GuideRealmProxyInterface) obj).realmSet$salesman(null);
            } else {
                ((GuideRealmProxyInterface) obj).realmSet$salesman((String) json.getString("salesman"));
            }
        }
        if (json.has("details")) {
            if (json.isNull("details")) {
                ((GuideRealmProxyInterface) obj).realmSet$details(null);
            } else {
                ((GuideRealmProxyInterface) obj).realmGet$details().clear();
                JSONArray array = json.getJSONArray("details");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.CashingGuideDetail item = CashingGuideDetailRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((GuideRealmProxyInterface) obj).realmGet$details().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Guide createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mobile.polux.models.Guide obj = new com.mobile.polux.models.Guide();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GuideRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((GuideRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("date")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GuideRealmProxyInterface) obj).realmSet$date(null);
                } else {
                    ((GuideRealmProxyInterface) obj).realmSet$date((String) reader.nextString());
                }
            } else if (name.equals("salesman")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GuideRealmProxyInterface) obj).realmSet$salesman(null);
                } else {
                    ((GuideRealmProxyInterface) obj).realmSet$salesman((String) reader.nextString());
                }
            } else if (name.equals("details")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((GuideRealmProxyInterface) obj).realmSet$details(null);
                } else {
                    ((GuideRealmProxyInterface) obj).realmSet$details(new RealmList<com.mobile.polux.models.CashingGuideDetail>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.CashingGuideDetail item = CashingGuideDetailRealmProxy.createUsingJsonStream(realm, reader);
                        ((GuideRealmProxyInterface) obj).realmGet$details().add(item);
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

    public static com.mobile.polux.models.Guide copyOrUpdate(Realm realm, com.mobile.polux.models.Guide object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Guide) cachedRealmObject;
        } else {
            com.mobile.polux.models.Guide realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.mobile.polux.models.Guide.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((GuideRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Guide.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.GuideRealmProxy();
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

    public static com.mobile.polux.models.Guide copy(Realm realm, com.mobile.polux.models.Guide newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Guide) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Guide realmObject = realm.createObjectInternal(com.mobile.polux.models.Guide.class, ((GuideRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((GuideRealmProxyInterface) realmObject).realmSet$date(((GuideRealmProxyInterface) newObject).realmGet$date());
            ((GuideRealmProxyInterface) realmObject).realmSet$salesman(((GuideRealmProxyInterface) newObject).realmGet$salesman());

            RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((GuideRealmProxyInterface) newObject).realmGet$details();
            if (detailsList != null) {
                RealmList<com.mobile.polux.models.CashingGuideDetail> detailsRealmList = ((GuideRealmProxyInterface) realmObject).realmGet$details();
                for (int i = 0; i < detailsList.size(); i++) {
                    com.mobile.polux.models.CashingGuideDetail detailsItem = detailsList.get(i);
                    com.mobile.polux.models.CashingGuideDetail cachedetails = (com.mobile.polux.models.CashingGuideDetail) cache.get(detailsItem);
                    if (cachedetails != null) {
                        detailsRealmList.add(cachedetails);
                    } else {
                        detailsRealmList.add(CashingGuideDetailRealmProxy.copyOrUpdate(realm, detailsList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Guide object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Guide.class);
        long tableNativePtr = table.getNativePtr();
        GuideColumnInfo columnInfo = (GuideColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Guide.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((GuideRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GuideRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((GuideRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$date = ((GuideRealmProxyInterface)object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        }
        String realmGet$salesman = ((GuideRealmProxyInterface)object).realmGet$salesman();
        if (realmGet$salesman != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.salesmanIndex, rowIndex, realmGet$salesman, false);
        }

        RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((GuideRealmProxyInterface) object).realmGet$details();
        if (detailsList != null) {
            long detailsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.detailsIndex, rowIndex);
            for (com.mobile.polux.models.CashingGuideDetail detailsItem : detailsList) {
                Long cacheItemIndexdetails = cache.get(detailsItem);
                if (cacheItemIndexdetails == null) {
                    cacheItemIndexdetails = CashingGuideDetailRealmProxy.insert(realm, detailsItem, cache);
                }
                LinkView.nativeAdd(detailsNativeLinkViewPtr, cacheItemIndexdetails);
            }
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Guide.class);
        long tableNativePtr = table.getNativePtr();
        GuideColumnInfo columnInfo = (GuideColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Guide.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Guide object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Guide) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((GuideRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GuideRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((GuideRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$date = ((GuideRealmProxyInterface)object).realmGet$date();
                if (realmGet$date != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
                }
                String realmGet$salesman = ((GuideRealmProxyInterface)object).realmGet$salesman();
                if (realmGet$salesman != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.salesmanIndex, rowIndex, realmGet$salesman, false);
                }

                RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((GuideRealmProxyInterface) object).realmGet$details();
                if (detailsList != null) {
                    long detailsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.detailsIndex, rowIndex);
                    for (com.mobile.polux.models.CashingGuideDetail detailsItem : detailsList) {
                        Long cacheItemIndexdetails = cache.get(detailsItem);
                        if (cacheItemIndexdetails == null) {
                            cacheItemIndexdetails = CashingGuideDetailRealmProxy.insert(realm, detailsItem, cache);
                        }
                        LinkView.nativeAdd(detailsNativeLinkViewPtr, cacheItemIndexdetails);
                    }
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Guide object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Guide.class);
        long tableNativePtr = table.getNativePtr();
        GuideColumnInfo columnInfo = (GuideColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Guide.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((GuideRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GuideRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((GuideRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        String realmGet$date = ((GuideRealmProxyInterface)object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
        }
        String realmGet$salesman = ((GuideRealmProxyInterface)object).realmGet$salesman();
        if (realmGet$salesman != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.salesmanIndex, rowIndex, realmGet$salesman, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.salesmanIndex, rowIndex, false);
        }

        long detailsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.detailsIndex, rowIndex);
        LinkView.nativeClear(detailsNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((GuideRealmProxyInterface) object).realmGet$details();
        if (detailsList != null) {
            for (com.mobile.polux.models.CashingGuideDetail detailsItem : detailsList) {
                Long cacheItemIndexdetails = cache.get(detailsItem);
                if (cacheItemIndexdetails == null) {
                    cacheItemIndexdetails = CashingGuideDetailRealmProxy.insertOrUpdate(realm, detailsItem, cache);
                }
                LinkView.nativeAdd(detailsNativeLinkViewPtr, cacheItemIndexdetails);
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Guide.class);
        long tableNativePtr = table.getNativePtr();
        GuideColumnInfo columnInfo = (GuideColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Guide.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Guide object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Guide) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((GuideRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GuideRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((GuideRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                String realmGet$date = ((GuideRealmProxyInterface)object).realmGet$date();
                if (realmGet$date != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.dateIndex, rowIndex, realmGet$date, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.dateIndex, rowIndex, false);
                }
                String realmGet$salesman = ((GuideRealmProxyInterface)object).realmGet$salesman();
                if (realmGet$salesman != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.salesmanIndex, rowIndex, realmGet$salesman, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.salesmanIndex, rowIndex, false);
                }

                long detailsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.detailsIndex, rowIndex);
                LinkView.nativeClear(detailsNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((GuideRealmProxyInterface) object).realmGet$details();
                if (detailsList != null) {
                    for (com.mobile.polux.models.CashingGuideDetail detailsItem : detailsList) {
                        Long cacheItemIndexdetails = cache.get(detailsItem);
                        if (cacheItemIndexdetails == null) {
                            cacheItemIndexdetails = CashingGuideDetailRealmProxy.insertOrUpdate(realm, detailsItem, cache);
                        }
                        LinkView.nativeAdd(detailsNativeLinkViewPtr, cacheItemIndexdetails);
                    }
                }

            }
        }
    }

    public static com.mobile.polux.models.Guide createDetachedCopy(com.mobile.polux.models.Guide realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Guide unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Guide)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Guide)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Guide();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((GuideRealmProxyInterface) unmanagedObject).realmSet$id(((GuideRealmProxyInterface) realmObject).realmGet$id());
        ((GuideRealmProxyInterface) unmanagedObject).realmSet$date(((GuideRealmProxyInterface) realmObject).realmGet$date());
        ((GuideRealmProxyInterface) unmanagedObject).realmSet$salesman(((GuideRealmProxyInterface) realmObject).realmGet$salesman());

        // Deep copy of details
        if (currentDepth == maxDepth) {
            ((GuideRealmProxyInterface) unmanagedObject).realmSet$details(null);
        } else {
            RealmList<com.mobile.polux.models.CashingGuideDetail> manageddetailsList = ((GuideRealmProxyInterface) realmObject).realmGet$details();
            RealmList<com.mobile.polux.models.CashingGuideDetail> unmanageddetailsList = new RealmList<com.mobile.polux.models.CashingGuideDetail>();
            ((GuideRealmProxyInterface) unmanagedObject).realmSet$details(unmanageddetailsList);
            int nextDepth = currentDepth + 1;
            int size = manageddetailsList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.CashingGuideDetail item = CashingGuideDetailRealmProxy.createDetachedCopy(manageddetailsList.get(i), nextDepth, maxDepth, cache);
                unmanageddetailsList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.mobile.polux.models.Guide update(Realm realm, com.mobile.polux.models.Guide realmObject, com.mobile.polux.models.Guide newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((GuideRealmProxyInterface) realmObject).realmSet$date(((GuideRealmProxyInterface) newObject).realmGet$date());
        ((GuideRealmProxyInterface) realmObject).realmSet$salesman(((GuideRealmProxyInterface) newObject).realmGet$salesman());
        RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((GuideRealmProxyInterface) newObject).realmGet$details();
        RealmList<com.mobile.polux.models.CashingGuideDetail> detailsRealmList = ((GuideRealmProxyInterface) realmObject).realmGet$details();
        detailsRealmList.clear();
        if (detailsList != null) {
            for (int i = 0; i < detailsList.size(); i++) {
                com.mobile.polux.models.CashingGuideDetail detailsItem = detailsList.get(i);
                com.mobile.polux.models.CashingGuideDetail cachedetails = (com.mobile.polux.models.CashingGuideDetail) cache.get(detailsItem);
                if (cachedetails != null) {
                    detailsRealmList.add(cachedetails);
                } else {
                    detailsRealmList.add(CashingGuideDetailRealmProxy.copyOrUpdate(realm, detailsList.get(i), true, cache));
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
        StringBuilder stringBuilder = new StringBuilder("Guide = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date() != null ? realmGet$date() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{salesman:");
        stringBuilder.append(realmGet$salesman() != null ? realmGet$salesman() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{details:");
        stringBuilder.append("RealmList<CashingGuideDetail>[").append(realmGet$details().size()).append("]");
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
        GuideRealmProxy aGuide = (GuideRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGuide.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGuide.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGuide.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
