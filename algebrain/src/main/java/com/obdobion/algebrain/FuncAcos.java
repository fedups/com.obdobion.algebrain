package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncAcos extends Function
{
    public FuncAcos()
    {
        super();
    }

    public FuncAcos(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        final double[] data = convertToDouble(values.pop());
        values.push(new Double(Math.acos(data[0]) * 180 / Math.PI));
    }

    @Override
    public String toString ()
    {
        return "function(acos)";
    }
}
