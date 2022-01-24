package com.mobile.polux.models;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by laptoplenovo on 6/6/2018.
 */

public class Filter extends RealmObject {

    @PrimaryKey
    private String id;
    private String text;
    private String type;
    private Date date;

    public Filter() {
    }

    public Filter(String text, String type) {
        id = type+"_"+text;
        this.text = text;
        this.type = type;
        date = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
