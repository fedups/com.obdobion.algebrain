package com.obdobion.algebrain.function;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncAbs class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncAbs extends Function
{

    /**
     * <p>
     * Constructor for FuncAbs.
     * </p>
     */
    public FuncAbs()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncAbs.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncAbs(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        final double data = values.popDouble();
        values.push(new Double(Math.abs(data)));
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "function(abs)";
    }
}
