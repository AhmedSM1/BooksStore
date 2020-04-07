package com.ahmed.order_book.config;


import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableEventHandlers
@Import(ServiceProxyConfig.class)
public class OrderBookBackendConfig {

    @Bean
    public BookOrderWorkflow bookOrderWorkflow() {
        return new BookOrderWorkflow();
    }




}
