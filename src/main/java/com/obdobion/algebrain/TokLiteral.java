package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 *
 */
public class TokLiteral extends TokOperand
{
    final private char delimiter;
    private int        delims;

    public TokLiteral(final char p_delimiter)
    {
        super();
        this.delimiter = p_delimiter;
        setDelims(0);
    }

    @Override
    public boolean accepts (final char s)
    {
        return getDelims() != 2;
    }

    public int getDelims ()
    {
        return delims;
    }

    @Override
    public void put (final char c)
    {
        if (c != delimiter)
            super.put(c);
        else
            setDelims(getDelims() + 1);
    }

    @Override
    public void resolve (final ValueStack values) throws Exception
    {
        values.push(getValue().toString());
    }

    public void setDelims (final int newDelims)
    {
        delims = newDelims;
    }

    @Override
    public String toString ()
    {
        return "lit(" + super.toString() + ")";
    }
}
