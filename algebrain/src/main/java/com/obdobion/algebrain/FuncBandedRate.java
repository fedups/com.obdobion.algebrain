package com.obdobion.algebrain;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncBandedRate extends Function
{
    public FuncBandedRate()
    {
        super();
    }

    public FuncBandedRate(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());

        try
        {
            final String tableName = (String) values.pop();
            final Double baseAmount = (Double) values.pop();
            final EquationSupport model = getEqu().getSupport();

            final Hashtable<Double, Double> rateTable = model.resolveRate(tableName, getEqu().getBaseDate(), baseAmount
                    .doubleValue());
            double blendedRate = 0;

            /*
             * only the last key in the table is used for banded rates
             */
            for (final Enumeration<Double> limits = rateTable.keys(); limits.hasMoreElements();)
            {
                final Double limit = limits.nextElement();
                blendedRate = (rateTable.get(limit)).doubleValue();
            }

            values.push(new Double(blendedRate));
        } catch (final ClassCastException e)
        {
            throw new Exception("invalid type for parameter in: " + toString());
        }
    }

    @Override
    public String toString ()
    {
        return "function(bandedrate)";
    }
}
