package com.example.backend.repositories;

import com.example.backend.models.PlayedGame;
import com.example.backend.models.Stats;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlayedGameRepository extends CrudRepository<PlayedGame, Integer> {
    @Query("SELECT pg.player, COUNT(*) as games_played FROM PlayedGame as pg WHERE pg.id=:id")
    public Stats findStats(@Param("id") Integer userId);
}