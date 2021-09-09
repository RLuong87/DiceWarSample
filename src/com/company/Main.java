package com.company;

public class Main {


/*
You are expected to get as far as you can with this challenge.
Please make a copy of where we ended off in class so we can continue from that point, and then continue working on this project solo.
Work hard and see how far you can get.

The program should have a main menu where the user can play the game or exit the program

When the game starts it will ask how many players are playing and how many dice will be thrown.
Min players of 2, Max players: 10
Min dice: 1,  Max dice: 10

Then ask how many rounds: min rounds 1, max rounds 10.

Each player will be asked to enter their name one at a time.

The game will then start and each player will roll their die/dice.
Each player will be receive a message;
 "Okay ___ it your turn
  Press Enter to roll your dice


  ___ you rolled: 4, 2, 1, 6"


Where the ___ is the players name.


After everyone has rolled the round ends. Each players round score (all the dice values added up) will be added to their overall game total.

The player/s with the greatest overall total at the end wins.
If there is a tie, all players should be considered winners and the end game display message should display all of their names


If one winner:
"The winner of the game is ___ with a score of ___. Congratulations ____!"


If more than one winner:
"The winners of the game are ___, ___, and ___ with a score of ___. Congratulations players!"


After the game has ended the program should return to the main menu where the user/s is given the choice to play again, or exit the program.
*/

    public static void main(String[] args) {
        Menu.options();

        // Simple Pyramid
//        for (int i = 0; i < 8; i++) {
//            for (int j = 8; j > i ; j--) {
//                System.out.print(" ");
//            }
//            for (int j = 0; j < 2*i+1; j++) {
//                System.out.print('*');
//            }
//            System.out.println();
//        }
    }
}
