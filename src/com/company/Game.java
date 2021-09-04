package com.company;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();
    private int numberOfRounds;
    private ArrayList<Die> numberOfDice;
    private Player player;
    private Object Die;

    public Game(int numberOfPlayers, int numberOfRounds, int numberOfDice) {
        this.numberOfRounds = numberOfRounds;
        this.numberOfDice = generateDice();
        generatePlayers(numberOfPlayers);
    }

    public void startGame() {


    }

    private void playerTurn(Player player) {


    }

    public void printScore() {


    }

    private void generatePlayers(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = CLI.getString("Enter your name\nName: ");
            Player newPlayer = new Player(name);
        }
    }

    private ArrayList<Die> generateDice() {
        int number_of_dice = CLI.getInt("Enter number of dice", 2, 10);

        return null;
    }

}
