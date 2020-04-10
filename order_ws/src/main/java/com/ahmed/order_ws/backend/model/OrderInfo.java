package com.ahmed.order_ws.backend.model;

import java.util.List;

public class OrderInfo {
    private String customerId;
    private String orderId;
    private OrderState state;

    public OrderInfo(String customerId, String orderId, OrderState state) {
        this.customerId = customerId;
        this.orderId = orderId;
        this.state = state;
    }

    public String getCustomerId() {
        return customerId;
    }
    public String getOrderId() {
        return orderId;
    }

    public OrderState getState() {
        return state;
    }
}
