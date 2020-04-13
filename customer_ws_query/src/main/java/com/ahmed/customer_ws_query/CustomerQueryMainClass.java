package com.ahmed.customer_ws_query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class CustomerQueryMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CustomerQueryMainClass.class,args);
    }
}

