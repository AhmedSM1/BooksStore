package com.ahmed.order_ws.backend.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Embeddable
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "order")
public class OrderItemPK{

    
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @Column(name = "BOOK_ID", nullable = false)
    private String bookId;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public OrderItemPK(Order order, String bookId) {
        this.order = order;
        this.bookId = bookId;
    }

    public OrderItemPK() {
    super();
    }
    

    
}