package com.obdobion.algebrain.function;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * @author Chris DeGreef
 *
 */
public class FuncAbs extends Function
{

    public FuncAbs()
    {
        super();
    }

    public FuncAbs(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        final double data = values.popDouble();
        values.push(new Double(Math.abs(data)));
    }

    @Override
    public String toString ()
    {
        return "function(abs)";
    }
}
