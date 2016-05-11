package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncStringIndexOf extends Function
{
    public FuncStringIndexOf()
    {
        super();
    }

    public FuncStringIndexOf(final TokVariable var)
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
            final char chr = values.popString().charAt(0);
            final String target = values.popString();

            values.push(new Double((target.indexOf(chr))));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(indexOf)";
    }
}
