package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncToString extends Function
{
    public FuncToString()
    {
        super();
    }

    public FuncToString(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        String format = null;
        if (getParameterCount() == 2)
            format = ((String) values.pop());

        Object op1 = values.pop();

        if (op1 instanceof String)
            values.push(op1);
        else if (op1 instanceof Double)
        {
            double op = ((Double) op1).doubleValue();
            if (format != null)
                values.push(String.format(format, op));
            else
                values.push(Double.toString(op));
        } else
        if (op1 instanceof Long)
        {
            long op = ((Long) op1).longValue();
            if (format != null)
                values.push(String.format(format, op));
            else
                values.push(Long.toString(op));
        }
        else
            values.push("");
    }

    @Override
    public String toString ()
    {
        return "function(toString)";
    }
}
