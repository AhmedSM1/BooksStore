package com.ahmed.books_ws.domain;

public class CreateBookCommand implements BooksCommand {
    BooksInfo info;

    public CreateBookCommand(BooksInfo info) {
        this.info = info;
    }

    public BooksInfo getInfo() {
        return info;
    }
}
