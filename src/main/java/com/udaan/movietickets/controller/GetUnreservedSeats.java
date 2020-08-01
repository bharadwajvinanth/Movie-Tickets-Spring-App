package com.udaan.movietickets.controller;

import com.udaan.movietickets.model.Request;
import com.udaan.movietickets.model.Seats;
import com.udaan.movietickets.service.UnreservedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/unreservedseats")
@RestController
public class GetUnreservedSeats {
    private final UnreservedService unreservedService;

    public GetUnreservedSeats(UnreservedService unreservedService) {
        this.unreservedService = unreservedService;
    }

    @GetMapping
    public Seats unreservedSeats(@RequestBody Request request){
        List<Integer>seats = unreservedService.getUnreservedSeats(request);
        String message ;
        if(seats == null){
            message = "Screen doesn't exist or row number doesn't exist";
        }
        else{
            message = "Success";
        }
        return new Seats(seats,message);
    }
}
