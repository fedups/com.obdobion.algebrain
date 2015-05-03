package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncCos extends Function
{
    public FuncCos()
    {
        super();
    }

    public FuncCos(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        final double[] data = convertToDouble(values.pop());
        final double degrees = data[0];
        final double rads = degrees * (Math.PI / 180);
        values.push(new Double(Math.cos(rads)));
    }

    @Override
    public String toString ()
    {
        return "function(cos)";
    }
}
