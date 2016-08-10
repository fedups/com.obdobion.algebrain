package com.obdobion.algebrain.function;

import java.text.ParseException;
import java.util.Arrays;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>FuncStringSubstr class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncStringSubstr extends Function
{
    /**
     * <p>Constructor for FuncStringSubstr.</p>
     */
    public FuncStringSubstr()
    {
        super();
    }

    /**
     * <p>Constructor for FuncStringSubstr.</p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncStringSubstr(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 3)
            throw new Exception("requires 3 parameters " + toString());
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());
        try
        {
            final Double length = values.popDouble();
            final Double offset = values.popDouble();
            final Object target = values.popStringOrByteArray();

            if (target instanceof String)
                values.push(((String) target).substring(
                    offset.intValue(), offset.intValue() + length.intValue()));
            else
                values.push(Arrays.copyOfRange((byte[]) target,
                    offset.intValue(), offset.intValue() + length.intValue()));

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
        return "function(substr)";
    }
}
