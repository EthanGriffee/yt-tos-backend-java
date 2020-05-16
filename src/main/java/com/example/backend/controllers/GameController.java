package com.example.backend.controllers;

import com.example.backend.models.Game;
import com.example.backend.models.Role;
import com.example.backend.models.Player;
import com.example.backend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired
    GameService service;

    @PostMapping("api/games")
    public Game createGame(
            @RequestBody Game g,
            @RequestBody List<Player> players,
            @RequestBody List<Role> roles) {
        if (service.checkPlayersAndRoles(players, roles))
            return service.createGame(g, players, roles);
        return null;
    }
}