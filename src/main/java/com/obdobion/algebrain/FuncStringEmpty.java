package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncStringEmpty extends Function
{
    public FuncStringEmpty()
    {
        super();
    }

    public FuncStringEmpty(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        String target;
        target = (String) values.pop();

        if (target == null || target.trim().length() == 0)
            values.push(new Boolean(true));
        else
            values.push(new Boolean(false));
    }

    @Override
    public String toString ()
    {
        return "function(empty)";
    }
}
