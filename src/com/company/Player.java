package com.company;

import java.util.ArrayList;

public class Player {

    public ArrayList<Die> playersDice;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
