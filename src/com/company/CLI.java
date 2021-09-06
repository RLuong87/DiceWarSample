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
                System.out.println("Enter a number between 1 & 10");
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
                    System.out.println("The minimum amount is " + min + " & the max is " + max);
                } else {
                    return userInt;
                }
            } catch (InputMismatchException exception) {
                System.out.println("Enter a number between " + min + " & " + max);
                scan.nextLine();
            }
        }
    }

    public static char getChar(String question) {

        while (true) {
            System.out.print(question);
            scan.nextLine();
            char userChar = scan.next().toUpperCase().charAt(0);

            if (userChar != ' ') {
                return userChar;
            } else {
                System.out.println("Enter an operator!");
            }
        }
    }

    public static void exit() {
        System.out.println("\n*************************************\n");
        System.out.println("\tThank you, come again!");
        System.exit(0);
        scan.close();
    }
}
