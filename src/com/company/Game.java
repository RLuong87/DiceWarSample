package com.company;

import java.util.ArrayList;

public class Game {

    private final ArrayList<Player> players = new ArrayList<>();
    public static Die dice = new Die(6);
    private int numberOfRounds;
    private int numberOfDice;

    public Game(int numberOfPlayers, int numberOfRounds, int numberOfDice) {

        // Set number of rounds
        this.numberOfRounds = numberOfRounds;

        // Set number of dice
        this.numberOfDice = numberOfDice;

        // Generate number of players
        generatePlayers(numberOfPlayers);
        showPlayers();
        startGame();
        rounds(numberOfRounds);
        setNumberOfDice(numberOfDice);
//        playerTurn();
    }


    private void generatePlayers(int numberOfPlayers) {
        // Generate the amount of players
        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = CLI.getString("\nEnter your name: ");
            Player newPlayer = new Player(playerName, 0);
            newPlayer.playersDice = generateDice();
            players.add(newPlayer);
        }
    }

    public void startGame() {
        // Ask the user a series of questions,

        for (Player player : players) {

            System.out.println("\n" + player.getName() + " rolled a " + dice.diceRoll());
        }
    }

    public void setNumberOfDice(int numberOfDice) {

        for (int i = 0; i < numberOfDice; i++) {
            System.out.println("You rolled a " + dice.diceRoll());
        }
    }

    public void rounds(int numberOfRounds) {
        // Create a method to give each player a turn to roll their dice
        while (true) {
            for (int i = 0; i < numberOfRounds; i++) {

                startGame();
                System.out.println("\nReady for the next round?\nPress enter to go again!");
                CLI.proceed();
            }
        }
    }

    public void playerTurn(Player player) {

    }

    public void printScore() {
        // Display the score of each player

    }

    public void showPlayers() {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(0);
            System.out.println(i + 1 + ") " + player.getName());
        }
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
