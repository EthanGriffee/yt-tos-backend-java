package com.example.backend.repositories;

import com.example.backend.models.PlayedGame;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayedGameRepository extends CrudRepository<PlayedGame, Integer> {
    
}