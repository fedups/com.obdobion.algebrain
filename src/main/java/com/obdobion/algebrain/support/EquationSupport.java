package com.obdobion.algebrain.support;

import java.util.Hashtable;
import java.util.List;

/**
 * <p>EquationSupport interface.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public interface EquationSupport
{

    /**
     * <p>assignVariable.</p>
     *
     * @param variableName a {@link java.lang.String} object.
     * @param value a {@link java.lang.Object} object.
     * @throws java.lang.Exception if any.
     */
    void assignVariable (String variableName, Object value) throws Exception;

    /**
     * <p>getVariableNames.</p>
     *
     * @return a {@link java.util.List} object.
     */
    List<String> getVariableNames ();

    /**
     * <p>removeVariable.</p>
     *
     * @param varName a {@link java.lang.String} object.
     */
    void removeVariable (String varName);

    /**
     * <p>resolveRate.</p>
     *
     * @param tableName a {@link java.lang.String} object.
     * @param baseDate a {@link java.sql.Date} object.
     * @param tableKey a double.
     * @return a {@link java.util.Hashtable} object.
     * @throws java.lang.Exception if any.
     */
    Hashtable<Double, Double> resolveRate (String tableName, java.sql.Date baseDate, double tableKey) throws Exception;

    /**
     * <p>resolveRate.</p>
     *
     * @param tableName a {@link java.lang.String} object.
     * @param baseDate a {@link java.sql.Date} object.
     * @param key1 a {@link java.lang.String} object.
     * @param key2 a {@link java.lang.String} object.
     * @param key3 a {@link java.lang.String} object.
     * @param key4 a {@link java.lang.String} object.
     * @param key5 a {@link java.lang.String} object.
     * @return a double.
     * @throws java.lang.Exception if any.
     */
    double resolveRate (
        String tableName,
        java.sql.Date baseDate,
        String key1,
        String key2,
        String key3,
        String key4,
        String key5) throws Exception;

    /**
     * <p>resolveVariable.</p>
     *
     * @param variableName a {@link java.lang.String} object.
     * @param baseDate a {@link java.sql.Date} object.
     * @return a {@link java.lang.Object} object.
     * @throws java.lang.Exception if any.
     */
    Object resolveVariable (String variableName, java.sql.Date baseDate) throws Exception;
}
