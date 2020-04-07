package com.ahmed.order_book.config;

import com.ahmed.order_book.domain.BookIsNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


//will get the order id and book id
public class ServiceProxyAnd implements OrderAndBookService {

    private RestTemplate restTemplate;


    @Value("${books_ws.service.url}")
    private String booksServiceUrl;

    @Value("${order_ws.service.url}")
    private String orderServiceUrl;

    public ServiceProxyAnd(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void verifyBooksBookId(String bookId) {
        Assert.notNull(booksServiceUrl, "Should not be null: " + booksServiceUrl);
        ResponseEntity<Book> result = null;
        try {
            result = restTemplate.getForEntity(booksServiceUrl, Book.class, bookId);

        } catch (HttpClientErrorException e) {
            switch (e.getStatusCode()) {
                case NOT_FOUND:
                    throw new BookIsNotFoundException();
                default:
                    unrecognizedStatusCode(bookId,result.getStatusCode());
            }
        }
        switch (result.getStatusCode()) {
            case OK:
                return;
            case NOT_FOUND:
                throw new BookIsNotFoundException();
            default:
                unrecognizedStatusCode(bookId, result.getStatusCode());
        }
    }

    @Override
    public void verifyOrdersOrderId(String orderId) {
        Assert.notNull(orderServiceUrl, "Should not be null: " + orderServiceUrl);
        ResponseEntity<Order> result = null;
        try {
            result = restTemplate.getForEntity(orderServiceUrl, Order.class, orderId);

        } catch (HttpClientErrorException e) {
            switch (e.getStatusCode()) {
                case NOT_FOUND:
                    throw new BookIsNotFoundException();
                default:
                    unrecognizedStatusCode(orderId,result.getStatusCode());
            }
        }
        switch (result.getStatusCode()) {
            case OK:
                return;
            case NOT_FOUND:
                throw new BookIsNotFoundException();
            default:
                unrecognizedStatusCode(orderId, result.getStatusCode());
        }
    }

    private void unrecognizedStatusCode(String bookId, HttpStatus statusCode) {
        throw new RuntimeException(String.format("Unrecognized status code %s when fetching bookId %s",
                statusCode, bookId));
    }
}
