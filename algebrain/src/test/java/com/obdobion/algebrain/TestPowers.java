package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public class TestPowers extends junit.framework.TestCase
{

    public TestPowers(final String name)
    {

        super(name);
    }

    public void testPower1 () throws Exception
    {

        final Double result = (Double) Equ.getInstance().evaluate("2^5");
        assertEquals("testPower1 result ", 32D, result.doubleValue(), 0D);
    }

    public void testPower2 () throws Exception
    {

        final Double result = (Double) Equ.getInstance().evaluate("2^5*3");
        assertEquals("testPower2 result ", 96D, result.doubleValue(), 0D);
    }

    public void testPower3 () throws Exception
    {

        final Double result = (Double) Equ.getInstance().evaluate("3*2^5");
        assertEquals("testPower3 result ", 96D, result.doubleValue(), 0D);
    }

    public void testPower4 () throws Exception
    {

        final Double result = (Double) Equ.getInstance().evaluate("(3*2)^5");
        assertEquals("testPower4 result ", 7776D, result.doubleValue(), 0D);
    }

    public void testPower5 () throws Exception
    {

        final Double result = (Double) Equ.getInstance().evaluate("2^(5*3)");
        assertEquals("testPower5 result ", 32768D, result.doubleValue(), 0D);
    }

    public void testMod1 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("13%10");
        assertEquals("testMod1 result ", 3, result.doubleValue(), 0D);
    }

    public void testMod2 () throws Exception
    {
        final Double result = (Double) Equ.getInstance().evaluate("round(13.76%3, 2)");
        assertEquals("testMod2 result ", 1.76, result.doubleValue(), 0D);
    }

    public void testMod3 () throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance().evaluate("85 % 2 = 1");
        assertEquals("testMod3 result ", true, result.booleanValue());
    }
}
