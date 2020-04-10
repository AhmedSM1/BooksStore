package com.ahmed.common.customers;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Objects;

public class CustomerCreatedEvent implements CustomerEvent {

    private CustomerInfo info;

    public CustomerCreatedEvent(CustomerInfo info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerCreatedEvent that = (CustomerCreatedEvent) o;
        return Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }

    public CustomerInfo getInfo() {
        return info;
    }
}
