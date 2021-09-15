package com.company;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Player> players = new ArrayList<>();
    private final List<Player> theWinners = new ArrayList<>();
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
//            totalScore += diceScore;
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
        System.out.println("-".repeat(40));
        showPlayers();
        System.out.println("-".repeat(40));
        System.out.println("Please, press enter to start the war!");
        CLI.pressEnter();

        for (int i = 0; i < numberOfRounds; i++) {

            for (Player player : players) {
                System.out.println();
                System.out.println(player.getName() + ", you're up! Show them what true power looks like!\nPress enter to start your turn!");
                CLI.pressEnter();
                playerTurn(player);
            }
            System.out.println("-".repeat(30));
            // Fires off after each round has ended
            System.out.println("Round " + (i + 1) + " has ended\n\nPress enter for the next round!");
            System.out.println("-".repeat(30) + "\n");
//            Menu.instructions();
            CLI.pressEnter();
        }
        System.out.println("Well, it looks like the war is over, press enter to see the game results\n");
        CLI.pressEnter();
        System.out.println("-".repeat(100));
        // Showing all the players scores
        scoreBoard();
        System.out.println("-".repeat(100));
        // Check the winner/winners
        checkWinner();
        System.out.println("-".repeat(100) + "\n");
        System.out.println();
        Menu.endMessage();
        CLI.pressEnter();
    }

    public void scoreBoard() {
        System.out.println("S C O R E B O A R D");
        System.out.println("-".repeat(100));
        // Loop through the players list to grab their name and scores for the scoreboard
        for (int i = 0; i < players.size(); i++) {
            Player p = players.get(i);
            // Using print format
            System.out.printf("%d) %s: %d points\n", i + 1, p.getName(), p.getScore());
        }
    }

    public void checkWinner() {
        int highestScore = 0;
        // Loop through the players arraylist

        // String winnerNames = ""; <--- // Also acceptable w/out StringBuilder

        StringBuilder winnersNames = new StringBuilder(); // Using StringBuilder for winner names

        for (Player p : players) {
            // Look at the scores of each player

            // If players score is higher than the highestScore variable, make highestScore equal to p.score

            if (p.getScore() > highestScore) {

                // winnersNames = p.getName(); <--- // Different approach without the help of StringBuilder

                winnersNames = new StringBuilder(p.getName()); // Concatenate winners name w/ StringBuilder

                highestScore = p.getScore(); // Store the player's highest score in the highestScore variable

                theWinners.clear(); // clear any players that would be added before finding the final result

                theWinners.add(p); // add the winner to theWinners arraylist

            } else if (highestScore == p.getScore()) { // if scores are even with the highest score

//                winnersNames += ", " + p.getName(); // Different approach without the help of StringBuilder

                winnersNames.append(", ").append(p.getName()); // append all the players names who tied

                theWinners.add(p); // add the winners to the arraylist
            }
        }
        System.out.println("The winner" + (theWinners.size() == 1 ? " is " : "s are ") + winnersNames + " with a score of " + highestScore
                + ". Congratulations " + winnersNames + "!");
    }

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
        Menu.endMessage();
        }*/

    public void showPlayers() {
        // Loop through the players arraylist to grab each player name
        for (int i = 0; i < players.size(); i++) {

            // Gaining access by declaring the variable player
            Player player = players.get(i);

            // using the variable i, add 1 to it to give the index of each player object
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
