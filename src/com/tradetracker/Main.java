package com.tradetracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter entry price:");
        double entry = scanner.nextDouble();

        System.out.println("Enter exit price:");
        double exit = scanner.nextDouble();

        System.out.println("Enter volume:");
        int volume = scanner.nextInt();

        System.out.println("Enter date (e.g., 2025-03-26):");
        String date = scanner.next();

        Trade trade = new Trade(entry, exit, volume, date);
        System.out.println("Profit: " + trade.calculateProfit());
    }
}