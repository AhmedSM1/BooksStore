package com.ahmed.order_ws_query.service;

import com.ahmed.common.customers.CustomerInfo;
import com.ahmed.order_ws_query.data.Books;
import com.ahmed.order_ws_query.data.OrderEntity;
import com.ahmed.order_ws_query.model.CustomerRequest;

import java.util.List;

public interface OrderService {
    void createOrder(OrderEntity entity);
    void addBook(OrderEntity entity);
    void removeBook(OrderEntity entity);

    OrderEntity findById(String orderId);


}
