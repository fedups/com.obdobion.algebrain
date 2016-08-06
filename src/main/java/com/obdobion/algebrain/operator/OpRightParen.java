package com.obdobion.algebrain.operator;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokOperand;

/**
 * @author Chris DeGreef
 *
 */
public class OpRightParen extends Operator
{
    public OpRightParen()
    {
        super();
    }

    public OpRightParen(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    public boolean includeInRpn()
    {
        return false;
    }

    @Override
    public boolean multiplize(final EquPart rightSide)
    {
        return rightSide instanceof OpLeftParen || rightSide instanceof TokOperand || rightSide instanceof Function;
    }

    @Override
    protected int precedence()
    {
        return 999;
    }

    /**
     * @param values
     */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        throw new Exception("WHAT! " + toString());
    }

    @Override
    public String toString()
    {
        return "op(closeparen)";
    }
}
