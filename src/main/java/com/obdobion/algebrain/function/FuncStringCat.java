package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>FuncStringCat class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncStringCat extends Function
{
    /**
     * <p>Constructor for FuncStringCat.</p>
     */
    public FuncStringCat()
    {
        super();
    }

    /**
     * <p>Constructor for FuncStringCat.</p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncStringCat(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        try
        {
            final StringBuilder sb = new StringBuilder();
            for (int p = 0; p < getParameterCount(); p++)
            {
                sb.insert(0, values.popString());
            }

            values.push(sb.toString());
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
        return "function(cat)";
    }
}
