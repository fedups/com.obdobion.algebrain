package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncTrunc extends Function
{

    public FuncTrunc()
    {
        super();
    }

    public FuncTrunc(final TokVariable var)
    {
        super(var);
    }

    /**
     * The trunc function uses one operands.
     */
    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        try
        {
            values.push(new Double(Math.floor(values.popDouble())));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(round)";
    }
}
