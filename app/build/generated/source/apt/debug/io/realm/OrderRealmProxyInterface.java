package io.realm;


public interface OrderRealmProxyInterface {
    public Integer realmGet$id();
    public void realmSet$id(Integer value);
    public Long realmGet$numeroOrden();
    public void realmSet$numeroOrden(Long value);
    public Integer realmGet$numeroOrdenAuxiliar();
    public void realmSet$numeroOrdenAuxiliar(Integer value);
    public String realmGet$aprobada();
    public void realmSet$aprobada(String value);
    public String realmGet$observaciones();
    public void realmSet$observaciones(String value);
    public String realmGet$error();
    public void realmSet$error(String value);
    public int realmGet$codigoCliente();
    public void realmSet$codigoCliente(int value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public double realmGet$total();
    public void realmSet$total(double value);
    public double realmGet$subtotal();
    public void realmSet$subtotal(double value);
    public double realmGet$iva();
    public void realmSet$iva(double value);
    public double realmGet$discount();
    public void realmSet$discount(double value);
    public String realmGet$state();
    public void realmSet$state(String value);
    public boolean realmGet$approved();
    public void realmSet$approved(boolean value);
    public String realmGet$fechaOrden();
    public void realmSet$fechaOrden(String value);
    public Integer realmGet$codigoEmpresa();
    public void realmSet$codigoEmpresa(Integer value);
    public Integer realmGet$codigoSucursal();
    public void realmSet$codigoSucursal(Integer value);
    public String realmGet$fechaEntrega();
    public void realmSet$fechaEntrega(String value);
    public String realmGet$fechaCompromisoPago();
    public void realmSet$fechaCompromisoPago(String value);
    public Integer realmGet$codigoTipoVenta();
    public void realmSet$codigoTipoVenta(Integer value);
    public String realmGet$codigoEstado();
    public void realmSet$codigoEstado(String value);
    public String realmGet$observacion();
    public void realmSet$observacion(String value);
    public String realmGet$aplicaConsignacion();
    public void realmSet$aplicaConsignacion(String value);
    public String realmGet$codigoTipoOrden();
    public void realmSet$codigoTipoOrden(String value);
    public String realmGet$aplicaFacturaSinStock();
    public void realmSet$aplicaFacturaSinStock(String value);
    public Integer realmGet$codigoBodega();
    public void realmSet$codigoBodega(Integer value);
    public String realmGet$usuarioIngreso();
    public void realmSet$usuarioIngreso(String value);
    public Integer realmGet$codigoCuentaCliente();
    public void realmSet$codigoCuentaCliente(Integer value);
    public Integer realmGet$codigoDivision();
    public void realmSet$codigoDivision(Integer value);
    public Integer realmGet$codigoCuentaXDZV();
    public void realmSet$codigoCuentaXDZV(Integer value);
    public Integer realmGet$codigoLocalidad();
    public void realmSet$codigoLocalidad(Integer value);
    public RealmList<com.mobile.polux.models.ProductOrder> realmGet$lsDafDetallesOrdens();
    public void realmSet$lsDafDetallesOrdens(RealmList<com.mobile.polux.models.ProductOrder> value);
}