package com.ahmed.order_ws.model;

import java.util.List;

public class OrderInfo {
    private String customerId;
    private OrderState state;
    private List<Books> booksList;


    public OrderInfo(String customerId,OrderState state) {
        this.customerId = customerId;

        this.state = state;
    }

    public String getCustomerId() {
        return customerId;
    }

    public OrderState getState() {
        return state;
    }
}
