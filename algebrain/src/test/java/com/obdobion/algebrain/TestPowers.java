package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestPowers
{
    @Test
    public void power1 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("2^5");
        Assert.assertEquals("testPower1 result ", 32D, result.doubleValue(), 0D);
    }

    @Test
    public void power2 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("2^5*3");
        Assert.assertEquals("testPower2 result ", 96D, result.doubleValue(), 0D);
    }

    @Test
    public void power3 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("3*2^5");
        Assert.assertEquals("testPower3 result ", 96D, result.doubleValue(), 0D);
    }

    @Test
    public void power4 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("(3*2)^5");
        Assert.assertEquals("testPower4 result ", 7776D, result.doubleValue(), 0D);
    }

    @Test
    public void power5 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("2^(5*3)");
        Assert.assertEquals("testPower5 result ", 32768D, result.doubleValue(), 0D);
    }
}
