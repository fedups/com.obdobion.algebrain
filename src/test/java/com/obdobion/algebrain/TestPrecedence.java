package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestPrecedence
{
    @Test
    public void mdas01 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 * 3 / 4 + 5 - 6");
        Assert.assertEquals("result", 0.5D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas02 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("5 - 6 + 3 / 4 * 2");
        Assert.assertEquals("result", 0.5D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas03 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 * 3 / (4 + 5 - 6)");
        Assert.assertEquals("result", 2D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas04 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 * 3 / 4 ");
        Assert.assertEquals("result", 1.5D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas05 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("3 / 4 * 2");
        Assert.assertEquals("result", 1.5D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas06 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("3 / (4 * 2)");
        Assert.assertEquals("result", 0.375D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas07 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("3 / 4 + 1 / 4");
        Assert.assertEquals("result", 1D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas08 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("3 / (4 + 1) / 4");
        Assert.assertEquals("result", 0.15D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas09 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 ^ 10");
        Assert.assertEquals("result", 1024D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas10 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 ^ 5 + 5");
        Assert.assertEquals("result", 37D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas11 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 ^ (5 + 5)");
        Assert.assertEquals("result", 1024D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas12 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 ^ 5 * 2");
        Assert.assertEquals("result", 64D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas13 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 ^ (5 * 2)");
        Assert.assertEquals("result", 1024D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas14 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 + 3 * 4 ^ 2");
        Assert.assertEquals("result", 50D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas15 () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 * (3 + 4) ^ 2");
        System.out.println(equ.showRPN());
        Assert.assertEquals("result", 98D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas16 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ (2 + 3)");
        System.out.println(equ.showRPN());
        Assert.assertEquals("result", 32D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas17 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ (2 + 3 * 2)");
        System.out.println(equ.showRPN());
        Assert.assertEquals("result", 256D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas18 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ (2 + 3 ^ 2)");
        System.out.println(equ.showRPN());
        Assert.assertEquals("result", 2048D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas18b () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ (2 + 3) ^ 2");
        System.out.println(equ.showRPN());
        Assert.assertEquals("result", 1024D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas18c () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ 2 + 3 ^ 2");
        System.out.println(equ.showRPN());
        Assert.assertEquals("result", 13D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas19 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ 3 ^ 2");
        System.out.println(equ.showRPN());
        Assert.assertEquals("result", 64D, result.doubleValue(), 0D);
    }

    @Test
    public void mdas20 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ (3 ^ 2)");
        System.out.println(equ.showRPN());
        Assert.assertEquals("result", 512D, result.doubleValue(), 0D);
    }

    @Test
    public void web01 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 15; b := 3; t := 4; (a - b) / t");
        Assert.assertEquals("result", 3D, result.doubleValue(), 0D);
    }

    @Test
    public void web02 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 15; b := 3; t := 4; (2(a - b) + 3b - 5) / (t + b)");
        Assert.assertEquals("result", 4D, result.doubleValue(), 0D);
    }

    @Test
    public void web03 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 15; b := 3; t := 4; 2(a - b)^2 / 10");
        System.out.println(equ.showRPN());
        Assert.assertEquals("result", 28.8D, result.doubleValue(), 0D);
    }

    @Test
    public void web03ForcedDefaultAnyway () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 15; b := 3; t := 4; 2((a - b)^2) / 10");
        Assert.assertEquals("result", 28.8D, result.doubleValue(), 0D);
    }

    @Test
    public void web03ForcedWrong () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 15; b := 3; t := 4; (2(a - b))^2 / 10");
        Assert.assertEquals("result", 57.6D, result.doubleValue(), 0D);
    }

    @Test
    public void web04 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("v := 5; t := 2; a := 10;v t + 1/2a t^2");
        Assert.assertEquals("result", 30D, result.doubleValue(), 0D);
    }

    @Test
    public void web05 () throws Exception
    {
        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("d := 80; t := 2; a := 10;(d - 1/2 a t^2) / t");
        System.out.println(equ.showRPN());
        Assert.assertEquals("result", 30D, result.doubleValue(), 0D);
    }
}
