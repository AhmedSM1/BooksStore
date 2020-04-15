package com.ahmed.order_ws_query.controller;


import com.ahmed.order_ws_query.data.OrderEntity;
import com.ahmed.order_ws_query.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService service;


    @GetMapping("/{orderId}")
    public ResponseEntity<OrderEntity> getOrder(@PathVariable(value = "orderId")String orderId){
        OrderEntity entity = service.findById(orderId);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll(){
        List<OrderEntity> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
