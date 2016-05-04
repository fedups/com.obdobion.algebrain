package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpCompareNotLess extends OpCompareLess
{
    public OpCompareNotLess()
    {
    }

    public OpCompareNotLess(final EquPart opTok)
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
        return "op(compare not less)";
    }
}
