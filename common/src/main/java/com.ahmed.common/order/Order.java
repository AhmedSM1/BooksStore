package com.ahmed.common.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;




@Entity
@Table(name = "order")
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="orderItems")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "primaryKey.order")
    @Valid
    private List<OrderBook> orderItems = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<OrderBook> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderBook> orderItems) {
        this.orderItems = orderItems;
    }

    @Transient
    public Double getTotalPrice() {
        double sum = 0;
        List<OrderBook> orderItems = getOrderItems();
        for (OrderBook item : orderItems) {
            sum += item.getQuantity();
        }

        return sum;
    }
}
