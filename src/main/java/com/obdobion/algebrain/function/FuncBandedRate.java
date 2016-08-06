package com.obdobion.algebrain.function;

import java.text.ParseException;
import java.util.Enumeration;
import java.util.Hashtable;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.support.EquationSupport;
import com.obdobion.algebrain.token.TokVariable;

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
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());

        try
        {
            final String tableName = values.popString();
            final double baseAmount = values.popDouble();
            final EquationSupport model = getEqu().getSupport();

            final Hashtable<Double, Double> rateTable = model
                    .resolveRate(tableName, getEqu().getBaseDate(), baseAmount);
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
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(bandedrate)";
    }
}
