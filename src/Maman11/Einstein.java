package Maman11;

import java.util.Scanner;

// this class is an interactive einstein game
public class Einstein {
    public static void main(String[] args) {
        // init
        Scanner reader = new Scanner(System.in);
        final int FINAL_RESULT = 1089;
        final int FIRST_DIGIT = 100;
        final int SECOND_DIGIT = 10;
        final int MAX_INPUT = 999;
        final int LOWEST_INPUT = 100;
        // explaining the game
        System.out.println("Welcome to the Einstein magic game");

        //reading user input
        System.out.println("enter a 3 digit positive number whose first and las digit are different and is not 0 : ");
        int userNumber = reader.nextInt();

        // validate user input
        if (userNumber > MAX_INPUT || userNumber < LOWEST_INPUT) {
            System.out.println("The number you entered is not a 3 digit positive number");
        }
        // check if first and last digit are equal
        else if (userNumber % 10 == userNumber / FIRST_DIGIT) {
            System.out.println("The first and the last digits of the number should be different");
        } else {
            System.out.println("User number is: " + userNumber);

            // flip user input and find difference
            int flippedUserInput = (userNumber % 10 * FIRST_DIGIT) + (userNumber / 10 % 10 * SECOND_DIGIT) + (userNumber / 100);
            int difference = Math.abs(userNumber - flippedUserInput);
            System.out.println("Difference: " + difference);

            // flip difference
            int flippedDifference = (difference % 10 * FIRST_DIGIT) + (difference / 10 % 10 * SECOND_DIGIT) + (difference / 100);
            System.out.println("Reversed difference: " + flippedDifference);

            // check if the riddle succeeded
            if (flippedDifference + difference == FINAL_RESULT) {
                System.out.println("SUCCEEDED");
            } else {
                System.out.println("FAILED");
            }
        }

    }
}
