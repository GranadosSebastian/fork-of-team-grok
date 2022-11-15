package org.learn.dptl.ui;

import java.util.Scanner;

public class GameController {

    /*
     * Don't Play the Lottery
     * Console based app
     * Age
     * Life Expectancy
     * $/drawing ($2 / ticket)

     * 3 drawings/week
     * Quick Pick
     * Stretch Goals
     * Power Play
     * Favorite Numbers instead of / in addition to Quick Pick
     * Configuration change for Mega Millions
     * Web Interface
     */

    public void run() {
        Scanner console = new Scanner(System.in);
        String name = readRequiredString("What is your name?");
        int age = readRequiredInt("What is your age?", 18, Integer.MAX_VALUE);
        int years = readRequiredInt("How many years do you intend to play the lottery?", 1, Integer.MAX_VALUE);
        int playsPerWeek = readRequiredInt("How many times will you play each week?", 1, 3);
        int tickets = readRequiredInt("How many tickets do you want each lottery (tickets are $2)?", 1, 75);

        int totalLotteries = calculateTotalPlays(age, years, playsPerWeek);


    }

    private int calculateTotalPlays(int age, int years, int playsPerWeek) {
        return -1;
    }

    private int readRequiredInt(String prompt, int min, int max) {
        return -1;
    }

    private String readRequiredString(String prompt) {
        return null;
    }
}
