package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>TestConstants class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestConstants
{
    /**
     * <p>pi.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void pi () throws Exception
    {
        double result = (double) Equ.getInstance(true).evaluate("PI");
        Assert.assertEquals("PI", Math.PI, result, 0D);
    }

    /**
     * <p>e.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void e () throws Exception
    {
        double result = (double) Equ.getInstance(true).evaluate("E");
        Assert.assertEquals("E", Math.E, result, 0D);
    }

    /**
     * <p>unknownConstant.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void unknownConstant () throws Exception
    {
        TokVariable result = (TokVariable) Equ.getInstance(true).evaluate("W");
        Assert.assertEquals("W", "W", result.getValue().toString());
    }
}
