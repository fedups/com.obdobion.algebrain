package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

import com.obdobion.algebrain.function.FuncMin;

/**
 * @author Chris DeGreef
 * 
 */
public class TestRegisterFunction
{
    @Test
    public void myFunction () throws Exception
    {
        Equ.getInstance().registerFunction("myFunction", FuncMin.class);
        final Double result = (Double) Equ.getInstance().evaluate("myFunction(5,max(2,3))");
        Assert.assertEquals("min result ", 3D, result.doubleValue(), 0D);
    }
}
