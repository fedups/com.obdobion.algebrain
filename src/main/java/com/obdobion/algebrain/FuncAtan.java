package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncAtan extends Function
{
    public FuncAtan()
    {
        super();
    }

    public FuncAtan(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        final double[] data = convertToDouble(values.pop());
        final double toa = data[0];
        values.push(new Double(Math.atan(toa) * 180 / Math.PI));
    }

    @Override
    public String toString ()
    {
        return "function(acotan)";
    }
}
