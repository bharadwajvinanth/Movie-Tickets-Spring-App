package com.udaan.movietickets.model;

import java.util.List;

public class Seats {
    List<Integer> seats;
    String message;
    public Seats(List<Integer> seats,String message){
        this.seats = seats;
        this.message = message;
    }
    public List<Integer> getSeats() {
        return seats;
    }

    public String getMessage() {
        return message;
    }
}
