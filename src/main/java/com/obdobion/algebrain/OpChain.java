package com.obdobion.algebrain;

import java.text.ParseException;

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
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            return;
        try
        {
            final Object op2 = values.popWhatever();
            values.popWhatever();

            values.push(op2);
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "op(chain)";
    }
}
