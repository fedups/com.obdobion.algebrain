package com.obdobion.algebrain.function;

import java.text.ParseException;
import java.util.Formatter;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * @author Chris DeGreef
 *
 */
public class FuncAlpha extends Function
{
    public FuncAlpha()
    {
        super();
    }

    public FuncAlpha(final TokVariable var)
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
            final StringBuilder buf = new StringBuilder();
            try (final Formatter fmt = new Formatter(buf))
            {
                fmt.format("%d", new Object[]
                {
                    (int) values.popDouble()
                });
            }
            values.push(buf.toString());
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(alpha)";
    }
}
