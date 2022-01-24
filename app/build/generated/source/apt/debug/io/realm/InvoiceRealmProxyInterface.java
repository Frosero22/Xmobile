package io.realm;


public interface InvoiceRealmProxyInterface {
    public int realmGet$pk();
    public void realmSet$pk(int value);
    public int realmGet$id();
    public void realmSet$id(int value);
    public Integer realmGet$order();
    public void realmSet$order(Integer value);
    public String realmGet$codigoComprobante();
    public void realmSet$codigoComprobante(String value);
    public double realmGet$iva();
    public void realmSet$iva(double value);
    public double realmGet$discount();
    public void realmSet$discount(double value);
    public double realmGet$subTotal();
    public void realmSet$subTotal(double value);
    public double realmGet$total();
    public void realmSet$total(double value);
    public double realmGet$due();
    public void realmSet$due(double value);
    public double realmGet$pay();
    public void realmSet$pay(double value);
    public String realmGet$state();
    public void realmSet$state(String value);
    public long realmGet$guide();
    public void realmSet$guide(long value);
    public String realmGet$fechaVencimiento();
    public void realmSet$fechaVencimiento(String value);
    public String realmGet$fecha();
    public void realmSet$fecha(String value);
    public RealmList<com.mobile.polux.models.PaymentDoc> realmGet$pago();
    public void realmSet$pago(RealmList<com.mobile.polux.models.PaymentDoc> value);
    public RealmList<com.mobile.polux.models.ProductInvoice> realmGet$products();
    public void realmSet$products(RealmList<com.mobile.polux.models.ProductInvoice> value);
}
