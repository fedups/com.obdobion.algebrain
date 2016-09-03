package com.obdobion.algebrain.token;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.operator.OpLeftParen;

/**
 * <p>
 * Abstract TokOperand class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public abstract class TokOperand extends Token
{
    /**
     * <p>
     * Constructor for TokOperand.
     * </p>
     */
    public TokOperand()
    {
        super();
    }

    /** {@inheritDoc} */
    @Override
    public boolean multiplize(final EquPart rightSide)
    {
        return (rightSide instanceof OpLeftParen || rightSide instanceof TokOperand || rightSide instanceof Function);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        values.push(getValue());
    }
}
