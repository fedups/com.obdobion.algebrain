package com.obdobion.algebrain.operator;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpCompareNotEqual class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpCompareNotEqual extends OpCompareEqual
{
    /**
     * <p>
     * Constructor for OpCompareNotEqual.
     * </p>
     */
    public OpCompareNotEqual()
    {}

    /**
     * <p>
     * Constructor for OpCompareNotEqual.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpCompareNotEqual(final EquPart opTok)
    {
        super(opTok);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        super.resolve(values);
        values.push(new Boolean(!values.popBoolean()));
        return;
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "op(compare not equal)";
    }
}
