package com.ahmed.order_ws.service;

import com.ahmed.order_ws.model.Book;
import com.ahmed.order_ws.util.BookNotFoundException;
import com.ahmed.order_ws.util.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class BookServiceProxy implements BookServiceRestTemplete {
    private RestTemplate restTemplate;
    public static final String BOOK_WS_URL = "localhost:8011/books/%s";

    private String bookServiceUrl;

    public BookServiceProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void verifyBookId(String bookId) {
        bookServiceUrl = String.format(BOOK_WS_URL,bookId);
        ResponseEntity<Book> result = null;
        try {
            result = restTemplate.getForEntity(bookServiceUrl, Book.class, bookId);
        } catch (HttpClientErrorException e) {
            switch (e.getStatusCode()) {
                case NOT_FOUND:
                    throw new BookNotFoundException();
                default:
                    unrecognizedStatusCode(bookId, e.getStatusCode());
            }
        }
        switch (result.getStatusCode()) {
            case OK:
                return;
            case NOT_FOUND:
                throw new CustomerNotFoundException();
            default:
                unrecognizedStatusCode(bookId, result.getStatusCode());
        }
    }

    private void unrecognizedStatusCode(String bookId, HttpStatus statusCode) {
        throw new RuntimeException(String.format("Unrecognized status code %s when fetching bookId %s",
                statusCode, bookId));
    }
}
