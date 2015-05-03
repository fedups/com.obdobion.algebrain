package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public class TestChaining extends junit.framework.TestCase
{

    public TestChaining(final String name)
    {

        super(name);
    }

    public void testPresetVariables () throws Exception
    {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("a:=2; b:=a+1; c:=a*b");
        assertEquals("result", 6D, result);
        assertEquals("variable a", 2D, Equ.getInstance().getSupport().resolveVariable("a", null));
        assertEquals("variable b", 3D, Equ.getInstance().getSupport().resolveVariable("b", null));
        assertEquals("variable c", 6D, Equ.getInstance().getSupport().resolveVariable("c", null));
    }

    public void testTrailingChainMarker () throws Exception
    {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("a:=2;b:=a+1;c:=a*b;");
        assertEquals("result", 6D, result);
        assertEquals("variable a", 2D, Equ.getInstance().getSupport().resolveVariable("a", null));
        assertEquals("variable b", 3D, Equ.getInstance().getSupport().resolveVariable("b", null));
        assertEquals("variable c", 6D, Equ.getInstance().getSupport().resolveVariable("c", null));
    }

    public void testTrailingChainMarker2 () throws Exception
    {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("a:=2; b:=a+1; a*b;");
        assertEquals("result", 6D, result);
        assertEquals("variable a", 2D, Equ.getInstance().getSupport().resolveVariable("a", null));
        assertEquals("variable b", 3D, Equ.getInstance().getSupport().resolveVariable("b", null));
        assertNull("variable c", Equ.getInstance().getSupport().resolveVariable("c", null));
    }

    public void testUnexpectedChaining () throws Exception
    {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("a:=2;*3");
        assertEquals("result", 6D, result);
        assertEquals("variable a", 2D, Equ.getInstance().getSupport().resolveVariable("a", null));
    }

    public void testChainingToOverridePrecedence () throws Exception
    {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("a:=2;+3;/4");
        assertEquals("result", 1.25D, result);
        assertEquals("variable a", 2D, Equ.getInstance().getSupport().resolveVariable("a", null));
    }

    public void testProofOfPrecedence () throws Exception
    {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("(a:=2)+3/4");
        assertEquals("result", 2.75D, result);
        assertEquals("variable a", 2D, Equ.getInstance().getSupport().resolveVariable("a", null));
    }

    public void testProofOfPrecedence2 () throws Exception
    {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("a:=2+3/4");
        assertEquals("result", 2.75D, result);
        assertEquals("variable a", 2.75D, Equ.getInstance().getSupport().resolveVariable("a", null));
    }

    public void testNothing1 () throws Exception
    {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("a:=2;;;");
        assertEquals("result", 2D, result);
        assertEquals("variable a", 2D, Equ.getInstance().getSupport().resolveVariable("a", null));
    }

    public void testNothing2 () throws Exception
    {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate(";;;a:=2");
        assertEquals("result", 2D, result);
        assertEquals("variable a", 2D, Equ.getInstance().getSupport().resolveVariable("a", null));
    }
}
