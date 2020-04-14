package com.ahmed.order_ws.model;

public class OrderInfo {
    private String customerId;

    public OrderInfo(String customerId) {
        this.customerId = customerId;
    }

    public OrderInfo() {
    }

    public String getCustomerId() {
        return customerId;
    }
}
