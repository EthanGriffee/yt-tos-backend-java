package com.example.backend.controllers;

import com.example.backend.models.Game;
import com.example.backend.models.PlayedGame;
import com.example.backend.models.Stats;
import com.example.backend.models.Player;
import com.example.backend.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class StatsController {

    @Autowired
    PlayerService service;

    @GetMapping("api/stats")
    public List<Stats> getAllStats() {
            return service.getStats();
        }

    @GetMapping("api/stats/{name}")
    public List<Stats> getStatsForPlayer(
        @PathVariable("name") String name){
            return service.getStats(name);
        }
    
}