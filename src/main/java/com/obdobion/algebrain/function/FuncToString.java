package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>FuncToString class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncToString extends Function
{
    /**
     * <p>Constructor for FuncToString.</p>
     */
    public FuncToString()
    {
        super();
    }

    /**
     * <p>Constructor for FuncToString.</p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncToString(final TokVariable var)
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
            String format = null;
            if (getParameterCount() == 2)
                format = values.popString();

            final Object op1 = values.popWhatever();

            if (op1 instanceof String)
                values.push(op1);
            else if (op1 instanceof byte[])
                values.push(new String((byte[]) op1));
            else if (op1 instanceof Double)
            {
                final double op = ((Double) op1).doubleValue();
                if (format != null)
                    values.push(String.format(format, op));
                else
                    values.push(Double.toString(op));
            } else if (op1 instanceof Long)
            {
                final long op = ((Long) op1).longValue();
                if (format != null)
                    values.push(String.format(format, op));
                else
                    values.push(Long.toString(op));
            }
            else
                values.push("");
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
        return "function(toString)";
    }
}
