package com.ahmed.order_ws.config;


import com.ahmed.order_ws.aggregate.Order;
import com.ahmed.order_ws.commands.OrderCommand;
import com.ahmed.order_ws.service.BookServiceRestTemplete;
import com.ahmed.order_ws.service.CustomerServiceRestTemplete;
import com.ahmed.order_ws.service.OrderService;
import com.ahmed.order_ws.service.OrderServiceImpl;
import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@Configuration
@Import({EventuateDriverConfiguration.class,ServiceProxyConfiguration.class})
@EnableEventHandlers
public class OrderBackendConfig {

    @Bean
    public OrderService orderService(AggregateRepository<Order, OrderCommand> orderRepo,
                                     CustomerServiceRestTemplete customerServiceRestTemplete,
                                     BookServiceRestTemplete bookServiceRestTemplete) {

        return new OrderServiceImpl(orderRepo,customerServiceRestTemplete,bookServiceRestTemplete);

    }
    @Bean
    public AggregateRepository<Order, OrderCommand> orderRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(Order.class, eventStore);
    }
}
