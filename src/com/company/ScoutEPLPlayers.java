package com.company;

public class ScoutEPLPlayers {
    private String playerName;
    private String manager; // manager's name
    private int matchApp; // position in premier league
    private int playerMarketValue;

    public ScoutEPLPlayers(String playerName, String position, int matchApp, int numberOfTrophyWins) {
        this.playerName = playerName;
        this.manager = position;
        this.matchApp = matchApp;
        this.playerMarketValue = numberOfTrophyWins;
    }

    public String getClubName() {
        return playerName;
    }

    public String getManager() {
        return manager;
    }

    public int getMatchApp() {
        return matchApp;
    }

    public int getNumberOfTrophyWins() {
        return playerMarketValue;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerMarketValue() {
        return playerMarketValue;
    }

    @Override
    public String toString() {
        return "ScoutEPLPlayers{" +
                "playerName='" + playerName + '\'' +
                ", manager='" + manager + '\'' +
                ", matchApp=" + matchApp +
                ", playerMarketValue=" + playerMarketValue +
                '}';
    }
}
