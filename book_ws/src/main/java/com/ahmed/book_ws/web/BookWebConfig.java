package com.ahmed.book_ws.web;


import com.ahmed.book_ws.backend.BackendConfiguration;
import com.ahmed.common.WebConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@Import(BackendConfiguration.class)
public class BookWebConfig {
}
