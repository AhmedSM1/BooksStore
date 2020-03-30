package com.ahmed.order_ws.backend.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BookServiceProxyFactory {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    @Bean
    public BookService customerServiceProxy(RestTemplate restTemplate) {
        return new BookServiceProxy(restTemplate);
    }

}
