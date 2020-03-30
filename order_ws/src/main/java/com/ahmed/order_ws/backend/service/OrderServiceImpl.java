package com.ahmed.order_ws.backend.service;

import com.ahmed.order_ws.backend.model.Order;
import com.ahmed.order_ws.backend.model.OrderItemRepo;
import com.ahmed.order_ws.backend.model.OrderRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo repo;

    @Autowired
    OrderItemRepo itemRepo;
    @Override
    public String createOrder() {
       Order  order = new Order();
       
       order.dismissChild(cartItem);
       
       
    }

    

}
