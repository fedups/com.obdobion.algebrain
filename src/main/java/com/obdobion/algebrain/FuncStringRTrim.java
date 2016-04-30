package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncStringRTrim extends Function
{
    public FuncStringRTrim()
    {
        super();
    }

    public FuncStringRTrim(final TokVariable var)
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
        for (i = target.length() - 1; i >= 0 && Character.isWhitespace(target.charAt(i)); i--)
        {
            //
        }

        values.push(target.substring(0, i + 1));
    }

    @Override
    public String toString ()
    {
        return "function(rtrim)";
    }
}
