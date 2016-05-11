package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class OpOr extends Operator
{
    public OpOr()
    {
    }

    public OpOr(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected int precedence ()
    {
        return 9;
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            final boolean b0 = values.popBoolean();
            final boolean b1 = values.popBoolean();
            values.push(new Boolean(b1 || b0));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "op(or)";
    }
}
