package com.udaan.movietickets.dao;

import com.udaan.movietickets.model.Screen;

import java.util.UUID;

public interface ScreenDao {
    int insertScreen(UUID id, Screen screen);
    default int addScreen(Screen screen) {
        UUID id = UUID.randomUUID();
        return insertScreen(id,screen);
    }
}
