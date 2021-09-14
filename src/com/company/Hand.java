package com.company;

import java.util.ArrayList;

public class Hand {

    public ArrayList<Die> dice;

    public void setDice(ArrayList<Die> dice) {
        this.dice = dice;
    }

    public void rollDice() {

        for (Die die : dice) {
            die.diceRoll();
        }
    }
}
