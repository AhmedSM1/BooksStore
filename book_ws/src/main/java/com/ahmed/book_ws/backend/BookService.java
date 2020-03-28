package com.ahmed.book_ws.backend;

import io.eventuate.EntityWithIdAndVersion;

public interface BookService {

    EntityWithIdAndVersion<Book> createBook(CreateBookRequest  book);

    EntityWithIdAndVersion<Book> findById(String bookid);

    EntityWithIdAndVersion<Book> findByBookTitle(String bookid);

    
}
