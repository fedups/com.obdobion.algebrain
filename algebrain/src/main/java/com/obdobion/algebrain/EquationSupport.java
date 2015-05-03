package com.obdobion.algebrain;

import java.util.Hashtable;

/**
 * @author Chris DeGreef
 * 
 */
public interface EquationSupport {

    Hashtable<Double, Double> resolveRate (String tableName, java.sql.Date baseDate, double tableKey) throws Exception;

    double resolveRate (
            String tableName,
            java.sql.Date baseDate,
            String key1,
            String key2,
            String key3,
            String key4,
            String key5) throws Exception;

    Object resolveVariable (String variableName, java.sql.Date baseDate) throws Exception;

    void assignVariable (String variableName, Object value) throws Exception;
}
