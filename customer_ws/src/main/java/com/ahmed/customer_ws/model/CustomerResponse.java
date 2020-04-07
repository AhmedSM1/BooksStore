package com.ahmed.customer_ws.model;

public class CustomerResponse {
    private String customerId;

    public CustomerResponse() {
    }

    public CustomerResponse(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
