package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncSqrt extends Function
{
    public FuncSqrt()
    {
        super();
    }

    public FuncSqrt(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        final double[] data = convertToDouble(values.pop());
        values.push(new Double(Math.sqrt(data[0])));
    }

    @Override
    public String toString ()
    {
        return "function(sqrt)";
    }
}
