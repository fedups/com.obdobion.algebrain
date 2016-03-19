package com.obdobion.algebrain;

import java.util.Formatter;
import java.util.Stack;

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
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());

        final double[] data = convertToDouble(values.pop());
        final StringBuilder buf = new StringBuilder();
        try (final Formatter fmt = new Formatter(buf))
        {
            fmt.format("%d", new Object[]
            {
                    (int) data[0]
            });
        }
        values.push(buf.toString());
    }

    @Override
    public String toString ()
    {
        return "function(alpha)";
    }
}
