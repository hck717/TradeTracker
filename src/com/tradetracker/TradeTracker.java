package com.tradetracker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TradeTracker {
    private ArrayList<Trade> trades;

    // Constructor
    public TradeTracker() {
        trades = new ArrayList<>();
    }

    // Add a trade
    public void addTrade(Trade trade) {
        if (trade.getVolume() <= 0) {
            throw new IllegalArgumentException("Volume must be positive");
        }
        if (trade.getEntryPrice() < 0 || trade.getExitPrice() < 0) {
            throw new IllegalArgumentException("Prices cannot be negative");
        }
        trades.add(trade);
    }

    // Calculate total profit
    public double totalProfit() {
        double total = 0;
        for (Trade trade : trades) {
            total += trade.calculateProfit();
        }
        return total;
    }

    // Calculate win rate (percentage of profitable trades)
    public double winRate() {
        if (trades.isEmpty()) return 0.0;
        int profitable = 0;
        for (Trade trade : trades) {
            if (trade.isProfitable()) profitable++;
        }
        return (profitable * 100.0) / trades.size();
    }

    // Get all trades (for later use)
    public ArrayList<Trade> getTrades() {
        return trades;
    }

    // Save trades to a file
    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Trade trade : trades) {
            writer.write(trade.getEntryPrice() + "," + trade.getExitPrice() + "," +
                         trade.getVolume() + "," + trade.getDate());
            writer.newLine();
        }
        writer.close();
    }
}
