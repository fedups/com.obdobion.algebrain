package com.obdobion.algebrain;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Stack;

import com.obdobion.algebrain.token.TokVariable;
import com.obdobion.calendar.CalendarFactory;

/**
 * <p>
 * ValueStack class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 */
public class ValueStack extends Stack<Object>
{
    /**
     * <p>
     * byteArrayAsString.
     * </p>
     *
     * @param bytearray a {@link java.lang.Object} object.
     * @return a {@link java.lang.String} object.
     * @throws java.text.ParseException if any.
     */
    public static String byteArrayAsString(final Object bytearray) throws ParseException
    {
        try
        {
            return new String((byte[]) bytearray, "ISO-8859-1");

        } catch (final UnsupportedEncodingException e)
        {
            throw new ParseException("Literal required, " + e.getMessage(), 0);
        }

    }

    /**
     * <p>
     * convertToBoolean.
     * </p>
     *
     * @param fromStack a {@link java.lang.Object} object.
     * @return a boolean.
     * @throws java.text.ParseException if any.
     */
    protected boolean convertToBoolean(final Object fromStack) throws ParseException
    {
        if (fromStack instanceof Number)
            /*
             * 0 is the only number that is false, all others are true.
             */
            return ((Number) fromStack).intValue() != 0;
        if (fromStack instanceof String)
            return Boolean.parseBoolean((String) fromStack);
        if (fromStack instanceof Boolean)
            return (Boolean) fromStack;

        final StringBuilder errMsg = new StringBuilder();
        errMsg.append("invalid type ");
        errMsg.append(fromStack.getClass().getSimpleName());
        throw new ParseException(errMsg.toString(), 0);
    }

    /**
     * <p>
     * convertToDouble.
     * </p>
     *
     * @param fromStack a {@link java.lang.Object} object.
     * @return a double.
     * @throws java.text.ParseException if any.
     */
    protected double convertToDouble(final Object fromStack) throws ParseException
    {
        if (fromStack instanceof Number)
            return ((Number) fromStack).doubleValue();
        if (fromStack instanceof String)
            return Double.parseDouble((String) fromStack);
        if (fromStack instanceof LocalDateTime)
            return CalendarFactory.asDateLong((LocalDateTime) fromStack);

        final StringBuilder errMsg = new StringBuilder();
        errMsg.append("invalid type ");
        errMsg.append(fromStack.getClass().getSimpleName());
        throw new ParseException(errMsg.toString(), 0);
    }

    /**
     * <p>
     * convertToDouble.
     * </p>
     *
     * @param fromStack a {@link java.lang.Object} object.
     * @return a double.
     * @throws java.text.ParseException if any.
     */
    protected long convertToLong(final Object fromStack) throws ParseException
    {
        if (fromStack instanceof Number)
            return ((Number) fromStack).longValue();
        if (fromStack instanceof String)
            return Long.parseLong((String) fromStack);
        if (fromStack instanceof LocalDateTime)
            return CalendarFactory.asDateLong((LocalDateTime) fromStack);

        final StringBuilder errMsg = new StringBuilder();
        errMsg.append("invalid type ");
        errMsg.append(fromStack.getClass().getSimpleName());
        throw new ParseException(errMsg.toString(), 0);
    }

    /**
     * <p>
     * ensureSameTypes.
     * </p>
     *
     * @return an array of {@link java.lang.Object} objects.
     * @throws java.text.ParseException if any.
     */
    public Object[] ensureSameTypes() throws ParseException
    {
        return ensureSameTypes(2);
    }

