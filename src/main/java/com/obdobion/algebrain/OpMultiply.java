package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class OpMultiply extends Operator
{
    public OpMultiply()
    {
        super();
    }

    public OpMultiply(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected int precedence ()
    {
        return 4;
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            values.push(new Double(values.popDouble() * values.popDouble()));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "op(multiply)";
    }
}
