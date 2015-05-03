package com.obdobion.algebrain;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncTieredRate extends Function
{
    public FuncTieredRate()
    {
        super();
    }

    public FuncTieredRate(final TokVariable var)
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

            if (baseAmount.doubleValue() == 0)
            {
                values.push(new Double(0D));
                return;
            }

            final EquationSupport model = getEqu().getSupport();

            final Hashtable<Double, Double> rateTable = model.resolveRate(tableName, getEqu().getBaseDate(), baseAmount
                    .doubleValue());
            double blendedRate = 0;
            double previousLimit = 0;
            double previousRate = 0;

            /*
             * only the last key in the table is used for tiered rates
             */
            for (final Enumeration<Double> limits = rateTable.keys(); limits.hasMoreElements();)
            {
                final Double limit = limits.nextElement();
                final Double rate = rateTable.get(limit);

                if (previousRate > 0)
                    blendedRate += (previousRate * ((limit.doubleValue() - previousLimit) / baseAmount.doubleValue()));

                previousRate = rate.doubleValue();
                previousLimit = limit.doubleValue();
            }

            if (previousRate > 0)
                blendedRate += (previousRate * ((baseAmount.doubleValue() - previousLimit) / baseAmount.doubleValue()));

            values.push(new Double(blendedRate));
        } catch (final ClassCastException e)
        {
            throw new Exception("invalid type for parameter in: " + toString());
        }
    }

    @Override
    public String toString ()
    {
        return "function(tieredrate)";
    }
}
