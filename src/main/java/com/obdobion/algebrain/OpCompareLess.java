package com.obdobion.algebrain;

import java.text.ParseException;
import java.util.Calendar;

/**
 * @author Chris DeGreef
 *
 */
public class OpCompareLess extends Operator
{
    public OpCompareLess()
    {
    }

    public OpCompareLess(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected int precedence ()
    {
        return 8;
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            final Object[] ops = values.ensureSameTypes();
            if (ops[0] instanceof Calendar)
            {
                values.push(new Boolean(((Calendar) ops[1]).compareTo((Calendar) ops[0]) < 0));
                return;
            }
            if (ops[0] instanceof Double)
            {
                values.push(new Boolean((Double) ops[1] < (Double) ops[0]));
                return;
            }
            throw new Exception(toString() + "; invalid type, found " + ops[0].getClass().getSimpleName());
        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "op(compare less)";
    }
}
