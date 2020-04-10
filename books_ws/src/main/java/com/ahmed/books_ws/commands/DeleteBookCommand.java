package com.ahmed.books_ws.commands;

public class DeleteBookCommand implements BooksCommand {
    private String bookId;

    public DeleteBookCommand(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
