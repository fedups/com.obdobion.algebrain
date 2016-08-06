package com.obdobion.algebrain.function;

import java.text.ParseException;
import java.util.Stack;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * @author Chris DeGreef
 *
 */
public class FuncMax extends Function
{
    public FuncMax()
    {
        super();
    }

    public FuncMax(final TokVariable var)
    {
        super(var);
    }

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
                op1 = new Double(Math.max(op1.doubleValue(), op2.doubleValue()));
            }
            values.push(op1);
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(max-" + getParameterCount() + ")";
    }
}
