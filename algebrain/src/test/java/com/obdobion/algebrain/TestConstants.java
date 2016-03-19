package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestConstants
{
    @Test
    public void pi () throws Exception
    {
        double result = (double) Equ.getInstance(true).evaluate("PI");
        Assert.assertEquals("PI", Math.PI, result, 0D);
    }

    @Test
    public void e () throws Exception
    {
        double result = (double) Equ.getInstance(true).evaluate("E");
        Assert.assertEquals("E", Math.E, result, 0D);
    }

    @Test
    public void unknownConstant () throws Exception
    {
        TokVariable result = (TokVariable) Equ.getInstance(true).evaluate("W");
        Assert.assertEquals("W", "W", result.getValue().toString());
    }
}
