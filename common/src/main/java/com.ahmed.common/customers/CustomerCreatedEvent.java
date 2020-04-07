package com.ahmed.common.customers;

import org.apache.commons.lang.builder.EqualsBuilder;

import java.util.Objects;

public class CustomerCreatedEvent implements CustomerEvent {
    private String firstName;
    private String lastName;
    private String email;

    public CustomerCreatedEvent(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
