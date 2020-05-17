package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Player;
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
    
}