package com.ahmed.books_ws.domain;

public class UpdateBookCommand implements BooksCommand{
    BooksInfo info;

    public UpdateBookCommand(BooksInfo info) {
        this.info = info;
    }

    public BooksInfo getInfo() {
        return info;
    }
}
