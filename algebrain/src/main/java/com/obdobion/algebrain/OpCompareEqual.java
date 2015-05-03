package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpCompareEqual extends Operator
{
    public OpCompareEqual()
    {
    }

    public OpCompareEqual(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected int precedence ()
    {
        return 8;
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());

        final Object op2 = values.pop();
        final Object op1 = values.pop();
        values.push(new Boolean(op1.equals(op2)));

        return;
    }

    @Override
    public String toString ()
    {
        return "op(compare equal)";
    }
}
