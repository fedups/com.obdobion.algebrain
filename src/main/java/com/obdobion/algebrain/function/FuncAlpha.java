package com.obdobion.algebrain.function;

import java.text.ParseException;
import java.util.Formatter;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncAlpha class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncAlpha extends Function
{
    /**
     * <p>
     * Constructor for FuncAlpha.
     * </p>
     */
    public FuncAlpha()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncAlpha.
     * </p>
     *
     * @param var
     *            a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncAlpha(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());

        try
        {
            final StringBuilder buf = new StringBuilder();
            try (final Formatter fmt = new Formatter(buf))
            {
                fmt.format("%d", new Object[] {
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

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "function(alpha)";
    }
}
