package com.ahmed.book_ws.backend.events;

import com.ahmed.book_ws.model.BookInfo;

public class CreateBookEvent implements BookEvent{
    BookInfo info;

    public CreateBookEvent(BookInfo info) {
        this.info = info;
    }


}
