package com.obdobion.algebrain.function;

import java.text.ParseException;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * @author Chris DeGreef
 *
 */
public class FuncStringEmpty extends Function
{
    public FuncStringEmpty()
    {
        super();
    }

    public FuncStringEmpty(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());
        try
        {
            boolean result;
            final Object whoKnowsWhat = values.popStringOrByteArray();
            if (whoKnowsWhat instanceof String)
            {
                final String target = (String) whoKnowsWhat;
                result = target.trim().length() == 0;

            } else
            {
                final byte[] target = (byte[]) whoKnowsWhat;
                result = target == null || target.length == 0;
            }

            values.push(new Boolean(result));

        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(empty)";
    }
}
