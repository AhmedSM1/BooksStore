package com.ahmed.order_ws.backend.commands;

public class CreateOrderCommand implements OrderCommand {
    private String customerId;

    public CreateOrderCommand(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
