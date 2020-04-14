package com.ahmed.order_ws.model;

public class CommandResponse {
    private String id;

    public CommandResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
