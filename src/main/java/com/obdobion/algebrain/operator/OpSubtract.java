package com.obdobion.algebrain.operator;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpSubtract class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpSubtract extends Operator
{
    /**
     * <p>
     * Constructor for OpSubtract.
     * </p>
     */
    public OpSubtract()
    {
        super();
    }

    /**
     * <p>
     * Constructor for OpSubtract.
     * </p>
     *
     * @param opTok
     *            a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpSubtract(final EquPart opTok)
    {
        super(opTok);
    }

    /** {@inheritDoc} */
    @Override
    protected int precedence()
    {
        return 6;
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            final Object[] value = values.ensureSameTypes();
            if (value[0] instanceof LocalDateTime)
            {
                final LocalDateTime ldt0 = (LocalDateTime) value[0];
                final LocalDateTime ldt1 = (LocalDateTime) value[1];
                values.push(new Long(ChronoUnit.DAYS.between(ldt0, ldt1)));

            } else if (value[0] instanceof Long)
                values.push(new Long((Long) value[1] - (Long) value[0]));
            else
                values.push(new Double((Double) value[1] - (Double) value[0]));
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
        return "op(subtract)";
    }
}
