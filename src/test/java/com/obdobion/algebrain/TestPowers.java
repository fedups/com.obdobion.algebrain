package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * TestPowers class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestPowers
{
    /**
     * <p>
     * power1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void power1() throws Exception
    {
        final Long result = (Long) Equ.getInstance().evaluate("2^5");
        Assert.assertEquals("testPower1 result ", 32, (long) result);
    }

    /**
     * <p>
     * power2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void power2() throws Exception
    {
        final Long result = (Long) Equ.getInstance().evaluate("2^5*3");
        Assert.assertEquals("testPower2 result ", 96, (long) result);
    }

    /**
     * <p>
     * power3.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void power3() throws Exception
    {
        final Long result = (Long) Equ.getInstance().evaluate("3*2^5");
        Assert.assertEquals("testPower3 result ", 96, (long) result);
    }

    /**
     * <p>
     * power4.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void power4() throws Exception
    {
        final Long result = (Long) Equ.getInstance().evaluate("(3*2)^5");
        Assert.assertEquals("testPower4 result ", 7776, (long) result);
    }

    /**
     * <p>
     * power5.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void power5() throws Exception
    {
        final Long result = (Long) Equ.getInstance().evaluate("2^(5*3)");
        Assert.assertEquals("testPower5 result ", 32768, (long) result);
    }

    /**
     * <p>
     * powerFloat.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void powerFloat() throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("2^(5.2*3)");
        Assert.assertEquals("powerFloat result ", 49667.0004D, result, 0.0001);
    }
}
