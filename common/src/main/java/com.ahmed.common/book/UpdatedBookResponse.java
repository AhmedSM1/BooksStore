package com.ahmed.common.book;

public class UpdatedBookResponse {
    private String id;

    public UpdatedBookResponse() {
    }

    public UpdatedBookResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
