package com.ahmed.book_ws.backend.events;


import com.ahmed.book_ws.backend.Model.BookEntity;
import com.ahmed.book_ws.backend.Service.BookDTO;

public class BookAddedEvent implements BookEvent {
private BookDTO dto;

    public BookAddedEvent(BookDTO dto) {
        this.dto = dto;
    }

    public BookDTO getDto() {
        return dto;
    }

    public void setDto(BookDTO dto) {
        this.dto = dto;
    }
}
