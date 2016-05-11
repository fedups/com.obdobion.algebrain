package com.obdobion.algebrain;


/**
 * @author Chris DeGreef
 *
 */
public class OpLeftParen extends Operator
{
    public OpLeftParen()
    {
        super();
    }

    public OpLeftParen(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected boolean includeInRpn ()
    {
        return false;
    }

    @Override
    protected int precedence ()
    {
        return 1;
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        throw new Exception("WHAT! " + toString());
    }

    @Override
    public String toString ()
    {
        return "op(openparen)";
    }
}
