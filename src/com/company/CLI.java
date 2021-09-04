package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {

    private static final Scanner scan = new Scanner(System.in);

    public static String getString(String question) {

        System.out.print(question);
        return scan.nextLine();
    }

    public static int getInt(String question) {

        while (true) {
            try {
                System.out.print(question);
                return scan.nextInt();

            } catch (InputMismatchException exception) {
                System.out.println("Enter a number between 2 & 10");
                scan.nextLine();
            }
        }
    }

    public static int getInt(String question, int min, int max) {

        while (true) {
            try {
                System.out.println(question);
                int userInt = scan.nextInt();
                if (userInt < min || userInt > max) {
                    System.out.println("The minimum amount of players are " + min + " & the max is " + max);
                } else {
                    return userInt;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter a number between " + min + " & " + max);
                scan.nextLine();
            }
        }
    }
}
