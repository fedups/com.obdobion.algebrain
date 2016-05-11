package com.obdobion.algebrain;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Chris DeGreef
 *
 */
public class FuncStringMatch extends Function
{
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
            target = values.popString();

            final Matcher matcher = Pattern.compile(pattern, ignoreCase
                    ? Pattern.CASE_INSENSITIVE
                    : 0).matcher(target);
            if (matcher.find())
            {
                if (matcher.groupCount() > 0)
                    values.push(matcher.group(1));
                else
                    values.push(matcher.group());
            } else
                values.push("");
        } catch (final ParseException e)
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
