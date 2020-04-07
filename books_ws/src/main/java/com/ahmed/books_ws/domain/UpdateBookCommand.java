package com.ahmed.books_ws.domain;

import com.ahmed.books_ws.model.BookInfo;

public class UpdateBookCommand implements BooksCommand{
    BookInfo info;

    public UpdateBookCommand(BookInfo info) {
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }
}
