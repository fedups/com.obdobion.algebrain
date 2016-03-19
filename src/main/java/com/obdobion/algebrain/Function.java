package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public abstract class Function extends Operation
{
    private int parameterCount;

    public Function()
    {
        super();
    }

    public Function(final TokVariable var)
    {
        super();
        setLevel(var.getLevel());
    }

    public int getParameterCount ()
    {
        return parameterCount;
    }

    @Override
    protected int precedence ()
    {
        return 2;
    }

    public void setParameterCount (final int newParameterCount)
    {
        parameterCount = newParameterCount;
    }

    public void updateParameterCount (final EquPart[] equParts, final int myLocInArray)
    {
        setParameterCount(0);

        for (int p = myLocInArray + 1; p < equParts.length; p++)
        {
            final EquPart part = equParts[p];

            if (part.getLevel() < getLevel())
                break;

            if ((part.getLevel() == (getLevel() + 1)) && part instanceof OpComma)
                setParameterCount(getParameterCount() + 1);
        }

        if (getParameterCount() > 0)
            setParameterCount(getParameterCount() + 1);
    }
}
