package com.obdobion.algebrain;

/**
 * <p>
 * Abstract Operator class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 */
public abstract class Operator extends Operation
{
    /**
     * <p>
     * Constructor for Operator.
     * </p>
     */
    public Operator()
    {
        super();
    }

    /**
     * <p>
     * Constructor for Operator.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public Operator(final EquPart opTok)
    {
        super();
        setLevel(opTok.getLevel());
    }

    /**
     * {@inheritDoc}
     *
     * An operator followed by a minus sign is always a negate rather than a
     * subtraction
     */
    @Override
    public boolean negatize(final EquPart rightSide)
    {
        return true;
    }

    /** {@inheritDoc} */
    @Override
    protected int precedence()
    {
        return 999;
    }

}
