package com.tradetracker;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TradeTracker tracker = new TradeTracker();

        while (true) {
            try {
                System.out.println("Enter entry price (or -1 to finish):");
                double entry = scanner.nextDouble();
                if (entry == -1) break;

                System.out.println("Enter exit price:");
                double exit = scanner.nextDouble();
                System.out.println("Enter volume:");
                int volume = scanner.nextInt();
                scanner.nextLine(); // Clear the newline after nextInt()
                System.out.println("Enter date (e.g., 2025-03-26):");
                String date = scanner.nextLine();

                Trade trade = new Trade(entry, exit, volume, date);
                tracker.addTrade(trade);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear invalid input
            }
        }

        try {
            tracker.saveToFile("trades.txt");
            System.out.println("Trades saved to trades.txt");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }

        System.out.println("Total Profit: " + tracker.totalProfit());
        System.out.println("Win Rate: " + tracker.winRate() + "%");

        scanner.close(); // Good practice to close the scanner
    }
}