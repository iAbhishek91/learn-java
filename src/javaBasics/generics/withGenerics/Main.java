package javaBasics.generics.withGenerics;

public class Main {
    public static void main(String[] args) {
        FootballPlayer bekham = new FootballPlayer("Bekham");
        CricketPlayer sachin = new CricketPlayer("Sachin");

        // this still works as Java allows type to be optional
        Team manchester = new Team("Manchester");
        manchester.addPlayer(bekham);
        manchester.addPlayer(sachin);

        manchester.listAllPlayer();
        manchester.getTeamSize();
        // The PROBLEM-1:
        // Sachin should not be added to manchester as he is a cricket player

        //To solve the above problem
        //Define team with specific type
        Team<FootballPlayer> liverpool = new Team<>("Liverpool");
        liverpool.addPlayer(bekham);
        // liverpool.addPlayer(sachin); // throws err at compile time
        liverpool.listAllPlayer();
        liverpool.getTeamSize();

        Team<CricketPlayer> india = new Team<>("India");
        // india.addPlayer(bekham); // throws err at compile time
        india.addPlayer(sachin);
        india.listAllPlayer();
        india.getTeamSize();

        // Now there is another PROBLEM-2:
        // we an assign any type to Team
        // for example: Team<String> will also work at compile time, but will fail during run time

        //To solve this problem
        // we change class definition from `public class Team<T> {` to `public class Team<T extends Players> {`
    }
}
