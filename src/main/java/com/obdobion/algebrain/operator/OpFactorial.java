package com.obdobion.algebrain.operator;

import java.text.ParseException;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * OpFactorial class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpFactorial extends Operator
{
    /**
     * <p>
     * Constructor for OpFactorial.
     * </p>
     */
    public OpFactorial()
    {
        super();
    }

    /**
     * <p>
     * Constructor for OpFactorial.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpFactorial(final EquPart opTok)
    {
        super(opTok);
    }

    /**
     * <p>
     * multiplize.
     * </p>
     *
     * @param rightSide is not used
     * @return a boolean.
     */
    @Override
    public boolean multiplize(final EquPart rightSide)
    {
        return !(rightSide instanceof Operator);
    }

    /**
     * factorial followed by a minus sign is always subtraction.
     *
     * @param rightSide is not used
     * @return a boolean.
     */
    @Override
    public boolean negatize(final EquPart rightSide)
    {
        return false;
    }

    /** {@inheritDoc} */
    @Override
    protected int precedence()
    {
        return 3;
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operand for " + toString());
        try
        {
            final long base = values.popLong();

            if (base > 20)
                throw new Exception(toString() + "; " + "numeric overflow");

            if (base < 0)
                throw new Exception(toString() + "; " + "negative numbers not allowed");

            long factorial = 1;
            for (int i = (int) base; i > 1; i--)
                factorial *= i;

            values.push(new Long(factorial));
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
        return "op(factorial)";
    }
}
