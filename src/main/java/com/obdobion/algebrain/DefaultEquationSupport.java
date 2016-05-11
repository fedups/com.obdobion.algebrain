package com.obdobion.algebrain;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author Chris DeGreef
 *
 */
public class DefaultEquationSupport implements EquationSupport
{
    private Hashtable<String, Object> variables;

    public DefaultEquationSupport()
    {
        super();
        setVariables(new Hashtable<String, Object>());
    }

    public void assignVariable (final String variableName, final Object value) throws Exception
    {
        getVariables().put(variableName.toLowerCase(), value);
    }

    public List<String> getVariableNames ()
    {
        final List<String> names = new ArrayList();

        for (final String name : variables.keySet())
        {
            names.add(name);
        }
        return names;
    }

    private Hashtable<String, Object> getVariables ()
    {
        return variables;
    }

    public void removeVariable (final String name)
    {
        getVariables().remove(name);
    }

    public Hashtable<Double, Double> resolveRate (
        final String tableName,
        final java.sql.Date baseDate,
        final double tableKey) throws Exception
    {
        final Hashtable<Double, Double> rates = new Hashtable<>();
        rates.put(new Double(0), new Double(1));

        return rates;
    }

    public double resolveRate (
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

    public Object resolveVariable (final String variableName, final java.sql.Date baseDate) throws Exception
    {
        if (getVariables().get(variableName) instanceof String)
            return getVariables().get(variableName);
        return getVariables().get(variableName);
    }

    public void setVariables (final Hashtable<String, Object> newVariables)
    {
        variables = newVariables;
    }

}
