package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 5/12/2018.
 */

public class Bank extends RealmObject {

    @PrimaryKey
    @SerializedName("codigoInstitucion")
    private int id;
    @SerializedName("nombreInstitucion")
    private String name;

    public Bank() {
    }

    public Bank(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
