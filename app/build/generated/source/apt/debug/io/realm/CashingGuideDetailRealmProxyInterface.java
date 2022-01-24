package io.realm;


public interface CashingGuideDetailRealmProxyInterface {
    public int realmGet$id();
    public void realmSet$id(int value);
    public int realmGet$clientId();
    public void realmSet$clientId(int value);
    public String realmGet$name();
    public void realmSet$name(String value);
    public String realmGet$address();
    public void realmSet$address(String value);
    public String realmGet$state();
    public void realmSet$state(String value);
    public Double realmGet$collected();
    public void realmSet$collected(Double value);
    public Double realmGet$pending();
    public void realmSet$pending(Double value);
    public Double realmGet$totalDue();
    public void realmSet$totalDue(Double value);
    public Double realmGet$credit();
    public void realmSet$credit(Double value);
    public String realmGet$date();
    public void realmSet$date(String value);
    public RealmList<com.mobile.polux.models.Invoice> realmGet$docXcobrar();
    public void realmSet$docXcobrar(RealmList<com.mobile.polux.models.Invoice> value);
}
