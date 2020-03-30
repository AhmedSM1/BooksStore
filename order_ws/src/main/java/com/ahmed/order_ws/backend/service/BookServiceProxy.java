package com.ahmed.order_ws.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

public class BookServiceProxy implements BookService {
    private RestTemplate restTemplate;

    @Value("${book_ws.service.url}")
    private String bookServiceUrl;

    public BookServiceProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void setBookServiceUrl(String bookServiceUrl) {
        this.bookServiceUrl = bookServiceUrl;
    }

    @Override
    public void verifyBookId(Long bookId) {

    }

    private void unrecognizedStatusCode(Long bookId, HttpStatus statusCode) {
        throw new RuntimeException(String.format("Unrecognized status code %s when fetching bookID %s",
                statusCode, bookId));
    }
}
