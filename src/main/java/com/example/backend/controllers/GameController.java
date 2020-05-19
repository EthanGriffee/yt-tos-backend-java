package com.example.backend.controllers;

import com.example.backend.models.Game;
import com.example.backend.models.PlayedGame;
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
            @RequestBody Game game,
            @RequestBody List<String> players,
            @RequestBody List<String> roles,
            @RequestBody int mvp,
            @RequestBody int lvp) {
        if (service.checkPlayersAndRoles(players, roles, mvp, lvp))
            return service.createGame(game, players, roles, mvp, lvp);
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
}