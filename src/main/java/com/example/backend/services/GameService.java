package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.example.backend.models.Game;
import com.example.backend.models.PlayedGame;
import com.example.backend.models.Role;
import com.example.backend.models.Player;
import com.example.backend.repositories.GameRepository;
import com.example.backend.repositories.PlayedGameRepository;
import com.example.backend.repositories.PlayerRepository;
import com.example.backend.repositories.RoleRepository;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayedGameRepository playedGameRepository;

    @Autowired
    RoleRepository roleRepository;

    public Game createGame(Game g, List<String> usernames, List<String> rolenames, int mvp, int lvp) {
        g = gameRepository.save(g);
        for (int x = 0; x < 15; x++) {
            Player being_added;
            Optional<Player> p = playerRepository.findById(usernames.get(0));
            if (p.isPresent()) {
                being_added = p.get();
            }
            else {
                being_added = playerRepository.save(new Player(usernames.get(0)));
            }
            if (mvp == x) {
                g.setMvp(being_added);
            }
            if (lvp == x) {
                g.setLvp(being_added);
            }
            playedGameRepository.save(new PlayedGame(g, being_added, roleRepository.findById(rolenames.get(0)).get()));
        }
        return g;
    }

    public boolean checkPlayersAndRoles(List<String> usernames, List<String> rolenames, int mvp, int lvp) {
        if (usernames.size() == 15 && rolenames.size() == 15 && Stream.of(usernames).distinct().count() == 15 && Math.abs(mvp) <= 14 && Math.abs(lvp) <= 14 && mvp != lvp) {
            // ADD CHECKS FOR ROLLES
            return true;
        }
        return false;
    }

    public List<PlayedGame> getPlayers(int gid) {
        return gameRepository.findById(gid).get().getPlayers();
    }

    public Iterable<Game> findAllGames() {
        return gameRepository.findAll();
    }
    
}