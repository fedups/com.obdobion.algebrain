package com.obdobion.algebrain;

import java.util.Calendar;
import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpCompareLess extends Operator
{
    public OpCompareLess()
    {
    }

    public OpCompareLess(final EquPart opTok)
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
        if (ops[0] instanceof Calendar)
        {
            values.push(new Boolean(((Calendar) ops[1]).compareTo((Calendar) ops[0]) < 0));
            return;
        }
        final double[] data = convertToDouble(ops[0], ops[1]);
        values.push(new Boolean(data[1] < data[0]));
    }

    @Override
    public String toString ()
    {
        return "op(compare less)";
    }
}
