package com.ahmed.books_ws.service;

import com.ahmed.books_ws.domain.Books;
import com.ahmed.books_ws.domain.BooksCommand;

import com.ahmed.books_ws.domain.CreateBookCommand;
import com.ahmed.books_ws.domain.UpdateBookCommand;

import com.ahmed.books_ws.model.BookInfo;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import io.eventuate.sync.AggregateRepository;

public class BookServiceImpl implements BookService {

    private final AggregateRepository<Books, BooksCommand> bookRepository;

    public BookServiceImpl(AggregateRepository<Books, BooksCommand> bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public EntityWithIdAndVersion<Books> createBook(BookInfo bookInfo) {
       return bookRepository.save(new CreateBookCommand(bookInfo));
    }



    @Override
    public EntityWithMetadata<Books> findById(String bookId) {
        return bookRepository.find(bookId);
    }
}
