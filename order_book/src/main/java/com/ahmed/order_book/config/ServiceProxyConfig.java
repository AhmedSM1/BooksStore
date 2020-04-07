package com.ahmed.order_book.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceProxyConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public OrderAndBookService orderBookServiceProxy(RestTemplate restTemplate) {
        return new ServiceProxyAnd(restTemplate);
    }
}
