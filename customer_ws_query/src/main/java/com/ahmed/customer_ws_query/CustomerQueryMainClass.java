package com.ahmed.customer_ws_query;

import com.ahmed.customer_ws_query.config.CustomerViewWebConfig;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableEurekaClient
@Import(CustomerViewWebConfig.class)
@ComponentScan
public class CustomerQueryMainClass {
    public static void main(String[] args) {
        SpringApplication.run(CustomerQueryMainClass.class,args);
    }
}

