package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * TestModulus class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestModulus
{
    /**
     * <p>
     * mod1.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void mod1() throws Exception
    {
        final Long result = (Long) Equ.getInstance().evaluate("13%10");
        Assert.assertEquals("testMod1 result ", 3, result.longValue());
    }

    /**
     * <p>
     * mod2.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void mod2() throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("round(13.76%3, 2)");
        Assert.assertEquals("testMod2 result ", 1.76, result.doubleValue(), 0D);
    }

    /**
     * <p>
     * mod3.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void mod3() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance().evaluate("85 % 2 = 1");
        Assert.assertEquals("testMod3 result ", true, result.booleanValue());
    }
}
