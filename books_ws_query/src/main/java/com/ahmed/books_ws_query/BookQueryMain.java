package com.ahmed.books_ws_query;


import com.ahmed.books_ws_query.config.BackendConfig;
import io.eventuate.EventHandlerMethod;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@Import(BackendConfig.class)
@ComponentScan
public class BookQueryMain {
    public static void main(String[] args) {
        SpringApplication.run(BookQueryMain.class,args);
    }
}
