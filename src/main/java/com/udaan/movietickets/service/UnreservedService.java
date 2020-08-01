package com.udaan.movietickets.service;

import com.udaan.movietickets.dao.GetUnreservedDao;
import com.udaan.movietickets.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnreservedService {
    private final GetUnreservedDao getUnreservedDao;

    @Autowired
    public UnreservedService(GetUnreservedDao getUnreservedDao) {
        this.getUnreservedDao = getUnreservedDao;
    }
    public List<Integer> getUnreservedSeats(Request request){
        return  getUnreservedDao.getUnreservedSeats(request);
    }
}
