package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public abstract class Operator extends Operation
{
    public Operator()
    {
        super();
    }

    public Operator(final EquPart opTok)
    {
        super();
        setLevel(opTok.getLevel());
    }

    @Override
    protected int precedence ()
    {
        return 999;
    }

    protected Object[] ensureSameTypes (Object o1, Object o2) throws Exception
    {
        Object[] sameTypes = new Object[2];

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

        throw new Exception("\"=\" supports same type comparisons only, found "
                + o2.getClass().getSimpleName()
                + " and "
                + o1.getClass().getSimpleName());
    }

}
