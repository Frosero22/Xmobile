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

public class PaymentRealmProxy extends com.mobile.polux.models.Payment
    implements RealmObjectProxy, PaymentRealmProxyInterface {

    static final class PaymentColumnInfo extends ColumnInfo {
        long codigoIndex;
        long clientIdIndex;
        long tipoIndex;
        long numCuentaIndex;
        long valorIndex;
        long voucherIndex;
        long bancoIndex;
        long observacionesIndex;
        long fechaIndex;
        long nameIndex;
        long residuaryIndex;
        long guideIndex;

        PaymentColumnInfo(SharedRealm realm, Table table) {
            super(12);
            this.codigoIndex = addColumnDetails(table, "codigo", RealmFieldType.INTEGER);
            this.clientIdIndex = addColumnDetails(table, "clientId", RealmFieldType.INTEGER);
            this.tipoIndex = addColumnDetails(table, "tipo", RealmFieldType.STRING);
            this.numCuentaIndex = addColumnDetails(table, "numCuenta", RealmFieldType.STRING);
            this.valorIndex = addColumnDetails(table, "valor", RealmFieldType.DOUBLE);
            this.voucherIndex = addColumnDetails(table, "voucher", RealmFieldType.STRING);
            this.bancoIndex = addColumnDetails(table, "banco", RealmFieldType.INTEGER);
            this.observacionesIndex = addColumnDetails(table, "observaciones", RealmFieldType.STRING);
            this.fechaIndex = addColumnDetails(table, "fecha", RealmFieldType.STRING);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.residuaryIndex = addColumnDetails(table, "residuary", RealmFieldType.DOUBLE);
            this.guideIndex = addColumnDetails(table, "guide", RealmFieldType.INTEGER);
        }

        PaymentColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new PaymentColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final PaymentColumnInfo src = (PaymentColumnInfo) rawSrc;
            final PaymentColumnInfo dst = (PaymentColumnInfo) rawDst;
            dst.codigoIndex = src.codigoIndex;
            dst.clientIdIndex = src.clientIdIndex;
            dst.tipoIndex = src.tipoIndex;
            dst.numCuentaIndex = src.numCuentaIndex;
            dst.valorIndex = src.valorIndex;
            dst.voucherIndex = src.voucherIndex;
            dst.bancoIndex = src.bancoIndex;
            dst.observacionesIndex = src.observacionesIndex;
            dst.fechaIndex = src.fechaIndex;
            dst.nameIndex = src.nameIndex;
            dst.residuaryIndex = src.residuaryIndex;
            dst.guideIndex = src.guideIndex;
        }
    }

    private PaymentColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Payment> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("codigo");
        fieldNames.add("clientId");
        fieldNames.add("tipo");
        fieldNames.add("numCuenta");
        fieldNames.add("valor");
        fieldNames.add("voucher");
        fieldNames.add("banco");
        fieldNames.add("observaciones");
        fieldNames.add("fecha");
        fieldNames.add("name");
        fieldNames.add("residuary");
        fieldNames.add("guide");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    PaymentRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (PaymentColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Payment>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigo() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoIndex);
    }

    @Override
    public void realmSet$codigo(Integer value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'codigo' cannot be changed after object was created.");
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
    public double realmGet$valor() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.valorIndex);
    }

    @Override
    public void realmSet$valor(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.valorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.valorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$voucher() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.voucherIndex);
    }

    @Override
    public void realmSet$voucher(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.voucherIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.voucherIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.voucherIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.voucherIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$banco() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.bancoIndex);
    }

    @Override
    public void realmSet$banco(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.bancoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.bancoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$observaciones() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.observacionesIndex);
    }

    @Override
    public void realmSet$observaciones(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.observacionesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.observacionesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.observacionesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.observacionesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fechaIndex);
    }

    @Override
    public void realmSet$fecha(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fechaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fechaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fechaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fechaIndex, value);
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
    public double realmGet$residuary() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.residuaryIndex);
    }

    @Override
    public void realmSet$residuary(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.residuaryIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.residuaryIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$guide() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.guideIndex);
    }

    @Override
    public void realmSet$guide(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.guideIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.guideIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Payment")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Payment");
            realmObjectSchema.add("codigo", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("clientId", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("tipo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("numCuenta", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("valor", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("voucher", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("banco", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("observaciones", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("fecha", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("residuary", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("guide", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Payment");
    }

    public static PaymentColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Payment")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Payment' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Payment");
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

        final PaymentColumnInfo columnInfo = new PaymentColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'codigo' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.codigoIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field codigo");
            }
        }

        if (!columnTypes.containsKey("codigo")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigo") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigo' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'codigo' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("codigo"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'codigo' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
        if (!columnTypes.containsKey("valor")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'valor' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("valor") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'valor' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.valorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'valor' does support null values in the existing Realm file. Use corresponding boxed type for field 'valor' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("voucher")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'voucher' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("voucher") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'voucher' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.voucherIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'voucher' is required. Either set @Required to field 'voucher' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("banco")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'banco' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("banco") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'banco' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.bancoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'banco' does support null values in the existing Realm file. Use corresponding boxed type for field 'banco' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("observaciones")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'observaciones' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("observaciones") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'observaciones' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.observacionesIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'observaciones' is required. Either set @Required to field 'observaciones' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("fecha")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fecha' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fecha") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fecha' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.fechaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fecha' is required. Either set @Required to field 'fecha' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("residuary")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'residuary' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("residuary") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'residuary' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.residuaryIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'residuary' does support null values in the existing Realm file. Use corresponding boxed type for field 'residuary' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("guide")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'guide' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("guide") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'guide' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.guideIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'guide' does support null values in the existing Realm file. Use corresponding boxed type for field 'guide' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Payment";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Payment createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mobile.polux.models.Payment obj = null;
        if (update) {
            Table table = realm.getTable(com.mobile.polux.models.Payment.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("codigo")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("codigo"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Payment.class), false, Collections.<String> emptyList());
                    obj = new io.realm.PaymentRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("codigo")) {
                if (json.isNull("codigo")) {
                    obj = (io.realm.PaymentRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Payment.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.PaymentRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Payment.class, json.getInt("codigo"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'codigo'.");
            }
        }
        if (json.has("clientId")) {
            if (json.isNull("clientId")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clientId' to null.");
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$clientId((int) json.getInt("clientId"));
            }
        }
        if (json.has("tipo")) {
            if (json.isNull("tipo")) {
                ((PaymentRealmProxyInterface) obj).realmSet$tipo(null);
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$tipo((String) json.getString("tipo"));
            }
        }
        if (json.has("numCuenta")) {
            if (json.isNull("numCuenta")) {
                ((PaymentRealmProxyInterface) obj).realmSet$numCuenta(null);
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$numCuenta((String) json.getString("numCuenta"));
            }
        }
        if (json.has("valor")) {
            if (json.isNull("valor")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'valor' to null.");
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$valor((double) json.getDouble("valor"));
            }
        }
        if (json.has("voucher")) {
            if (json.isNull("voucher")) {
                ((PaymentRealmProxyInterface) obj).realmSet$voucher(null);
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$voucher((String) json.getString("voucher"));
            }
        }
        if (json.has("banco")) {
            if (json.isNull("banco")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'banco' to null.");
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$banco((int) json.getInt("banco"));
            }
        }
        if (json.has("observaciones")) {
            if (json.isNull("observaciones")) {
                ((PaymentRealmProxyInterface) obj).realmSet$observaciones(null);
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$observaciones((String) json.getString("observaciones"));
            }
        }
        if (json.has("fecha")) {
            if (json.isNull("fecha")) {
                ((PaymentRealmProxyInterface) obj).realmSet$fecha(null);
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$fecha((String) json.getString("fecha"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((PaymentRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("residuary")) {
            if (json.isNull("residuary")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'residuary' to null.");
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$residuary((double) json.getDouble("residuary"));
            }
        }
        if (json.has("guide")) {
            if (json.isNull("guide")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'guide' to null.");
            } else {
                ((PaymentRealmProxyInterface) obj).realmSet$guide((long) json.getLong("guide"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Payment createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mobile.polux.models.Payment obj = new com.mobile.polux.models.Payment();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("codigo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentRealmProxyInterface) obj).realmSet$codigo(null);
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$codigo((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("clientId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clientId' to null.");
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$clientId((int) reader.nextInt());
                }
            } else if (name.equals("tipo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentRealmProxyInterface) obj).realmSet$tipo(null);
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$tipo((String) reader.nextString());
                }
            } else if (name.equals("numCuenta")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentRealmProxyInterface) obj).realmSet$numCuenta(null);
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$numCuenta((String) reader.nextString());
                }
            } else if (name.equals("valor")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'valor' to null.");
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$valor((double) reader.nextDouble());
                }
            } else if (name.equals("voucher")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentRealmProxyInterface) obj).realmSet$voucher(null);
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$voucher((String) reader.nextString());
                }
            } else if (name.equals("banco")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'banco' to null.");
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$banco((int) reader.nextInt());
                }
            } else if (name.equals("observaciones")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentRealmProxyInterface) obj).realmSet$observaciones(null);
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$observaciones((String) reader.nextString());
                }
            } else if (name.equals("fecha")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentRealmProxyInterface) obj).realmSet$fecha(null);
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$fecha((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((PaymentRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("residuary")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'residuary' to null.");
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$residuary((double) reader.nextDouble());
                }
            } else if (name.equals("guide")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'guide' to null.");
                } else {
                    ((PaymentRealmProxyInterface) obj).realmSet$guide((long) reader.nextLong());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'codigo'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.Payment copyOrUpdate(Realm realm, com.mobile.polux.models.Payment object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Payment) cachedRealmObject;
        } else {
            com.mobile.polux.models.Payment realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.mobile.polux.models.Payment.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((PaymentRealmProxyInterface) object).realmGet$codigo();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Payment.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.PaymentRealmProxy();
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

    public static com.mobile.polux.models.Payment copy(Realm realm, com.mobile.polux.models.Payment newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Payment) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Payment realmObject = realm.createObjectInternal(com.mobile.polux.models.Payment.class, ((PaymentRealmProxyInterface) newObject).realmGet$codigo(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((PaymentRealmProxyInterface) realmObject).realmSet$clientId(((PaymentRealmProxyInterface) newObject).realmGet$clientId());
            ((PaymentRealmProxyInterface) realmObject).realmSet$tipo(((PaymentRealmProxyInterface) newObject).realmGet$tipo());
            ((PaymentRealmProxyInterface) realmObject).realmSet$numCuenta(((PaymentRealmProxyInterface) newObject).realmGet$numCuenta());
            ((PaymentRealmProxyInterface) realmObject).realmSet$valor(((PaymentRealmProxyInterface) newObject).realmGet$valor());
            ((PaymentRealmProxyInterface) realmObject).realmSet$voucher(((PaymentRealmProxyInterface) newObject).realmGet$voucher());
            ((PaymentRealmProxyInterface) realmObject).realmSet$banco(((PaymentRealmProxyInterface) newObject).realmGet$banco());
            ((PaymentRealmProxyInterface) realmObject).realmSet$observaciones(((PaymentRealmProxyInterface) newObject).realmGet$observaciones());
            ((PaymentRealmProxyInterface) realmObject).realmSet$fecha(((PaymentRealmProxyInterface) newObject).realmGet$fecha());
            ((PaymentRealmProxyInterface) realmObject).realmSet$name(((PaymentRealmProxyInterface) newObject).realmGet$name());
            ((PaymentRealmProxyInterface) realmObject).realmSet$residuary(((PaymentRealmProxyInterface) newObject).realmGet$residuary());
            ((PaymentRealmProxyInterface) realmObject).realmSet$guide(((PaymentRealmProxyInterface) newObject).realmGet$guide());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Payment object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Payment.class);
        long tableNativePtr = table.getNativePtr();
        PaymentColumnInfo columnInfo = (PaymentColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Payment.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((PaymentRealmProxyInterface) object).realmGet$codigo();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PaymentRealmProxyInterface) object).realmGet$codigo());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PaymentRealmProxyInterface) object).realmGet$codigo());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clientIdIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$clientId(), false);
        String realmGet$tipo = ((PaymentRealmProxyInterface)object).realmGet$tipo();
        if (realmGet$tipo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tipoIndex, rowIndex, realmGet$tipo, false);
        }
        String realmGet$numCuenta = ((PaymentRealmProxyInterface)object).realmGet$numCuenta();
        if (realmGet$numCuenta != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, realmGet$numCuenta, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.valorIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$valor(), false);
        String realmGet$voucher = ((PaymentRealmProxyInterface)object).realmGet$voucher();
        if (realmGet$voucher != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.voucherIndex, rowIndex, realmGet$voucher, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.bancoIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$banco(), false);
        String realmGet$observaciones = ((PaymentRealmProxyInterface)object).realmGet$observaciones();
        if (realmGet$observaciones != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.observacionesIndex, rowIndex, realmGet$observaciones, false);
        }
        String realmGet$fecha = ((PaymentRealmProxyInterface)object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
        }
        String realmGet$name = ((PaymentRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.residuaryIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$residuary(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.guideIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$guide(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Payment.class);
        long tableNativePtr = table.getNativePtr();
        PaymentColumnInfo columnInfo = (PaymentColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Payment.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Payment object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Payment) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((PaymentRealmProxyInterface) object).realmGet$codigo();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PaymentRealmProxyInterface) object).realmGet$codigo());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PaymentRealmProxyInterface) object).realmGet$codigo());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.clientIdIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$clientId(), false);
                String realmGet$tipo = ((PaymentRealmProxyInterface)object).realmGet$tipo();
                if (realmGet$tipo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.tipoIndex, rowIndex, realmGet$tipo, false);
                }
                String realmGet$numCuenta = ((PaymentRealmProxyInterface)object).realmGet$numCuenta();
                if (realmGet$numCuenta != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, realmGet$numCuenta, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.valorIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$valor(), false);
                String realmGet$voucher = ((PaymentRealmProxyInterface)object).realmGet$voucher();
                if (realmGet$voucher != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.voucherIndex, rowIndex, realmGet$voucher, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.bancoIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$banco(), false);
                String realmGet$observaciones = ((PaymentRealmProxyInterface)object).realmGet$observaciones();
                if (realmGet$observaciones != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.observacionesIndex, rowIndex, realmGet$observaciones, false);
                }
                String realmGet$fecha = ((PaymentRealmProxyInterface)object).realmGet$fecha();
                if (realmGet$fecha != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
                }
                String realmGet$name = ((PaymentRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.residuaryIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$residuary(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.guideIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$guide(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Payment object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Payment.class);
        long tableNativePtr = table.getNativePtr();
        PaymentColumnInfo columnInfo = (PaymentColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Payment.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((PaymentRealmProxyInterface) object).realmGet$codigo();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PaymentRealmProxyInterface) object).realmGet$codigo());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PaymentRealmProxyInterface) object).realmGet$codigo());
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clientIdIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$clientId(), false);
        String realmGet$tipo = ((PaymentRealmProxyInterface)object).realmGet$tipo();
        if (realmGet$tipo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tipoIndex, rowIndex, realmGet$tipo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tipoIndex, rowIndex, false);
        }
        String realmGet$numCuenta = ((PaymentRealmProxyInterface)object).realmGet$numCuenta();
        if (realmGet$numCuenta != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, realmGet$numCuenta, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.valorIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$valor(), false);
        String realmGet$voucher = ((PaymentRealmProxyInterface)object).realmGet$voucher();
        if (realmGet$voucher != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.voucherIndex, rowIndex, realmGet$voucher, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.voucherIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.bancoIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$banco(), false);
        String realmGet$observaciones = ((PaymentRealmProxyInterface)object).realmGet$observaciones();
        if (realmGet$observaciones != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.observacionesIndex, rowIndex, realmGet$observaciones, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.observacionesIndex, rowIndex, false);
        }
        String realmGet$fecha = ((PaymentRealmProxyInterface)object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
        }
        String realmGet$name = ((PaymentRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.residuaryIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$residuary(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.guideIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$guide(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Payment.class);
        long tableNativePtr = table.getNativePtr();
        PaymentColumnInfo columnInfo = (PaymentColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Payment.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Payment object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Payment) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((PaymentRealmProxyInterface) object).realmGet$codigo();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((PaymentRealmProxyInterface) object).realmGet$codigo());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((PaymentRealmProxyInterface) object).realmGet$codigo());
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.clientIdIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$clientId(), false);
                String realmGet$tipo = ((PaymentRealmProxyInterface)object).realmGet$tipo();
                if (realmGet$tipo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.tipoIndex, rowIndex, realmGet$tipo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.tipoIndex, rowIndex, false);
                }
                String realmGet$numCuenta = ((PaymentRealmProxyInterface)object).realmGet$numCuenta();
                if (realmGet$numCuenta != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, realmGet$numCuenta, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.numCuentaIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.valorIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$valor(), false);
                String realmGet$voucher = ((PaymentRealmProxyInterface)object).realmGet$voucher();
                if (realmGet$voucher != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.voucherIndex, rowIndex, realmGet$voucher, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.voucherIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.bancoIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$banco(), false);
                String realmGet$observaciones = ((PaymentRealmProxyInterface)object).realmGet$observaciones();
                if (realmGet$observaciones != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.observacionesIndex, rowIndex, realmGet$observaciones, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.observacionesIndex, rowIndex, false);
                }
                String realmGet$fecha = ((PaymentRealmProxyInterface)object).realmGet$fecha();
                if (realmGet$fecha != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
                }
                String realmGet$name = ((PaymentRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.residuaryIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$residuary(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.guideIndex, rowIndex, ((PaymentRealmProxyInterface)object).realmGet$guide(), false);
            }
        }
    }

    public static com.mobile.polux.models.Payment createDetachedCopy(com.mobile.polux.models.Payment realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Payment unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Payment)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Payment)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Payment();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$codigo(((PaymentRealmProxyInterface) realmObject).realmGet$codigo());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$clientId(((PaymentRealmProxyInterface) realmObject).realmGet$clientId());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$tipo(((PaymentRealmProxyInterface) realmObject).realmGet$tipo());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$numCuenta(((PaymentRealmProxyInterface) realmObject).realmGet$numCuenta());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$valor(((PaymentRealmProxyInterface) realmObject).realmGet$valor());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$voucher(((PaymentRealmProxyInterface) realmObject).realmGet$voucher());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$banco(((PaymentRealmProxyInterface) realmObject).realmGet$banco());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$observaciones(((PaymentRealmProxyInterface) realmObject).realmGet$observaciones());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$fecha(((PaymentRealmProxyInterface) realmObject).realmGet$fecha());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$name(((PaymentRealmProxyInterface) realmObject).realmGet$name());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$residuary(((PaymentRealmProxyInterface) realmObject).realmGet$residuary());
        ((PaymentRealmProxyInterface) unmanagedObject).realmSet$guide(((PaymentRealmProxyInterface) realmObject).realmGet$guide());
        return unmanagedObject;
    }

    static com.mobile.polux.models.Payment update(Realm realm, com.mobile.polux.models.Payment realmObject, com.mobile.polux.models.Payment newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((PaymentRealmProxyInterface) realmObject).realmSet$clientId(((PaymentRealmProxyInterface) newObject).realmGet$clientId());
        ((PaymentRealmProxyInterface) realmObject).realmSet$tipo(((PaymentRealmProxyInterface) newObject).realmGet$tipo());
        ((PaymentRealmProxyInterface) realmObject).realmSet$numCuenta(((PaymentRealmProxyInterface) newObject).realmGet$numCuenta());
        ((PaymentRealmProxyInterface) realmObject).realmSet$valor(((PaymentRealmProxyInterface) newObject).realmGet$valor());
        ((PaymentRealmProxyInterface) realmObject).realmSet$voucher(((PaymentRealmProxyInterface) newObject).realmGet$voucher());
        ((PaymentRealmProxyInterface) realmObject).realmSet$banco(((PaymentRealmProxyInterface) newObject).realmGet$banco());
        ((PaymentRealmProxyInterface) realmObject).realmSet$observaciones(((PaymentRealmProxyInterface) newObject).realmGet$observaciones());
        ((PaymentRealmProxyInterface) realmObject).realmSet$fecha(((PaymentRealmProxyInterface) newObject).realmGet$fecha());
        ((PaymentRealmProxyInterface) realmObject).realmSet$name(((PaymentRealmProxyInterface) newObject).realmGet$name());
        ((PaymentRealmProxyInterface) realmObject).realmSet$residuary(((PaymentRealmProxyInterface) newObject).realmGet$residuary());
        ((PaymentRealmProxyInterface) realmObject).realmSet$guide(((PaymentRealmProxyInterface) newObject).realmGet$guide());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Payment = proxy[");
        stringBuilder.append("{codigo:");
        stringBuilder.append(realmGet$codigo() != null ? realmGet$codigo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{clientId:");
        stringBuilder.append(realmGet$clientId());
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
        stringBuilder.append("{valor:");
        stringBuilder.append(realmGet$valor());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{voucher:");
        stringBuilder.append(realmGet$voucher() != null ? realmGet$voucher() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{banco:");
        stringBuilder.append(realmGet$banco());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{observaciones:");
        stringBuilder.append(realmGet$observaciones() != null ? realmGet$observaciones() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha:");
        stringBuilder.append(realmGet$fecha() != null ? realmGet$fecha() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{residuary:");
        stringBuilder.append(realmGet$residuary());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{guide:");
        stringBuilder.append(realmGet$guide());
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
        PaymentRealmProxy aPayment = (PaymentRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aPayment.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aPayment.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aPayment.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
