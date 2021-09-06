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

    public void roll() {
        int num = random.nextInt(sides) + 1;
    }

    public int getValue() {
        return value;
    }
}
