package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * TestCompiling class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestImpliedMultiply
{
    /**
     * <p>
     * factorialMinus1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void factorialMinus1() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("3!- 2");
        Assert.assertEquals(4, result);
    }

    /**
     * <p>
     * factorialMinus2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void factorialMinus2() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("3!-2");
        Assert.assertEquals(-12, result);
    }

    /**
     * <p>
     * factorialMinus3.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void factorialMinus3() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=2;3!-a");
        Assert.assertEquals(4, result);
    }

    /**
     * <p>
     * factorialMinus4.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void factorialMinus4() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=2;-a 3!");
        Assert.assertEquals(-12, result);
    }

    /**
     * <p>
     * factorialMinus5.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void factorialMinus5() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=2;(-a)3!");
        Assert.assertEquals(-12, result);
    }

    /**
     * <p>
     * functionMinus1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void functionMinus1() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("min(12,13) -2");
        Assert.assertEquals(-24, result);
    }

    /**
     * <p>
     * functionMinus2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void functionMinus2() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("min(12,13) - 2");
        System.out.println(Equ.getInstance().showRPN());
        Assert.assertEquals(10, result);
    }

    /**
     * <p>
     * negativeVariable1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void negativeVariable1() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=4;-a");
        Assert.assertEquals(-4, result);
    }

    /**
     * <p>
     * negativeVariable2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void negativeVariable2() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=4;- a");
        Assert.assertEquals(-4, result);
    }

    /**
     * <p>
     * numberVariable1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void numberVariable1() throws Exception
    {
        final Long result = (Long) Equ.getInstance(true).evaluate("a:=4;2a");
        Assert.assertEquals(8, result.longValue());
    }

    /**
     * <p>
     * numberVariable2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void numberVariable2() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=4;2 a");
        Assert.assertEquals(8, result);
    }

    /**
     * <p>
     * numberVariable3.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void numberVariable3() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=4;-2a");
        Assert.assertEquals(-8, result);
    }

    /**
     * <p>
     * numberVariable4.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void numberVariable4() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=4;2 -a");
        Assert.assertEquals(-2, result);
    }

    /**
     * <p>
     * numberVariable5.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void numberVariable5() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=4;2-a");
        Assert.assertEquals(-2, result);
    }

    /**
     * <p>
     * timesNegative.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void timesNegative1() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=4;5*-a");
        Assert.assertEquals(-20, result);
    }

    /**
     * <p>
     * timesNegative2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void timesNegative2() throws Exception
    {
        final long result = (Long) Equ.getInstance(true).evaluate("a:=4;5*- a");
        Assert.assertEquals(-20, result);
    }
}
