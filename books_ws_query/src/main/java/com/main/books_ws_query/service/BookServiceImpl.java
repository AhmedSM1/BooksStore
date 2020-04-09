package com.main.books_ws_query.service;

import com.main.books_ws_query.data.BookRepo;
import com.main.books_ws_query.model.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl implements BookService {
    BookRepo repo;

    @Autowired
    public BookServiceImpl(BookRepo repo) {
        this.repo = repo;
    }

    @Override
    public void createBook(BookDetails createBook) {

    }

    @Override
    public void updateBook(String bookId, BookDetails details) {

    }

    @Override
    public void deleteBook(String bookId) {

    }
}
