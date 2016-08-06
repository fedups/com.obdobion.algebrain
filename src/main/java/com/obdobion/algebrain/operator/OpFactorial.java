package com.obdobion.algebrain.operator;

import java.text.ParseException;

import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;

/**
 * @author Chris DeGreef
 *
 */
public class OpFactorial extends Operator
{
    public OpFactorial()
    {
        super();
    }

    public OpFactorial(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected int precedence ()
    {
        return 3;
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operand for " + toString());
        try
        {
            final double base = values.popDouble();

            if (base > 20)
                throw new Exception(toString() + "; " + "numeric overflow");

            if (base < 0)
                throw new Exception(toString() + "; " + "negative numbers not allowed");

            long factorial = 1;
            for (int i = new Double(base).intValue(); i > 1; i--)
                factorial *= i;

            values.push(new Double(factorial));
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "op(factorial)";
    }
}
