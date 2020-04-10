package com.ahmed.common.customers;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Objects;

public class CustomerCreatedEvent implements CustomerEvent {

    private CustomerInfo info;

    public CustomerCreatedEvent(CustomerInfo info) {
        this.info = info;
    }

    public CustomerInfo getInfo() {
        return info;
    }
}
