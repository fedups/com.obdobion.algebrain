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
     * @param bytearray
     *            a {@link java.lang.Object} object.
     * @return a {@link java.lang.String} object.
     * @throws java.text.ParseException
     *             if any.
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
     * @param fromStack
     *            a {@link java.lang.Object} object.
     * @return a boolean.
     * @throws java.text.ParseException
     *             if any.
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
     * @param fromStack
     *            a {@link java.lang.Object} object.
     * @return a double.
     * @throws java.text.ParseException
     *             if any.
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
     * ensureSameTypes.
     * </p>
     *
     * @return an array of {@link java.lang.Object} objects.
     * @throws java.text.ParseException
     *             if any.
     */
    public Object[] ensureSameTypes() throws ParseException
    {
        final Object o1 = popWhatever();
        final Object o2 = popWhatever();

        final Object[] sameTypes = new Object[2];

        if (o1.getClass() == o2.getClass())
        {
            sameTypes[0] = o1;
            sameTypes[1] = o2;
            return sameTypes;
        }

        if (o1 instanceof Double && o2 instanceof Long)
        {
            sameTypes[0] = o1;
            sameTypes[1] = new Double(((Long) o2).doubleValue());
            return sameTypes;
        }

        if (o1 instanceof Long && o2 instanceof Double)
        {
            sameTypes[0] = new Double(((Long) o1).doubleValue());
            sameTypes[1] = o2;
            return sameTypes;
        }

        /*
         * This code previously allowed for specifying a string as an unquoted
         * literal. Not worth the little bit of convenience for the odd
         * exception this seems to create. For instance, rather than giving the
         * user a reasonable error like "variable with a value" it would compare
         * is a String and just say false (or true), probably a mistake on their
         * part and the reasonable error would make it easier to fix.
         */
        /*-
        if (o1 instanceof String && o2 instanceof TokVariable)
        {
            sameTypes[0] = o1;
            sameTypes[1] = ((TokVariable) o2).getName();
            return sameTypes;
        }
        if (o1 instanceof TokVariable && o2 instanceof String)
        {
            sameTypes[0] = ((TokVariable) o1).getName();
            sameTypes[1] = o2;
            return sameTypes;
        }
        */

        throw new ParseException("supports same type comparisons only, found "
                + o2.getClass().getSimpleName()
                + " and "
                + o1.getClass().getSimpleName(), 0);
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
     * @throws java.text.ParseException
     *             if any.
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
     * @throws java.text.ParseException
     *             if any.
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
     * @throws java.text.ParseException
     *             if any.
     */
    public double popDouble() throws ParseException
    {
        return convertToDouble(super.pop());
    }

    /**
     * <p>
     * popString.
     * </p>
     *
     * @return a {@link java.lang.String} object.
     * @throws java.text.ParseException
     *             if any.
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
     * @throws java.text.ParseException
     *             if any.
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
     * @throws java.text.ParseException
     *             if any.
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
