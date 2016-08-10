package com.obdobion.algebrain.operator;

import java.text.ParseException;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>OpDivide class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpDivide extends Operator
{
    /**
     * <p>Constructor for OpDivide.</p>
     */
    public OpDivide()
    {
        super();
    }

    /**
     * <p>Constructor for OpDivide.</p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpDivide(final EquPart opTok)
    {
        super(opTok);
    }

    /** {@inheritDoc} */
    @Override
    protected int precedence ()
    {
        return 4;
    }

    /** {@inheritDoc} */
    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            final double d0 = values.popDouble();
            final double d1 = values.popDouble();
            values.push(new Double(d1 / d0));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public String toString ()
    {
        return "op(divide)";
    }
}
