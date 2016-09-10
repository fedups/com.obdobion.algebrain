package com.obdobion.algebrain.operator;

import java.text.ParseException;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpChain class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpChain extends Operator
{
    /**
     * <p>
     * Constructor for OpChain.
     * </p>
     */
    public OpChain()
    {
        super();
    }

    /**
     * <p>
     * Constructor for OpChain.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpChain(final EquPart opTok)
    {
        super(opTok);
    }

    /** {@inheritDoc} */
    @Override
    public boolean includeInRpn()
    {
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * This is just to the left of a subtraction meaning that the minus sign is
     * the first thing in an equation. That makes it a negation.
     */
    @Override
    public boolean negatize(final EquPart rightSide)
    {
        return true;
    }

    /** {@inheritDoc} */
    @Override
    protected int precedence()
    {
        return 999;
    }

    /**
     * {@inheritDoc}
     *
     * This is an intermediate result. Its result is not directly returned.
     * Assign the value to a variable if you need access to it later.
     */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new ParseException("missing operand", 0);

        try
        {
            final Object rightSideResult = values.popWhatever();
            values.popWhatever();

            values.push(rightSideResult);
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "op(chain)";
    }
}
