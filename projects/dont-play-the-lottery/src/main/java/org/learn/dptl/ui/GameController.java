package org.learn.dptl.ui;

import org.learn.dptl.model.Match;
import org.learn.dptl.model.Ticket;

import java.util.Scanner;

public class GameController {

    private static Scanner console = new Scanner(System.in);

    public void run() {
        int age = readRequiredInt("What is your age?", 18, Integer.MAX_VALUE);
        int years = readRequiredInt("What is your life expectancy?", 1, Integer.MAX_VALUE);
        int lotteriesPerWeek = readRequiredInt("There are 3 lotteries each week, how many of them do you plan to play?", 1, 3);
        int ticketsPerLottery = readRequiredInt("How many tickets do you want to play each lottery (tickets are $2)?", 1, 75);

        int totalSpent = 0;
        int totalWon = 0;

        int totalLotteries = calculateTotalLotteries(age, years, lotteriesPerWeek);
        for (int lottery = 0; lottery < totalLotteries; lottery++) {
            totalSpent += 2;
            totalWon += calculateWinningsForOneLottery(ticketsPerLottery);
        }

        System.out.printf("\nYou spent $%d and won $%d for a total of $%d%n",
                totalSpent, totalWon, totalWon - totalSpent);
    }

    private int calculateWinningsForOneLottery(int ticketsPerLottery) {
        int winnings = 0;
        Ticket winningTicket = new Ticket();
        for (int ticket = 0; ticket < ticketsPerLottery; ticket++) {
            Ticket myTicket = new Ticket();
            Match match = Match.calculatePrizeMoney(winningTicket, myTicket);
            winnings += match.getPrizeMoney();
        }
        return winnings;
    }

    private int calculateTotalLotteries(int age, int lifeExpectancy, int playsPerWeek) {
        int years = lifeExpectancy - age;
        return years * 52 * playsPerWeek;
    }

    private int readRequiredInt(String prompt, int min, int max) {
        Integer num = null;
        do {
            String input = readRequiredString(prompt);
            try {
                num = Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
            }

        } while (num == null || num < min || num > max);

        return num;
    }

    private String readRequiredString(String prompt) {

        String input;
        do {
            System.out.print(prompt);
            input = console.nextLine();
        } while (input == null || input.isBlank());

        return input;

    }
}
