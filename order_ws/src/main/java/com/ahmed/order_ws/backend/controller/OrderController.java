package com.ahmed.order_ws.backend.controller;

import com.ahmed.order_ws.backend.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController{

    @Autowired
    OrderService service;

    @PostMapping("/order")
    public ResponseEntity<CreateOrderResponse> createOrder(){
       String orderID = service.createOrder();

       CreateOrderResponse createdOrderResponse = new CreateOrderResponse(orderID);
       
       return ResponseEntity.accepted().body(createdOrderResponse);        
    }

}