package com.udaan.movietickets.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {
    private final String screenName;
    private final int row;
    private final int[] seats;

    public Request(@JsonProperty("screenName") String screenName,
                   @JsonProperty("row") int row,
                   @JsonProperty("seats") int[] seats) {
        this.screenName = screenName;
        this.row = row;
        this.seats = seats;
    }

    public String getScreenName() {
        return screenName;
    }

    public int[] getSeats() {
        return seats;
    }

    public int getRow() {
        return row;
    }

}

