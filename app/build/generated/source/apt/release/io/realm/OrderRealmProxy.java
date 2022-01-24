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

public class OrderRealmProxy extends com.mobile.polux.models.Order
    implements RealmObjectProxy, OrderRealmProxyInterface {

    static final class OrderColumnInfo extends ColumnInfo {
        long idIndex;
        long numeroOrdenIndex;
        long numeroOrdenAuxiliarIndex;
        long aprobadaIndex;
        long observacionesIndex;
        long errorIndex;
        long codigoClienteIndex;
        long nameIndex;
        long totalIndex;
        long subtotalIndex;
        long ivaIndex;
        long discountIndex;
        long stateIndex;
        long approvedIndex;
        long fechaOrdenIndex;
        long codigoEmpresaIndex;
        long codigoSucursalIndex;
        long fechaEntregaIndex;
        long fechaCompromisoPagoIndex;
        long codigoTipoVentaIndex;
        long codigoEstadoIndex;
        long observacionIndex;
        long aplicaConsignacionIndex;
        long codigoTipoOrdenIndex;
        long aplicaFacturaSinStockIndex;
        long codigoBodegaIndex;
        long usuarioIngresoIndex;
        long codigoCuentaClienteIndex;
        long codigoDivisionIndex;
        long codigoCuentaXDZVIndex;
        long codigoLocalidadIndex;
        long lsDafDetallesOrdensIndex;

        OrderColumnInfo(SharedRealm realm, Table table) {
            super(32);
            this.idIndex = addColumnDetails(table, "id", RealmFieldType.INTEGER);
            this.numeroOrdenIndex = addColumnDetails(table, "numeroOrden", RealmFieldType.INTEGER);
            this.numeroOrdenAuxiliarIndex = addColumnDetails(table, "numeroOrdenAuxiliar", RealmFieldType.INTEGER);
            this.aprobadaIndex = addColumnDetails(table, "aprobada", RealmFieldType.STRING);
            this.observacionesIndex = addColumnDetails(table, "observaciones", RealmFieldType.STRING);
            this.errorIndex = addColumnDetails(table, "error", RealmFieldType.STRING);
            this.codigoClienteIndex = addColumnDetails(table, "codigoCliente", RealmFieldType.INTEGER);
            this.nameIndex = addColumnDetails(table, "name", RealmFieldType.STRING);
            this.totalIndex = addColumnDetails(table, "total", RealmFieldType.DOUBLE);
            this.subtotalIndex = addColumnDetails(table, "subtotal", RealmFieldType.DOUBLE);
            this.ivaIndex = addColumnDetails(table, "iva", RealmFieldType.DOUBLE);
            this.discountIndex = addColumnDetails(table, "discount", RealmFieldType.DOUBLE);
            this.stateIndex = addColumnDetails(table, "state", RealmFieldType.STRING);
            this.approvedIndex = addColumnDetails(table, "approved", RealmFieldType.BOOLEAN);
            this.fechaOrdenIndex = addColumnDetails(table, "fechaOrden", RealmFieldType.STRING);
            this.codigoEmpresaIndex = addColumnDetails(table, "codigoEmpresa", RealmFieldType.INTEGER);
            this.codigoSucursalIndex = addColumnDetails(table, "codigoSucursal", RealmFieldType.INTEGER);
            this.fechaEntregaIndex = addColumnDetails(table, "fechaEntrega", RealmFieldType.STRING);
            this.fechaCompromisoPagoIndex = addColumnDetails(table, "fechaCompromisoPago", RealmFieldType.STRING);
            this.codigoTipoVentaIndex = addColumnDetails(table, "codigoTipoVenta", RealmFieldType.INTEGER);
            this.codigoEstadoIndex = addColumnDetails(table, "codigoEstado", RealmFieldType.STRING);
            this.observacionIndex = addColumnDetails(table, "observacion", RealmFieldType.STRING);
            this.aplicaConsignacionIndex = addColumnDetails(table, "aplicaConsignacion", RealmFieldType.STRING);
            this.codigoTipoOrdenIndex = addColumnDetails(table, "codigoTipoOrden", RealmFieldType.STRING);
            this.aplicaFacturaSinStockIndex = addColumnDetails(table, "aplicaFacturaSinStock", RealmFieldType.STRING);
            this.codigoBodegaIndex = addColumnDetails(table, "codigoBodega", RealmFieldType.INTEGER);
            this.usuarioIngresoIndex = addColumnDetails(table, "usuarioIngreso", RealmFieldType.STRING);
            this.codigoCuentaClienteIndex = addColumnDetails(table, "codigoCuentaCliente", RealmFieldType.INTEGER);
            this.codigoDivisionIndex = addColumnDetails(table, "codigoDivision", RealmFieldType.INTEGER);
            this.codigoCuentaXDZVIndex = addColumnDetails(table, "codigoCuentaXDZV", RealmFieldType.INTEGER);
            this.codigoLocalidadIndex = addColumnDetails(table, "codigoLocalidad", RealmFieldType.INTEGER);
            this.lsDafDetallesOrdensIndex = addColumnDetails(table, "lsDafDetallesOrdens", RealmFieldType.LIST);
        }

        OrderColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new OrderColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final OrderColumnInfo src = (OrderColumnInfo) rawSrc;
            final OrderColumnInfo dst = (OrderColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.numeroOrdenIndex = src.numeroOrdenIndex;
            dst.numeroOrdenAuxiliarIndex = src.numeroOrdenAuxiliarIndex;
            dst.aprobadaIndex = src.aprobadaIndex;
            dst.observacionesIndex = src.observacionesIndex;
            dst.errorIndex = src.errorIndex;
            dst.codigoClienteIndex = src.codigoClienteIndex;
            dst.nameIndex = src.nameIndex;
            dst.totalIndex = src.totalIndex;
            dst.subtotalIndex = src.subtotalIndex;
            dst.ivaIndex = src.ivaIndex;
            dst.discountIndex = src.discountIndex;
            dst.stateIndex = src.stateIndex;
            dst.approvedIndex = src.approvedIndex;
            dst.fechaOrdenIndex = src.fechaOrdenIndex;
            dst.codigoEmpresaIndex = src.codigoEmpresaIndex;
            dst.codigoSucursalIndex = src.codigoSucursalIndex;
            dst.fechaEntregaIndex = src.fechaEntregaIndex;
            dst.fechaCompromisoPagoIndex = src.fechaCompromisoPagoIndex;
            dst.codigoTipoVentaIndex = src.codigoTipoVentaIndex;
            dst.codigoEstadoIndex = src.codigoEstadoIndex;
            dst.observacionIndex = src.observacionIndex;
            dst.aplicaConsignacionIndex = src.aplicaConsignacionIndex;
            dst.codigoTipoOrdenIndex = src.codigoTipoOrdenIndex;
            dst.aplicaFacturaSinStockIndex = src.aplicaFacturaSinStockIndex;
            dst.codigoBodegaIndex = src.codigoBodegaIndex;
            dst.usuarioIngresoIndex = src.usuarioIngresoIndex;
            dst.codigoCuentaClienteIndex = src.codigoCuentaClienteIndex;
            dst.codigoDivisionIndex = src.codigoDivisionIndex;
            dst.codigoCuentaXDZVIndex = src.codigoCuentaXDZVIndex;
            dst.codigoLocalidadIndex = src.codigoLocalidadIndex;
            dst.lsDafDetallesOrdensIndex = src.lsDafDetallesOrdensIndex;
        }
    }

    private OrderColumnInfo columnInfo;
    private ProxyState<com.mobile.polux.models.Order> proxyState;
    private RealmList<com.mobile.polux.models.ProductOrder> lsDafDetallesOrdensRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("numeroOrden");
        fieldNames.add("numeroOrdenAuxiliar");
        fieldNames.add("aprobada");
        fieldNames.add("observaciones");
        fieldNames.add("error");
        fieldNames.add("codigoCliente");
        fieldNames.add("name");
        fieldNames.add("total");
        fieldNames.add("subtotal");
        fieldNames.add("iva");
        fieldNames.add("discount");
        fieldNames.add("state");
        fieldNames.add("approved");
        fieldNames.add("fechaOrden");
        fieldNames.add("codigoEmpresa");
        fieldNames.add("codigoSucursal");
        fieldNames.add("fechaEntrega");
        fieldNames.add("fechaCompromisoPago");
        fieldNames.add("codigoTipoVenta");
        fieldNames.add("codigoEstado");
        fieldNames.add("observacion");
        fieldNames.add("aplicaConsignacion");
        fieldNames.add("codigoTipoOrden");
        fieldNames.add("aplicaFacturaSinStock");
        fieldNames.add("codigoBodega");
        fieldNames.add("usuarioIngreso");
        fieldNames.add("codigoCuentaCliente");
        fieldNames.add("codigoDivision");
        fieldNames.add("codigoCuentaXDZV");
        fieldNames.add("codigoLocalidad");
        fieldNames.add("lsDafDetallesOrdens");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    OrderRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (OrderColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mobile.polux.models.Order>(this);
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
    public Long realmGet$numeroOrden() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.numeroOrdenIndex)) {
            return null;
        }
        return (long) proxyState.getRow$realm().getLong(columnInfo.numeroOrdenIndex);
    }

    @Override
    public void realmSet$numeroOrden(Long value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.numeroOrdenIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.numeroOrdenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.numeroOrdenIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.numeroOrdenIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$numeroOrdenAuxiliar() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.numeroOrdenAuxiliarIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.numeroOrdenAuxiliarIndex);
    }

    @Override
    public void realmSet$numeroOrdenAuxiliar(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.numeroOrdenAuxiliarIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.numeroOrdenAuxiliarIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.numeroOrdenAuxiliarIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.numeroOrdenAuxiliarIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$aprobada() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.aprobadaIndex);
    }

    @Override
    public void realmSet$aprobada(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.aprobadaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.aprobadaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.aprobadaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.aprobadaIndex, value);
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
    public String realmGet$error() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.errorIndex);
    }

    @Override
    public void realmSet$error(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.errorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.errorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.errorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.errorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$codigoCliente() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoClienteIndex);
    }

    @Override
    public void realmSet$codigoCliente(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.codigoClienteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.codigoClienteIndex, value);
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
    public boolean realmGet$approved() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.approvedIndex);
    }

    @Override
    public void realmSet$approved(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.approvedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.approvedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fechaOrden() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fechaOrdenIndex);
    }

    @Override
    public void realmSet$fechaOrden(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fechaOrdenIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fechaOrdenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fechaOrdenIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fechaOrdenIndex, value);
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
    public String realmGet$fechaEntrega() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fechaEntregaIndex);
    }

    @Override
    public void realmSet$fechaEntrega(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fechaEntregaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fechaEntregaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fechaEntregaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fechaEntregaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fechaCompromisoPago() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fechaCompromisoPagoIndex);
    }

    @Override
    public void realmSet$fechaCompromisoPago(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fechaCompromisoPagoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fechaCompromisoPagoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fechaCompromisoPagoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fechaCompromisoPagoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoTipoVenta() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoTipoVentaIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoTipoVentaIndex);
    }

    @Override
    public void realmSet$codigoTipoVenta(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoTipoVentaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoTipoVentaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoTipoVentaIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoTipoVentaIndex, value);
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
    public String realmGet$observacion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.observacionIndex);
    }

    @Override
    public void realmSet$observacion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.observacionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.observacionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.observacionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.observacionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$aplicaConsignacion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.aplicaConsignacionIndex);
    }

    @Override
    public void realmSet$aplicaConsignacion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.aplicaConsignacionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.aplicaConsignacionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.aplicaConsignacionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.aplicaConsignacionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$codigoTipoOrden() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.codigoTipoOrdenIndex);
    }

    @Override
    public void realmSet$codigoTipoOrden(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoTipoOrdenIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.codigoTipoOrdenIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoTipoOrdenIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.codigoTipoOrdenIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$aplicaFacturaSinStock() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.aplicaFacturaSinStockIndex);
    }

    @Override
    public void realmSet$aplicaFacturaSinStock(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.aplicaFacturaSinStockIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.aplicaFacturaSinStockIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.aplicaFacturaSinStockIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.aplicaFacturaSinStockIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoBodega() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoBodegaIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoBodegaIndex);
    }

    @Override
    public void realmSet$codigoBodega(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoBodegaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoBodegaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoBodegaIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoBodegaIndex, value);
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
    public Integer realmGet$codigoCuentaCliente() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoCuentaClienteIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoCuentaClienteIndex);
    }

    @Override
    public void realmSet$codigoCuentaCliente(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoCuentaClienteIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoCuentaClienteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoCuentaClienteIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoCuentaClienteIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoDivision() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoDivisionIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoDivisionIndex);
    }

    @Override
    public void realmSet$codigoDivision(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoDivisionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoDivisionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoDivisionIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoDivisionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoCuentaXDZV() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoCuentaXDZVIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoCuentaXDZVIndex);
    }

    @Override
    public void realmSet$codigoCuentaXDZV(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoCuentaXDZVIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoCuentaXDZVIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoCuentaXDZVIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoCuentaXDZVIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$codigoLocalidad() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.codigoLocalidadIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.codigoLocalidadIndex);
    }

    @Override
    public void realmSet$codigoLocalidad(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigoLocalidadIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.codigoLocalidadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigoLocalidadIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.codigoLocalidadIndex, value);
    }

    @Override
    public RealmList<com.mobile.polux.models.ProductOrder> realmGet$lsDafDetallesOrdens() {
        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (lsDafDetallesOrdensRealmList != null) {
            return lsDafDetallesOrdensRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.lsDafDetallesOrdensIndex);
            lsDafDetallesOrdensRealmList = new RealmList<com.mobile.polux.models.ProductOrder>(com.mobile.polux.models.ProductOrder.class, linkView, proxyState.getRealm$realm());
            return lsDafDetallesOrdensRealmList;
        }
    }

    @Override
    public void realmSet$lsDafDetallesOrdens(RealmList<com.mobile.polux.models.ProductOrder> value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("lsDafDetallesOrdens")) {
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
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.lsDafDetallesOrdensIndex);
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
        if (!realmSchema.contains("Order")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Order");
            realmObjectSchema.add("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("numeroOrden", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("numeroOrdenAuxiliar", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("aprobada", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("observaciones", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("error", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoCliente", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("total", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("subtotal", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("iva", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("discount", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("state", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("approved", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
            realmObjectSchema.add("fechaOrden", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoEmpresa", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoSucursal", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("fechaEntrega", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("fechaCompromisoPago", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoTipoVenta", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoEstado", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("observacion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("aplicaConsignacion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoTipoOrden", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("aplicaFacturaSinStock", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoBodega", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("usuarioIngreso", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoCuentaCliente", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoDivision", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoCuentaXDZV", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            realmObjectSchema.add("codigoLocalidad", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
            if (!realmSchema.contains("ProductOrder")) {
                ProductOrderRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add("lsDafDetallesOrdens", RealmFieldType.LIST, realmSchema.get("ProductOrder"));
            return realmObjectSchema;
        }
        return realmSchema.get("Order");
    }

    public static OrderColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (!sharedRealm.hasTable("class_Order")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Order' class is missing from the schema for this Realm.");
        }
        Table table = sharedRealm.getTable("class_Order");
        final long columnCount = table.getColumnCount();
        if (columnCount != 32) {
            if (columnCount < 32) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 32 but was " + columnCount);
            }
            if (allowExtraColumns) {
                RealmLog.debug("Field count is more than expected - expected 32 but was %1$d", columnCount);
            } else {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 32 but was " + columnCount);
            }
        }
        Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
        for (long i = 0; i < columnCount; i++) {
            columnTypes.put(table.getColumnName(i), table.getColumnType(i));
        }

        final OrderColumnInfo columnInfo = new OrderColumnInfo(sharedRealm, table);

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
        if (!columnTypes.containsKey("numeroOrden")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numeroOrden' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("numeroOrden") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Long' for field 'numeroOrden' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.numeroOrdenIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'numeroOrden' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'numeroOrden' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("numeroOrdenAuxiliar")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'numeroOrdenAuxiliar' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("numeroOrdenAuxiliar") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'numeroOrdenAuxiliar' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.numeroOrdenAuxiliarIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'numeroOrdenAuxiliar' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'numeroOrdenAuxiliar' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("aprobada")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aprobada' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("aprobada") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'aprobada' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.aprobadaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aprobada' is required. Either set @Required to field 'aprobada' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("error")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'error' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("error") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'error' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.errorIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'error' is required. Either set @Required to field 'error' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoCliente")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoCliente' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoCliente") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'codigoCliente' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.codigoClienteIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'codigoCliente' does support null values in the existing Realm file. Use corresponding boxed type for field 'codigoCliente' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("total")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'total' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("total") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'total' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.totalIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'total' does support null values in the existing Realm file. Use corresponding boxed type for field 'total' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("iva")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'iva' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("iva") != RealmFieldType.DOUBLE) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'double' for field 'iva' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.ivaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'iva' does support null values in the existing Realm file. Use corresponding boxed type for field 'iva' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("state")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'state' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("state") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'state' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.stateIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'state' is required. Either set @Required to field 'state' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("approved")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'approved' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("approved") != RealmFieldType.BOOLEAN) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'boolean' for field 'approved' in existing Realm file.");
        }
        if (table.isColumnNullable(columnInfo.approvedIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'approved' does support null values in the existing Realm file. Use corresponding boxed type for field 'approved' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("fechaOrden")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fechaOrden' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fechaOrden") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fechaOrden' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.fechaOrdenIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fechaOrden' is required. Either set @Required to field 'fechaOrden' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("fechaEntrega")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fechaEntrega' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fechaEntrega") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fechaEntrega' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.fechaEntregaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fechaEntrega' is required. Either set @Required to field 'fechaEntrega' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("fechaCompromisoPago")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'fechaCompromisoPago' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("fechaCompromisoPago") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'fechaCompromisoPago' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.fechaCompromisoPagoIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'fechaCompromisoPago' is required. Either set @Required to field 'fechaCompromisoPago' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoTipoVenta")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoTipoVenta' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoTipoVenta") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoTipoVenta' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoTipoVentaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoTipoVenta' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoTipoVenta' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("observacion")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'observacion' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("observacion") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'observacion' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.observacionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'observacion' is required. Either set @Required to field 'observacion' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("aplicaConsignacion")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aplicaConsignacion' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("aplicaConsignacion") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'aplicaConsignacion' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.aplicaConsignacionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aplicaConsignacion' is required. Either set @Required to field 'aplicaConsignacion' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoTipoOrden")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoTipoOrden' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoTipoOrden") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'codigoTipoOrden' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoTipoOrdenIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'codigoTipoOrden' is required. Either set @Required to field 'codigoTipoOrden' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("aplicaFacturaSinStock")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'aplicaFacturaSinStock' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("aplicaFacturaSinStock") != RealmFieldType.STRING) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'aplicaFacturaSinStock' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.aplicaFacturaSinStockIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'aplicaFacturaSinStock' is required. Either set @Required to field 'aplicaFacturaSinStock' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoBodega")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoBodega' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoBodega") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoBodega' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoBodegaIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoBodega' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoBodega' or migrate using RealmObjectSchema.setNullable().");
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
        if (!columnTypes.containsKey("codigoCuentaCliente")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoCuentaCliente' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoCuentaCliente") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoCuentaCliente' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoCuentaClienteIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoCuentaCliente' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoCuentaCliente' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoDivision")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoDivision' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoDivision") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoDivision' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoDivisionIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoDivision' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoDivision' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoCuentaXDZV")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoCuentaXDZV' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoCuentaXDZV") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoCuentaXDZV' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoCuentaXDZVIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoCuentaXDZV' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoCuentaXDZV' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("codigoLocalidad")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'codigoLocalidad' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
        }
        if (columnTypes.get("codigoLocalidad") != RealmFieldType.INTEGER) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Integer' for field 'codigoLocalidad' in existing Realm file.");
        }
        if (!table.isColumnNullable(columnInfo.codigoLocalidadIndex)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(),"Field 'codigoLocalidad' does not support null values in the existing Realm file. Either set @Required, use the primitive type for field 'codigoLocalidad' or migrate using RealmObjectSchema.setNullable().");
        }
        if (!columnTypes.containsKey("lsDafDetallesOrdens")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'lsDafDetallesOrdens'");
        }
        if (columnTypes.get("lsDafDetallesOrdens") != RealmFieldType.LIST) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'ProductOrder' for field 'lsDafDetallesOrdens'");
        }
        if (!sharedRealm.hasTable("class_ProductOrder")) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_ProductOrder' for field 'lsDafDetallesOrdens'");
        }
        Table table_31 = sharedRealm.getTable("class_ProductOrder");
        if (!table.getLinkTarget(columnInfo.lsDafDetallesOrdensIndex).hasSameSchema(table_31)) {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'lsDafDetallesOrdens': '" + table.getLinkTarget(columnInfo.lsDafDetallesOrdensIndex).getName() + "' expected - was '" + table_31.getName() + "'");
        }

        return columnInfo;
    }

    public static String getTableName() {
        return "class_Order";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.mobile.polux.models.Order createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        com.mobile.polux.models.Order obj = null;
        if (update) {
            Table table = realm.getTable(com.mobile.polux.models.Order.class);
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
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Order.class), false, Collections.<String> emptyList());
                    obj = new io.realm.OrderRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("lsDafDetallesOrdens")) {
                excludeFields.add("lsDafDetallesOrdens");
            }
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.OrderRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Order.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.OrderRealmProxy) realm.createObjectInternal(com.mobile.polux.models.Order.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("numeroOrden")) {
            if (json.isNull("numeroOrden")) {
                ((OrderRealmProxyInterface) obj).realmSet$numeroOrden(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$numeroOrden((long) json.getLong("numeroOrden"));
            }
        }
        if (json.has("numeroOrdenAuxiliar")) {
            if (json.isNull("numeroOrdenAuxiliar")) {
                ((OrderRealmProxyInterface) obj).realmSet$numeroOrdenAuxiliar(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$numeroOrdenAuxiliar((int) json.getInt("numeroOrdenAuxiliar"));
            }
        }
        if (json.has("aprobada")) {
            if (json.isNull("aprobada")) {
                ((OrderRealmProxyInterface) obj).realmSet$aprobada(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$aprobada((String) json.getString("aprobada"));
            }
        }
        if (json.has("observaciones")) {
            if (json.isNull("observaciones")) {
                ((OrderRealmProxyInterface) obj).realmSet$observaciones(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$observaciones((String) json.getString("observaciones"));
            }
        }
        if (json.has("error")) {
            if (json.isNull("error")) {
                ((OrderRealmProxyInterface) obj).realmSet$error(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$error((String) json.getString("error"));
            }
        }
        if (json.has("codigoCliente")) {
            if (json.isNull("codigoCliente")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'codigoCliente' to null.");
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoCliente((int) json.getInt("codigoCliente"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((OrderRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("total")) {
            if (json.isNull("total")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'total' to null.");
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$total((double) json.getDouble("total"));
            }
        }
        if (json.has("subtotal")) {
            if (json.isNull("subtotal")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'subtotal' to null.");
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$subtotal((double) json.getDouble("subtotal"));
            }
        }
        if (json.has("iva")) {
            if (json.isNull("iva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'iva' to null.");
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$iva((double) json.getDouble("iva"));
            }
        }
        if (json.has("discount")) {
            if (json.isNull("discount")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'discount' to null.");
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$discount((double) json.getDouble("discount"));
            }
        }
        if (json.has("state")) {
            if (json.isNull("state")) {
                ((OrderRealmProxyInterface) obj).realmSet$state(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$state((String) json.getString("state"));
            }
        }
        if (json.has("approved")) {
            if (json.isNull("approved")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'approved' to null.");
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$approved((boolean) json.getBoolean("approved"));
            }
        }
        if (json.has("fechaOrden")) {
            if (json.isNull("fechaOrden")) {
                ((OrderRealmProxyInterface) obj).realmSet$fechaOrden(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$fechaOrden((String) json.getString("fechaOrden"));
            }
        }
        if (json.has("codigoEmpresa")) {
            if (json.isNull("codigoEmpresa")) {
                ((OrderRealmProxyInterface) obj).realmSet$codigoEmpresa(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoEmpresa((int) json.getInt("codigoEmpresa"));
            }
        }
        if (json.has("codigoSucursal")) {
            if (json.isNull("codigoSucursal")) {
                ((OrderRealmProxyInterface) obj).realmSet$codigoSucursal(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoSucursal((int) json.getInt("codigoSucursal"));
            }
        }
        if (json.has("fechaEntrega")) {
            if (json.isNull("fechaEntrega")) {
                ((OrderRealmProxyInterface) obj).realmSet$fechaEntrega(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$fechaEntrega((String) json.getString("fechaEntrega"));
            }
        }
        if (json.has("fechaCompromisoPago")) {
            if (json.isNull("fechaCompromisoPago")) {
                ((OrderRealmProxyInterface) obj).realmSet$fechaCompromisoPago(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$fechaCompromisoPago((String) json.getString("fechaCompromisoPago"));
            }
        }
        if (json.has("codigoTipoVenta")) {
            if (json.isNull("codigoTipoVenta")) {
                ((OrderRealmProxyInterface) obj).realmSet$codigoTipoVenta(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoTipoVenta((int) json.getInt("codigoTipoVenta"));
            }
        }
        if (json.has("codigoEstado")) {
            if (json.isNull("codigoEstado")) {
                ((OrderRealmProxyInterface) obj).realmSet$codigoEstado(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoEstado((String) json.getString("codigoEstado"));
            }
        }
        if (json.has("observacion")) {
            if (json.isNull("observacion")) {
                ((OrderRealmProxyInterface) obj).realmSet$observacion(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$observacion((String) json.getString("observacion"));
            }
        }
        if (json.has("aplicaConsignacion")) {
            if (json.isNull("aplicaConsignacion")) {
                ((OrderRealmProxyInterface) obj).realmSet$aplicaConsignacion(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$aplicaConsignacion((String) json.getString("aplicaConsignacion"));
            }
        }
        if (json.has("codigoTipoOrden")) {
            if (json.isNull("codigoTipoOrden")) {
                ((OrderRealmProxyInterface) obj).realmSet$codigoTipoOrden(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoTipoOrden((String) json.getString("codigoTipoOrden"));
            }
        }
        if (json.has("aplicaFacturaSinStock")) {
            if (json.isNull("aplicaFacturaSinStock")) {
                ((OrderRealmProxyInterface) obj).realmSet$aplicaFacturaSinStock(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$aplicaFacturaSinStock((String) json.getString("aplicaFacturaSinStock"));
            }
        }
        if (json.has("codigoBodega")) {
            if (json.isNull("codigoBodega")) {
                ((OrderRealmProxyInterface) obj).realmSet$codigoBodega(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoBodega((int) json.getInt("codigoBodega"));
            }
        }
        if (json.has("usuarioIngreso")) {
            if (json.isNull("usuarioIngreso")) {
                ((OrderRealmProxyInterface) obj).realmSet$usuarioIngreso(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$usuarioIngreso((String) json.getString("usuarioIngreso"));
            }
        }
        if (json.has("codigoCuentaCliente")) {
            if (json.isNull("codigoCuentaCliente")) {
                ((OrderRealmProxyInterface) obj).realmSet$codigoCuentaCliente(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoCuentaCliente((int) json.getInt("codigoCuentaCliente"));
            }
        }
        if (json.has("codigoDivision")) {
            if (json.isNull("codigoDivision")) {
                ((OrderRealmProxyInterface) obj).realmSet$codigoDivision(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoDivision((int) json.getInt("codigoDivision"));
            }
        }
        if (json.has("codigoCuentaXDZV")) {
            if (json.isNull("codigoCuentaXDZV")) {
                ((OrderRealmProxyInterface) obj).realmSet$codigoCuentaXDZV(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoCuentaXDZV((int) json.getInt("codigoCuentaXDZV"));
            }
        }
        if (json.has("codigoLocalidad")) {
            if (json.isNull("codigoLocalidad")) {
                ((OrderRealmProxyInterface) obj).realmSet$codigoLocalidad(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmSet$codigoLocalidad((int) json.getInt("codigoLocalidad"));
            }
        }
        if (json.has("lsDafDetallesOrdens")) {
            if (json.isNull("lsDafDetallesOrdens")) {
                ((OrderRealmProxyInterface) obj).realmSet$lsDafDetallesOrdens(null);
            } else {
                ((OrderRealmProxyInterface) obj).realmGet$lsDafDetallesOrdens().clear();
                JSONArray array = json.getJSONArray("lsDafDetallesOrdens");
                for (int i = 0; i < array.length(); i++) {
                    com.mobile.polux.models.ProductOrder item = ProductOrderRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((OrderRealmProxyInterface) obj).realmGet$lsDafDetallesOrdens().add(item);
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mobile.polux.models.Order createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.mobile.polux.models.Order obj = new com.mobile.polux.models.Order();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$id((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("numeroOrden")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$numeroOrden(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$numeroOrden((long) reader.nextLong());
                }
            } else if (name.equals("numeroOrdenAuxiliar")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$numeroOrdenAuxiliar(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$numeroOrdenAuxiliar((int) reader.nextInt());
                }
            } else if (name.equals("aprobada")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$aprobada(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$aprobada((String) reader.nextString());
                }
            } else if (name.equals("observaciones")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$observaciones(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$observaciones((String) reader.nextString());
                }
            } else if (name.equals("error")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$error(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$error((String) reader.nextString());
                }
            } else if (name.equals("codigoCliente")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'codigoCliente' to null.");
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoCliente((int) reader.nextInt());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("total")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'total' to null.");
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$total((double) reader.nextDouble());
                }
            } else if (name.equals("subtotal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'subtotal' to null.");
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$subtotal((double) reader.nextDouble());
                }
            } else if (name.equals("iva")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'iva' to null.");
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$iva((double) reader.nextDouble());
                }
            } else if (name.equals("discount")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'discount' to null.");
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$discount((double) reader.nextDouble());
                }
            } else if (name.equals("state")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$state(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$state((String) reader.nextString());
                }
            } else if (name.equals("approved")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'approved' to null.");
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$approved((boolean) reader.nextBoolean());
                }
            } else if (name.equals("fechaOrden")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$fechaOrden(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$fechaOrden((String) reader.nextString());
                }
            } else if (name.equals("codigoEmpresa")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$codigoEmpresa(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoEmpresa((int) reader.nextInt());
                }
            } else if (name.equals("codigoSucursal")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$codigoSucursal(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoSucursal((int) reader.nextInt());
                }
            } else if (name.equals("fechaEntrega")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$fechaEntrega(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$fechaEntrega((String) reader.nextString());
                }
            } else if (name.equals("fechaCompromisoPago")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$fechaCompromisoPago(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$fechaCompromisoPago((String) reader.nextString());
                }
            } else if (name.equals("codigoTipoVenta")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$codigoTipoVenta(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoTipoVenta((int) reader.nextInt());
                }
            } else if (name.equals("codigoEstado")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$codigoEstado(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoEstado((String) reader.nextString());
                }
            } else if (name.equals("observacion")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$observacion(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$observacion((String) reader.nextString());
                }
            } else if (name.equals("aplicaConsignacion")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$aplicaConsignacion(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$aplicaConsignacion((String) reader.nextString());
                }
            } else if (name.equals("codigoTipoOrden")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$codigoTipoOrden(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoTipoOrden((String) reader.nextString());
                }
            } else if (name.equals("aplicaFacturaSinStock")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$aplicaFacturaSinStock(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$aplicaFacturaSinStock((String) reader.nextString());
                }
            } else if (name.equals("codigoBodega")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$codigoBodega(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoBodega((int) reader.nextInt());
                }
            } else if (name.equals("usuarioIngreso")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$usuarioIngreso(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$usuarioIngreso((String) reader.nextString());
                }
            } else if (name.equals("codigoCuentaCliente")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$codigoCuentaCliente(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoCuentaCliente((int) reader.nextInt());
                }
            } else if (name.equals("codigoDivision")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$codigoDivision(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoDivision((int) reader.nextInt());
                }
            } else if (name.equals("codigoCuentaXDZV")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$codigoCuentaXDZV(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoCuentaXDZV((int) reader.nextInt());
                }
            } else if (name.equals("codigoLocalidad")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$codigoLocalidad(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$codigoLocalidad((int) reader.nextInt());
                }
            } else if (name.equals("lsDafDetallesOrdens")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((OrderRealmProxyInterface) obj).realmSet$lsDafDetallesOrdens(null);
                } else {
                    ((OrderRealmProxyInterface) obj).realmSet$lsDafDetallesOrdens(new RealmList<com.mobile.polux.models.ProductOrder>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.mobile.polux.models.ProductOrder item = ProductOrderRealmProxy.createUsingJsonStream(realm, reader);
                        ((OrderRealmProxyInterface) obj).realmGet$lsDafDetallesOrdens().add(item);
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

    public static com.mobile.polux.models.Order copyOrUpdate(Realm realm, com.mobile.polux.models.Order object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Order) cachedRealmObject;
        } else {
            com.mobile.polux.models.Order realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.mobile.polux.models.Order.class);
                long pkColumnIndex = table.getPrimaryKey();
                Number value = ((OrderRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstLong(pkColumnIndex, value.longValue());
                }
                if (rowIndex != Table.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.mobile.polux.models.Order.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.OrderRealmProxy();
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

    public static com.mobile.polux.models.Order copy(Realm realm, com.mobile.polux.models.Order newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mobile.polux.models.Order) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.mobile.polux.models.Order realmObject = realm.createObjectInternal(com.mobile.polux.models.Order.class, ((OrderRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((OrderRealmProxyInterface) realmObject).realmSet$numeroOrden(((OrderRealmProxyInterface) newObject).realmGet$numeroOrden());
            ((OrderRealmProxyInterface) realmObject).realmSet$numeroOrdenAuxiliar(((OrderRealmProxyInterface) newObject).realmGet$numeroOrdenAuxiliar());
            ((OrderRealmProxyInterface) realmObject).realmSet$aprobada(((OrderRealmProxyInterface) newObject).realmGet$aprobada());
            ((OrderRealmProxyInterface) realmObject).realmSet$observaciones(((OrderRealmProxyInterface) newObject).realmGet$observaciones());
            ((OrderRealmProxyInterface) realmObject).realmSet$error(((OrderRealmProxyInterface) newObject).realmGet$error());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoCliente(((OrderRealmProxyInterface) newObject).realmGet$codigoCliente());
            ((OrderRealmProxyInterface) realmObject).realmSet$name(((OrderRealmProxyInterface) newObject).realmGet$name());
            ((OrderRealmProxyInterface) realmObject).realmSet$total(((OrderRealmProxyInterface) newObject).realmGet$total());
            ((OrderRealmProxyInterface) realmObject).realmSet$subtotal(((OrderRealmProxyInterface) newObject).realmGet$subtotal());
            ((OrderRealmProxyInterface) realmObject).realmSet$iva(((OrderRealmProxyInterface) newObject).realmGet$iva());
            ((OrderRealmProxyInterface) realmObject).realmSet$discount(((OrderRealmProxyInterface) newObject).realmGet$discount());
            ((OrderRealmProxyInterface) realmObject).realmSet$state(((OrderRealmProxyInterface) newObject).realmGet$state());
            ((OrderRealmProxyInterface) realmObject).realmSet$approved(((OrderRealmProxyInterface) newObject).realmGet$approved());
            ((OrderRealmProxyInterface) realmObject).realmSet$fechaOrden(((OrderRealmProxyInterface) newObject).realmGet$fechaOrden());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoEmpresa(((OrderRealmProxyInterface) newObject).realmGet$codigoEmpresa());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoSucursal(((OrderRealmProxyInterface) newObject).realmGet$codigoSucursal());
            ((OrderRealmProxyInterface) realmObject).realmSet$fechaEntrega(((OrderRealmProxyInterface) newObject).realmGet$fechaEntrega());
            ((OrderRealmProxyInterface) realmObject).realmSet$fechaCompromisoPago(((OrderRealmProxyInterface) newObject).realmGet$fechaCompromisoPago());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoTipoVenta(((OrderRealmProxyInterface) newObject).realmGet$codigoTipoVenta());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoEstado(((OrderRealmProxyInterface) newObject).realmGet$codigoEstado());
            ((OrderRealmProxyInterface) realmObject).realmSet$observacion(((OrderRealmProxyInterface) newObject).realmGet$observacion());
            ((OrderRealmProxyInterface) realmObject).realmSet$aplicaConsignacion(((OrderRealmProxyInterface) newObject).realmGet$aplicaConsignacion());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoTipoOrden(((OrderRealmProxyInterface) newObject).realmGet$codigoTipoOrden());
            ((OrderRealmProxyInterface) realmObject).realmSet$aplicaFacturaSinStock(((OrderRealmProxyInterface) newObject).realmGet$aplicaFacturaSinStock());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoBodega(((OrderRealmProxyInterface) newObject).realmGet$codigoBodega());
            ((OrderRealmProxyInterface) realmObject).realmSet$usuarioIngreso(((OrderRealmProxyInterface) newObject).realmGet$usuarioIngreso());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoCuentaCliente(((OrderRealmProxyInterface) newObject).realmGet$codigoCuentaCliente());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoDivision(((OrderRealmProxyInterface) newObject).realmGet$codigoDivision());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoCuentaXDZV(((OrderRealmProxyInterface) newObject).realmGet$codigoCuentaXDZV());
            ((OrderRealmProxyInterface) realmObject).realmSet$codigoLocalidad(((OrderRealmProxyInterface) newObject).realmGet$codigoLocalidad());

            RealmList<com.mobile.polux.models.ProductOrder> lsDafDetallesOrdensList = ((OrderRealmProxyInterface) newObject).realmGet$lsDafDetallesOrdens();
            if (lsDafDetallesOrdensList != null) {
                RealmList<com.mobile.polux.models.ProductOrder> lsDafDetallesOrdensRealmList = ((OrderRealmProxyInterface) realmObject).realmGet$lsDafDetallesOrdens();
                for (int i = 0; i < lsDafDetallesOrdensList.size(); i++) {
                    com.mobile.polux.models.ProductOrder lsDafDetallesOrdensItem = lsDafDetallesOrdensList.get(i);
                    com.mobile.polux.models.ProductOrder cachelsDafDetallesOrdens = (com.mobile.polux.models.ProductOrder) cache.get(lsDafDetallesOrdensItem);
                    if (cachelsDafDetallesOrdens != null) {
                        lsDafDetallesOrdensRealmList.add(cachelsDafDetallesOrdens);
                    } else {
                        lsDafDetallesOrdensRealmList.add(ProductOrderRealmProxy.copyOrUpdate(realm, lsDafDetallesOrdensList.get(i), update, cache));
                    }
                }
            }

            return realmObject;
        }
    }

    public static long insert(Realm realm, com.mobile.polux.models.Order object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Order.class);
        long tableNativePtr = table.getNativePtr();
        OrderColumnInfo columnInfo = (OrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Order.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((OrderRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OrderRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((OrderRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Number realmGet$numeroOrden = ((OrderRealmProxyInterface)object).realmGet$numeroOrden();
        if (realmGet$numeroOrden != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.numeroOrdenIndex, rowIndex, realmGet$numeroOrden.longValue(), false);
        }
        Number realmGet$numeroOrdenAuxiliar = ((OrderRealmProxyInterface)object).realmGet$numeroOrdenAuxiliar();
        if (realmGet$numeroOrdenAuxiliar != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.numeroOrdenAuxiliarIndex, rowIndex, realmGet$numeroOrdenAuxiliar.longValue(), false);
        }
        String realmGet$aprobada = ((OrderRealmProxyInterface)object).realmGet$aprobada();
        if (realmGet$aprobada != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aprobadaIndex, rowIndex, realmGet$aprobada, false);
        }
        String realmGet$observaciones = ((OrderRealmProxyInterface)object).realmGet$observaciones();
        if (realmGet$observaciones != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.observacionesIndex, rowIndex, realmGet$observaciones, false);
        }
        String realmGet$error = ((OrderRealmProxyInterface)object).realmGet$error();
        if (realmGet$error != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.codigoClienteIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$codigoCliente(), false);
        String realmGet$name = ((OrderRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$total(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$subtotal(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$iva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$discount(), false);
        String realmGet$state = ((OrderRealmProxyInterface)object).realmGet$state();
        if (realmGet$state != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.approvedIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$approved(), false);
        String realmGet$fechaOrden = ((OrderRealmProxyInterface)object).realmGet$fechaOrden();
        if (realmGet$fechaOrden != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaOrdenIndex, rowIndex, realmGet$fechaOrden, false);
        }
        Number realmGet$codigoEmpresa = ((OrderRealmProxyInterface)object).realmGet$codigoEmpresa();
        if (realmGet$codigoEmpresa != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
        }
        Number realmGet$codigoSucursal = ((OrderRealmProxyInterface)object).realmGet$codigoSucursal();
        if (realmGet$codigoSucursal != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
        }
        String realmGet$fechaEntrega = ((OrderRealmProxyInterface)object).realmGet$fechaEntrega();
        if (realmGet$fechaEntrega != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaEntregaIndex, rowIndex, realmGet$fechaEntrega, false);
        }
        String realmGet$fechaCompromisoPago = ((OrderRealmProxyInterface)object).realmGet$fechaCompromisoPago();
        if (realmGet$fechaCompromisoPago != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaCompromisoPagoIndex, rowIndex, realmGet$fechaCompromisoPago, false);
        }
        Number realmGet$codigoTipoVenta = ((OrderRealmProxyInterface)object).realmGet$codigoTipoVenta();
        if (realmGet$codigoTipoVenta != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoTipoVentaIndex, rowIndex, realmGet$codigoTipoVenta.longValue(), false);
        }
        String realmGet$codigoEstado = ((OrderRealmProxyInterface)object).realmGet$codigoEstado();
        if (realmGet$codigoEstado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, realmGet$codigoEstado, false);
        }
        String realmGet$observacion = ((OrderRealmProxyInterface)object).realmGet$observacion();
        if (realmGet$observacion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.observacionIndex, rowIndex, realmGet$observacion, false);
        }
        String realmGet$aplicaConsignacion = ((OrderRealmProxyInterface)object).realmGet$aplicaConsignacion();
        if (realmGet$aplicaConsignacion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaConsignacionIndex, rowIndex, realmGet$aplicaConsignacion, false);
        }
        String realmGet$codigoTipoOrden = ((OrderRealmProxyInterface)object).realmGet$codigoTipoOrden();
        if (realmGet$codigoTipoOrden != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigoTipoOrdenIndex, rowIndex, realmGet$codigoTipoOrden, false);
        }
        String realmGet$aplicaFacturaSinStock = ((OrderRealmProxyInterface)object).realmGet$aplicaFacturaSinStock();
        if (realmGet$aplicaFacturaSinStock != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaFacturaSinStockIndex, rowIndex, realmGet$aplicaFacturaSinStock, false);
        }
        Number realmGet$codigoBodega = ((OrderRealmProxyInterface)object).realmGet$codigoBodega();
        if (realmGet$codigoBodega != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoBodegaIndex, rowIndex, realmGet$codigoBodega.longValue(), false);
        }
        String realmGet$usuarioIngreso = ((OrderRealmProxyInterface)object).realmGet$usuarioIngreso();
        if (realmGet$usuarioIngreso != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
        }
        Number realmGet$codigoCuentaCliente = ((OrderRealmProxyInterface)object).realmGet$codigoCuentaCliente();
        if (realmGet$codigoCuentaCliente != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoCuentaClienteIndex, rowIndex, realmGet$codigoCuentaCliente.longValue(), false);
        }
        Number realmGet$codigoDivision = ((OrderRealmProxyInterface)object).realmGet$codigoDivision();
        if (realmGet$codigoDivision != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoDivisionIndex, rowIndex, realmGet$codigoDivision.longValue(), false);
        }
        Number realmGet$codigoCuentaXDZV = ((OrderRealmProxyInterface)object).realmGet$codigoCuentaXDZV();
        if (realmGet$codigoCuentaXDZV != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoCuentaXDZVIndex, rowIndex, realmGet$codigoCuentaXDZV.longValue(), false);
        }
        Number realmGet$codigoLocalidad = ((OrderRealmProxyInterface)object).realmGet$codigoLocalidad();
        if (realmGet$codigoLocalidad != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, realmGet$codigoLocalidad.longValue(), false);
        }

        RealmList<com.mobile.polux.models.ProductOrder> lsDafDetallesOrdensList = ((OrderRealmProxyInterface) object).realmGet$lsDafDetallesOrdens();
        if (lsDafDetallesOrdensList != null) {
            long lsDafDetallesOrdensNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.lsDafDetallesOrdensIndex, rowIndex);
            for (com.mobile.polux.models.ProductOrder lsDafDetallesOrdensItem : lsDafDetallesOrdensList) {
                Long cacheItemIndexlsDafDetallesOrdens = cache.get(lsDafDetallesOrdensItem);
                if (cacheItemIndexlsDafDetallesOrdens == null) {
                    cacheItemIndexlsDafDetallesOrdens = ProductOrderRealmProxy.insert(realm, lsDafDetallesOrdensItem, cache);
                }
                LinkView.nativeAdd(lsDafDetallesOrdensNativeLinkViewPtr, cacheItemIndexlsDafDetallesOrdens);
            }
        }

        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Order.class);
        long tableNativePtr = table.getNativePtr();
        OrderColumnInfo columnInfo = (OrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Order.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Order object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Order) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((OrderRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OrderRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((OrderRealmProxyInterface) object).realmGet$id());
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Number realmGet$numeroOrden = ((OrderRealmProxyInterface)object).realmGet$numeroOrden();
                if (realmGet$numeroOrden != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.numeroOrdenIndex, rowIndex, realmGet$numeroOrden.longValue(), false);
                }
                Number realmGet$numeroOrdenAuxiliar = ((OrderRealmProxyInterface)object).realmGet$numeroOrdenAuxiliar();
                if (realmGet$numeroOrdenAuxiliar != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.numeroOrdenAuxiliarIndex, rowIndex, realmGet$numeroOrdenAuxiliar.longValue(), false);
                }
                String realmGet$aprobada = ((OrderRealmProxyInterface)object).realmGet$aprobada();
                if (realmGet$aprobada != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aprobadaIndex, rowIndex, realmGet$aprobada, false);
                }
                String realmGet$observaciones = ((OrderRealmProxyInterface)object).realmGet$observaciones();
                if (realmGet$observaciones != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.observacionesIndex, rowIndex, realmGet$observaciones, false);
                }
                String realmGet$error = ((OrderRealmProxyInterface)object).realmGet$error();
                if (realmGet$error != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.codigoClienteIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$codigoCliente(), false);
                String realmGet$name = ((OrderRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$total(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$subtotal(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$iva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$discount(), false);
                String realmGet$state = ((OrderRealmProxyInterface)object).realmGet$state();
                if (realmGet$state != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.approvedIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$approved(), false);
                String realmGet$fechaOrden = ((OrderRealmProxyInterface)object).realmGet$fechaOrden();
                if (realmGet$fechaOrden != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaOrdenIndex, rowIndex, realmGet$fechaOrden, false);
                }
                Number realmGet$codigoEmpresa = ((OrderRealmProxyInterface)object).realmGet$codigoEmpresa();
                if (realmGet$codigoEmpresa != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
                }
                Number realmGet$codigoSucursal = ((OrderRealmProxyInterface)object).realmGet$codigoSucursal();
                if (realmGet$codigoSucursal != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
                }
                String realmGet$fechaEntrega = ((OrderRealmProxyInterface)object).realmGet$fechaEntrega();
                if (realmGet$fechaEntrega != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaEntregaIndex, rowIndex, realmGet$fechaEntrega, false);
                }
                String realmGet$fechaCompromisoPago = ((OrderRealmProxyInterface)object).realmGet$fechaCompromisoPago();
                if (realmGet$fechaCompromisoPago != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaCompromisoPagoIndex, rowIndex, realmGet$fechaCompromisoPago, false);
                }
                Number realmGet$codigoTipoVenta = ((OrderRealmProxyInterface)object).realmGet$codigoTipoVenta();
                if (realmGet$codigoTipoVenta != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoTipoVentaIndex, rowIndex, realmGet$codigoTipoVenta.longValue(), false);
                }
                String realmGet$codigoEstado = ((OrderRealmProxyInterface)object).realmGet$codigoEstado();
                if (realmGet$codigoEstado != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, realmGet$codigoEstado, false);
                }
                String realmGet$observacion = ((OrderRealmProxyInterface)object).realmGet$observacion();
                if (realmGet$observacion != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.observacionIndex, rowIndex, realmGet$observacion, false);
                }
                String realmGet$aplicaConsignacion = ((OrderRealmProxyInterface)object).realmGet$aplicaConsignacion();
                if (realmGet$aplicaConsignacion != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaConsignacionIndex, rowIndex, realmGet$aplicaConsignacion, false);
                }
                String realmGet$codigoTipoOrden = ((OrderRealmProxyInterface)object).realmGet$codigoTipoOrden();
                if (realmGet$codigoTipoOrden != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codigoTipoOrdenIndex, rowIndex, realmGet$codigoTipoOrden, false);
                }
                String realmGet$aplicaFacturaSinStock = ((OrderRealmProxyInterface)object).realmGet$aplicaFacturaSinStock();
                if (realmGet$aplicaFacturaSinStock != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaFacturaSinStockIndex, rowIndex, realmGet$aplicaFacturaSinStock, false);
                }
                Number realmGet$codigoBodega = ((OrderRealmProxyInterface)object).realmGet$codigoBodega();
                if (realmGet$codigoBodega != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoBodegaIndex, rowIndex, realmGet$codigoBodega.longValue(), false);
                }
                String realmGet$usuarioIngreso = ((OrderRealmProxyInterface)object).realmGet$usuarioIngreso();
                if (realmGet$usuarioIngreso != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
                }
                Number realmGet$codigoCuentaCliente = ((OrderRealmProxyInterface)object).realmGet$codigoCuentaCliente();
                if (realmGet$codigoCuentaCliente != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoCuentaClienteIndex, rowIndex, realmGet$codigoCuentaCliente.longValue(), false);
                }
                Number realmGet$codigoDivision = ((OrderRealmProxyInterface)object).realmGet$codigoDivision();
                if (realmGet$codigoDivision != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoDivisionIndex, rowIndex, realmGet$codigoDivision.longValue(), false);
                }
                Number realmGet$codigoCuentaXDZV = ((OrderRealmProxyInterface)object).realmGet$codigoCuentaXDZV();
                if (realmGet$codigoCuentaXDZV != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoCuentaXDZVIndex, rowIndex, realmGet$codigoCuentaXDZV.longValue(), false);
                }
                Number realmGet$codigoLocalidad = ((OrderRealmProxyInterface)object).realmGet$codigoLocalidad();
                if (realmGet$codigoLocalidad != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, realmGet$codigoLocalidad.longValue(), false);
                }

                RealmList<com.mobile.polux.models.ProductOrder> lsDafDetallesOrdensList = ((OrderRealmProxyInterface) object).realmGet$lsDafDetallesOrdens();
                if (lsDafDetallesOrdensList != null) {
                    long lsDafDetallesOrdensNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.lsDafDetallesOrdensIndex, rowIndex);
                    for (com.mobile.polux.models.ProductOrder lsDafDetallesOrdensItem : lsDafDetallesOrdensList) {
                        Long cacheItemIndexlsDafDetallesOrdens = cache.get(lsDafDetallesOrdensItem);
                        if (cacheItemIndexlsDafDetallesOrdens == null) {
                            cacheItemIndexlsDafDetallesOrdens = ProductOrderRealmProxy.insert(realm, lsDafDetallesOrdensItem, cache);
                        }
                        LinkView.nativeAdd(lsDafDetallesOrdensNativeLinkViewPtr, cacheItemIndexlsDafDetallesOrdens);
                    }
                }

            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mobile.polux.models.Order object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mobile.polux.models.Order.class);
        long tableNativePtr = table.getNativePtr();
        OrderColumnInfo columnInfo = (OrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Order.class);
        long pkColumnIndex = table.getPrimaryKey();
        Object primaryKeyValue = ((OrderRealmProxyInterface) object).realmGet$id();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OrderRealmProxyInterface) object).realmGet$id());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((OrderRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, rowIndex);
        Number realmGet$numeroOrden = ((OrderRealmProxyInterface)object).realmGet$numeroOrden();
        if (realmGet$numeroOrden != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.numeroOrdenIndex, rowIndex, realmGet$numeroOrden.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numeroOrdenIndex, rowIndex, false);
        }
        Number realmGet$numeroOrdenAuxiliar = ((OrderRealmProxyInterface)object).realmGet$numeroOrdenAuxiliar();
        if (realmGet$numeroOrdenAuxiliar != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.numeroOrdenAuxiliarIndex, rowIndex, realmGet$numeroOrdenAuxiliar.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numeroOrdenAuxiliarIndex, rowIndex, false);
        }
        String realmGet$aprobada = ((OrderRealmProxyInterface)object).realmGet$aprobada();
        if (realmGet$aprobada != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aprobadaIndex, rowIndex, realmGet$aprobada, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.aprobadaIndex, rowIndex, false);
        }
        String realmGet$observaciones = ((OrderRealmProxyInterface)object).realmGet$observaciones();
        if (realmGet$observaciones != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.observacionesIndex, rowIndex, realmGet$observaciones, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.observacionesIndex, rowIndex, false);
        }
        String realmGet$error = ((OrderRealmProxyInterface)object).realmGet$error();
        if (realmGet$error != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.errorIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.codigoClienteIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$codigoCliente(), false);
        String realmGet$name = ((OrderRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$total(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$subtotal(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$iva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$discount(), false);
        String realmGet$state = ((OrderRealmProxyInterface)object).realmGet$state();
        if (realmGet$state != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.stateIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.approvedIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$approved(), false);
        String realmGet$fechaOrden = ((OrderRealmProxyInterface)object).realmGet$fechaOrden();
        if (realmGet$fechaOrden != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaOrdenIndex, rowIndex, realmGet$fechaOrden, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaOrdenIndex, rowIndex, false);
        }
        Number realmGet$codigoEmpresa = ((OrderRealmProxyInterface)object).realmGet$codigoEmpresa();
        if (realmGet$codigoEmpresa != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, false);
        }
        Number realmGet$codigoSucursal = ((OrderRealmProxyInterface)object).realmGet$codigoSucursal();
        if (realmGet$codigoSucursal != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, false);
        }
        String realmGet$fechaEntrega = ((OrderRealmProxyInterface)object).realmGet$fechaEntrega();
        if (realmGet$fechaEntrega != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaEntregaIndex, rowIndex, realmGet$fechaEntrega, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaEntregaIndex, rowIndex, false);
        }
        String realmGet$fechaCompromisoPago = ((OrderRealmProxyInterface)object).realmGet$fechaCompromisoPago();
        if (realmGet$fechaCompromisoPago != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fechaCompromisoPagoIndex, rowIndex, realmGet$fechaCompromisoPago, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaCompromisoPagoIndex, rowIndex, false);
        }
        Number realmGet$codigoTipoVenta = ((OrderRealmProxyInterface)object).realmGet$codigoTipoVenta();
        if (realmGet$codigoTipoVenta != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoTipoVentaIndex, rowIndex, realmGet$codigoTipoVenta.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoTipoVentaIndex, rowIndex, false);
        }
        String realmGet$codigoEstado = ((OrderRealmProxyInterface)object).realmGet$codigoEstado();
        if (realmGet$codigoEstado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, realmGet$codigoEstado, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, false);
        }
        String realmGet$observacion = ((OrderRealmProxyInterface)object).realmGet$observacion();
        if (realmGet$observacion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.observacionIndex, rowIndex, realmGet$observacion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.observacionIndex, rowIndex, false);
        }
        String realmGet$aplicaConsignacion = ((OrderRealmProxyInterface)object).realmGet$aplicaConsignacion();
        if (realmGet$aplicaConsignacion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaConsignacionIndex, rowIndex, realmGet$aplicaConsignacion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.aplicaConsignacionIndex, rowIndex, false);
        }
        String realmGet$codigoTipoOrden = ((OrderRealmProxyInterface)object).realmGet$codigoTipoOrden();
        if (realmGet$codigoTipoOrden != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigoTipoOrdenIndex, rowIndex, realmGet$codigoTipoOrden, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoTipoOrdenIndex, rowIndex, false);
        }
        String realmGet$aplicaFacturaSinStock = ((OrderRealmProxyInterface)object).realmGet$aplicaFacturaSinStock();
        if (realmGet$aplicaFacturaSinStock != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.aplicaFacturaSinStockIndex, rowIndex, realmGet$aplicaFacturaSinStock, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.aplicaFacturaSinStockIndex, rowIndex, false);
        }
        Number realmGet$codigoBodega = ((OrderRealmProxyInterface)object).realmGet$codigoBodega();
        if (realmGet$codigoBodega != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoBodegaIndex, rowIndex, realmGet$codigoBodega.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoBodegaIndex, rowIndex, false);
        }
        String realmGet$usuarioIngreso = ((OrderRealmProxyInterface)object).realmGet$usuarioIngreso();
        if (realmGet$usuarioIngreso != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, false);
        }
        Number realmGet$codigoCuentaCliente = ((OrderRealmProxyInterface)object).realmGet$codigoCuentaCliente();
        if (realmGet$codigoCuentaCliente != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoCuentaClienteIndex, rowIndex, realmGet$codigoCuentaCliente.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoCuentaClienteIndex, rowIndex, false);
        }
        Number realmGet$codigoDivision = ((OrderRealmProxyInterface)object).realmGet$codigoDivision();
        if (realmGet$codigoDivision != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoDivisionIndex, rowIndex, realmGet$codigoDivision.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoDivisionIndex, rowIndex, false);
        }
        Number realmGet$codigoCuentaXDZV = ((OrderRealmProxyInterface)object).realmGet$codigoCuentaXDZV();
        if (realmGet$codigoCuentaXDZV != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoCuentaXDZVIndex, rowIndex, realmGet$codigoCuentaXDZV.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoCuentaXDZVIndex, rowIndex, false);
        }
        Number realmGet$codigoLocalidad = ((OrderRealmProxyInterface)object).realmGet$codigoLocalidad();
        if (realmGet$codigoLocalidad != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, realmGet$codigoLocalidad.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, false);
        }

        long lsDafDetallesOrdensNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.lsDafDetallesOrdensIndex, rowIndex);
        LinkView.nativeClear(lsDafDetallesOrdensNativeLinkViewPtr);
        RealmList<com.mobile.polux.models.ProductOrder> lsDafDetallesOrdensList = ((OrderRealmProxyInterface) object).realmGet$lsDafDetallesOrdens();
        if (lsDafDetallesOrdensList != null) {
            for (com.mobile.polux.models.ProductOrder lsDafDetallesOrdensItem : lsDafDetallesOrdensList) {
                Long cacheItemIndexlsDafDetallesOrdens = cache.get(lsDafDetallesOrdensItem);
                if (cacheItemIndexlsDafDetallesOrdens == null) {
                    cacheItemIndexlsDafDetallesOrdens = ProductOrderRealmProxy.insertOrUpdate(realm, lsDafDetallesOrdensItem, cache);
                }
                LinkView.nativeAdd(lsDafDetallesOrdensNativeLinkViewPtr, cacheItemIndexlsDafDetallesOrdens);
            }
        }

        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mobile.polux.models.Order.class);
        long tableNativePtr = table.getNativePtr();
        OrderColumnInfo columnInfo = (OrderColumnInfo) realm.schema.getColumnInfo(com.mobile.polux.models.Order.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.mobile.polux.models.Order object = null;
        while (objects.hasNext()) {
            object = (com.mobile.polux.models.Order) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                Object primaryKeyValue = ((OrderRealmProxyInterface) object).realmGet$id();
                long rowIndex = Table.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((OrderRealmProxyInterface) object).realmGet$id());
                }
                if (rowIndex == Table.NO_MATCH) {
                    rowIndex = OsObject.createRowWithPrimaryKey(realm.sharedRealm, table, ((OrderRealmProxyInterface) object).realmGet$id());
                }
                cache.put(object, rowIndex);
                Number realmGet$numeroOrden = ((OrderRealmProxyInterface)object).realmGet$numeroOrden();
                if (realmGet$numeroOrden != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.numeroOrdenIndex, rowIndex, realmGet$numeroOrden.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.numeroOrdenIndex, rowIndex, false);
                }
                Number realmGet$numeroOrdenAuxiliar = ((OrderRealmProxyInterface)object).realmGet$numeroOrdenAuxiliar();
                if (realmGet$numeroOrdenAuxiliar != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.numeroOrdenAuxiliarIndex, rowIndex, realmGet$numeroOrdenAuxiliar.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.numeroOrdenAuxiliarIndex, rowIndex, false);
                }
                String realmGet$aprobada = ((OrderRealmProxyInterface)object).realmGet$aprobada();
                if (realmGet$aprobada != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aprobadaIndex, rowIndex, realmGet$aprobada, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.aprobadaIndex, rowIndex, false);
                }
                String realmGet$observaciones = ((OrderRealmProxyInterface)object).realmGet$observaciones();
                if (realmGet$observaciones != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.observacionesIndex, rowIndex, realmGet$observaciones, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.observacionesIndex, rowIndex, false);
                }
                String realmGet$error = ((OrderRealmProxyInterface)object).realmGet$error();
                if (realmGet$error != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.errorIndex, rowIndex, realmGet$error, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.errorIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.codigoClienteIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$codigoCliente(), false);
                String realmGet$name = ((OrderRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                Table.nativeSetDouble(tableNativePtr, columnInfo.totalIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$total(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.subtotalIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$subtotal(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.ivaIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$iva(), false);
                Table.nativeSetDouble(tableNativePtr, columnInfo.discountIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$discount(), false);
                String realmGet$state = ((OrderRealmProxyInterface)object).realmGet$state();
                if (realmGet$state != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.stateIndex, rowIndex, realmGet$state, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.stateIndex, rowIndex, false);
                }
                Table.nativeSetBoolean(tableNativePtr, columnInfo.approvedIndex, rowIndex, ((OrderRealmProxyInterface)object).realmGet$approved(), false);
                String realmGet$fechaOrden = ((OrderRealmProxyInterface)object).realmGet$fechaOrden();
                if (realmGet$fechaOrden != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaOrdenIndex, rowIndex, realmGet$fechaOrden, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.fechaOrdenIndex, rowIndex, false);
                }
                Number realmGet$codigoEmpresa = ((OrderRealmProxyInterface)object).realmGet$codigoEmpresa();
                if (realmGet$codigoEmpresa != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, realmGet$codigoEmpresa.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoEmpresaIndex, rowIndex, false);
                }
                Number realmGet$codigoSucursal = ((OrderRealmProxyInterface)object).realmGet$codigoSucursal();
                if (realmGet$codigoSucursal != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, realmGet$codigoSucursal.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoSucursalIndex, rowIndex, false);
                }
                String realmGet$fechaEntrega = ((OrderRealmProxyInterface)object).realmGet$fechaEntrega();
                if (realmGet$fechaEntrega != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaEntregaIndex, rowIndex, realmGet$fechaEntrega, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.fechaEntregaIndex, rowIndex, false);
                }
                String realmGet$fechaCompromisoPago = ((OrderRealmProxyInterface)object).realmGet$fechaCompromisoPago();
                if (realmGet$fechaCompromisoPago != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.fechaCompromisoPagoIndex, rowIndex, realmGet$fechaCompromisoPago, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.fechaCompromisoPagoIndex, rowIndex, false);
                }
                Number realmGet$codigoTipoVenta = ((OrderRealmProxyInterface)object).realmGet$codigoTipoVenta();
                if (realmGet$codigoTipoVenta != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoTipoVentaIndex, rowIndex, realmGet$codigoTipoVenta.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoTipoVentaIndex, rowIndex, false);
                }
                String realmGet$codigoEstado = ((OrderRealmProxyInterface)object).realmGet$codigoEstado();
                if (realmGet$codigoEstado != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, realmGet$codigoEstado, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoEstadoIndex, rowIndex, false);
                }
                String realmGet$observacion = ((OrderRealmProxyInterface)object).realmGet$observacion();
                if (realmGet$observacion != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.observacionIndex, rowIndex, realmGet$observacion, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.observacionIndex, rowIndex, false);
                }
                String realmGet$aplicaConsignacion = ((OrderRealmProxyInterface)object).realmGet$aplicaConsignacion();
                if (realmGet$aplicaConsignacion != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaConsignacionIndex, rowIndex, realmGet$aplicaConsignacion, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.aplicaConsignacionIndex, rowIndex, false);
                }
                String realmGet$codigoTipoOrden = ((OrderRealmProxyInterface)object).realmGet$codigoTipoOrden();
                if (realmGet$codigoTipoOrden != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.codigoTipoOrdenIndex, rowIndex, realmGet$codigoTipoOrden, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoTipoOrdenIndex, rowIndex, false);
                }
                String realmGet$aplicaFacturaSinStock = ((OrderRealmProxyInterface)object).realmGet$aplicaFacturaSinStock();
                if (realmGet$aplicaFacturaSinStock != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.aplicaFacturaSinStockIndex, rowIndex, realmGet$aplicaFacturaSinStock, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.aplicaFacturaSinStockIndex, rowIndex, false);
                }
                Number realmGet$codigoBodega = ((OrderRealmProxyInterface)object).realmGet$codigoBodega();
                if (realmGet$codigoBodega != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoBodegaIndex, rowIndex, realmGet$codigoBodega.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoBodegaIndex, rowIndex, false);
                }
                String realmGet$usuarioIngreso = ((OrderRealmProxyInterface)object).realmGet$usuarioIngreso();
                if (realmGet$usuarioIngreso != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, realmGet$usuarioIngreso, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.usuarioIngresoIndex, rowIndex, false);
                }
                Number realmGet$codigoCuentaCliente = ((OrderRealmProxyInterface)object).realmGet$codigoCuentaCliente();
                if (realmGet$codigoCuentaCliente != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoCuentaClienteIndex, rowIndex, realmGet$codigoCuentaCliente.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoCuentaClienteIndex, rowIndex, false);
                }
                Number realmGet$codigoDivision = ((OrderRealmProxyInterface)object).realmGet$codigoDivision();
                if (realmGet$codigoDivision != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoDivisionIndex, rowIndex, realmGet$codigoDivision.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoDivisionIndex, rowIndex, false);
                }
                Number realmGet$codigoCuentaXDZV = ((OrderRealmProxyInterface)object).realmGet$codigoCuentaXDZV();
                if (realmGet$codigoCuentaXDZV != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoCuentaXDZVIndex, rowIndex, realmGet$codigoCuentaXDZV.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoCuentaXDZVIndex, rowIndex, false);
                }
                Number realmGet$codigoLocalidad = ((OrderRealmProxyInterface)object).realmGet$codigoLocalidad();
                if (realmGet$codigoLocalidad != null) {
                    Table.nativeSetLong(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, realmGet$codigoLocalidad.longValue(), false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.codigoLocalidadIndex, rowIndex, false);
                }

                long lsDafDetallesOrdensNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.lsDafDetallesOrdensIndex, rowIndex);
                LinkView.nativeClear(lsDafDetallesOrdensNativeLinkViewPtr);
                RealmList<com.mobile.polux.models.ProductOrder> lsDafDetallesOrdensList = ((OrderRealmProxyInterface) object).realmGet$lsDafDetallesOrdens();
                if (lsDafDetallesOrdensList != null) {
                    for (com.mobile.polux.models.ProductOrder lsDafDetallesOrdensItem : lsDafDetallesOrdensList) {
                        Long cacheItemIndexlsDafDetallesOrdens = cache.get(lsDafDetallesOrdensItem);
                        if (cacheItemIndexlsDafDetallesOrdens == null) {
                            cacheItemIndexlsDafDetallesOrdens = ProductOrderRealmProxy.insertOrUpdate(realm, lsDafDetallesOrdensItem, cache);
                        }
                        LinkView.nativeAdd(lsDafDetallesOrdensNativeLinkViewPtr, cacheItemIndexlsDafDetallesOrdens);
                    }
                }

            }
        }
    }

    public static com.mobile.polux.models.Order createDetachedCopy(com.mobile.polux.models.Order realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mobile.polux.models.Order unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mobile.polux.models.Order)cachedObject.object;
            } else {
                unmanagedObject = (com.mobile.polux.models.Order)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.mobile.polux.models.Order();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        }
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$id(((OrderRealmProxyInterface) realmObject).realmGet$id());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$numeroOrden(((OrderRealmProxyInterface) realmObject).realmGet$numeroOrden());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$numeroOrdenAuxiliar(((OrderRealmProxyInterface) realmObject).realmGet$numeroOrdenAuxiliar());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$aprobada(((OrderRealmProxyInterface) realmObject).realmGet$aprobada());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$observaciones(((OrderRealmProxyInterface) realmObject).realmGet$observaciones());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$error(((OrderRealmProxyInterface) realmObject).realmGet$error());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoCliente(((OrderRealmProxyInterface) realmObject).realmGet$codigoCliente());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$name(((OrderRealmProxyInterface) realmObject).realmGet$name());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$total(((OrderRealmProxyInterface) realmObject).realmGet$total());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$subtotal(((OrderRealmProxyInterface) realmObject).realmGet$subtotal());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$iva(((OrderRealmProxyInterface) realmObject).realmGet$iva());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$discount(((OrderRealmProxyInterface) realmObject).realmGet$discount());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$state(((OrderRealmProxyInterface) realmObject).realmGet$state());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$approved(((OrderRealmProxyInterface) realmObject).realmGet$approved());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$fechaOrden(((OrderRealmProxyInterface) realmObject).realmGet$fechaOrden());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoEmpresa(((OrderRealmProxyInterface) realmObject).realmGet$codigoEmpresa());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoSucursal(((OrderRealmProxyInterface) realmObject).realmGet$codigoSucursal());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$fechaEntrega(((OrderRealmProxyInterface) realmObject).realmGet$fechaEntrega());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$fechaCompromisoPago(((OrderRealmProxyInterface) realmObject).realmGet$fechaCompromisoPago());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoTipoVenta(((OrderRealmProxyInterface) realmObject).realmGet$codigoTipoVenta());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoEstado(((OrderRealmProxyInterface) realmObject).realmGet$codigoEstado());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$observacion(((OrderRealmProxyInterface) realmObject).realmGet$observacion());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$aplicaConsignacion(((OrderRealmProxyInterface) realmObject).realmGet$aplicaConsignacion());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoTipoOrden(((OrderRealmProxyInterface) realmObject).realmGet$codigoTipoOrden());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$aplicaFacturaSinStock(((OrderRealmProxyInterface) realmObject).realmGet$aplicaFacturaSinStock());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoBodega(((OrderRealmProxyInterface) realmObject).realmGet$codigoBodega());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$usuarioIngreso(((OrderRealmProxyInterface) realmObject).realmGet$usuarioIngreso());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoCuentaCliente(((OrderRealmProxyInterface) realmObject).realmGet$codigoCuentaCliente());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoDivision(((OrderRealmProxyInterface) realmObject).realmGet$codigoDivision());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoCuentaXDZV(((OrderRealmProxyInterface) realmObject).realmGet$codigoCuentaXDZV());
        ((OrderRealmProxyInterface) unmanagedObject).realmSet$codigoLocalidad(((OrderRealmProxyInterface) realmObject).realmGet$codigoLocalidad());

        // Deep copy of lsDafDetallesOrdens
        if (currentDepth == maxDepth) {
            ((OrderRealmProxyInterface) unmanagedObject).realmSet$lsDafDetallesOrdens(null);
        } else {
            RealmList<com.mobile.polux.models.ProductOrder> managedlsDafDetallesOrdensList = ((OrderRealmProxyInterface) realmObject).realmGet$lsDafDetallesOrdens();
            RealmList<com.mobile.polux.models.ProductOrder> unmanagedlsDafDetallesOrdensList = new RealmList<com.mobile.polux.models.ProductOrder>();
            ((OrderRealmProxyInterface) unmanagedObject).realmSet$lsDafDetallesOrdens(unmanagedlsDafDetallesOrdensList);
            int nextDepth = currentDepth + 1;
            int size = managedlsDafDetallesOrdensList.size();
            for (int i = 0; i < size; i++) {
                com.mobile.polux.models.ProductOrder item = ProductOrderRealmProxy.createDetachedCopy(managedlsDafDetallesOrdensList.get(i), nextDepth, maxDepth, cache);
                unmanagedlsDafDetallesOrdensList.add(item);
            }
        }
        return unmanagedObject;
    }

    static com.mobile.polux.models.Order update(Realm realm, com.mobile.polux.models.Order realmObject, com.mobile.polux.models.Order newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((OrderRealmProxyInterface) realmObject).realmSet$numeroOrden(((OrderRealmProxyInterface) newObject).realmGet$numeroOrden());
        ((OrderRealmProxyInterface) realmObject).realmSet$numeroOrdenAuxiliar(((OrderRealmProxyInterface) newObject).realmGet$numeroOrdenAuxiliar());
        ((OrderRealmProxyInterface) realmObject).realmSet$aprobada(((OrderRealmProxyInterface) newObject).realmGet$aprobada());
        ((OrderRealmProxyInterface) realmObject).realmSet$observaciones(((OrderRealmProxyInterface) newObject).realmGet$observaciones());
        ((OrderRealmProxyInterface) realmObject).realmSet$error(((OrderRealmProxyInterface) newObject).realmGet$error());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoCliente(((OrderRealmProxyInterface) newObject).realmGet$codigoCliente());
        ((OrderRealmProxyInterface) realmObject).realmSet$name(((OrderRealmProxyInterface) newObject).realmGet$name());
        ((OrderRealmProxyInterface) realmObject).realmSet$total(((OrderRealmProxyInterface) newObject).realmGet$total());
        ((OrderRealmProxyInterface) realmObject).realmSet$subtotal(((OrderRealmProxyInterface) newObject).realmGet$subtotal());
        ((OrderRealmProxyInterface) realmObject).realmSet$iva(((OrderRealmProxyInterface) newObject).realmGet$iva());
        ((OrderRealmProxyInterface) realmObject).realmSet$discount(((OrderRealmProxyInterface) newObject).realmGet$discount());
        ((OrderRealmProxyInterface) realmObject).realmSet$state(((OrderRealmProxyInterface) newObject).realmGet$state());
        ((OrderRealmProxyInterface) realmObject).realmSet$approved(((OrderRealmProxyInterface) newObject).realmGet$approved());
        ((OrderRealmProxyInterface) realmObject).realmSet$fechaOrden(((OrderRealmProxyInterface) newObject).realmGet$fechaOrden());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoEmpresa(((OrderRealmProxyInterface) newObject).realmGet$codigoEmpresa());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoSucursal(((OrderRealmProxyInterface) newObject).realmGet$codigoSucursal());
        ((OrderRealmProxyInterface) realmObject).realmSet$fechaEntrega(((OrderRealmProxyInterface) newObject).realmGet$fechaEntrega());
        ((OrderRealmProxyInterface) realmObject).realmSet$fechaCompromisoPago(((OrderRealmProxyInterface) newObject).realmGet$fechaCompromisoPago());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoTipoVenta(((OrderRealmProxyInterface) newObject).realmGet$codigoTipoVenta());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoEstado(((OrderRealmProxyInterface) newObject).realmGet$codigoEstado());
        ((OrderRealmProxyInterface) realmObject).realmSet$observacion(((OrderRealmProxyInterface) newObject).realmGet$observacion());
        ((OrderRealmProxyInterface) realmObject).realmSet$aplicaConsignacion(((OrderRealmProxyInterface) newObject).realmGet$aplicaConsignacion());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoTipoOrden(((OrderRealmProxyInterface) newObject).realmGet$codigoTipoOrden());
        ((OrderRealmProxyInterface) realmObject).realmSet$aplicaFacturaSinStock(((OrderRealmProxyInterface) newObject).realmGet$aplicaFacturaSinStock());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoBodega(((OrderRealmProxyInterface) newObject).realmGet$codigoBodega());
        ((OrderRealmProxyInterface) realmObject).realmSet$usuarioIngreso(((OrderRealmProxyInterface) newObject).realmGet$usuarioIngreso());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoCuentaCliente(((OrderRealmProxyInterface) newObject).realmGet$codigoCuentaCliente());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoDivision(((OrderRealmProxyInterface) newObject).realmGet$codigoDivision());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoCuentaXDZV(((OrderRealmProxyInterface) newObject).realmGet$codigoCuentaXDZV());
        ((OrderRealmProxyInterface) realmObject).realmSet$codigoLocalidad(((OrderRealmProxyInterface) newObject).realmGet$codigoLocalidad());
        RealmList<com.mobile.polux.models.ProductOrder> lsDafDetallesOrdensList = ((OrderRealmProxyInterface) newObject).realmGet$lsDafDetallesOrdens();
        RealmList<com.mobile.polux.models.ProductOrder> lsDafDetallesOrdensRealmList = ((OrderRealmProxyInterface) realmObject).realmGet$lsDafDetallesOrdens();
        lsDafDetallesOrdensRealmList.clear();
        if (lsDafDetallesOrdensList != null) {
            for (int i = 0; i < lsDafDetallesOrdensList.size(); i++) {
                com.mobile.polux.models.ProductOrder lsDafDetallesOrdensItem = lsDafDetallesOrdensList.get(i);
                com.mobile.polux.models.ProductOrder cachelsDafDetallesOrdens = (com.mobile.polux.models.ProductOrder) cache.get(lsDafDetallesOrdensItem);
                if (cachelsDafDetallesOrdens != null) {
                    lsDafDetallesOrdensRealmList.add(cachelsDafDetallesOrdens);
                } else {
                    lsDafDetallesOrdensRealmList.add(ProductOrderRealmProxy.copyOrUpdate(realm, lsDafDetallesOrdensList.get(i), true, cache));
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
        StringBuilder stringBuilder = new StringBuilder("Order = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numeroOrden:");
        stringBuilder.append(realmGet$numeroOrden() != null ? realmGet$numeroOrden() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numeroOrdenAuxiliar:");
        stringBuilder.append(realmGet$numeroOrdenAuxiliar() != null ? realmGet$numeroOrdenAuxiliar() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aprobada:");
        stringBuilder.append(realmGet$aprobada() != null ? realmGet$aprobada() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{observaciones:");
        stringBuilder.append(realmGet$observaciones() != null ? realmGet$observaciones() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{error:");
        stringBuilder.append(realmGet$error() != null ? realmGet$error() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoCliente:");
        stringBuilder.append(realmGet$codigoCliente());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{total:");
        stringBuilder.append(realmGet$total());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{subtotal:");
        stringBuilder.append(realmGet$subtotal());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{iva:");
        stringBuilder.append(realmGet$iva());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{discount:");
        stringBuilder.append(realmGet$discount());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{state:");
        stringBuilder.append(realmGet$state() != null ? realmGet$state() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{approved:");
        stringBuilder.append(realmGet$approved());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fechaOrden:");
        stringBuilder.append(realmGet$fechaOrden() != null ? realmGet$fechaOrden() : "null");
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
        stringBuilder.append("{fechaEntrega:");
        stringBuilder.append(realmGet$fechaEntrega() != null ? realmGet$fechaEntrega() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fechaCompromisoPago:");
        stringBuilder.append(realmGet$fechaCompromisoPago() != null ? realmGet$fechaCompromisoPago() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoTipoVenta:");
        stringBuilder.append(realmGet$codigoTipoVenta() != null ? realmGet$codigoTipoVenta() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoEstado:");
        stringBuilder.append(realmGet$codigoEstado() != null ? realmGet$codigoEstado() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{observacion:");
        stringBuilder.append(realmGet$observacion() != null ? realmGet$observacion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aplicaConsignacion:");
        stringBuilder.append(realmGet$aplicaConsignacion() != null ? realmGet$aplicaConsignacion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoTipoOrden:");
        stringBuilder.append(realmGet$codigoTipoOrden() != null ? realmGet$codigoTipoOrden() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{aplicaFacturaSinStock:");
        stringBuilder.append(realmGet$aplicaFacturaSinStock() != null ? realmGet$aplicaFacturaSinStock() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoBodega:");
        stringBuilder.append(realmGet$codigoBodega() != null ? realmGet$codigoBodega() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{usuarioIngreso:");
        stringBuilder.append(realmGet$usuarioIngreso() != null ? realmGet$usuarioIngreso() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoCuentaCliente:");
        stringBuilder.append(realmGet$codigoCuentaCliente() != null ? realmGet$codigoCuentaCliente() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoDivision:");
        stringBuilder.append(realmGet$codigoDivision() != null ? realmGet$codigoDivision() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoCuentaXDZV:");
        stringBuilder.append(realmGet$codigoCuentaXDZV() != null ? realmGet$codigoCuentaXDZV() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigoLocalidad:");
        stringBuilder.append(realmGet$codigoLocalidad() != null ? realmGet$codigoLocalidad() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{lsDafDetallesOrdens:");
        stringBuilder.append("RealmList<ProductOrder>[").append(realmGet$lsDafDetallesOrdens().size()).append("]");
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
        OrderRealmProxy aOrder = (OrderRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aOrder.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aOrder.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aOrder.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
