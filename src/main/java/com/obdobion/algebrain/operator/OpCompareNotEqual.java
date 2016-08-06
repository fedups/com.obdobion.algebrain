package com.obdobion.algebrain.operator;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.ValueStack;

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
    public void resolve (final ValueStack values) throws Exception
    {
        super.resolve(values);
        values.push(new Boolean(!values.popBoolean()));
        return;
    }

    @Override
    public String toString ()
    {
        return "op(compare not equal)";
    }
}
