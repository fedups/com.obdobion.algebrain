package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * TestReuse class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestReuse
{
    /**
     * <p>
     * reuseEqu.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    @SuppressWarnings("null")
    public void reuseEqu() throws Exception
    {
        final Equ equ = Equ.getInstance(true);

        Double result = null;
        equ.getSupport().assignVariable("x", new Double(5));
        for (int x = 0; x <= 1000; x++)
            result = (Double) equ.evaluate("2x");

        Assert.assertEquals("ReuseEqu result1 ", 10D, result.doubleValue(), 0D);

        equ.getSupport().assignVariable("x", new Double(5));
        for (int x = 0; x <= 1000; x++)
            equ.compile("2x");

        for (long x = 0; x <= 400000; x++)
        {
            equ.getSupport().assignVariable("x", new Double(x));
            result = (Double) equ.evaluate();
        }

        Assert.assertEquals("ReuseEqu result2 ", 800000D, result.doubleValue(), 0D);
    }

    /**
     * <p>
     * reuseVarAssignment.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void reuseVarAssignment() throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        Assert.assertTrue(((Boolean) equ.evaluate("x:=2;x>1 && x<3")).booleanValue());
        Assert.assertFalse(((Boolean) equ.evaluate("x:=3;x>1 && x<3")).booleanValue());
    }

}
