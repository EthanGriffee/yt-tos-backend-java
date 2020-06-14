package com.example.backend.repositories;

import com.example.backend.models.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, String> {

    @Query("SELECT player FROM Player player WHERE player.name LIKE :username%")
    public List<Player> searchPlayer(@Param("username") String username);
    
}