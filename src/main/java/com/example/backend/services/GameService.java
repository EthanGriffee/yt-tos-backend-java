package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.example.backend.models.Game;
import com.example.backend.models.PlayedGame;
import com.example.backend.models.Player;
import com.example.backend.repositories.GameRepository;
import com.example.backend.repositories.PlayedGameRepository;
import com.example.backend.repositories.PlayerRepository;
import com.example.backend.repositories.RoleRepository;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayedGameRepository playedGameRepository;

    @Autowired
    RoleRepository roleRepository;

    public Game createGame(Game g, List<String> usernames, List<String> rolenames, int mvp, int lvp) {
        g = gameRepository.save(g);
        for (int x = 0; x < 15; x++) {
            Player being_added;
            Optional<Player> p = playerRepository.findById(usernames.get(x));
            if (p.isPresent()) {
                being_added = p.get();
            }
            else {
                being_added = playerRepository.save(new Player(usernames.get(x)));
            }
            if (mvp == x) {
                g.setMvp(being_added);
            }
            if (lvp == x) {
                g.setLvp(being_added);
            }
            playedGameRepository.save(new PlayedGame(g, being_added, roleRepository.findById(rolenames.get(x)).get()));
        }
        return g;
    }

    public boolean checkPlayersAndRoles(List<String> usernames, List<String> rolenames, int mvp, int lvp) {
        if (usernames.size() == 15 && usernames.size() == 15 && Math.abs(mvp) <= 14 && Math.abs(lvp) <= 14 && mvp != lvp) {
            Set<String> appeared = new HashSet<String>();
            for (String username : usernames) {
              if (!appeared.add(username)) {
                System.out.printf("Bad username given. %s", username);
                return false;
              }
            }
            for (String role : rolenames) {
                if (!roleRepository.findById(role).isPresent()) {
                    System.out.printf("Bad role given %s", role);
                    return false;
                }
            }
            // ADD ROLE CHECKS
            return true;
        }
        System.out.println("Bad game given");
        System.out.printf("%d %d %d %d %d", usernames.size(), rolenames.size(), Stream.of(usernames).distinct().count(), mvp, lvp);
        return false;
    }

    public List<PlayedGame> getPlayers(int gid) {
        return gameRepository.findById(gid).get().getPlayers();
    }

    public Iterable<Game> findAllGames() {
        return gameRepository.findAll();
    }

    public Game findGame(int gid) {
        return gameRepository.findById(gid).get();
    }

    public void deleteGame(int gid) {
        Optional<Game> result = gameRepository.findById(gid);
        if (result.isPresent()) {
            List<PlayedGame> lpg = result.get().getPlayers();
            List<Player> playersChecking = new ArrayList<Player>();
            for (PlayedGame pg : lpg) {
                playersChecking.add(pg.getPlayer());
                playedGameRepository.deleteById(pg.getId());
            }
            gameRepository.deleteById(gid);
            for (Player p : playersChecking) {
                if (p.getGamesPlayed().size() == 0) {
                    playerRepository.delete(p);
                }
            }
        }
    }

    public int editGame(Game g) {
        Optional<Game> result = gameRepository.findById(g.getId());
        if (result.isPresent()) {
            Set<Player> appeared = new HashSet<Player>();
            for (PlayedGame p : g.getPlayers()) {
                if (!appeared.add(p.getPlayer())) {
                System.out.printf("Bad username given. %s", p.getPlayer().getName());
                return -1;
                }
                if (!roleRepository.findById(p.getRole().getName()).isPresent()) {
                    System.out.printf("Bad role given %s", p.getRole().getName());
                    return -1;
                }
            }
            for (PlayedGame p : g.getPlayers()) {
                //playedGameRepository.save(p);
            }
            gameRepository.save(g);
            return 0;
        }
        return -1;


    }
    
}