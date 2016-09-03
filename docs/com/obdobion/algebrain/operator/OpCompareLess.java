package com.obdobion.algebrain.operator;

import java.text.ParseException;
import java.time.LocalDateTime;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpCompareLess class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpCompareLess extends Operator
{
    /**
     * <p>
     * Constructor for OpCompareLess.
     * </p>
     */
    public OpCompareLess()
    {}

    /**
     * <p>
     * Constructor for OpCompareLess.
     * </p>
     *
     * @param opTok
     *            a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpCompareLess(final EquPart opTok)
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
            if (ops[0] instanceof LocalDateTime)
            {
                values.push(new Boolean(((LocalDateTime) ops[1]).compareTo((LocalDateTime) ops[0]) < 0));
                return;
            }
            if (ops[0] instanceof Double)
            {
                values.push(new Boolean((Double) ops[1] < (Double) ops[0]));
                return;
            }
            if (ops[0] instanceof Long)
            {
                values.push(new Boolean((Long) ops[1] < (Long) ops[0]));
                return;
            }
            throw new Exception(toString() + "; invalid type, found " + ops[0].getClass().getSimpleName());
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
        return "op(compare less)";
    }
}
