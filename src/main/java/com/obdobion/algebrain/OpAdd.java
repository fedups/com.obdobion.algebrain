package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class OpAdd extends Operator
{
    public OpAdd()
    {
        super();
    }

    public OpAdd(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected int precedence ()
    {
        return 6;
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            values.push(new Double(values.popDouble() + values.popDouble()));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "op(add)";
    }
}
