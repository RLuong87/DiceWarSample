package com.company;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();
    private int numberOfRounds;
    private int numberOfDice;
    private Player player;
    private boolean turn = true;

    public Game(int numberOfPlayers, int numberOfRounds, int numberOfDice) {
        this.numberOfRounds = numberOfRounds;
        this.numberOfDice = numberOfDice;
        generatePlayers(numberOfPlayers);
        playerTurn(player);

    }

    public void startGame() {

    }

    private void playerTurn(Player player) {
        for (Player play: players) {
            System.out.println(play);
        }
    }

    public void printScore() {


    }

    private void generatePlayers(int numberOfPlayers) {
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = CLI.getString("Enter your name\nName: ");
            Player newPlayer = new Player(name);
            players.add(newPlayer);
        }
    }

    private ArrayList<Die> generateDice() {
        Die die1 = new Die(numberOfDice);
        ArrayList<Integer> dice = new ArrayList<>();
        dice.add(numberOfDice);
        return null;
    }

    public void options() {
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
