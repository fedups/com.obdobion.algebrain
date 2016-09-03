package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncRoot class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncRoot extends Function
{
    /**
     * <p>
     * Constructor for FuncRoot.
     * </p>
     */
    public FuncRoot()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncRoot.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncRoot(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            final double d0 = values.popDouble();
            final double d1 = values.popDouble();
            values.push(new Double(Math.pow(10, Math.log10(d1) / d0)));
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
        return "function(root)";
    }
}
