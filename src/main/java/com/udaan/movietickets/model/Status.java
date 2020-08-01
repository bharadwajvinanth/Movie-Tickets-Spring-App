package com.udaan.movietickets.model;

public class Status {
    private final String status;
    private final String message;

    public Status(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
