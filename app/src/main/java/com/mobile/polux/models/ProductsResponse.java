package com.mobile.polux.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by laptoplenovo on 2/6/2018.
 */

public class ProductsResponse {

    @SerializedName("mensaje")
    private String message;
    @SerializedName("productos")
    private List<Product> products = null;
    @SerializedName("totalProductos")
    private Integer totalProducts;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }
}
