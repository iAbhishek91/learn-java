package javaBasics.generics.withOutGenerics;

public class Main {
    public static void main(String[] args) {
        Player bekham = new FootballPlayer("Bekham");
        Player sachin = new FootballPlayer("Sachin");

        Team manchester = new Team("Manchester");
        manchester.addPlayer(bekham);
        manchester.addPlayer(sachin);

        manchester.listAllPlayer();
        manchester.getTeamSize();
        // The PROBLEM:
        // Sachin should not be added to manchester as he is a cricket player
    }
}
