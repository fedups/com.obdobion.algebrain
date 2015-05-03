package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public abstract class TokOperand extends Token
{
    public TokOperand()
    {
        super();
    }

    @Override
    public boolean multiplize (final EquPart rightSide)
    {
        return (rightSide instanceof OpLeftParen || rightSide instanceof TokOperand || rightSide instanceof Function);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        values.push(getValue());
    }
}
