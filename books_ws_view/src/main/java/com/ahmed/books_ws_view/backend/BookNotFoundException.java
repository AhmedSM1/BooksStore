package com.ahmed.books_ws_view.backend;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String bookId) {
        super("Book not found exception "+bookId);
    }
}
