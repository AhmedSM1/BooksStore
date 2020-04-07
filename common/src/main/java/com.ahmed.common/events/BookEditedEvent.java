package com.ahmed.common.events;



public class BookEditedEvent implements BookEvent {
    private String id;
    private String title;
    private int stock;
    private double price;
    private String description;

    public BookEditedEvent(String id, String title, int stock, double price, String description) {
        this.id = id;
        this.title = title;
        this.stock = stock;
        this.price = price;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
