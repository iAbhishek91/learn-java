package javaBasics.generics.withGenerics;

import java.util.ArrayList;

// mention the type of Team it is
public class Team<T extends Player> {

    private final String teamName;
    private final ArrayList<T> players = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addPlayer(T p) {
        if (players.contains(p)) {
            System.out.println(p.toString() + "is already in the team");
            return;
        }
        players.add(p);
    }

    public void listAllPlayer() {
        for(T player:players) {
            System.out.println(player.toString());
        }
    }

    public void getTeamSize() {
        System.out.println(teamName + " has " + players.size() + " players.");
    }
}
