package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>FuncRound class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncRound extends Function
{

    /**
     * <p>Constructor for FuncRound.</p>
     */
    public FuncRound()
    {
        super();
    }

    /**
     * <p>Constructor for FuncRound.</p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncRound(final TokVariable var)
    {
        super(var);
    }

    /**
     * {@inheritDoc}
     *
     * The round function uses two operands. The second one is the number of
     * decimal places in which to round to.
     */
    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            final double multiplier = Math.pow(10, values.popDouble());
            values.push(new Double(Math.round(values.popDouble() * multiplier) / multiplier));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public String toString ()
    {
        return "function(round)";
    }
}
