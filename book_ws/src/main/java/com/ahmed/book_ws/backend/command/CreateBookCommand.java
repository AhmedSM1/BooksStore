package com.ahmed.book_ws.backend.command;


import com.ahmed.book_ws.backend.Model.BookEntity;
import com.ahmed.book_ws.backend.Service.BookDTO;


public class CreateBookCommand implements BookCommand {
  private BookDTO dto;

    public CreateBookCommand(BookDTO dto) {
        this.dto = dto;
    }

    public BookDTO getDto() {
        return dto;
    }

    public void setDto(BookDTO dto) {
        this.dto = dto;
    }
}
