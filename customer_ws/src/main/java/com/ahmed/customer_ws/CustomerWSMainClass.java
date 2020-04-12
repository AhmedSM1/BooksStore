package com.ahmed.customer_ws;


import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@EnableAutoConfiguration
@ComponentScan
public class CustomerWSMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CustomerWSMainClass.class,args);
    }
}
