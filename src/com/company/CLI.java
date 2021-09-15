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
                System.out.println("\nEnter a number between 1 & 10");
                scan.nextLine();
            }
        }
    }

    public static int getInt(String question, int min, int max) {

        while (true) {
            try {
                System.out.print(question);
                int userInt = scan.nextInt();
                if (userInt < min || userInt > max) {
                    System.out.println("\nThe minimum amount is " + min + " & the max is " + max + "\n");
                } else {
                    return userInt;
                }
            } catch (InputMismatchException exception) {
                System.out.println("\nEnter a number between " + min + " & " + max);
                scan.nextLine();
            }
        }
    }

    public static char getChar(String question) {

        while (true) {
            try {
                System.out.print(question);
                char userChar = scan.next().toUpperCase().charAt(0);
                scan.nextLine();

                if (userChar == ' ') {
                    System.out.println("\nInvalid selection");
                } else {
                    return userChar;
                }
            } catch (InputMismatchException exception) {
                System.out.println("\nInvalid selection");
                scan.nextLine();
            }
        }
    }

    public static void exit() {
        System.out.println("\n" + "_".repeat(100) + "\n");
        System.out.println("Hope you had a good time, until we play again!");
        System.exit(0);
        scan.close();
    }

    public static void pressEnter() {
        scan.nextLine();
    }
}
