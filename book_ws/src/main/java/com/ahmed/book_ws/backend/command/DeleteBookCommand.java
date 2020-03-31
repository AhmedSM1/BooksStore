package com.ahmed.book_ws.backend.command;


public class DeleteBookCommand implements  BookCommand {

    String bookId;

    public DeleteBookCommand(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
