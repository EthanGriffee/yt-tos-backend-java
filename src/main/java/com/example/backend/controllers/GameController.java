package com.example.backend.controllers;

import com.example.backend.models.CreateGameWrapper;
import com.example.backend.models.Game;
import com.example.backend.models.PlayedGame;
import com.example.backend.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class GameController {

    @Autowired
    GameService service;

    @PostMapping("api/games")
    public Game createGame(
            @RequestBody CreateGameWrapper creategame) {
        if (service.checkPlayersAndRoles(creategame.getPlayers(), creategame.getRoles(), creategame.getMvp(), creategame.getLvp()))
            return service.createGame(creategame.getGame(), creategame.getPlayers(), creategame.getRoles(), creategame.getMvp(), creategame.getLvp());
        return null;
    }

    @GetMapping("api/games/{gid}/players")
    public Iterable<PlayedGame> findPlayersForGame(
        @PathVariable("gid") int gid) {
            return service.getPlayers(gid);
        }

    @GetMapping("api/games")
    public Iterable<Game> findAllGames() {
            return service.findAllGames();
        }
    
    @GetMapping("api/games/{gid}")
    public Game findGame(
        @PathVariable("gid") int gid) {
            return service.findGame(gid);
        }
}