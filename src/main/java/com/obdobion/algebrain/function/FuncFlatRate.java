package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.support.EquationSupport;
import com.obdobion.algebrain.token.TokVariable;

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
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());

        try
        {
            final String tableName = values.popString();
            final String[] keys = new String[5];
            for (int a = 0; a < getParameterCount() - 1; a++)
                keys[a] = values.popString();

            final EquationSupport model = getEqu().getSupport();
            double rate = 0D;

            rate = model.resolveRate(tableName, getEqu().getBaseDate(), keys[0], keys[1], keys[2], keys[3], keys[4]);
            values.push(new Double(rate));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(flatrate)";
    }
}
