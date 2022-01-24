package com.mobile.polux.models;

public class OrderType {

    private String name;
    private String value;

    public OrderType() {
    }

    public OrderType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + name ;
    }
}
