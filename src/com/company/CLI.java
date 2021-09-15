package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {

    private static final Scanner scan = new Scanner(System.in);

    public static String getString(String question) {

        while (true) {
            System.out.print(question);
            String userInput = scan.nextLine();
            // If empty input is not entered, return userInput
            if (!userInput.equals("")) {
                return userInput;
            } else {
                // Output this message if empty input is entered
                System.out.println("\nERROR: NO NAME WAS RECORDED. PLEASE ENTER A NAME");
            }
        }
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
                    System.out.println("\nThe minimum amount is " + min + " & the max is " + max);
                } else {
                    return userInt;
                }
            } catch (InputMismatchException exception) {
                System.out.println("\nEnter a number between " + min + " & " + max);
                scan.nextLine();
            }
        }
    }

    public static String getStr(String question) {

        while (true) {
            try {
                System.out.print(question);
                String userStr = scan.next().toUpperCase();
                scan.nextLine();

                if (userStr.length() != 1) {
                    System.out.println("\nInvalid selection: Enter 'Y' or 'N'");
                } else {
                    return userStr;
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
