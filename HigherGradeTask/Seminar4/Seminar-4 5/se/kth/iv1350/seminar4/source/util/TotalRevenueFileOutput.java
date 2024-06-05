package se.kth.iv1350.seminar4.source.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import se.kth.iv1350.seminar4.source.integration.RevenueNotChangedException;
import se.kth.iv1350.seminar4.source.integration.TotalRevenueObserverTemplate;

/**
 * Logs the total income to a file.
 */

public class TotalRevenueFileOutput extends TotalRevenueObserverTemplate {
    private static final String LOG_FILE_NAME = "totalRevenue.txt";
    private static TotalRevenueFileOutput instance = new TotalRevenueFileOutput();
    private PrintWriter logFile;
    private double totalIncome;

    /**
     * Creates an instance of the TotalRevenueFileOutput.
     */

    private TotalRevenueFileOutput() {
        try {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME), true);
        } catch (IOException ex) {
            System.out.println("Could not create logger.");
            ex.printStackTrace();
        }
    }

    public static synchronized TotalRevenueFileOutput getTotalRevenueFileOutput() {
        if (instance == null) {
            instance = new TotalRevenueFileOutput();
        }
        return instance;
    }

    /**
     * Updates the total income.
     * @param totalRevenue The total income.
     */
    
    @Override
    protected void doShowTotalIncome() throws RevenueNotChangedException {

        if(totalIncome != getTotalIncome()) {
            logFile.println("Total Revenue: " + String.format("%.2f", getTotalIncome()));
            totalIncome = getTotalIncome();
        }
        else {
            throw new RevenueNotChangedException(totalIncome);
        }
    }

    @Override
    protected void handleErrors(RevenueNotChangedException e) {
        logFile.println(e.getMessage());
    }
}