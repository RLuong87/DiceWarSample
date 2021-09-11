package com.company;

import java.util.ArrayList;

public class Game {

    private final ArrayList<Player> players = new ArrayList<>();
    public static Die dice = new Die(6);
    private final int numberOfDice;
    private int sum = 0;

    public Game(int numberOfPlayers, int numberOfRounds, int numberOfDice) {
        // Set number of dice
        this.numberOfDice = numberOfDice;

        // Generate number of players
        generatePlayers(numberOfPlayers);
        showPlayers();
        rounds(numberOfRounds);
        checkWinner();
    }

    private void generatePlayers(int numberOfPlayers) {
        // Generate the amount of players
        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = CLI.getString("\nWhat should we call you?: ");
            Player newPlayer = new Player(playerName, 0);
            newPlayer.playersDice = generateDice();
            players.add(newPlayer);
        }
    }

    public void playerTurn(Player player, ArrayList<Die> numberOfDice) {
        ArrayList<Integer> scores = new ArrayList<>();
        String playerName = player.getName();
        int total = 0;

        for (int i = 0; i < numberOfDice.size(); i++) {
            int diceScore = dice.diceRoll();
            scores.add(diceScore);
            total += scores.get(i);
            System.out.printf("%s rolled a %d\n", playerName, scores.get(i));
        }
        System.out.println("-".repeat(15));
        System.out.println("Total score: " + total);
    }

    public void checkWinner() {
    }

    public void rounds(int numberOfRounds) {
        // Create a method to give each player a turn to roll their dice
        for (int i = 0; i < numberOfRounds; i++) {
            playerTurn(players.get(i), generateDice());
            System.out.println("""
                    ~~~~~~~~~~~~~~~~~~~~~~~~~
                    Ready for the next round?
                                        
                    Press enter my friend!
                    ~~~~~~~~~~~~~~~~~~~~~~~~~
                    """);
            CLI.proceed();
        }
        System.out.println("""
                You have reached the end my fellow warriors!
                                
                If I do not see your faces again then farewell brave warriors!
                                
                If you wish to play again then simply press enter.
                """);
    }

    public void printScore() {
        // Display the score of each player

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
