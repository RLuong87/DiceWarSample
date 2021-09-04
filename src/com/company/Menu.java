package com.company;

public class Menu {

    private static String options;

    public static void displayGame() {

        System.out.println("Welcome to DICE WARS!!\nThe rules are quite simple");
        System.out.println("Each player will take turns rolling dice, the player with the most points wins!");
        options = CLI.getString("\nEnter the amount of players: ");




    }

    public static void setNumberOfPlayers() {
        Game diceGame = new Game(0, 0, 0);

    }
}
