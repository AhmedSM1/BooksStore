package com.ahmed.books_ws.config;

import com.ahmed.books_ws.aggregate.Books;
import com.ahmed.books_ws.commands.BooksCommand;
import com.ahmed.books_ws.service.BookService;
import com.ahmed.books_ws.service.BookServiceImpl;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.sync.AggregateRepository;
import io.eventuate.sync.EventuateAggregateStore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@Configuration
@EnableJpaRepositories("com.ahmed.books_ws")
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
