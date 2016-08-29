package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * TestChaining class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestChaining
{
    /**
     * <p>
     * testChainingToOverridePrecedence.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void testChainingToOverridePrecedence() throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a:=2;+3;/4");
        Assert.assertEquals("result", 1.25D, result, 0);
        Assert.assertEquals("variable a", 2, (long) Equ.getInstance().getSupport().resolveVariable("a", null));
    }

    /**
     * <p>
     * testNothing1.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void testNothing1() throws Exception
    {
        Equ.getInstance(true);
        final Long result = (Long) Equ.getInstance().evaluate("a:=2;;;");
        Assert.assertEquals("result", 2, result.intValue());
        Assert.assertEquals("variable a", 2, (long) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
    }

    /**
     * <p>
     * testNothing2.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void testNothing2() throws Exception
    {
        Equ.getInstance(true);
        final Long result = (Long) Equ.getInstance().evaluate(";;;a:=2");
        Assert.assertEquals("result", 2, result.intValue());
        Assert.assertEquals("variable a", 2, (long) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
    }

    /**
     * <p>
     * testPresetVariables.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void testPresetVariables() throws Exception
    {
        Equ.getInstance(true);
        final Long result = (Long) Equ.getInstance().evaluate("a:=2; b:=a+1; c:=a*b");
        Assert.assertEquals("result", 6, result.intValue());
        Assert.assertEquals("variable a", 2, (long) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
        Assert.assertEquals("variable b", 3, (long) Equ.getInstance().getSupport().resolveVariable("b", null), 0);
        Assert.assertEquals("variable c", 6, (long) Equ.getInstance().getSupport().resolveVariable("c", null), 0);
    }

    /**
     * <p>
     * testProofOfPrecedence.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void testProofOfPrecedence() throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("(a:=2)+3/4");
        Assert.assertEquals("result", 2.75D, result, 0);
        Assert.assertEquals("variable a", 2, (long) Equ.getInstance().getSupport().resolveVariable("a", null));
    }

    /**
     * <p>
     * testProofOfPrecedence2.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void testProofOfPrecedence2() throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a:=2+3/4");
        Assert.assertEquals("result", 2.75D, result, 0);
        Assert.assertEquals("variable a", 2.75D, (double) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
    }

    /**
     * <p>
     * testTrailingChainMarker.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void testTrailingChainMarker() throws Exception
    {
        Equ.getInstance(true);
        final Long result = (Long) Equ.getInstance().evaluate("a:=2;b:=a+1;c:=a*b;");
        Assert.assertEquals("result", 6, result.intValue());
        Assert.assertEquals("variable a", 2, (long) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
        Assert.assertEquals("variable b", 3, (long) Equ.getInstance().getSupport().resolveVariable("b", null), 0);
        Assert.assertEquals("variable c", 6, (long) Equ.getInstance().getSupport().resolveVariable("c", null), 0);
    }

    /**
     * <p>
     * testTrailingChainMarker2.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void testTrailingChainMarker2() throws Exception
    {
        Equ.getInstance(true);
        final Long result = (Long) Equ.getInstance().evaluate("a:=2; b:=a+1; a*b;");
        Assert.assertEquals("result", 6, result.intValue());
        Assert.assertEquals("variable a", 2, (long) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
        Assert.assertEquals("variable b", 3, (long) Equ.getInstance().getSupport().resolveVariable("b", null), 0);
        Assert.assertNull("variable c", Equ.getInstance().getSupport().resolveVariable("c", null));
    }

    /**
     * <p>
     * testUnexpectedChaining.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void testUnexpectedChaining() throws Exception
    {
        Equ.getInstance(true);
        final Long result = (Long) Equ.getInstance().evaluate("a:=2;*3");
        Assert.assertEquals("result", 6, result.intValue());
        Assert.assertEquals("variable a", 2, (long) Equ.getInstance().getSupport().resolveVariable("a", null), 0);
    }
}
