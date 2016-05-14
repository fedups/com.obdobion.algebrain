package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncDegreesToRads extends Function
{
    public FuncDegreesToRads()
    {
        super();
    }

    public FuncDegreesToRads(final TokVariable var)
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
            final double degrees = values.popDouble();
            final double rads = degrees * (Math.PI / 180);
            values.push(new Double(rads));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(rad)";
    }
}
