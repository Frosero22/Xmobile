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

public class ProductOrderRealmProxy extends com.mobile.polux.models.ProductOrder
    implements RealmObjectProxy, ProductOrderRealmProxyInterface {

    static final class ProductOrderColumnInfo extends ColumnInfo {
        long idIndex;
        long codigoPrestacionIndex;
        long codigoExistenciaIndex;
        long nameIndex;
        long boxesIndex;
        long unitsIndex;
        long codigoSucursalIndex;
        long codigoServicioIndex;
        long cantidadIndex;
        long precioUnitarioVentaIndex;
        long subtotalVentaIndex;
        long porcentajeDescuentoIndex;
        long valorDescuentoIndex;
        long subtotalBaseImponibleIndex;
        long aplicaIvaIndex;
        long porcentajeIvaIndex;
        long valorIvaIndex;
        long valorTotalIndex;
        long esActivoIndex;
        long codigoEstadoIndex;
        long usuarioIngresoIndex;
        long tieneStockDisponibleIndex;
        long esPromocionIndex;
        long costoUnitarioIndex;
        long costoTotalIndex;
        long costoPromedioIndex;
        long numeroVersionIndex;
        long esPromocionAutomaticaIndex;
        long codigoReglaNegocioIndex;
        long lineaDetalleIndex;
        long aplicaXRulesIndex;
        long porcentajeDescuentoXRulesIndex;
        long valorDescuentoXRulesIndex;
        long porcentajeDescuentoManualIndex;
        long valorDescuentoManualIndex;
        long cantidadEnCajasIndex;
        long cantidadEnUnidadesIndex;
        long productRelationIndex;
        long lstDafDetallesOrdenIndex;
        long providerIndex;
        long groupIndex;
        long subGroupIndex;
        long articleIndex;

        ProductOrderColumnInfo(SharedRealm realm, Table table) {
            super(43);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.codigoPrestacionIndex = addColumnDetails(table, "codigoPrestacion", RealmFieldType.INTEGER);
            this.codigoExistenciaIndex = addColumnDetails(table, "codigoExistencia", RealmFieldType.INTEGER);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.boxesIndex = addColumnDetails(table, "boxes", RealmFieldType.INTEGER);
            this.unitsIndex = addColumnDetails(table, "units", RealmFieldType.INTEGER);
            this.codigoSucursalIndex = addColumnDetails(table, "codigoSucursal", RealmFieldType.INTEGER);
            this.codigoServicioIndex = addColumnDetails(table, "codigoServicio", RealmFieldType.INTEGER);
            this.cantidadIndex = addColumnDetails(table, "cantidad", RealmFieldType.INTEGER);
            this.precioUnitarioVentaIndex = addColumnDetails(table, "precioUnitarioVenta", RealmFieldType.DOUBLE);
            this.subtotalVentaIndex = addColumnDetails(table, "subtotalVenta", RealmFieldType.DOUBLE);
            this.porcentajeDescuentoIndex = addColumnDetails(table, "porcentajeDescuento", RealmFieldType.DOUBLE);
            this.valorDescuentoIndex = addColumnDetails(table, "valorDescuento", RealmFieldType.DOUBLE);
            this.subtotalBaseImponibleIndex = addColumnDetails(table, "subtotalBaseImponible", RealmFieldType.DOUBLE);
            this.aplicaIvaIndex = addColumnDetails(table, "aplicaIva", RealmFieldType.STRING);
            this.porcentajeIvaIndex = addColumnDetails(table, "porcentajeIva", RealmFieldType.DOUBLE);
            this.valorIvaIndex = addColumnDetails(table, "valorIva", RealmFieldType.DOUBLE);
            this.valorTotalIndex = addColumnDetails(table, "valorTotal", RealmFieldType.DOUBLE);
            this.esActivoIndex = addColumnDetails(table, "esActivo", RealmFieldType.STRING);
            this.codigoEstadoIndex = addColumnDetails(table, "codigoEstado", RealmFieldType.STRING);
            this.usuarioIngresoIndex = addColumnDetails(table, "usuarioIngreso", RealmFieldType.STRING);
            this.tieneStockDisponibleIndex = addColumnDetails(table, "tieneStockDisponible", RealmFieldType.STRING);
            this.esPromocionIndex = addColumnDetails(table, "esPromocion", RealmFieldType.STRING);
            this.costoUnitarioIndex = addColumnDetails(table, "costoUnitario", RealmFieldType.DOUBLE);
            this.costoTotalIndex = addColumnDetails(table, "costoTotal", RealmFieldType.DOUBLE);
            this.costoPromedioIndex = addColumnDetails(table, "costoPromedio", RealmFieldType.DOUBLE);
            this.numeroVersionIndex = addColumnDetails(table, "numeroVersion", RealmFieldType.INTEGER);
            this.esPromocionAutomaticaIndex = addColumnDetails(table, "esPromocionAutomatica", RealmFieldType.STRING);
            this.codigoReglaNegocioIndex = addColumnDetails(table, "codigoReglaNegocio", RealmFieldType.INTEGER);
            this.lineaDetalleIndex = addColumnDetails(table, "lineaDetalle", RealmFieldType.INTEGER);
            this.aplicaXRulesIndex = addColumnDetails(table, "aplicaXRules", RealmFieldType.STRING);
            this.porcentajeDescuentoXRulesIndex = addColumnDetails(table, "porcentajeDescuentoXRules", RealmFieldType.DOUBLE);
            this.valorDescuentoXRulesIndex = addColumnDetails(table, "valorDescuentoXRules", RealmFieldType.DOUBLE);
            this.porcentajeDescuentoManualIndex = addColumnDetails(table, "porcentajeDescuentoManual", RealmFieldType.DOUBLE);
            this.valorDescuentoManualIndex = addColumnDetails(table, "valorDescuentoManual", RealmFieldType.DOUBLE);
            this.cantidadEnCajasIndex = addColumnDetails(table, "cantidadEnCajas", RealmFieldType.INTEGER);
            this.cantidadEnUnidadesIndex = addColumnDetails(table, "cantidadEnUnidades", RealmFieldType.INTEGER);
            this.productRelationIndex = addColumnDetails(table, "productRelation", RealmFieldType.INTEGER);
            this.lstDafDetallesOrdenIndex = addColumnDetails(table, "lstDafDetallesOrden", RealmFieldType.LIST);
            this.providerIndex = addColumnDetails(table, "provider", RealmFieldType.INTEGER);
            this.groupIndex = addColumnDetails(table, "group", RealmFieldType.INTEGER);
            this.subGroupIndex = addColumnDetails(table, "subGroup", RealmFieldType.INTEGER);
            this.articleIndex = addColumnDetails(table, "article", RealmFieldType.INTEGER);
        }

        ProductOrderColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ProductOrderColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ProductOrderColumnInfo src = (ProductOrderColumnInfo) rawSrc;
            final ProductOrderColumnInfo dst = (ProductOrderColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.codigoPrestacionIndex = src.codigoPrestacionIndex;
            dst.codigoExistenciaIndex = src.codigoExistenciaIndex;
            dst.nameIndex = src.nameIndex;
            dst.boxesIndex = src.boxesIndex;
            dst.unitsIndex = src.unitsIndex;
            dst.codigoSucursalIndex = src.codigoSucursalIndex;
            dst.codigoServicioIndex = src.codigoServicioIndex;
            dst.cantidadIndex = src.cantidadIndex;
            dst.precioUnitarioVentaIndex = src.precioUnitarioVentaIndex;
            dst.subtotalVentaIndex = src.subtotalVentaIndex;
            dst.porcentajeDescuentoIndex = src.porcentajeDescuentoIndex;
            dst.valorDescuentoIndex = src.valorDescuentoIndex;
            dst.subtotalBaseImponibleIndex = src.subtotalBaseImponibleIndex;
            dst.aplicaIvaIndex = src.aplicaIvaIndex;
            dst.porcentajeIvaIndex = src.porcentajeIvaIndex;
            dst.valorIvaIndex = src.valorIvaIndex;
            dst.valorTotalIndex = src.valorTotalIndex;
            dst.esActivoIndex = src.esActivoIndex;
            dst.codigoEstadoIndex = src.codigoEstadoIndex;
            dst.usuarioIngresoIndex = src.usuarioIngresoIndex;
            dst.tieneStockDisponibleIndex = src.tieneStockDisponibleIndex;
            dst.esPromocionIndex = src.esPromocionIndex;
            dst.costoUnitarioIndex = src.costoUnitarioIndex;
            dst.costoTotalIndex = src.costoTotalIndex;
            dst.costoPromedioIndex = src.costoPromedioIndex;
            dst.numeroVersionIndex = src.numeroVersionIndex;
            dst.esPromocionAutomaticaIndex = src.esPromocionAutomaticaIndex;
            dst.codigoReglaNegocioIndex = src.codigoReglaNegocioIndex;
            dst.lineaDetalleIndex = src.lineaDetalleIndex;
            dst.aplicaXRulesIndex = src.aplicaXRulesIndex;
            dst.porcentajeDescuentoXRulesIndex = src.porcentajeDescuentoXRulesIndex;
            dst.valorDescuentoXRulesIndex = src.valorDescuentoXRulesIndex;
            dst.porcentajeDescuentoManualIndex = src.porcentajeDescuentoManualIndex;
            dst.valorDescuentoManualIndex = src.valorDescuentoManualIndex;
            dst.cantidadEnCajasIndex = src.cantidadEnCajasIndex;
            dst.cantidadEnUnidadesIndex = src.cantidadEnUnidadesIndex;
            dst.productRelationIndex = src.productRelationIndex;
            dst.lstDafDetallesOrdenIndex = src.lstDafDetallesOrdenIndex;
            dst.providerIndex = src.providerIndex;
            dst.groupIndex = src.groupIndex;
            dst.subGroupIndex = src.subGroupIndex;
            dst.articleIndex = src.articleIndex;
        }
    }

    private ProductOrderColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.ProductOrder> proxyState;
    private RealmList<com.mobile.polux.models.ProductOrder> lstDafDetallesOrdenRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("codigoPrestacion");
        fieldNames.add("codigoExistencia");
        fieldNames.add("name");
        fieldNames.add("boxes");
        fieldNames.add("units");
        fieldNames.add("codigoSucursal");
        fieldNames.add("codigoServicio");
        fieldNames.add("cantidad");
        fieldNames.add("precioUnitarioVenta");
        fieldNames.add("subtotalVenta");
        fieldNames.add("porcentajeDescuento");
        fieldNames.add("valorDescuento");
        fieldNames.add("subtotalBaseImponible");
        fieldNames.add("aplicaIva");
        fieldNames.add("porcentajeIva");
        fieldNames.add("valorIva");
        fieldNames.add("valorTotal");
        fieldNames.add("esActivo");
        fieldNames.add("codigoEstado");
        fieldNames.add("usuarioIngreso");
        fieldNames.add("tieneStockDisponible");
        fieldNames.add("esPromocion");
        fieldNames.add("costoUnitario");
        fieldNames.add("costoTotal");
        fieldNames.add("costoPromedio");
        fieldNames.add("numeroVersion");
        fieldNames.add("esPromocionAutomatica");
        fieldNames.add("codigoReglaNegocio");
        fieldNames.add("lineaDetalle");
        fieldNames.add("aplicaXRules");
        fieldNames.add("porcentajeDescuentoXRules");
        fieldNames.add("valorDescuentoXRules");
        fieldNames.add("porcentajeDescuentoManual");
        fieldNames.add("valorDescuentoManual");
        fieldNames.add("cantidadEnCajas");
        fieldNames.add("cantidadEnUnidades");
        fieldNames.add("productRelation");
        fieldNames.add("lstDafDetallesOrden");
        fieldNames.add("provider");
        fieldNames.add("group");
        fieldNames.add("subGroup");
        fieldNames.add("article");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ProductOrderRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ProductOrderColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.ProductOrder>(this);
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
    public int realmGet$codigoPrestacion() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoPrestacionIndex);
    }

    @Override
    public void realmSet$codigoPrestacion(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.codigoPrestacionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.codigoPrestacionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$codigoExistencia() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoExistenciaIndex);
    }

    @Override
    public void realmSet$codigoExistencia(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.codigoExistenciaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
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
    public int realmGet$boxes() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.boxesIndex);
    }

    @Override
    public void realmSet$boxes(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.boxesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.boxesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$units() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.unitsIndex);
    }

    @Override
    public void realmSet$units(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.unitsIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.unitsIndex, value);
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
    public Integer realmGet$codigoServicio() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoServicioIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoServicioIndex);
    }

    @Override
    public void realmSet$codigoServicio(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoServicioIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoServicioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoServicioIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoServicioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$cantidad() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.cantidadIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.cantidadIndex);
    }

    @Override
    public void realmSet$cantidad(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cantidadIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.cantidadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cantidadIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.cantidadIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$precioUnitarioVenta() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.precioUnitarioVentaIndex);
    }

    @Override
    public void realmSet$precioUnitarioVenta(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.precioUnitarioVentaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.precioUnitarioVentaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$subtotalVenta() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.subtotalVentaIndex);
    }

    @Override
    public void realmSet$subtotalVenta(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.subtotalVentaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.subtotalVentaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$porcentajeDescuento() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.porcentajeDescuentoIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.porcentajeDescuentoIndex);
    }

    @Override
    public void realmSet$porcentajeDescuento(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.porcentajeDescuentoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.porcentajeDescuentoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.porcentajeDescuentoIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.porcentajeDescuentoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$valorDescuento() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.valorDescuentoIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.valorDescuentoIndex);
    }

    @Override
    public void realmSet$valorDescuento(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.valorDescuentoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.valorDescuentoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.valorDescuentoIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.valorDescuentoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$subtotalBaseImponible() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.subtotalBaseImponibleIndex);
    }

    @Override
    public void realmSet$subtotalBaseImponible(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.subtotalBaseImponibleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.subtotalBaseImponibleIndex, value);
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
    public double realmGet$porcentajeIva() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.porcentajeIvaIndex);
    }

    @Override
    public void realmSet$porcentajeIva(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.porcentajeIvaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.porcentajeIvaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$valorIva() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.valorIvaIndex);
    }

    @Override
    public void realmSet$valorIva(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.valorIvaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.valorIvaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$valorTotal() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.valorTotalIndex);
    }

    @Override
    public void realmSet$valorTotal(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.valorTotalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.valorTotalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$esActivo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.esActivoIndex);
    }

    @Override
    public void realmSet$esActivo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.esActivoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.esActivoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.esActivoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.esActivoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$codigoEstado() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.codigoEstadoIndex);
    }

    @Override
    public void realmSet$codigoEstado(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoEstadoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.codigoEstadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoEstadoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.codigoEstadoIndex, value);
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
    public String realmGet$tieneStockDisponible() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tieneStockDisponibleIndex);
    }

    @Override
    public void realmSet$tieneStockDisponible(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tieneStockDisponibleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tieneStockDisponibleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tieneStockDisponibleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tieneStockDisponibleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$esPromocion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.esPromocionIndex);
    }

    @Override
    public void realmSet$esPromocion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.esPromocionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.esPromocionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.esPromocionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.esPromocionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$costoUnitario() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.costoUnitarioIndex);
    }

    @Override
    public void realmSet$costoUnitario(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.costoUnitarioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.costoUnitarioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$costoTotal() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.costoTotalIndex);
    }

    @Override
    public void realmSet$costoTotal(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.costoTotalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.costoTotalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$costoPromedio() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.costoPromedioIndex);
    }

    @Override
    public void realmSet$costoPromedio(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.costoPromedioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.costoPromedioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$numeroVersion() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.numeroVersionIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.numeroVersionIndex);
    }

    @Override
    public void realmSet$numeroVersion(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.numeroVersionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.numeroVersionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.numeroVersionIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.numeroVersionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$esPromocionAutomatica() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.esPromocionAutomaticaIndex);
    }

    @Override
    public void realmSet$esPromocionAutomatica(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.esPromocionAutomaticaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.esPromocionAutomaticaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.esPromocionAutomaticaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.esPromocionAutomaticaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoReglaNegocio() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoReglaNegocioIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoReglaNegocioIndex);
    }

    @Override
    public void realmSet$codigoReglaNegocio(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoReglaNegocioIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoReglaNegocioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoReglaNegocioIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoReglaNegocioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$lineaDetalle() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.lineaDetalleIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.lineaDetalleIndex);
    }

    @Override
    public void realmSet$lineaDetalle(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.lineaDetalleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.lineaDetalleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.lineaDetalleIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.lineaDetalleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$aplicaXRules() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.aplicaXRulesIndex);
    }

    @Override
    public void realmSet$aplicaXRules(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.aplicaXRulesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.aplicaXRulesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.aplicaXRulesIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.aplicaXRulesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$porcentajeDescuentoXRules() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.porcentajeDescuentoXRulesIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.porcentajeDescuentoXRulesIndex);
    }

    @Override
    public void realmSet$porcentajeDescuentoXRules(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.porcentajeDescuentoXRulesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.porcentajeDescuentoXRulesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.porcentajeDescuentoXRulesIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.porcentajeDescuentoXRulesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$valorDescuentoXRules() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.valorDescuentoXRulesIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.valorDescuentoXRulesIndex);
    }

    @Override
    public void realmSet$valorDescuentoXRules(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.valorDescuentoXRulesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.valorDescuentoXRulesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.valorDescuentoXRulesIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.valorDescuentoXRulesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$porcentajeDescuentoManual() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.porcentajeDescuentoManualIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.porcentajeDescuentoManualIndex);
    }

    @Override
    public void realmSet$porcentajeDescuentoManual(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.porcentajeDescuentoManualIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.porcentajeDescuentoManualIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.porcentajeDescuentoManualIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.porcentajeDescuentoManualIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Double realmGet$valorDescuentoManual() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.valorDescuentoManualIndex)) {
            return null;
        }
        return (double) proxyState.getRow$realm().getDouble(columnInfo.valorDescuentoManualIndex);
    }

    @Override
    public void realmSet$valorDescuentoManual(Double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.valorDescuentoManualIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDouble(columnInfo.valorDescuentoManualIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.valorDescuentoManualIndex);
            return;
        }
        proxyState.getRow$realm().setDouble(columnInfo.valorDescuentoManualIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$cantidadEnCajas() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.cantidadEnCajasIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.cantidadEnCajasIndex);
    }

    @Override
    public void realmSet$cantidadEnCajas(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cantidadEnCajasIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.cantidadEnCajasIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cantidadEnCajasIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.cantidadEnCajasIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$cantidadEnUnidades() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.cantidadEnUnidadesIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.cantidadEnUnidadesIndex);
    }

    @Override
    public void realmSet$cantidadEnUnidades(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.cantidadEnUnidadesIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.cantidadEnUnidadesIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.cantidadEnUnidadesIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.cantidadEnUnidadesIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$productRelation() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.productRelationIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.productRelationIndex);
    }

    @Override
    public void realmSet$productRelation(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.productRelationIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.productRelationIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.productRelationIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.productRelationIndex, value);
    }

    @Override
    public RealmList<com.mobile.polux.models.ProductOrder> realmGet$lstDafDetallesOrden() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (lstDafDetallesOrdenRealmList != null) {
            return lstDafDetallesOrdenRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.lstDafDetallesOrdenIndex);
            lstDafDetallesOrdenRealmList = new RealmList<com.mobile.polux.models.ProductOrder>(com.mobile.polux.models.ProductOrder.class, linkView, proxyState.getRealm$realm());
            return lstDafDetallesOrdenRealmList;
        }
    }

    @Override
    public void realmSet$lstDafDetallesOrden(RealmList<com.mobile.polux.models.ProductOrder> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("lstDafDetallesOrden")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.mobile.polux.models.ProductOrder> original = value;
                value = new RealmList<com.mobile.polux.models.ProductOrder>();
                for (com.mobile.polux.models.ProductOrder item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.lstDafDetallesOrdenIndex);
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

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("ProductOrder")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("ProductOrder");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("codigoPrestacion", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("codigoExistencia", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("boxes", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("units", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("codigoSucursal", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoServicio", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("cantidad", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("precioUnitarioVenta", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("subtotalVenta", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("porcentajeDescuento", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("valorDescuento", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("subtotalBaseImponible", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("aplicaIva", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("porcentajeIva", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("valorIva", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("valorTotal", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("esActivo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoEstado", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("usuarioIngreso", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("tieneStockDisponible", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("esPromocion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("costoUnitario", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("costoTotal", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("costoPromedio", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("numeroVersion", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("esPromocionAutomatica", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoReglaNegocio", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("lineaDetalle", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("aplicaXRules", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("porcentajeDescuentoXRules", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("valorDescuentoXRules", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("porcentajeDescuentoManual", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("valorDescuentoManual", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("cantidadEnCajas", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("cantidadEnUnidades", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("productRelation", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("ProductOrder")) {
                ProductOrderRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("lstDafDetallesOrden", RealmFieldType.LIST, realmSchema.get("ProductOrder"));
            realmObjectSchema.add("provider", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("group", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("subGroup", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("article", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            return realmObjectSchema;
        }
        return realmSchema.get("ProductOrder");
    }

    public static ProductOrderColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_ProductOrder")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'ProductOrder' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_ProductOrder");
        final long columnCount = table.getColumnCount();
        if (columnCount != 43) {
            if (columnCount < 43) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 43 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 43 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 43 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final ProductOrderColumnInfo columnInfo = new ProductOrderColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("codigoPrestacion")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoPrestacion' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoPrestacion") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'codigoPrestacion' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.codigoPrestacionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'codigoPrestacion' does support null values in the existing Realm file. Use corresponding boxed type for field 'codigoPrestacion' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoExistencia")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoExistencia' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoExistencia") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'codigoExistencia' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.codigoExistenciaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'codigoExistencia' does support null values in the existing Realm file. Use corresponding boxed type for field 'codigoExistencia' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("boxes")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'boxes' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("boxes") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'boxes' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.boxesIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'boxes' does support null values in the existing Realm file. Use corresponding boxed type for field 'boxes' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("units")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'units' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("units") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'units' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.unitsIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'units' does support null values in the existing Realm file. Use corresponding boxed type for field 'units' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("codigoServicio")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoServicio' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoServicio") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoServicio' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoServicioIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoServicio' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoServicio' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("cantidad")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cantidad' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("cantidad") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'cantidad' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.cantidadIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'cantidad' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'cantidad' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("precioUnitarioVenta")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'precioUnitarioVenta' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("precioUnitarioVenta") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'precioUnitarioVenta' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.precioUnitarioVentaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'precioUnitarioVenta' does support null values in the existing Realm file. Use corresponding boxed type for field 'precioUnitarioVenta' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("subtotalVenta")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'subtotalVenta' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("subtotalVenta") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'subtotalVenta' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.subtotalVentaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'subtotalVenta' does support null values in the existing Realm file. Use corresponding boxed type for field 'subtotalVenta' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("porcentajeDescuento")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'porcentajeDescuento' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("porcentajeDescuento") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'porcentajeDescuento' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.porcentajeDescuentoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'porcentajeDescuento' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'porcentajeDescuento' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("valorDescuento")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'valorDescuento' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("valorDescuento") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'valorDescuento' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.valorDescuentoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'valorDescuento' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'valorDescuento' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("subtotalBaseImponible")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'subtotalBaseImponible' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("subtotalBaseImponible") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'subtotalBaseImponible' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.subtotalBaseImponibleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'subtotalBaseImponible' does support null values in the existing Realm file. Use corresponding boxed type for field 'subtotalBaseImponible' or migrate using RealmObjectSchema.setNullable().");
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
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'porcentajeIva' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.porcentajeIvaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'porcentajeIva' does support null values in the existing Realm file. Use corresponding boxed type for field 'porcentajeIva' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("valorIva")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'valorIva' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("valorIva") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'valorIva' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.valorIvaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'valorIva' does support null values in the existing Realm file. Use corresponding boxed type for field 'valorIva' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("valorTotal")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'valorTotal' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("valorTotal") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'valorTotal' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.valorTotalIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'valorTotal' does support null values in the existing Realm file. Use corresponding boxed type for field 'valorTotal' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("esActivo")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'esActivo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("esActivo") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'esActivo' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.esActivoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'esActivo' is required. Either set @Required to field 'esActivo' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoEstado")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoEstado' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoEstado") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'codigoEstado' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoEstadoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'codigoEstado' is required. Either set @Required to field 'codigoEstado' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("tieneStockDisponible")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'tieneStockDisponible' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("tieneStockDisponible") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'tieneStockDisponible' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.tieneStockDisponibleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'tieneStockDisponible' is required. Either set @Required to field 'tieneStockDisponible' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("esPromocion")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'esPromocion' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("esPromocion") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'esPromocion' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.esPromocionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'esPromocion' is required. Either set @Required to field 'esPromocion' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("costoUnitario")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'costoUnitario' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("costoUnitario") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'costoUnitario' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.costoUnitarioIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'costoUnitario' does support null values in the existing Realm file. Use corresponding boxed type for field 'costoUnitario' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("costoTotal")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'costoTotal' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("costoTotal") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'costoTotal' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.costoTotalIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'costoTotal' does support null values in the existing Realm file. Use corresponding boxed type for field 'costoTotal' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("costoPromedio")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'costoPromedio' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("costoPromedio") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'costoPromedio' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.costoPromedioIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'costoPromedio' does support null values in the existing Realm file. Use corresponding boxed type for field 'costoPromedio' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("numeroVersion")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numeroVersion' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("numeroVersion") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'numeroVersion' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.numeroVersionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'numeroVersion' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'numeroVersion' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("esPromocionAutomatica")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'esPromocionAutomatica' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("esPromocionAutomatica") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'esPromocionAutomatica' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.esPromocionAutomaticaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'esPromocionAutomatica' is required. Either set @Required to field 'esPromocionAutomatica' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoReglaNegocio")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoReglaNegocio' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoReglaNegocio") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoReglaNegocio' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoReglaNegocioIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoReglaNegocio' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoReglaNegocio' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("lineaDetalle")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'lineaDetalle' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("lineaDetalle") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'lineaDetalle' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.lineaDetalleIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'lineaDetalle' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'lineaDetalle' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("aplicaXRules")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aplicaXRules' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("aplicaXRules") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'aplicaXRules' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.aplicaXRulesIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aplicaXRules' is required. Either set @Required to field 'aplicaXRules' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("porcentajeDescuentoXRules")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'porcentajeDescuentoXRules' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("porcentajeDescuentoXRules") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'porcentajeDescuentoXRules' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.porcentajeDescuentoXRulesIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'porcentajeDescuentoXRules' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'porcentajeDescuentoXRules' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("valorDescuentoXRules")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'valorDescuentoXRules' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("valorDescuentoXRules") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'valorDescuentoXRules' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.valorDescuentoXRulesIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'valorDescuentoXRules' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'valorDescuentoXRules' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("porcentajeDescuentoManual")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'porcentajeDescuentoManual' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("porcentajeDescuentoManual") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'porcentajeDescuentoManual' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.porcentajeDescuentoManualIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'porcentajeDescuentoManual' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'porcentajeDescuentoManual' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("valorDescuentoManual")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'valorDescuentoManual' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("valorDescuentoManual") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Double' for field 'valorDescuentoManual' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.valorDescuentoManualIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'valorDescuentoManual' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'valorDescuentoManual' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("cantidadEnCajas")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cantidadEnCajas' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("cantidadEnCajas") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'cantidadEnCajas' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.cantidadEnCajasIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'cantidadEnCajas' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'cantidadEnCajas' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("cantidadEnUnidades")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cantidadEnUnidades' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("cantidadEnUnidades") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'cantidadEnUnidades' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.cantidadEnUnidadesIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'cantidadEnUnidades' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'cantidadEnUnidades' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("productRelation")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'productRelation' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("productRelation") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'productRelation' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.productRelationIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'productRelation' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'productRelation' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("lstDafDetallesOrden")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'lstDafDetallesOrden'");
        }
        if (columnTypes.get("lstDafDetallesOrden") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'ProductOrder' for field 'lstDafDetallesOrden'");
        }
        if (!sharedRealm.hasTable("class_ProductOrder")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_ProductOrder' for field 'lstDafDetallesOrden'");
        }
        Table table_38 = sharedRealm.getTable("class_ProductOrder");
        if (!table.getLinkTarget(columnInfo.lstDafDetallesOrdenIndex).hasSameSchema(table_38)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'lstDafDetallesOrden': '" + table.getLinkTarget(columnInfo.lstDafDetallesOrdenIndex).getName() + "' expected - was '" + table_38.getName() + "'");
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
        if (!columnTypes.containsKey("group")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'group' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("group") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'group' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.groupIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'group' does support null values in the existing Realm file. Use corresponding boxed type for field 'group' or migrate using RealmObjectSchema.setNullable().");
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

        return columnInfo;
    }

    public static String getTableName() {
        return "class_ProductOrder";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.ProductOrder createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("lstDafDetallesOrden")) {
            excludeFields.add("lstDafDetallesOrden");
        }
        com.mobile.polux.models.ProductOrder obj = realm.createObjectInternal(com.mobile.polux.models.ProductOrder.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$id((int) json.getInt("id"));
            }
        }
        if (json.has("codigoPrestacion")) {
            if (json.isNull("codigoPrestacion")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'codigoPrestacion' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$codigoPrestacion((int) json.getInt("codigoPrestacion"));
            }
        }
        if (json.has("codigoExistencia")) {
            if (json.isNull("codigoExistencia")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'codigoExistencia' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$codigoExistencia((int) json.getInt("codigoExistencia"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("boxes")) {
            if (json.isNull("boxes")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'boxes' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$boxes((int) json.getInt("boxes"));
            }
        }
        if (json.has("units")) {
            if (json.isNull("units")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'units' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$units((int) json.getInt("units"));
            }
        }
        if (json.has("codigoSucursal")) {
            if (json.isNull("codigoSucursal")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$codigoSucursal(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$codigoSucursal((int) json.getInt("codigoSucursal"));
            }
        }
        if (json.has("codigoServicio")) {
            if (json.isNull("codigoServicio")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$codigoServicio(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$codigoServicio((int) json.getInt("codigoServicio"));
            }
        }
        if (json.has("cantidad")) {
            if (json.isNull("cantidad")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$cantidad(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$cantidad((int) json.getInt("cantidad"));
            }
        }
        if (json.has("precioUnitarioVenta")) {
            if (json.isNull("precioUnitarioVenta")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'precioUnitarioVenta' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$precioUnitarioVenta((double) json.getDouble("precioUnitarioVenta"));
            }
        }
        if (json.has("subtotalVenta")) {
            if (json.isNull("subtotalVenta")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'subtotalVenta' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$subtotalVenta((double) json.getDouble("subtotalVenta"));
            }
        }
        if (json.has("porcentajeDescuento")) {
            if (json.isNull("porcentajeDescuento")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuento(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuento((double) json.getDouble("porcentajeDescuento"));
            }
        }
        if (json.has("valorDescuento")) {
            if (json.isNull("valorDescuento")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuento(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuento((double) json.getDouble("valorDescuento"));
            }
        }
        if (json.has("subtotalBaseImponible")) {
            if (json.isNull("subtotalBaseImponible")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'subtotalBaseImponible' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$subtotalBaseImponible((double) json.getDouble("subtotalBaseImponible"));
            }
        }
        if (json.has("aplicaIva")) {
            if (json.isNull("aplicaIva")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$aplicaIva(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$aplicaIva((String) json.getString("aplicaIva"));
            }
        }
        if (json.has("porcentajeIva")) {
            if (json.isNull("porcentajeIva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'porcentajeIva' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeIva((double) json.getDouble("porcentajeIva"));
            }
        }
        if (json.has("valorIva")) {
            if (json.isNull("valorIva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'valorIva' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$valorIva((double) json.getDouble("valorIva"));
            }
        }
        if (json.has("valorTotal")) {
            if (json.isNull("valorTotal")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'valorTotal' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$valorTotal((double) json.getDouble("valorTotal"));
            }
        }
        if (json.has("esActivo")) {
            if (json.isNull("esActivo")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$esActivo(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$esActivo((String) json.getString("esActivo"));
            }
        }
        if (json.has("codigoEstado")) {
            if (json.isNull("codigoEstado")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$codigoEstado(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$codigoEstado((String) json.getString("codigoEstado"));
            }
        }
        if (json.has("usuarioIngreso")) {
            if (json.isNull("usuarioIngreso")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$usuarioIngreso(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$usuarioIngreso((String) json.getString("usuarioIngreso"));
            }
        }
        if (json.has("tieneStockDisponible")) {
            if (json.isNull("tieneStockDisponible")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$tieneStockDisponible(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$tieneStockDisponible((String) json.getString("tieneStockDisponible"));
            }
        }
        if (json.has("esPromocion")) {
            if (json.isNull("esPromocion")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$esPromocion(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$esPromocion((String) json.getString("esPromocion"));
            }
        }
        if (json.has("costoUnitario")) {
            if (json.isNull("costoUnitario")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'costoUnitario' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$costoUnitario((double) json.getDouble("costoUnitario"));
            }
        }
        if (json.has("costoTotal")) {
            if (json.isNull("costoTotal")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'costoTotal' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$costoTotal((double) json.getDouble("costoTotal"));
            }
        }
        if (json.has("costoPromedio")) {
            if (json.isNull("costoPromedio")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'costoPromedio' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$costoPromedio((double) json.getDouble("costoPromedio"));
            }
        }
        if (json.has("numeroVersion")) {
            if (json.isNull("numeroVersion")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$numeroVersion(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$numeroVersion((int) json.getInt("numeroVersion"));
            }
        }
        if (json.has("esPromocionAutomatica")) {
            if (json.isNull("esPromocionAutomatica")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$esPromocionAutomatica(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$esPromocionAutomatica((String) json.getString("esPromocionAutomatica"));
            }
        }
        if (json.has("codigoReglaNegocio")) {
            if (json.isNull("codigoReglaNegocio")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$codigoReglaNegocio(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$codigoReglaNegocio((int) json.getInt("codigoReglaNegocio"));
            }
        }
        if (json.has("lineaDetalle")) {
            if (json.isNull("lineaDetalle")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$lineaDetalle(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$lineaDetalle((int) json.getInt("lineaDetalle"));
            }
        }
        if (json.has("aplicaXRules")) {
            if (json.isNull("aplicaXRules")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$aplicaXRules(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$aplicaXRules((String) json.getString("aplicaXRules"));
            }
        }
        if (json.has("porcentajeDescuentoXRules")) {
            if (json.isNull("porcentajeDescuentoXRules")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuentoXRules(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuentoXRules((double) json.getDouble("porcentajeDescuentoXRules"));
            }
        }
        if (json.has("valorDescuentoXRules")) {
            if (json.isNull("valorDescuentoXRules")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuentoXRules(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuentoXRules((double) json.getDouble("valorDescuentoXRules"));
            }
        }
        if (json.has("porcentajeDescuentoManual")) {
            if (json.isNull("porcentajeDescuentoManual")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuentoManual(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuentoManual((double) json.getDouble("porcentajeDescuentoManual"));
            }
        }
        if (json.has("valorDescuentoManual")) {
            if (json.isNull("valorDescuentoManual")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuentoManual(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuentoManual((double) json.getDouble("valorDescuentoManual"));
            }
        }
        if (json.has("cantidadEnCajas")) {
            if (json.isNull("cantidadEnCajas")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$cantidadEnCajas(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$cantidadEnCajas((int) json.getInt("cantidadEnCajas"));
            }
        }
        if (json.has("cantidadEnUnidades")) {
            if (json.isNull("cantidadEnUnidades")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$cantidadEnUnidades(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$cantidadEnUnidades((int) json.getInt("cantidadEnUnidades"));
            }
        }
        if (json.has("productRelation")) {
            if (json.isNull("productRelation")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$productRelation(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$productRelation((int) json.getInt("productRelation"));
            }
        }
        if (json.has("lstDafDetallesOrden")) {
            if (json.isNull("lstDafDetallesOrden")) {
                ((ProductOrderRealmProxyInterface) obj).realmSet$lstDafDetallesOrden(null);
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmGet$lstDafDetallesOrden().clear();
                JSONArray array = json.getJSONArray("lstDafDetallesOrden");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.ProductOrder item = ProductOrderRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((ProductOrderRealmProxyInterface) obj).realmGet$lstDafDetallesOrden().add(item);
                }
            }
        }
        if (json.has("provider")) {
            if (json.isNull("provider")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'provider' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$provider((int) json.getInt("provider"));
            }
        }
        if (json.has("group")) {
            if (json.isNull("group")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'group' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$group((int) json.getInt("group"));
            }
        }
        if (json.has("subGroup")) {
            if (json.isNull("subGroup")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'subGroup' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$subGroup((int) json.getInt("subGroup"));
            }
        }
        if (json.has("article")) {
            if (json.isNull("article")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'article' to null.");
            } else {
                ((ProductOrderRealmProxyInterface) obj).realmSet$article((int) json.getInt("article"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.ProductOrder createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.mobile.polux.models.ProductOrder obj = new com.mobile.polux.models.ProductOrder();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
            } else if (name.equals("codigoPrestacion")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'codigoPrestacion' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$codigoPrestacion((int) reader.nextInt());
                }
            } else if (name.equals("codigoExistencia")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'codigoExistencia' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$codigoExistencia((int) reader.nextInt());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("boxes")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'boxes' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$boxes((int) reader.nextInt());
                }
            } else if (name.equals("units")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'units' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$units((int) reader.nextInt());
                }
            } else if (name.equals("codigoSucursal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$codigoSucursal(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$codigoSucursal((int) reader.nextInt());
                }
            } else if (name.equals("codigoServicio")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$codigoServicio(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$codigoServicio((int) reader.nextInt());
                }
            } else if (name.equals("cantidad")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$cantidad(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$cantidad((int) reader.nextInt());
                }
            } else if (name.equals("precioUnitarioVenta")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'precioUnitarioVenta' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$precioUnitarioVenta((double) reader.nextDouble());
                }
            } else if (name.equals("subtotalVenta")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'subtotalVenta' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$subtotalVenta((double) reader.nextDouble());
                }
            } else if (name.equals("porcentajeDescuento")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuento(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuento((double) reader.nextDouble());
                }
            } else if (name.equals("valorDescuento")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuento(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuento((double) reader.nextDouble());
                }
            } else if (name.equals("subtotalBaseImponible")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'subtotalBaseImponible' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$subtotalBaseImponible((double) reader.nextDouble());
                }
            } else if (name.equals("aplicaIva")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$aplicaIva(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$aplicaIva((String) reader.nextString());
                }
            } else if (name.equals("porcentajeIva")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'porcentajeIva' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeIva((double) reader.nextDouble());
                }
            } else if (name.equals("valorIva")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'valorIva' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$valorIva((double) reader.nextDouble());
                }
            } else if (name.equals("valorTotal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'valorTotal' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$valorTotal((double) reader.nextDouble());
                }
            } else if (name.equals("esActivo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$esActivo(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$esActivo((String) reader.nextString());
                }
            } else if (name.equals("codigoEstado")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$codigoEstado(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$codigoEstado((String) reader.nextString());
                }
            } else if (name.equals("usuarioIngreso")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$usuarioIngreso(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$usuarioIngreso((String) reader.nextString());
                }
            } else if (name.equals("tieneStockDisponible")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$tieneStockDisponible(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$tieneStockDisponible((String) reader.nextString());
                }
            } else if (name.equals("esPromocion")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$esPromocion(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$esPromocion((String) reader.nextString());
                }
            } else if (name.equals("costoUnitario")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'costoUnitario' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$costoUnitario((double) reader.nextDouble());
                }
            } else if (name.equals("costoTotal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'costoTotal' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$costoTotal((double) reader.nextDouble());
                }
            } else if (name.equals("costoPromedio")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'costoPromedio' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$costoPromedio((double) reader.nextDouble());
                }
            } else if (name.equals("numeroVersion")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$numeroVersion(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$numeroVersion((int) reader.nextInt());
                }
            } else if (name.equals("esPromocionAutomatica")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$esPromocionAutomatica(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$esPromocionAutomatica((String) reader.nextString());
                }
            } else if (name.equals("codigoReglaNegocio")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$codigoReglaNegocio(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$codigoReglaNegocio((int) reader.nextInt());
                }
            } else if (name.equals("lineaDetalle")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$lineaDetalle(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$lineaDetalle((int) reader.nextInt());
                }
            } else if (name.equals("aplicaXRules")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$aplicaXRules(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$aplicaXRules((String) reader.nextString());
                }
            } else if (name.equals("porcentajeDescuentoXRules")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuentoXRules(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuentoXRules((double) reader.nextDouble());
                }
            } else if (name.equals("valorDescuentoXRules")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuentoXRules(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuentoXRules((double) reader.nextDouble());
                }
            } else if (name.equals("porcentajeDescuentoManual")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuentoManual(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$porcentajeDescuentoManual((double) reader.nextDouble());
                }
            } else if (name.equals("valorDescuentoManual")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuentoManual(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$valorDescuentoManual((double) reader.nextDouble());
                }
            } else if (name.equals("cantidadEnCajas")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$cantidadEnCajas(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$cantidadEnCajas((int) reader.nextInt());
                }
            } else if (name.equals("cantidadEnUnidades")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$cantidadEnUnidades(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$cantidadEnUnidades((int) reader.nextInt());
                }
            } else if (name.equals("productRelation")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$productRelation(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$productRelation((int) reader.nextInt());
                }
            } else if (name.equals("lstDafDetallesOrden")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((ProductOrderRealmProxyInterface) obj).realmSet$lstDafDetallesOrden(null);
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$lstDafDetallesOrden(new RealmList<com.mobile.polux.models.ProductOrder>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.ProductOrder item = ProductOrderRealmProxy.createUsingJsonStream(realm, reader);
                        ((ProductOrderRealmProxyInterface) obj).realmGet$lstDafDetallesOrden().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("provider")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'provider' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$provider((int) reader.nextInt());
                }
            } else if (name.equals("group")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'group' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$group((int) reader.nextInt());
                }
            } else if (name.equals("subGroup")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'subGroup' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$subGroup((int) reader.nextInt());
                }
            } else if (name.equals("article")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'article' to null.");
                } else {
                    ((ProductOrderRealmProxyInterface) obj).realmSet$article((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.mobile.polux.models.ProductOrder copyOrUpdate(Realm realm, com.mobile.polux.models.ProductOrder object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.ProductOrder) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.mobile.polux.models.ProductOrder copy(Realm realm, com.mobile.polux.models.ProductOrder newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.ProductOrder) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.ProductOrder realmObject = realm.createObjectInternal(com.mobile.polux.models.ProductOrder.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$id(((ProductOrderRealmProxyInterface) newObject).realmGet$id());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$codigoPrestacion(((ProductOrderRealmProxyInterface) newObject).realmGet$codigoPrestacion());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$codigoExistencia(((ProductOrderRealmProxyInterface) newObject).realmGet$codigoExistencia());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$name(((ProductOrderRealmProxyInterface) newObject).realmGet$name());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$boxes(((ProductOrderRealmProxyInterface) newObject).realmGet$boxes());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$units(((ProductOrderRealmProxyInterface) newObject).realmGet$units());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$codigoSucursal(((ProductOrderRealmProxyInterface) newObject).realmGet$codigoSucursal());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$codigoServicio(((ProductOrderRealmProxyInterface) newObject).realmGet$codigoServicio());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$cantidad(((ProductOrderRealmProxyInterface) newObject).realmGet$cantidad());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$precioUnitarioVenta(((ProductOrderRealmProxyInterface) newObject).realmGet$precioUnitarioVenta());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$subtotalVenta(((ProductOrderRealmProxyInterface) newObject).realmGet$subtotalVenta());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$porcentajeDescuento(((ProductOrderRealmProxyInterface) newObject).realmGet$porcentajeDescuento());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$valorDescuento(((ProductOrderRealmProxyInterface) newObject).realmGet$valorDescuento());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$subtotalBaseImponible(((ProductOrderRealmProxyInterface) newObject).realmGet$subtotalBaseImponible());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$aplicaIva(((ProductOrderRealmProxyInterface) newObject).realmGet$aplicaIva());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$porcentajeIva(((ProductOrderRealmProxyInterface) newObject).realmGet$porcentajeIva());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$valorIva(((ProductOrderRealmProxyInterface) newObject).realmGet$valorIva());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$valorTotal(((ProductOrderRealmProxyInterface) newObject).realmGet$valorTotal());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$esActivo(((ProductOrderRealmProxyInterface) newObject).realmGet$esActivo());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$codigoEstado(((ProductOrderRealmProxyInterface) newObject).realmGet$codigoEstado());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$usuarioIngreso(((ProductOrderRealmProxyInterface) newObject).realmGet$usuarioIngreso());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$tieneStockDisponible(((ProductOrderRealmProxyInterface) newObject).realmGet$tieneStockDisponible());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$esPromocion(((ProductOrderRealmProxyInterface) newObject).realmGet$esPromocion());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$costoUnitario(((ProductOrderRealmProxyInterface) newObject).realmGet$costoUnitario());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$costoTotal(((ProductOrderRealmProxyInterface) newObject).realmGet$costoTotal());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$costoPromedio(((ProductOrderRealmProxyInterface) newObject).realmGet$costoPromedio());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$numeroVersion(((ProductOrderRealmProxyInterface) newObject).realmGet$numeroVersion());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$esPromocionAutomatica(((ProductOrderRealmProxyInterface) newObject).realmGet$esPromocionAutomatica());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$codigoReglaNegocio(((ProductOrderRealmProxyInterface) newObject).realmGet$codigoReglaNegocio());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$lineaDetalle(((ProductOrderRealmProxyInterface) newObject).realmGet$lineaDetalle());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$aplicaXRules(((ProductOrderRealmProxyInterface) newObject).realmGet$aplicaXRules());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$porcentajeDescuentoXRules(((ProductOrderRealmProxyInterface) newObject).realmGet$porcentajeDescuentoXRules());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$valorDescuentoXRules(((ProductOrderRealmProxyInterface) newObject).realmGet$valorDescuentoXRules());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$porcentajeDescuentoManual(((ProductOrderRealmProxyInterface) newObject).realmGet$porcentajeDescuentoManual());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$valorDescuentoManual(((ProductOrderRealmProxyInterface) newObject).realmGet$valorDescuentoManual());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$cantidadEnCajas(((ProductOrderRealmProxyInterface) newObject).realmGet$cantidadEnCajas());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$cantidadEnUnidades(((ProductOrderRealmProxyInterface) newObject).realmGet$cantidadEnUnidades());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$productRelation(((ProductOrderRealmProxyInterface) newObject).realmGet$productRelation());

            RealmList<com.mobile.polux.models.ProductOrder> lstDafDetallesOrdenList = ((ProductOrderRealmProxyInterface) newObject).realmGet$lstDafDetallesOrden();
            if (lstDafDetallesOrdenList != null) {
                RealmList<com.mobile.polux.models.ProductOrder> lstDafDetallesOrdenRealmList = ((ProductOrderRealmProxyInterface) realmObject).realmGet$lstDafDetallesOrden();
                for (int i = 0; i < lstDafDetallesOrdenList.size(); i++) {
                    com.mobile.polux.models.ProductOrder lstDafDetallesOrdenItem = lstDafDetallesOrdenList.get(i);
                    com.mobile.polux.models.ProductOrder cachelstDafDetallesOrden = (com.mobile.polux.models.ProductOrder) cache.get(lstDafDetallesOrdenItem);
                    if (cachelstDafDetallesOrden != null) {
                        lstDafDetallesOrdenRealmList.add(cachelstDafDetallesOrden);
                    } else {
                        lstDafDetallesOrdenRealmList.add(ProductOrderRealmProxy.copyOrUpdate(realm, lstDafDetallesOrdenList.get(i), update, cache));
                    }
                }
            }

            ((ProductOrderRealmProxyInterface) realmObject).realmSet$provider(((ProductOrderRealmProxyInterface) newObject).realmGet$provider());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$group(((ProductOrderRealmProxyInterface) newObject).realmGet$group());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$subGroup(((ProductOrderRealmProxyInterface) newObject).realmGet$subGroup());
            ((ProductOrderRealmProxyInterface) realmObject).realmSet$article(((ProductOrderRealmProxyInterface) newObject).realmGet$article());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.ProductOrder object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.ProductOrder.class);
        long tableNativePtr = table.getNativePtr();
        ProductOrderColumnInfo columnInfo = (ProductOrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductOrder.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.codigoPrestacionIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$codigoPrestacion(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$codigoExistencia(), false);
        String realmGet$name = ((ProductOrderRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.boxesIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$boxes(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.unitsIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$units(), false);
        Number realmGet$codigoSucursal = ((ProductOrderRealmProxyInterface)object).realmGet$codigoSucursal();
        if (realmGet$codigoSucursal != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
        }
        Number realmGet$codigoServicio = ((ProductOrderRealmProxyInterface)object).realmGet$codigoServicio();
        if (realmGet$codigoServicio != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoServicioIndex, rowIndex, realmGet$codigoServicio.longValue(), false);
        }
        Number realmGet$cantidad = ((ProductOrderRealmProxyInterface)object).realmGet$cantidad();
        if (realmGet$cantidad != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, realmGet$cantidad.longValue(), false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.precioUnitarioVentaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$precioUnitarioVenta(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalVentaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subtotalVenta(), false);
        Double realmGet$porcentajeDescuento = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuento();
        if (realmGet$porcentajeDescuento != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoIndex, rowIndex, realmGet$porcentajeDescuento, false);
        }
        Double realmGet$valorDescuento = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuento();
        if (realmGet$valorDescuento != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoIndex, rowIndex, realmGet$valorDescuento, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalBaseImponibleIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subtotalBaseImponible(), false);
        String realmGet$aplicaIva = ((ProductOrderRealmProxyInterface)object).realmGet$aplicaIva();
        if (realmGet$aplicaIva != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, realmGet$aplicaIva, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeIvaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeIva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.valorIvaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$valorIva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.valorTotalIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$valorTotal(), false);
        String realmGet$esActivo = ((ProductOrderRealmProxyInterface)object).realmGet$esActivo();
        if (realmGet$esActivo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esActivoIndex, rowIndex, realmGet$esActivo, false);
        }
        String realmGet$codigoEstado = ((ProductOrderRealmProxyInterface)object).realmGet$codigoEstado();
        if (realmGet$codigoEstado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, realmGet$codigoEstado, false);
        }
        String realmGet$usuarioIngreso = ((ProductOrderRealmProxyInterface)object).realmGet$usuarioIngreso();
        if (realmGet$usuarioIngreso != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
        }
        String realmGet$tieneStockDisponible = ((ProductOrderRealmProxyInterface)object).realmGet$tieneStockDisponible();
        if (realmGet$tieneStockDisponible != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tieneStockDisponibleIndex, rowIndex, realmGet$tieneStockDisponible, false);
        }
        String realmGet$esPromocion = ((ProductOrderRealmProxyInterface)object).realmGet$esPromocion();
        if (realmGet$esPromocion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esPromocionIndex, rowIndex, realmGet$esPromocion, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.costoUnitarioIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoUnitario(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.costoTotalIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoTotal(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.costoPromedioIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoPromedio(), false);
        Number realmGet$numeroVersion = ((ProductOrderRealmProxyInterface)object).realmGet$numeroVersion();
        if (realmGet$numeroVersion != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.numeroVersionIndex, rowIndex, realmGet$numeroVersion.longValue(), false);
        }
        String realmGet$esPromocionAutomatica = ((ProductOrderRealmProxyInterface)object).realmGet$esPromocionAutomatica();
        if (realmGet$esPromocionAutomatica != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esPromocionAutomaticaIndex, rowIndex, realmGet$esPromocionAutomatica, false);
        }
        Number realmGet$codigoReglaNegocio = ((ProductOrderRealmProxyInterface)object).realmGet$codigoReglaNegocio();
        if (realmGet$codigoReglaNegocio != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoReglaNegocioIndex, rowIndex, realmGet$codigoReglaNegocio.longValue(), false);
        }
        Number realmGet$lineaDetalle = ((ProductOrderRealmProxyInterface)object).realmGet$lineaDetalle();
        if (realmGet$lineaDetalle != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.lineaDetalleIndex, rowIndex, realmGet$lineaDetalle.longValue(), false);
        }
        String realmGet$aplicaXRules = ((ProductOrderRealmProxyInterface)object).realmGet$aplicaXRules();
        if (realmGet$aplicaXRules != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaXRulesIndex, rowIndex, realmGet$aplicaXRules, false);
        }
        Double realmGet$porcentajeDescuentoXRules = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuentoXRules();
        if (realmGet$porcentajeDescuentoXRules != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoXRulesIndex, rowIndex, realmGet$porcentajeDescuentoXRules, false);
        }
        Double realmGet$valorDescuentoXRules = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuentoXRules();
        if (realmGet$valorDescuentoXRules != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoXRulesIndex, rowIndex, realmGet$valorDescuentoXRules, false);
        }
        Double realmGet$porcentajeDescuentoManual = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuentoManual();
        if (realmGet$porcentajeDescuentoManual != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoManualIndex, rowIndex, realmGet$porcentajeDescuentoManual, false);
        }
        Double realmGet$valorDescuentoManual = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuentoManual();
        if (realmGet$valorDescuentoManual != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoManualIndex, rowIndex, realmGet$valorDescuentoManual, false);
        }
        Number realmGet$cantidadEnCajas = ((ProductOrderRealmProxyInterface)object).realmGet$cantidadEnCajas();
        if (realmGet$cantidadEnCajas != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantidadEnCajasIndex, rowIndex, realmGet$cantidadEnCajas.longValue(), false);
        }
        Number realmGet$cantidadEnUnidades = ((ProductOrderRealmProxyInterface)object).realmGet$cantidadEnUnidades();
        if (realmGet$cantidadEnUnidades != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantidadEnUnidadesIndex, rowIndex, realmGet$cantidadEnUnidades.longValue(), false);
        }
        Number realmGet$productRelation = ((ProductOrderRealmProxyInterface)object).realmGet$productRelation();
        if (realmGet$productRelation != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.productRelationIndex, rowIndex, realmGet$productRelation.longValue(), false);
        }

        RealmList<com.mobile.polux.models.ProductOrder> lstDafDetallesOrdenList = ((ProductOrderRealmProxyInterface) object).realmGet$lstDafDetallesOrden();
        if (lstDafDetallesOrdenList != null) {
            long lstDafDetallesOrdenNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.lstDafDetallesOrdenIndex, rowIndex);
            for (com.mobile.polux.models.ProductOrder lstDafDetallesOrdenItem : lstDafDetallesOrdenList) {
                Long cacheItemIndexlstDafDetallesOrden = cache.get(lstDafDetallesOrdenItem);
                if (cacheItemIndexlstDafDetallesOrden == null) {
                    cacheItemIndexlstDafDetallesOrden = ProductOrderRealmProxy.insert(realm, lstDafDetallesOrdenItem, cache);
                }
                LinkView.nativeAdd(lstDafDetallesOrdenNativeLinkViewPtr, cacheItemIndexlstDafDetallesOrden);
            }
        }

        Table.nativeSetLong(tableNativePtr, columnInfo.providerIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$provider(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.groupIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$group(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.subGroupIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subGroup(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.articleIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$article(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.ProductOrder.class);
        long tableNativePtr = table.getNativePtr();
        ProductOrderColumnInfo columnInfo = (ProductOrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductOrder.class);
        com.mobile.polux.models.ProductOrder object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.ProductOrder) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$id(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.codigoPrestacionIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$codigoPrestacion(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$codigoExistencia(), false);
                String realmGet$name = ((ProductOrderRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.boxesIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$boxes(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.unitsIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$units(), false);
                Number realmGet$codigoSucursal = ((ProductOrderRealmProxyInterface)object).realmGet$codigoSucursal();
                if (realmGet$codigoSucursal != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
                }
                Number realmGet$codigoServicio = ((ProductOrderRealmProxyInterface)object).realmGet$codigoServicio();
                if (realmGet$codigoServicio != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoServicioIndex, rowIndex, realmGet$codigoServicio.longValue(), false);
                }
                Number realmGet$cantidad = ((ProductOrderRealmProxyInterface)object).realmGet$cantidad();
                if (realmGet$cantidad != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, realmGet$cantidad.longValue(), false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.precioUnitarioVentaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$precioUnitarioVenta(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalVentaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subtotalVenta(), false);
                Double realmGet$porcentajeDescuento = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuento();
                if (realmGet$porcentajeDescuento != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoIndex, rowIndex, realmGet$porcentajeDescuento, false);
                }
                Double realmGet$valorDescuento = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuento();
                if (realmGet$valorDescuento != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoIndex, rowIndex, realmGet$valorDescuento, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalBaseImponibleIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subtotalBaseImponible(), false);
                String realmGet$aplicaIva = ((ProductOrderRealmProxyInterface)object).realmGet$aplicaIva();
                if (realmGet$aplicaIva != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, realmGet$aplicaIva, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeIvaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeIva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.valorIvaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$valorIva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.valorTotalIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$valorTotal(), false);
                String realmGet$esActivo = ((ProductOrderRealmProxyInterface)object).realmGet$esActivo();
                if (realmGet$esActivo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esActivoIndex, rowIndex, realmGet$esActivo, false);
                }
                String realmGet$codigoEstado = ((ProductOrderRealmProxyInterface)object).realmGet$codigoEstado();
                if (realmGet$codigoEstado != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, realmGet$codigoEstado, false);
                }
                String realmGet$usuarioIngreso = ((ProductOrderRealmProxyInterface)object).realmGet$usuarioIngreso();
                if (realmGet$usuarioIngreso != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
                }
                String realmGet$tieneStockDisponible = ((ProductOrderRealmProxyInterface)object).realmGet$tieneStockDisponible();
                if (realmGet$tieneStockDisponible != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.tieneStockDisponibleIndex, rowIndex, realmGet$tieneStockDisponible, false);
                }
                String realmGet$esPromocion = ((ProductOrderRealmProxyInterface)object).realmGet$esPromocion();
                if (realmGet$esPromocion != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esPromocionIndex, rowIndex, realmGet$esPromocion, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.costoUnitarioIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoUnitario(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.costoTotalIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoTotal(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.costoPromedioIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoPromedio(), false);
                Number realmGet$numeroVersion = ((ProductOrderRealmProxyInterface)object).realmGet$numeroVersion();
                if (realmGet$numeroVersion != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.numeroVersionIndex, rowIndex, realmGet$numeroVersion.longValue(), false);
                }
                String realmGet$esPromocionAutomatica = ((ProductOrderRealmProxyInterface)object).realmGet$esPromocionAutomatica();
                if (realmGet$esPromocionAutomatica != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esPromocionAutomaticaIndex, rowIndex, realmGet$esPromocionAutomatica, false);
                }
                Number realmGet$codigoReglaNegocio = ((ProductOrderRealmProxyInterface)object).realmGet$codigoReglaNegocio();
                if (realmGet$codigoReglaNegocio != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoReglaNegocioIndex, rowIndex, realmGet$codigoReglaNegocio.longValue(), false);
                }
                Number realmGet$lineaDetalle = ((ProductOrderRealmProxyInterface)object).realmGet$lineaDetalle();
                if (realmGet$lineaDetalle != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.lineaDetalleIndex, rowIndex, realmGet$lineaDetalle.longValue(), false);
                }
                String realmGet$aplicaXRules = ((ProductOrderRealmProxyInterface)object).realmGet$aplicaXRules();
                if (realmGet$aplicaXRules != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaXRulesIndex, rowIndex, realmGet$aplicaXRules, false);
                }
                Double realmGet$porcentajeDescuentoXRules = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuentoXRules();
                if (realmGet$porcentajeDescuentoXRules != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoXRulesIndex, rowIndex, realmGet$porcentajeDescuentoXRules, false);
                }
                Double realmGet$valorDescuentoXRules = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuentoXRules();
                if (realmGet$valorDescuentoXRules != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoXRulesIndex, rowIndex, realmGet$valorDescuentoXRules, false);
                }
                Double realmGet$porcentajeDescuentoManual = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuentoManual();
                if (realmGet$porcentajeDescuentoManual != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoManualIndex, rowIndex, realmGet$porcentajeDescuentoManual, false);
                }
                Double realmGet$valorDescuentoManual = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuentoManual();
                if (realmGet$valorDescuentoManual != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoManualIndex, rowIndex, realmGet$valorDescuentoManual, false);
                }
                Number realmGet$cantidadEnCajas = ((ProductOrderRealmProxyInterface)object).realmGet$cantidadEnCajas();
                if (realmGet$cantidadEnCajas != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantidadEnCajasIndex, rowIndex, realmGet$cantidadEnCajas.longValue(), false);
                }
                Number realmGet$cantidadEnUnidades = ((ProductOrderRealmProxyInterface)object).realmGet$cantidadEnUnidades();
                if (realmGet$cantidadEnUnidades != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantidadEnUnidadesIndex, rowIndex, realmGet$cantidadEnUnidades.longValue(), false);
                }
                Number realmGet$productRelation = ((ProductOrderRealmProxyInterface)object).realmGet$productRelation();
                if (realmGet$productRelation != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.productRelationIndex, rowIndex, realmGet$productRelation.longValue(), false);
                }

                RealmList<com.mobile.polux.models.ProductOrder> lstDafDetallesOrdenList = ((ProductOrderRealmProxyInterface) object).realmGet$lstDafDetallesOrden();
                if (lstDafDetallesOrdenList != null) {
                    long lstDafDetallesOrdenNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.lstDafDetallesOrdenIndex, rowIndex);
                    for (com.mobile.polux.models.ProductOrder lstDafDetallesOrdenItem : lstDafDetallesOrdenList) {
                        Long cacheItemIndexlstDafDetallesOrden = cache.get(lstDafDetallesOrdenItem);
                        if (cacheItemIndexlstDafDetallesOrden == null) {
                            cacheItemIndexlstDafDetallesOrden = ProductOrderRealmProxy.insert(realm, lstDafDetallesOrdenItem, cache);
                        }
                        LinkView.nativeAdd(lstDafDetallesOrdenNativeLinkViewPtr, cacheItemIndexlstDafDetallesOrden);
                    }
                }

                Table.nativeSetLong(tableNativePtr, columnInfo.providerIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$provider(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.groupIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$group(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.subGroupIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subGroup(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.articleIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$article(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.ProductOrder object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.ProductOrder.class);
        long tableNativePtr = table.getNativePtr();
        ProductOrderColumnInfo columnInfo = (ProductOrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductOrder.class);
        long rowIndex = OsObject.createRow(realm.sharedRealm, table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$id(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.codigoPrestacionIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$codigoPrestacion(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$codigoExistencia(), false);
        String realmGet$name = ((ProductOrderRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.boxesIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$boxes(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.unitsIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$units(), false);
        Number realmGet$codigoSucursal = ((ProductOrderRealmProxyInterface)object).realmGet$codigoSucursal();
        if (realmGet$codigoSucursal != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, false);
        }
        Number realmGet$codigoServicio = ((ProductOrderRealmProxyInterface)object).realmGet$codigoServicio();
        if (realmGet$codigoServicio != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoServicioIndex, rowIndex, realmGet$codigoServicio.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoServicioIndex, rowIndex, false);
        }
        Number realmGet$cantidad = ((ProductOrderRealmProxyInterface)object).realmGet$cantidad();
        if (realmGet$cantidad != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, realmGet$cantidad.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cantidadIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.precioUnitarioVentaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$precioUnitarioVenta(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalVentaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subtotalVenta(), false);
        Double realmGet$porcentajeDescuento = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuento();
        if (realmGet$porcentajeDescuento != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoIndex, rowIndex, realmGet$porcentajeDescuento, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.porcentajeDescuentoIndex, rowIndex, false);
        }
        Double realmGet$valorDescuento = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuento();
        if (realmGet$valorDescuento != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoIndex, rowIndex, realmGet$valorDescuento, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.valorDescuentoIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalBaseImponibleIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subtotalBaseImponible(), false);
        String realmGet$aplicaIva = ((ProductOrderRealmProxyInterface)object).realmGet$aplicaIva();
        if (realmGet$aplicaIva != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, realmGet$aplicaIva, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeIvaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeIva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.valorIvaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$valorIva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.valorTotalIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$valorTotal(), false);
        String realmGet$esActivo = ((ProductOrderRealmProxyInterface)object).realmGet$esActivo();
        if (realmGet$esActivo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esActivoIndex, rowIndex, realmGet$esActivo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.esActivoIndex, rowIndex, false);
        }
        String realmGet$codigoEstado = ((ProductOrderRealmProxyInterface)object).realmGet$codigoEstado();
        if (realmGet$codigoEstado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, realmGet$codigoEstado, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, false);
        }
        String realmGet$usuarioIngreso = ((ProductOrderRealmProxyInterface)object).realmGet$usuarioIngreso();
        if (realmGet$usuarioIngreso != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, false);
        }
        String realmGet$tieneStockDisponible = ((ProductOrderRealmProxyInterface)object).realmGet$tieneStockDisponible();
        if (realmGet$tieneStockDisponible != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tieneStockDisponibleIndex, rowIndex, realmGet$tieneStockDisponible, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tieneStockDisponibleIndex, rowIndex, false);
        }
        String realmGet$esPromocion = ((ProductOrderRealmProxyInterface)object).realmGet$esPromocion();
        if (realmGet$esPromocion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esPromocionIndex, rowIndex, realmGet$esPromocion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.esPromocionIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.costoUnitarioIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoUnitario(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.costoTotalIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoTotal(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.costoPromedioIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoPromedio(), false);
        Number realmGet$numeroVersion = ((ProductOrderRealmProxyInterface)object).realmGet$numeroVersion();
        if (realmGet$numeroVersion != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.numeroVersionIndex, rowIndex, realmGet$numeroVersion.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numeroVersionIndex, rowIndex, false);
        }
        String realmGet$esPromocionAutomatica = ((ProductOrderRealmProxyInterface)object).realmGet$esPromocionAutomatica();
        if (realmGet$esPromocionAutomatica != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.esPromocionAutomaticaIndex, rowIndex, realmGet$esPromocionAutomatica, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.esPromocionAutomaticaIndex, rowIndex, false);
        }
        Number realmGet$codigoReglaNegocio = ((ProductOrderRealmProxyInterface)object).realmGet$codigoReglaNegocio();
        if (realmGet$codigoReglaNegocio != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoReglaNegocioIndex, rowIndex, realmGet$codigoReglaNegocio.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoReglaNegocioIndex, rowIndex, false);
        }
        Number realmGet$lineaDetalle = ((ProductOrderRealmProxyInterface)object).realmGet$lineaDetalle();
        if (realmGet$lineaDetalle != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.lineaDetalleIndex, rowIndex, realmGet$lineaDetalle.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.lineaDetalleIndex, rowIndex, false);
        }
        String realmGet$aplicaXRules = ((ProductOrderRealmProxyInterface)object).realmGet$aplicaXRules();
        if (realmGet$aplicaXRules != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaXRulesIndex, rowIndex, realmGet$aplicaXRules, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.aplicaXRulesIndex, rowIndex, false);
        }
        Double realmGet$porcentajeDescuentoXRules = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuentoXRules();
        if (realmGet$porcentajeDescuentoXRules != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoXRulesIndex, rowIndex, realmGet$porcentajeDescuentoXRules, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.porcentajeDescuentoXRulesIndex, rowIndex, false);
        }
        Double realmGet$valorDescuentoXRules = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuentoXRules();
        if (realmGet$valorDescuentoXRules != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoXRulesIndex, rowIndex, realmGet$valorDescuentoXRules, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.valorDescuentoXRulesIndex, rowIndex, false);
        }
        Double realmGet$porcentajeDescuentoManual = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuentoManual();
        if (realmGet$porcentajeDescuentoManual != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoManualIndex, rowIndex, realmGet$porcentajeDescuentoManual, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.porcentajeDescuentoManualIndex, rowIndex, false);
        }
        Double realmGet$valorDescuentoManual = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuentoManual();
        if (realmGet$valorDescuentoManual != null) {
            Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoManualIndex, rowIndex, realmGet$valorDescuentoManual, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.valorDescuentoManualIndex, rowIndex, false);
        }
        Number realmGet$cantidadEnCajas = ((ProductOrderRealmProxyInterface)object).realmGet$cantidadEnCajas();
        if (realmGet$cantidadEnCajas != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantidadEnCajasIndex, rowIndex, realmGet$cantidadEnCajas.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cantidadEnCajasIndex, rowIndex, false);
        }
        Number realmGet$cantidadEnUnidades = ((ProductOrderRealmProxyInterface)object).realmGet$cantidadEnUnidades();
        if (realmGet$cantidadEnUnidades != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.cantidadEnUnidadesIndex, rowIndex, realmGet$cantidadEnUnidades.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.cantidadEnUnidadesIndex, rowIndex, false);
        }
        Number realmGet$productRelation = ((ProductOrderRealmProxyInterface)object).realmGet$productRelation();
        if (realmGet$productRelation != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.productRelationIndex, rowIndex, realmGet$productRelation.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.productRelationIndex, rowIndex, false);
        }

        long lstDafDetallesOrdenNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.lstDafDetallesOrdenIndex, rowIndex);
        LinkView.nativeClear(lstDafDetallesOrdenNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.ProductOrder> lstDafDetallesOrdenList = ((ProductOrderRealmProxyInterface) object).realmGet$lstDafDetallesOrden();
        if (lstDafDetallesOrdenList != null) {
            for (com.mobile.polux.models.ProductOrder lstDafDetallesOrdenItem : lstDafDetallesOrdenList) {
                Long cacheItemIndexlstDafDetallesOrden = cache.get(lstDafDetallesOrdenItem);
                if (cacheItemIndexlstDafDetallesOrden == null) {
                    cacheItemIndexlstDafDetallesOrden = ProductOrderRealmProxy.insertOrUpdate(realm, lstDafDetallesOrdenItem, cache);
                }
                LinkView.nativeAdd(lstDafDetallesOrdenNativeLinkViewPtr, cacheItemIndexlstDafDetallesOrden);
            }
        }

        Table.nativeSetLong(tableNativePtr, columnInfo.providerIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$provider(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.groupIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$group(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.subGroupIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subGroup(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.articleIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$article(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.ProductOrder.class);
        long tableNativePtr = table.getNativePtr();
        ProductOrderColumnInfo columnInfo = (ProductOrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.ProductOrder.class);
        com.mobile.polux.models.ProductOrder object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.ProductOrder) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = OsObject.createRow(realm.sharedRealm, table);
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$id(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.codigoPrestacionIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$codigoPrestacion(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.codigoExistenciaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$codigoExistencia(), false);
                String realmGet$name = ((ProductOrderRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.boxesIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$boxes(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.unitsIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$units(), false);
                Number realmGet$codigoSucursal = ((ProductOrderRealmProxyInterface)object).realmGet$codigoSucursal();
                if (realmGet$codigoSucursal != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, false);
                }
                Number realmGet$codigoServicio = ((ProductOrderRealmProxyInterface)object).realmGet$codigoServicio();
                if (realmGet$codigoServicio != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoServicioIndex, rowIndex, realmGet$codigoServicio.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoServicioIndex, rowIndex, false);
                }
                Number realmGet$cantidad = ((ProductOrderRealmProxyInterface)object).realmGet$cantidad();
                if (realmGet$cantidad != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, realmGet$cantidad.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cantidadIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.precioUnitarioVentaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$precioUnitarioVenta(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalVentaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subtotalVenta(), false);
                Double realmGet$porcentajeDescuento = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuento();
                if (realmGet$porcentajeDescuento != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoIndex, rowIndex, realmGet$porcentajeDescuento, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.porcentajeDescuentoIndex, rowIndex, false);
                }
                Double realmGet$valorDescuento = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuento();
                if (realmGet$valorDescuento != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoIndex, rowIndex, realmGet$valorDescuento, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.valorDescuentoIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalBaseImponibleIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subtotalBaseImponible(), false);
                String realmGet$aplicaIva = ((ProductOrderRealmProxyInterface)object).realmGet$aplicaIva();
                if (realmGet$aplicaIva != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, realmGet$aplicaIva, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.aplicaIvaIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeIvaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeIva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.valorIvaIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$valorIva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.valorTotalIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$valorTotal(), false);
                String realmGet$esActivo = ((ProductOrderRealmProxyInterface)object).realmGet$esActivo();
                if (realmGet$esActivo != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esActivoIndex, rowIndex, realmGet$esActivo, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.esActivoIndex, rowIndex, false);
                }
                String realmGet$codigoEstado = ((ProductOrderRealmProxyInterface)object).realmGet$codigoEstado();
                if (realmGet$codigoEstado != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, realmGet$codigoEstado, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, false);
                }
                String realmGet$usuarioIngreso = ((ProductOrderRealmProxyInterface)object).realmGet$usuarioIngreso();
                if (realmGet$usuarioIngreso != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, false);
                }
                String realmGet$tieneStockDisponible = ((ProductOrderRealmProxyInterface)object).realmGet$tieneStockDisponible();
                if (realmGet$tieneStockDisponible != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.tieneStockDisponibleIndex, rowIndex, realmGet$tieneStockDisponible, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.tieneStockDisponibleIndex, rowIndex, false);
                }
                String realmGet$esPromocion = ((ProductOrderRealmProxyInterface)object).realmGet$esPromocion();
                if (realmGet$esPromocion != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esPromocionIndex, rowIndex, realmGet$esPromocion, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.esPromocionIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.costoUnitarioIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoUnitario(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.costoTotalIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoTotal(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.costoPromedioIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$costoPromedio(), false);
                Number realmGet$numeroVersion = ((ProductOrderRealmProxyInterface)object).realmGet$numeroVersion();
                if (realmGet$numeroVersion != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.numeroVersionIndex, rowIndex, realmGet$numeroVersion.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.numeroVersionIndex, rowIndex, false);
                }
                String realmGet$esPromocionAutomatica = ((ProductOrderRealmProxyInterface)object).realmGet$esPromocionAutomatica();
                if (realmGet$esPromocionAutomatica != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.esPromocionAutomaticaIndex, rowIndex, realmGet$esPromocionAutomatica, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.esPromocionAutomaticaIndex, rowIndex, false);
                }
                Number realmGet$codigoReglaNegocio = ((ProductOrderRealmProxyInterface)object).realmGet$codigoReglaNegocio();
                if (realmGet$codigoReglaNegocio != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoReglaNegocioIndex, rowIndex, realmGet$codigoReglaNegocio.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoReglaNegocioIndex, rowIndex, false);
                }
                Number realmGet$lineaDetalle = ((ProductOrderRealmProxyInterface)object).realmGet$lineaDetalle();
                if (realmGet$lineaDetalle != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.lineaDetalleIndex, rowIndex, realmGet$lineaDetalle.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.lineaDetalleIndex, rowIndex, false);
                }
                String realmGet$aplicaXRules = ((ProductOrderRealmProxyInterface)object).realmGet$aplicaXRules();
                if (realmGet$aplicaXRules != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaXRulesIndex, rowIndex, realmGet$aplicaXRules, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.aplicaXRulesIndex, rowIndex, false);
                }
                Double realmGet$porcentajeDescuentoXRules = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuentoXRules();
                if (realmGet$porcentajeDescuentoXRules != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoXRulesIndex, rowIndex, realmGet$porcentajeDescuentoXRules, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.porcentajeDescuentoXRulesIndex, rowIndex, false);
                }
                Double realmGet$valorDescuentoXRules = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuentoXRules();
                if (realmGet$valorDescuentoXRules != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoXRulesIndex, rowIndex, realmGet$valorDescuentoXRules, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.valorDescuentoXRulesIndex, rowIndex, false);
                }
                Double realmGet$porcentajeDescuentoManual = ((ProductOrderRealmProxyInterface)object).realmGet$porcentajeDescuentoManual();
                if (realmGet$porcentajeDescuentoManual != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.porcentajeDescuentoManualIndex, rowIndex, realmGet$porcentajeDescuentoManual, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.porcentajeDescuentoManualIndex, rowIndex, false);
                }
                Double realmGet$valorDescuentoManual = ((ProductOrderRealmProxyInterface)object).realmGet$valorDescuentoManual();
                if (realmGet$valorDescuentoManual != null) {
                    Table.nativeSetDouble(tableNativePtr, columnInfo.valorDescuentoManualIndex, rowIndex, realmGet$valorDescuentoManual, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.valorDescuentoManualIndex, rowIndex, false);
                }
                Number realmGet$cantidadEnCajas = ((ProductOrderRealmProxyInterface)object).realmGet$cantidadEnCajas();
                if (realmGet$cantidadEnCajas != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantidadEnCajasIndex, rowIndex, realmGet$cantidadEnCajas.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cantidadEnCajasIndex, rowIndex, false);
                }
                Number realmGet$cantidadEnUnidades = ((ProductOrderRealmProxyInterface)object).realmGet$cantidadEnUnidades();
                if (realmGet$cantidadEnUnidades != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.cantidadEnUnidadesIndex, rowIndex, realmGet$cantidadEnUnidades.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.cantidadEnUnidadesIndex, rowIndex, false);
                }
                Number realmGet$productRelation = ((ProductOrderRealmProxyInterface)object).realmGet$productRelation();
                if (realmGet$productRelation != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.productRelationIndex, rowIndex, realmGet$productRelation.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.productRelationIndex, rowIndex, false);
                }

                long lstDafDetallesOrdenNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.lstDafDetallesOrdenIndex, rowIndex);
                LinkView.nativeClear(lstDafDetallesOrdenNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.ProductOrder> lstDafDetallesOrdenList = ((ProductOrderRealmProxyInterface) object).realmGet$lstDafDetallesOrden();
                if (lstDafDetallesOrdenList != null) {
                    for (com.mobile.polux.models.ProductOrder lstDafDetallesOrdenItem : lstDafDetallesOrdenList) {
                        Long cacheItemIndexlstDafDetallesOrden = cache.get(lstDafDetallesOrdenItem);
                        if (cacheItemIndexlstDafDetallesOrden == null) {
                            cacheItemIndexlstDafDetallesOrden = ProductOrderRealmProxy.insertOrUpdate(realm, lstDafDetallesOrdenItem, cache);
                        }
                        LinkView.nativeAdd(lstDafDetallesOrdenNativeLinkViewPtr, cacheItemIndexlstDafDetallesOrden);
                    }
                }

                Table.nativeSetLong(tableNativePtr, columnInfo.providerIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$provider(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.groupIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$group(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.subGroupIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$subGroup(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.articleIndex, rowIndex, ((ProductOrderRealmProxyInterface)object).realmGet$article(), false);
            }
        }
    }

    public static com.mobile.polux.models.ProductOrder createDetachedCopy(com.mobile.polux.models.ProductOrder realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.ProductOrder unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.ProductOrder)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.ProductOrder)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.ProductOrder();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$id(((ProductOrderRealmProxyInterface) realmObject).realmGet$id());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$codigoPrestacion(((ProductOrderRealmProxyInterface) realmObject).realmGet$codigoPrestacion());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$codigoExistencia(((ProductOrderRealmProxyInterface) realmObject).realmGet$codigoExistencia());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$name(((ProductOrderRealmProxyInterface) realmObject).realmGet$name());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$boxes(((ProductOrderRealmProxyInterface) realmObject).realmGet$boxes());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$units(((ProductOrderRealmProxyInterface) realmObject).realmGet$units());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$codigoSucursal(((ProductOrderRealmProxyInterface) realmObject).realmGet$codigoSucursal());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$codigoServicio(((ProductOrderRealmProxyInterface) realmObject).realmGet$codigoServicio());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$cantidad(((ProductOrderRealmProxyInterface) realmObject).realmGet$cantidad());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$precioUnitarioVenta(((ProductOrderRealmProxyInterface) realmObject).realmGet$precioUnitarioVenta());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$subtotalVenta(((ProductOrderRealmProxyInterface) realmObject).realmGet$subtotalVenta());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$porcentajeDescuento(((ProductOrderRealmProxyInterface) realmObject).realmGet$porcentajeDescuento());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$valorDescuento(((ProductOrderRealmProxyInterface) realmObject).realmGet$valorDescuento());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$subtotalBaseImponible(((ProductOrderRealmProxyInterface) realmObject).realmGet$subtotalBaseImponible());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$aplicaIva(((ProductOrderRealmProxyInterface) realmObject).realmGet$aplicaIva());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$porcentajeIva(((ProductOrderRealmProxyInterface) realmObject).realmGet$porcentajeIva());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$valorIva(((ProductOrderRealmProxyInterface) realmObject).realmGet$valorIva());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$valorTotal(((ProductOrderRealmProxyInterface) realmObject).realmGet$valorTotal());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$esActivo(((ProductOrderRealmProxyInterface) realmObject).realmGet$esActivo());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$codigoEstado(((ProductOrderRealmProxyInterface) realmObject).realmGet$codigoEstado());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$usuarioIngreso(((ProductOrderRealmProxyInterface) realmObject).realmGet$usuarioIngreso());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$tieneStockDisponible(((ProductOrderRealmProxyInterface) realmObject).realmGet$tieneStockDisponible());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$esPromocion(((ProductOrderRealmProxyInterface) realmObject).realmGet$esPromocion());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$costoUnitario(((ProductOrderRealmProxyInterface) realmObject).realmGet$costoUnitario());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$costoTotal(((ProductOrderRealmProxyInterface) realmObject).realmGet$costoTotal());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$costoPromedio(((ProductOrderRealmProxyInterface) realmObject).realmGet$costoPromedio());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$numeroVersion(((ProductOrderRealmProxyInterface) realmObject).realmGet$numeroVersion());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$esPromocionAutomatica(((ProductOrderRealmProxyInterface) realmObject).realmGet$esPromocionAutomatica());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$codigoReglaNegocio(((ProductOrderRealmProxyInterface) realmObject).realmGet$codigoReglaNegocio());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$lineaDetalle(((ProductOrderRealmProxyInterface) realmObject).realmGet$lineaDetalle());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$aplicaXRules(((ProductOrderRealmProxyInterface) realmObject).realmGet$aplicaXRules());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$porcentajeDescuentoXRules(((ProductOrderRealmProxyInterface) realmObject).realmGet$porcentajeDescuentoXRules());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$valorDescuentoXRules(((ProductOrderRealmProxyInterface) realmObject).realmGet$valorDescuentoXRules());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$porcentajeDescuentoManual(((ProductOrderRealmProxyInterface) realmObject).realmGet$porcentajeDescuentoManual());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$valorDescuentoManual(((ProductOrderRealmProxyInterface) realmObject).realmGet$valorDescuentoManual());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$cantidadEnCajas(((ProductOrderRealmProxyInterface) realmObject).realmGet$cantidadEnCajas());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$cantidadEnUnidades(((ProductOrderRealmProxyInterface) realmObject).realmGet$cantidadEnUnidades());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$productRelation(((ProductOrderRealmProxyInterface) realmObject).realmGet$productRelation());

        // Deep copy of lstDafDetallesOrden
        if (currentDepth == maxDepth) {
            ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$lstDafDetallesOrden(null);
        } else {
            RealmList<com.mobile.polux.models.ProductOrder> managedlstDafDetallesOrdenList = ((ProductOrderRealmProxyInterface) realmObject).realmGet$lstDafDetallesOrden();
            RealmList<com.mobile.polux.models.ProductOrder> unmanagedlstDafDetallesOrdenList = new RealmList<com.mobile.polux.models.ProductOrder>();
            ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$lstDafDetallesOrden(unmanagedlstDafDetallesOrdenList);
            int nextDepth = currentDepth + 1;
            int size = managedlstDafDetallesOrdenList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.ProductOrder item = ProductOrderRealmProxy.createDetachedCopy(managedlstDafDetallesOrdenList.get(i), nextDepth, maxDepth, cache);
                unmanagedlstDafDetallesOrdenList.add(item);
            }
        }
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$provider(((ProductOrderRealmProxyInterface) realmObject).realmGet$provider());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$group(((ProductOrderRealmProxyInterface) realmObject).realmGet$group());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$subGroup(((ProductOrderRealmProxyInterface) realmObject).realmGet$subGroup());
        ((ProductOrderRealmProxyInterface) unmanagedObject).realmSet$article(((ProductOrderRealmProxyInterface) realmObject).realmGet$article());
        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ProductOrder = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoPrestacion:");
        stringBuilder.append(realmGet$codigoPrestacion());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoExistencia:");
        stringBuilder.append(realmGet$codigoExistencia());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{boxes:");
        stringBuilder.append(realmGet$boxes());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{units:");
        stringBuilder.append(realmGet$units());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoSucursal:");
        stringBuilder.append(realmGet$codigoSucursal() != null ? realmGet$codigoSucursal() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoServicio:");
        stringBuilder.append(realmGet$codigoServicio() != null ? realmGet$codigoServicio() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantidad:");
        stringBuilder.append(realmGet$cantidad() != null ? realmGet$cantidad() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{precioUnitarioVenta:");
        stringBuilder.append(realmGet$precioUnitarioVenta());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subtotalVenta:");
        stringBuilder.append(realmGet$subtotalVenta());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{porcentajeDescuento:");
        stringBuilder.append(realmGet$porcentajeDescuento() != null ? realmGet$porcentajeDescuento() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{valorDescuento:");
        stringBuilder.append(realmGet$valorDescuento() != null ? realmGet$valorDescuento() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subtotalBaseImponible:");
        stringBuilder.append(realmGet$subtotalBaseImponible());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aplicaIva:");
        stringBuilder.append(realmGet$aplicaIva() != null ? realmGet$aplicaIva() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{porcentajeIva:");
        stringBuilder.append(realmGet$porcentajeIva());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{valorIva:");
        stringBuilder.append(realmGet$valorIva());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{valorTotal:");
        stringBuilder.append(realmGet$valorTotal());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{esActivo:");
        stringBuilder.append(realmGet$esActivo() != null ? realmGet$esActivo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoEstado:");
        stringBuilder.append(realmGet$codigoEstado() != null ? realmGet$codigoEstado() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{usuarioIngreso:");
        stringBuilder.append(realmGet$usuarioIngreso() != null ? realmGet$usuarioIngreso() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{tieneStockDisponible:");
        stringBuilder.append(realmGet$tieneStockDisponible() != null ? realmGet$tieneStockDisponible() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{esPromocion:");
        stringBuilder.append(realmGet$esPromocion() != null ? realmGet$esPromocion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{costoUnitario:");
        stringBuilder.append(realmGet$costoUnitario());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{costoTotal:");
        stringBuilder.append(realmGet$costoTotal());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{costoPromedio:");
        stringBuilder.append(realmGet$costoPromedio());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numeroVersion:");
        stringBuilder.append(realmGet$numeroVersion() != null ? realmGet$numeroVersion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{esPromocionAutomatica:");
        stringBuilder.append(realmGet$esPromocionAutomatica() != null ? realmGet$esPromocionAutomatica() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoReglaNegocio:");
        stringBuilder.append(realmGet$codigoReglaNegocio() != null ? realmGet$codigoReglaNegocio() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lineaDetalle:");
        stringBuilder.append(realmGet$lineaDetalle() != null ? realmGet$lineaDetalle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aplicaXRules:");
        stringBuilder.append(realmGet$aplicaXRules() != null ? realmGet$aplicaXRules() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{porcentajeDescuentoXRules:");
        stringBuilder.append(realmGet$porcentajeDescuentoXRules() != null ? realmGet$porcentajeDescuentoXRules() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{valorDescuentoXRules:");
        stringBuilder.append(realmGet$valorDescuentoXRules() != null ? realmGet$valorDescuentoXRules() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{porcentajeDescuentoManual:");
        stringBuilder.append(realmGet$porcentajeDescuentoManual() != null ? realmGet$porcentajeDescuentoManual() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{valorDescuentoManual:");
        stringBuilder.append(realmGet$valorDescuentoManual() != null ? realmGet$valorDescuentoManual() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantidadEnCajas:");
        stringBuilder.append(realmGet$cantidadEnCajas() != null ? realmGet$cantidadEnCajas() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantidadEnUnidades:");
        stringBuilder.append(realmGet$cantidadEnUnidades() != null ? realmGet$cantidadEnUnidades() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{productRelation:");
        stringBuilder.append(realmGet$productRelation() != null ? realmGet$productRelation() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lstDafDetallesOrden:");
        stringBuilder.append("RealmList<ProductOrder>[").append(realmGet$lstDafDetallesOrden().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{provider:");
        stringBuilder.append(realmGet$provider());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{group:");
        stringBuilder.append(realmGet$group());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subGroup:");
        stringBuilder.append(realmGet$subGroup());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{article:");
        stringBuilder.append(realmGet$article());
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
        ProductOrderRealmProxy aProductOrder = (ProductOrderRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aProductOrder.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aProductOrder.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aProductOrder.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
