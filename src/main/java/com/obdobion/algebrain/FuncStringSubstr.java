package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncStringSubstr extends Function
{
    public FuncStringSubstr()
    {
        super();
    }

    public FuncStringSubstr(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 3)
            throw new Exception("requires 3 parameters " + toString());
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());
        try
        {
            final Double length = values.popDouble();
            final Double offset = values.popDouble();
            final String target = values.popString();

            values.push(target.substring(offset.intValue(), offset.intValue() + length.intValue()));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(substr)";
    }
}
