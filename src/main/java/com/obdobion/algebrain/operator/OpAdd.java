package com.obdobion.algebrain.operator;

import java.text.ParseException;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpAdd class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpAdd extends Operator
{
    /**
     * <p>
     * Constructor for OpAdd.
     * </p>
     */
    public OpAdd()
    {
        super();
    }

    /**
     * <p>
     * Constructor for OpAdd.
     * </p>
     *
     * @param opTok
     *            a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpAdd(final EquPart opTok)
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
            if (value[0] instanceof Long)
                values.push(new Long((Long) value[1] + (Long) value[0]));
            else
                values.push(new Double((Double) value[1] + (Double) value[0]));
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
        return "op(add)";
    }
}
