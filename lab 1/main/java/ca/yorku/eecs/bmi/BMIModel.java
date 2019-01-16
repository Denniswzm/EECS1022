package ca.yorku.eecs.bmi;

import java.io.PrintStream;
import java.util.Scanner;

import java.io.PrintStream;
import java.util.Scanner;

public class BMIModel
{
    private double weight;
    private double height;

    public BMIModel(String w, String h)
    {
        this.weight = Double.parseDouble(w);
        this.height = Double.parseDouble(h);
    }

    public String getWeightInPound(){
        double index = weight * 2.2;
        String result = String.format("%.1f", index);
        return result;
    }

    public String toFeetInch()
    {
        double x = height * 3.28084;
        int F = (int) Math.floor(x);
        int I = (int)((x - F)*12);
        return String.format("%d'%d''", F, I);
    }

    public String getBMI()
    {
        double index = this.weight / (this.height * this.height);
        String result = String.format("%.1f", index); // 
        String output = "Your Weight is "+ getWeightInPound()+" lb," + "your Height is "+toFeetInch() +" and your BMI is " + result;
        return output;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        PrintStream output = System.out;

        BMIModel model = new BMIModel("100", "1.8");
        output.println(model.getBMI());

        model = new BMIModel("45", "1.35");
        output.println(model.getBMI());

        model = new BMIModel("80", "1.2");
        output.println(model.getBMI());

        model = new BMIModel("65", "1.6");
        output.println(model.getBMI());
    }
}
