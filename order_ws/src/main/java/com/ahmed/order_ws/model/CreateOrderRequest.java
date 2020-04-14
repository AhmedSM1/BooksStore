package com.ahmed.order_ws.model;

public class CreateOrderRequest {
    private String customerId;

    public CreateOrderRequest(String customerId) {
        this.customerId = customerId;
    }

    public CreateOrderRequest() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
