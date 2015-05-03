package com.obdobion.algebrain;

import java.util.Stack;

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
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        final Stack<Double> ops = new Stack<Double>();

        for (int p = 0; p < getParameterCount(); p++)
            ops.push(new Double(convertToDouble(values.pop())[0]));

        Double op1;
        Double op2;
        op1 = ops.pop();

        while (!ops.empty())
        {
            op2 = ops.pop();
            op1 = new Double(Math.max(op1.doubleValue(), op2.doubleValue()));
        }
        values.push(op1);
    }

    @Override
    public String toString ()
    {
        return "function(max-" + getParameterCount() + ")";
    }
}
