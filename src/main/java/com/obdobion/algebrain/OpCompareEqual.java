package com.obdobion.algebrain;

import java.text.ParseException;

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
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            final Object[] ops = values.ensureSameTypes();
            values.push(new Boolean(ops[1].equals(ops[0])));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }

        return;
    }

    @Override
    public String toString ()
    {
        return "op(compare equal)";
    }
}
