package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>FuncStringLTrim class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncStringLTrim extends Function
{
    /**
     * <p>Constructor for FuncStringLTrim.</p>
     */
    public FuncStringLTrim()
    {
        super();
    }

    /**
     * <p>Constructor for FuncStringLTrim.</p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncStringLTrim(final TokVariable var)
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
            final String target = values.popString();

            int i;
            for (i = 0; i < target.length() && Character.isWhitespace(target.charAt(i)); i++)
            {
                //
            }

            values.push(target.substring(i));
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
        return "function(ltrim)";
    }
}
