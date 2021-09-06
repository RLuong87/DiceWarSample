package com.company;

public class Menu {

    public static void displayGame() {

        System.out.println("Welcome to DICE WARS!!\nThe rules are quite simple");
        System.out.println("Each player will take turns rolling dice\nThe player with the most points wins!");
        String numberOfRounds = CLI.getString("\nEnter the amount of rounds: ");
        int numberOfDice = CLI.getInt("Enter the amount of dice: ", 1, 10);
        int numberOfPlayers = CLI.getInt("Enter the amount of players: ", 2, 10);
        Game diceGame = new Game(Integer.parseInt(numberOfRounds), numberOfDice, numberOfPlayers);

    }
}
