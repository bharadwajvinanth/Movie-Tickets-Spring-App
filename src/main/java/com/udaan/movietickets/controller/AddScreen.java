package com.udaan.movietickets.controller;

import com.udaan.movietickets.model.Screen;
import com.udaan.movietickets.service.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/addscreen")
@RestController
public class AddScreen {
    private final ScreenService screenService;

    @Autowired
    public AddScreen(ScreenService screenService) {
        this.screenService = screenService;
    }
    @PostMapping
    public void addScreen(@RequestBody Screen screen) {
        screenService.addScreen(screen);
    }
}
