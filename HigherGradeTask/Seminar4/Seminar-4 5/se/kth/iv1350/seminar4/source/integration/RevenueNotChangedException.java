package se.kth.iv1350.seminar4.source.integration;

public class RevenueNotChangedException extends Exception{
    public RevenueNotChangedException(double totalRevenue) {
        super("No sale, the total Revenue remains the same: " + String.format("%.2f", totalRevenue) + ".");
    }
    
}
