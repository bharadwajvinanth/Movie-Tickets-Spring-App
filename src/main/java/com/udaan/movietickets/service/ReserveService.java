package com.udaan.movietickets.service;

import com.udaan.movietickets.dao.ReserveDao;
import com.udaan.movietickets.model.Request;
import com.udaan.movietickets.model.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReserveService {
    private final ReserveDao reserveDao;

    @Autowired
    public ReserveService(ReserveDao reserveDao) {
        this.reserveDao = reserveDao;
    }

    public int reserveSeats(Request request){
        return reserveDao.reserveSeat(request);
    }
}
