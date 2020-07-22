package com.example.backend.controllers;

import com.example.backend.models.Stats;
import com.example.backend.services.StatsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class StatsController {

    @Autowired
    StatsService service;

    @GetMapping("api/stats-player")
    public List<Stats> getAllPlayerStats() {
            return service.getPlayerStats();
        }
    
    @GetMapping("api/stats-roles")
    public List<Stats> getAllRoleStats() {
            return service.getRoleStats();
        }

    @GetMapping("api/stats/{name}")
    public List<Stats> getStatsForPlayer(
        @PathVariable("name") String name){
            return service.getPlayerStats(name);
        }
    
}