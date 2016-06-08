package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncStringToInt extends Function
{
    public FuncStringToInt()
    {
        super();
    }

    public FuncStringToInt(final TokVariable var)
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
            final Object value = values.popString();
            if (value instanceof String)
            {
                if (((String) value).trim().length() == 0)
                    values.push(new Long(0));
                else
                    values.push(Long.parseLong((String) value));
                return;
            }
            values.push(value);
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(toInt)";
    }
}