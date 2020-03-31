package com.ahmed.common;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MainClass {
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }

}
