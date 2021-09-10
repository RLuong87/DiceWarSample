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
//        setNumberOfDice(generateDice());
        rounds(numberOfRounds);
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

            setNumberOfDice(generateDice());
//            System.out.println("\n" + player.getName() + " rolled a " + dice.diceRoll());
        }
    }

    public void setNumberOfDice(ArrayList<Die> numberOfDice) {

        for (int i = 0; i < numberOfDice.size(); i++) {

            for (Player p : players) {

                System.out.printf("%s rolled a %d\n", p.getName(), dice.diceRoll());
            }
        }
    }

    public void rounds(int numberOfRounds) {
        // Create a method to give each player a turn to roll their dice
        for (int i = 0; i < numberOfRounds; i++) {
            setNumberOfDice(generateDice());
            System.out.println("""
                    Ready for the next round?
                                        
                    Press enter my friend!
                    """);
            CLI.proceed();
        }
        System.out.println("""
                You have reached the end my fellow Warriors!
                                
                If I do not see your faces again then farewell Brave Warriors!
                                
                If you wish to play again then simply press enter.
                """);
    }

    public void playerTurn(Player player) {



    }

    public void printScore() {
        // Display the score of each player

    }

    public void showPlayers() {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(0);
            System.out.println(i + 1 + ") " + player.getName() + "\n");
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
