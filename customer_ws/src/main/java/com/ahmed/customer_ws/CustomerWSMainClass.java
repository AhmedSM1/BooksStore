package com.ahmed.customer_ws;


import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan
public class CustomerWSMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CustomerWSMainClass.class,args);
    }
}
