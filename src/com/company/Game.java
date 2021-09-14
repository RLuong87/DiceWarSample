package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Player> players = new ArrayList<>();
    private final int numberOfDice;
    private final int numberOfRounds;

    public Game(int numberOfPlayers, int numberOfRounds, int numberOfDice) {
        // Set number of rounds
        this.numberOfRounds = numberOfRounds;

        // Set number of dice
        this.numberOfDice = numberOfDice;

        // Generate number of players
        generatePlayers(numberOfPlayers);

        // Start the war!!!
        startGame();
    }

//    public void startGame() {
//        System.out.println("\nOkay! Our warriors are set for war!");
//        System.out.println("~".repeat(35));
//        showPlayers();
//        System.out.println("~".repeat(35));
//        System.out.println("Please, press enter to start the Dice War!");
//        rounds(numberOfRounds);
//    }

    private void generatePlayers(int numberOfPlayers) {
        // Generate the amount of players
        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = CLI.getString("\nEnter your name: ");
            Player newPlayer = new Player(playerName, 0);
            players.add(newPlayer);
            Hand hand = new Hand();
            ArrayList<Die> newDice = generateDice();
            hand.setDice(newDice);
            newPlayer.setHand(hand);
        }
    }

//    public void playerTurn() {
//
//        for (Player p : players) {
//            System.out.println(p.getName() + " it is your turn to roll!\nPress enter my friend!");
//            CLI.proceed();
//            System.out.print(p.getName() + " rolled ");
//            playerRoll();
//        }
//    }

//    public void playerRoll() {
//
//        List<Integer> gameScores = new ArrayList<>();
//        int totalScore = 0, diceScore;
//
//        for (int i = 0; i < numberOfDice; i++) {
//            diceScore = die.roll();
//            gameScores.add(diceScore);
//            System.out.print(gameScores.get(i) + " ");
//            totalScore += gameScores.get(i);
//        }
//        System.out.println();
//        System.out.println("-".repeat(16));
////        player.playersDice = new ArrayList<>();
//        totalPlayerScore.add(totalScore);
//        System.out.println("Total points: " + totalScore);
//        System.out.println("-".repeat(16) + "\n");
//    }

    private void playerTurn(Player player) {
        int sum = 0;
        ArrayList<Die> playerCurrentRoll = player.rollHand();

        for (Die die : playerCurrentRoll) {
            die.diceRoll();
            sum += die.getValue();
            System.out.println(player.getName() + " rolled " + die.getValue());
        }
        int newScore = sum + player.getScore();

        player.setScore(newScore);
        System.out.println("-".repeat(30));
        System.out.println(player.getName() + "'s total score is: " + newScore);
        System.out.println("-".repeat(30) + "\n");
    }

//    public void rounds(int numberOfRounds) {
//
//        for (int i = 0; i < numberOfRounds; i++) {
//            CLI.proceed();
//            playerTurn();
//            System.out.println();
//            Menu.instructions();
//        }
//        CLI.proceed();
//        Menu.endMessage();
//    }

    public void startGame() {

        System.out.println("\nOur warriors are set & ready for battle!");
        System.out.println("-".repeat(30));
        showPlayers();
        System.out.println("-".repeat(30));
        System.out.println("Please, press enter to start the war!");
        CLI.proceed();
        for (int i = 0; i < numberOfRounds; i++) {
            for (Player player : players) {
                System.out.println();
                System.out.println(player.getName() + ", you're up! Show them what true power looks like!");
                CLI.proceed();
                playerTurn(player);
            }
            Menu.instructions();
            CLI.proceed();
        }
        List<Integer> winnerScore = new ArrayList<>();

        for (Player p : players) {
            winnerScore.add(p.getScore());

            if (p.getScore() == Collections.max(winnerScore)) {
                int total = p.getScore();
                System.out.println("-".repeat(100));
                System.out.println(p.getName() + " IS VICTORIOUS WITH A TOTAL OF " + total + " POINTS! CONGRATULATIONS " + p.getName() + "!!!");
                System.out.println("-".repeat(100) + "\n");
//            } else {
//                System.out.println("-".repeat(100));
//                System.out.println("Looks like we a tie! Congratulations " + p.getName() + " & " + p.getName());
//                System.out.println("-".repeat(100) + "\n");
            }
        }
        Menu.endMessage();
    }

    public void showPlayers() {

        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            System.out.printf("Player %d) %s\n", i + 1, player.getName());
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
