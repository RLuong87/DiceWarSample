package com.company;

public class Menu {

    public static void welcomeMessage() {

        System.out.println("\n" + "_".repeat(25) + "\n");
        System.out.println("Welcome to DICE WARS!!");
        System.out.println("\n" + "_".repeat(25) + "\n");
        System.out.println("""
                The rules are quite simple. Each player will take turns rolling dice.
                The player with the most points will be the victor!! Are you ready!!""");
    }

    public static void options() {
        // Option to start the game or exit the game
        welcomeMessage();

        while (true) {
            System.out.print("\nTo start the war, enter 'Y' or to exit enter 'N' ");
            char userChar = CLI.getChar("(" + "Y/N" + "): ");

            switch (userChar) {
                case 'Y' -> userOptions();
                case 'N' -> CLI.exit();
            }
        }
    }

    public static void userOptions() {

        System.out.println("\n" + "-".repeat(100) + "\n");
        System.out.println("\nLET'S GO TO WAR SHALL WE!!!\n");
        System.out.println("\n" + "-".repeat(100) + "\n");

        int numberOfPlayers = CLI.getInt("\nEnter the amount of players (2 players minimum & 10 players max): ", 2, 10);
        int numberOfRounds = CLI.getInt("\nEnter the amount of rounds (1 round minimum & 10 rounds max): ", 1, 10);
        int numberOfDice = CLI.getInt("\nEnter the amount of dice (1 die minimum & 10 dice max): ", 1, 10);

        System.out.println("\n" + "_".repeat(100) + "\n");
        System.out.println("\nTake a look we must! So, we have " + numberOfPlayers + " warriors, " + numberOfRounds + " rounds of war and "
                + numberOfDice + " dice to take to war!\n");
        System.out.println("\n" + "-".repeat(100) + "\n");
        System.out.print("\nIf this is correct, enter 'Y' to start the war or 'N' to start over! ");
        char userChar = CLI.getChar("(" + "Y/N" + "): ");

        switch (userChar) {
            case 'Y' -> new Game(numberOfPlayers, numberOfRounds, numberOfDice);
            case 'N' -> userOptions();
        }
        System.out.println("\n" + "-".repeat(100) + "\n");
        CLI.pressEnter();
    }

    public static void instructions() {
        System.out.println("""
                    ~~~~~~~~~~~~~~~~~~~~~~~~~
                    Ready for the next round?
                    Press enter my friend! :)
                    ~~~~~~~~~~~~~~~~~~~~~~~~~
                    """);
    }

    public static void endMessage() {
        System.out.println("""
                It looks as if you have reached the end my fellow warriors!
                                
                If I do not see your faces again then farewell brave warriors!
                                
                If you wish to play again or if you wish to exit then simply press enter for options.
                """);
    }
}
