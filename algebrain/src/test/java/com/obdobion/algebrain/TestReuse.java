package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestReuse
{
    @Test
    @SuppressWarnings("null")
    public void reuseEqu () throws Exception
    {
        final Equ equ = Equ.getInstance();

        long start, dur;
        Double result = null;
        equ.getSupport().assignVariable("x", new Double(5));
        start = System.currentTimeMillis();
        for (int x = 0; x <= 1000; x++) {
            result = (Double) equ.evaluate("2x");
        }
        dur = System.currentTimeMillis() - start;
        System.out.println(dur);
        Assert.assertEquals("ReuseEqu result1 ", 10D, result.doubleValue(), 0D);

        equ.getSupport().assignVariable("x", new Double(5));
        start = System.currentTimeMillis();
        for (int x = 0; x <= 1000; x++) {
            equ.compile("2x");
        }
        dur = System.currentTimeMillis() - start;
        System.out.println(dur);

        start = System.currentTimeMillis();
        for (long x = 0; x <= 400000; x++) {
            equ.getSupport().assignVariable("x", new Double(x));
            result = (Double) equ.evaluate();
        }
        dur = System.currentTimeMillis() - start;
        System.out.println(dur);
        Assert.assertEquals("ReuseEqu result2 ", 800000D, result.doubleValue(), 0D);
    }
}
