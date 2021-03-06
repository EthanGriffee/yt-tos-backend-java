package com.example.backend.models;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "game")
public class Game {

    public enum winType { TOWN, MAFIA, NK, DRAW; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String youtubeID;

    private String videoTitle;

    @ManyToOne
    private Player mvp;

    @ManyToOne
    private Player lvp;

    @OneToMany(mappedBy = "game")
    @JsonBackReference
    private List<PlayedGame> players;

    @Enumerated(EnumType.ORDINAL)
    private winType winner;

    boolean neWin;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PlayedGame> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayedGame> players) {
        this.players = players;
    }

    public Player getMvp() {
        return mvp;
    }

    public void setMvp(Player mvp) {
        this.mvp = mvp;
    }

    public Player getLvp() {
        return lvp;
    }

    public void setLvp(Player lvp) {
        this.lvp = lvp;
    }

    public winType getWinner() {
        return winner;
    }

    public void setWinner(winType winner) {
        this.winner = winner;
    }

    public boolean isNeWin() {
        return neWin;
    }

    public void setNeWin(boolean neWin) {
        this.neWin = neWin;
    }

    public String getYoutubeID() {
        return youtubeID;
    }

    public void setYoutubeID(String youtubeID) {
        this.youtubeID = youtubeID;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }
    
}