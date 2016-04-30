package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncStringLength extends Function
{
    public FuncStringLength()
    {
        super();
    }

    public FuncStringLength(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        values.push(new Double(((String) values.pop()).length()));
    }

    @Override
    public String toString ()
    {
        return "function(length)";
    }
}
