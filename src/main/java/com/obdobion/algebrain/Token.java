package com.obdobion.algebrain;

import java.util.Collection;

/**
 * @author Chris DeGreef
 * 
 */
public abstract class Token extends EquPart
{
    public static Token instanceFor (final char c)
    {
        if (c == '\'')
            return new TokLiteral();

        if (Character.isDigit(c) || c == '-' || c == '.')
            return new TokNumber();

        if (Character.isLetter(c) || c == '_')
            return new TokVariable();

        return new TokOperator();
    }

    StringBuffer value;

    public Token()
    {
        super();
        setValue(new StringBuffer());
    }

    /**
     * @param c any value is ok, and ignored in this method
     * @return
     */
    public boolean accepts (final char c)
    {
        return true;
    }

    public void addTo (final Collection<EquPart> tokens) throws Exception
    {
        tokens.add(morph());
    }

    public java.lang.StringBuffer getValue ()
    {
        return value;
    }

    protected EquPart morph () throws Exception
    {
        return this;
    }

    public void put (final char c)
    {
        getValue().append(c);
    }

    public void setValue (final java.lang.StringBuffer newValue)
    {
        value = newValue;
    }

    @Override
    public String toString ()
    {
        return getValue().toString();
    }
}
