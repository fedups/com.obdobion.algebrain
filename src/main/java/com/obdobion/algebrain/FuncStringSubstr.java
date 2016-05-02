package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncStringSubstr extends Function
{
    public FuncStringSubstr()
    {
        super();
    }

    public FuncStringSubstr(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 3)
            throw new Exception("requires 3 parameters " + toString());
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        Double length = (Double) values.pop();
        Double offset = (Double) values.pop();
        String target = (String) values.pop();

        values.push(target.substring(offset.intValue(), offset.intValue() + length.intValue()));
    }

    @Override
    public String toString ()
    {
        return "function(substr)";
    }
}
