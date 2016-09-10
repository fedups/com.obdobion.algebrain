package com.obdobion.algebrain.operator;

import java.text.ParseException;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpNegate class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 */
public class OpNegate extends Operator
{
    /**
     * <p>
     * Constructor for OpNegate.
     * </p>
     */
    public OpNegate()
    {
        super();
    }

    /**
     * <p>
     * Constructor for OpNegate.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpNegate(final EquPart opTok)
    {
        super(opTok);
    }

    /** {@inheritDoc} */
    @Override
    protected int precedence()
    {
        return 3;
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        try
        {
            final Object value = values.popWhatever();
            if (value instanceof Long)
                values.push(new Long(0L - (Long) value));
            else if (value instanceof Double)
                values.push(new Double(0.0 - (Double) value));
            else
                throw new Exception(toString() + "; invalid type: " + value.toString());
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
        return "op(negate)";
    }
}
