package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import com.example.backend.models.Player;
import com.example.backend.models.Role;
import com.example.backend.models.Stats;
import com.example.backend.repositories.PlayedGameRepository;
import com.example.backend.repositories.PlayerRepository;
import com.example.backend.repositories.RoleRepository;

@Service
public class StatsService {
    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayedGameRepository pgRep;

    @Autowired
    RoleRepository roleRep;

    public List<Stats> getPlayerStats() {
        List<Stats> returning = new ArrayList<Stats>();
        for (Player p : playerRepository.findAll()) {
            returning.add(new Stats(p));
        }
        return returning;
    }
    
    public List<Stats> getPlayerStats(String username) {
        List<Stats> returning = new ArrayList<Stats>();
        for (Player p : playerRepository.searchPlayer(username)) {
            returning.add(new Stats(p));
        }
        return returning;
    }

    public List<Stats> getRoleStats() {
        List<Stats> returning = new ArrayList<Stats>();
        for (Role r : roleRep.findAll()) {
            returning.add(new Stats(r, pgRep.findStatsForRole(r.getName())));
        }
        return returning;
    }
}