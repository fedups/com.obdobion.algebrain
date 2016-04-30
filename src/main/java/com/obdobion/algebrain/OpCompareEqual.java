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

    Object[] ensureSameTypes (Object o1, Object o2) throws Exception
    {
        Object[] sameTypes = new Object[2];

        if (o1.getClass() == o2.getClass())
        {
            sameTypes[0] = o1;
            sameTypes[1] = o2;
            return sameTypes;
        }

        if (o1 instanceof Double && o2 instanceof Long)
        {
            sameTypes[0] = o1;
            sameTypes[1] = new Double(((Long) o2).doubleValue());
            return sameTypes;
        }

        if (o1 instanceof Long && o2 instanceof Double)
        {
            sameTypes[0] = new Double(((Long) o1).doubleValue());
            sameTypes[1] = o2;
            return sameTypes;
        }

        throw new Exception("\"=\" supports same type comparisons only, found "
                + o2.getClass().getSimpleName()
                + " and "
                + o1.getClass().getSimpleName());
    }

    @Override
    public String toString ()
    {
        return "op(compare equal)";
    }
}
