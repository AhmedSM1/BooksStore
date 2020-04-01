package com.ahmed.common.order;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.ahmed.common.books.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class OrderBook {

    @EmbeddedId
    @JsonIgnore
    private OrderBookPK primaryKey;

    @Column(nullable = false)
    private Integer quantity;

    public OrderBook(Order order, Book book, Integer quantity) {
        this.primaryKey = new OrderBookPK();
        primaryKey.setBook(book);
        primaryKey.setOrder(order);
        this.quantity = quantity;
    }

    public OrderBook() {
        super();
    }

    @JsonIgnore
    public OrderBookPK getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(OrderBookPK primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
