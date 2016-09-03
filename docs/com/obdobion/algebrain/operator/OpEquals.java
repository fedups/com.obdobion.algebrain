package com.obdobion.algebrain.operator;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpEquals class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
abstract public class OpEquals extends Operator
{
    /**
     * <p>
     * Constructor for OpEquals.
     * </p>
     */
    public OpEquals()
    {
        super();
    }

    /**
     * <p>
     * Constructor for OpEquals.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpEquals(final EquPart opTok)
    {
        super(opTok);
    }

    /** {@inheritDoc} */
    @Override
    protected int precedence()
    {
        return 999;
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() != 1)
            throw new Exception("Wrong number of operands " + toString());
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "op(assignment)";
    }
}
