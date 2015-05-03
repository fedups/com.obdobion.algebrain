package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public class TestPrecedence extends junit.framework.TestCase {

    public TestPrecedence(final String name) {

        super(name);
    }

    public void testMDAS01 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 * 3 / 4 + 5 - 6");
        assertEquals("result", 0.5D, result.doubleValue(), 0D);
    }

    public void testMDAS02 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("5 - 6 + 3 / 4 * 2");
        assertEquals("result", 0.5D, result.doubleValue(), 0D);
    }

    public void testMDAS03 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 * 3 / (4 + 5 - 6)");
        assertEquals("result", 2D, result.doubleValue(), 0D);
    }

    public void testMDAS04 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 * 3 / 4 ");
        assertEquals("result", 1.5D, result.doubleValue(), 0D);
    }

    public void testMDAS05 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("3 / 4 * 2");
        assertEquals("result", 1.5D, result.doubleValue(), 0D);
    }

    public void testMDAS06 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("3 / (4 * 2)");
        assertEquals("result", 0.375D, result.doubleValue(), 0D);
    }

    public void testMDAS07 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("3 / 4 + 1 / 4");
        assertEquals("result", 1D, result.doubleValue(), 0D);
    }

    public void testMDAS08 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("3 / (4 + 1) / 4");
        assertEquals("result", 0.15D, result.doubleValue(), 0D);
    }

    public void testMDAS09 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 ^ 10");
        assertEquals("result", 1024D, result.doubleValue(), 0D);
    }

    public void testMDAS10 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 ^ 5 + 5");
        assertEquals("result", 37D, result.doubleValue(), 0D);
    }

    public void testMDAS11 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 ^ (5 + 5)");
        assertEquals("result", 1024D, result.doubleValue(), 0D);
    }

    public void testMDAS12 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 ^ 5 * 2");
        assertEquals("result", 64D, result.doubleValue(), 0D);
    }

    public void testMDAS13 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 ^ (5 * 2)");
        assertEquals("result", 1024D, result.doubleValue(), 0D);
    }

    public void testMDAS14 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 + 3 * 4 ^ 2");
        assertEquals("result", 50D, result.doubleValue(), 0D);
    }

    public void testMDAS15 () throws Exception {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("2 * (3 + 4) ^ 2");
        System.out.println(equ.showRPN());
        assertEquals("result", 98D, result.doubleValue(), 0D);
    }

    public void testMDAS16 () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ (2 + 3)");
        System.out.println(equ.showRPN());
        assertEquals("result", 32D, result.doubleValue(), 0D);
    }

    public void testMDAS17 () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ (2 + 3 * 2)");
        System.out.println(equ.showRPN());
        assertEquals("result", 256D, result.doubleValue(), 0D);
    }

    public void testMDAS18 () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ (2 + 3 ^ 2)");
        System.out.println(equ.showRPN());
        assertEquals("result", 2048D, result.doubleValue(), 0D);
    }

    public void testMDAS18b () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ (2 + 3) ^ 2");
        System.out.println(equ.showRPN());
        assertEquals("result", 1024D, result.doubleValue(), 0D);
    }

    public void testMDAS18c () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ 2 + 3 ^ 2");
        System.out.println(equ.showRPN());
        assertEquals("result", 13D, result.doubleValue(), 0D);
    }

    public void testMDAS19 () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ 3 ^ 2");
        System.out.println(equ.showRPN());
        assertEquals("result", 64D, result.doubleValue(), 0D);
    }

    public void testMDAS20 () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("2 ^ (3 ^ 2)");
        System.out.println(equ.showRPN());
        assertEquals("result", 512D, result.doubleValue(), 0D);
    }

    public void testWeb01 () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 15; b := 3; t := 4; (a - b) / t");
        assertEquals("result", 3D, result.doubleValue(), 0D);
    }

    public void testWeb02 () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 15; b := 3; t := 4; (2(a - b) + 3b - 5) / (t + b)");
        assertEquals("result", 4D, result.doubleValue(), 0D);
    }

    public void testWeb03 () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 15; b := 3; t := 4; 2(a - b)^2 / 10");
        System.out.println(equ.showRPN());
        assertEquals("result", 28.8D, result.doubleValue(), 0D);
    }

    public void testWeb03ForcedDefaultAnyway () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 15; b := 3; t := 4; 2((a - b)^2) / 10");
        assertEquals("result", 28.8D, result.doubleValue(), 0D);
    }

    public void testWeb03ForcedWrong () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("a := 15; b := 3; t := 4; (2(a - b))^2 / 10");
        assertEquals("result", 57.6D, result.doubleValue(), 0D);
    }

    public void testWeb04 () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("v := 5; t := 2; a := 10;v t + 1/2a t^2");
        assertEquals("result", 30D, result.doubleValue(), 0D);
    }

    public void testWeb05 () throws Exception {

        final Equ equ = Equ.getInstance(true);
        final Double result = (Double) equ.evaluate("d := 80; t := 2; a := 10;(d - 1/2 a t^2) / t");
        System.out.println(equ.showRPN());
        assertEquals("result", 30D, result.doubleValue(), 0D);
    }

}
