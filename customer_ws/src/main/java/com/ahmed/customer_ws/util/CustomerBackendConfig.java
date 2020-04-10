package com.ahmed.customer_ws.util;


import com.ahmed.customer_ws.aggregate.Customer;
import com.ahmed.customer_ws.command.CustomerCommand;
import com.ahmed.customer_ws.service.CustomerService;
import com.ahmed.customer_ws.service.CustomerServiceImpl;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.sync.AggregateRepository;
import io.eventuate.sync.EventuateAggregateStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableEventHandlers
public class CustomerBackendConfig {

    @Bean
    public CustomerService customerService(AggregateRepository<Customer, CustomerCommand> customerRepository) {
        return new CustomerServiceImpl(customerRepository);
    }

    @Bean
    public AggregateRepository<Customer, CustomerCommand> customerRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(Customer.class, eventStore);
    }
}
