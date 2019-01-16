package com.example.dennis97;

import com.example.dennis97.mcalc.MortgageModel;
import junit.framework.Assert;

import org.junit.Test;


public class TestModel
{
    @Test
    public void testPayment()
    {
        MortgageModel myModel;

        myModel = new MortgageModel("700000", "25", "2.75");
        Assert.assertEquals("C1", "3,229.18", myModel.compute());

       // myModel = new MortgageModel("300000", "20", "4.5");
       // Assert.assertEquals("C2", "3,000.00", myModel.compute());
    }
}
