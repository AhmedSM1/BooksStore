package com.ahmed.customer_ws_query.config;

import com.ahmed.customer_ws_query.data.CustomerRepo;
import com.ahmed.customer_ws_query.service.CustomerService;
import com.ahmed.customer_ws_query.service.CustomerServiceImpl;
import com.ahmed.customer_ws_query.service.CustomerSubscriber;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@EnableMongoRepositories(basePackageClasses = CustomerRepo.class)
@EnableAutoConfiguration
@Configuration
@Import(EventuateDriverConfiguration.class)
@EnableEventHandlers
public class CustomerBackendConfig {

    @Bean
    public CustomerService customerService() {
        return new CustomerServiceImpl();
    }


    @Bean
    public CustomerSubscriber customerSubscriber(CustomerService service){
        return new CustomerSubscriber(service);
    }
}
