package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncLog10 extends Function
{
    public FuncLog10()
    {
        super();
    }

    public FuncLog10(final TokVariable var)
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
            values.push(new Double(Math.log10(values.popDouble())));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(log10)";
    }
}
