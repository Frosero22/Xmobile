package com.mobile.polux.models;

import java.util.List;

/**
 * Created by laptoplenovo on 11/10/2018.
 */

public class Delivery {

    private String name;
    private String address;
    private String state;
    private String observation;
    private String numBill;

    private double due;
    private double cancelled;
    private double balance;

    public Delivery(){}

    public Delivery(String name, String address, String state, String observation,
                    String numBill, double due, double cancelled, double balance,
                    List<ProductOrder> products) {
        this.name = name;
        this.address = address;
        this.state = state;
        this.observation = observation;
        this.numBill = numBill;
        this.due = due;
        this.cancelled = cancelled;
        this.balance = balance;
        this.products = products;
    }

    private List<ProductOrder> products;

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

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public String getNumBill() {
        return numBill;
    }

    public void setNumBill(String numBill) {
        this.numBill = numBill;
    }

    public double getDue() {
        return due;
    }

    public void setDue(double due) {
        this.due = due;
    }

    public double getCancelled() {
        return cancelled;
    }

    public void setCancelled(double cancelled) {
        this.cancelled = cancelled;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<ProductOrder> getProducts() {
        return products;
    }

    public void setProducts(List<ProductOrder> products) {
        this.products = products;
    }
}
