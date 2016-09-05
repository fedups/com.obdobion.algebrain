package com.obdobion.algebrain.support;

import java.util.Hashtable;
import java.util.List;

/**
 * <p>
 * EquationSupport interface.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public interface EquationSupport
{

    /**
     * <p>
     * assignVariable.
     * </p>
     *
     * @param variableName a {@link java.lang.String} object.
     * @param value a {@link java.lang.Object} object.
     * @throws java.lang.Exception if any.
     */
    void assignVariable(String variableName, Object value) throws Exception;

    /**
     * <p>
     * assignVariable.
     * </p>
     *
     * @param variableName a {@link java.lang.String} object.
     * @param value a {@link java.lang.Object} object.
     * @param systemGenerated If true these variables can not be cleared.
     * @throws java.lang.Exception if any.
     */
    void assignVariable(String variableName, Object value, boolean systemGenerated) throws Exception;

    /**
     * <p>
     * Removes all variables except system generated ones.
     * </p>
     */
    void clear();

    /**
     * <p>
     * getVariableNames.
     * </p>
     *
     * @return a {@link java.util.List} object.
     */
    List<String> getVariableNames();

    /**
     * <p>
     * getVariableNames.
     * </p>
     *
     * @param includeSystemGenerated
     * @return a {@link java.util.List} object.
     */
    List<String> getVariableNames(boolean includeSystemGenerated);

    /**
     * <p>
     * removeVariable.
     * </p>
     *
     * @param varName a {@link java.lang.String} object.
     */
    void removeVariable(String varName);

    /**
     * <p>
     * resolveRate.
     * </p>
     *
     * @param tableName a {@link java.lang.String} object.
     * @param baseDate a {@link java.util.Date} object.
     * @param tableKey a double.
     * @return a {@link java.util.Hashtable} object.
     * @throws java.lang.Exception if any.
     */
    Hashtable<Double, Double> resolveRate(String tableName, java.util.Date baseDate, double tableKey) throws Exception;

    /**
     * <p>
     * resolveRate.
     * </p>
     *
     * @param tableName a {@link java.lang.String} object.
     * @param baseDate a {@link java.util.Date} object.
     * @param key1 a {@link java.lang.String} object.
     * @param key2 a {@link java.lang.String} object.
     * @param key3 a {@link java.lang.String} object.
     * @param key4 a {@link java.lang.String} object.
     * @param key5 a {@link java.lang.String} object.
     * @return a double.
     * @throws java.lang.Exception if any.
     */
    double resolveRate(
            String tableName,
            java.util.Date baseDate,
            String key1,
            String key2,
            String key3,
            String key4,
            String key5) throws Exception;

    /**
     * <p>
     * resolveVariable.
     * </p>
     *
     * @param variableName a {@link java.lang.String} object.
     * @return a {@link java.lang.Object} object.
     * @throws java.lang.Exception if any.
     */
    Object resolveVariable(String variableName) throws Exception;

    /**
     * <p>
     * resolveVariable.
     * </p>
     *
     * @param variableName a {@link java.lang.String} object.
     * @param baseDate a {@link java.sql.Date} object.
     * @return a {@link java.lang.Object} object.
     * @throws java.lang.Exception if any.
     */
    Object resolveVariable(String variableName, java.util.Date baseDate) throws Exception;
}
