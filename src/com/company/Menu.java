package com.company;

public class Menu {

    public static void displayGame() {

        System.out.println("Welcome to DICE WARS!!\n");
        System.out.println("The rules are quite simple. Each player will take turns rolling dice\nThe player with the most points wins!");
    }

    public static void options() {
        // Option to start the game or exit the game
        displayGame();

        while (true) {
            System.out.print("\nTo start the game, enter Y or to exit enter N ");
            char userChar = CLI.getChar("(" + "Y/N" + "): ");
            switch (userChar) {
                case 'Y' -> userChoices();
                case 'N' -> CLI.exit();
            }
        }
    }

    public static void userChoices() {
        int numberOfPlayers = CLI.getInt("\nEnter the amount of players (2 players minimum & 10 players max): ", 2,10);
        int numberOfRounds = CLI.getInt("\nEnter the amount of rounds (1 round minimum & 10 rounds max): ", 1, 10);
        int numberOfDice = CLI.getInt("\nEnter the amount of dice (1 die minimum & 10 dice max): ", 1, 10);
        Game diceGame = new Game(numberOfPlayers, numberOfRounds, numberOfDice);
//        diceGame.startGame();
//        diceGame.printScore();
    }
}