    /**
     * <p>
     * ensureSameTypes.
     * </p>
     *
     * @return an array of {@link java.lang.Object} objects.
     * @throws java.text.ParseException if any.
     * @param count a int.
     */
    public Object[] ensureSameTypes(final int count) throws ParseException
    {
        boolean foundLong = false;
        boolean foundDouble = false;
        boolean foundAllSame = true;

        Object firstFound = null;
        final Stack<Object> ops = new Stack<>();
        for (int p = 0; p < count; p++)
        {
            final Object currentFound = popWhatever();

            if (currentFound instanceof TokVariable)
                throw new ParseException(
                        "\"" + ((TokVariable) currentFound).getName() + "\" is unassigned", 0);

            ops.push(currentFound);
            if (firstFound == null)
                firstFound = currentFound;
            if (!firstFound.getClass().equals(currentFound.getClass()))
                foundAllSame = false;
            if (currentFound instanceof Long)
                foundLong = true;
            else if (currentFound instanceof Double)
                foundDouble = true;
        }
        final Object[] found = new Object[ops.size()];
        for (int x = ops.size() - 1; x >= 0; x--)
        {
            final Object oneFound = ops.pop();
            if (foundAllSame)
                found[x] = oneFound;
            else if (foundDouble)
                found[x] = convertToDouble(oneFound);
            else if (foundLong)
                found[x] = convertToLong(oneFound);
            else
                throw new ParseException("invalid type: " + oneFound.getClass().getSimpleName(), 0);
        }
        return found;
    }

    /** {@inheritDoc} */
    @Override
    @Deprecated
    public synchronized Object pop()
    {
        return super.pop();
    }

    /**
     * <p>
     * popBoolean.
     * </p>
     *
     * @return a boolean.
     * @throws java.text.ParseException if any.
     */
    public boolean popBoolean() throws ParseException
    {
        return convertToBoolean(super.pop());
    }

    /**
     * <p>
     * popByteArray.
     * </p>
     *
     * @return an array of byte.
     * @throws java.text.ParseException if any.
     */
    public byte[] popByteArray() throws ParseException
    {
        final Object popped = super.pop();
        if (popped instanceof byte[])
            return (byte[]) popped;

        throw new ParseException("byte[] required, found " + popped.getClass().getSimpleName(), 0);
    }

    /**
     * <p>
     * popDouble.
     * </p>
     *
     * @return a double.
     * @throws java.text.ParseException if any.
     */
    public double popDouble() throws ParseException
    {
        return convertToDouble(super.pop());
    }

    /**
     * <p>
     * popLong.
     * </p>
     *
     * @return a long.
     * @throws java.text.ParseException if any.
     */
    public long popLong() throws ParseException
    {
        return convertToLong(super.pop());
    }

    /**
     * <p>
     * popString.
     * </p>
     *
     * @return a {@link java.lang.String} object.
     * @throws java.text.ParseException if any.
     */
    public String popString() throws ParseException
    {
        final Object popped = super.pop();
        if (popped instanceof String)
            return (String) popped;
        /*
         * This is probably an unquoted single word literal.
         */
        if (popped instanceof TokVariable)
            return ((TokVariable) popped).getName();

        throw new ParseException("Literal required, found " + popped.getClass().getSimpleName(), 0);
    }

    /**
     * <p>
     * popStringOrByteArray.
     * </p>
     *
     * @return a {@link java.lang.Object} object.
     * @throws java.text.ParseException if any.
     */
    public Object popStringOrByteArray() throws ParseException
    {
        final Object popped = super.pop();
        if (popped instanceof String)
            return popped;
        /*
         * This is probably an unquoted single word literal.
         */
        if (popped instanceof TokVariable)
            return ((TokVariable) popped).getName();

        if (popped instanceof byte[])
            return popped;

        throw new ParseException("Literal or byte[] required, found " + popped.getClass().getSimpleName(), 0);
    }

    /**
     * <p>
     * popWhatever.
     * </p>
     *
     * @return a {@link java.lang.Object} object.
     * @throws java.text.ParseException if any.
     */
    public Object popWhatever() throws ParseException
    {
        return super.pop();
    }

    /** {@inheritDoc} */
    @Override
    public Object push(final Object item)
    {
        if (item instanceof Integer)
            return super.push(new Long((Integer) item));
        if (item instanceof Float)
            return super.push(new Double((Float) item));

        return super.push(item);
    }
}
