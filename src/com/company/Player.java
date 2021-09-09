package com.company;

import java.util.ArrayList;

public class Player {

    public ArrayList<Die> playersDice;
    private final String name;
    private final int score;

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

    @Override
    public String toString() {
        return name;
    }
}
