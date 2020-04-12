package com.ahmed.books_ws_query;


import com.ahmed.books_ws_query.config.WebConfig;
import com.ahmed.books_ws_query.service.BookSubscriber;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@Import(WebConfig.class)
@ComponentScan
public class BookQueryMain {
    public static void main(String[] args) {
        SpringApplication.run(BookQueryMain.class,args);
    }
}
