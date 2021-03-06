package com.obdobion.algebrain.function;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncStringReplace class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncStringReplace extends Function
{
    private static void pushAppropriateType(final ValueStack values, final Object whoKnowsWhat, final String result)
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

    /**
     * <p>
     * Constructor for FuncStringReplace.
     * </p>
     */
    public FuncStringReplace()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncStringReplace.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncStringReplace(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());
        if (getParameterCount() != 3)
            throw new Exception("missing operands for " + toString());
        try
        {
            String target;
            String pattern;
            final String replacement = values.popString();
            pattern = values.popString();

            final Object whoKnowsWhat = values.popStringOrByteArray();
            if (whoKnowsWhat instanceof String)
            {
                target = (String) whoKnowsWhat;

            } else
            {
                target = ValueStack.byteArrayAsString(whoKnowsWhat);
            }

            final Matcher matcher = Pattern.compile(pattern).matcher(target);
            pushAppropriateType(values, whoKnowsWhat, matcher.replaceAll(replacement));

        } catch (final ParseException | UnsupportedEncodingException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "function(replace)";
    }
}
