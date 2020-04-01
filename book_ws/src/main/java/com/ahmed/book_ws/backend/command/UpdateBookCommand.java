package com.ahmed.book_ws.backend.command;

import com.ahmed.book_ws.backend.Service.BookDTO;

public class UpdateBookCommand implements BookCommand {
     BookDTO bookDTO;

    public UpdateBookCommand(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    @Override
    public String toString() {
        return "UpdateBookCommand{" +
                "bookDTO=" + bookDTO +
                '}';
    }
}

