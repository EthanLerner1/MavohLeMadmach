package Maman11;

import java.util.Scanner;

// this class reformats ms to days:hours:minutes:seconds
public class Milliseconds {
    public static void main(String[] args) {
        // constants representing ratio between time units
        final int MS_IN_SEC = 1000;
        final int SEC_IN_MIN = 60;
        final int MIN_IN_HOUR = 60;
        final int HOUR_IN_DAY = 24;

        // reading input from user
        Scanner reader = new Scanner(System.in);
        System.out.println ("This program reads an integer which " +
                "represents Milliseconds and converts it to days, " +
                "hours, minutes and seconds.");
        System.out.println ("Please enter the number of Milliseconds");
        long ms = reader.nextLong();

        // time ratio calculations
        long seconds = ms / MS_IN_SEC; // ms to sec
        long minutes = seconds / SEC_IN_MIN; // sec to min
        seconds %= SEC_IN_MIN; // sec = what left from minutes
        long hours = minutes / MIN_IN_HOUR; // min to hour
        minutes %= MIN_IN_HOUR;
        long days = hours / HOUR_IN_DAY;
        hours %= HOUR_IN_DAY;

        // print to user
        System.out.println(days + " days " + hours + ":" + minutes + ":" + seconds + " hours");

    }

}
