package com.obdobion.algebrain;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestCompiling
{
    @Test
    public void duplicateVariablesAreReturnedOnce () throws Exception
    {
        final Set<String> variableNames = Equ.getInstance().compile("rate(tablename, 'a', alpha(tablename))");
        Assert.assertEquals(1, variableNames.size());
        final String[] v = variableNames.toArray(new String[variableNames.size()]);
        Assert.assertEquals("tablename", v[0]);
    }

    @Test
    public void literalsAreNotInVariableReturns () throws Exception
    {
        final Set<String> variableNames = Equ.getInstance().compile("rate(tablename, 'a', alpha(FacAmt))");
        Assert.assertEquals(2, variableNames.size());
        final String[] v = variableNames.toArray(new String[variableNames.size()]);
        Assert.assertEquals("tablename", v[0]);
        Assert.assertEquals("FacAmt", v[1]);
    }
}
