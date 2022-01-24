package io.realm;


public interface ClientRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public String realmGet$identification();
    public void realmSet$identification(String value);
    public String realmGet$businessName();
    public void realmSet$businessName(String value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public int realmGet$type();
    public void realmSet$type(int value);
    public String realmGet$typeName();
    public void realmSet$typeName(String value);
    public String realmGet$phone();
    public void realmSet$phone(String value);
    public String realmGet$paymentType();
    public void realmSet$paymentType(String value);
    public RealmList<com.mobile.polux.models.Account> realmGet$accounts();
    public void realmSet$accounts(RealmList<com.mobile.polux.models.Account> value);
    public RealmList<com.mobile.polux.models.Rate> realmGet$rate();
    public void realmSet$rate(RealmList<com.mobile.polux.models.Rate> value);
    public RealmList<com.mobile.polux.models.Location> realmGet$locations();
    public void realmSet$locations(RealmList<com.mobile.polux.models.Location> value);
    public String realmGet$permiteModificarDiasPedido();
    public void realmSet$permiteModificarDiasPedido(String value);
}
