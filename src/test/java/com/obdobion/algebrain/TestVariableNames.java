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
    public void assignVariableFirst () throws Exception
    {
        Equ.getInstance(true).getSupport().assignVariable("x", 123D);
        final Double result = (Double) Equ.getInstance().evaluate("x * 2");
        Assert.assertEquals(246D, result, 0);
        Assert.assertEquals(123D, Equ.getInstance().getSupport().resolveVariable("x", null));
    }

    @Test
    public void assignVariableSecond () throws Exception
    {
        Equ.getInstance(true).getSupport().assignVariable("x", 123D);
        final Double result = (Double) Equ.getInstance().evaluate("2 * x");
        Assert.assertEquals(246D, result, 0);
        Assert.assertEquals(123D, Equ.getInstance().getSupport().resolveVariable("x", null));
    }

    @Test
    public void dots () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("myvar.inc:=17.2");
        Assert.assertEquals(17.2D, result, 0);
        Assert.assertEquals(17.2D, Equ.getInstance().getSupport().resolveVariable("myvar.inc", null));
    }

    @Test
    public void doubleAsStringError () throws Exception
    {
        try
        {
            Equ.getInstance(true).evaluate("length(trim(2))");
            Assert.fail("should have failed");
        } catch (final Exception e)
        {
            Assert.assertEquals("function(trim); Literal required, found Double", e.getMessage());
        }
    }

    @Test
    public void leadingDot () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("0.5*(_inc:=17.2)");
        Assert.assertEquals(8.6D, result, 0);
        Assert.assertEquals(17.2D, Equ.getInstance().getSupport().resolveVariable("_inc", null));
    }

    @Test
    public void leadingUnderbar () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("_myvar.inc:=17.2");
        Assert.assertEquals(17.2D, result, 0);
        Assert.assertEquals(17.2D, Equ.getInstance().getSupport().resolveVariable("_myvar.inc", null));
    }

    @Test
    public void undefinedVariableAsString () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("length(trim(unknown))");
        Assert.assertEquals(7D, result, 0);
    }

    @Test
    public void unquotedPhraseError () throws Exception
    {
        try
        {
            Equ.getInstance(true).evaluate("length(trim(unquoted phrase))");
            Assert.fail("should have failed");
        } catch (final Exception e)
        {
            Assert.assertEquals("op(multiply); invalid type TokVariable", e.getMessage());
        }
    }
}
