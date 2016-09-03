package com.obdobion.algebrain.operator;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpCompareNotLess class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpCompareNotLess extends OpCompareLess
{
    /**
     * <p>
     * Constructor for OpCompareNotLess.
     * </p>
     */
    public OpCompareNotLess()
    {}

    /**
     * <p>
     * Constructor for OpCompareNotLess.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpCompareNotLess(final EquPart opTok)
    {
        super(opTok);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        super.resolve(values);
        values.push(new Boolean(!values.popBoolean()));
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "op(compare not less)";
    }
}
