package javaBasics.generics.withOutGenerics;

import java.util.ArrayList;

public class Team {
    private final String teamName;
    private ArrayList<Player> players = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }

    public void addPlayer(Player p) {
        if (players.contains(p)) {
            System.out.println(p.toString() + "is already in the team");
            return;
        }
        players.add(p);
    }

    public void listAllPlayer() {
        for(Player player:players) {
            System.out.println(player.toString());
        }
    }

    public void getTeamSize() {
        System.out.println(players.size());
    }
}
