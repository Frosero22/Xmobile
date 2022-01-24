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

public class AccountRealmProxy extends com.mobile.polux.models.Account
    implements RealmObjectProxy, AccountRealmProxyInterface {

    static final class AccountColumnInfo extends ColumnInfo {
        long idIndex;
        long saleTypeCodeIndex;
        long nameSaleIndex;
        long quotaIndex;
        long daysGraceIndex;
        long stateIndex;
        long commentsIndex;
        long divisionCodeIndex;
        long XDZVCodeIndex;
        long nDivisionIndex;
        long divisionIndex;
        long permiteModificarDiasPedidoIndex;
        long diasPlazoIndex;

        AccountColumnInfo(SharedRealm realm, Table table) {
            super(13);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.saleTypeCodeIndex = addColumnDetails(table, "saleTypeCode", RealmFieldType.INTEGER);
            this.nameSaleIndex = addColumnDetails(table, "nameSale", RealmFieldType.STRING);
            this.quotaIndex = addColumnDetails(table, "quota", RealmFieldType.DOUBLE);
            this.daysGraceIndex = addColumnDetails(table, "daysGrace", RealmFieldType.INTEGER);
            this.stateIndex = addColumnDetails(table, "state", RealmFieldType.STRING);
            this.commentsIndex = addColumnDetails(table, "comments", RealmFieldType.STRING);
            this.divisionCodeIndex = addColumnDetails(table, "divisionCode", RealmFieldType.INTEGER);
            this.XDZVCodeIndex = addColumnDetails(table, "XDZVCode", RealmFieldType.INTEGER);
            this.nDivisionIndex = addColumnDetails(table, "nDivision", RealmFieldType.STRING);
            this.divisionIndex = addColumnDetails(table, "division", RealmFieldType.STRING);
            this.permiteModificarDiasPedidoIndex = addColumnDetails(table, "permiteModificarDiasPedido", RealmFieldType.STRING);
            this.diasPlazoIndex = addColumnDetails(table, "diasPlazo", RealmFieldType.INTEGER);
        }

        AccountColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new AccountColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final AccountColumnInfo src = (AccountColumnInfo) rawSrc;
            final AccountColumnInfo dst = (AccountColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.saleTypeCodeIndex = src.saleTypeCodeIndex;
            dst.nameSaleIndex = src.nameSaleIndex;
            dst.quotaIndex = src.quotaIndex;
            dst.daysGraceIndex = src.daysGraceIndex;
            dst.stateIndex = src.stateIndex;
            dst.commentsIndex = src.commentsIndex;
            dst.divisionCodeIndex = src.divisionCodeIndex;
            dst.XDZVCodeIndex = src.XDZVCodeIndex;
            dst.nDivisionIndex = src.nDivisionIndex;
            dst.divisionIndex = src.divisionIndex;
            dst.permiteModificarDiasPedidoIndex = src.permiteModificarDiasPedidoIndex;
            dst.diasPlazoIndex = src.diasPlazoIndex;
        }
    }

    private AccountColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Account> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("saleTypeCode");
        fieldNames.add("nameSale");
        fieldNames.add("quota");
        fieldNames.add("daysGrace");
        fieldNames.add("state");
        fieldNames.add("comments");
        fieldNames.add("divisionCode");
        fieldNames.add("XDZVCode");
        fieldNames.add("nDivision");
        fieldNames.add("division");
        fieldNames.add("permiteModificarDiasPedido");
        fieldNames.add("diasPlazo");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    AccountRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (AccountColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Account>(this);
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
    public Integer realmGet$saleTypeCode() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.saleTypeCodeIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.saleTypeCodeIndex);
    }

    @Override
    public void realmSet$saleTypeCode(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.saleTypeCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.saleTypeCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.saleTypeCodeIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.saleTypeCodeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nameSale() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameSaleIndex);
    }

    @Override
    public void realmSet$nameSale(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameSaleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameSaleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameSaleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameSaleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$quota() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.quotaIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.quotaIndex);
    }

    @Override
    public void realmSet$quota(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.quotaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.quotaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.quotaIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.quotaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$daysGrace() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.daysGraceIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.daysGraceIndex);
    }

    @Override
    public void realmSet$daysGrace(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.daysGraceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.daysGraceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.daysGraceIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.daysGraceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$state() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.stateIndex);
    }

    @Override
    public void realmSet$state(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.stateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.stateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.stateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$comments() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.commentsIndex);
    }

    @Override
    public void realmSet$comments(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.commentsIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.commentsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.commentsIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.commentsIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$divisionCode() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.divisionCodeIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.divisionCodeIndex);
    }

    @Override
    public void realmSet$divisionCode(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.divisionCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.divisionCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.divisionCodeIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.divisionCodeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$XDZVCode() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.XDZVCodeIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.XDZVCodeIndex);
    }

    @Override
    public void realmSet$XDZVCode(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.XDZVCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.XDZVCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.XDZVCodeIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.XDZVCodeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nDivision() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nDivisionIndex);
    }

    @Override
    public void realmSet$nDivision(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nDivisionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nDivisionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nDivisionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nDivisionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$division() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.divisionIndex);
    }

    @Override
    public void realmSet$division(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.divisionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.divisionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.divisionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.divisionIndex, value);
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

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$diasPlazo() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.diasPlazoIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.diasPlazoIndex);
    }

    @Override
    public void realmSet$diasPlazo(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.diasPlazoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.diasPlazoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.diasPlazoIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.diasPlazoIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Account")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Account");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("saleTypeCode", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("nameSale", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("quota", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("daysGrace", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("state", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("comments", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("divisionCode", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("XDZVCode", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("nDivision", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("division", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("permiteModificarDiasPedido", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("diasPlazo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Account");
    }

    public static AccountColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Account")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Account' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Account");
        final long columnCount = table.getColumnCount();
        if (columnCount != 13) {
            if (columnCount < 13) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 13 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 13 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 13 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final AccountColumnInfo columnInfo = new AccountColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("saleTypeCode")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'saleTypeCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("saleTypeCode") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'saleTypeCode' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.saleTypeCodeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'saleTypeCode' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'saleTypeCode' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("nameSale")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nameSale' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("nameSale") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nameSale' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nameSaleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nameSale' is required. Either set @Required to field 'nameSale' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("quota")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'quota' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("quota") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'quota' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.quotaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'quota' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'quota' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("daysGrace")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'daysGrace' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("daysGrace") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'daysGrace' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.daysGraceIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'daysGrace' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'daysGrace' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("state")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'state' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("state") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'state' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.stateIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'state' is required. Either set @Required to field 'state' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("comments")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'comments' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("comments") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'comments' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.commentsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'comments' is required. Either set @Required to field 'comments' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("divisionCode")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'divisionCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("divisionCode") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'divisionCode' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.divisionCodeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'divisionCode' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'divisionCode' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("XDZVCode")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'XDZVCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("XDZVCode") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'XDZVCode' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.XDZVCodeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'XDZVCode' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'XDZVCode' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("nDivision")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nDivision' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("nDivision") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nDivision' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nDivisionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nDivision' is required. Either set @Required to field 'nDivision' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("division")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'division' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("division") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'division' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.divisionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'division' is required. Either set @Required to field 'division' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("diasPlazo")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'diasPlazo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("diasPlazo") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'diasPlazo' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.diasPlazoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'diasPlazo' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'diasPlazo' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Account";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Account createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mobile.polux.models.Account obj = realm.createObjectInternal(com.mobile.polux.models.Account.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                ((AccountRealmProxyInterface) obj).realmSet$id(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("saleTypeCode")) {
            if (json.isNull("saleTypeCode")) {
                ((AccountRealmProxyInterface) obj).realmSet$saleTypeCode(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$saleTypeCode((int) json.getInt("saleTypeCode"));
            }
        }
        if (json.has("nameSale")) {
            if (json.isNull("nameSale")) {
                ((AccountRealmProxyInterface) obj).realmSet$nameSale(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$nameSale((String) json.getString("nameSale"));
            }
        }
        if (json.has("quota")) {
            if (json.isNull("quota")) {
                ((AccountRealmProxyInterface) obj).realmSet$quota(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$quota((double) json.getDouble("quota"));
            }
        }
        if (json.has("daysGrace")) {
            if (json.isNull("daysGrace")) {
                ((AccountRealmProxyInterface) obj).realmSet$daysGrace(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$daysGrace((int) json.getInt("daysGrace"));
            }
        }
        if (json.has("state")) {
            if (json.isNull("state")) {
                ((AccountRealmProxyInterface) obj).realmSet$state(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$state((String) json.getString("state"));
            }
        }
        if (json.has("comments")) {
            if (json.isNull("comments")) {
                ((AccountRealmProxyInterface) obj).realmSet$comments(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$comments((String) json.getString("comments"));
            }
        }
        if (json.has("divisionCode")) {
            if (json.isNull("divisionCode")) {
                ((AccountRealmProxyInterface) obj).realmSet$divisionCode(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$divisionCode((int) json.getInt("divisionCode"));
            }
        }
        if (json.has("XDZVCode")) {
            if (json.isNull("XDZVCode")) {
                ((AccountRealmProxyInterface) obj).realmSet$XDZVCode(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$XDZVCode((int) json.getInt("XDZVCode"));
            }
        }
        if (json.has("nDivision")) {
            if (json.isNull("nDivision")) {
                ((AccountRealmProxyInterface) obj).realmSet$nDivision(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$nDivision((String) json.getString("nDivision"));
            }
        }
        if (json.has("division")) {
            if (json.isNull("division")) {
                ((AccountRealmProxyInterface) obj).realmSet$division(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$division((String) json.getString("division"));
            }
        }
        if (json.has("permiteModificarDiasPedido")) {
            if (json.isNull("permiteModificarDiasPedido")) {
                ((AccountRealmProxyInterface) obj).realmSet$permiteModificarDiasPedido(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$permiteModificarDiasPedido((String) json.getString("permiteModificarDiasPedido"));
            }
        }
        if (json.has("diasPlazo")) {
            if (json.isNull("diasPlazo")) {
                ((AccountRealmProxyInterface) obj).realmSet$diasPlazo(null);
            } else {
                ((AccountRealmProxyInterface) obj).realmSet$diasPlazo((int) json.getInt("diasPlazo"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Account createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.mobile.polux.models.Account obj = new com.mobile.polux.models.Account();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("saleTypeCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$saleTypeCode(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$saleTypeCode((int) reader.nextInt());
                }
            } else if (name.equals("nameSale")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$nameSale(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$nameSale((String) reader.nextString());
                }
            } else if (name.equals("quota")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$quota(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$quota((double) reader.nextDouble());
                }
            } else if (name.equals("daysGrace")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$daysGrace(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$daysGrace((int) reader.nextInt());
                }
            } else if (name.equals("state")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$state(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$state((String) reader.nextString());
                }
            } else if (name.equals("comments")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$comments(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$comments((String) reader.nextString());
                }
            } else if (name.equals("divisionCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$divisionCode(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$divisionCode((int) reader.nextInt());
                }
            } else if (name.equals("XDZVCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$XDZVCode(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$XDZVCode((int) reader.nextInt());
                }
            } else if (name.equals("nDivision")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$nDivision(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$nDivision((String) reader.nextString());
                }
            } else if (name.equals("division")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$division(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$division((String) reader.nextString());
                }
            } else if (name.equals("permiteModificarDiasPedido")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$permiteModificarDiasPedido(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$permiteModificarDiasPedido((String) reader.nextString());
                }
            } else if (name.equals("diasPlazo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((AccountRealmProxyInterface) obj).realmSet$diasPlazo(null);
                } else {
                    ((AccountRealmProxyInterface) obj).realmSet$diasPlazo((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.Account copyOrUpdate(Realm realm, com.mobile.polux.models.Account object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Account) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.mobile.polux.models.Account copy(Realm realm, com.mobile.polux.models.Account newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Account) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Account realmObject = realm.createObjectInternal(com.mobile.polux.models.Account.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((AccountRealmProxyInterface) realmObject).realmSet$id(((AccountRealmProxyInterface) newObject).realmGet$id());
            ((AccountRealmProxyInterface) realmObject).realmSet$saleTypeCode(((AccountRealmProxyInterface) newObject).realmGet$saleTypeCode());
            ((AccountRealmProxyInterface) realmObject).realmSet$nameSale(((AccountRealmProxyInterface) newObject).realmGet$nameSale());
            ((AccountRealmProxyInterface) realmObject).realmSet$quota(((AccountRealmProxyInterface) newObject).realmGet$quota());
            ((AccountRealmProxyInterface) realmObject).realmSet$daysGrace(((AccountRealmProxyInterface) newObject).realmGet$daysGrace());
            ((AccountRealmProxyInterface) realmObject).realmSet$state(((AccountRealmProxyInterface) newObject).realmGet$state());
            ((AccountRealmProxyInterface) realmObject).realmSet$comments(((AccountRealmProxyInterface) newObject).realmGet$comments());
            ((AccountRealmProxyInterface) realmObject).realmSet$divisionCode(((AccountRealmProxyInterface) newObject).realmGet$divisionCode());
            ((AccountRealmProxyInterface) realmObject).realmSet$XDZVCode(((AccountRealmProxyInterface) newObject).realmGet$XDZVCode());
            ((AccountRealmProxyInterface) realmObject).realmSet$nDivision(((AccountRealmProxyInterface) newObject).realmGet$nDivision());
            ((AccountRealmProxyInterface) realmObject).realmSet$division(((AccountRealmProxyInterface) newObject).realmGet$division());
            ((AccountRealmProxyInterface) realmObject).realmSet$permiteModificarDiasPedido(((AccountRealmProxyInterface) newObject).realmGet$permiteModificarDiasPedido());
            ((AccountRealmProxyInterface) realmObject).realmSet$diasPlazo(((AccountRealmProxyInterface) newObject).realmGet$diasPlazo());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Account object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Account.class);
        long tableNativePtr = table.getNativePtr();
        AccountColumnInfo columnInfo = (AccountColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Account.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((AccountRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        }
        Number realmGet$saleTypeCode = ((AccountRealmProxyInterface)object).realmGet$saleTypeCode();
        if (realmGet$saleTypeCode != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.saleTypeCodeIndex, rowIndex, realmGet$saleTypeCode.longValue(), false);
        }
        String realmGet$nameSale = ((AccountRealmProxyInterface)object).realmGet$nameSale();
        if (realmGet$nameSale != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameSaleIndex, rowIndex, realmGet$nameSale, false);
        }
        Double realmGet$quota = ((AccountRealmProxyInterface)object).realmGet$quota();
        if (realmGet$quota != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.quotaIndex, rowIndex, realmGet$quota, false);
        }
        Number realmGet$daysGrace = ((AccountRealmProxyInterface)object).realmGet$daysGrace();
        if (realmGet$daysGrace != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.daysGraceIndex, rowIndex, realmGet$daysGrace.longValue(), false);
        }
        String realmGet$state = ((AccountRealmProxyInterface)object).realmGet$state();
        if (realmGet$state != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
        }
        String realmGet$comments = ((AccountRealmProxyInterface)object).realmGet$comments();
        if (realmGet$comments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentsIndex, rowIndex, realmGet$comments, false);
        }
        Number realmGet$divisionCode = ((AccountRealmProxyInterface)object).realmGet$divisionCode();
        if (realmGet$divisionCode != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.divisionCodeIndex, rowIndex, realmGet$divisionCode.longValue(), false);
        }
        Number realmGet$XDZVCode = ((AccountRealmProxyInterface)object).realmGet$XDZVCode();
        if (realmGet$XDZVCode != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.XDZVCodeIndex, rowIndex, realmGet$XDZVCode.longValue(), false);
        }
        String realmGet$nDivision = ((AccountRealmProxyInterface)object).realmGet$nDivision();
        if (realmGet$nDivision != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, realmGet$nDivision, false);
        }
        String realmGet$division = ((AccountRealmProxyInterface)object).realmGet$division();
        if (realmGet$division != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.divisionIndex, rowIndex, realmGet$division, false);
        }
        String realmGet$permiteModificarDiasPedido = ((AccountRealmProxyInterface)object).realmGet$permiteModificarDiasPedido();
        if (realmGet$permiteModificarDiasPedido != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, realmGet$permiteModificarDiasPedido, false);
        }
        Number realmGet$diasPlazo = ((AccountRealmProxyInterface)object).realmGet$diasPlazo();
        if (realmGet$diasPlazo != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.diasPlazoIndex, rowIndex, realmGet$diasPlazo.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Account.class);
        long tableNativePtr = table.getNativePtr();
        AccountColumnInfo columnInfo = (AccountColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Account.class);
        com.mobile.polux.models.Account object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Account) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Number realmGet$id = ((AccountRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
                }
                Number realmGet$saleTypeCode = ((AccountRealmProxyInterface)object).realmGet$saleTypeCode();
                if (realmGet$saleTypeCode != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.saleTypeCodeIndex, rowIndex, realmGet$saleTypeCode.longValue(), false);
                }
                String realmGet$nameSale = ((AccountRealmProxyInterface)object).realmGet$nameSale();
                if (realmGet$nameSale != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameSaleIndex, rowIndex, realmGet$nameSale, false);
                }
                Double realmGet$quota = ((AccountRealmProxyInterface)object).realmGet$quota();
                if (realmGet$quota != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.quotaIndex, rowIndex, realmGet$quota, false);
                }
                Number realmGet$daysGrace = ((AccountRealmProxyInterface)object).realmGet$daysGrace();
                if (realmGet$daysGrace != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.daysGraceIndex, rowIndex, realmGet$daysGrace.longValue(), false);
                }
                String realmGet$state = ((AccountRealmProxyInterface)object).realmGet$state();
                if (realmGet$state != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
                }
                String realmGet$comments = ((AccountRealmProxyInterface)object).realmGet$comments();
                if (realmGet$comments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.commentsIndex, rowIndex, realmGet$comments, false);
                }
                Number realmGet$divisionCode = ((AccountRealmProxyInterface)object).realmGet$divisionCode();
                if (realmGet$divisionCode != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.divisionCodeIndex, rowIndex, realmGet$divisionCode.longValue(), false);
                }
                Number realmGet$XDZVCode = ((AccountRealmProxyInterface)object).realmGet$XDZVCode();
                if (realmGet$XDZVCode != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.XDZVCodeIndex, rowIndex, realmGet$XDZVCode.longValue(), false);
                }
                String realmGet$nDivision = ((AccountRealmProxyInterface)object).realmGet$nDivision();
                if (realmGet$nDivision != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, realmGet$nDivision, false);
                }
                String realmGet$division = ((AccountRealmProxyInterface)object).realmGet$division();
                if (realmGet$division != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.divisionIndex, rowIndex, realmGet$division, false);
                }
                String realmGet$permiteModificarDiasPedido = ((AccountRealmProxyInterface)object).realmGet$permiteModificarDiasPedido();
                if (realmGet$permiteModificarDiasPedido != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, realmGet$permiteModificarDiasPedido, false);
                }
                Number realmGet$diasPlazo = ((AccountRealmProxyInterface)object).realmGet$diasPlazo();
                if (realmGet$diasPlazo != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.diasPlazoIndex, rowIndex, realmGet$diasPlazo.longValue(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Account object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Account.class);
        long tableNativePtr = table.getNativePtr();
        AccountColumnInfo columnInfo = (AccountColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Account.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Number realmGet$id = ((AccountRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        Number realmGet$saleTypeCode = ((AccountRealmProxyInterface)object).realmGet$saleTypeCode();
        if (realmGet$saleTypeCode != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.saleTypeCodeIndex, rowIndex, realmGet$saleTypeCode.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.saleTypeCodeIndex, rowIndex, false);
        }
        String realmGet$nameSale = ((AccountRealmProxyInterface)object).realmGet$nameSale();
        if (realmGet$nameSale != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameSaleIndex, rowIndex, realmGet$nameSale, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameSaleIndex, rowIndex, false);
        }
        Double realmGet$quota = ((AccountRealmProxyInterface)object).realmGet$quota();
        if (realmGet$quota != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.quotaIndex, rowIndex, realmGet$quota, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.quotaIndex, rowIndex, false);
        }
        Number realmGet$daysGrace = ((AccountRealmProxyInterface)object).realmGet$daysGrace();
        if (realmGet$daysGrace != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.daysGraceIndex, rowIndex, realmGet$daysGrace.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.daysGraceIndex, rowIndex, false);
        }
        String realmGet$state = ((AccountRealmProxyInterface)object).realmGet$state();
        if (realmGet$state != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stateIndex, rowIndex, false);
        }
        String realmGet$comments = ((AccountRealmProxyInterface)object).realmGet$comments();
        if (realmGet$comments != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.commentsIndex, rowIndex, realmGet$comments, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.commentsIndex, rowIndex, false);
        }
        Number realmGet$divisionCode = ((AccountRealmProxyInterface)object).realmGet$divisionCode();
        if (realmGet$divisionCode != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.divisionCodeIndex, rowIndex, realmGet$divisionCode.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.divisionCodeIndex, rowIndex, false);
        }
        Number realmGet$XDZVCode = ((AccountRealmProxyInterface)object).realmGet$XDZVCode();
        if (realmGet$XDZVCode != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.XDZVCodeIndex, rowIndex, realmGet$XDZVCode.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.XDZVCodeIndex, rowIndex, false);
        }
        String realmGet$nDivision = ((AccountRealmProxyInterface)object).realmGet$nDivision();
        if (realmGet$nDivision != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, realmGet$nDivision, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, false);
        }
        String realmGet$division = ((AccountRealmProxyInterface)object).realmGet$division();
        if (realmGet$division != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.divisionIndex, rowIndex, realmGet$division, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.divisionIndex, rowIndex, false);
        }
        String realmGet$permiteModificarDiasPedido = ((AccountRealmProxyInterface)object).realmGet$permiteModificarDiasPedido();
        if (realmGet$permiteModificarDiasPedido != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, realmGet$permiteModificarDiasPedido, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, false);
        }
        Number realmGet$diasPlazo = ((AccountRealmProxyInterface)object).realmGet$diasPlazo();
        if (realmGet$diasPlazo != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.diasPlazoIndex, rowIndex, realmGet$diasPlazo.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.diasPlazoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Account.class);
        long tableNativePtr = table.getNativePtr();
        AccountColumnInfo columnInfo = (AccountColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Account.class);
        com.mobile.polux.models.Account object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Account) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Number realmGet$id = ((AccountRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
                }
                Number realmGet$saleTypeCode = ((AccountRealmProxyInterface)object).realmGet$saleTypeCode();
                if (realmGet$saleTypeCode != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.saleTypeCodeIndex, rowIndex, realmGet$saleTypeCode.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.saleTypeCodeIndex, rowIndex, false);
                }
                String realmGet$nameSale = ((AccountRealmProxyInterface)object).realmGet$nameSale();
                if (realmGet$nameSale != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameSaleIndex, rowIndex, realmGet$nameSale, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameSaleIndex, rowIndex, false);
                }
                Double realmGet$quota = ((AccountRealmProxyInterface)object).realmGet$quota();
                if (realmGet$quota != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.quotaIndex, rowIndex, realmGet$quota, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.quotaIndex, rowIndex, false);
                }
                Number realmGet$daysGrace = ((AccountRealmProxyInterface)object).realmGet$daysGrace();
                if (realmGet$daysGrace != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.daysGraceIndex, rowIndex, realmGet$daysGrace.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.daysGraceIndex, rowIndex, false);
                }
                String realmGet$state = ((AccountRealmProxyInterface)object).realmGet$state();
                if (realmGet$state != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.stateIndex, rowIndex, false);
                }
                String realmGet$comments = ((AccountRealmProxyInterface)object).realmGet$comments();
                if (realmGet$comments != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.commentsIndex, rowIndex, realmGet$comments, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.commentsIndex, rowIndex, false);
                }
                Number realmGet$divisionCode = ((AccountRealmProxyInterface)object).realmGet$divisionCode();
                if (realmGet$divisionCode != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.divisionCodeIndex, rowIndex, realmGet$divisionCode.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.divisionCodeIndex, rowIndex, false);
                }
                Number realmGet$XDZVCode = ((AccountRealmProxyInterface)object).realmGet$XDZVCode();
                if (realmGet$XDZVCode != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.XDZVCodeIndex, rowIndex, realmGet$XDZVCode.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.XDZVCodeIndex, rowIndex, false);
                }
                String realmGet$nDivision = ((AccountRealmProxyInterface)object).realmGet$nDivision();
                if (realmGet$nDivision != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, realmGet$nDivision, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, false);
                }
                String realmGet$division = ((AccountRealmProxyInterface)object).realmGet$division();
                if (realmGet$division != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.divisionIndex, rowIndex, realmGet$division, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.divisionIndex, rowIndex, false);
                }
                String realmGet$permiteModificarDiasPedido = ((AccountRealmProxyInterface)object).realmGet$permiteModificarDiasPedido();
                if (realmGet$permiteModificarDiasPedido != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, realmGet$permiteModificarDiasPedido, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.permiteModificarDiasPedidoIndex, rowIndex, false);
                }
                Number realmGet$diasPlazo = ((AccountRealmProxyInterface)object).realmGet$diasPlazo();
                if (realmGet$diasPlazo != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.diasPlazoIndex, rowIndex, realmGet$diasPlazo.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.diasPlazoIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.mobile.polux.models.Account createDetachedCopy(com.mobile.polux.models.Account realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Account unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Account)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Account)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Account();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$id(((AccountRealmProxyInterface) realmObject).realmGet$id());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$saleTypeCode(((AccountRealmProxyInterface) realmObject).realmGet$saleTypeCode());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$nameSale(((AccountRealmProxyInterface) realmObject).realmGet$nameSale());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$quota(((AccountRealmProxyInterface) realmObject).realmGet$quota());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$daysGrace(((AccountRealmProxyInterface) realmObject).realmGet$daysGrace());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$state(((AccountRealmProxyInterface) realmObject).realmGet$state());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$comments(((AccountRealmProxyInterface) realmObject).realmGet$comments());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$divisionCode(((AccountRealmProxyInterface) realmObject).realmGet$divisionCode());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$XDZVCode(((AccountRealmProxyInterface) realmObject).realmGet$XDZVCode());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$nDivision(((AccountRealmProxyInterface) realmObject).realmGet$nDivision());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$division(((AccountRealmProxyInterface) realmObject).realmGet$division());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$permiteModificarDiasPedido(((AccountRealmProxyInterface) realmObject).realmGet$permiteModificarDiasPedido());
        ((AccountRealmProxyInterface) unmanagedObject).realmSet$diasPlazo(((AccountRealmProxyInterface) realmObject).realmGet$diasPlazo());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Account = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{saleTypeCode:");
        stringBuilder.append(realmGet$saleTypeCode() != null ? realmGet$saleTypeCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nameSale:");
        stringBuilder.append(realmGet$nameSale() != null ? realmGet$nameSale() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{quota:");
        stringBuilder.append(realmGet$quota() != null ? realmGet$quota() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{daysGrace:");
        stringBuilder.append(realmGet$daysGrace() != null ? realmGet$daysGrace() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{state:");
        stringBuilder.append(realmGet$state() != null ? realmGet$state() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{comments:");
        stringBuilder.append(realmGet$comments() != null ? realmGet$comments() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{divisionCode:");
        stringBuilder.append(realmGet$divisionCode() != null ? realmGet$divisionCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{XDZVCode:");
        stringBuilder.append(realmGet$XDZVCode() != null ? realmGet$XDZVCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nDivision:");
        stringBuilder.append(realmGet$nDivision() != null ? realmGet$nDivision() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{division:");
        stringBuilder.append(realmGet$division() != null ? realmGet$division() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{permiteModificarDiasPedido:");
        stringBuilder.append(realmGet$permiteModificarDiasPedido() != null ? realmGet$permiteModificarDiasPedido() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{diasPlazo:");
        stringBuilder.append(realmGet$diasPlazo() != null ? realmGet$diasPlazo() : "null");
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
        AccountRealmProxy aAccount = (AccountRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aAccount.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aAccount.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aAccount.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
