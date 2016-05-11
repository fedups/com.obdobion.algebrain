package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncStringTrim extends Function
{
    public FuncStringTrim()
    {
        super();
    }

    public FuncStringTrim(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());
        try
        {
            final String target = values.popString();

            values.push(target.trim());
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(trim)";
    }
}
