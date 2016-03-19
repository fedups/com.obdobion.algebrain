package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestChaining
{
    @Test
    public void testPresetVariables () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a:=2; b:=a+1; c:=a*b");
        Assert.assertEquals("result", 6D, result, 0);
        Assert.assertEquals("variable a", 2D, (double) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
        Assert.assertEquals("variable b", 3D, (double) Equ.getInstance().getSupport().resolveVariable("b", null), 0);
        Assert.assertEquals("variable c", 6D, (double) Equ.getInstance().getSupport().resolveVariable("c", null), 0);
    }

    @Test
    public void testTrailingChainMarker () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a:=2;b:=a+1;c:=a*b;");
        Assert.assertEquals("result", 6D, result, 0);
        Assert.assertEquals("variable a", 2D, (double) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
        Assert.assertEquals("variable b", 3D, (double) Equ.getInstance().getSupport().resolveVariable("b", null), 0);
        Assert.assertEquals("variable c", 6D, (double) Equ.getInstance().getSupport().resolveVariable("c", null), 0);
    }

    @Test
    public void testTrailingChainMarker2 () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a:=2; b:=a+1; a*b;");
        Assert.assertEquals("result", 6D, result, 0);
        Assert.assertEquals("variable a", 2D, (double) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
        Assert.assertEquals("variable b", 3D, (double) Equ.getInstance().getSupport().resolveVariable("b", null), 0);
        Assert.assertNull("variable c", Equ.getInstance().getSupport().resolveVariable("c", null));
    }

    @Test
    public void testUnexpectedChaining () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a:=2;*3");
        Assert.assertEquals("result", 6D, result, 0);
        Assert.assertEquals("variable a", 2D, (double) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
    }

    @Test
    public void testChainingToOverridePrecedence () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a:=2;+3;/4");
        Assert.assertEquals("result", 1.25D, result, 0);
        Assert.assertEquals("variable a", 2D, (double) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
    }

    @Test
    public void testProofOfPrecedence () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("(a:=2)+3/4");
        Assert.assertEquals("result", 2.75D, result, 0);
        Assert.assertEquals("variable a", 2D, (double) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
    }

    @Test
    public void testProofOfPrecedence2 () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a:=2+3/4");
        Assert.assertEquals("result", 2.75D, result, 0);
        Assert.assertEquals("variable a", 2.75D, (double) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
    }

    @Test
    public void testNothing1 () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a:=2;;;");
        Assert.assertEquals("result", 2D, result, 0);
        Assert.assertEquals("variable a", 2D, (double) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
    }

    @Test
    public void testNothing2 () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate(";;;a:=2");
        Assert.assertEquals("result", 2D, result, 0);
        Assert.assertEquals("variable a", 2D, (double) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
    }
}
