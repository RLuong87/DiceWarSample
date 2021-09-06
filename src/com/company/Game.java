package com.company;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();
    private int numberOfRounds;
    private int numberOfDice;
    private Player player;
    private boolean turn = true;

    public Game(int numberOfPlayers, int numberOfRounds, int numberOfDice) {

        // Generate number of rounds
        this.numberOfRounds = numberOfRounds;

        // Generate number of players
        generatePlayers(numberOfPlayers);

        // Generate number of dice
        generateDice(numberOfDice);

    }

    public void startGame() {
        // Ask the user a series of questions,
        String numberOfPlayers = CLI.getString("\nEnter the amount of players: ");
        String numberOfRounds = CLI.getString("Enter the amount of rounds: ");
        String numberOfDice = CLI.getString("Enter the amount of dice: ");

        // Generate the dice wars game
        Game diceGame = new Game(Integer.parseInt(numberOfPlayers), Integer.parseInt(numberOfRounds), Integer.parseInt(numberOfDice));

    }

    private void playerTurn(Player player) {
        // Create a method to create a turn so each player can roll their dice

    }

    public void printScore() {


    }

    private void generatePlayers(int numberOfPlayers) {
        // Generates the amount of players
        // add their names to an arraylist
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = CLI.getString("Enter your name\nName: ");
            Player newPlayer = new Player(name);
            players.add(newPlayer); // Not sure if this work??
        }
    }

    private ArrayList<Die> generateDice(int numberOfDice) {
        ArrayList<Die> dice = new ArrayList<>();

        for (int i = 0; i < numberOfDice; i++) {
            Die die = new Die(numberOfDice);
            String rollDice = CLI.getString("Your turn to roll!");
            die.roll();
        }
        return null;
    }

    public void options() {
        // Option to start the game or exit the game
        while (true) {
            System.out.println("\nTo start the game, enter Y or to exit enter N");
            char userChar = CLI.getChar("(" + "Y/N" + "): ");
            switch (userChar) {
                case 'Y' -> startGame();
                case 'N' -> CLI.exit();
            }
        }
    }
}
