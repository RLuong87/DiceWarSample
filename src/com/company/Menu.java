package com.company;

public class Menu {

    public static void displayGame() {

        System.out.println("Welcome to DICE WARS!!\n");
        System.out.println("The rules are quite simple.\nEach player will take turns rolling dice\nThe player with the most points wins!");
        String numberOfPlayers = CLI.getString("\nEnter the amount of players: ");
        String numberOfRounds = CLI.getString("Enter the amount of rounds: ");
        String  numberOfDice = CLI.getString("Enter the amount of dice: ");
        Game diceGame = new Game(Integer.parseInt(numberOfPlayers), Integer.parseInt(numberOfRounds), Integer.parseInt(numberOfDice));

    }
}
