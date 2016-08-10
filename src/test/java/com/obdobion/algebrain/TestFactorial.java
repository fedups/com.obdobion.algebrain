package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>TestFactorial class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestFactorial
{
    /**
     * <p>binomialCoefficient.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void binomialCoefficient () throws Exception
    {
        Equ.getInstance(true).getSupport().assignVariable("n", new Double(5));
        Equ.getInstance().getSupport().assignVariable("k", new Double(6));

        final Double result = (Double) Equ.getInstance().evaluate("(n^k)/(k!)");

        Assert.assertEquals("binomialCoefficient result ", 21.7, result.doubleValue(), 1D);
    }

    /**
     * <p>fac1.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void fac1 () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("3!");
        Assert.assertEquals("factorial result ", 6, result.doubleValue(), 0D);
    }

    /**
     * <p>fraction.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void fraction () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("5.4!");
        Assert.assertEquals("factorial result ", 120, result.doubleValue(), 0D);
    }

    /**
     * <p>negative.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void negative () throws Exception
    {
        try
        {
            Equ.getInstance(true).evaluate("-5!");
            Assert.fail("exception expected but not thrown");
        } catch (final Exception e)
        {
            Assert.assertEquals("negative ", "op(factorial); negative numbers not allowed", e.getMessage());
        }
    }

    /**
     * <p>precedence.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void precedence () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("3*2!");
        Assert.assertEquals("factorial result ", 6, result.doubleValue(), 0D);
    }

    /**
     * <p>preliminaryResult.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void preliminaryResult () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("(3*2)!");
        Assert.assertEquals("factorial result ", 720, result.doubleValue(), 0D);
    }

    /**
     * <p>tooLarge.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void tooLarge () throws Exception
    {
        try
        {
            Equ.getInstance(true).evaluate("21!");
            Assert.fail("exception expected but not thrown");
        } catch (final Exception e)
        {
            Assert.assertEquals("tooLarge ", "op(factorial); numeric overflow", e.getMessage());
        }
    }

    /**
     * <p>veryLarge.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void veryLarge () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("20!");
        Assert.assertEquals("factorial result ", 2.43290200817664e18, result.doubleValue(), 0D);
    }

    /**
     * <p>zero.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void zero () throws Exception
    {
        final Double result = (Double) Equ.getInstance(true).evaluate("0!");
        Assert.assertEquals("factorial result ", 1, result.doubleValue(), 0D);
    }
}
