package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpCompareNotGreater extends OpCompareGreater
{
    public OpCompareNotGreater()
    {
    }

    public OpCompareNotGreater(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        super.resolve(values);
        final Object op1 = values.pop();
        values.push(new Boolean(!(Boolean) op1));
    }

    @Override
    public String toString ()
    {
        return "op(compare not greater)";
    }
}
