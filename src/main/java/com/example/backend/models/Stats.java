package com.example.backend.models;

import com.example.backend.models.Game.winType;

public class Stats {
    Player player;
    int games_played;
    int games_won;
    int games_lost;
    int games_drawn;
    int mvps;
    int lvps;

    public Stats() {}

    public Stats(Player player) {
        this.player = player;
        this.games_played = player.getGamesPlayed().size();
        for(PlayedGame pg : player.getGamesPlayed()) {
            if (pg.getGame().getMvp().equals(this.player)) {
                mvps += 1;
            }
            else if (pg.getGame().getLvp().equals(this.player)) {
                lvps += 1;
            }

            winType winner = pg.getGame().getWinner();

            switch(pg.getRole().type) {
                case NEUTRAL_EVIL:
                    if (pg.getGame().isNeWin()) {
                        games_won += 1;
                    }
                    else {
                        games_lost += 1;
                    }
                case NEUTRAL_KILLING:
                    checkWinForRole(winner, winType.NK);
                    break;
                case TOWN_INVESTIGATIVE:
                case TOWN_KILLING:
                case TOWN_PROTECTIVE:
                case TOWN_SUPPORT:
                case JAILOR:
                    checkWinForRole(winner, winType.TOWN);
                    break;
                case MAFIOSO:
                case RANDOM_MAFIA:
                case GODFATHER:
                    checkWinForRole(winner, winType.MAFIA);
                    break;      
            }
        }
    }

    private void checkWinForRole(winType one, winType two) {
        if (one == two) {
            games_won += 1;
        }
        else if (one == winType.DRAW) {
            games_drawn += 1;
        }
        else {
            games_lost += 1;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getGames_played() {
        return games_played;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public int getGames_won() {
        return games_won;
    }

    public void setGames_won(int games_won) {
        this.games_won = games_won;
    }

    public int getGames_lost() {
        return games_lost;
    }

    public void setGames_lost(int games_lost) {
        this.games_lost = games_lost;
    }

    public int getGames_drawn() {
        return games_drawn;
    }

    public void setGames_drawn(int games_drawn) {
        this.games_drawn = games_drawn;
    }

    public int getMvps() {
        return mvps;
    }

    public void setMvps(int mvps) {
        this.mvps = mvps;
    }

    public int getLvps() {
        return lvps;
    }

    public void setLvps(int lvps) {
        this.lvps = lvps;
    }
}