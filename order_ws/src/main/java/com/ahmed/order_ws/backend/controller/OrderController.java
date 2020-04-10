package com.ahmed.order_ws.backend.controller;


import com.ahmed.order_ws.backend.model.BookRes;
import com.ahmed.order_ws.backend.model.RequestBookModel;
import com.ahmed.order_ws.backend.service.BookService;
import com.ahmed.order_ws.backend.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController{
    OrderService service;
    BookService bookService;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BookRes>  addToOrder(@RequestBody RequestBookModel req){


    }

    private BookRes findByTitle(RequestBookModel req){
        return bookService.findByBookTitle(req.getTitle());


    }
}