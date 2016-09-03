package com.obdobion.algebrain;

import com.obdobion.algebrain.operator.OpComma;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * Abstract Function class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 */
public abstract class Function extends Operation
{
    private int parameterCount;

    /**
     * <p>
     * Constructor for Function.
     * </p>
     */
    public Function()
    {
        super();
    }

    /**
     * <p>
     * Constructor for Function.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public Function(final TokVariable var)
    {
        super();
        setLevel(var.getLevel());
    }

    /**
     * <p>
     * Getter for the field <code>parameterCount</code>.
     * </p>
     *
     * @return a int.
     */
    public int getParameterCount()
    {
        return parameterCount;
    }

    /** {@inheritDoc} */
    @Override
    protected int precedence()
    {
        return 2;
    }

    /**
     * <p>
     * Setter for the field <code>parameterCount</code>.
     * </p>
     *
     * @param newParameterCount a int.
     */
    public void setParameterCount(final int newParameterCount)
    {
        parameterCount = newParameterCount;
    }

    /**
     * <p>
     * updateParameterCount.
     * </p>
     *
     * @param equParts an array of {@link com.obdobion.algebrain.EquPart}
     *            objects.
     * @param myLocInArray a int.
     */
    public void updateParameterCount(final EquPart[] equParts, final int myLocInArray)
    {
        setParameterCount(0);

        for (int p = myLocInArray + 1; p < equParts.length; p++)
        {
            final EquPart part = equParts[p];

            if (part.getLevel() <= getLevel())
                break;

            if ((part.getLevel() == (getLevel() + 1)) && part instanceof OpComma)
                setParameterCount(getParameterCount() + 1);
        }

        if (getParameterCount() > 0)
            setParameterCount(getParameterCount() + 1);
    }
}
