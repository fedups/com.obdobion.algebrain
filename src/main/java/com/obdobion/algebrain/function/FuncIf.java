package com.obdobion.algebrain.function;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncIf class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncIf extends Function
{
    /**
     * <p>
     * Constructor for FuncIf.
     * </p>
     */
    public FuncIf()
    {}

    /**
     * <p>
     * Constructor for FuncIf.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncIf(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
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

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "function(if)";
    }
}
