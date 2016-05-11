package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncRadsToDegrees extends Function
{
    public FuncRadsToDegrees()
    {
        super();
    }

    public FuncRadsToDegrees(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        try
        {
            final double rads = values.popDouble();
            final double degrees = rads * (180 / Math.PI);
            values.push(new Double(degrees));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(sin)";
    }
}
