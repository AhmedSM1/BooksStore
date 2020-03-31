package com.ahmed.order_ws.backend.controller;

import com.ahmed.common.order.Order;
import com.ahmed.common.order.OrderBook;
import com.ahmed.order_ws.backend.service.OrderBookService;
import com.ahmed.order_ws.backend.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/order")
public class OrderController{

    @Autowired
    OrderService service;

    @Autowired
    OrderBookService orderBookService;


}