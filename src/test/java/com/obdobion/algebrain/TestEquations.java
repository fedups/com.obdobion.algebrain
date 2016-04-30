package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestEquations
{
    @Test
    public void m10a () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("if (1=1,1,2)");
        Assert.assertEquals("M10a result ", 1D, result.doubleValue(), 0D);
    }

    @Test
    public void m10b () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("if (1=3,1,2)");
        Assert.assertEquals("M10b result ", 2D, result.doubleValue(), 0D);
    }

    @Test
    public void m10c () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("5 * if (1=3,1,2)");
        Assert.assertEquals("M10c result ", 10D, result.doubleValue(), 0D);
    }

    @Test
    public void m10d () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("if (1=3,1,if (10 - 9 = 11 - 10,4,5))");
        Assert.assertEquals("M10d result ", 4D, result.doubleValue(), 0D);
    }

    @Test
    public void m1a () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("2x");
        Assert.assertEquals("M1a result ", 10D, result.doubleValue(), 0D);
    }

    @Test
    public void m1b () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("2tan(x)");
        Assert.assertEquals("M1b result ", 0.17497732705184801, result.doubleValue(), 0D);
    }

    @Test
    public void m2 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("2(3+x)");
        Assert.assertEquals("M2 result ", 16D, result.doubleValue(), 0D);
    }

    @Test
    public void m3a () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("(2-x)x");
        Assert.assertEquals("M3a result ", -15D, result.doubleValue(), 0D);
    }

    @Test
    public void m3b () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("(2-x)sin(x)");
        // System.err.println(equ.showRPN());
        Assert.assertEquals("M3b result ", -0.2614672282429745, result.doubleValue(), 0D);
    }

    @Test
    public void m4a () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("(2-x)(x+1)");
        Assert.assertEquals("M4a result ", -18D, result.doubleValue(), 0D);
    }

    @Test
    public void m4b () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("sin(x)(2-x)");
        Assert.assertEquals("M4b result ", -0.2614672282429745, result.doubleValue(), 0D);
    }

    @Test
    public void m5a () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("x(x+1)");
        Assert.assertEquals("M5a result ", 30D, result.doubleValue(), 0D);
    }

    @Test
    public void m5b () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("x(1-sin(x))");
        Assert.assertEquals("M5b result ", 4.564221286261709, result.doubleValue(), 0D);
    }

    @Test
    public void m6a () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("3 / (4 * x)11 / 2");
        Assert.assertEquals("M6a result ", 0.825, result.doubleValue(), 0D);
    }

    @Test
    public void m6b () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("3 / 4 * x * 11 / 2");
        Assert.assertEquals("M5b result ", 20.625, result.doubleValue(), 0D);
    }

    @Test
    public void m6c () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("4 - 7 + 11 / 3 * x");
        Assert.assertEquals("M6c result ", 15.333333333333332, result.doubleValue(), 0D);
    }

    @Test
    public void m7a () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("max(1,2,3)");
        Assert.assertEquals("M7a result ", 3, result.doubleValue(), 0D);
    }

    @Test
    public void m7b () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("max(x,8,2,1)");
        Assert.assertEquals("M7b result ", 8, result.doubleValue(), 0D);
    }

    @Test
    public void m7c () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("max(x,max(x+2,6),1)");
        Assert.assertEquals("M7c result ", 7, result.doubleValue(), 0D);
    }

    @Test
    public void twoMaxFunctions () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("max(1,0) + max(2,0)");
        Assert.assertEquals("twoMaxFunctions", 3, result.doubleValue(), 0D);
    }

    @Test
    public void maxAndMinFunctions () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("max(1,0) + min(2,0)");
        Assert.assertEquals("maxAndMinFunctions", 1, result.doubleValue(), 0D);
    }

    @Test
    public void m8a () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000));
        equ.getSupport().assignVariable("Age", new Double(55));
        equ.getSupport().assignVariable("Prem", new Double(200000));
        final Double result = (Double) equ.evaluate("FacAmt*(100-Age)/Prem*12358+FacAmt ");
        Assert.assertEquals("M8a result ", 5670825.00, result.doubleValue(), 0D);
    }

    @Test
    public void m8b () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000));
        equ.getSupport().assignVariable("Age", new Double(55));
        equ.getSupport().assignVariable("Prem", new Double(200000));
        final Double result = (Double) equ.evaluate("FacAmt*(100-Age)/Prem*(12358+FacAmt) ");
        Assert.assertEquals("M8b result ", 510420825.00, result.doubleValue(), 0D);
    }

    @Test
    public void m8c () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000));
        equ.getSupport().assignVariable("Age", new Double(55));
        equ.getSupport().assignVariable("Prem", new Double(200000));
        final Double result = (Double) equ.evaluate("round((FacAmt*100-Age)/Prem*12358+FacAmt,2)");
        Assert.assertEquals("M8c result ", 10768496.60, result.doubleValue(), 0D);
    }

    @Test
    public void m9a () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000.99));
        final String result = (String) equ.evaluate("alpha(round(FacAmt,0))");
        Assert.assertEquals("M9a result ", "1500001", result);
    }

    @Test
    public void m9a2 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000.99));
        final String result = (String) equ.evaluate("alpha(FacAmt)");
        Assert.assertEquals("M9a2 result ", "1500000", result);
    }

    @Test
    public void m9b () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("rate('tablename', 'a', 'b')");
        Assert.assertEquals("M9b result ", 1D, result.doubleValue(), 0D);
    }

    @Test
    public void m9c () throws Exception
    {
        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000));
        final Double result = (Double) equ.evaluate("rate('tablename', 'a', alpha(FacAmt))");
        Assert.assertEquals("M9c result ", 1D, result.doubleValue(), 0D);
    }

    @Test
    public void min () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("min(1,2,3)");
        Assert.assertEquals("result ", 1, result.doubleValue(), 0D);
    }

    @Test
    public void booleanEqual () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 = 2");
        Assert.assertFalse("result ", result.booleanValue());
    }

    @Test
    public void booleanNotEqual () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 != 2");
        Assert.assertTrue("result ", result.booleanValue());
    }

    @Test
    public void booleanGreater () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 > 2");
        Assert.assertFalse("result ", result.booleanValue());
    }

    @Test
    public void booleanNotGreater () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 <= 2");
        Assert.assertTrue("result ", result.booleanValue());
    }

    @Test
    public void booleanLess () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 < 2");
        Assert.assertTrue("result ", result.booleanValue());
    }

    @Test
    public void booleanNotLess () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 >= 2");
        Assert.assertFalse("result ", result.booleanValue());
    }
}
