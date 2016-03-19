package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpChain extends Operator
{
    public OpChain()
    {
        super();
    }

    public OpChain(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected boolean includeInRpn ()
    {
        return true;
    }

    @Override
    protected int precedence ()
    {
        return 999;
    }

    /**
     * This is an intermediate result. Its result is not directly returned.
     * Assign the value to a variable if you need access to it later.
     */
    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 2)
            return;

        Object op2 = values.pop();
        values.pop();

        values.push(op2);
    }

    @Override
    public String toString ()
    {
        return "op(chain)";
    }
}
