package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class TokOperator extends Token
{
    public TokOperator()
    {
        super();
    }

    @Override
    public boolean accepts (final char s)
    {
        /*
         * possible second characters in a double (or more) character symbol
         */
        switch (s)
        {
            case '=':
                return true;
            case '&':
                return true;
            case '|':
            return true;
        }
        return false;
    }

    @Override
    public EquPart morph () throws Exception
    {
        final EquPart part = Equ.getInstance().operator(this);
        if (part == null)
            return this;
        return part;
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        throw new Exception("Unknown token encountered in equation: " + getValue().toString());
    }

    @Override
    public String toString ()
    {
        return "nonop(" + super.toString() + ")";
    }
}
