package com.company;

import java.util.Random;

public class Die {

    private final Random random = new Random();
    private final int sides;
    private int value;

    public Die(int sides) {
        this.sides = sides;
    }

    public void diceRoll() {
       value = random.nextInt(sides) + 1;
    }

    public int getValue() {
        return value;
    }
}
