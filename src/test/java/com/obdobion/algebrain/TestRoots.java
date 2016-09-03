package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * TestRoots class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestRoots
{
    /**
     * <p>
     * sqrt.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void sqrt() throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("sqrt(9)");
        Assert.assertEquals("result ", 3, result.doubleValue(), 0D);
    }

    /**
     * <p>
     * cbrt.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void cbrt() throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("cbrt(27)");
        Assert.assertEquals("result ", 3, result.doubleValue(), 0D);
    }

    /**
     * <p>
     * cbrt2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void cbrt2() throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("cbrt(9*9*9)");
        Assert.assertEquals("result ", 9, result.doubleValue(), 0D);
    }

    /**
     * <p>
     * sqrt2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void sqrt2() throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("sqrt(9*9*9)");
        Assert.assertEquals("result ", 27, result.doubleValue(), 0D);
    }

    /**
     * <p>
     * srootOFcroot.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void srootOFcroot() throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("sqrt(cbrt(9*9*9))");
        Assert.assertEquals("result ", 3, result.doubleValue(), 5D);
    }

    /**
     * <p>
     * crootOFsroot.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void crootOFsroot() throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("cbrt(sqrt(9*9*9))");
        Assert.assertEquals("result ", 3, result.doubleValue(), 5D);
    }

    /**
     * <p>
     * root2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void root2() throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("root(16, 2))");
        Assert.assertEquals("result ", 4, result.doubleValue(), 0D);
    }

    /**
     * <p>
     * root4.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void root4() throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("root(9*9*9*9, 4))");
        Assert.assertEquals("result ", 9, result.doubleValue(), 0D);
    }
}
