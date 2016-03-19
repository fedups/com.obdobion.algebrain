package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpNand extends Operator
{
    public OpNand()
    {
    }

    public OpNand(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected int precedence ()
    {
        return 9;
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        final boolean[] data = convertToBoolean(values.pop(), values.pop());
        values.push(new Boolean((data[1] && !data[0]) || (!data[1] && data[0])));
    }

    @Override
    public String toString ()
    {
        return "op(nand)";
    }
}
