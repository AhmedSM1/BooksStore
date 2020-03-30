package com.ahmed.order_ws.backend.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ahmed.common.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
