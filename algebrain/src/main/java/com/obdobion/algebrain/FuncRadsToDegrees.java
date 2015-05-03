package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncRadsToDegrees extends Function
{
    public FuncRadsToDegrees()
    {
        super();
    }

    public FuncRadsToDegrees(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        final double[] data = convertToDouble(values.pop());
        final double rads = data[0];
        final double degrees = rads * (180 / Math.PI);
        values.push(new Double(degrees));
    }

    @Override
    public String toString ()
    {
        return "function(sin)";
    }
}
