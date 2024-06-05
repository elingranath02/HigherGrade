package se.kth.iv1350.seminar4.source.integration;

public abstract class TotalRevenueObserverTemplate implements TotalRevenueObserver {
    private double totalIncome;

    @Override
    public void updateTotalRevenue(double totalRevenue){

            setTotalIncome(totalRevenue);
            showTotalIncome();

    }

    private void setTotalIncome(double totalRevenue) {
        totalIncome = totalRevenue;
    }

    private void showTotalIncome() {
        try {
            doShowTotalIncome();
        } catch (RevenueNotChangedException e) {
            handleErrors(e);
        }
    }

    protected abstract void doShowTotalIncome() throws RevenueNotChangedException;

    protected abstract void handleErrors(RevenueNotChangedException e);

    protected double getTotalIncome() {
        return totalIncome;
    }
}
