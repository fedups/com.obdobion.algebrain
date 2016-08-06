package com.obdobion.algebrain.token;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.operator.OpLeftParen;

/**
 * @author Chris DeGreef
 *
 */
public abstract class TokOperand extends Token
{
    public TokOperand()
    {
        super();
    }

    @Override
    public boolean multiplize (final EquPart rightSide)
    {
        return (rightSide instanceof OpLeftParen || rightSide instanceof TokOperand || rightSide instanceof Function);
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        values.push(getValue());
    }
}
