package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players = new ArrayList<>();
    public static List<Integer> totalPlayerScore = new ArrayList<>();
    public Die die = new Die(6);
    private Player player;
    private final int numberOfDice;

    public Game(int numberOfPlayers, int numberOfRounds, int numberOfDice) {
        // Set number of dice
        this.numberOfDice = numberOfDice;

        // Generate number of players
        generatePlayers(numberOfPlayers);
        showPlayers();
        rounds(numberOfRounds);
    }

    private void generatePlayers(int numberOfPlayers) {
        // Generate the amount of players
        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = CLI.getString("\nWhat should we call you?: ");
            Player newPlayer = new Player(playerName);
            newPlayer.playersDice = generateDice();
            players.add(newPlayer);
        }
    }

    public void playerTurn() {
        for (Player p : players) {
            System.out.println(p.getName() + " it is your turn to roll!\nPress enter my friend!");
            CLI.proceed();
            System.out.print(p.getName() + " rolled ");
            roll();
        }
    }

    public void roll() {
        List<Integer> gameScores = new ArrayList<>();
        int totalScore = 0, diceScore;

        for (int i = 0; i < numberOfDice; i++) {
            diceScore = die.diceRoll();
            gameScores.add(diceScore);
            System.out.print(gameScores.get(i) + " ");
            totalScore += gameScores.get(i);
        }
        System.out.println();
        System.out.println("-".repeat(16));
//        player.playersDice = new ArrayList<>();
        totalPlayerScore.add(totalScore);
        System.out.println("Total points: " + totalScore);
        System.out.println("-".repeat(16) + "\n");
    }

    public void rounds(int numberOfRounds) {
        // Number of rounds method is all set
        for (int i = 0; i < numberOfRounds; i++) {
            CLI.proceed();
            playerTurn();
            System.out.println();
            System.out.println("""
                    ~~~~~~~~~~~~~~~~~~~~~~~~~
                    Ready for the next round?
                    Press enter my friend! :)
                    ~~~~~~~~~~~~~~~~~~~~~~~~~
                    """);
        }
        printScore();
        System.out.println("-".repeat(30));
        CLI.proceed();
        System.out.println("""
                You have reached the end my fellow warriors!
                                
                If I do not see your faces again then farewell brave warriors!
                                
                If you wish to play again then simply press enter.
                """);
    }

    public void printScore() {
        int scores = 0;
        for (int i = 0; i < totalPlayerScore.size(); i++) {

            for (Player p : players) {

                System.out.printf("%d) %s has %d points\n", i + 1, p.getName(), scores);
            }
        }
    }

    public void showPlayers() {
        System.out.println("\nOkay! Our warriors are set for war!");
        System.out.println("~".repeat(35));
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.printf("Player%d) %s\n", i + 1, player.getName());
        }
        System.out.println("~".repeat(35));
        System.out.println("Please, press enter to start the Dice War!");
    }

    private ArrayList<Die> generateDice() {
        ArrayList<Die> tempDice = new ArrayList<>();
        for (int i = 0; i < numberOfDice; i++) {
            Die die = new Die(6);
            tempDice.add(die);
        }
        return tempDice;
    }
}
