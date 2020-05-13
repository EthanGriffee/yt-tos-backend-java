package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.Game;
import com.example.backend.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public Game createGame(Game g) {
        return gameRepository.save(g);
    }
    
}