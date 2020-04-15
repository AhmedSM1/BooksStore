package com.ahmed.order_ws_query;

import com.ahmed.order_ws_query.config.OrderBackEndConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(OrderBackEndConfig.class)
@ComponentScan
public class OrderQueryMainClass {
    public static void main(String[] args) {
        SpringApplication.run(OrderQueryMainClass.class, args); }}
