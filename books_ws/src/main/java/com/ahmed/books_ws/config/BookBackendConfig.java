package com.ahmed.books_ws.config;

import com.ahmed.books_ws.domain.Books;
import com.ahmed.books_ws.domain.BooksCommand;
import com.ahmed.books_ws.service.BookService;
import com.ahmed.books_ws.service.BookServiceImpl;
import io.eventuate.javaclient.spring.EnableEventHandlers;
import io.eventuate.sync.AggregateRepository;
import io.eventuate.sync.EventuateAggregateStore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
