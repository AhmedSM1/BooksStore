package com.ahmed.books_ws;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@ComponentScan
public class BooksWSMainClass {
    public static void main(String[] args) {
        SpringApplication.run(BooksWSMainClass.class,args);
    }
}
