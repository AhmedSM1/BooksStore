package com.ahmed.books_ws.commands;

import com.ahmed.common.books.BookInfo;

public class UpdateBookCommand implements BooksCommand{
    BookInfo info;

    public UpdateBookCommand(BookInfo info) {
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }
}
