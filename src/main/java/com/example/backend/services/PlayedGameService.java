package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.models.PlayedGame;
import com.example.backend.repositories.PlayedGameRepository;

@Service
public class PlayedGameService {

    @Autowired
    PlayedGameRepository playedGameRepository;

    public PlayedGame createGamePlayed(PlayedGame g) {
        return playedGameRepository.save(g);
    }
    
}