package com.ahmed.book_ws.backend.command;

import com.ahmed.common.BookInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateBookCommand implements BookCommand {
     BookInfo info;
     Long id;
    public UpdateBookCommand(Long id , BookInfo info) {
        this.id = id;
        this.info = info;
    }

    public BookInfo getInfo() {
        return info;
    }

    public void setInfo(BookInfo info) {
        this.info = info;
    }
}

