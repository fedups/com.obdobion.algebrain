package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>FuncStringEmpty class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncStringEmpty extends Function
{
    /**
     * <p>Constructor for FuncStringEmpty.</p>
     */
    public FuncStringEmpty()
    {
        super();
    }

    /**
     * <p>Constructor for FuncStringEmpty.</p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncStringEmpty(final TokVariable var)
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
            boolean result;
            final Object whoKnowsWhat = values.popStringOrByteArray();
            if (whoKnowsWhat instanceof String)
            {
                final String target = (String) whoKnowsWhat;
                result = target.trim().length() == 0;

            } else
            {
                final byte[] target = (byte[]) whoKnowsWhat;
                result = target == null || target.length == 0;
            }

            values.push(new Boolean(result));

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
        return "function(empty)";
    }
}
