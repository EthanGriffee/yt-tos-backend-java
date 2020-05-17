package com.example.backend.controllers;

import com.example.backend.models.Game;
import com.example.backend.models.PlayedGame;
import com.example.backend.models.Role;
import com.example.backend.models.Player;
import com.example.backend.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PlayerController {


    @Autowired
    PlayerService service;

    @GetMapping("api/players/{username}")
    public Player getPlayers(
        @PathVariable("username") String username) {
            return service.getPlayer(username);
        }
    
}