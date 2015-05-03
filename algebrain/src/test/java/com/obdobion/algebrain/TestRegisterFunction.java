package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public class TestRegisterFunction extends junit.framework.TestCase {

    public TestRegisterFunction(final String name) {

        super(name);
    }

    public void testMyFunction () throws Exception {

        Equ.getInstance().registerFunction("myFunction", FuncMin.class);
        final Double result = (Double) Equ.getInstance().evaluate("myFunction(5,max(2,3))");
        assertEquals("min result ", 3D, result.doubleValue(), 0D);
    }
}
