package com.obdobion.algebrain.support;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.obdobion.calendar.CalendarFactory;

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
    /**
     * @author Chris DeGreef
     *
     */
    static class Variable
    {
        boolean systemGenerated;
        Object  value;
        String  name;

        /**
         * @param _value
         */
        public Variable(final String _name, final Object _value)
        {
            this(_name, _value, false);
        }

        public Variable(final String _name, final Object _value, final boolean sysgen)
        {
            name = _name;
            value = _value;
            systemGenerated = sysgen;
        }
    }

    private final static Logger         logger = LoggerFactory.getLogger(DefaultEquationSupport.class.getName());
    private Hashtable<String, Variable> variables;

    /**
     * <p>
     * Constructor for DefaultEquationSupport.
     * </p>
     */
    public DefaultEquationSupport()
    {
        super();
        setVariables(new Hashtable<String, Variable>());
        initializeWellKnownVariables();
    }

    /** {@inheritDoc} */
    @Override
    public void assignVariable(final String variableName, final Object value) throws Exception
    {
        assignVariable(variableName, value, false);
    }

    /** {@inheritDoc} */
    @Override
    public void assignVariable(final String variableName, final Object value, final boolean sysgen) throws Exception
    {
        /*
         * Only store supported types in the stack.
         */
        if (value instanceof Date)
            getVariables().put(variableName.toLowerCase(),
                    new Variable(variableName, CalendarFactory.convert((Date) value), sysgen));
        else if (value instanceof Calendar)
            getVariables().put(variableName.toLowerCase(),
                    new Variable(variableName, CalendarFactory.convert((Calendar) value), sysgen));
        else
            getVariables().put(variableName.toLowerCase(),
                    new Variable(variableName, value, sysgen));
    }

    /** {@inheritDoc} */
    @Override
    public void clear()
    {
        final Enumeration<Variable> varIter = getVariables().elements();
        while (varIter.hasMoreElements())
        {
            final Variable var = varIter.nextElement();
            if (var.systemGenerated)
                continue;
            removeVariable(var.name);
        }
    }

    /** {@inheritDoc} */
    @Override
    public List<String> getVariableNames()
    {
        return getVariableNames(true);
    }

    /** {@inheritDoc} */
    @Override
    public List<String> getVariableNames(final boolean includeSystemGenerated)
    {
        final List<String> names = new ArrayList<>();

        for (final String name : variables.keySet())
        {
            if (!includeSystemGenerated)
            {
                final Variable var = getVariables().get(name);
                if (var.systemGenerated)
                    continue;
            }
            names.add(name);
        }
        return names;
    }

    private Hashtable<String, Variable> getVariables()
    {
        return variables;
    }

    void initializeWellKnownVariables()
    {
        try
        {
            assignVariable("PI", Math.PI, true);
            assignVariable("E", Math.E, true);
            assignVariable("true", new Boolean(true), true);
            assignVariable("false", new Boolean(false), true);
            assignVariable("now", "now", true);
            assignVariable("today", "today", true);

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
            final java.util.Date baseDate,
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
            final java.util.Date effectiveDate,
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
    public Object resolveVariable(final String variableName) throws Exception
    {
        final Variable variable = getVariables().get(variableName);
        if (variable == null)
            return null;
        return variable.value;
    }

    /** {@inheritDoc} */
    @Override
    public Object resolveVariable(final String variableName, final java.util.Date baseDate) throws Exception
    {
        final Variable variable = getVariables().get(variableName);
        if (variable == null)
            return null;
        return variable.value;
    }

    /**
     * <p>
     * Setter for the field <code>variables</code>.
     * </p>
     *
     * @param newVariables a {@link java.util.Hashtable} object.
     */
    public void setVariables(final Hashtable<String, Variable> newVariables)
    {
        variables = newVariables;
    }
}
