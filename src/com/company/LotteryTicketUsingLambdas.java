package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryTicketUsingLambdas {

    public static void main(String[] args) {



        System.out.println("-----------------------");

        ScoutEPLPlayers harry = new ScoutEPLPlayers("Harry Maguire", "Center Back",
                80, 0);
        ScoutEPLPlayers ben = new ScoutEPLPlayers("Ben White", "Center Back",
                40, 0);
        ScoutEPLPlayers bruno = new ScoutEPLPlayers("Bruno Fernandez", "Central Midfield",
                90, 0);
        ScoutEPLPlayers james = new ScoutEPLPlayers("James Rodriguez", "Central Midfield",
                17, 8);
        ScoutEPLPlayers ronaldo = new ScoutEPLPlayers("Christiano Ronaldo", "Central Striker",
                300, 30);
        ScoutEPLPlayers smith = new ScoutEPLPlayers("Smith Rowe", "Central Midfield",
                50, 0);


        EPLClubs manutd = new EPLClubs("Manchester United");
        manutd.addPlayerToScoutBucket(harry);
        manutd.addPlayerToScoutBucket(bruno);
        manutd.addPlayerToScoutBucket(ronaldo);

            EPLClubs arsenal = new EPLClubs("Arsenal");
            arsenal.addPlayerToScoutBucket(ben);
            arsenal.addPlayerToScoutBucket(smith);

        List<EPLClubs> eplClubsList = new ArrayList<>();
        eplClubsList.add(manutd);
        eplClubsList.add(arsenal);

        eplClubsList.stream()
                        .flatMap(eplClub -> eplClub.getPlayers().stream())
                .forEach(System.out::println);




        System.out.println("-----------------------$$$$$$$$$$$$-----------------------");

        Map<Integer, List <ScoutEPLPlayers>> groupByMatchApp = eplClubsList.stream()
                        .flatMap(eplClubsLi -> eplClubsLi.getPlayers().stream())
                        // sort by match app in Decending order

                                        .sorted((p2, p1) -> p2.getMatchApp() - p1.getMatchApp() )
                        .collect(Collectors.groupingBy(ScoutEPLPlayers::getMatchApp));

        groupByMatchApp.forEach((k,v) -> System.out.println(k  + " : " + v));

        System.out.println("-----------------------GGGGGGGG-----------------------");

        eplClubsList.stream()
                .flatMap(eplteam -> eplteam.getPlayers().stream())
                        .filter(p -> p.getMatchApp() > 50)
                .reduce((e1, e2) -> e1.getNumberOfTrophyWins() < e2.getNumberOfTrophyWins() ? e1 : e2)
                .ifPresent(System.out::println );

//        groupByMatchApp.forEach((k,v) -> System.out.println(k  + " : " + v));


        System.out.println("-----------------------***-----------------------");
        System.out.println("-----------------------***-----------------------");


        List<String> ticketNumbers = Arrays.asList(
                "N4430", "N2336",
                "B1223", "B2216",
                "G1534", "G4492", "G2603", "G2750", "g4364",
                "I2236", "I5147", "I2349",
                "K1234", "F2345", "D4356", "D5678", "Q6789");

        List<String> sortedTicketNumbers = ticketNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        //print sorted ticket numbers

        sortedTicketNumbers.forEach(System.out::println);


        List<String> gNumbers = new ArrayList<>();

        ticketNumbers.forEach(number -> {
            if(number.toLowerCase().startsWith("b")) {
                gNumbers.add(number);
//                System.out.println(number);
            }
        });

        System.out.println("use lamda expressions to filter sort and find " );

        ticketNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("I"))
                .sorted()
                .forEach(System.out::println);

//        for(String s : ticketNumbers) {
//            System.out.println(s.toLowerCase());
//        }


        Stream<String> ioNumberStream = Stream.of("I3236", "I2217", "I3329", "O1371");
        Stream<String> inNumberStream = Stream.of("N4043", "N3634", "I2631", "I1731");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("-----------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());
    }
}