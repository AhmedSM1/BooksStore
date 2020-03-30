package com.ahmed.book_ws.backend.command;

import com.ahmed.book_ws.backend.model.BookInfo;

public class CreateBookCommand implements BookCommand {

    BookInfo info;

    public CreateBookCommand(BookInfo info) {
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }
}
