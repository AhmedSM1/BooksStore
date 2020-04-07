package com.ahmed.customer_ws.model;

public class CreateCustomerRequest {
    private String firstName;
    private String lastName;
    private String email;

    public CreateCustomerRequest(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public CreateCustomerRequest() {
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
