package com.obdobion.algebrain;

import java.text.ParseException;

/**
 * @author Chris DeGreef
 *
 */
public class FuncStringEmpty extends Function
{
    public FuncStringEmpty()
    {
        super();
    }

    public FuncStringEmpty(final TokVariable var)
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
            String target;
            target = values.popString();

            if (target == null || target.trim().length() == 0)
                values.push(new Boolean(true));
            else
                values.push(new Boolean(false));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(empty)";
    }
}
