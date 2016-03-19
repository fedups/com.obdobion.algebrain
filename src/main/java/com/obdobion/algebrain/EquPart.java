package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public abstract class EquPart extends Object
{
    private Equ equ;
    private int level;

    public EquPart()
    {
        super();
    }

    public Equ getEqu ()
    {
        return equ;
    }

    public int getLevel ()
    {
        return level;
    }

    /**
     * @param rightSide is not used
     * @return
     */
    public boolean multiplize (final EquPart rightSide)
    {
        return false;
    }

    public abstract void resolve (Stack<Object> values) throws Exception;

    public void setEqu (final Equ newEqu)
    {
        equ = newEqu;
    }

    public void setLevel (final int newLevel)
    {
        level = newLevel;
    }
}
