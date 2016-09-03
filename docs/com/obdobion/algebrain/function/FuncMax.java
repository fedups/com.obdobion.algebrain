package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncMax class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncMax extends Function
{
    /**
     * <p>
     * Constructor for FuncMax.
     * </p>
     */
    public FuncMax()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncMax.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncMax(final TokVariable var)
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
            final Object[] value = values.ensureSameTypes(getParameterCount());
            if (value[0] instanceof Long)
            {
                long bestSoFar = (Long) value[0];
                for (int x = 1; x < value.length; x++)
                    bestSoFar = new Long(Math.max(bestSoFar, (Long) value[x]));
                values.push(new Long(bestSoFar));
            } else if (value[0] instanceof Double)
            {
                double bestSoFar = (Double) value[0];
                for (int x = 1; x < value.length; x++)
                    bestSoFar = new Double(Math.max(bestSoFar, (Double) value[x]));
                values.push(new Double(bestSoFar));
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
        return "function(max-" + getParameterCount() + ")";
    }
}
