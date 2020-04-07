package com.ahmed.books_ws.domain;


import com.ahmed.books_ws.model.BookInfo;

public class CreateBookCommand implements BooksCommand {
    BookInfo info;

    public CreateBookCommand(BookInfo info) {
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }
}
