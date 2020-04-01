package com.ahmed.common.book;

public class CreateBookResponse {
    private String id;

    public CreateBookResponse() {
    }

    public CreateBookResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
