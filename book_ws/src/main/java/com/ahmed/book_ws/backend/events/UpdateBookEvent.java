package com.ahmed.book_ws.backend.events;

import com.ahmed.book_ws.model.BookInfo;

public class UpdateBookEvent implements BookEvent{

    BookInfo info;


    public UpdateBookEvent(BookInfo info) {
        this.info = info;
    }

    
    public BookInfo getInfo() {
        return info;
    }

    
}
