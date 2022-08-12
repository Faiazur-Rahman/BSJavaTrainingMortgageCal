package com.BSJavaTraining;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    protected MortgageReport(MortgageCalculator calculator){
        this.calculator=calculator;
        currency = NumberFormat.getCurrencyInstance();
    }
    protected void printMortgage() {
        // calculate the mortgage value
        double mortgage = calculator.calculateMortgage();

        System.out.println("\nMORTGAGE \n----------");
        System.out.println("Monthly Payments: " + currency.format(mortgage));
    }

    protected void printPaymentSchedule() {
        System.out.println("\nPAYMENT SCHEDULE \n------------");
        for (var balance : calculator.getRemainingBalances())
            System.out.println(currency.format(balance));
    }
}
