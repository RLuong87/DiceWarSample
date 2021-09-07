package com.company;

import java.util.ArrayList;

public class Game {

    private final ArrayList<Player> players = new ArrayList<>();
    private int numberOfRounds;
    private final int numberOfDice;
    private Player player;

    public Game(int numberOfPlayers, int numberOfRounds, int numberOfDice) {

        // Set number of rounds
        this.numberOfRounds = numberOfRounds;

        // Set number of dice
        this.numberOfDice = numberOfDice;

        // Generate number of players
        generatePlayers(numberOfPlayers);

        playerTurn(numberOfRounds);

    }

    public void startGame() {
        // Ask the user a series of questions,


        // Generate the game

    }

    private void playerTurn(int numberOfRounds) {
        // Create a method to give each player a turn to roll their dice
        for (Player value : players) {
            System.out.println(value);
        }

        for (int i = 0; i < numberOfRounds; i++) {
            CLI.proceed();
            Die dice = new Die(numberOfDice);
            System.out.println("You rolled a " + dice.roll());
        }
    }

    public void printScore() {
        // Display the score of each player

    }

    private void generatePlayers(int numberOfPlayers) {
        // Generate the amount of players
        // adds their names to an arraylist
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = CLI.getString("\nEnter your name\nName: ");
            Player newPlayer = new Player(name);
            players.add(newPlayer);
            newPlayer.playersDice = generateDice();
        }
        System.out.println("Press enter to roll");
    }

    private ArrayList<Die> generateDice() {
        ArrayList<Die> dice = new ArrayList<>();
        for (int i = 0; i < numberOfDice; i++) {
            Die die = new Die(numberOfDice);
            dice.add(die);
        }
        return dice;
    }
}
