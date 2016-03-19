package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestVariableNames
{
    @Test
    public void dots () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("myvar.inc:=17.2");
        Assert.assertEquals(17.2D, result, 0);
        Assert.assertEquals(17.2D, Equ.getInstance().getSupport().resolveVariable("myvar.inc", null));
    }

    @Test
    public void leadingDot () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("0.5*(_inc:=17.2)");
        Assert.assertEquals(8.6D, result, 0);
        Assert.assertEquals(17.2D, Equ.getInstance().getSupport().resolveVariable("_inc", null));
    }

    @Test
    public void leadingUnderbar () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("_myvar.inc:=17.2");
        Assert.assertEquals(17.2D, result, 0);
        Assert.assertEquals(17.2D, Equ.getInstance().getSupport().resolveVariable("_myvar.inc", null));
    }

    @Test
    public void assignVariableFirst () throws Exception
    {
        Equ.getInstance().getSupport().assignVariable("x", 123D);
        final Double result = (Double) Equ.getInstance().evaluate("x * 2");
        Assert.assertEquals(246D, result, 0);
        Assert.assertEquals(123D, Equ.getInstance().getSupport().resolveVariable("x", null));
    }

    @Test
    public void assignVariableSecond () throws Exception
    {
        Equ.getInstance().getSupport().assignVariable("x", 123D);
        final Double result = (Double) Equ.getInstance().evaluate("2 * x");
        Assert.assertEquals(246D, result, 0);
        Assert.assertEquals(123D, Equ.getInstance().getSupport().resolveVariable("x", null));
    }
}
