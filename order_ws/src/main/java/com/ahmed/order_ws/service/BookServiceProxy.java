package com.ahmed.order_ws.service;

import com.ahmed.order_ws.model.Book;
import com.ahmed.order_ws.model.BookResponseModel;
import com.ahmed.order_ws.model.CustomerResponseModel;
import com.ahmed.order_ws.util.BookNotFoundException;
import com.ahmed.order_ws.util.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class BookServiceProxy implements BookServiceRestTemplete {
    private RestTemplate restTemplate;
    public static final String BOOK_WS_URL = "http://localhost:8011/books/%s";

    public BookServiceProxy(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public BookResponseModel getBook(String bookId) {
        String bookServiceUrl = String.format(BOOK_WS_URL, bookId);
        BookResponseModel book = restTemplate.getForObject(bookServiceUrl, BookResponseModel.class);
        return book;
    }
}
