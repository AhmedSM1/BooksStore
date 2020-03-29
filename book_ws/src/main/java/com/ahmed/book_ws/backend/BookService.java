package com.ahmed.book_ws.backend;

import com.ahmed.book_ws.model.Book;
import com.ahmed.book_ws.model.BookInfo;

import io.eventuate.EntityWithIdAndVersion;

public interface BookService {

    EntityWithIdAndVersion<Book> createBook(BookInfo  info);

    EntityWithIdAndVersion<Book> findById(String bookid);

    EntityWithIdAndVersion<Book> findByBookTitle(String bookid);

    
}
