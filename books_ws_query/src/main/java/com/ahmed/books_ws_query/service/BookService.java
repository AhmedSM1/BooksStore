package com.ahmed.books_ws_query.service;

import com.ahmed.books_ws_query.data.BookEntity;
import com.ahmed.common.books.BookInfo;

import java.util.List;

public interface BookService {

    void createBook(BookEntity createBook);

    void updateBook(String bookId,BookInfo details);

    void deleteBook(String bookId);

    BookEntity findById(String bookId);

    List<BookEntity> getAllBooks();

}
