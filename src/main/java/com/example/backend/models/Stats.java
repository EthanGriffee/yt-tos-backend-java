package com.example.backend.models;

import com.example.backend.models.Game.winType;
import com.example.backend.constants.ConstantRoles;

import java.util.List;

public class Stats {

    int games_played;
    int games_won;
    int games_lost;
    int games_drawn;
    int[] roles_to_wins = new int[ConstantRoles.role_to_index.size()];
    int[] roles_to_draws = new int[ConstantRoles.role_to_index.size()];
    int[] role_to_games_played = new int[ConstantRoles.role_to_index.size()];
    int mvps;
    int lvps;

    public Stats() {}

    public Stats(Player player) {
        this(player.getGamesPlayed());
    }

    public Stats(List<PlayedGame> lpg) {
        this.games_played = lpg.size();
        for(PlayedGame pg : lpg) {
            addGamePlayed(pg);
        }
        
    }

    public void addGamePlayed(PlayedGame pg) {
        if (pg.getGame().getMvp().equals(pg.getPlayer())) {
            mvps += 1;
        }
        else if (pg.getGame().getLvp().equals(pg.getPlayer())) {
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
                break;
            case NEUTRAL_KILLING:
                checkWinForRole(winner, winType.NK, pg.getRole());
                break;
            case TOWN_INVESTIGATIVE:
            case TOWN_KILLING:
            case TOWN_PROTECTIVE:
            case TOWN_SUPPORT:
            case JAILOR:
                checkWinForRole(winner, winType.TOWN, pg.getRole());
                break;
            case MAFIOSO:
            case RANDOM_MAFIA:
            case GODFATHER:
                checkWinForRole(winner, winType.MAFIA, pg.getRole());
                break;      
        }
    }

    private void checkWinForRole(winType one, winType two, Role role) {
        if (one == two) {
            games_won += 1;
            roles_to_wins[ConstantRoles.role_to_index.get(role.getName())] = roles_to_wins[ConstantRoles.role_to_index.get(role.getName())]  + 1;
        }
        else if (one == winType.DRAW) {
            games_drawn += 1;
            roles_to_draws[ConstantRoles.role_to_index.get(role.getName())] = roles_to_draws[ConstantRoles.role_to_index.get(role.getName())]  + 1;
        }
        else {
            games_lost += 1;
        }
        role_to_games_played[ConstantRoles.role_to_index.get(role.getName())] = role_to_games_played[ConstantRoles.role_to_index.get(role.getName())]  + 1;
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