package com.example.backend.models;

import javax.persistence.*;

@Entity
@Table(name = "playedgame")
public class PlayedGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Game game;

    @ManyToOne
    private Role role;

    @ManyToOne
    private Player player;

    public PlayedGame(Game g, Player p, Role r) {
        this.game = g;
        this.role = r;
        this.player = p;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
}