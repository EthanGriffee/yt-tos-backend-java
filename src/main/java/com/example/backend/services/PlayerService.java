package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.models.PlayedGame;
import com.example.backend.models.Player;
import com.example.backend.models.Stats;
import com.example.backend.repositories.PlayerRepository;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public Player createPlayer(Player p) {
        return playerRepository.save(p);
    }

    public Player getPlayer(String username) {
        return playerRepository.findById(username).get();
    }

    public List<PlayedGame> getPlayedGames(String username) {
        return playerRepository.findById(username).get().getGamesPlayed();
    }

    public List<Stats> getStats() {
        List<Stats> returning = new ArrayList<Stats>();
        for (Player p : playerRepository.findAll()) {
            returning.add(new Stats(p));
        }
        return returning;
    }
    
    public List<Stats> getStats(String username) {
        List<Stats> returning = new ArrayList<Stats>();
        for (Player p : playerRepository.findAll()) {
            returning.add(new Stats(p));
        }
        return returning;
    }
}