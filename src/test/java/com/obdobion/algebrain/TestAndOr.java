package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestAndOr
{
    @Test
    public void conditionalAND1 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true && true");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    @Test
    public void conditionalAND2 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true && false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    @Test
    public void conditionalAND3 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true && not(false)");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    @Test
    public void conditionalAND4 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("not(true && false)");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    @Test
    public void conditionalAND5 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false && false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    @Test
    public void conditionalPrecedence () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("not true && false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    @Test
    public void conditionalOR1 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true || true");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    @Test
    public void conditionalOR2 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true || false");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    @Test
    public void conditionalOR3 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false || not(false)");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    @Test
    public void conditionalOR4 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("not(true || false)");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    @Test
    public void conditionalOR5 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false || false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    @Test
    public void nand1 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true !& false");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    @Test
    public void nand2 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true !& true");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    @Test
    public void nand3 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false !& true");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    @Test
    public void nand4 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false !& false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    @Test
    public void greaterAndLess () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("a:=43;a>=40 && a<50");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

}
