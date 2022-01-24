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

public class ProductPromotionOrderRealmProxy extends com.mobile.polux.models.ProductPromotionOrder
    implements RealmObjectProxy, ProductPromotionOrderRealmProxyInterface {

    static final class ProductPromotionOrderColumnInfo extends ColumnInfo {
        long codeIndex;
        long nameIndex;
        long codeSubCompanyIndex;
        long codeServiceIndex;
        long codeCompanyRateIndex;
        long codeMoneyIndex;
        long cantIndex;
        long priceIndex;
        long subtotalIndex;
        long percentDiscountIndex;
        long discountIndex;
        long subtotalBaseImpIndex;
        long applyIvaIndex;
        long percentIvaIndex;
        long ivaIndex;
        long totalIndex;
        long activeIndex;
        long codeStateIndex;
        long factIndex;
        long xFactIndex;
        long userIndex;
        long preFactIndex;
        long cantFactIndex;
        long promotionIndex;
        long unitCostIndex;
        long versionIndex;

        ProductPromotionOrderColumnInfo(SharedRealm realm, Table table) {
            super(26);
            this.codeIndex = addColumnDetails(table, "code", RealmFieldType.INTEGER);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.codeSubCompanyIndex = addColumnDetails(table, "codeSubCompany", RealmFieldType.INTEGER);
            this.codeServiceIndex = addColumnDetails(table, "codeService", RealmFieldType.INTEGER);
            this.codeCompanyRateIndex = addColumnDetails(table, "codeCompanyRate", RealmFieldType.INTEGER);
            this.codeMoneyIndex = addColumnDetails(table, "codeMoney", RealmFieldType.INTEGER);
            this.cantIndex = addColumnDetails(table, "cant", RealmFieldType.INTEGER);
            this.priceIndex = addColumnDetails(table, "price", RealmFieldType.DOUBLE);
            this.subtotalIndex = addColumnDetails(table, "subtotal", RealmFieldType.DOUBLE);
            this.percentDiscountIndex = addColumnDetails(table, "percentDiscount", RealmFieldType.DOUBLE);
            this.discountIndex = addColumnDetails(table, "discount", RealmFieldType.DOUBLE);
            this.subtotalBaseImpIndex = addColumnDetails(table, "subtotalBaseImp", RealmFieldType.DOUBLE);
            this.applyIvaIndex = addColumnDetails(table, "applyIva", RealmFieldType.STRING);
            this.percentIvaIndex = addColumnDetails(table, "percentIva", RealmFieldType.DOUBLE);
            this.ivaIndex = addColumnDetails(table, "iva", RealmFieldType.DOUBLE);
            this.totalIndex = addColumnDetails(table, "total", RealmFieldType.DOUBLE);
            this.activeIndex = addColumnDetails(table, "active", RealmFieldType.STRING);
            this.codeStateIndex = addColumnDetails(table, "codeState", RealmFieldType.STRING);
            this.factIndex = addColumnDetails(table, "fact", RealmFieldType.DOUBLE);
            this.xFactIndex = addColumnDetails(table, "xFact", RealmFieldType.DOUBLE);
            this.userIndex = addColumnDetails(table, "user", RealmFieldType.STRING);
            this.preFactIndex = addColumnDetails(table, "preFact", RealmFieldType.STRING);
            this.cantFactIndex = addColumnDetails(table, "cantFact", RealmFieldType.INTEGER);
            this.promotionIndex = addColumnDetails(table, "promotion", RealmFieldType.STRING);
            this.unitCostIndex = addColumnDetails(table, "unitCost", RealmFieldType.DOUBLE);
            this.versionIndex = addColumnDetails(table, "version", RealmFieldType.INTEGER);
        }

        ProductPromotionOrderColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ProductPromotionOrderColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ProductPromotionOrderColumnInfo src = (ProductPromotionOrderColumnInfo) rawSrc;
            final ProductPromotionOrderColumnInfo dst = (ProductPromotionOrderColumnInfo) rawDst;
            dst.codeIndex = src.codeIndex;
            dst.nameIndex = src.nameIndex;
            dst.codeSubCompanyIndex = src.codeSubCompanyIndex;
            dst.codeServiceIndex = src.codeServiceIndex;
            dst.codeCompanyRateIndex = src.codeCompanyRateIndex;
            dst.codeMoneyIndex = src.codeMoneyIndex;
            dst.cantIndex = src.cantIndex;
            dst.priceIndex = src.priceIndex;
            dst.subtotalIndex = src.subtotalIndex;
            dst.percentDiscountIndex = src.percentDiscountIndex;
            dst.discountIndex = src.discountIndex;
            dst.subtotalBaseImpIndex = src.subtotalBaseImpIndex;
            dst.applyIvaIndex = src.applyIvaIndex;
            dst.percentIvaIndex = src.percentIvaIndex;
            dst.ivaIndex = src.ivaIndex;
            dst.totalIndex = src.totalIndex;
            dst.activeIndex = src.activeIndex;
            dst.codeStateIndex = src.codeStateIndex;
            dst.factIndex = src.factIndex;
            dst.xFactIndex = src.xFactIndex;
            dst.userIndex = src.userIndex;
            dst.preFactIndex = src.preFactIndex;
            dst.cantFactIndex = src.cantFactIndex;
            dst.promotionIndex = src.promotionIndex;
            dst.unitCostIndex = src.unitCostIndex;
            dst.versionIndex = src.versionIndex;
        }
    }

    private ProductPromotionOrderColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.ProductPromotionOrder> proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("code");
        fieldNames.add("name");
        fieldNames.add("codeSubCompany");
        fieldNames.add("codeService");
        fieldNames.add("codeCompanyRate");
        fieldNames.add("codeMoney");
        fieldNames.add("cant");
        fieldNames.add("price");
        fieldNames.add("subtotal");
        fieldNames.add("percentDiscount");
        fieldNames.add("discount");
        fieldNames.add("subtotalBaseImp");
        fieldNames.add("applyIva");
        fieldNames.add("percentIva");
        fieldNames.add("iva");
        fieldNames.add("total");
        fieldNames.add("active");
        fieldNames.add("codeState");
        fieldNames.add("fact");
        fieldNames.add("xFact");
        fieldNames.add("user");
        fieldNames.add("preFact");
        fieldNames.add("cantFact");
        fieldNames.add("promotion");
        fieldNames.add("unitCost");
        fieldNames.add("version");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ProductPromotionOrderRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProductPromotionOrderColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.ProductPromotionOrder>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$code() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.codeIndex);
    }

    @Override
    public void realmSet$code(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.codeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.codeIndex, value);
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
    public Integer realmGet$codeSubCompany() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codeSubCompanyIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codeSubCompanyIndex);
    }

    @Override
    public void realmSet$codeSubCompany(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codeSubCompanyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codeSubCompanyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codeSubCompanyIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codeSubCompanyIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codeService() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codeServiceIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codeServiceIndex);
    }

    @Override
    public void realmSet$codeService(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codeServiceIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codeServiceIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codeServiceIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codeServiceIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codeCompanyRate() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codeCompanyRateIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codeCompanyRateIndex);
    }

    @Override
    public void realmSet$codeCompanyRate(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codeCompanyRateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codeCompanyRateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codeCompanyRateIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codeCompanyRateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codeMoney() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codeMoneyIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codeMoneyIndex);
    }

    @Override
    public void realmSet$codeMoney(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codeMoneyIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codeMoneyIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codeMoneyIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codeMoneyIndex, value);
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
    public double realmGet$subtotal() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.subtotalIndex);
    }

    @Override
    public void realmSet$subtotal(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.subtotalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.subtotalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$percentDiscount() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.percentDiscountIndex);
    }

    @Override
    public void realmSet$percentDiscount(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.percentDiscountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.percentDiscountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$discount() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.discountIndex);
    }

    @Override
    public void realmSet$discount(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.discountIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.discountIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$subtotalBaseImp() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.subtotalBaseImpIndex);
    }

    @Override
    public void realmSet$subtotalBaseImp(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.subtotalBaseImpIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.subtotalBaseImpIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$applyIva() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.applyIvaIndex);
    }

    @Override
    public void realmSet$applyIva(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.applyIvaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.applyIvaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.applyIvaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.applyIvaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$percentIva() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.percentIvaIndex);
    }

    @Override
    public void realmSet$percentIva(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.percentIvaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.percentIvaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$iva() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.ivaIndex);
    }

    @Override
    public void realmSet$iva(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.ivaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.ivaIndex, value);
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

    @Override
    @SuppressWarnings("cast")
    public String realmGet$active() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.activeIndex);
    }

    @Override
    public void realmSet$active(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.activeIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.activeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.activeIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.activeIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$codeState() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.codeStateIndex);
    }

    @Override
    public void realmSet$codeState(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codeStateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.codeStateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codeStateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.codeStateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$fact() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.factIndex);
    }

    @Override
    public void realmSet$fact(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.factIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.factIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$xFact() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.xFactIndex);
    }

    @Override
    public void realmSet$xFact(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.xFactIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.xFactIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$user() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.userIndex);
    }

    @Override
    public void realmSet$user(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.userIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.userIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.userIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.userIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$preFact() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.preFactIndex);
    }

    @Override
    public void realmSet$preFact(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.preFactIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.preFactIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.preFactIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.preFactIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$cantFact() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.cantFactIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.cantFactIndex);
    }

    @Override
    public void realmSet$cantFact(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cantFactIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.cantFactIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cantFactIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.cantFactIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$promotion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.promotionIndex);
    }

    @Override
    public void realmSet$promotion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.promotionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.promotionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.promotionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.promotionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$unitCost() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.unitCostIndex);
    }

    @Override
    public void realmSet$unitCost(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.unitCostIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.unitCostIndex, value);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("ProductPromotionOrder")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ProductPromotionOrder");
            realmObjectSchema.add("code", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codeSubCompany", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codeService", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codeCompanyRate", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codeMoney", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("cant", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("price", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("subtotal", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("percentDiscount", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("discount", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("subtotalBaseImp", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("applyIva", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("percentIva", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("iva", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("total", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("active", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codeState", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("fact", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("xFact", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("user", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("preFact", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("cantFact", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("promotion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("unitCost", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("version", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("ProductPromotionOrder");
    }

    public static ProductPromotionOrderColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_ProductPromotionOrder")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ProductPromotionOrder' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_ProductPromotionOrder");
        final long columnCount = table.getColumnCount();
        if (columnCount != 26) {
            if (columnCount < 26) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 26 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 26 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 26 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ProductPromotionOrderColumnInfo columnInfo = new ProductPromotionOrderColumnInfo(sharedRealm, table);

        if (table.hasPrimaryKey()) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary Key defined for field " + table.getColumnName(table.getPrimaryKey()) + " was removed.");
        }

        if (!columnTypes.containsKey("code")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'code' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("code") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'code' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.codeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'code' does support null values in the existing Realm file. Use corresponding boxed type for field 'code' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("codeSubCompany")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codeSubCompany' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codeSubCompany") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codeSubCompany' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codeSubCompanyIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codeSubCompany' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codeSubCompany' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codeService")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codeService' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codeService") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codeService' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codeServiceIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codeService' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codeService' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codeCompanyRate")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codeCompanyRate' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codeCompanyRate") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codeCompanyRate' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codeCompanyRateIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codeCompanyRate' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codeCompanyRate' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codeMoney")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codeMoney' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codeMoney") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codeMoney' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codeMoneyIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codeMoney' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codeMoney' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("subtotal")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'subtotal' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("subtotal") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'subtotal' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.subtotalIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'subtotal' does support null values in the existing Realm file. Use corresponding boxed type for field 'subtotal' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("percentDiscount")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'percentDiscount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("percentDiscount") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'percentDiscount' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.percentDiscountIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'percentDiscount' does support null values in the existing Realm file. Use corresponding boxed type for field 'percentDiscount' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("discount")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'discount' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("discount") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'discount' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.discountIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'discount' does support null values in the existing Realm file. Use corresponding boxed type for field 'discount' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("subtotalBaseImp")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'subtotalBaseImp' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("subtotalBaseImp") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'subtotalBaseImp' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.subtotalBaseImpIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'subtotalBaseImp' does support null values in the existing Realm file. Use corresponding boxed type for field 'subtotalBaseImp' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("applyIva")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'applyIva' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("applyIva") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'applyIva' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.applyIvaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'applyIva' is required. Either set @Required to field 'applyIva' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("percentIva")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'percentIva' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("percentIva") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'percentIva' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.percentIvaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'percentIva' does support null values in the existing Realm file. Use corresponding boxed type for field 'percentIva' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("iva")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iva' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("iva") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'iva' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.ivaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iva' does support null values in the existing Realm file. Use corresponding boxed type for field 'iva' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("active")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'active' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("active") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'active' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.activeIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'active' is required. Either set @Required to field 'active' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codeState")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codeState' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codeState") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'codeState' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codeStateIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'codeState' is required. Either set @Required to field 'codeState' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("fact")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fact' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fact") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'fact' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.factIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fact' does support null values in the existing Realm file. Use corresponding boxed type for field 'fact' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("xFact")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'xFact' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("xFact") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'xFact' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.xFactIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'xFact' does support null values in the existing Realm file. Use corresponding boxed type for field 'xFact' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("user")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'user' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("user") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'user' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.userIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'user' is required. Either set @Required to field 'user' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("preFact")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'preFact' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("preFact") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'preFact' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.preFactIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'preFact' is required. Either set @Required to field 'preFact' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("cantFact")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cantFact' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("cantFact") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'cantFact' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.cantFactIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'cantFact' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'cantFact' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("promotion")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'promotion' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("promotion") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'promotion' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.promotionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'promotion' is required. Either set @Required to field 'promotion' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("unitCost")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'unitCost' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("unitCost") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'unitCost' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.unitCostIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'unitCost' does support null values in the existing Realm file. Use corresponding boxed type for field 'unitCost' or migrate using RealmObjectSchema.setNullable().");
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

        return columnInfo;
    }

    public static String getTableName() {
        return "class_ProductPromotionOrder";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.ProductPromotionOrder createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mobile.polux.models.ProductPromotionOrder obj = realm.createObjectInternal(com.mobile.polux.models.ProductPromotionOrder.class, true, excludeFields);
        if (json.has("code")) {
            if (json.isNull("code")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'code' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$code((int) json.getInt("code"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("codeSubCompany")) {
            if (json.isNull("codeSubCompany")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeSubCompany(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeSubCompany((int) json.getInt("codeSubCompany"));
            }
        }
        if (json.has("codeService")) {
            if (json.isNull("codeService")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeService(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeService((int) json.getInt("codeService"));
            }
        }
        if (json.has("codeCompanyRate")) {
            if (json.isNull("codeCompanyRate")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeCompanyRate(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeCompanyRate((int) json.getInt("codeCompanyRate"));
            }
        }
        if (json.has("codeMoney")) {
            if (json.isNull("codeMoney")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeMoney(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeMoney((int) json.getInt("codeMoney"));
            }
        }
        if (json.has("cant")) {
            if (json.isNull("cant")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$cant(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$cant((int) json.getInt("cant"));
            }
        }
        if (json.has("price")) {
            if (json.isNull("price")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$price((double) json.getDouble("price"));
            }
        }
        if (json.has("subtotal")) {
            if (json.isNull("subtotal")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'subtotal' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$subtotal((double) json.getDouble("subtotal"));
            }
        }
        if (json.has("percentDiscount")) {
            if (json.isNull("percentDiscount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'percentDiscount' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$percentDiscount((double) json.getDouble("percentDiscount"));
            }
        }
        if (json.has("discount")) {
            if (json.isNull("discount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'discount' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$discount((double) json.getDouble("discount"));
            }
        }
        if (json.has("subtotalBaseImp")) {
            if (json.isNull("subtotalBaseImp")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'subtotalBaseImp' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$subtotalBaseImp((double) json.getDouble("subtotalBaseImp"));
            }
        }
        if (json.has("applyIva")) {
            if (json.isNull("applyIva")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$applyIva(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$applyIva((String) json.getString("applyIva"));
            }
        }
        if (json.has("percentIva")) {
            if (json.isNull("percentIva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'percentIva' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$percentIva((double) json.getDouble("percentIva"));
            }
        }
        if (json.has("iva")) {
            if (json.isNull("iva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'iva' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$iva((double) json.getDouble("iva"));
            }
        }
        if (json.has("total")) {
            if (json.isNull("total")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'total' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$total((double) json.getDouble("total"));
            }
        }
        if (json.has("active")) {
            if (json.isNull("active")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$active(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$active((String) json.getString("active"));
            }
        }
        if (json.has("codeState")) {
            if (json.isNull("codeState")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeState(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeState((String) json.getString("codeState"));
            }
        }
        if (json.has("fact")) {
            if (json.isNull("fact")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'fact' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$fact((double) json.getDouble("fact"));
            }
        }
        if (json.has("xFact")) {
            if (json.isNull("xFact")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'xFact' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$xFact((double) json.getDouble("xFact"));
            }
        }
        if (json.has("user")) {
            if (json.isNull("user")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$user(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$user((String) json.getString("user"));
            }
        }
        if (json.has("preFact")) {
            if (json.isNull("preFact")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$preFact(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$preFact((String) json.getString("preFact"));
            }
        }
        if (json.has("cantFact")) {
            if (json.isNull("cantFact")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$cantFact(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$cantFact((int) json.getInt("cantFact"));
            }
        }
        if (json.has("promotion")) {
            if (json.isNull("promotion")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$promotion(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$promotion((String) json.getString("promotion"));
            }
        }
        if (json.has("unitCost")) {
            if (json.isNull("unitCost")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'unitCost' to null.");
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$unitCost((double) json.getDouble("unitCost"));
            }
        }
        if (json.has("version")) {
            if (json.isNull("version")) {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$version(null);
            } else {
                ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$version((int) json.getInt("version"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.ProductPromotionOrder createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.mobile.polux.models.ProductPromotionOrder obj = new com.mobile.polux.models.ProductPromotionOrder();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("code")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'code' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$code((int) reader.nextInt());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("codeSubCompany")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeSubCompany(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeSubCompany((int) reader.nextInt());
                }
            } else if (name.equals("codeService")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeService(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeService((int) reader.nextInt());
                }
            } else if (name.equals("codeCompanyRate")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeCompanyRate(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeCompanyRate((int) reader.nextInt());
                }
            } else if (name.equals("codeMoney")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeMoney(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeMoney((int) reader.nextInt());
                }
            } else if (name.equals("cant")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$cant(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$cant((int) reader.nextInt());
                }
            } else if (name.equals("price")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'price' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$price((double) reader.nextDouble());
                }
            } else if (name.equals("subtotal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'subtotal' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$subtotal((double) reader.nextDouble());
                }
            } else if (name.equals("percentDiscount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'percentDiscount' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$percentDiscount((double) reader.nextDouble());
                }
            } else if (name.equals("discount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'discount' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$discount((double) reader.nextDouble());
                }
            } else if (name.equals("subtotalBaseImp")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'subtotalBaseImp' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$subtotalBaseImp((double) reader.nextDouble());
                }
            } else if (name.equals("applyIva")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$applyIva(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$applyIva((String) reader.nextString());
                }
            } else if (name.equals("percentIva")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'percentIva' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$percentIva((double) reader.nextDouble());
                }
            } else if (name.equals("iva")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'iva' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$iva((double) reader.nextDouble());
                }
            } else if (name.equals("total")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'total' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$total((double) reader.nextDouble());
                }
            } else if (name.equals("active")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$active(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$active((String) reader.nextString());
                }
            } else if (name.equals("codeState")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeState(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$codeState((String) reader.nextString());
                }
            } else if (name.equals("fact")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'fact' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$fact((double) reader.nextDouble());
                }
            } else if (name.equals("xFact")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'xFact' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$xFact((double) reader.nextDouble());
                }
            } else if (name.equals("user")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$user(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$user((String) reader.nextString());
                }
            } else if (name.equals("preFact")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$preFact(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$preFact((String) reader.nextString());
                }
            } else if (name.equals("cantFact")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$cantFact(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$cantFact((int) reader.nextInt());
                }
            } else if (name.equals("promotion")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$promotion(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$promotion((String) reader.nextString());
                }
            } else if (name.equals("unitCost")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'unitCost' to null.");
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$unitCost((double) reader.nextDouble());
                }
            } else if (name.equals("version")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$version(null);
                } else {
                    ((ProductPromotionOrderRealmProxyInterface) obj).realmSet$version((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.ProductPromotionOrder copyOrUpdate(Realm realm, com.mobile.polux.models.ProductPromotionOrder object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.ProductPromotionOrder) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.mobile.polux.models.ProductPromotionOrder copy(Realm realm, com.mobile.polux.models.ProductPromotionOrder newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.ProductPromotionOrder) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.ProductPromotionOrder realmObject = realm.createObjectInternal(com.mobile.polux.models.ProductPromotionOrder.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$code(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$code());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$name(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$name());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$codeSubCompany(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$codeSubCompany());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$codeService(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$codeService());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$codeCompanyRate(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$codeCompanyRate());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$codeMoney(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$codeMoney());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$cant(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$cant());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$price(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$price());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$subtotal(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$subtotal());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$percentDiscount(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$percentDiscount());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$discount(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$discount());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$subtotalBaseImp(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$subtotalBaseImp());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$applyIva(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$applyIva());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$percentIva(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$percentIva());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$iva(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$iva());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$total(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$total());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$active(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$active());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$codeState(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$codeState());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$fact(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$fact());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$xFact(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$xFact());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$user(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$user());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$preFact(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$preFact());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$cantFact(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$cantFact());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$promotion(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$promotion());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$unitCost(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$unitCost());
            ((ProductPromotionOrderRealmProxyInterface) realmObject).realmSet$version(((ProductPromotionOrderRealmProxyInterface) newObject).realmGet$version());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.ProductPromotionOrder object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.ProductPromotionOrder.class);
        long tableNativePtr = table.getNativePtr();
        ProductPromotionOrderColumnInfo columnInfo = (ProductPromotionOrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductPromotionOrder.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.codeIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$code(), false);
        String realmGet$name = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Number realmGet$codeSubCompany = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeSubCompany();
        if (realmGet$codeSubCompany != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codeSubCompanyIndex, rowIndex, realmGet$codeSubCompany.longValue(), false);
        }
        Number realmGet$codeService = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeService();
        if (realmGet$codeService != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codeServiceIndex, rowIndex, realmGet$codeService.longValue(), false);
        }
        Number realmGet$codeCompanyRate = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeCompanyRate();
        if (realmGet$codeCompanyRate != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codeCompanyRateIndex, rowIndex, realmGet$codeCompanyRate.longValue(), false);
        }
        Number realmGet$codeMoney = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeMoney();
        if (realmGet$codeMoney != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codeMoneyIndex, rowIndex, realmGet$codeMoney.longValue(), false);
        }
        Number realmGet$cant = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$cant();
        if (realmGet$cant != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, realmGet$cant.longValue(), false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$price(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$subtotal(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.percentDiscountIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$percentDiscount(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$discount(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalBaseImpIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$subtotalBaseImp(), false);
        String realmGet$applyIva = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$applyIva();
        if (realmGet$applyIva != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.applyIvaIndex, rowIndex, realmGet$applyIva, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.percentIvaIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$percentIva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$iva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$total(), false);
        String realmGet$active = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$active();
        if (realmGet$active != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.activeIndex, rowIndex, realmGet$active, false);
        }
        String realmGet$codeState = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeState();
        if (realmGet$codeState != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codeStateIndex, rowIndex, realmGet$codeState, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.factIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$fact(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.xFactIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$xFact(), false);
        String realmGet$user = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$user();
        if (realmGet$user != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIndex, rowIndex, realmGet$user, false);
        }
        String realmGet$preFact = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$preFact();
        if (realmGet$preFact != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preFactIndex, rowIndex, realmGet$preFact, false);
        }
        Number realmGet$cantFact = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$cantFact();
        if (realmGet$cantFact != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantFactIndex, rowIndex, realmGet$cantFact.longValue(), false);
        }
        String realmGet$promotion = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$promotion();
        if (realmGet$promotion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.promotionIndex, rowIndex, realmGet$promotion, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.unitCostIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$unitCost(), false);
        Number realmGet$version = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$version();
        if (realmGet$version != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, realmGet$version.longValue(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.ProductPromotionOrder.class);
        long tableNativePtr = table.getNativePtr();
        ProductPromotionOrderColumnInfo columnInfo = (ProductPromotionOrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductPromotionOrder.class);
        com.mobile.polux.models.ProductPromotionOrder object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.ProductPromotionOrder) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.codeIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$code(), false);
                String realmGet$name = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                Number realmGet$codeSubCompany = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeSubCompany();
                if (realmGet$codeSubCompany != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codeSubCompanyIndex, rowIndex, realmGet$codeSubCompany.longValue(), false);
                }
                Number realmGet$codeService = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeService();
                if (realmGet$codeService != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codeServiceIndex, rowIndex, realmGet$codeService.longValue(), false);
                }
                Number realmGet$codeCompanyRate = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeCompanyRate();
                if (realmGet$codeCompanyRate != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codeCompanyRateIndex, rowIndex, realmGet$codeCompanyRate.longValue(), false);
                }
                Number realmGet$codeMoney = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeMoney();
                if (realmGet$codeMoney != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codeMoneyIndex, rowIndex, realmGet$codeMoney.longValue(), false);
                }
                Number realmGet$cant = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$cant();
                if (realmGet$cant != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, realmGet$cant.longValue(), false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$price(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$subtotal(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.percentDiscountIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$percentDiscount(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$discount(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalBaseImpIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$subtotalBaseImp(), false);
                String realmGet$applyIva = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$applyIva();
                if (realmGet$applyIva != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.applyIvaIndex, rowIndex, realmGet$applyIva, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.percentIvaIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$percentIva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$iva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$total(), false);
                String realmGet$active = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$active();
                if (realmGet$active != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.activeIndex, rowIndex, realmGet$active, false);
                }
                String realmGet$codeState = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeState();
                if (realmGet$codeState != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codeStateIndex, rowIndex, realmGet$codeState, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.factIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$fact(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.xFactIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$xFact(), false);
                String realmGet$user = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$user();
                if (realmGet$user != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.userIndex, rowIndex, realmGet$user, false);
                }
                String realmGet$preFact = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$preFact();
                if (realmGet$preFact != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.preFactIndex, rowIndex, realmGet$preFact, false);
                }
                Number realmGet$cantFact = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$cantFact();
                if (realmGet$cantFact != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantFactIndex, rowIndex, realmGet$cantFact.longValue(), false);
                }
                String realmGet$promotion = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$promotion();
                if (realmGet$promotion != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.promotionIndex, rowIndex, realmGet$promotion, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.unitCostIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$unitCost(), false);
                Number realmGet$version = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$version();
                if (realmGet$version != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, realmGet$version.longValue(), false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.ProductPromotionOrder object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.ProductPromotionOrder.class);
        long tableNativePtr = table.getNativePtr();
        ProductPromotionOrderColumnInfo columnInfo = (ProductPromotionOrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductPromotionOrder.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.codeIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$code(), false);
        String realmGet$name = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Number realmGet$codeSubCompany = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeSubCompany();
        if (realmGet$codeSubCompany != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codeSubCompanyIndex, rowIndex, realmGet$codeSubCompany.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codeSubCompanyIndex, rowIndex, false);
        }
        Number realmGet$codeService = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeService();
        if (realmGet$codeService != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codeServiceIndex, rowIndex, realmGet$codeService.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codeServiceIndex, rowIndex, false);
        }
        Number realmGet$codeCompanyRate = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeCompanyRate();
        if (realmGet$codeCompanyRate != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codeCompanyRateIndex, rowIndex, realmGet$codeCompanyRate.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codeCompanyRateIndex, rowIndex, false);
        }
        Number realmGet$codeMoney = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeMoney();
        if (realmGet$codeMoney != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codeMoneyIndex, rowIndex, realmGet$codeMoney.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codeMoneyIndex, rowIndex, false);
        }
        Number realmGet$cant = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$cant();
        if (realmGet$cant != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, realmGet$cant.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cantIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$price(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$subtotal(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.percentDiscountIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$percentDiscount(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$discount(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalBaseImpIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$subtotalBaseImp(), false);
        String realmGet$applyIva = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$applyIva();
        if (realmGet$applyIva != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.applyIvaIndex, rowIndex, realmGet$applyIva, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.applyIvaIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.percentIvaIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$percentIva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$iva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$total(), false);
        String realmGet$active = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$active();
        if (realmGet$active != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.activeIndex, rowIndex, realmGet$active, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.activeIndex, rowIndex, false);
        }
        String realmGet$codeState = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeState();
        if (realmGet$codeState != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codeStateIndex, rowIndex, realmGet$codeState, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codeStateIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.factIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$fact(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.xFactIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$xFact(), false);
        String realmGet$user = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$user();
        if (realmGet$user != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.userIndex, rowIndex, realmGet$user, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.userIndex, rowIndex, false);
        }
        String realmGet$preFact = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$preFact();
        if (realmGet$preFact != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.preFactIndex, rowIndex, realmGet$preFact, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.preFactIndex, rowIndex, false);
        }
        Number realmGet$cantFact = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$cantFact();
        if (realmGet$cantFact != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantFactIndex, rowIndex, realmGet$cantFact.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cantFactIndex, rowIndex, false);
        }
        String realmGet$promotion = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$promotion();
        if (realmGet$promotion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.promotionIndex, rowIndex, realmGet$promotion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.promotionIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.unitCostIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$unitCost(), false);
        Number realmGet$version = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$version();
        if (realmGet$version != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, realmGet$version.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.versionIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.ProductPromotionOrder.class);
        long tableNativePtr = table.getNativePtr();
        ProductPromotionOrderColumnInfo columnInfo = (ProductPromotionOrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductPromotionOrder.class);
        com.mobile.polux.models.ProductPromotionOrder object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.ProductPromotionOrder) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.codeIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$code(), false);
                String realmGet$name = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                Number realmGet$codeSubCompany = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeSubCompany();
                if (realmGet$codeSubCompany != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codeSubCompanyIndex, rowIndex, realmGet$codeSubCompany.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codeSubCompanyIndex, rowIndex, false);
                }
                Number realmGet$codeService = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeService();
                if (realmGet$codeService != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codeServiceIndex, rowIndex, realmGet$codeService.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codeServiceIndex, rowIndex, false);
                }
                Number realmGet$codeCompanyRate = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeCompanyRate();
                if (realmGet$codeCompanyRate != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codeCompanyRateIndex, rowIndex, realmGet$codeCompanyRate.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codeCompanyRateIndex, rowIndex, false);
                }
                Number realmGet$codeMoney = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeMoney();
                if (realmGet$codeMoney != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codeMoneyIndex, rowIndex, realmGet$codeMoney.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codeMoneyIndex, rowIndex, false);
                }
                Number realmGet$cant = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$cant();
                if (realmGet$cant != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantIndex, rowIndex, realmGet$cant.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cantIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.priceIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$price(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$subtotal(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.percentDiscountIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$percentDiscount(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$discount(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalBaseImpIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$subtotalBaseImp(), false);
                String realmGet$applyIva = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$applyIva();
                if (realmGet$applyIva != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.applyIvaIndex, rowIndex, realmGet$applyIva, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.applyIvaIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.percentIvaIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$percentIva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$iva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$total(), false);
                String realmGet$active = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$active();
                if (realmGet$active != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.activeIndex, rowIndex, realmGet$active, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.activeIndex, rowIndex, false);
                }
                String realmGet$codeState = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$codeState();
                if (realmGet$codeState != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codeStateIndex, rowIndex, realmGet$codeState, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codeStateIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.factIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$fact(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.xFactIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$xFact(), false);
                String realmGet$user = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$user();
                if (realmGet$user != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.userIndex, rowIndex, realmGet$user, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.userIndex, rowIndex, false);
                }
                String realmGet$preFact = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$preFact();
                if (realmGet$preFact != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.preFactIndex, rowIndex, realmGet$preFact, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.preFactIndex, rowIndex, false);
                }
                Number realmGet$cantFact = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$cantFact();
                if (realmGet$cantFact != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantFactIndex, rowIndex, realmGet$cantFact.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cantFactIndex, rowIndex, false);
                }
                String realmGet$promotion = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$promotion();
                if (realmGet$promotion != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.promotionIndex, rowIndex, realmGet$promotion, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.promotionIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.unitCostIndex, rowIndex, ((ProductPromotionOrderRealmProxyInterface)object).realmGet$unitCost(), false);
                Number realmGet$version = ((ProductPromotionOrderRealmProxyInterface)object).realmGet$version();
                if (realmGet$version != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.versionIndex, rowIndex, realmGet$version.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.versionIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.mobile.polux.models.ProductPromotionOrder createDetachedCopy(com.mobile.polux.models.ProductPromotionOrder realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.ProductPromotionOrder unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.ProductPromotionOrder)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.ProductPromotionOrder)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.ProductPromotionOrder();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$code(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$code());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$name(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$name());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$codeSubCompany(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$codeSubCompany());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$codeService(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$codeService());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$codeCompanyRate(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$codeCompanyRate());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$codeMoney(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$codeMoney());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$cant(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$cant());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$price(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$price());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$subtotal(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$subtotal());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$percentDiscount(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$percentDiscount());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$discount(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$discount());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$subtotalBaseImp(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$subtotalBaseImp());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$applyIva(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$applyIva());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$percentIva(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$percentIva());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$iva(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$iva());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$total(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$total());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$active(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$active());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$codeState(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$codeState());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$fact(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$fact());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$xFact(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$xFact());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$user(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$user());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$preFact(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$preFact());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$cantFact(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$cantFact());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$promotion(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$promotion());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$unitCost(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$unitCost());
        ((ProductPromotionOrderRealmProxyInterface) unmanagedObject).realmSet$version(((ProductPromotionOrderRealmProxyInterface) realmObject).realmGet$version());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ProductPromotionOrder = proxy[");
        stringBuilder.append("{code:");
        stringBuilder.append(realmGet$code());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codeSubCompany:");
        stringBuilder.append(realmGet$codeSubCompany() != null ? realmGet$codeSubCompany() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codeService:");
        stringBuilder.append(realmGet$codeService() != null ? realmGet$codeService() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codeCompanyRate:");
        stringBuilder.append(realmGet$codeCompanyRate() != null ? realmGet$codeCompanyRate() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codeMoney:");
        stringBuilder.append(realmGet$codeMoney() != null ? realmGet$codeMoney() : "null");
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
        stringBuilder.append("{subtotal:");
        stringBuilder.append(realmGet$subtotal());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{percentDiscount:");
        stringBuilder.append(realmGet$percentDiscount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{discount:");
        stringBuilder.append(realmGet$discount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subtotalBaseImp:");
        stringBuilder.append(realmGet$subtotalBaseImp());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{applyIva:");
        stringBuilder.append(realmGet$applyIva() != null ? realmGet$applyIva() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{percentIva:");
        stringBuilder.append(realmGet$percentIva());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iva:");
        stringBuilder.append(realmGet$iva());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total:");
        stringBuilder.append(realmGet$total());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{active:");
        stringBuilder.append(realmGet$active() != null ? realmGet$active() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codeState:");
        stringBuilder.append(realmGet$codeState() != null ? realmGet$codeState() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fact:");
        stringBuilder.append(realmGet$fact());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{xFact:");
        stringBuilder.append(realmGet$xFact());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user:");
        stringBuilder.append(realmGet$user() != null ? realmGet$user() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{preFact:");
        stringBuilder.append(realmGet$preFact() != null ? realmGet$preFact() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantFact:");
        stringBuilder.append(realmGet$cantFact() != null ? realmGet$cantFact() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{promotion:");
        stringBuilder.append(realmGet$promotion() != null ? realmGet$promotion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{unitCost:");
        stringBuilder.append(realmGet$unitCost());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{version:");
        stringBuilder.append(realmGet$version() != null ? realmGet$version() : "null");
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
        ProductPromotionOrderRealmProxy aProductPromotionOrder = (ProductPromotionOrderRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProductPromotionOrder.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProductPromotionOrder.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProductPromotionOrder.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
