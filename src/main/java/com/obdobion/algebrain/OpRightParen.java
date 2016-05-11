package com.obdobion.algebrain;


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
    protected boolean includeInRpn ()
    {
        return false;
    }

    @Override
    public boolean multiplize (final EquPart rightSide)
    {
        return rightSide instanceof OpLeftParen || rightSide instanceof TokOperand || rightSide instanceof Function;
    }

    @Override
    protected int precedence ()
    {
        return 999;
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        throw new Exception("WHAT! " + toString());
    }

    @Override
    public String toString ()
    {
        return "op(closeparen)";
    }
}
