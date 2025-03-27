package com.tradetracker;

public class Trade {
    double entryPrice;  // Price you bought at
    double exitPrice;   // Price you sold at
    int volume;         // How many units (e.g., shares)
    String date;        // When the trade happened

    // This sets up a new trade
    public Trade(double entryPrice, double exitPrice, int volume, String date) {
        this.entryPrice = entryPrice;
        this.exitPrice = exitPrice;
        this.volume = volume;
        this.date = date;
    }

    // This calculates profit (or loss if negative)
    public double calculateProfit() {
        return (exitPrice - entryPrice) * volume;
    }
}
