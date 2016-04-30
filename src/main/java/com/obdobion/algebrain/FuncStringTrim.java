package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncStringTrim extends Function
{
    public FuncStringTrim()
    {
        super();
    }

    public FuncStringTrim(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        String target = (String) values.pop();

        values.push(target.trim());
    }

    @Override
    public String toString ()
    {
        return "function(trim)";
    }
}
