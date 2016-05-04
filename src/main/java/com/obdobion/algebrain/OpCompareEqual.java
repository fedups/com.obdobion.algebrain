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

        Object[] ops = ensureSameTypes(values.pop(), values.pop());
        values.push(new Boolean(ops[1].equals(ops[0])));

        return;
    }

    @Override
    public String toString ()
    {
        return "op(compare equal)";
    }
}
