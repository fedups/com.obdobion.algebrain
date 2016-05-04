package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpCompareNotEqual extends OpCompareEqual
{
    public OpCompareNotEqual()
    {
    }

    public OpCompareNotEqual(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        super.resolve(values);

        final Object op1 = values.pop();
        values.push(new Boolean(!(Boolean) op1));

        return;
    }

    @Override
    public String toString ()
    {
        return "op(compare not equal)";
    }
}
