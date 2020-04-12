package com.ahmed.common.customers;

public class CustomerUpdatedEvent implements CustomerEvent {
    private CustomerInfo info;

    public CustomerUpdatedEvent(CustomerInfo info) {
        this.info = info;
    }

    public CustomerUpdatedEvent() {
    }

    public CustomerInfo getInfo() {
        return info;
    }
}
