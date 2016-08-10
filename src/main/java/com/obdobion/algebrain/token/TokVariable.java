package com.obdobion.algebrain.token;

import com.obdobion.algebrain.Equ;
import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>TokVariable class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TokVariable extends TokOperand
{
    boolean assignedByEquation;

    /**
     * <p>Constructor for TokVariable.</p>
     */
    public TokVariable()
    {
        super();
        assignedByEquation = false;
    }

    /** {@inheritDoc} */
    @Override
    public boolean accepts (final char s)
    {
        return Character.isLetter(s) || Character.isDigit(s) || s == '_' || s == '.';
    }

    /**
     * <p>getName.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName ()
    {
        return super.toString();
    }

    /**
     * <p>isResetable.</p>
     *
     * @return a boolean.
     */
    public boolean isResetable ()
    {
        return assignedByEquation;
    }

    /** {@inheritDoc} */
    @Override
    public EquPart morph () throws Exception
    {
        final EquPart fun = Equ.getInstance().function(this);
        if (fun == null)
            return this;
        return fun;
    }

    /** {@inheritDoc} */
    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (getEqu().getSupport() == null)
            throw new Exception("variables require support");

        final Object obj = getEqu().getSupport().resolveVariable(
            getValue().toString().toLowerCase(),
            getEqu().getBaseDate());
        if (obj == null)
        {
            /*
             * The variable may not exist if it is the target of an assignment
             * operation. The variable will be created rather than resolved.
             * Further, variables are final.
             */
            values.push(this);
            assignedByEquation = true;
        } else
            values.push(obj);
    }

    /** {@inheritDoc} */
    @Override
    public String toString ()
    {
        return "var(" + super.toString() + ")";
    }
}
