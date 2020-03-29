package com.ahmed.book_ws.backend.command;

import com.ahmed.book_ws.backend.model.BookInfo;

public class UpdateBookCommand implements  BookCommand {
    private String id;
    private BookInfo info;

    public UpdateBookCommand(String id, BookInfo info) {
        this.id = id;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public BookInfo getInfo() {
        return info;
    }
}

