package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class TokVariable extends TokOperand
{
    public TokVariable()
    {
        super();
    }

    @Override
    public boolean accepts (final char s)
    {
        return Character.isLetter(s) || Character.isDigit(s) || s == '_' || s == '.';
    }

    @Override
    public EquPart morph () throws Exception
    {
        final EquPart fun = Equ.getInstance().function(this);
        if (fun == null)
            return this;
        return fun;
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (getEqu().getSupport() == null)
            throw new Exception("variables require support");

        final Object obj = getEqu().getSupport().resolveVariable(
                getValue().toString().toLowerCase(),
                getEqu().getBaseDate());
        if (obj == null)
            /*
             * The variable may not exist if it is the target of an assignment
             * operation. The variable will be created rather than resolved.
             * Further, variables are final.
             */
            values.push(this);
        else
            values.push(obj);
    }

    @Override
    public String toString ()
    {
        return "var(" + super.toString() + ")";
    }
}
