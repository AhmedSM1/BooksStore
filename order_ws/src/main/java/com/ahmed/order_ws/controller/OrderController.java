package com.ahmed.order_ws.controller;


import com.ahmed.order_ws.model.CreateOrderRequest;
import com.ahmed.order_ws.model.OrderResponse;
import com.ahmed.order_ws.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/order")
public class OrderController  {
    @Autowired
    private OrderService service;

    @PostMapping
    public CompletableFuture<ResponseEntity<OrderResponse>> createOrder(@RequestBody CreateOrderRequest request){
        return this.service.createOrder(request.getCustomerId())
                .thenApply(res->new ResponseEntity<>(new OrderResponse(res.getEntityId()), HttpStatus.CREATED));
    }
}
