package com.udaan.movietickets.dao;

import com.udaan.movietickets.model.Screen;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AddScreenService implements ScreenDao{
    private static List<Screen>screenList = new ArrayList<>();

    public static List<Screen> getScreenList() {
        return screenList;
    }

    @Override
    public int insertScreen(UUID id, Screen screen) {
        screenList.add(new Screen(id,screen.getScreenName(),screen.getNumberRows(),screen.getSeatRow(),screen.getAisleSeats()));
        return 1;
    }
}
