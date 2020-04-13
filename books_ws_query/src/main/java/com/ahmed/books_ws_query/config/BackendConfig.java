package com.ahmed.books_ws_query.config;


import com.ahmed.books_ws_query.data.BookRepo;
import com.ahmed.books_ws_query.service.BookService;
import com.ahmed.books_ws_query.service.BookServiceImpl;
import com.ahmed.books_ws_query.service.BookSubscriber;
import io.eventuate.javaclient.driver.EventuateDriverConfiguration;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@Import(EventuateDriverConfiguration.class)
@EnableEventHandlers
public class BackendConfig {

    @Bean
    public BookService bookService() {
        return new BookServiceImpl();
    }


    @Bean
    public BookSubscriber bookSubscriber(BookService bookService){
        return new BookSubscriber(bookService);
    }

    @Bean
    public QuerySideDependencyChecker querysideDependencyChecker(MongoTemplate mongoTemplate) {
        return new QuerySideDependencyChecker(mongoTemplate);
    }

}
