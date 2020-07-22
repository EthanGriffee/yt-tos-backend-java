package com.example.backend.repositories;

import java.util.List;

import com.example.backend.models.PlayedGame;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PlayedGameRepository extends CrudRepository<PlayedGame, Integer> {

    @Query("SELECT playedGame FROM PlayedGame as playedGame WHERE playedGame.role.name=:roleName")
    public List<PlayedGame> findStatsForRole(@Param("roleName") String roleName);
}