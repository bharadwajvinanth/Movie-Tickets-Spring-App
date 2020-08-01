package com.udaan.movietickets.dao;

import com.udaan.movietickets.model.Request;
import com.udaan.movietickets.model.Screen;
import org.springframework.stereotype.Repository;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class ReserveScreenService implements ReserveDao{
    @Override
    public int reserveSeat(Request request) { ;
        List<Screen>screenList = AddScreenService.getScreenList();
        int row = request.getRow();
        int[] requestSeats = request.getSeats();
        for(int i=0;i<screenList.size();i++) {
            Screen currentScreen = screenList.get(i);
            if (currentScreen.getScreenName().equals(request.getScreenName())) {
                int numberRows = currentScreen.getNumberRows();
                if(row>numberRows){
                    return 0;
                }
                int seatsRow = currentScreen.getSeatRow();
                for (int j = 0; j < requestSeats.length; j++){
                    if(requestSeats[i]>seatsRow){
                        return 1;
                    }
                }
                HashMap<Integer,List<Integer>> reservedSeats = (HashMap<Integer, List<Integer>>) currentScreen.getReservedSeats();
                List<Integer> filledSeats = new ArrayList<>();
                if(reservedSeats.get(row) != null) {
                    filledSeats = reservedSeats.get(row);
                    for (int j = 0; j < requestSeats.length; j++) {
                        for (int k = 0; k < filledSeats.size(); k++) {
                            if (requestSeats[j] == filledSeats.get(k))
                                return 2;
                        }
                    }
                }
                for (int j = 0; j < requestSeats.length; j++) {
                    filledSeats.add(requestSeats[j]);
                }
                reservedSeats.put(row,filledSeats);
                currentScreen.setReservedSeats(reservedSeats);
                return 4;
            }
        }
        return 3;
    }
}
