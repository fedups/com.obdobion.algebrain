package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncStringIndexOf extends Function
{
    public FuncStringIndexOf()
    {
        super();
    }

    public FuncStringIndexOf(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        char chr = ((String) values.pop()).charAt(0);
        String target = (String) values.pop();

        values.push(new Double((target.indexOf(chr))));
    }

    @Override
    public String toString ()
    {
        return "function(indexOf)";
    }
}
