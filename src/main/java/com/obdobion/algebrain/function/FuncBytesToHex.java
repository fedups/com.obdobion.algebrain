package com.obdobion.algebrain.function;

import java.text.ParseException;

import org.apache.commons.codec.binary.Hex;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * FuncBytesToHex class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncBytesToHex extends Function
{
    /**
     * <p>
     * Constructor for FuncBytesToHex.
     * </p>
     */
    public FuncBytesToHex()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncBytesToHex.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncBytesToHex(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < getParameterCount())
            throw new Exception("missing operands for " + toString());
        try
        {
            values.push(Hex.encodeHexString(values.popByteArray()));

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
        return "function(toHex)";
    }
}
