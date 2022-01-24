package io.realm;


public interface LocationRealmProxyInterface {
    public Integer realmGet$id();
    public void realmSet$id(Integer value);
    public Integer realmGet$codigoCliente();
    public void realmSet$codigoCliente(Integer value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$address();
    public void realmSet$address(String value);
    public String realmGet$direccionEntregaMercaderia();
    public void realmSet$direccionEntregaMercaderia(String value);
    public String realmGet$direccionMapa();
    public void realmSet$direccionMapa(String value);
    public String realmGet$esPrincipal();
    public void realmSet$esPrincipal(String value);
    public String realmGet$latitude();
    public void realmSet$latitude(String value);
    public String realmGet$longitude();
    public void realmSet$longitude(String value);
    public String realmGet$img();
    public void realmSet$img(String value);
    public Integer realmGet$maxOrdenes();
    public void realmSet$maxOrdenes(Integer value);
    public RealmList<com.mobile.polux.models.Contact> realmGet$contacts();
    public void realmSet$contacts(RealmList<com.mobile.polux.models.Contact> value);
}
