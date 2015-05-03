package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncIf extends Function
{
    public FuncIf()
    {
    }

    public FuncIf(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 3)
            throw new Exception("missing operands for " + toString());

        final Object op3 = values.pop();
        final Object op2 = values.pop();
        final boolean[] op1 = convertToBoolean(values.pop());

        values.push(op1[0]
                ? op2
                : op3);
    }

    @Override
    public String toString ()
    {
        return "function(if)";
    }
}
