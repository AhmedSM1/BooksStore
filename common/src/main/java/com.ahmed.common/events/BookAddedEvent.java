package com.ahmed.common.events;


public class BookAddedEvent implements BookEvent {
    private String id;
    private String title;
    private int stock;
    private double price;

    public BookAddedEvent(String id, String title, int stock, double price) {
        this.id = id;
        this.title = title;
        this.stock = stock;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
