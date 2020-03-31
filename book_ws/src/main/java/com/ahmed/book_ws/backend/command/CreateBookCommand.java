package com.ahmed.book_ws.backend.command;


import com.ahmed.common.books.BookInfo;


public class CreateBookCommand implements BookCommand {
  private BookInfo info;

    public CreateBookCommand(BookInfo info) {
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }

    public void setInfo(BookInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CreateBookCommand{" +
                "info=" + info +
                '}';
    }
}
