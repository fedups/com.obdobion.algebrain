package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 *
 */
public class TestStrings
{
    @Test
    public void stringCaseInsensitive () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("match('ABC123XYZ', 'abc', true)");
        Assert.assertEquals("ABC", result);
    }

    @Test
    public void stringConcatinateMany () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("cat('1','2','3','4')");
        Assert.assertEquals("1234", result);
    }

    @Test
    public void stringConcatinateMatchResult () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("cat(match('ABC123XYZ', '123'), 'WHAT')");
        Assert.assertEquals("123WHAT", result);
    }

    @Test
    public void stringConcatinateMatchResults () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("cat(match('ABC123XYZ', '123'), match('ABC123XYZ', 'XYZ'))");
        Assert.assertEquals("123XYZ", result);
    }

    @Test
    public void stringConcatinateOne () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("cat('1')");
        Assert.assertEquals("1", result);
    }

    @Test
    public void stringEmpty () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("empty(match('ABC123XYZ', 'NOTHING'))");
        Assert.assertTrue(result.booleanValue());
    }

    @Test
    public void stringIndexOf () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("indexOf(' ABC ', 'B')");
        Assert.assertEquals(2, result, 0D);
    }

    @Test
    public void stringLeadingSpaces () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("' TRIMMED'=' TRIMMED'");
        Assert.assertTrue(result.booleanValue());
    }

    @Test
    public void stringLeftTrim () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("ltrim(' ABC ')");
        Assert.assertEquals("ABC ", result);
    }

    @Test
    public void stringLength () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("length(match('ABC123XYZ', '[X-Z]+'))");
        Assert.assertEquals(3, result, 0D);
    }

    @Test
    public void stringMatches () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("match('ABC123XYZ', '.*123.*')");
        Assert.assertEquals("ABC123XYZ", result);
    }

    @Test
    public void stringMatchesInitialGroup () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("match('ABC123XYZ', '.*(123).*')");
        Assert.assertEquals("123", result);
    }

    @Test
    public void stringMatchesPartial () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("match('ABC123XYZ', '123')");
        Assert.assertEquals("123", result);
    }

    @Test
    public void stringNoSpaces () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("'TRIMMED'='TRIMMED'");
        Assert.assertTrue(result.booleanValue());
    }

    @Test
    public void stringNotEmpty () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("not(empty(match('ABC123XYZ', '123')))");
        Assert.assertTrue(result.booleanValue());
    }

    @Test
    public void stringRightTrim () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("rtrim(' ABC ')");
        Assert.assertEquals(" ABC", result);
    }

    @Test
    public void stringSubstring () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("substr('ABC123XYZ', 2, 3)");
        Assert.assertEquals("C12", result);
    }

    @Test
    public void stringTrailingSpaces () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("'TRIMMED '='TRIMMED '");
        Assert.assertTrue(result.booleanValue());
    }

    @Test
    public void stringTrim () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("trim(' ABC ')");
        Assert.assertEquals("ABC", result);
    }

    @Test
    public void stringUntrimmed () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("' TRIMMED '=' TRIMMED '");
        Assert.assertTrue(result.booleanValue());
    }

    @Test
    public void unquotedLiteral () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("rtrim('Illinois') = Illinois");
        Assert.assertTrue(result.booleanValue());
    }
}
