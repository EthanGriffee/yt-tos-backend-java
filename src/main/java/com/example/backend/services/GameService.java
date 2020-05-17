package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

import com.example.backend.models.Game;
import com.example.backend.models.PlayedGame;
import com.example.backend.models.Role;
import com.example.backend.models.Player;
import com.example.backend.repositories.GameRepository;
import com.example.backend.repositories.PlayedGameRepository;
import com.example.backend.repositories.PlayerRepository;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayedGameRepository playedGameRepository;

    public Game createGame(Game g, List<Player> players, List<Role> roles) {
        g = gameRepository.save(g);
        for (int x = 0; x < 15; x++) {
            Player p = playerRepository.save(players.get(0));
            playedGameRepository.save(new PlayedGame(g, p, roles.get(0)));
        }
        return g;
    }

    public boolean checkPlayersAndRoles(List<Player> players, List<Role> roles) {
        if (players.size() == 15 && roles.size() == 15 && Stream.of(players).distinct().count() == 15) {
            // ADD CHECKS FOR ROLLES
            return true;
        }
        return false;
    }

    public List<PlayedGame> getPlayers(int gid) {
        return gameRepository.findById(gid).get().getPlayers();
    }
    
}