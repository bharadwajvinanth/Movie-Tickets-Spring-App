package com.udaan.movietickets.dao;

import com.udaan.movietickets.model.Request;
import com.udaan.movietickets.model.Screen;

public interface ReserveDao {
    int reserveSeat(Request request);
}
