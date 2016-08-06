package com.obdobion.algebrain.support;

import java.util.Hashtable;
import java.util.List;

public interface EquationSupport
{

    void assignVariable (String variableName, Object value) throws Exception;

    List<String> getVariableNames ();

    void removeVariable (String varName);

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
}
