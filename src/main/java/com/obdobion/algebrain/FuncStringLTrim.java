package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncStringLTrim extends Function
{
    public FuncStringLTrim()
    {
        super();
    }

    public FuncStringLTrim(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        String target = (String) values.pop();

        int i;
        for (i = 0; i < target.length() && Character.isWhitespace(target.charAt(i)); i++)
        {
            //
        }

        values.push(target.substring(i));
    }

    @Override
    public String toString ()
    {
        return "function(ltrim)";
    }
}
