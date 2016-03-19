package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestModulus
{
    @Test
    public void mod1 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("13%10");
        Assert.assertEquals("testMod1 result ", 3, result.doubleValue(), 0D);
    }

    @Test
    public void mod2 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("round(13.76%3, 2)");
        Assert.assertEquals("testMod2 result ", 1.76, result.doubleValue(), 0D);
    }

    @Test
    public void mod3 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance().evaluate("85 % 2 = 1");
        Assert.assertEquals("testMod3 result ", true, result.booleanValue());
    }
}
