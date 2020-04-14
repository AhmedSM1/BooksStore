package com.ahmed.order_ws;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@ComponentScan
public class OrderMainClass {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainClass.class, args);

    }
}