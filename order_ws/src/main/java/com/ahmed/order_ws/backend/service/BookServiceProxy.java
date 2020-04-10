package com.ahmed.order_ws.backend.service;

import com.ahmed.order_ws.backend.BookNotFoundException;
import com.ahmed.order_ws.backend.model.BookRes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
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
    public void verifyBookId(String bookId) {
        ResponseEntity<BookRes> result = null;
        try {
            result = restTemplate.getForEntity(bookServiceUrl, BookRes.class, bookId);
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
                return ;
            case NOT_FOUND:
                throw new BookNotFoundException();
            default:
                unrecognizedStatusCode(bookId, result.getStatusCode());
        }

    }

    @Override
    public void findByBookTitle(String bookTitle) {
        ResponseEntity<BookRes> result = null;
        try {
            result = restTemplate.getForEntity(bookServiceUrl, BookRes.class, bookTitle);
        } catch (HttpClientErrorException e) {
            switch (e.getStatusCode()) {
                case NOT_FOUND:
                    throw new BookNotFoundException();
                default:
                    unrecognizedStatusCode(bookTitle, e.getStatusCode());
            }
        }
        switch (result.getStatusCode()) {
            case OK:
                return;
            case NOT_FOUND:
                throw new BookNotFoundException();
            default:
                unrecognizedStatusCode(bookTitle, result.getStatusCode());
        }

    }

    private void unrecognizedStatusCode(String bookTitle, HttpStatus statusCode) {
        throw new RuntimeException(String.format("Unrecognized status code %s when fetching bookID %s",
                statusCode, bookTitle));
    }
}
