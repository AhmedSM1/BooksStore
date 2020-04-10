package com.ahmed.order_ws.backend.service;

import com.ahmed.order_ws.backend.model.BookRes;

public interface BookService {
    void verifyBookId(String bookId);
    void findByBookTitle(String bookTitle);
}
