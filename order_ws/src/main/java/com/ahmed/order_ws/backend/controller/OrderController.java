package com.ahmed.order_ws.backend.controller;

import com.ahmed.order_ws.backend.model.Order;
import com.ahmed.order_ws.backend.service.OrderService;

import io.eventuate.EntityWithIdAndVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController{

    @Autowired
    OrderService service;


}