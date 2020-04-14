package com.ahmed.order_ws.config;

import com.ahmed.order_ws.service.BookServiceProxy;
import com.ahmed.order_ws.service.BookServiceRestTemplete;
import com.ahmed.order_ws.service.CustomerServiceProxy;
import com.ahmed.order_ws.service.CustomerServiceRestTemplete;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceProxyConfiguration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CustomerServiceRestTemplete customerServiceProxy(RestTemplate restTemplate) {
        return new CustomerServiceProxy(restTemplate);
    }
    @Bean
    public BookServiceRestTemplete bookServiceProxy(RestTemplate restTemplate) {
        return new BookServiceProxy(restTemplate);
    }
}
