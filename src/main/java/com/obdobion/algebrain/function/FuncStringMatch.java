package com.obdobion.algebrain.function;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * @author Chris DeGreef
 *
 */
public class FuncStringMatch extends Function
{
    private static void pushAppropriateType (final ValueStack values, final Object whoKnowsWhat, final String result)
        throws UnsupportedEncodingException
    {
        if (whoKnowsWhat instanceof String)
        {
            values.push(result);

        } else if (whoKnowsWhat instanceof byte[])
        {
            values.push((result.getBytes("ISO-8859-1")));
        }
    }

    public FuncStringMatch()
    {
        super();
    }

    public FuncStringMatch(final TokVariable var)
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
            String target;
            String pattern;
            boolean ignoreCase = false;
            if (getParameterCount() == 3)
                ignoreCase = values.popBoolean();
            pattern = values.popString();

            final Object whoKnowsWhat = values.popStringOrByteArray();
            if (whoKnowsWhat instanceof String)
            {
                target = (String) whoKnowsWhat;

            } else
            {
                target = ValueStack.byteArrayAsString(whoKnowsWhat);
            }

            final Matcher matcher = Pattern.compile(pattern, ignoreCase
                    ? Pattern.CASE_INSENSITIVE
                    : 0).matcher(target);

            if (matcher.find())
            {
                if (matcher.groupCount() > 0)
                    pushAppropriateType(values, whoKnowsWhat, matcher.group(1));
                else
                    pushAppropriateType(values, whoKnowsWhat, matcher.group());
            } else
                pushAppropriateType(values, whoKnowsWhat, "");

        } catch (final ParseException | UnsupportedEncodingException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    @Override
    public String toString ()
    {
        return "function(match-" + getParameterCount() + ")";
    }
}
