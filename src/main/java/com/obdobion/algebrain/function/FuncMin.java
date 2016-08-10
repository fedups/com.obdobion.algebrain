package com.obdobion.algebrain.function;

import java.text.ParseException;
import java.util.Stack;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>FuncMin class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncMin extends Function
{
    /**
     * <p>Constructor for FuncMin.</p>
     */
    public FuncMin()
    {
        super();
    }

    /**
     * <p>Constructor for FuncMin.</p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncMin(final TokVariable var)
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
            final Stack<Double> ops = new Stack<>();

            for (int p = 0; p < getParameterCount(); p++)
                ops.push(new Double(values.popDouble()));

            Double op1;
            Double op2;
            op1 = ops.pop();

            while (!ops.empty())
            {
                op2 = ops.pop();
                op1 = new Double(Math.min(op1.doubleValue(), op2.doubleValue()));
            }
            values.push(op1);
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
        return "function(min-" + getParameterCount() + ")";
    }
}
