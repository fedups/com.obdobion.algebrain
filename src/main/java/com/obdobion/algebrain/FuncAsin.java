package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncAsin extends Function
{
    public FuncAsin()
    {
        super();
    }

    public FuncAsin(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        final double[] data = convertToDouble(values.pop());
        final double soh = data[0];
        values.push(new Double(Math.asin(soh) * 180 / Math.PI));
    }

    @Override
    public String toString ()
    {
        return "function(asin)";
    }
}
