package com.ahmed.order_ws.model;

public class CustomerResponseModel {
    private String customerId;

    public CustomerResponseModel(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
