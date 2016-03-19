package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestTrig
{
    @Test
    public void web01 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("10 sin(30)");
        Assert.assertEquals("result", 5D, result.doubleValue(), 0.01D);
    }

    @Test
    public void web01a () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("10sin(deg(0.5236))");
        Assert.assertEquals("result", 5D, result.doubleValue(), 0.01D);
    }

    @Test
    public void web01b () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("cos(30)");
        Assert.assertEquals("result", 0.866D, result.doubleValue(), 0.01D);
    }

    @Test
    public void web02 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("4 / tan(55)");
        Assert.assertEquals("result", 2.8D, result.doubleValue(), 0.01D);
    }

    @Test
    public void web02a () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 4 / tan(55); sqrt(4^2 + a^2)");
        Assert.assertEquals("result", 4.88D, result.doubleValue(), 0.01D);
    }

    @Test
    public void web03 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        equ.evaluate("a:=acos(3/4); b:=90-a");
        Assert.assertEquals("result", 41.4D, (Double) Equ.getInstance().getSupport().resolveVariable("a", null), 0.01D);
        Assert.assertEquals("result", 48.6D, (Double) Equ.getInstance().getSupport().resolveVariable("b", null), 0.01D);
    }

    @Test
    public void web04 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        equ.evaluate("c:=sqrt(3^2+5^2);a:=atan(5/3);b:=90-a");
        Assert.assertEquals("result", 59.04D, (Double) Equ.getInstance().getSupport().resolveVariable("a", null), 0.01D);
        Assert.assertEquals("result", 30.96D, (Double) Equ.getInstance().getSupport().resolveVariable("b", null), 0.01D);
        Assert.assertEquals("result", 5.83D, (Double) Equ.getInstance().getSupport().resolveVariable("c", null), 0.01D);
    }

    @Test
    public void web05 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        equ.evaluate("v:=25sin(25);h:=25cos(25)");
        Assert.assertEquals("result", 10.57D, (Double) Equ.getInstance().getSupport().resolveVariable("v", null), 0.01D);
        Assert.assertEquals("result", 22.66D, (Double) Equ.getInstance().getSupport().resolveVariable("h", null), 0.01D);
    }

    @Test
    public void web06 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        equ.evaluate("a:=3.21/9.47;atana:=atan(a);v:=sqrt(3.21^2+9.47^2)");
        Assert.assertEquals("result", 0.339D, (Double) Equ.getInstance().getSupport().resolveVariable("a", null), 0.01D);
        Assert.assertEquals(
                "result",
                18.72D,
                (Double) Equ.getInstance().getSupport().resolveVariable("atana", null),
                0.01D);
        Assert.assertEquals("result", 9.99D, (Double) Equ.getInstance().getSupport().resolveVariable("v", null), 0.01D);
    }
}
