package com.ahmed.order_ws_query.service;

import com.ahmed.order_ws_query.data.Books;
import com.ahmed.order_ws_query.data.OrderEntity;
import com.ahmed.order_ws_query.data.OrderRepo;
import com.ahmed.order_ws_query.model.CustomerRequest;
import com.ahmed.order_ws_query.util.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

 class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo repo;

    @Override
    public void createOrder(OrderEntity entity) {
        this.repo.save(entity);
    }

    @Override
    public void addBook(OrderEntity entity) {

         this.repo.insert(entity);
    }

    @Override
    public void removeBook(OrderEntity entity) {
       this.repo.save(entity);
    }

    @Override
    public OrderEntity findById(String orderId) {
       return  this.repo.findById(orderId).orElseThrow(OrderNotFoundException::new);
    }
}
