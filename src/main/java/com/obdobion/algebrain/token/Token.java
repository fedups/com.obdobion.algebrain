package com.obdobion.algebrain.token;

import java.util.Collection;

import com.obdobion.algebrain.EquPart;

/**
 * <p>Abstract Token class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public abstract class Token extends EquPart
{
    /**
     * <p>instanceFor.</p>
     *
     * @param c a char.
     * @return a {@link com.obdobion.algebrain.token.Token} object.
     */
    public static Token instanceFor (final char c)
    {
        if (c == '\'' || c == '"')
            return new TokLiteral(c);

        if (Character.isDigit(c) || c == '-' || c == '.')
            return new TokNumber();

        if (Character.isLetter(c) || c == '_')
            return new TokVariable();

        return new TokOperator();
    }

    StringBuffer value;

    /**
     * <p>Constructor for Token.</p>
     */
    public Token()
    {
        super();
        setValue(new StringBuffer());
    }

    /**
     * <p>accepts.</p>
     *
     * @param c any value is ok, and ignored in this method
     * @return a boolean.
     */
    public boolean accepts (final char c)
    {
        return true;
    }

    /**
     * <p>addTo.</p>
     *
     * @param tokens a {@link java.util.Collection} object.
     * @throws java.lang.Exception if any.
     */
    public void addTo (final Collection<EquPart> tokens) throws Exception
    {
        tokens.add(morph());
    }

    /**
     * <p>Getter for the field <code>value</code>.</p>
     *
     * @return a {@link java.lang.StringBuffer} object.
     */
    public java.lang.StringBuffer getValue ()
    {
        return value;
    }

    /**
     * <p>morph.</p>
     *
     * @return a {@link com.obdobion.algebrain.EquPart} object.
     * @throws java.lang.Exception if any.
     */
    protected EquPart morph () throws Exception
    {
        return this;
    }

    /**
     * <p>put.</p>
     *
     * @param c a char.
     */
    public void put (final char c)
    {
        getValue().append(c);
    }

    /**
     * <p>Setter for the field <code>value</code>.</p>
     *
     * @param newValue a {@link java.lang.StringBuffer} object.
     */
    public void setValue (final java.lang.StringBuffer newValue)
    {
        value = newValue;
    }

    /** {@inheritDoc} */
    @Override
    public String toString ()
    {
        return getValue().toString();
    }
}
