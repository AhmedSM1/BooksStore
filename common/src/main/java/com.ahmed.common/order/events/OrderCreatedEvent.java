package com.ahmed.common.order.events;

public class OrderCreatedEvent implements OrderEvent {
    private String customerId;

    public OrderCreatedEvent(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
