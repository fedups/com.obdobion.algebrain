package com.obdobion.algebrain;

import java.text.ParseException;

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
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            final double d0 = values.popDouble();
            final double d1 = values.popDouble();
            values.push(new Double(d1 % d0));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "op(mod)";
    }
}
