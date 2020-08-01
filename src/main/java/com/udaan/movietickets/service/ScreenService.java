package com.udaan.movietickets.service;

import com.udaan.movietickets.dao.ScreenDao;
import com.udaan.movietickets.model.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {
    private final ScreenDao screenDao;

    @Autowired
    public ScreenService(ScreenDao screenDao) {
        this.screenDao = screenDao;
    }
    public int addScreen(Screen screen){
        return screenDao.addScreen(screen);
    }
}
