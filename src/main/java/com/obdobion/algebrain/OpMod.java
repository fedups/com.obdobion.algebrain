package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpMod extends Operator
{
    public OpMod()
    {
        super();
    }

    public OpMod(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected int precedence ()
    {
        return 3;
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        final double[] data = convertToDouble(values.pop(), values.pop());
        values.push(new Double(data[1] % data[0]));
    }

    @Override
    public String toString ()
    {
        return "op(mod)";
    }
}
