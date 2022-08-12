package com.BSJavaTraining;

public class MortgageCalculator {
    private final static byte MONTHS_IN_YEAR = 12;
    private final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private int years;

    protected MortgageCalculator(int principal, float annualInterest, int years){
        this.principal=principal;
        this.annualInterest=annualInterest;
        this.years=years;
    }
    protected double[] getRemainingBalances(){
        var balances = new double[getTotalNumberOfPayments()];
        for (int month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }
    protected double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();

        double totalNumberOfPayments = getTotalNumberOfPayments();

        // calculate the monthly interest per month
        double paymentsPerMonth = Math.pow(1 + monthlyInterest, totalNumberOfPayments);
        // calculate the mortgage value
        double mortgage =  principal * (monthlyInterest * paymentsPerMonth) / (paymentsPerMonth - 1);

        return mortgage;
    }

    protected double calculateBalance(int numberOfPaymentsMade) {

        float monthlyInterest = getMonthlyInterest();

        double totalNumberOfPayments = getTotalNumberOfPayments();

        double balance = principal
                * ( Math.pow(1 + monthlyInterest, totalNumberOfPayments)
                - Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
                / (Math.pow(1+ monthlyInterest, totalNumberOfPayments) - 1);

        return balance;
    }
    private float getMonthlyInterest(){
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }
    private int getTotalNumberOfPayments(){
        return years * MONTHS_IN_YEAR;
    }
}
