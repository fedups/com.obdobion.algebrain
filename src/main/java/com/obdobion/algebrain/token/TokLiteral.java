package com.obdobion.algebrain.token;

import com.obdobion.algebrain.ValueStack;

/**
 * <p>
 * TokLiteral class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TokLiteral extends TokOperand
{
    final private char delimiter;
    private int        delims;

    /**
     * <p>
     * Constructor for TokLiteral.
     * </p>
     *
     * @param p_delimiter a char.
     */
    public TokLiteral(final char p_delimiter)
    {
        super();
        delimiter = p_delimiter;
        setDelims(0);
    }

    /** {@inheritDoc} */
    @Override
    public boolean accepts(final char s)
    {
        return getDelims() != 2;
    }

    /**
     * <p>
     * Getter for the field <code>delims</code>.
     * </p>
     *
     * @return a int.
     */
    public int getDelims()
    {
        return delims;
    }

    /** {@inheritDoc} */
    @Override
    public void put(final char c)
    {
        if (c != delimiter)
            super.put(c);
        else
            setDelims(getDelims() + 1);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        values.push(getValue().toString());
    }

    /**
     * <p>
     * Setter for the field <code>delims</code>.
     * </p>
     *
     * @param newDelims a int.
     */
    public void setDelims(final int newDelims)
    {
        delims = newDelims;
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "lit(" + super.toString() + ")";
    }
}
