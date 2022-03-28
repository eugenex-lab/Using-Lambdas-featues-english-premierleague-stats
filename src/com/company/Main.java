package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
	// write your code here

        UnitedPLayers ronaldo  = new UnitedPLayers ("Ronaldo" , 150,"striker",200);
        UnitedPLayers rooney  = new UnitedPLayers ("Wayne Rooney" , 300,"striker",350);
        UnitedPLayers tevez  = new UnitedPLayers ("Tevez" , 200,"striker",150);
        UnitedPLayers bebatoov  = new UnitedPLayers ("BabaTope" , 200,"striker",100);
        UnitedPLayers nani  = new UnitedPLayers ("Luiz Nani " , 150,"winger",70);
        UnitedPLayers macheda  = new UnitedPLayers ("Fedrico Macheda" , 10,"winger",5);

        List<UnitedPLayers> soccerPlayers = new ArrayList<>();
        soccerPlayers.add(ronaldo);
        soccerPlayers.add(rooney);
        soccerPlayers.add(tevez);
        soccerPlayers.add(bebatoov);
        soccerPlayers.add(nani);
        soccerPlayers.add(macheda);

        printEPLstats(soccerPlayers, "United players with over 100", soccerPlayer -> soccerPlayer.getGoalStats() > 100);
        printEPLstats(soccerPlayers, "United players with LESS THAN  100", soccerPlayer -> soccerPlayer.getGoalStats() < 150);
        printEPLstats(soccerPlayers, "\nUnited players younger than 25", new Predicate<UnitedPLayers>() {
            @Override
            public boolean test(UnitedPLayers soccerPlayer) {
                return soccerPlayer.getMatchApp() > 35;
            }
        });

        IntPredicate greaterThan15 = i -> i > 15;
        IntPredicate lessThan100 = i -> i < 100;

        System.out.println(greaterThan15.test(10));
        int a = 20;
        System.out.println(greaterThan15.test(a + 5));

        System.out.println(greaterThan15.and(lessThan100).test(50));
        System.out.println(greaterThan15.and(lessThan100).test(15));

        Random random = new Random();
        Supplier<Integer> randomSupplier = () -> random.nextInt(1000);
        for(int i=0; i<10; i++) {
            System.out.println(randomSupplier.get());
        }
    }

    private static void printEPLstats(List<UnitedPLayers> soccerPlayers,
                                      String goalStatsText,
                                      Predicate<UnitedPLayers> statsCondition) {

        System.out.println(goalStatsText);
        System.out.println("==================");
        for(UnitedPLayers soccerPlayer : soccerPlayers) {
            if (statsCondition.test(soccerPlayer)) {
                System.out.println(" United players --> " + soccerPlayer.getPlayerNames() + " has match apperances of " + soccerPlayer.getMatchApp() +  " has a stat of " + soccerPlayer.getGoalStats() + " goals " );
            }
        }
    }
}


class UnitedPLayers {
    private String playerNames;
    private String playerPosition;
    private int matchApp;
    private int  goalStats;

    public UnitedPLayers(String playerNames, int matchApp, String playerPosition, int goalStats) {
        this.playerNames = playerNames;
        this.matchApp = matchApp;
        this.playerPosition = playerPosition ;
        this.goalStats = goalStats ;
    }

    public int getGoalStats() {
        return goalStats;
    }

    public void setGoalStats(int goalStats) {
        this.goalStats = goalStats;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public String getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(String playerNames) {
        this.playerNames = playerNames;
    }

    public int getMatchApp() {
        return matchApp;
    }

    public void setMatchApp(int matchApp) {
        this.matchApp = matchApp;
    }
}

