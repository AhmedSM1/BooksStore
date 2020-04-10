package com.ahmed.books_ws.commands;


import com.ahmed.common.books.BookInfo;

public class CreateBookCommand implements BooksCommand {
    BookInfo info;

    public CreateBookCommand(BookInfo info) {
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }
}
