package com.obdobion.algebrain.operator;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpLeftParen class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpLeftParen extends Operator
{
    /**
     * <p>
     * Constructor for OpLeftParen.
     * </p>
     */
    public OpLeftParen()
    {
        super();
    }

    /**
     * <p>
     * Constructor for OpLeftParen.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpLeftParen(final EquPart opTok)
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
        return 1;
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
        return "op(openparen)";
    }
}
