package com.ahmed.books_ws.service;

import com.ahmed.books_ws.aggregate.Books;
import com.ahmed.books_ws.commands.BooksCommand;

import com.ahmed.books_ws.commands.CreateBookCommand;

import com.ahmed.books_ws.commands.DeleteBookCommand;
import com.ahmed.books_ws.commands.UpdateBookCommand;
import com.ahmed.common.books.BookInfo;
import io.eventuate.EntityWithIdAndVersion;
import io.eventuate.EntityWithMetadata;
import io.eventuate.sync.AggregateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {


    private  AggregateRepository<Books, BooksCommand> bookRepository;

    public BookServiceImpl(AggregateRepository<Books, BooksCommand> bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public EntityWithIdAndVersion<Books> createBook(BookInfo bookInfo) {

        return this.bookRepository.save(new CreateBookCommand(bookInfo));
    }

    @Override
    public EntityWithIdAndVersion<Books> deleteBook(String bookId) {
        return this.bookRepository.update(bookId,new DeleteBookCommand(bookId));
    }


    @Override
    public EntityWithMetadata<Books> findById(String bookId) {
        return bookRepository.find(bookId);
    }

    @Override
    public EntityWithIdAndVersion<Books> updateBook(String bookId, BookInfo info) {
        return this.bookRepository.update(bookId, new UpdateBookCommand(info));
    }
}
