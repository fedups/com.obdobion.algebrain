package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncStringCat extends Function
{
    public FuncStringCat()
    {
        super();
    }

    public FuncStringCat(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        StringBuilder sb = new StringBuilder();
        for (int p = 0; p < getParameterCount(); p++)
        {
            sb.insert(0, (String) values.pop());
        }

        values.push(sb.toString());
    }

    @Override
    public String toString ()
    {
        return "function(cat)";
    }
}
