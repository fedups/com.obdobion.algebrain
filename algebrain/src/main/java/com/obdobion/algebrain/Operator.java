package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public abstract class Operator extends Operation
{
    public Operator()
    {
        super();
    }

    public Operator(final EquPart opTok)
    {
        super();
        setLevel(opTok.getLevel());
    }

    @Override
    protected int precedence ()
    {
        return 999;
    }
}
