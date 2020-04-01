package com.ahmed.common.book;

public class DeleteBookResponse {
    private String id;

    public DeleteBookResponse() {
    }

    public DeleteBookResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
