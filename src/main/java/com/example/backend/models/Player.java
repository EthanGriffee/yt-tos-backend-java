package com.example.backend.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "players")
public class Player {

    @Id
    private String name;

    @OneToMany(mappedBy = "mvp")
    @JsonIgnore
    private List<Game> mvpGames = new ArrayList<>();

    @OneToMany(mappedBy = "lvp")
    @JsonIgnore
    private List<Game> lvpGames = new ArrayList<>();

    @OneToMany(mappedBy = "player")
    @JsonIgnore
    private List<PlayedGame> gamesPlayed = new ArrayList<>();

    public Player(String username) {
        this.name = username;
    }

    public List<Game> getMvpGames() {
        return mvpGames;
    }

    public void setMvpGames(List<Game> mvpGames) {
        this.mvpGames = mvpGames;
    }

    public List<Game> getLvpGames() {
        return lvpGames;
    }

    public void setLvpGames(List<Game> lvpGames) {
        this.lvpGames = lvpGames;
    }

    public List<PlayedGame> getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(List<PlayedGame> gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}