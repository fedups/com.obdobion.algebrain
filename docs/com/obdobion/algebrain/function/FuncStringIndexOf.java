package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncStringIndexOf class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncStringIndexOf extends Function
{
    /**
     * <p>
     * Constructor for FuncStringIndexOf.
     * </p>
     */
    public FuncStringIndexOf()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncStringIndexOf.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncStringIndexOf(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
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

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "function(indexOf)";
    }
}
