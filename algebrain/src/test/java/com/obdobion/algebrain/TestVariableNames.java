package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public class TestVariableNames extends junit.framework.TestCase {

    public TestVariableNames(final String name) {

        super(name);
    }

    public void testDots () throws Exception {

        final Double result = (Double) Equ.getInstance().evaluate("myvar.inc:=17.2");
        assertEquals(17.2D, result);
        assertEquals(17.2D, Equ.getInstance().getSupport().resolveVariable("myvar.inc", null));
    }

    public void testLeadingDot () throws Exception {

        final Double result = (Double) Equ.getInstance().evaluate("0.5*(_inc:=17.2)");
        assertEquals(8.6D, result);
        assertEquals(17.2D, Equ.getInstance().getSupport().resolveVariable("_inc", null));
    }

    public void testLeadingUnderbar () throws Exception {

        final Double result = (Double) Equ.getInstance().evaluate("_myvar.inc:=17.2");
        assertEquals(17.2D, result);
        assertEquals(17.2D, Equ.getInstance().getSupport().resolveVariable("_myvar.inc", null));
    }

    public void testAssignVariableFirst () throws Exception
    {
        Equ.getInstance().getSupport().assignVariable("x", 123D);
        final Double result = (Double) Equ.getInstance().evaluate("x * 2");
        assertEquals(246D, result);
        assertEquals(123D, Equ.getInstance().getSupport().resolveVariable("x", null));
    }

    public void testAssignVariableSecond () throws Exception
    {
        Equ.getInstance().getSupport().assignVariable("x", 123D);
        final Double result = (Double) Equ.getInstance().evaluate("2 * x");
        assertEquals(246D, result);
        assertEquals(123D, Equ.getInstance().getSupport().resolveVariable("x", null));
    }

}
