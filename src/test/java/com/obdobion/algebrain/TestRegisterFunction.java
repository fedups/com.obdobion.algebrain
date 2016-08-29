package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

import com.obdobion.algebrain.function.FuncMin;

/**
 * <p>
 * TestRegisterFunction class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestRegisterFunction
{
    /**
     * <p>
     * myFunction.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void myFunction() throws Exception
    {
        Equ.getInstance().registerFunction("myFunction", FuncMin.class);
        final Long result = (Long) Equ.getInstance().evaluate("myFunction(5,max(2,3))");
        Assert.assertEquals("min result ", 3, result.longValue());
    }
}
