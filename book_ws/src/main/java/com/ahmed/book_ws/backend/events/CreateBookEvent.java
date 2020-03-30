package com.ahmed.book_ws.backend.events;

import com.ahmed.book_ws.backend.model.BookInfo;

public class CreateBookEvent implements BookEvent {
    BookInfo info;

    public CreateBookEvent(BookInfo info) {
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }

    public void setInfo(BookInfo info) {
        this.info = info;
    }


}
