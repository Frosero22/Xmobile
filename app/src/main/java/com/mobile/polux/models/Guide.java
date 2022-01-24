package com.mobile.polux.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 26/12/2018.
 */

public class Guide extends RealmObject {

    @PrimaryKey
    private Integer id;
    private String date;
    private String salesman;

    private RealmList<CashingGuideDetail> details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public RealmList<CashingGuideDetail> getDetails() {
        return details;
    }

    public void setDetails(RealmList<CashingGuideDetail> details) {
        this.details = details;
    }
}
