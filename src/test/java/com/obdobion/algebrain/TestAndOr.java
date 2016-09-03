package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * TestAndOr class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestAndOr
{
    /**
     * <p>
     * conditionalAND1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalAND1() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true && true");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * conditionalAND2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalAND2() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true && false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * conditionalAND3.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalAND3() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true && not(false)");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * conditionalAND4.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalAND4() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("not(true && false)");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * conditionalAND5.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalAND5() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false && false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * conditionalOR1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalOR1() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true || true");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * conditionalOR2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalOR2() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true || false");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * conditionalOR3.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalOR3() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false || not(false)");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * conditionalOR4.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalOR4() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("not(true || false)");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * conditionalOR5.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalOR5() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false || false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * conditionalPrecedence.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalPrecedence() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("not true && false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * greaterAndLess.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void greaterAndLess() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("a:=43;a>=40 && a<50");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * nand1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nand1() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true !& false");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * nand2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nand2() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true !& true");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * nand3.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nand3() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false !& true");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * nand4.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nand4() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false !& false");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * nor1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nor1() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false !| false");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * nor2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nor2() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false !| true");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * nor3.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nor3() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true !| false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * nor4.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void nor4() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true !| true");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * xnor1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void xnor1() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false !~| false");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * xnor2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void xnor2() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false !~| true");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * xnor3.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void xnor3() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true !~| false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * xnor4.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void xnor4() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true !~| true");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * xor1.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void xor1() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false ~| false");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

    /**
     * <p>
     * xor2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void xor2() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("false ~| true");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * xor3.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void xor3() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true ~| false");
        Assert.assertEquals("result ", true, result.booleanValue());
    }

    /**
     * <p>
     * xor4.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void xor4() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate("true ~| true");
        Assert.assertEquals("result ", false, result.booleanValue());
    }

}
