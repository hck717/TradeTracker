package com.tradetracker;

public class Trade {
    private double entryPrice;
    private double exitPrice;
    private int volume;
    private String date;

    public Trade(double entryPrice, double exitPrice, int volume, String date) {
        this.entryPrice = entryPrice;
        this.exitPrice = exitPrice;
        this.volume = volume;
        this.date = date;
    }

    public double getEntryPrice() { return entryPrice; }
    public double getExitPrice() { return exitPrice; }
    public int getVolume() { return volume; }
    public String getDate() { return date; }

    public double calculateProfit() {
        return (exitPrice - entryPrice) * volume;
    }

    public boolean isProfitable() {
        return exitPrice > entryPrice;
    }
}