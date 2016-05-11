package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncStringRTrim extends Function
{
    public FuncStringRTrim()
    {
        super();
    }

    public FuncStringRTrim(final TokVariable var)
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

            int i;
            for (i = target.length() - 1; i >= 0 && Character.isWhitespace(target.charAt(i)); i--)
            {
                //
            }

            values.push(target.substring(0, i + 1));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(rtrim)";
    }
}
