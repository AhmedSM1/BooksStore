package com.ahmed.customer_ws.command;

public class DeleteCustomerCommand implements CustomerCommand {
    private String customerId;

    public DeleteCustomerCommand(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
