package com.company;

import java.util.ArrayList;
import java.util.List;

public class EPLClubs {

    private String name;
    private List<ScoutEPLPlayers> players;

    public EPLClubs(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

   public void addPlayerToScoutBucket(ScoutEPLPlayers player) {
       this.players.add(player);
   }

    public List<ScoutEPLPlayers> getPlayers() {
        return players;
    }
}
