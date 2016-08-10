package com.obdobion.algebrain.token;

import com.obdobion.algebrain.Equ;
import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>TokNumber class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TokNumber extends TokOperand
{
    /**
     * <p>Constructor for TokNumber.</p>
     */
    public TokNumber()
    {
        super();
    }

    /** {@inheritDoc} */
    @Override
    public boolean accepts (final char s)
    {
        return Character.isDigit(s) || s == '.';
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        values.push(new Double(getValue().toString()));
    }

    /** {@inheritDoc} */
    @Override
    public String toString ()
    {
        return "num(" + super.toString() + ")";
    }
}
