package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncStringLength extends Function
{
    public FuncStringLength()
    {
        super();
    }

    public FuncStringLength(final TokVariable var)
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
            values.push(new Double(values.popString().length()));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(length)";
    }
}
