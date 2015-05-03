package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncFlatRate extends Function
{
    public FuncFlatRate()
    {
        super();
    }

    public FuncFlatRate(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        final Stack<Object> ops = new Stack<Object>();

        for (int p = 0; p < getParameterCount(); p++)
            ops.push(values.pop());

        try
        {
            final String tableName = (String) ops.pop();
            final String[] keys = new String[5];

            for (int a = 0; a < getParameterCount() - 1; a++)
                keys[a] = (String) ops.pop();

            final EquationSupport model = getEqu().getSupport();
            double rate = 0D;

            rate = model.resolveRate(tableName, getEqu().getBaseDate(), keys[0], keys[1], keys[2], keys[3], keys[4]);
            values.push(new Double(rate));
        } catch (final ClassCastException e)
        {
            e.printStackTrace();
            throw new Exception("invalid parameter type for: " + toString());
        }
    }

    @Override
    public String toString ()
    {
        return "function(flatrate)";
    }
}
