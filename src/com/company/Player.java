package com.company;

import java.util.ArrayList;

public class Player {

    private final String name;
    private int score;
    private Hand hand;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public ArrayList<Die> rollHand() {
        hand.rollDice();
        return hand.dice;
    }

//    public int rollDice() {
//        int totalRoll = 0;
//
//        for (int i = 0; i < dice.size(); i++) {
//            Die tempDie = dice.get(i);
//            tempDie.rollDie();
//            totalRoll += tempDie.getValue;
//        }
//        return totalRoll;
//    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public void setScore(int value) {
        score = value;
    }

    public int getScore() {
        return score;
    }

}
