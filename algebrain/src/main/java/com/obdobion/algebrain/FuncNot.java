package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncNot extends Function
{
    public FuncNot()
    {
        super();
    }

    public FuncNot(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operand for " + toString());
        final boolean[] data = convertToBoolean(values.pop());
        values.push(new Boolean(!data[0]));
    }

    @Override
    public String toString ()
    {
        return "function(not)";
    }
}
