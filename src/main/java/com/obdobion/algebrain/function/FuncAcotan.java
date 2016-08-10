package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>FuncAcotan class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncAcotan extends Function
{
    /**
     * <p>Constructor for FuncAcotan.</p>
     */
    public FuncAcotan()
    {
        super();
    }

    /**
     * <p>Constructor for FuncAcotan.</p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncAcotan(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        try
        {
            final double degrees = values.popDouble();
            final double rads = degrees * (Math.PI / 180);
            values.push(new Double(Math.PI / 2 - Math.atan(rads)));
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
        return "function(acotan)";
    }
}
