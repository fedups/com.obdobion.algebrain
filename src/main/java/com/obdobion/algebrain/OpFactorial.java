package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpFactorial extends Operator
{
    public OpFactorial()
    {
        super();
    }

    public OpFactorial(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected int precedence ()
    {
        return 3;
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operand for " + toString());
        final double[] data = convertToDouble(values.pop());

        if (data[0] > 20)
            throw new Exception("numeric overflow for " + toString());

        if (data[0] < 0)
            throw new Exception("negative numbers not allowed for " + toString());

        long factorial = 1;
        for (int i = new Double(data[0]).intValue(); i > 1; i--)
            factorial *= i;

        values.push(new Double(factorial));
    }

    @Override
    public String toString ()
    {
        return "op(factorial)";
    }
}
