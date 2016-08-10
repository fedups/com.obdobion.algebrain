package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>TestPowers class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestPowers
{
    /**
     * <p>power1.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void power1 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("2^5");
        Assert.assertEquals("testPower1 result ", 32D, result.doubleValue(), 0D);
    }

    /**
     * <p>power2.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void power2 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("2^5*3");
        Assert.assertEquals("testPower2 result ", 96D, result.doubleValue(), 0D);
    }

    /**
     * <p>power3.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void power3 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("3*2^5");
        Assert.assertEquals("testPower3 result ", 96D, result.doubleValue(), 0D);
    }

    /**
     * <p>power4.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void power4 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("(3*2)^5");
        Assert.assertEquals("testPower4 result ", 7776D, result.doubleValue(), 0D);
    }

    /**
     * <p>power5.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void power5 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("2^(5*3)");
        Assert.assertEquals("testPower5 result ", 32768D, result.doubleValue(), 0D);
    }
}
