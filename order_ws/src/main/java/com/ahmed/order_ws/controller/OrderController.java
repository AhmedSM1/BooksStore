package com.ahmed.order_ws.controller;


import com.ahmed.order_ws.model.*;
import com.ahmed.order_ws.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/order")
public class OrderController  {
    @Autowired
    private OrderService service;

    @PostMapping
    public CompletableFuture<ResponseEntity<CommandResponse>> createOrder(@RequestBody CreateOrderRequest request){
        return this.service.createOrder(request.getCustomerId())
                .thenApply(res->new ResponseEntity<>(new CommandResponse(res.getEntityId()), HttpStatus.CREATED));
    }

    @PostMapping("/{orderId}")
    public CompletableFuture<ResponseEntity<CommandResponse>> addBookToOrder(@PathVariable(value = "orderId") String orderId, @RequestBody AddBookRequest request){
        return this.service.addBook(orderId,request)
                .thenApply(res->new ResponseEntity<>(new CommandResponse(res.getEntityId()), HttpStatus.ACCEPTED));
    }

    @PostMapping("/{orderId}")
    public CompletableFuture<ResponseEntity<CommandResponse>> removeBookFromOrder(@PathVariable(value = "orderId") String orderId, @RequestBody RemoveBookRequest request){
        return this.service.removeBook(orderId,request)
                .thenApply(res->new ResponseEntity<>(new CommandResponse(res.getEntityId()), HttpStatus.ACCEPTED));
    }
}
