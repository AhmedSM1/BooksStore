package com.ahmed.order_ws_query.config;


import com.ahmed.order_ws_query.data.OrderRepo;
import com.ahmed.order_ws_query.service.OrderService;
import com.ahmed.order_ws_query.service.OrderServiceImpl;
import com.ahmed.order_ws_query.service.OrderSubscriber;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = OrderRepo.class)
@EnableAutoConfiguration
@Configuration
@Import(EventuateDriverConfiguration.class)
@EnableEventHandlers
public class OrderBackEndConfig {

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl();
    }


    @Bean
    public OrderSubscriber orderSubscriber(OrderService service){
        return new OrderSubscriber(service);
    }
}
