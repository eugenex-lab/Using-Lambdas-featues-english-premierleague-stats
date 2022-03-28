package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        UnitedPLayers ronaldo  = new UnitedPLayers ("Ronaldo" , 35,"striker");
        UnitedPLayers rooney  = new UnitedPLayers ("Wayne Rooney" , 36,"striker");
        UnitedPLayers tevez  = new UnitedPLayers ("Tevez" , 37,"striker");
        UnitedPLayers bebatoov  = new UnitedPLayers ("BabaTope" , 37,"striker");

        List<UnitedPLayers> soccerPlayer = new ArrayList<>();
        soccerPlayer.add(ronaldo);
        soccerPlayer.add(rooney);
        soccerPlayer.add(tevez);
        soccerPlayer.add(bebatoov);

        Collections.sort(soccerPlayer, (soccerPlayer1 , soccerPlayer2) ->
                soccerPlayer1.getPlayerNames().compareTo(soccerPlayer2.getPlayerNames()));

        for(UnitedPLayers soccerPlayers : soccerPlayer) {
            System.out.println(soccerPlayers.getPlayerNames());
        }

        UpperConcat uc = (s1, s2) -> s1.toUpperCase() +  s2.toUpperCase();
        String sillyString = doStringStuff(uc, soccerPlayer.get(1).getPlayerNames(), soccerPlayer.get(1).getPlayerNames());
        System.out.println(sillyString);

    }


    public final static String doStringStuff(UpperConcat uc, String player1, String player2) {
        return uc.upperAndConcat(player1, player2);
    }
}


class UnitedPLayers {
    private String playerNames;
    private String playerPosition;
    private int age;

    public UnitedPLayers(String playerNames, int age , String playerPosition) {
        this.playerNames = playerNames;
        this.age = age;
        this.playerPosition = playerPosition ;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

interface UpperConcat {
    public String upperAndConcat(String s1, String s2);
}
