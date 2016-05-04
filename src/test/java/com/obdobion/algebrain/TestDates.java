package com.obdobion.algebrain;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 * 
 */
public class TestDates
{
    @Test
    public void createAndReturnADate () throws Exception
    {
        Calendar result = (Calendar) Equ.getInstance(true).evaluate("date('19600409', 'yyyyMMdd', '')");
        Assert.assertEquals("yyyy", 1960, result.get(Calendar.YEAR));
        Assert.assertEquals("MM", Calendar.APRIL, result.get(Calendar.MONTH));
        Assert.assertEquals("dd", 9, result.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void compareEqualsWithLongValue () throws Exception
    {
        Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date(-307044000000) = date('19600409', 'yyyyMMdd')");
        Assert.assertTrue(result);
    }

    @Test
    public void todayAndNow () throws Exception
    {
        Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date('today') = date('now', '=0ho =0min =0sec =0milli')");
        Assert.assertTrue(result);
    }

    @Test
    public void compareEqualsTrueWithoutAdjustments () throws Exception
    {
        Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date('19600409', 'yyyyMMdd') = date('19600409', 'yyyyMMdd')");
        Assert.assertTrue(result);
    }

    @Test
    public void compareEqualsTrue () throws Exception
    {
        Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date('19600409', 'yyyyMMdd', '') = date('19600409', 'yyyyMMdd', '')");
        Assert.assertTrue(result);
    }

    @Test
    public void compareEqualsFalse () throws Exception
    {
        Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date('19600409', 'yyyyMMdd', '') = date('19600408', 'yyyyMMdd', '')");
        Assert.assertFalse(result);
    }

    @Test
    public void compareGreaterTrue () throws Exception
    {
        Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date('19600409', 'yyyyMMdd', '') > date('19600408', 'yyyyMMdd', '')");
        Assert.assertTrue(result);
    }

    @Test
    public void compareGreaterLess () throws Exception
    {
        Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date('19600408', 'yyyyMMdd', '') < date('19600409', 'yyyyMMdd', '')");
        Assert.assertTrue(result);
    }

    @Test
    public void withAdjustments () throws Exception
    {
        Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date('19600409', 'yyyyMMdd', '-1day') < date('19600409', 'yyyyMMdd', '')");
        Assert.assertTrue(result);
    }

    @Test
    public void withAdjustmentsFromStringVariable () throws Exception
    {
        Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                        "DayNumber:=-1;date('19600409', 'yyyyMMdd', cat(toString(DayNumber, '%+1.0f'), 'day')) < date('19600409', 'yyyyMMdd', '')");
        Assert.assertTrue(result);
    }
}
