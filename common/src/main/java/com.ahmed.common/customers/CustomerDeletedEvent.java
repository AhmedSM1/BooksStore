package com.ahmed.common.customers;

public class CustomerDeletedEvent implements CustomerEvent {
    private String customerId;

    public CustomerDeletedEvent(String customerId) {
        this.customerId = customerId;
    }

    public CustomerDeletedEvent() {
    }

    public String getCustomerId() {
        return customerId;
    }
}
