package com.obdobion.algebrain;

/**
 * <p>
 * Abstract EquPart class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 */
public abstract class EquPart extends Object
{
    private Equ equ;
    private int level;

    /**
     * <p>
     * Constructor for EquPart.
     * </p>
     */
    public EquPart()
    {
        super();
    }

    /**
     * <p>
     * Getter for the field <code>equ</code>.
     * </p>
     *
     * @return a {@link com.obdobion.algebrain.Equ} object.
     */
    public Equ getEqu()
    {
        return equ;
    }

    /**
     * <p>
     * Getter for the field <code>level</code>.
     * </p>
     *
     * @return a int.
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * <p>
     * multiplize.
     * </p>
     *
     * @param rightSide is not used
     * @return a boolean.
     */
    public boolean multiplize(final EquPart rightSide)
    {
        return false;
    }

    /**
     * <p>
     * negatize.
     * </p>
     *
     * @param rightSide is not used
     * @return a boolean.
     * @since 2.2.1
     */
    public boolean negatize(final EquPart rightSide)
    {
        return false;
    }

    /**
     * <p>
     * resolve.
     * </p>
     *
     * @param values a {@link com.obdobion.algebrain.ValueStack} object.
     * @throws java.lang.Exception if any.
     */
    public abstract void resolve(ValueStack values) throws Exception;

    /**
     * <p>
     * Setter for the field <code>equ</code>.
     * </p>
     *
     * @param newEqu a {@link com.obdobion.algebrain.Equ} object.
     */
    public void setEqu(final Equ newEqu)
    {
        equ = newEqu;
    }

    /**
     * <p>
     * Setter for the field <code>level</code>.
     * </p>
     *
     * @param newLevel a int.
     */
    public void setLevel(final int newLevel)
    {
        level = newLevel;
    }
}
