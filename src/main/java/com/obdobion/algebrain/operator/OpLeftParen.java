package com.obdobion.algebrain.operator;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

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
    public boolean includeInRpn()
    {
        return false;
    }

    @Override
    protected int precedence()
    {
        return 1;
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
        return "op(openparen)";
    }
}
