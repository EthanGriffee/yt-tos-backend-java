package com.example.backend.models;

import java.util.List;

public class CreateGameWrapper {
    Game game;
     List<String> players;
     List<String> roles;
    int mvp;
    int lvp;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public int getMvp() {
        return mvp;
    }

    public void setMvp(int mvp) {
        this.mvp = mvp;
    }

    public int getLvp() {
        return lvp;
    }

    public void setLvp(int lvp) {
        this.lvp = lvp;
    }
}
