package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncStringToFloat class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncStringToFloat extends Function
{
    /**
     * <p>
     * Constructor for FuncStringToFloat.
     * </p>
     */
    public FuncStringToFloat()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncStringToFloat.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncStringToFloat(final TokVariable var)
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
                    values.push(new Double(0));
                else
                    values.push(Double.parseDouble((String) value));
                return;

            } else if (value instanceof Long)
            {
                values.push(new Double((Long) value));
                return;
            } else if (value instanceof Double)
            {
                values.push(value);
                return;
            }
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
        return "function(toFloat)";
    }
}
