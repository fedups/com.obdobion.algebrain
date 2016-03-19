package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpCompareNotLess extends Operator
{
    public OpCompareNotLess()
    {
    }

    public OpCompareNotLess(final EquPart opTok)
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

        final double[] data = convertToDouble(values.pop(), values.pop());
        values.push(new Boolean(data[1] >= data[0]));
    }

    @Override
    public String toString ()
    {
        return "op(compare not less)";
    }
}
