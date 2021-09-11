package com.company;

import java.util.ArrayList;

public class Player {

    public ArrayList<Die> playersDice;
    private final String name;
    private int score;

    public Player(String name, int playerScore) {
        this.name = name;
        this.score = playerScore;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
