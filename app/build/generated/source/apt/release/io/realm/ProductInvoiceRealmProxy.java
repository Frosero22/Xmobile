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

public class ProductInvoiceRealmProxy extends com.mobile.polux.models.ProductInvoice
    implements RealmObjectProxy, ProductInvoiceRealmProxyInterface {

    static final class ProductInvoiceColumnInfo extends ColumnInfo {
        long idIndex;
        long codigoEmpresaIndex;
        long codigoExistenciaIndex;
        long nameIndex;
        long cantIndex;
        long priceIndex;
        long totalIndex;

        ProductInvoiceColumnInfo(SharedRealm realm, Table table) {
            super(7);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.codigoEmpresaIndex = addColumnDetails(table, "codigoEmpresa", RealmFieldType.INTEGER);
            this.codigoExistenciaIndex = addColumnDetails(table, "codigoExistencia", RealmFieldType.INTEGER);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.cantIndex = addColumnDetails(table, "cant", RealmFieldType.INTEGER);
            this.priceIndex = addColumnDetails(table, "price", RealmFieldType.DOUBLE);
            this.totalIndex = addColumnDetails(table, "total", RealmFieldType.DOUBLE);
        }

        ProductInvoiceColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ProductInvoiceColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ProductInvoiceColumnInfo src = (ProductInvoiceColumnInfo) rawSrc;
            final ProductInvoiceColumnInfo dst = (ProductInvoiceColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.codigoEmpresaIndex = src.codigoEmpresaIndex;
            dst.codigoExistenciaIndex = src.codigoExistenciaIndex;
            dst.nameIndex = src.nameIndex;
            dst.cantIndex = src.cantIndex;
            dst.priceIndex = src.priceIndex;
            dst.totalIndex = src.totalIndex;
        }
    }

    private ProductInvoiceColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.ProductInvoice> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("codigoEmpresa");
        fieldNames.add("codigoExistencia");
        fieldNames.add("name");
        fieldNames.add("cant");
        fieldNames.add("price");
        fieldNames.add("total");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ProductInvoiceRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProductInvoiceColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.ProductInvoice>(this);
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
    public Integer realmGet$codigoEmpresa() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoEmpresaIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoEmpresaIndex);
    }

    @Override
    public void realmSet$codigoEmpresa(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoEmpresaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoEmpresaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoEmpresaIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoEmpresaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoExistencia() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoExistenciaIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoExistenciaIndex);
    }

    @Override
    public void realmSet$codigoExistencia(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoExistenciaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoExistenciaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoExistenciaIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoExistenciaIndex, value);
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
    public Integer realmGet$cant() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.cantIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.cantIndex);
    }

    @Override
    public void realmSet$cant(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cantIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.cantIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cantIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.cantIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$price() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.priceIndex);
    }

    @Override
    public void realmSet$price(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.priceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.priceIndex, value);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("ProductInvoice")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ProductInvoice");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("codigoEmpresa", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoExistencia", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("cant", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("price", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("total", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("ProductInvoice");
    }

    public static ProductInvoiceColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_ProductInvoice")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ProductInvoice' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_ProductInvoice");
        final long columnCount = table.getColumnCount();
        if (columnCount != 7) {
            if (columnCount < 7) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 7 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 7 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 7 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ProductInvoiceColumnInfo columnInfo = new ProductInvoiceColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("codigoEmpresa")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoEmpresa' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoEmpresa") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoEmpresa' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoEmpresaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoEmpresa' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoEmpresa' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoExistencia")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoExistencia' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoExistencia") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoExistencia' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoExistenciaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoExistencia' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoExistencia' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("cant")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cant' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("cant") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'cant' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.cantIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'cant' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'cant' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("price")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'price' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("price") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'price' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.priceIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'price' does support null values in the existing Realm file. Use corresponding boxed type for field 'price' or migrate using RealmObjectSchema.setNullable().");
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

        return columnInfo;
    }

    public static String getTableName() {
        return "class_ProductInvoice";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.ProductInvoice createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mobile.polux.models.ProductInvoice obj = realm.createObjectInternal(com.mobile.polux.models.ProductInvoice.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("codigoEmpresa")) {
            if (json.isNull("codigoEmpresa")) {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$codigoEmpresa(null);
            } else {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$codigoEmpresa((int) json.getInt("codigoEmpresa"));
            }
        }
        if (json.has("codigoExistencia")) {
            if (json.isNull("codigoExistencia")) {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$codigoExistencia(null);
            } else {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$codigoExistencia((int) json.getInt("codigoExistencia"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("cant")) {
            if (json.isNull("cant")) {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$cant(null);
            } else {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$cant((int) json.getInt("cant"));
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
            } else {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$price((double) json.getDouble("price"));
            }
        }
        if (json.has("total")) {
            if (json.isNull("total")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'total' to null.");
            } else {
                ((ProductInvoiceRealmProxyInterface) obj).realmSet$total((double) json.getDouble("total"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.ProductInvoice createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.mobile.polux.models.ProductInvoice obj = new com.mobile.polux.models.ProductInvoice();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("codigoEmpresa")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$codigoEmpresa(null);
                } else {
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$codigoEmpresa((int) reader.nextInt());
                }
            } else if (name.equals("codigoExistencia")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$codigoExistencia(null);
                } else {
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$codigoExistencia((int) reader.nextInt());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("cant")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$cant(null);
                } else {
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$cant((int) reader.nextInt());
                }
            } else if (name.equals("price")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
                } else {
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$price((double) reader.nextDouble());
                }
            } else if (name.equals("total")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'total' to null.");
                } else {
                    ((ProductInvoiceRealmProxyInterface) obj).realmSet$total((double) reader.nextDouble());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.ProductInvoice copyOrUpdate(Realm realm, com.mobile.polux.models.ProductInvoice object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.ProductInvoice) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.mobile.polux.models.ProductInvoice copy(Realm realm, com.mobile.polux.models.ProductInvoice newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.ProductInvoice) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.ProductInvoice realmObject = realm.createObjectInternal(com.mobile.polux.models.ProductInvoice.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ProductInvoiceRealmProxyInterface) realmObject).realmSet$id(((ProductInvoiceRealmProxyInterface) newObject).realmGet$id());
            ((ProductInvoiceRealmProxyInterface) realmObject).realmSet$codigoEmpresa(((ProductInvoiceRealmProxyInterface) newObject).realmGet$codigoEmpresa());
            ((ProductInvoiceRealmProxyInterface) realmObject).realmSet$codigoExistencia(((ProductInvoiceRealmProxyInterface) newObject).realmGet$codigoExistencia());
            ((ProductInvoiceRealmProxyInterface) realmObject).realmSet$name(((ProductInvoiceRealmProxyInterface) newObject).realmGet$name());
            ((ProductInvoiceRealmProxyInterface) realmObject).realmSet$cant(((ProductInvoiceRealmProxyInterface) newObject).realmGet$cant());
            ((ProductInvoiceRealmProxyInterface) realmObject).realmSet$price(((ProductInvoiceRealmProxyInterface) newObject).realmGet$price());
            ((ProductInvoiceRealmProxyInterface) realmObject).realmSet$total(((ProductInvoiceRealmProxyInterface) newObject).realmGet$total());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.ProductInvoice object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.ProductInvoice.class);
        long tableNativePtr = table.getNativePtr();
        ProductInvoiceColumnInfo columnInfo = (ProductInvoiceColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductInvoice.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$id(), false);
        Number realmGet$codigoEmpresa = ((ProductInvoiceRealmProxyInterface)object).realmGet$codigoEmpresa();
        if (realmGet$codigoEmpresa != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
        }
        Number realmGet$codigoExistencia = ((ProductInvoiceRealmProxyInterface)object).realmGet$codigoExistencia();
        if (realmGet$codigoExistencia != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, realmGet$codigoExistencia.longValue(), false);
        }
        String realmGet$name = ((ProductInvoiceRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Number realmGet$cant = ((ProductInvoiceRealmProxyInterface)object).realmGet$cant();
        if (realmGet$cant != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, realmGet$cant.longValue(), false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$price(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$total(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.ProductInvoice.class);
        long tableNativePtr = table.getNativePtr();
        ProductInvoiceColumnInfo columnInfo = (ProductInvoiceColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductInvoice.class);
        com.mobile.polux.models.ProductInvoice object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.ProductInvoice) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$id(), false);
                Number realmGet$codigoEmpresa = ((ProductInvoiceRealmProxyInterface)object).realmGet$codigoEmpresa();
                if (realmGet$codigoEmpresa != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
                }
                Number realmGet$codigoExistencia = ((ProductInvoiceRealmProxyInterface)object).realmGet$codigoExistencia();
                if (realmGet$codigoExistencia != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, realmGet$codigoExistencia.longValue(), false);
                }
                String realmGet$name = ((ProductInvoiceRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                Number realmGet$cant = ((ProductInvoiceRealmProxyInterface)object).realmGet$cant();
                if (realmGet$cant != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, realmGet$cant.longValue(), false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$price(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$total(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.ProductInvoice object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.ProductInvoice.class);
        long tableNativePtr = table.getNativePtr();
        ProductInvoiceColumnInfo columnInfo = (ProductInvoiceColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductInvoice.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$id(), false);
        Number realmGet$codigoEmpresa = ((ProductInvoiceRealmProxyInterface)object).realmGet$codigoEmpresa();
        if (realmGet$codigoEmpresa != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, false);
        }
        Number realmGet$codigoExistencia = ((ProductInvoiceRealmProxyInterface)object).realmGet$codigoExistencia();
        if (realmGet$codigoExistencia != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, realmGet$codigoExistencia.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, false);
        }
        String realmGet$name = ((ProductInvoiceRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Number realmGet$cant = ((ProductInvoiceRealmProxyInterface)object).realmGet$cant();
        if (realmGet$cant != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, realmGet$cant.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cantIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$price(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$total(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.ProductInvoice.class);
        long tableNativePtr = table.getNativePtr();
        ProductInvoiceColumnInfo columnInfo = (ProductInvoiceColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductInvoice.class);
        com.mobile.polux.models.ProductInvoice object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.ProductInvoice) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$id(), false);
                Number realmGet$codigoEmpresa = ((ProductInvoiceRealmProxyInterface)object).realmGet$codigoEmpresa();
                if (realmGet$codigoEmpresa != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, false);
                }
                Number realmGet$codigoExistencia = ((ProductInvoiceRealmProxyInterface)object).realmGet$codigoExistencia();
                if (realmGet$codigoExistencia != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, realmGet$codigoExistencia.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, false);
                }
                String realmGet$name = ((ProductInvoiceRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                Number realmGet$cant = ((ProductInvoiceRealmProxyInterface)object).realmGet$cant();
                if (realmGet$cant != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, realmGet$cant.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cantIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$price(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((ProductInvoiceRealmProxyInterface)object).realmGet$total(), false);
            }
        }
    }

    public static com.mobile.polux.models.ProductInvoice createDetachedCopy(com.mobile.polux.models.ProductInvoice realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.ProductInvoice unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.ProductInvoice)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.ProductInvoice)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.ProductInvoice();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ProductInvoiceRealmProxyInterface) unmanagedObject).realmSet$id(((ProductInvoiceRealmProxyInterface) realmObject).realmGet$id());
        ((ProductInvoiceRealmProxyInterface) unmanagedObject).realmSet$codigoEmpresa(((ProductInvoiceRealmProxyInterface) realmObject).realmGet$codigoEmpresa());
        ((ProductInvoiceRealmProxyInterface) unmanagedObject).realmSet$codigoExistencia(((ProductInvoiceRealmProxyInterface) realmObject).realmGet$codigoExistencia());
        ((ProductInvoiceRealmProxyInterface) unmanagedObject).realmSet$name(((ProductInvoiceRealmProxyInterface) realmObject).realmGet$name());
        ((ProductInvoiceRealmProxyInterface) unmanagedObject).realmSet$cant(((ProductInvoiceRealmProxyInterface) realmObject).realmGet$cant());
        ((ProductInvoiceRealmProxyInterface) unmanagedObject).realmSet$price(((ProductInvoiceRealmProxyInterface) realmObject).realmGet$price());
        ((ProductInvoiceRealmProxyInterface) unmanagedObject).realmSet$total(((ProductInvoiceRealmProxyInterface) realmObject).realmGet$total());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ProductInvoice = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoEmpresa:");
        stringBuilder.append(realmGet$codigoEmpresa() != null ? realmGet$codigoEmpresa() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoExistencia:");
        stringBuilder.append(realmGet$codigoExistencia() != null ? realmGet$codigoExistencia() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cant:");
        stringBuilder.append(realmGet$cant() != null ? realmGet$cant() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{price:");
        stringBuilder.append(realmGet$price());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total:");
        stringBuilder.append(realmGet$total());
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
        ProductInvoiceRealmProxy aProductInvoice = (ProductInvoiceRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProductInvoice.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProductInvoice.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProductInvoice.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
