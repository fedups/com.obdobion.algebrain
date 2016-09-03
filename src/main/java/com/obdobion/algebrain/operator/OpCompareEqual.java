package com.obdobion.algebrain.operator;

import java.text.ParseException;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpCompareEqual class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpCompareEqual extends Operator
{
    /**
     * <p>
     * Constructor for OpCompareEqual.
     * </p>
     */
    public OpCompareEqual()
    {}

    /**
     * <p>
     * Constructor for OpCompareEqual.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpCompareEqual(final EquPart opTok)
    {
        super(opTok);
    }

    /** {@inheritDoc} */
    @Override
    protected int precedence()
    {
        return 8;
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            final Object[] ops = values.ensureSameTypes();
            values.push(new Boolean(ops[1].equals(ops[0])));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }

        return;
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "op(compare equal)";
    }
}
