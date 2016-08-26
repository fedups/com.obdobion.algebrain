package com.obdobion.algebrain;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * TestCompiling class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestCompiling
{
    /**
     * <p>
     * duplicateVariablesAreReturnedOnce.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void duplicateVariablesAreReturnedOnce() throws Exception
    {
        final Set<String> variableNames = Equ.getInstance().compile("rate(tablename, 'a', alpha(tablename))");
        Assert.assertEquals(1, variableNames.size());
        final String[] v = variableNames.toArray(new String[variableNames.size()]);
        Assert.assertEquals("tablename", v[0]);
    }

    /**
     * <p>
     * literalsAreNotInVariableReturns.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void literalsAreNotInVariableReturns() throws Exception
    {
        final Set<String> variableNames = Equ.getInstance().compile("rate(tablename, 'a', alpha(FacAmt))");
        Assert.assertEquals(2, variableNames.size());
        final String[] v = variableNames.toArray(new String[variableNames.size()]);
        Assert.assertEquals("FacAmt", v[1]);
        Assert.assertEquals("tablename", v[0]);
    }
}
