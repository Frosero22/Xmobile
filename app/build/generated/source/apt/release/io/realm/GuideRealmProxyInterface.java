package io.realm;


public interface GuideRealmProxyInterface {
    public Integer realmGet$id();
    public void realmSet$id(Integer value);
    public String realmGet$date();
    public void realmSet$date(String value);
    public String realmGet$salesman();
    public void realmSet$salesman(String value);
    public RealmList<com.mobile.polux.models.CashingGuideDetail> realmGet$details();
    public void realmSet$details(RealmList<com.mobile.polux.models.CashingGuideDetail> value);
}
