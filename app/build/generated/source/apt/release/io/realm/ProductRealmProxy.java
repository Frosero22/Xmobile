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

public class ProductRealmProxy extends com.mobile.polux.models.Product
    implements RealmObjectProxy, ProductRealmProxyInterface {

    static final class ProductColumnInfo extends ColumnInfo {
        long pkIdIndex;
        long idIndex;
        long codigoEmpresaIndex;
        long codigoExistenciaIndex;
        long codigoReferencialIndex;
        long nameIndex;
        long unidadesXCajasIndex;
        long stockIndex;
        long priceIndex;
        long aplicaIvaIndex;
        long porcentajeIvaIndex;
        long costIndex;
        long serviceCodeIndex;
        long versionIndex;
        long nDivisionIndex;
        long groupIndex;
        long providerIndex;
        long subGroupIndex;
        long articleIndex;
        long aplicaDescuentoManualIndex;

        ProductColumnInfo(SharedRealm realm, Table table) {
            super(20);
            this.pkIdIndex = addColumnDetails(table, "pkId", RealmFieldType.STRING);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.codigoEmpresaIndex = addColumnDetails(table, "codigoEmpresa", RealmFieldType.INTEGER);
            this.codigoExistenciaIndex = addColumnDetails(table, "codigoExistencia", RealmFieldType.INTEGER);
            this.codigoReferencialIndex = addColumnDetails(table, "codigoReferencial", RealmFieldType.STRING);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.unidadesXCajasIndex = addColumnDetails(table, "unidadesXCajas", RealmFieldType.INTEGER);
            this.stockIndex = addColumnDetails(table, "stock", RealmFieldType.INTEGER);
            this.priceIndex = addColumnDetails(table, "price", RealmFieldType.DOUBLE);
            this.aplicaIvaIndex = addColumnDetails(table, "aplicaIva", RealmFieldType.STRING);
            this.porcentajeIvaIndex = addColumnDetails(table, "porcentajeIva", RealmFieldType.DOUBLE);
            this.costIndex = addColumnDetails(table, "cost", RealmFieldType.DOUBLE);
            this.serviceCodeIndex = addColumnDetails(table, "serviceCode", RealmFieldType.INTEGER);
            this.versionIndex = addColumnDetails(table, "version", RealmFieldType.INTEGER);
            this.nDivisionIndex = addColumnDetails(table, "nDivision", RealmFieldType.STRING);
            this.groupIndex = addColumnDetails(table, "group", RealmFieldType.INTEGER);
            this.providerIndex = addColumnDetails(table, "provider", RealmFieldType.INTEGER);
            this.subGroupIndex = addColumnDetails(table, "subGroup", RealmFieldType.INTEGER);
            this.articleIndex = addColumnDetails(table, "article", RealmFieldType.INTEGER);
            this.aplicaDescuentoManualIndex = addColumnDetails(table, "aplicaDescuentoManual", RealmFieldType.STRING);
        }

        ProductColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ProductColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ProductColumnInfo src = (ProductColumnInfo) rawSrc;
            final ProductColumnInfo dst = (ProductColumnInfo) rawDst;
            dst.pkIdIndex = src.pkIdIndex;
            dst.idIndex = src.idIndex;
            dst.codigoEmpresaIndex = src.codigoEmpresaIndex;
            dst.codigoExistenciaIndex = src.codigoExistenciaIndex;
            dst.codigoReferencialIndex = src.codigoReferencialIndex;
            dst.nameIndex = src.nameIndex;
            dst.unidadesXCajasIndex = src.unidadesXCajasIndex;
            dst.stockIndex = src.stockIndex;
            dst.priceIndex = src.priceIndex;
            dst.aplicaIvaIndex = src.aplicaIvaIndex;
            dst.porcentajeIvaIndex = src.porcentajeIvaIndex;
            dst.costIndex = src.costIndex;
            dst.serviceCodeIndex = src.serviceCodeIndex;
            dst.versionIndex = src.versionIndex;
            dst.nDivisionIndex = src.nDivisionIndex;
            dst.groupIndex = src.groupIndex;
            dst.providerIndex = src.providerIndex;
            dst.subGroupIndex = src.subGroupIndex;
            dst.articleIndex = src.articleIndex;
            dst.aplicaDescuentoManualIndex = src.aplicaDescuentoManualIndex;
        }
    }

    private ProductColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Product> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("pkId");
        fieldNames.add("id");
        fieldNames.add("codigoEmpresa");
        fieldNames.add("codigoExistencia");
        fieldNames.add("codigoReferencial");
        fieldNames.add("name");
        fieldNames.add("unidadesXCajas");
        fieldNames.add("stock");
        fieldNames.add("price");
        fieldNames.add("aplicaIva");
        fieldNames.add("porcentajeIva");
        fieldNames.add("cost");
        fieldNames.add("serviceCode");
        fieldNames.add("version");
        fieldNames.add("nDivision");
        fieldNames.add("group");
        fieldNames.add("provider");
        fieldNames.add("subGroup");
        fieldNames.add("article");
        fieldNames.add("aplicaDescuentoManual");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ProductRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProductColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Product>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$pkId() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pkIdIndex);
    }

    @Override
    public void realmSet$pkId(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'pkId' cannot be changed after object was created.");
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
    public String realmGet$codigoReferencial() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.codigoReferencialIndex);
    }

    @Override
    public void realmSet$codigoReferencial(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoReferencialIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.codigoReferencialIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoReferencialIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.codigoReferencialIndex, value);
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
    public Integer realmGet$unidadesXCajas() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.unidadesXCajasIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.unidadesXCajasIndex);
    }

    @Override
    public void realmSet$unidadesXCajas(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.unidadesXCajasIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.unidadesXCajasIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.unidadesXCajasIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.unidadesXCajasIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$stock() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.stockIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.stockIndex);
    }

    @Override
    public void realmSet$stock(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.stockIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.stockIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.stockIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.stockIndex, value);
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
    public String realmGet$aplicaIva() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.aplicaIvaIndex);
    }

    @Override
    public void realmSet$aplicaIva(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.aplicaIvaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.aplicaIvaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.aplicaIvaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.aplicaIvaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$porcentajeIva() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.porcentajeIvaIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.porcentajeIvaIndex);
    }

    @Override
    public void realmSet$porcentajeIva(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.porcentajeIvaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.porcentajeIvaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.porcentajeIvaIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.porcentajeIvaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$cost() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.costIndex);
    }

    @Override
    public void realmSet$cost(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.costIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.costIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$serviceCode() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.serviceCodeIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.serviceCodeIndex);
    }

    @Override
    public void realmSet$serviceCode(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.serviceCodeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.serviceCodeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.serviceCodeIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.serviceCodeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$version() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.versionIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.versionIndex);
    }

    @Override
    public void realmSet$version(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.versionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.versionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.versionIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.versionIndex, value);
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
    public int realmGet$group() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.groupIndex);
    }

    @Override
    public void realmSet$group(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.groupIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.groupIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$provider() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.providerIndex);
    }

    @Override
    public void realmSet$provider(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.providerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.providerIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$subGroup() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.subGroupIndex);
    }

    @Override
    public void realmSet$subGroup(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.subGroupIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.subGroupIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$article() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.articleIndex);
    }

    @Override
    public void realmSet$article(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.articleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.articleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$aplicaDescuentoManual() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.aplicaDescuentoManualIndex);
    }

    @Override
    public void realmSet$aplicaDescuentoManual(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.aplicaDescuentoManualIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.aplicaDescuentoManualIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.aplicaDescuentoManualIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.aplicaDescuentoManualIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Product")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Product");
            realmObjectSchema.add("pkId", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("codigoEmpresa", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoExistencia", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoReferencial", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("unidadesXCajas", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("stock", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("price", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("aplicaIva", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("porcentajeIva", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("cost", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("serviceCode", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("version", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("nDivision", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("group", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("provider", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("subGroup", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("article", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("aplicaDescuentoManual", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("Product");
    }

    public static ProductColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Product")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Product' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Product");
        final long columnCount = table.getColumnCount();
        if (columnCount != 20) {
            if (columnCount < 20) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 20 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 20 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 20 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ProductColumnInfo columnInfo = new ProductColumnInfo(sharedRealm, table);

        if (!table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'pkId' in existing Realm file. @PrimaryKey was added.");
        } else {
            if (table.getPrimaryKey() != columnInfo.pkIdIndex) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key annotation definition was changed, from field " + table.getColumnName(table.getPrimaryKey()) + " to field pkId");
            }
        }

        if (!columnTypes.containsKey("pkId")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'pkId' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("pkId") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'pkId' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.pkIdIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'pkId' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
        }
        if (!table.hasSearchIndex(table.getColumnIndex("pkId"))) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'pkId' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
        if (!columnTypes.containsKey("codigoReferencial")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoReferencial' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoReferencial") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'codigoReferencial' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoReferencialIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'codigoReferencial' is required. Either set @Required to field 'codigoReferencial' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("unidadesXCajas")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'unidadesXCajas' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("unidadesXCajas") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'unidadesXCajas' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.unidadesXCajasIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'unidadesXCajas' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'unidadesXCajas' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("stock")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'stock' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("stock") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'stock' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.stockIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'stock' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'stock' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("aplicaIva")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aplicaIva' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("aplicaIva") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'aplicaIva' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.aplicaIvaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aplicaIva' is required. Either set @Required to field 'aplicaIva' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("porcentajeIva")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'porcentajeIva' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("porcentajeIva") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'porcentajeIva' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.porcentajeIvaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'porcentajeIva' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'porcentajeIva' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("cost")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("cost") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'cost' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.costIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cost' does support null values in the existing Realm file. Use corresponding boxed type for field 'cost' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("serviceCode")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'serviceCode' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("serviceCode") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'serviceCode' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.serviceCodeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'serviceCode' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'serviceCode' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("version")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'version' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("version") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'version' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.versionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'version' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'version' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("group")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'group' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("group") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'group' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.groupIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'group' does support null values in the existing Realm file. Use corresponding boxed type for field 'group' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("provider")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'provider' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("provider") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'provider' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.providerIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'provider' does support null values in the existing Realm file. Use corresponding boxed type for field 'provider' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("subGroup")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'subGroup' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("subGroup") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'subGroup' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.subGroupIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'subGroup' does support null values in the existing Realm file. Use corresponding boxed type for field 'subGroup' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("article")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'article' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("article") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'article' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.articleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'article' does support null values in the existing Realm file. Use corresponding boxed type for field 'article' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("aplicaDescuentoManual")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aplicaDescuentoManual' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("aplicaDescuentoManual") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'aplicaDescuentoManual' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.aplicaDescuentoManualIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aplicaDescuentoManual' is required. Either set @Required to field 'aplicaDescuentoManual' or migrate using RealmObjectSchema.setNullable().");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Product";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Product createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mobile.polux.models.Product obj = null;
        if (update) {
            Table table = realm.getTable(com.mobile.polux.models.Product.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("pkId")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("pkId"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Product.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ProductRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("pkId")) {
                if (json.isNull("pkId")) {
                    obj = (io.realm.ProductRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Product.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ProductRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Product.class, json.getString("pkId"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pkId'.");
            }
        }
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("codigoEmpresa")) {
            if (json.isNull("codigoEmpresa")) {
                ((ProductRealmProxyInterface) obj).realmSet$codigoEmpresa(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$codigoEmpresa((int) json.getInt("codigoEmpresa"));
            }
        }
        if (json.has("codigoExistencia")) {
            if (json.isNull("codigoExistencia")) {
                ((ProductRealmProxyInterface) obj).realmSet$codigoExistencia(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$codigoExistencia((int) json.getInt("codigoExistencia"));
            }
        }
        if (json.has("codigoReferencial")) {
            if (json.isNull("codigoReferencial")) {
                ((ProductRealmProxyInterface) obj).realmSet$codigoReferencial(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$codigoReferencial((String) json.getString("codigoReferencial"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((ProductRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("unidadesXCajas")) {
            if (json.isNull("unidadesXCajas")) {
                ((ProductRealmProxyInterface) obj).realmSet$unidadesXCajas(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$unidadesXCajas((int) json.getInt("unidadesXCajas"));
            }
        }
        if (json.has("stock")) {
            if (json.isNull("stock")) {
                ((ProductRealmProxyInterface) obj).realmSet$stock(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$stock((int) json.getInt("stock"));
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$price((double) json.getDouble("price"));
            }
        }
        if (json.has("aplicaIva")) {
            if (json.isNull("aplicaIva")) {
                ((ProductRealmProxyInterface) obj).realmSet$aplicaIva(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$aplicaIva((String) json.getString("aplicaIva"));
            }
        }
        if (json.has("porcentajeIva")) {
            if (json.isNull("porcentajeIva")) {
                ((ProductRealmProxyInterface) obj).realmSet$porcentajeIva(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$porcentajeIva((double) json.getDouble("porcentajeIva"));
            }
        }
        if (json.has("cost")) {
            if (json.isNull("cost")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cost' to null.");
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$cost((double) json.getDouble("cost"));
            }
        }
        if (json.has("serviceCode")) {
            if (json.isNull("serviceCode")) {
                ((ProductRealmProxyInterface) obj).realmSet$serviceCode(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$serviceCode((int) json.getInt("serviceCode"));
            }
        }
        if (json.has("version")) {
            if (json.isNull("version")) {
                ((ProductRealmProxyInterface) obj).realmSet$version(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$version((int) json.getInt("version"));
            }
        }
        if (json.has("nDivision")) {
            if (json.isNull("nDivision")) {
                ((ProductRealmProxyInterface) obj).realmSet$nDivision(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$nDivision((String) json.getString("nDivision"));
            }
        }
        if (json.has("group")) {
            if (json.isNull("group")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'group' to null.");
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$group((int) json.getInt("group"));
            }
        }
        if (json.has("provider")) {
            if (json.isNull("provider")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'provider' to null.");
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$provider((int) json.getInt("provider"));
            }
        }
        if (json.has("subGroup")) {
            if (json.isNull("subGroup")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'subGroup' to null.");
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$subGroup((int) json.getInt("subGroup"));
            }
        }
        if (json.has("article")) {
            if (json.isNull("article")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'article' to null.");
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$article((int) json.getInt("article"));
            }
        }
        if (json.has("aplicaDescuentoManual")) {
            if (json.isNull("aplicaDescuentoManual")) {
                ((ProductRealmProxyInterface) obj).realmSet$aplicaDescuentoManual(null);
            } else {
                ((ProductRealmProxyInterface) obj).realmSet$aplicaDescuentoManual((String) json.getString("aplicaDescuentoManual"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Product createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mobile.polux.models.Product obj = new com.mobile.polux.models.Product();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("pkId")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$pkId(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$pkId((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("codigoEmpresa")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$codigoEmpresa(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$codigoEmpresa((int) reader.nextInt());
                }
            } else if (name.equals("codigoExistencia")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$codigoExistencia(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$codigoExistencia((int) reader.nextInt());
                }
            } else if (name.equals("codigoReferencial")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$codigoReferencial(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$codigoReferencial((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("unidadesXCajas")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$unidadesXCajas(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$unidadesXCajas((int) reader.nextInt());
                }
            } else if (name.equals("stock")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$stock(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$stock((int) reader.nextInt());
                }
            } else if (name.equals("price")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$price((double) reader.nextDouble());
                }
            } else if (name.equals("aplicaIva")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$aplicaIva(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$aplicaIva((String) reader.nextString());
                }
            } else if (name.equals("porcentajeIva")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$porcentajeIva(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$porcentajeIva((double) reader.nextDouble());
                }
            } else if (name.equals("cost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cost' to null.");
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$cost((double) reader.nextDouble());
                }
            } else if (name.equals("serviceCode")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$serviceCode(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$serviceCode((int) reader.nextInt());
                }
            } else if (name.equals("version")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$version(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$version((int) reader.nextInt());
                }
            } else if (name.equals("nDivision")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$nDivision(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$nDivision((String) reader.nextString());
                }
            } else if (name.equals("group")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'group' to null.");
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$group((int) reader.nextInt());
                }
            } else if (name.equals("provider")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'provider' to null.");
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$provider((int) reader.nextInt());
                }
            } else if (name.equals("subGroup")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'subGroup' to null.");
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$subGroup((int) reader.nextInt());
                }
            } else if (name.equals("article")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'article' to null.");
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$article((int) reader.nextInt());
                }
            } else if (name.equals("aplicaDescuentoManual")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductRealmProxyInterface) obj).realmSet$aplicaDescuentoManual(null);
                } else {
                    ((ProductRealmProxyInterface) obj).realmSet$aplicaDescuentoManual((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'pkId'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.Product copyOrUpdate(Realm realm, com.mobile.polux.models.Product object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Product) cachedRealmObject;
        } else {
            com.mobile.polux.models.Product realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.mobile.polux.models.Product.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((ProductRealmProxyInterface) object).realmGet$pkId();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Product.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ProductRealmProxy();
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

    public static com.mobile.polux.models.Product copy(Realm realm, com.mobile.polux.models.Product newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Product) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Product realmObject = realm.createObjectInternal(com.mobile.polux.models.Product.class, ((ProductRealmProxyInterface) newObject).realmGet$pkId(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ProductRealmProxyInterface) realmObject).realmSet$id(((ProductRealmProxyInterface) newObject).realmGet$id());
            ((ProductRealmProxyInterface) realmObject).realmSet$codigoEmpresa(((ProductRealmProxyInterface) newObject).realmGet$codigoEmpresa());
            ((ProductRealmProxyInterface) realmObject).realmSet$codigoExistencia(((ProductRealmProxyInterface) newObject).realmGet$codigoExistencia());
            ((ProductRealmProxyInterface) realmObject).realmSet$codigoReferencial(((ProductRealmProxyInterface) newObject).realmGet$codigoReferencial());
            ((ProductRealmProxyInterface) realmObject).realmSet$name(((ProductRealmProxyInterface) newObject).realmGet$name());
            ((ProductRealmProxyInterface) realmObject).realmSet$unidadesXCajas(((ProductRealmProxyInterface) newObject).realmGet$unidadesXCajas());
            ((ProductRealmProxyInterface) realmObject).realmSet$stock(((ProductRealmProxyInterface) newObject).realmGet$stock());
            ((ProductRealmProxyInterface) realmObject).realmSet$price(((ProductRealmProxyInterface) newObject).realmGet$price());
            ((ProductRealmProxyInterface) realmObject).realmSet$aplicaIva(((ProductRealmProxyInterface) newObject).realmGet$aplicaIva());
            ((ProductRealmProxyInterface) realmObject).realmSet$porcentajeIva(((ProductRealmProxyInterface) newObject).realmGet$porcentajeIva());
            ((ProductRealmProxyInterface) realmObject).realmSet$cost(((ProductRealmProxyInterface) newObject).realmGet$cost());
            ((ProductRealmProxyInterface) realmObject).realmSet$serviceCode(((ProductRealmProxyInterface) newObject).realmGet$serviceCode());
            ((ProductRealmProxyInterface) realmObject).realmSet$version(((ProductRealmProxyInterface) newObject).realmGet$version());
            ((ProductRealmProxyInterface) realmObject).realmSet$nDivision(((ProductRealmProxyInterface) newObject).realmGet$nDivision());
            ((ProductRealmProxyInterface) realmObject).realmSet$group(((ProductRealmProxyInterface) newObject).realmGet$group());
            ((ProductRealmProxyInterface) realmObject).realmSet$provider(((ProductRealmProxyInterface) newObject).realmGet$provider());
            ((ProductRealmProxyInterface) realmObject).realmSet$subGroup(((ProductRealmProxyInterface) newObject).realmGet$subGroup());
            ((ProductRealmProxyInterface) realmObject).realmSet$article(((ProductRealmProxyInterface) newObject).realmGet$article());
            ((ProductRealmProxyInterface) realmObject).realmSet$aplicaDescuentoManual(((ProductRealmProxyInterface) newObject).realmGet$aplicaDescuentoManual());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Product object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Product.class);
        long tableNativePtr = table.getNativePtr();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Product.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ProductRealmProxyInterface) object).realmGet$pkId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$id(), false);
        Number realmGet$codigoEmpresa = ((ProductRealmProxyInterface)object).realmGet$codigoEmpresa();
        if (realmGet$codigoEmpresa != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
        }
        Number realmGet$codigoExistencia = ((ProductRealmProxyInterface)object).realmGet$codigoExistencia();
        if (realmGet$codigoExistencia != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, realmGet$codigoExistencia.longValue(), false);
        }
        String realmGet$codigoReferencial = ((ProductRealmProxyInterface)object).realmGet$codigoReferencial();
        if (realmGet$codigoReferencial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigoReferencialIndex, rowIndex, realmGet$codigoReferencial, false);
        }
        String realmGet$name = ((ProductRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Number realmGet$unidadesXCajas = ((ProductRealmProxyInterface)object).realmGet$unidadesXCajas();
        if (realmGet$unidadesXCajas != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.unidadesXCajasIndex, rowIndex, realmGet$unidadesXCajas.longValue(), false);
        }
        Number realmGet$stock = ((ProductRealmProxyInterface)object).realmGet$stock();
        if (realmGet$stock != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.stockIndex, rowIndex, realmGet$stock.longValue(), false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$price(), false);
        String realmGet$aplicaIva = ((ProductRealmProxyInterface)object).realmGet$aplicaIva();
        if (realmGet$aplicaIva != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, realmGet$aplicaIva, false);
        }
        Double realmGet$porcentajeIva = ((ProductRealmProxyInterface)object).realmGet$porcentajeIva();
        if (realmGet$porcentajeIva != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeIvaIndex, rowIndex, realmGet$porcentajeIva, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.costIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$cost(), false);
        Number realmGet$serviceCode = ((ProductRealmProxyInterface)object).realmGet$serviceCode();
        if (realmGet$serviceCode != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, realmGet$serviceCode.longValue(), false);
        }
        Number realmGet$version = ((ProductRealmProxyInterface)object).realmGet$version();
        if (realmGet$version != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, realmGet$version.longValue(), false);
        }
        String realmGet$nDivision = ((ProductRealmProxyInterface)object).realmGet$nDivision();
        if (realmGet$nDivision != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, realmGet$nDivision, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.groupIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$group(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.providerIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$provider(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.subGroupIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$subGroup(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.articleIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$article(), false);
        String realmGet$aplicaDescuentoManual = ((ProductRealmProxyInterface)object).realmGet$aplicaDescuentoManual();
        if (realmGet$aplicaDescuentoManual != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaDescuentoManualIndex, rowIndex, realmGet$aplicaDescuentoManual, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Product.class);
        long tableNativePtr = table.getNativePtr();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Product.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Product object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Product) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((ProductRealmProxyInterface) object).realmGet$pkId();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$id(), false);
                Number realmGet$codigoEmpresa = ((ProductRealmProxyInterface)object).realmGet$codigoEmpresa();
                if (realmGet$codigoEmpresa != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
                }
                Number realmGet$codigoExistencia = ((ProductRealmProxyInterface)object).realmGet$codigoExistencia();
                if (realmGet$codigoExistencia != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, realmGet$codigoExistencia.longValue(), false);
                }
                String realmGet$codigoReferencial = ((ProductRealmProxyInterface)object).realmGet$codigoReferencial();
                if (realmGet$codigoReferencial != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codigoReferencialIndex, rowIndex, realmGet$codigoReferencial, false);
                }
                String realmGet$name = ((ProductRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                Number realmGet$unidadesXCajas = ((ProductRealmProxyInterface)object).realmGet$unidadesXCajas();
                if (realmGet$unidadesXCajas != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.unidadesXCajasIndex, rowIndex, realmGet$unidadesXCajas.longValue(), false);
                }
                Number realmGet$stock = ((ProductRealmProxyInterface)object).realmGet$stock();
                if (realmGet$stock != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.stockIndex, rowIndex, realmGet$stock.longValue(), false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$price(), false);
                String realmGet$aplicaIva = ((ProductRealmProxyInterface)object).realmGet$aplicaIva();
                if (realmGet$aplicaIva != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, realmGet$aplicaIva, false);
                }
                Double realmGet$porcentajeIva = ((ProductRealmProxyInterface)object).realmGet$porcentajeIva();
                if (realmGet$porcentajeIva != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeIvaIndex, rowIndex, realmGet$porcentajeIva, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.costIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$cost(), false);
                Number realmGet$serviceCode = ((ProductRealmProxyInterface)object).realmGet$serviceCode();
                if (realmGet$serviceCode != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, realmGet$serviceCode.longValue(), false);
                }
                Number realmGet$version = ((ProductRealmProxyInterface)object).realmGet$version();
                if (realmGet$version != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, realmGet$version.longValue(), false);
                }
                String realmGet$nDivision = ((ProductRealmProxyInterface)object).realmGet$nDivision();
                if (realmGet$nDivision != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, realmGet$nDivision, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.groupIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$group(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.providerIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$provider(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.subGroupIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$subGroup(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.articleIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$article(), false);
                String realmGet$aplicaDescuentoManual = ((ProductRealmProxyInterface)object).realmGet$aplicaDescuentoManual();
                if (realmGet$aplicaDescuentoManual != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaDescuentoManualIndex, rowIndex, realmGet$aplicaDescuentoManual, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Product object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Product.class);
        long tableNativePtr = table.getNativePtr();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Product.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((ProductRealmProxyInterface) object).realmGet$pkId();
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
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$id(), false);
        Number realmGet$codigoEmpresa = ((ProductRealmProxyInterface)object).realmGet$codigoEmpresa();
        if (realmGet$codigoEmpresa != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, false);
        }
        Number realmGet$codigoExistencia = ((ProductRealmProxyInterface)object).realmGet$codigoExistencia();
        if (realmGet$codigoExistencia != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, realmGet$codigoExistencia.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, false);
        }
        String realmGet$codigoReferencial = ((ProductRealmProxyInterface)object).realmGet$codigoReferencial();
        if (realmGet$codigoReferencial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigoReferencialIndex, rowIndex, realmGet$codigoReferencial, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoReferencialIndex, rowIndex, false);
        }
        String realmGet$name = ((ProductRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Number realmGet$unidadesXCajas = ((ProductRealmProxyInterface)object).realmGet$unidadesXCajas();
        if (realmGet$unidadesXCajas != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.unidadesXCajasIndex, rowIndex, realmGet$unidadesXCajas.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.unidadesXCajasIndex, rowIndex, false);
        }
        Number realmGet$stock = ((ProductRealmProxyInterface)object).realmGet$stock();
        if (realmGet$stock != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.stockIndex, rowIndex, realmGet$stock.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stockIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$price(), false);
        String realmGet$aplicaIva = ((ProductRealmProxyInterface)object).realmGet$aplicaIva();
        if (realmGet$aplicaIva != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, realmGet$aplicaIva, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, false);
        }
        Double realmGet$porcentajeIva = ((ProductRealmProxyInterface)object).realmGet$porcentajeIva();
        if (realmGet$porcentajeIva != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeIvaIndex, rowIndex, realmGet$porcentajeIva, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.porcentajeIvaIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.costIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$cost(), false);
        Number realmGet$serviceCode = ((ProductRealmProxyInterface)object).realmGet$serviceCode();
        if (realmGet$serviceCode != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, realmGet$serviceCode.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, false);
        }
        Number realmGet$version = ((ProductRealmProxyInterface)object).realmGet$version();
        if (realmGet$version != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, realmGet$version.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.versionIndex, rowIndex, false);
        }
        String realmGet$nDivision = ((ProductRealmProxyInterface)object).realmGet$nDivision();
        if (realmGet$nDivision != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, realmGet$nDivision, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.groupIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$group(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.providerIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$provider(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.subGroupIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$subGroup(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.articleIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$article(), false);
        String realmGet$aplicaDescuentoManual = ((ProductRealmProxyInterface)object).realmGet$aplicaDescuentoManual();
        if (realmGet$aplicaDescuentoManual != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaDescuentoManualIndex, rowIndex, realmGet$aplicaDescuentoManual, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.aplicaDescuentoManualIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Product.class);
        long tableNativePtr = table.getNativePtr();
        ProductColumnInfo columnInfo = (ProductColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Product.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Product object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Product) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((ProductRealmProxyInterface) object).realmGet$pkId();
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
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$id(), false);
                Number realmGet$codigoEmpresa = ((ProductRealmProxyInterface)object).realmGet$codigoEmpresa();
                if (realmGet$codigoEmpresa != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, false);
                }
                Number realmGet$codigoExistencia = ((ProductRealmProxyInterface)object).realmGet$codigoExistencia();
                if (realmGet$codigoExistencia != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, realmGet$codigoExistencia.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, false);
                }
                String realmGet$codigoReferencial = ((ProductRealmProxyInterface)object).realmGet$codigoReferencial();
                if (realmGet$codigoReferencial != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codigoReferencialIndex, rowIndex, realmGet$codigoReferencial, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoReferencialIndex, rowIndex, false);
                }
                String realmGet$name = ((ProductRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                Number realmGet$unidadesXCajas = ((ProductRealmProxyInterface)object).realmGet$unidadesXCajas();
                if (realmGet$unidadesXCajas != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.unidadesXCajasIndex, rowIndex, realmGet$unidadesXCajas.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.unidadesXCajasIndex, rowIndex, false);
                }
                Number realmGet$stock = ((ProductRealmProxyInterface)object).realmGet$stock();
                if (realmGet$stock != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.stockIndex, rowIndex, realmGet$stock.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.stockIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$price(), false);
                String realmGet$aplicaIva = ((ProductRealmProxyInterface)object).realmGet$aplicaIva();
                if (realmGet$aplicaIva != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, realmGet$aplicaIva, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, false);
                }
                Double realmGet$porcentajeIva = ((ProductRealmProxyInterface)object).realmGet$porcentajeIva();
                if (realmGet$porcentajeIva != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeIvaIndex, rowIndex, realmGet$porcentajeIva, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.porcentajeIvaIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.costIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$cost(), false);
                Number realmGet$serviceCode = ((ProductRealmProxyInterface)object).realmGet$serviceCode();
                if (realmGet$serviceCode != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, realmGet$serviceCode.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.serviceCodeIndex, rowIndex, false);
                }
                Number realmGet$version = ((ProductRealmProxyInterface)object).realmGet$version();
                if (realmGet$version != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, realmGet$version.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.versionIndex, rowIndex, false);
                }
                String realmGet$nDivision = ((ProductRealmProxyInterface)object).realmGet$nDivision();
                if (realmGet$nDivision != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, realmGet$nDivision, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nDivisionIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.groupIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$group(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.providerIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$provider(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.subGroupIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$subGroup(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.articleIndex, rowIndex, ((ProductRealmProxyInterface)object).realmGet$article(), false);
                String realmGet$aplicaDescuentoManual = ((ProductRealmProxyInterface)object).realmGet$aplicaDescuentoManual();
                if (realmGet$aplicaDescuentoManual != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaDescuentoManualIndex, rowIndex, realmGet$aplicaDescuentoManual, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.aplicaDescuentoManualIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.mobile.polux.models.Product createDetachedCopy(com.mobile.polux.models.Product realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Product unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Product)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Product)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Product();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$pkId(((ProductRealmProxyInterface) realmObject).realmGet$pkId());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$id(((ProductRealmProxyInterface) realmObject).realmGet$id());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$codigoEmpresa(((ProductRealmProxyInterface) realmObject).realmGet$codigoEmpresa());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$codigoExistencia(((ProductRealmProxyInterface) realmObject).realmGet$codigoExistencia());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$codigoReferencial(((ProductRealmProxyInterface) realmObject).realmGet$codigoReferencial());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$name(((ProductRealmProxyInterface) realmObject).realmGet$name());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$unidadesXCajas(((ProductRealmProxyInterface) realmObject).realmGet$unidadesXCajas());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$stock(((ProductRealmProxyInterface) realmObject).realmGet$stock());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$price(((ProductRealmProxyInterface) realmObject).realmGet$price());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$aplicaIva(((ProductRealmProxyInterface) realmObject).realmGet$aplicaIva());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$porcentajeIva(((ProductRealmProxyInterface) realmObject).realmGet$porcentajeIva());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$cost(((ProductRealmProxyInterface) realmObject).realmGet$cost());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$serviceCode(((ProductRealmProxyInterface) realmObject).realmGet$serviceCode());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$version(((ProductRealmProxyInterface) realmObject).realmGet$version());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$nDivision(((ProductRealmProxyInterface) realmObject).realmGet$nDivision());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$group(((ProductRealmProxyInterface) realmObject).realmGet$group());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$provider(((ProductRealmProxyInterface) realmObject).realmGet$provider());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$subGroup(((ProductRealmProxyInterface) realmObject).realmGet$subGroup());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$article(((ProductRealmProxyInterface) realmObject).realmGet$article());
        ((ProductRealmProxyInterface) unmanagedObject).realmSet$aplicaDescuentoManual(((ProductRealmProxyInterface) realmObject).realmGet$aplicaDescuentoManual());
        return unmanagedObject;
    }

    static com.mobile.polux.models.Product update(Realm realm, com.mobile.polux.models.Product realmObject, com.mobile.polux.models.Product newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ProductRealmProxyInterface) realmObject).realmSet$id(((ProductRealmProxyInterface) newObject).realmGet$id());
        ((ProductRealmProxyInterface) realmObject).realmSet$codigoEmpresa(((ProductRealmProxyInterface) newObject).realmGet$codigoEmpresa());
        ((ProductRealmProxyInterface) realmObject).realmSet$codigoExistencia(((ProductRealmProxyInterface) newObject).realmGet$codigoExistencia());
        ((ProductRealmProxyInterface) realmObject).realmSet$codigoReferencial(((ProductRealmProxyInterface) newObject).realmGet$codigoReferencial());
        ((ProductRealmProxyInterface) realmObject).realmSet$name(((ProductRealmProxyInterface) newObject).realmGet$name());
        ((ProductRealmProxyInterface) realmObject).realmSet$unidadesXCajas(((ProductRealmProxyInterface) newObject).realmGet$unidadesXCajas());
        ((ProductRealmProxyInterface) realmObject).realmSet$stock(((ProductRealmProxyInterface) newObject).realmGet$stock());
        ((ProductRealmProxyInterface) realmObject).realmSet$price(((ProductRealmProxyInterface) newObject).realmGet$price());
        ((ProductRealmProxyInterface) realmObject).realmSet$aplicaIva(((ProductRealmProxyInterface) newObject).realmGet$aplicaIva());
        ((ProductRealmProxyInterface) realmObject).realmSet$porcentajeIva(((ProductRealmProxyInterface) newObject).realmGet$porcentajeIva());
        ((ProductRealmProxyInterface) realmObject).realmSet$cost(((ProductRealmProxyInterface) newObject).realmGet$cost());
        ((ProductRealmProxyInterface) realmObject).realmSet$serviceCode(((ProductRealmProxyInterface) newObject).realmGet$serviceCode());
        ((ProductRealmProxyInterface) realmObject).realmSet$version(((ProductRealmProxyInterface) newObject).realmGet$version());
        ((ProductRealmProxyInterface) realmObject).realmSet$nDivision(((ProductRealmProxyInterface) newObject).realmGet$nDivision());
        ((ProductRealmProxyInterface) realmObject).realmSet$group(((ProductRealmProxyInterface) newObject).realmGet$group());
        ((ProductRealmProxyInterface) realmObject).realmSet$provider(((ProductRealmProxyInterface) newObject).realmGet$provider());
        ((ProductRealmProxyInterface) realmObject).realmSet$subGroup(((ProductRealmProxyInterface) newObject).realmGet$subGroup());
        ((ProductRealmProxyInterface) realmObject).realmSet$article(((ProductRealmProxyInterface) newObject).realmGet$article());
        ((ProductRealmProxyInterface) realmObject).realmSet$aplicaDescuentoManual(((ProductRealmProxyInterface) newObject).realmGet$aplicaDescuentoManual());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Product = proxy[");
        stringBuilder.append("{pkId:");
        stringBuilder.append(realmGet$pkId() != null ? realmGet$pkId() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
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
        stringBuilder.append("{codigoReferencial:");
        stringBuilder.append(realmGet$codigoReferencial() != null ? realmGet$codigoReferencial() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unidadesXCajas:");
        stringBuilder.append(realmGet$unidadesXCajas() != null ? realmGet$unidadesXCajas() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{stock:");
        stringBuilder.append(realmGet$stock() != null ? realmGet$stock() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{price:");
        stringBuilder.append(realmGet$price());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aplicaIva:");
        stringBuilder.append(realmGet$aplicaIva() != null ? realmGet$aplicaIva() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{porcentajeIva:");
        stringBuilder.append(realmGet$porcentajeIva() != null ? realmGet$porcentajeIva() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cost:");
        stringBuilder.append(realmGet$cost());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{serviceCode:");
        stringBuilder.append(realmGet$serviceCode() != null ? realmGet$serviceCode() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{version:");
        stringBuilder.append(realmGet$version() != null ? realmGet$version() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nDivision:");
        stringBuilder.append(realmGet$nDivision() != null ? realmGet$nDivision() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{group:");
        stringBuilder.append(realmGet$group());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{provider:");
        stringBuilder.append(realmGet$provider());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subGroup:");
        stringBuilder.append(realmGet$subGroup());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{article:");
        stringBuilder.append(realmGet$article());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aplicaDescuentoManual:");
        stringBuilder.append(realmGet$aplicaDescuentoManual() != null ? realmGet$aplicaDescuentoManual() : "null");
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
        ProductRealmProxy aProduct = (ProductRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProduct.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProduct.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProduct.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
