package se.kth.iv1350.seminar4.source.view;

import se.kth.iv1350.seminar4.source.integration.RevenueNotChangedException;
import se.kth.iv1350.seminar4.source.integration.TotalRevenueObserverTemplate;

/**
 * A simple view that displays the total income.
 */

public class TotalRevenueView extends TotalRevenueObserverTemplate {
    private double totalIncome;

    @Override
    protected void doShowTotalIncome() throws RevenueNotChangedException {

        if(totalIncome != getTotalIncome()){
            System.out.println("Total Revenue: " + String.format("%.2f", getTotalIncome()));
            totalIncome = getTotalIncome();
        }

        else {
            throw new RevenueNotChangedException(totalIncome);
        }
    }

    @Override
    protected void handleErrors(RevenueNotChangedException e) {
        System.out.println(e.getMessage());
        
    }
}
