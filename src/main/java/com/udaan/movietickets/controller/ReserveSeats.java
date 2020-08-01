package com.udaan.movietickets.controller;

import com.udaan.movietickets.model.Request;
import com.udaan.movietickets.model.Status;
import com.udaan.movietickets.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reserveseats")
@RestController
public class ReserveSeats {
    private final ReserveService reserveService;

    @Autowired
    public ReserveSeats(ReserveService reserveService) {
        this.reserveService = reserveService;
    }
    @GetMapping
    public Status reserveSeats(@RequestBody Request request) {
        int result = reserveService.reserveSeats(request);
        String status,message;
        if(result == 4)
            status = "Success";
        else
            status = "Failure";
        switch(result){
            case 0:
                message = "Row is greater than the available rows";
                break;
            case 1:
                message = "Requested seat is greater than the seats per row";
                break;
            case 2:
                message = "Requested seats has been already reserved";
                break;
            case 3:
                message = "Screen not found";
                break;
            default:
                message ="Successfully reserved seats";
        }
        return (new Status(status, message));
    }
}
