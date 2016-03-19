package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class TokNumber extends TokOperand
{
    public TokNumber()
    {
        super();
    }

    @Override
    public boolean accepts (final char s)
    {
        return Character.isDigit(s) || s == '.';
    }

    @Override
    public EquPart morph () throws Exception
    {
        if (getValue().length() == 1 && getValue().charAt(0) == '-')
        {
            final EquPart part = Equ.getInstance().operator(this);
            if (part != null)
                return part;
        }
        return this;
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        values.push(new Double(getValue().toString()));
    }

    @Override
    public String toString ()
    {
        return "num(" + super.toString() + ")";
    }
}
