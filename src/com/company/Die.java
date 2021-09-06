package com.company;

import java.util.Random;

public class Die {

    private final Random random = new Random();
    private final int sides;
    private final int value;

    public Die(int sides) {
        this.sides = sides;
        this.value = getValue();
    }

    public void rollDice() {
        int num = random.nextInt(sides) + 1;
        System.out.println(num);
    }

    public int getValue() {
        return value;
    }
}
