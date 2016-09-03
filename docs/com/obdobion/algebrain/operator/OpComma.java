package com.obdobion.algebrain.operator;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpComma class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpComma extends Operator
{
    /**
     * <p>
     * Constructor for OpComma.
     * </p>
     */
    public OpComma()
    {
        super();
    }

    /**
     * <p>
     * Constructor for OpComma.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpComma(final EquPart opTok)
    {
        super(opTok);
    }

    /** {@inheritDoc} */
    @Override
    public boolean includeInRpn()
    {
        return false;
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
        throw new Exception("WHAT! " + toString());
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "op(comma)";
    }
}
