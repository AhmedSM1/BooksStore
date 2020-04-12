package com.ahmed.books_ws.config;

import com.ahmed.books_ws.aggregate.Books;
import com.ahmed.books_ws.commands.BooksCommand;
import com.ahmed.books_ws.service.BookService;
import com.ahmed.books_ws.service.BookServiceImpl;
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
@Import(EventuateDriverConfiguration.class)
@EnableEventHandlers
public class BookBackendConfig {

    @Bean
    public BookService bookService(AggregateRepository<Books, BooksCommand> bookRepo) {
        return new BookServiceImpl(bookRepo);
    }

    @Bean
    public AggregateRepository<Books, BooksCommand> bookRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(Books.class, eventStore);
    }

}
