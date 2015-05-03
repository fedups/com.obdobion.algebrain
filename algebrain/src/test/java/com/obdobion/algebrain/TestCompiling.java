package com.obdobion.algebrain;

import java.util.Set;

/**
 * @author Chris DeGreef
 * 
 */
public class TestCompiling extends junit.framework.TestCase {

    public TestCompiling(final String name) {

        super(name);
    }

    public void testDuplicateVariablesAreReturnedOnce () throws Exception {

        final Set<String> variableNames = Equ.getInstance().compile("rate(tablename, 'a', alpha(tablename))");
        assertEquals(1, variableNames.size());
        final String[] v = variableNames.toArray(new String[variableNames.size()]);
        assertEquals("tablename", v[0]);
    }

    public void testLiteralsAreNotInVariableReturns () throws Exception {

        final Set<String> variableNames = Equ.getInstance().compile("rate(tablename, 'a', alpha(FacAmt))");
        assertEquals(2, variableNames.size());
        final String[] v = variableNames.toArray(new String[variableNames.size()]);
        assertEquals("tablename", v[0]);
        assertEquals("FacAmt", v[1]);
    }
}
