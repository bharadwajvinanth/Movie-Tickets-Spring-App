package com.udaan.movietickets.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class Screen {
    private final UUID id;
    private final String screenName;
    private final int numberRows;
    private final int seatRow;
    private HashMap<Integer,List<Integer>>reservedSeats;
    private final int[] aisleSeats;

    public Screen(@JsonProperty("id") UUID id,
                  @JsonProperty("screenName") String screenName,
                  @JsonProperty("numberrows") int numberRows,
                  @JsonProperty("seatrow") int seatRow,
                  @JsonProperty("aisleseats") int[] aisleSeatsString) {
        this.id = id;
        this.screenName = screenName;
        this.numberRows = numberRows;
        this.seatRow = seatRow;;
        this.aisleSeats = aisleSeatsString;
        this.reservedSeats = new HashMap<>();
    }

    public int getNumberRows() {
        return numberRows;
    }

    public int getSeatRow() {
        return seatRow;
    }

    public String getScreenName() {
        return screenName;
    }

    public int[] getAisleSeats() {
        return aisleSeats;
    }

    public void setReservedSeats(HashMap<Integer, List<Integer>> reservedSeats) {
        this.reservedSeats = reservedSeats;
    }

    public Map<Integer, List<Integer>> getReservedSeats() {
        return reservedSeats;
    }
}
