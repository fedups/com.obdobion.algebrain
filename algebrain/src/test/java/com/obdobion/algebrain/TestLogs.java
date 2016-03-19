package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestLogs
{
    @Test
    public void logOfe () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("log(e)");
        Assert.assertEquals("result ", 1, result.doubleValue(), 0D);
    }

    @Test
    public void log () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("log(1)");
        Assert.assertEquals("result ", 0, result.doubleValue(), 0D);
    }

    @Test
    public void logESquared () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("log(e^2)");
        Assert.assertEquals("result ", 2, result.doubleValue(), 0D);
    }

    @Test
    public void logEpow () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("log(e^10)");
        Assert.assertEquals("result ", 10, result.doubleValue(), 0D);
    }

    @Test
    public void log10 () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("log10(100)");
        Assert.assertEquals("result ", 2, result.doubleValue(), 0D);
    }

    @Test
    public void log100 () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("log10(0)");
        Assert.assertEquals("result ", Double.NEGATIVE_INFINITY, result.doubleValue(), 0D);
    }

    @Test
    public void log101 () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("log10(1)");
        Assert.assertEquals("result ", 0, result.doubleValue(), 0D);
    }

    @Test
    public void log1010 () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("log10(10)");
        Assert.assertEquals("result ", 1, result.doubleValue(), 0D);
    }

    @Test
    public void log10round () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("round(log10(1050), 0)");
        Assert.assertEquals("result ", 3, result.doubleValue(), 3D);
    }

    @Test
    public void log10trunc () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("trunc(log10(950), 0)");
        Assert.assertEquals("result ", 2, result.doubleValue(), 3D);
    }

    @Test
    public void log10round3 () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("round(log10(950), 0)");
        Assert.assertEquals("result ", 3, result.doubleValue(), 3D);
    }

    @Test
    public void log10round2 () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("round(log10(1050), 2)");
        Assert.assertEquals("result ", 3.02, result.doubleValue(), 3D);
    }

}
