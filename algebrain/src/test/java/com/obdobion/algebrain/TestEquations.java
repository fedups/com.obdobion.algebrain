package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public class TestEquations extends junit.framework.TestCase
{

    public TestEquations(final String name)
    {

        super(name);
    }

    public void testM10a () throws Exception
    {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("if (1=1,1,2)");
        assertEquals("M10a result ", 1D, result.doubleValue(), 0D);
    }

    public void testM10b () throws Exception
    {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("if (1=3,1,2)");
        assertEquals("M10b result ", 2D, result.doubleValue(), 0D);
    }

    public void testM10c () throws Exception
    {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("5 * if (1=3,1,2)");
        assertEquals("M10c result ", 10D, result.doubleValue(), 0D);
    }

    public void testM10d () throws Exception
    {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("if (1=3,1,if (10 - 9 = 11 - 10,4,5))");
        assertEquals("M10d result ", 4D, result.doubleValue(), 0D);
    }

    public void testM1a () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("2x");
        assertEquals("M1a result ", 10D, result.doubleValue(), 0D);
    }

    public void testM1b () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("2tan(x)");
        assertEquals("M1b result ", 0.17497732705184801, result.doubleValue(), 0D);
    }

    public void testM2 () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("2(3+x)");
        assertEquals("M2 result ", 16D, result.doubleValue(), 0D);
    }

    public void testM3a () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("(2-x)x");
        assertEquals("M3a result ", -15D, result.doubleValue(), 0D);
    }

    public void testM3b () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("(2-x)sin(x)");
        // System.err.println(equ.showRPN());
        assertEquals("M3b result ", -0.2614672282429745, result.doubleValue(), 0D);
    }

    public void testM4a () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("(2-x)(x+1)");
        assertEquals("M4a result ", -18D, result.doubleValue(), 0D);
    }

    public void testM4b () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("sin(x)(2-x)");
        assertEquals("M4b result ", -0.2614672282429745, result.doubleValue(), 0D);
    }

    public void testM5a () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("x(x+1)");
        assertEquals("M5a result ", 30D, result.doubleValue(), 0D);
    }

    public void testM5b () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("x(1-sin(x))");
        assertEquals("M5b result ", 4.564221286261709, result.doubleValue(), 0D);
    }

    public void testM6a () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("3 / (4 * x)11 / 2");
        assertEquals("M6a result ", 0.825, result.doubleValue(), 0D);
    }

    public void testM6b () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("3 / 4 * x * 11 / 2");
        assertEquals("M5b result ", 20.625, result.doubleValue(), 0D);
    }

    public void testM6c () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("4 - 7 + 11 / 3 * x");
        assertEquals("M6c result ", 15.333333333333332, result.doubleValue(), 0D);
    }

    public void testM7a () throws Exception
    {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("max(1,2,3)");
        assertEquals("M7a result ", 3, result.doubleValue(), 0D);
    }

    public void testM7b () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("max(x,8,2,1)");
        assertEquals("M7b result ", 8, result.doubleValue(), 0D);
    }

    public void testM7c () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("x", new Double(5));
        final Double result = (Double) equ.evaluate("max(x,max(x+2,6),1)");
        assertEquals("M7c result ", 7, result.doubleValue(), 0D);
    }

    public void testM8a () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000));
        equ.getSupport().assignVariable("Age", new Double(55));
        equ.getSupport().assignVariable("Prem", new Double(200000));
        final Double result = (Double) equ.evaluate("FacAmt*(100-Age)/Prem*12358+FacAmt ");
        assertEquals("M8a result ", 5670825.00, result.doubleValue(), 0D);
    }

    public void testM8b () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000));
        equ.getSupport().assignVariable("Age", new Double(55));
        equ.getSupport().assignVariable("Prem", new Double(200000));
        final Double result = (Double) equ.evaluate("FacAmt*(100-Age)/Prem*(12358+FacAmt) ");
        assertEquals("M8b result ", 510420825.00, result.doubleValue(), 0D);
    }

    public void testM8c () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000));
        equ.getSupport().assignVariable("Age", new Double(55));
        equ.getSupport().assignVariable("Prem", new Double(200000));
        final Double result = (Double) equ.evaluate("round((FacAmt*100-Age)/Prem*12358+FacAmt,2)");
        assertEquals("M8c result ", 10768496.60, result.doubleValue(), 0D);
    }

    public void testM9a () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000.99));
        final String result = (String) equ.evaluate("alpha(round(FacAmt,0))");
        assertEquals("M9a result ", "1500001", result);
    }

    public void testM9a2 () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000.99));
        final String result = (String) equ.evaluate("alpha(FacAmt)");
        assertEquals("M9a2 result ", "1500000", result);
    }

    public void testM9b () throws Exception
    {

        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("rate('tablename', 'a', 'b')");
        assertEquals("M9b result ", 1D, result.doubleValue(), 0D);
    }

    public void testM9c () throws Exception
    {

        final Equ equ = Equ.getInstance();
        equ.getSupport().assignVariable("FacAmt", new Double(1500000));
        final Double result = (Double) equ.evaluate("rate('tablename', 'a', alpha(FacAmt))");
        assertEquals("M9c result ", 1D, result.doubleValue(), 0D);
    }

    public void testMin () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("min(1,2,3)");
        assertEquals("result ", 1, result.doubleValue(), 0D);
    }

    public void testBooleanEqual () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 = 2");
        assertFalse("result ", result.booleanValue());
    }

    public void testBooleanNotEqual () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 != 2");
        assertTrue("result ", result.booleanValue());
    }

    public void testBooleanGreater () throws Exception
    {

        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 > 2");
        assertFalse("result ", result.booleanValue());
    }

    public void testBooleanNotGreater () throws Exception
    {

        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 <= 2");
        assertTrue("result ", result.booleanValue());
    }

    public void testBooleanLess () throws Exception
    {

        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 < 2");
        assertTrue("result ", result.booleanValue());
    }

    public void testBooleanNotLess () throws Exception
    {

        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("1 >= 2");
        assertFalse("result ", result.booleanValue());
    }
}
