package com.example.dennis97.mcalc;

import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.Scanner;


public class MortgageModel
{

        private double principle;
        private double amortization;
        private double interest;

        private static double index;

        public MortgageModel(String a, String p, String i)
        {
            this.principle = Double.parseDouble(a);
            this.amortization = Double.parseDouble(i);
            this.interest = Double.parseDouble(p);
        }

    public String compute()
    {
        double interest = this.interest/(100*12);

        double amortization = this.amortization*12;

        index = (this.principle*interest)/(1-Math.pow(1+interest,-amortization));

        String result = String.format("%,.2f", index);

        return result;

    }



    public String outstandingAfter() {
        double interest = this.interest/(100*12);

        double amortization = this.amortization*12;

        double outstanding = this.principle -((index / interest) -principle)*(Math.pow((1+ interest),60)-1);

        String result = String.format("%, .0f", outstanding);
        return result;
    }



    public static void main(String[] args)
    {
        MortgageModel model = new MortgageModel("700000", "25","2.75");
        System.out.println(model.compute());

        model = new MortgageModel("300000","20","4.5");
        System.out.println(model.compute());
    }


}
