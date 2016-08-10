package com.obdobion.algebrain;

/**
 * <p>Abstract Operation class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 */
public abstract class Operation extends EquPart
{
    /**
     * <p>Constructor for Operation.</p>
     */
    public Operation()
    {
        super();
    }

    /**
     * <p>convertToBoolean.</p>
     *
     * @param fromStack a {@link java.lang.Object} object.
     * @return an array of boolean.
     * @throws java.lang.Exception if any.
     */
    @Deprecated
    protected boolean[] convertToBoolean(final Object... fromStack) throws Exception
    {
        final boolean[] converted = new boolean[fromStack.length];
        for (int c = 0; c < fromStack.length; c++)
        {
            final Object data = fromStack[c];

            if (data instanceof Number)
            {
                /*
                 * 0 is the only number that is false, all others are true.
                 */
                converted[c] = ((Number) data).intValue() != 0;
                continue;
            }
            if (data instanceof String)
            {
                converted[c] = Boolean.parseBoolean((String) data);
                continue;
            }
            if (data instanceof Boolean)
            {
                converted[c] = (Boolean) data;
                continue;
            }

            final StringBuilder errMsg = new StringBuilder();
            errMsg.append("invalid type for ");
            errMsg.append(toString());
            errMsg.append("; ");
            for (int e = 0; e < fromStack.length; e++)
            {
                errMsg.append(fromStack[e].getClass().getSimpleName());
                errMsg.append(" ");
            }
            throw new Exception(errMsg.toString());
        }
        return converted;
    }

    /**
     * <p>convertToDouble.</p>
     *
     * @param fromStack a {@link java.lang.Object} object.
     * @return an array of double.
     * @throws java.lang.Exception if any.
     */
    @Deprecated
    protected double[] convertToDouble(final Object... fromStack) throws Exception
    {
        final double[] converted = new double[fromStack.length];
        for (int c = 0; c < fromStack.length; c++)
        {
            final Object data = fromStack[c];

            if (data instanceof Number)
            {
                converted[c] = ((Number) data).doubleValue();
                continue;
            }
            if (data instanceof String)
            {
                converted[c] = Double.parseDouble((String) data);
                continue;
            }

            final StringBuilder errMsg = new StringBuilder();
            errMsg.append("invalid type for ");
            errMsg.append(toString());
            errMsg.append("; ");
            for (int e = 0; e < fromStack.length; e++)
            {
                errMsg.append(fromStack[e].getClass().getSimpleName());
                errMsg.append(" ");
            }
            throw new Exception(errMsg.toString());
        }
        return converted;
    }

    /**
     * <p>includeInRpn.</p>
     *
     * @return a boolean.
     */
    public boolean includeInRpn()
    {
        return true;
    }

    /**
     * <p>precedence.</p>
     *
     * @return a int.
     */
    protected abstract int precedence();

    /**
     * <p>preceeds.</p>
     *
     * @param rightOp a {@link com.obdobion.algebrain.Operation} object.
     * @return a boolean.
     */
    public boolean preceeds(final Operation rightOp)
    {
        if (getLevel() > rightOp.getLevel())
            return true;

        if (getLevel() < rightOp.getLevel())
            return false;

        if (precedence() <= rightOp.precedence())
            return true;

        return false;
    }
}
