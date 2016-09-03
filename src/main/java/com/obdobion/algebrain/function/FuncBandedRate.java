package com.obdobion.algebrain.function;

import java.text.ParseException;
import java.util.Enumeration;
import java.util.Hashtable;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.support.EquationSupport;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncBandedRate class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncBandedRate extends Function
{
    /**
     * <p>
     * Constructor for FuncBandedRate.
     * </p>
     */
    public FuncBandedRate()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncBandedRate.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncBandedRate(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
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

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "function(bandedrate)";
    }
}
