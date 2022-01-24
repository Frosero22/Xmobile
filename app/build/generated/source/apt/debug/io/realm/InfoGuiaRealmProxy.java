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

public class InfoGuiaRealmProxy extends com.mobile.polux.models.InfoGuia
    implements RealmObjectProxy, InfoGuiaRealmProxyInterface {

    static final class InfoGuiaColumnInfo extends ColumnInfo {
        long codigoGuiasCobroIndex;
        long usuarioIngresoIndex;
        long codigoEmpresaIndex;
        long codigoSucursalIndex;
        long codigoVendedorIndex;
        long codigoPersonalIndex;
        long nombreCompletoVendedorIndex;
        long fechaIngresoIndex;
        long codigoIndex;
        long detailsIndex;

        InfoGuiaColumnInfo(SharedRealm realm, Table table) {
            super(10);
            this.codigoGuiasCobroIndex = addColumnDetails(table, "codigoGuiasCobro", RealmFieldType.INTEGER);
            this.usuarioIngresoIndex = addColumnDetails(table, "usuarioIngreso", RealmFieldType.STRING);
            this.codigoEmpresaIndex = addColumnDetails(table, "codigoEmpresa", RealmFieldType.INTEGER);
            this.codigoSucursalIndex = addColumnDetails(table, "codigoSucursal", RealmFieldType.INTEGER);
            this.codigoVendedorIndex = addColumnDetails(table, "codigoVendedor", RealmFieldType.INTEGER);
            this.codigoPersonalIndex = addColumnDetails(table, "codigoPersonal", RealmFieldType.INTEGER);
            this.nombreCompletoVendedorIndex = addColumnDetails(table, "nombreCompletoVendedor", RealmFieldType.STRING);
            this.fechaIngresoIndex = addColumnDetails(table, "fechaIngreso", RealmFieldType.STRING);
            this.codigoIndex = addColumnDetails(table, "codigo", RealmFieldType.INTEGER);
            this.detailsIndex = addColumnDetails(table, "details", RealmFieldType.LIST);
        }

        InfoGuiaColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new InfoGuiaColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final InfoGuiaColumnInfo src = (InfoGuiaColumnInfo) rawSrc;
            final InfoGuiaColumnInfo dst = (InfoGuiaColumnInfo) rawDst;
            dst.codigoGuiasCobroIndex = src.codigoGuiasCobroIndex;
            dst.usuarioIngresoIndex = src.usuarioIngresoIndex;
            dst.codigoEmpresaIndex = src.codigoEmpresaIndex;
            dst.codigoSucursalIndex = src.codigoSucursalIndex;
            dst.codigoVendedorIndex = src.codigoVendedorIndex;
            dst.codigoPersonalIndex = src.codigoPersonalIndex;
            dst.nombreCompletoVendedorIndex = src.nombreCompletoVendedorIndex;
            dst.fechaIngresoIndex = src.fechaIngresoIndex;
            dst.codigoIndex = src.codigoIndex;
            dst.detailsIndex = src.detailsIndex;
        }
    }

    private InfoGuiaColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.InfoGuia> proxyState;
    private RealmList<com.mobile.polux.models.CashingGuideDetail> detailsRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("codigoGuiasCobro");
        fieldNames.add("usuarioIngreso");
        fieldNames.add("codigoEmpresa");
        fieldNames.add("codigoSucursal");
        fieldNames.add("codigoVendedor");
        fieldNames.add("codigoPersonal");
        fieldNames.add("nombreCompletoVendedor");
        fieldNames.add("fechaIngreso");
        fieldNames.add("codigo");
        fieldNames.add("details");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    InfoGuiaRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (InfoGuiaColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.InfoGuia>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$codigoGuiasCobro() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.codigoGuiasCobroIndex);
    }

    @Override
    public void realmSet$codigoGuiasCobro(long value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'codigoGuiasCobro' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$usuarioIngreso() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.usuarioIngresoIndex);
    }

    @Override
    public void realmSet$usuarioIngreso(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.usuarioIngresoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.usuarioIngresoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.usuarioIngresoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.usuarioIngresoIndex, value);
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
    public Integer realmGet$codigoSucursal() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoSucursalIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoSucursalIndex);
    }

    @Override
    public void realmSet$codigoSucursal(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoSucursalIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoSucursalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoSucursalIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoSucursalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoVendedor() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoVendedorIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoVendedorIndex);
    }

    @Override
    public void realmSet$codigoVendedor(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoVendedorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoVendedorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoVendedorIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoVendedorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoPersonal() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoPersonalIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoPersonalIndex);
    }

    @Override
    public void realmSet$codigoPersonal(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoPersonalIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoPersonalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoPersonalIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoPersonalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombreCompletoVendedor() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombreCompletoVendedorIndex);
    }

    @Override
    public void realmSet$nombreCompletoVendedor(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombreCompletoVendedorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombreCompletoVendedorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombreCompletoVendedorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombreCompletoVendedorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fechaIngreso() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fechaIngresoIndex);
    }

    @Override
    public void realmSet$fechaIngreso(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fechaIngresoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fechaIngresoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fechaIngresoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fechaIngresoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public long realmGet$codigo() {
        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.codigoIndex);
    }

    @Override
    public void realmSet$codigo(long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.codigoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.codigoIndex, value);
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
        if (!realmSchema.contains("InfoGuia")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("InfoGuia");
            realmObjectSchema.add("codigoGuiasCobro", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("usuarioIngreso", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoEmpresa", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoSucursal", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoVendedor", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoPersonal", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("nombreCompletoVendedor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("fechaIngreso", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            if (!realmSchema.contains("CashingGuideDetail")) {
                CashingGuideDetailRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("details", RealmFieldType.LIST, realmSchema.get("CashingGuideDetail"));
            return realmObjectSchema;
        }
        return realmSchema.get("InfoGuia");
    }

    public static InfoGuiaColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_InfoGuia")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'InfoGuia' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_InfoGuia");
        final long columnCount = table.getColumnCount();
        if (columnCount != 10) {
            if (columnCount < 10) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 10 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 10 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 10 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final InfoGuiaColumnInfo columnInfo = new InfoGuiaColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'codigoGuiasCobro' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.codigoGuiasCobroIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field codigoGuiasCobro");
            }
        }

        if (!columnTypes.containsKey("codigoGuiasCobro")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoGuiasCobro' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoGuiasCobro") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'codigoGuiasCobro' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.codigoGuiasCobroIndex) && table.findFirstNull(columnInfo.codigoGuiasCobroIndex) != Table.NO_MATCH) {
            throw new IllegalStateException("Cannot migrate an object with null value in field 'codigoGuiasCobro'. Either maintain the same type for primary key field 'codigoGuiasCobro', or remove the object with null value before migration.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("codigoGuiasCobro"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'codigoGuiasCobro' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
        }
        if (!columnTypes.containsKey("usuarioIngreso")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'usuarioIngreso' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("usuarioIngreso") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'usuarioIngreso' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.usuarioIngresoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'usuarioIngreso' is required. Either set @Required to field 'usuarioIngreso' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("codigoSucursal")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoSucursal' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoSucursal") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoSucursal' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoSucursalIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoSucursal' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoSucursal' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoVendedor")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoVendedor' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoVendedor") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoVendedor' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoVendedorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoVendedor' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoVendedor' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoPersonal")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoPersonal' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoPersonal") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoPersonal' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoPersonalIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoPersonal' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoPersonal' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("nombreCompletoVendedor")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'nombreCompletoVendedor' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("nombreCompletoVendedor") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'nombreCompletoVendedor' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.nombreCompletoVendedorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'nombreCompletoVendedor' is required. Either set @Required to field 'nombreCompletoVendedor' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("fechaIngreso")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fechaIngreso' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fechaIngreso") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fechaIngreso' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.fechaIngresoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fechaIngreso' is required. Either set @Required to field 'fechaIngreso' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigo")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigo") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'codigo' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.codigoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'codigo' does support null values in the existing Realm file. Use corresponding boxed type for field 'codigo' or migrate using RealmObjectSchema.setNullable().");
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
        Table table_9 = sharedRealm.getTable("class_CashingGuideDetail");
        if (!table.getLinkTarget(columnInfo.detailsIndex).hasSameSchema(table_9)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'details': '" + table.getLinkTarget(columnInfo.detailsIndex).getName() + "' expected - was '" + table_9.getName() + "'");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_InfoGuia";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.InfoGuia createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.mobile.polux.models.InfoGuia obj = null;
        if (update) {
            Table table = realm.getTable(com.mobile.polux.models.InfoGuia.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("codigoGuiasCobro")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("codigoGuiasCobro"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.InfoGuia.class), false, Collections.<String> emptyList());
                    obj = new io.realm.InfoGuiaRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("details")) {
                excludeFields.add("details");
            }
            if (json.has("codigoGuiasCobro")) {
                if (json.isNull("codigoGuiasCobro")) {
                    obj = (io.realm.InfoGuiaRealmProxy) realm.createObjectInternal(com.mobile.polux.models.InfoGuia.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.InfoGuiaRealmProxy) realm.createObjectInternal(com.mobile.polux.models.InfoGuia.class, json.getLong("codigoGuiasCobro"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'codigoGuiasCobro'.");
            }
        }
        if (json.has("usuarioIngreso")) {
            if (json.isNull("usuarioIngreso")) {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$usuarioIngreso(null);
            } else {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$usuarioIngreso((String) json.getString("usuarioIngreso"));
            }
        }
        if (json.has("codigoEmpresa")) {
            if (json.isNull("codigoEmpresa")) {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoEmpresa(null);
            } else {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoEmpresa((int) json.getInt("codigoEmpresa"));
            }
        }
        if (json.has("codigoSucursal")) {
            if (json.isNull("codigoSucursal")) {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoSucursal(null);
            } else {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoSucursal((int) json.getInt("codigoSucursal"));
            }
        }
        if (json.has("codigoVendedor")) {
            if (json.isNull("codigoVendedor")) {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoVendedor(null);
            } else {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoVendedor((int) json.getInt("codigoVendedor"));
            }
        }
        if (json.has("codigoPersonal")) {
            if (json.isNull("codigoPersonal")) {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoPersonal(null);
            } else {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoPersonal((int) json.getInt("codigoPersonal"));
            }
        }
        if (json.has("nombreCompletoVendedor")) {
            if (json.isNull("nombreCompletoVendedor")) {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$nombreCompletoVendedor(null);
            } else {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$nombreCompletoVendedor((String) json.getString("nombreCompletoVendedor"));
            }
        }
        if (json.has("fechaIngreso")) {
            if (json.isNull("fechaIngreso")) {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$fechaIngreso(null);
            } else {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$fechaIngreso((String) json.getString("fechaIngreso"));
            }
        }
        if (json.has("codigo")) {
            if (json.isNull("codigo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'codigo' to null.");
            } else {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$codigo((long) json.getLong("codigo"));
            }
        }
        if (json.has("details")) {
            if (json.isNull("details")) {
                ((InfoGuiaRealmProxyInterface) obj).realmSet$details(null);
            } else {
                ((InfoGuiaRealmProxyInterface) obj).realmGet$details().clear();
                JSONArray array = json.getJSONArray("details");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.CashingGuideDetail item = CashingGuideDetailRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((InfoGuiaRealmProxyInterface) obj).realmGet$details().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.InfoGuia createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mobile.polux.models.InfoGuia obj = new com.mobile.polux.models.InfoGuia();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("codigoGuiasCobro")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'codigoGuiasCobro' to null.");
                } else {
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoGuiasCobro((long) reader.nextLong());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("usuarioIngreso")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$usuarioIngreso(null);
                } else {
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$usuarioIngreso((String) reader.nextString());
                }
            } else if (name.equals("codigoEmpresa")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoEmpresa(null);
                } else {
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoEmpresa((int) reader.nextInt());
                }
            } else if (name.equals("codigoSucursal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoSucursal(null);
                } else {
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoSucursal((int) reader.nextInt());
                }
            } else if (name.equals("codigoVendedor")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoVendedor(null);
                } else {
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoVendedor((int) reader.nextInt());
                }
            } else if (name.equals("codigoPersonal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoPersonal(null);
                } else {
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$codigoPersonal((int) reader.nextInt());
                }
            } else if (name.equals("nombreCompletoVendedor")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$nombreCompletoVendedor(null);
                } else {
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$nombreCompletoVendedor((String) reader.nextString());
                }
            } else if (name.equals("fechaIngreso")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$fechaIngreso(null);
                } else {
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$fechaIngreso((String) reader.nextString());
                }
            } else if (name.equals("codigo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'codigo' to null.");
                } else {
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$codigo((long) reader.nextLong());
                }
            } else if (name.equals("details")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$details(null);
                } else {
                    ((InfoGuiaRealmProxyInterface) obj).realmSet$details(new RealmList<com.mobile.polux.models.CashingGuideDetail>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.CashingGuideDetail item = CashingGuideDetailRealmProxy.createUsingJsonStream(realm, reader);
                        ((InfoGuiaRealmProxyInterface) obj).realmGet$details().add(item);
                    }
                    reader.endArray();
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'codigoGuiasCobro'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.InfoGuia copyOrUpdate(Realm realm, com.mobile.polux.models.InfoGuia object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.InfoGuia) cachedRealmObject;
        } else {
            com.mobile.polux.models.InfoGuia realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.mobile.polux.models.InfoGuia.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro());
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.InfoGuia.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.InfoGuiaRealmProxy();
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

    public static com.mobile.polux.models.InfoGuia copy(Realm realm, com.mobile.polux.models.InfoGuia newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.InfoGuia) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.InfoGuia realmObject = realm.createObjectInternal(com.mobile.polux.models.InfoGuia.class, ((InfoGuiaRealmProxyInterface) newObject).realmGet$codigoGuiasCobro(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((InfoGuiaRealmProxyInterface) realmObject).realmSet$usuarioIngreso(((InfoGuiaRealmProxyInterface) newObject).realmGet$usuarioIngreso());
            ((InfoGuiaRealmProxyInterface) realmObject).realmSet$codigoEmpresa(((InfoGuiaRealmProxyInterface) newObject).realmGet$codigoEmpresa());
            ((InfoGuiaRealmProxyInterface) realmObject).realmSet$codigoSucursal(((InfoGuiaRealmProxyInterface) newObject).realmGet$codigoSucursal());
            ((InfoGuiaRealmProxyInterface) realmObject).realmSet$codigoVendedor(((InfoGuiaRealmProxyInterface) newObject).realmGet$codigoVendedor());
            ((InfoGuiaRealmProxyInterface) realmObject).realmSet$codigoPersonal(((InfoGuiaRealmProxyInterface) newObject).realmGet$codigoPersonal());
            ((InfoGuiaRealmProxyInterface) realmObject).realmSet$nombreCompletoVendedor(((InfoGuiaRealmProxyInterface) newObject).realmGet$nombreCompletoVendedor());
            ((InfoGuiaRealmProxyInterface) realmObject).realmSet$fechaIngreso(((InfoGuiaRealmProxyInterface) newObject).realmGet$fechaIngreso());
            ((InfoGuiaRealmProxyInterface) realmObject).realmSet$codigo(((InfoGuiaRealmProxyInterface) newObject).realmGet$codigo());

            RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((InfoGuiaRealmProxyInterface) newObject).realmGet$details();
            if (detailsList != null) {
                RealmList<com.mobile.polux.models.CashingGuideDetail> detailsRealmList = ((InfoGuiaRealmProxyInterface) realmObject).realmGet$details();
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

    public static long insert(Realm realm, com.mobile.polux.models.InfoGuia object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.InfoGuia.class);
        long tableNativePtr = table.getNativePtr();
        InfoGuiaColumnInfo columnInfo = (InfoGuiaColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.InfoGuia.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$usuarioIngreso = ((InfoGuiaRealmProxyInterface)object).realmGet$usuarioIngreso();
        if (realmGet$usuarioIngreso != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
        }
        Number realmGet$codigoEmpresa = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoEmpresa();
        if (realmGet$codigoEmpresa != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
        }
        Number realmGet$codigoSucursal = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoSucursal();
        if (realmGet$codigoSucursal != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
        }
        Number realmGet$codigoVendedor = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoVendedor();
        if (realmGet$codigoVendedor != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoVendedorIndex, rowIndex, realmGet$codigoVendedor.longValue(), false);
        }
        Number realmGet$codigoPersonal = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoPersonal();
        if (realmGet$codigoPersonal != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoPersonalIndex, rowIndex, realmGet$codigoPersonal.longValue(), false);
        }
        String realmGet$nombreCompletoVendedor = ((InfoGuiaRealmProxyInterface)object).realmGet$nombreCompletoVendedor();
        if (realmGet$nombreCompletoVendedor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreCompletoVendedorIndex, rowIndex, realmGet$nombreCompletoVendedor, false);
        }
        String realmGet$fechaIngreso = ((InfoGuiaRealmProxyInterface)object).realmGet$fechaIngreso();
        if (realmGet$fechaIngreso != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIngresoIndex, rowIndex, realmGet$fechaIngreso, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.codigoIndex, rowIndex, ((InfoGuiaRealmProxyInterface)object).realmGet$codigo(), false);

        RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((InfoGuiaRealmProxyInterface) object).realmGet$details();
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
        Table table = realm.getTable(com.mobile.polux.models.InfoGuia.class);
        long tableNativePtr = table.getNativePtr();
        InfoGuiaColumnInfo columnInfo = (InfoGuiaColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.InfoGuia.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.InfoGuia object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.InfoGuia) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$usuarioIngreso = ((InfoGuiaRealmProxyInterface)object).realmGet$usuarioIngreso();
                if (realmGet$usuarioIngreso != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
                }
                Number realmGet$codigoEmpresa = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoEmpresa();
                if (realmGet$codigoEmpresa != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
                }
                Number realmGet$codigoSucursal = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoSucursal();
                if (realmGet$codigoSucursal != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
                }
                Number realmGet$codigoVendedor = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoVendedor();
                if (realmGet$codigoVendedor != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoVendedorIndex, rowIndex, realmGet$codigoVendedor.longValue(), false);
                }
                Number realmGet$codigoPersonal = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoPersonal();
                if (realmGet$codigoPersonal != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoPersonalIndex, rowIndex, realmGet$codigoPersonal.longValue(), false);
                }
                String realmGet$nombreCompletoVendedor = ((InfoGuiaRealmProxyInterface)object).realmGet$nombreCompletoVendedor();
                if (realmGet$nombreCompletoVendedor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nombreCompletoVendedorIndex, rowIndex, realmGet$nombreCompletoVendedor, false);
                }
                String realmGet$fechaIngreso = ((InfoGuiaRealmProxyInterface)object).realmGet$fechaIngreso();
                if (realmGet$fechaIngreso != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaIngresoIndex, rowIndex, realmGet$fechaIngreso, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.codigoIndex, rowIndex, ((InfoGuiaRealmProxyInterface)object).realmGet$codigo(), false);

                RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((InfoGuiaRealmProxyInterface) object).realmGet$details();
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

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.InfoGuia object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.InfoGuia.class);
        long tableNativePtr = table.getNativePtr();
        InfoGuiaColumnInfo columnInfo = (InfoGuiaColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.InfoGuia.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro());
        }
        cache.put(object, rowIndex);
        String realmGet$usuarioIngreso = ((InfoGuiaRealmProxyInterface)object).realmGet$usuarioIngreso();
        if (realmGet$usuarioIngreso != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, false);
        }
        Number realmGet$codigoEmpresa = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoEmpresa();
        if (realmGet$codigoEmpresa != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, false);
        }
        Number realmGet$codigoSucursal = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoSucursal();
        if (realmGet$codigoSucursal != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, false);
        }
        Number realmGet$codigoVendedor = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoVendedor();
        if (realmGet$codigoVendedor != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoVendedorIndex, rowIndex, realmGet$codigoVendedor.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoVendedorIndex, rowIndex, false);
        }
        Number realmGet$codigoPersonal = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoPersonal();
        if (realmGet$codigoPersonal != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoPersonalIndex, rowIndex, realmGet$codigoPersonal.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoPersonalIndex, rowIndex, false);
        }
        String realmGet$nombreCompletoVendedor = ((InfoGuiaRealmProxyInterface)object).realmGet$nombreCompletoVendedor();
        if (realmGet$nombreCompletoVendedor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombreCompletoVendedorIndex, rowIndex, realmGet$nombreCompletoVendedor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombreCompletoVendedorIndex, rowIndex, false);
        }
        String realmGet$fechaIngreso = ((InfoGuiaRealmProxyInterface)object).realmGet$fechaIngreso();
        if (realmGet$fechaIngreso != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaIngresoIndex, rowIndex, realmGet$fechaIngreso, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaIngresoIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.codigoIndex, rowIndex, ((InfoGuiaRealmProxyInterface)object).realmGet$codigo(), false);

        long detailsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.detailsIndex, rowIndex);
        LinkView.nativeClear(detailsNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((InfoGuiaRealmProxyInterface) object).realmGet$details();
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
        Table table = realm.getTable(com.mobile.polux.models.InfoGuia.class);
        long tableNativePtr = table.getNativePtr();
        InfoGuiaColumnInfo columnInfo = (InfoGuiaColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.InfoGuia.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.InfoGuia object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.InfoGuia) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.NO_MATCH;
                Object primaryKeyValue = ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((InfoGuiaRealmProxyInterface) object).realmGet$codigoGuiasCobro());
                }
                cache.put(object, rowIndex);
                String realmGet$usuarioIngreso = ((InfoGuiaRealmProxyInterface)object).realmGet$usuarioIngreso();
                if (realmGet$usuarioIngreso != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, false);
                }
                Number realmGet$codigoEmpresa = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoEmpresa();
                if (realmGet$codigoEmpresa != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, false);
                }
                Number realmGet$codigoSucursal = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoSucursal();
                if (realmGet$codigoSucursal != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, false);
                }
                Number realmGet$codigoVendedor = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoVendedor();
                if (realmGet$codigoVendedor != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoVendedorIndex, rowIndex, realmGet$codigoVendedor.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoVendedorIndex, rowIndex, false);
                }
                Number realmGet$codigoPersonal = ((InfoGuiaRealmProxyInterface)object).realmGet$codigoPersonal();
                if (realmGet$codigoPersonal != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoPersonalIndex, rowIndex, realmGet$codigoPersonal.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoPersonalIndex, rowIndex, false);
                }
                String realmGet$nombreCompletoVendedor = ((InfoGuiaRealmProxyInterface)object).realmGet$nombreCompletoVendedor();
                if (realmGet$nombreCompletoVendedor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nombreCompletoVendedorIndex, rowIndex, realmGet$nombreCompletoVendedor, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nombreCompletoVendedorIndex, rowIndex, false);
                }
                String realmGet$fechaIngreso = ((InfoGuiaRealmProxyInterface)object).realmGet$fechaIngreso();
                if (realmGet$fechaIngreso != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaIngresoIndex, rowIndex, realmGet$fechaIngreso, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.fechaIngresoIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.codigoIndex, rowIndex, ((InfoGuiaRealmProxyInterface)object).realmGet$codigo(), false);

                long detailsNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.detailsIndex, rowIndex);
                LinkView.nativeClear(detailsNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((InfoGuiaRealmProxyInterface) object).realmGet$details();
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

    public static com.mobile.polux.models.InfoGuia createDetachedCopy(com.mobile.polux.models.InfoGuia realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.InfoGuia unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.InfoGuia)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.InfoGuia)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.InfoGuia();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$codigoGuiasCobro(((InfoGuiaRealmProxyInterface) realmObject).realmGet$codigoGuiasCobro());
        ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$usuarioIngreso(((InfoGuiaRealmProxyInterface) realmObject).realmGet$usuarioIngreso());
        ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$codigoEmpresa(((InfoGuiaRealmProxyInterface) realmObject).realmGet$codigoEmpresa());
        ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$codigoSucursal(((InfoGuiaRealmProxyInterface) realmObject).realmGet$codigoSucursal());
        ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$codigoVendedor(((InfoGuiaRealmProxyInterface) realmObject).realmGet$codigoVendedor());
        ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$codigoPersonal(((InfoGuiaRealmProxyInterface) realmObject).realmGet$codigoPersonal());
        ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$nombreCompletoVendedor(((InfoGuiaRealmProxyInterface) realmObject).realmGet$nombreCompletoVendedor());
        ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$fechaIngreso(((InfoGuiaRealmProxyInterface) realmObject).realmGet$fechaIngreso());
        ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$codigo(((InfoGuiaRealmProxyInterface) realmObject).realmGet$codigo());

        // Deep copy of details
        if (currentDepth == maxDepth) {
            ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$details(null);
        } else {
            RealmList<com.mobile.polux.models.CashingGuideDetail> manageddetailsList = ((InfoGuiaRealmProxyInterface) realmObject).realmGet$details();
            RealmList<com.mobile.polux.models.CashingGuideDetail> unmanageddetailsList = new RealmList<com.mobile.polux.models.CashingGuideDetail>();
            ((InfoGuiaRealmProxyInterface) unmanagedObject).realmSet$details(unmanageddetailsList);
            int nextDepth = currentDepth + 1;
            int size = manageddetailsList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.CashingGuideDetail item = CashingGuideDetailRealmProxy.createDetachedCopy(manageddetailsList.get(i), nextDepth, maxDepth, cache);
                unmanageddetailsList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.mobile.polux.models.InfoGuia update(Realm realm, com.mobile.polux.models.InfoGuia realmObject, com.mobile.polux.models.InfoGuia newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((InfoGuiaRealmProxyInterface) realmObject).realmSet$usuarioIngreso(((InfoGuiaRealmProxyInterface) newObject).realmGet$usuarioIngreso());
        ((InfoGuiaRealmProxyInterface) realmObject).realmSet$codigoEmpresa(((InfoGuiaRealmProxyInterface) newObject).realmGet$codigoEmpresa());
        ((InfoGuiaRealmProxyInterface) realmObject).realmSet$codigoSucursal(((InfoGuiaRealmProxyInterface) newObject).realmGet$codigoSucursal());
        ((InfoGuiaRealmProxyInterface) realmObject).realmSet$codigoVendedor(((InfoGuiaRealmProxyInterface) newObject).realmGet$codigoVendedor());
        ((InfoGuiaRealmProxyInterface) realmObject).realmSet$codigoPersonal(((InfoGuiaRealmProxyInterface) newObject).realmGet$codigoPersonal());
        ((InfoGuiaRealmProxyInterface) realmObject).realmSet$nombreCompletoVendedor(((InfoGuiaRealmProxyInterface) newObject).realmGet$nombreCompletoVendedor());
        ((InfoGuiaRealmProxyInterface) realmObject).realmSet$fechaIngreso(((InfoGuiaRealmProxyInterface) newObject).realmGet$fechaIngreso());
        ((InfoGuiaRealmProxyInterface) realmObject).realmSet$codigo(((InfoGuiaRealmProxyInterface) newObject).realmGet$codigo());
        RealmList<com.mobile.polux.models.CashingGuideDetail> detailsList = ((InfoGuiaRealmProxyInterface) newObject).realmGet$details();
        RealmList<com.mobile.polux.models.CashingGuideDetail> detailsRealmList = ((InfoGuiaRealmProxyInterface) realmObject).realmGet$details();
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
        StringBuilder stringBuilder = new StringBuilder("InfoGuia = proxy[");
        stringBuilder.append("{codigoGuiasCobro:");
        stringBuilder.append(realmGet$codigoGuiasCobro());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{usuarioIngreso:");
        stringBuilder.append(realmGet$usuarioIngreso() != null ? realmGet$usuarioIngreso() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoEmpresa:");
        stringBuilder.append(realmGet$codigoEmpresa() != null ? realmGet$codigoEmpresa() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoSucursal:");
        stringBuilder.append(realmGet$codigoSucursal() != null ? realmGet$codigoSucursal() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoVendedor:");
        stringBuilder.append(realmGet$codigoVendedor() != null ? realmGet$codigoVendedor() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoPersonal:");
        stringBuilder.append(realmGet$codigoPersonal() != null ? realmGet$codigoPersonal() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombreCompletoVendedor:");
        stringBuilder.append(realmGet$nombreCompletoVendedor() != null ? realmGet$nombreCompletoVendedor() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fechaIngreso:");
        stringBuilder.append(realmGet$fechaIngreso() != null ? realmGet$fechaIngreso() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigo:");
        stringBuilder.append(realmGet$codigo());
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
        InfoGuiaRealmProxy aInfoGuia = (InfoGuiaRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aInfoGuia.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aInfoGuia.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aInfoGuia.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
