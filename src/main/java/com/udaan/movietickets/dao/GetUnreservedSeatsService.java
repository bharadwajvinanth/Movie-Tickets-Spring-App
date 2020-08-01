package com.udaan.movietickets.dao;

import com.udaan.movietickets.model.Request;
import com.udaan.movietickets.model.Screen;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GetUnreservedSeatsService implements GetUnreservedDao{

    @Override
    public List<Integer> getUnreservedSeats(Request request) {
        List<Screen> screenList = AddScreenService.getScreenList();
        String requestedScreen = request.getScreenName();
        int requestedRow = request.getRow();
        List<Integer> unreservedSeats = new ArrayList<>();
        for(int i=0;i<screenList.size();i++){
            Screen currentScreen = screenList.get(i);
            if(requestedScreen.equals(currentScreen.getScreenName())){
                int numberRows = currentScreen.getNumberRows();
                int seatsPerRow = currentScreen.getSeatRow();
                List<Integer>filledSeats;
                if(requestedRow > numberRows){
                    return null;
                }
                if(currentScreen.getReservedSeats().get(requestedRow) != null){
                    filledSeats = currentScreen.getReservedSeats().get(requestedRow);
                    for(int j=1;j<=seatsPerRow;j++){
                        if(!filledSeats.contains(j)){
                            unreservedSeats.add(j);
                        }
                    }
                }
                else{
                    for(int j=1;j<=seatsPerRow;j++){
                        unreservedSeats.add(j);
                    }
                }
                return unreservedSeats;
            }
        }
        return null;
    }
}
