package com.obdobion.algebrain.operator;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpCompareNotGreater class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpCompareNotGreater extends OpCompareGreater
{
    /**
     * <p>
     * Constructor for OpCompareNotGreater.
     * </p>
     */
    public OpCompareNotGreater()
    {}

    /**
     * <p>
     * Constructor for OpCompareNotGreater.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpCompareNotGreater(final EquPart opTok)
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
        return "op(compare not greater)";
    }
}
