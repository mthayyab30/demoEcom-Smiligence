package com.thayyab.demoEcom.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cart {

    public Long getProduct_id() {
        return product_id;
    }

    public Cart(Long product_id, String product_name, Long quantity, Long cost) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.quantity = quantity;
        this.cost = cost;
    }

    public Cart() {
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Id
    private Long product_id;
    private String product_name;
    private Long quantity;
    private Long cost;
}
