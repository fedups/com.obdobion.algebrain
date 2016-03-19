package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncRoot extends Function
{
    public FuncRoot()
    {
        super();
    }

    public FuncRoot(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        final double[] data = convertToDouble(values.pop(), values.pop());
        values.push(new Double(Math.pow(10, Math.log10(data[1]) / data[0])));
    }

    @Override
    public String toString ()
    {
        return "function(root)";
    }
}
