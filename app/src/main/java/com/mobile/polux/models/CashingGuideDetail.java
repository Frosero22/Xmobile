package com.mobile.polux.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 16/10/2018.
 */

public class CashingGuideDetail extends RealmObject {

    @PrimaryKey
    private int id;
    @Expose
    @SerializedName("codigo")
    private int clientId;
    private String name;
    private String address;
    private String state;
    private Double collected;
    private Double pending;
    private Double totalDue;
    private Double credit;
    private String date;
    private Integer seqC;
    @Expose
    private RealmList<Invoice> docXcobrar;

    public CashingGuideDetail() {
    }

    public CashingGuideDetail(int clientId, String name, String address, String state, Double collected, Double pending, Double due,Integer seqC) {
        this.clientId = clientId;
        this.name = name;
        this.address = address;
        this.state = state;
        this.collected = collected;
        this.pending = pending;
        this.totalDue = due;
        this.seqC = seqC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getCollected() {
        return collected;
    }

    public void setCollected(Double collected) {
        this.collected = collected;
    }

    public Double getPending() {
        return pending;
    }

    public void setPending(Double pending) {
        this.pending = pending;
    }

    public Double getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(Double totalDue) {
        this.totalDue = totalDue;
    }

    public Double getCredit() {
        if (credit == null) {
            return .0;
        }
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RealmList<Invoice> getDocXcobrar() {
        if (docXcobrar == null) {
            docXcobrar = new RealmList<>();
        }
        return docXcobrar;
    }

    public void setDocXcobrar(RealmList<Invoice> docXcobrar) {
        this.docXcobrar = docXcobrar;
    }

    public CashingGuideDetail toUnManaged(Realm realm) {
        return isManaged() ? realm.copyFromRealm(this) : this;
    }

    public Integer getSeqC() {
        return seqC;
    }

    public void setSeqC(Integer seqC) {
        this.seqC = seqC;
    }
}
