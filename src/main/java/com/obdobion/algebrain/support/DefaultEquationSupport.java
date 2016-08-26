package com.obdobion.algebrain.support;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * DefaultEquationSupport class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class DefaultEquationSupport implements EquationSupport
{
    private final static Logger       logger = LoggerFactory.getLogger(DefaultEquationSupport.class.getName());
    private Hashtable<String, Object> variables;

    /**
     * <p>
     * Constructor for DefaultEquationSupport.
     * </p>
     */
    public DefaultEquationSupport()
    {
        super();
        setVariables(new Hashtable<String, Object>());
        initializeWellKnownVariables();
    }

    /** {@inheritDoc} */
    @Override
    public void assignVariable(final String variableName, final Object value) throws Exception
    {
        getVariables().put(variableName.toLowerCase(), value);
    }

    /** {@inheritDoc} */
    @Override
    public List<String> getVariableNames()
    {
        final List<String> names = new ArrayList<>();

        for (final String name : variables.keySet())
            names.add(name);
        return names;
    }

    private Hashtable<String, Object> getVariables()
    {
        return variables;
    }

    void initializeWellKnownVariables()
    {
        try
        {
            assignVariable("PI", Math.PI);
            assignVariable("E", Math.E);
            assignVariable("true", new Boolean(true));
            assignVariable("false", new Boolean(false));
            assignVariable("now", "now");
            assignVariable("today", "today");

        } catch (final Exception e)
        {
            logger.error("failed to initialize some well known variables: {}", e.getMessage(), e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void removeVariable(final String name)
    {
        getVariables().remove(name);
    }

    /** {@inheritDoc} */
    @Override
    public Hashtable<Double, Double> resolveRate(
            final String tableName,
            final java.sql.Date baseDate,
            final double tableKey) throws Exception
    {
        final Hashtable<Double, Double> rates = new Hashtable<>();
        rates.put(new Double(0), new Double(1));

        return rates;
    }

    /** {@inheritDoc} */
    @Override
    public double resolveRate(
            final String tableId,
            final java.sql.Date effectiveDate,
            final String key1,
            final String key2,
            final String key3,
            final String key4,
            final String key5) throws Exception
    {
        return 1D;
    }

    /** {@inheritDoc} */
    @Override
    public Object resolveVariable(final String variableName, final java.sql.Date baseDate) throws Exception
    {
        if (getVariables().get(variableName) instanceof String)
            return getVariables().get(variableName);
        return getVariables().get(variableName);
    }

    /**
     * <p>
     * Setter for the field <code>variables</code>.
     * </p>
     *
     * @param newVariables
     *            a {@link java.util.Hashtable} object.
     */
    public void setVariables(final Hashtable<String, Object> newVariables)
    {
        variables = newVariables;
    }
}
