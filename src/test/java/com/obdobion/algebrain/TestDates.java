package com.obdobion.algebrain;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * TestDates class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestDates
{
    /**
     * <p>
     * compareEqualsFalse.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void compareEqualsFalse() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "datefmt('19600409', 'yyyyMMdd') = datefmt('19600408', 'yyyyMMdd')");
        Assert.assertFalse(result);
    }

    /**
     * <p>
     * compareEqualsTrue.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void compareEqualsTrue() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "datefmt('19600409', 'yyyyMMdd', '') = datefmt('19600409', 'yyyyMMdd', '')");
        Assert.assertTrue(result);
    }

    /**
     * <p>
     * compareEqualsTrueWithoutAdjustments.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void compareEqualsTrueWithoutAdjustments() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date('1960-04-09') = date('1960/04/09')");
        Assert.assertTrue(result);
    }

    /**
     * <p>
     * compareEqualsWithLongValue.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void compareEqualsWithLongValue() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date(-307044000000, '=123milli') = dateFmt('19600409', 'yyyyMMdd', '=123milli')");
        Assert.assertTrue(result);
    }

    /**
     * <p>
     * compareGreaterLess.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void compareGreaterLess() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "datefmt('19600408', 'yyyyMMdd', '') < datefmt('19600409', 'yyyyMMdd', '')");
        Assert.assertTrue(result);
    }

    /**
     * <p>
     * compareGreaterTrue.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void compareGreaterTrue() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "dateFmt('19600409', 'yyyyMMdd', '') > dateFmt('19600408', 'yyyyMMdd', '')");
        Assert.assertTrue(result);
    }

    /**
     * <p>
     * createAndReturnADate.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void createAndReturnADate() throws Exception
    {
        final LocalDateTime result = (LocalDateTime) Equ.getInstance(true)
                .evaluate("dateFmt('19600409', 'yyyyMMdd', '')");
        Assert.assertEquals("yyyy", 1960, result.getYear());
        Assert.assertEquals("MM", Month.APRIL, result.getMonth());
        Assert.assertEquals("dd", 9, result.getDayOfMonth());
    }

    /**
     * <p>
     * modifyingCalendar.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void modifyingCalendar() throws Exception
    {
        final LocalDateTime result = (LocalDateTime) Equ.getInstance(true)
                .evaluate("date(dateFmt('196004090830', 'yyyyMMddHHmm', ''), '=10day =7h =31min'");
        Assert.assertEquals("yyyy", 1960, result.getYear());
        Assert.assertEquals("MM", Month.APRIL, result.getMonth());
        Assert.assertEquals("dd", 10, result.getDayOfMonth());
        Assert.assertEquals("HH", 7, result.getHour());
        Assert.assertEquals("MIN", 31, result.getMinute());
    }

    /**
     * <p>
     * todayAndNow.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void todayAndNow() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date('today') = date('now', '=0ho =0min =0sec =0milli')");
        Assert.assertTrue(result);
    }

    /**
     * <p>
     * withAdjustments.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void withAdjustments() throws Exception
    {
        final Boolean result = (Boolean) Equ.getInstance(true).evaluate(
                "date('1960-04-09', '-1day') < date('1960/04/09')");
        Assert.assertTrue(result);
    }

    /**
     * <p>
     * withAdjustmentsFromStringVariable.
     * </p>
     *
     * @throws java.lang.Exception
     *             if any.
     */
    @Test
    public void withAdjustmentsFromStringVariable() throws Exception
    {
        final Boolean result = (Boolean) Equ
                .getInstance(true)
                .evaluate(
                        "DayNumber:=-1;dateFmt('19600409', 'yyyyMMdd', cat(toString(DayNumber, '%+1.0f'), 'day')) < date('1960-04-09')");
        Assert.assertTrue(result);
    }
}
