package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 *
 */
public class FuncIf extends Function
{
    public FuncIf()
    {
    }

    public FuncIf(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 3)
            throw new Exception("missing operands for " + toString());

        final Object op3 = values.popWhatever();
        final Object op2 = values.popWhatever();
        final boolean op1 = values.popBoolean();

        values.push(op1
                ? op2
                : op3);
    }

    @Override
    public String toString ()
    {
        return "function(if)";
    }
}
