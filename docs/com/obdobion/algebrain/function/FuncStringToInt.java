package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncStringToInt class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncStringToInt extends Function
{
    /**
     * <p>
     * Constructor for FuncStringToInt.
     * </p>
     */
    public FuncStringToInt()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncStringToInt.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncStringToInt(final TokVariable var)
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
            final Object value = values.popWhatever();
            if (value instanceof String)
            {
                if (((String) value).trim().length() == 0)
                    values.push(new Long(0));
                else
                    values.push(Long.parseLong((String) value));
                return;

            } else if (value instanceof Double)
            {
                values.push(new Long(((Double) value).longValue()));
                return;

            } else if (value instanceof Long)
            {
                values.push(value);
                return;
            }
            values.push(value);
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
        return "function(toInt)";
    }
}
