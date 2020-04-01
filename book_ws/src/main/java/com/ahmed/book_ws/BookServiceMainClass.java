package com.ahmed.book_ws;

import com.ahmed.book_ws.web.BookWebConfig;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({BookWebConfig.class,  EventuateDriverConfiguration.class})
@SpringBootApplication
@EnableEurekaClient
public class BookServiceMainClass {
    public static void main(String[] args) {
        SpringApplication.run(BookServiceMainClass.class, args);
    }
}
