package com.udaan.movietickets.dao;

import com.udaan.movietickets.model.Request;

import java.util.List;

public interface GetUnreservedDao {
    List<Integer> getUnreservedSeats(Request request);
}
