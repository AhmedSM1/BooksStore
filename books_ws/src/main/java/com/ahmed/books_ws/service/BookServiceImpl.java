package com.ahmed.books_ws.service;

import com.ahmed.books_ws.aggregate.Books;
import com.ahmed.books_ws.commands.BooksCommand;

import com.ahmed.books_ws.commands.CreateBookCommand;

import com.ahmed.books_ws.commands.DeleteBookCommand;
import com.ahmed.books_ws.commands.UpdateBookCommand;
import com.ahmed.common.books.BookInfo;
import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class BookServiceImpl implements BookService {


    private AggregateRepository<Books, BooksCommand> bookRepository;
    Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    public BookServiceImpl(AggregateRepository<Books, BooksCommand> bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Books>> createBook(BookInfo bookInfo) {
        logger.debug("Book service_________create book()");
        return this.bookRepository.save(new CreateBookCommand(bookInfo));
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Books>> deleteBook(String bookId) {
        return this.bookRepository.update(bookId,new DeleteBookCommand(bookId));
    }

    @Override
    public CompletableFuture<EntityWithIdAndVersion<Books>> updateBook(String bookId, BookInfo info) {
        logger.debug("Book service_________delete book()");

        return this.bookRepository.update(bookId, new UpdateBookCommand(info));
    }
}
