package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players = new ArrayList<>();
    private final List<Player> theWinner = new ArrayList<>();
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
//            CLI.pressEnter();
//            playerTurn();
//            System.out.println();
//            Menu.instructions();
//        }
//        CLI.pressEnter();
//        Menu.endMessage();
//    }

    public void startGame() {

        System.out.println("\nOur warriors are set & ready for battle!");
        System.out.println("-".repeat(30));
        showPlayers();
        System.out.println("-".repeat(30));
        System.out.println("Please, press enter to start the war!");
        CLI.pressEnter();

        for (int i = 0; i < numberOfRounds; i++) {

            for (Player player : players) {
                System.out.println();
                System.out.println(player.getName() + ", you're up! Show them what true power looks like!\nPress enter to start your turn!");
                CLI.pressEnter();
                playerTurn(player);
            }
            Menu.instructions();
            CLI.pressEnter();
        }
        System.out.println("-".repeat(100));
        checkWinner();
        System.out.println("-".repeat(100) + "\n");
        Menu.endMessage();
        CLI.pressEnter();
    }

    public void checkWinner() {
        int highestScore = 0;
        // Loop through the players arraylist
        String winnersNames = "";
        for (Player p : players) {
            // Look at the scores of each player
            if (p.getScore() > highestScore) {
                winnersNames = p.getName();
                highestScore = p.getScore();
                theWinner.clear();
                theWinner.add(p);
            } else if (highestScore == p.getScore()) {
                winnersNames += ", " + p.getName();
                theWinner.add(p);
            }
        }
        System.out.println("The winner" + (theWinner.size() == 1 ? " is " : "s are ") + winnersNames + " with a score of " + highestScore);

        // Check the scores against the variable highestScore

        /*for (Player p : players) {
//            System.out.println(p.getScore());

            for (int j = 0; j < players.size(); j++) {

                if (p.getScore() > highestScore) {
                    highestScore = p.getScore();
                    System.out.println(p.getScore());
                } else if (p.getScore() < highestScore) {

                }
            }

            if (p.getScore() > highestScore) {
                System.out.println("-".repeat(100));
                System.out.println(p.getName() + " IS VICTORIOUS WITH A TOTAL OF " + highestScore + " POINTS! CONGRATULATIONS " + p.getName() + "!!!");
                System.out.println("-".repeat(100) + "\n");
//            } else {
//                System.out.println("-".repeat(100));
//                System.out.println("Looks like we a tie! Congratulations " + p.getName() + " & " + p.getName());
//                System.out.println("-".repeat(100) + "\n");
            }
        }
        Menu.endMessage();*/
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
