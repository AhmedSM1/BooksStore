package com.ahmed.book_ws.backend.command;

import com.ahmed.common.books.BookInfo;

public class UpdateBookCommand implements BookCommand {
     BookInfo info;
     String id;
    public UpdateBookCommand(String id , BookInfo info) {
        this.id = id;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BookInfo getInfo() {
        return info;
    }

    public void setInfo(BookInfo info) {
        this.info = info;
    }
}

