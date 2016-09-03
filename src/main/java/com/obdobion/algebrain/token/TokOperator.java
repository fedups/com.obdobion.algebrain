package com.obdobion.algebrain.token;

import com.obdobion.algebrain.Equ;
import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * TokOperator class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TokOperator extends Token
{
    /**
     * <p>
     * Constructor for TokOperator.
     * </p>
     */
    public TokOperator()
    {
        super();
    }

    /** {@inheritDoc} */
    @Override
    public boolean accepts(final char s)
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
            case '~':
                return true;
            default:
                break;
        }
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public EquPart morph() throws Exception
    {
        final EquPart part = Equ.getInstance().operator(this);
        if (part == null)
            return this;
        return part;
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        throw new Exception("Unknown token encountered in equation: " + getValue().toString());
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "nonop(" + super.toString() + ")";
    }
}
