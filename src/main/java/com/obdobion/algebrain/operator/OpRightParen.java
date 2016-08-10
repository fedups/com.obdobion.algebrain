package com.obdobion.algebrain.operator;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokOperand;

/**
 * <p>OpRightParen class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpRightParen extends Operator
{
    /**
     * <p>Constructor for OpRightParen.</p>
     */
    public OpRightParen()
    {
        super();
    }

    /**
     * <p>Constructor for OpRightParen.</p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpRightParen(final EquPart opTok)
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
    public boolean multiplize(final EquPart rightSide)
    {
        return rightSide instanceof OpLeftParen || rightSide instanceof TokOperand || rightSide instanceof Function;
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
        return "op(closeparen)";
    }
}
