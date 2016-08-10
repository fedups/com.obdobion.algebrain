package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>TestStrings class.</p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestStrings
{
    /**
     * <p>stringCaseInsensitive.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringCaseInsensitive () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("match('ABC123XYZ', 'abc', true)");
        Assert.assertEquals("ABC", result);
    }

    /**
     * <p>stringConcatinateMany.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringConcatinateMany () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("cat('1','2','3','4')");
        Assert.assertEquals("1234", result);
    }

    /**
     * <p>stringConcatinateMatchResult.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringConcatinateMatchResult () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("cat(match('ABC123XYZ', '123'), 'WHAT')");
        Assert.assertEquals("123WHAT", result);
    }

    /**
     * <p>stringConcatinateMatchResults.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringConcatinateMatchResults () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("cat(match('ABC123XYZ', '123'), match('ABC123XYZ', 'XYZ'))");
        Assert.assertEquals("123XYZ", result);
    }

    /**
     * <p>stringConcatinateOne.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringConcatinateOne () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("cat('1')");
        Assert.assertEquals("1", result);
    }

    /**
     * <p>stringEmpty.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringEmpty () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("empty(match('ABC123XYZ', 'NOTHING'))");
        Assert.assertTrue(result.booleanValue());
    }

    /**
     * <p>stringIndexOf.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringIndexOf () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("indexOf(' ABC ', 'B')");
        Assert.assertEquals(2, result, 0D);
    }

    /**
     * <p>stringLeadingSpaces.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringLeadingSpaces () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("' TRIMMED'=' TRIMMED'");
        Assert.assertTrue(result.booleanValue());
    }

    /**
     * <p>stringLeftTrim.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringLeftTrim () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("ltrim(' ABC ')");
        Assert.assertEquals("ABC ", result);
    }

    /**
     * <p>stringLength.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringLength () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Double result = (Double) equ.evaluate("length(match('ABC123XYZ', '[X-Z]+'))");
        Assert.assertEquals(3, result, 0D);
    }

    /**
     * <p>stringLowercase.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringLowercase () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("lcase('abcDEF')");
        Assert.assertEquals("abcdef", result);
    }

    /**
     * <p>stringMatches.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringMatches () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("match('ABC123XYZ', '.*123.*')");
        Assert.assertEquals("ABC123XYZ", result);
    }

    /**
     * <p>stringMatchesInitialGroup.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringMatchesInitialGroup () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("match('ABC123XYZ', '.*(123).*')");
        Assert.assertEquals("123", result);
    }

    /**
     * <p>stringMatchesPartial.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringMatchesPartial () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("match('ABC123XYZ', '123')");
        Assert.assertEquals("123", result);
    }

    /**
     * <p>stringMetaphone.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringMetaphone () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("metaphone('telephone')");
        Assert.assertEquals("TLFN", result);
    }

    /**
     * <p>stringMetaphoneCompare.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringMetaphoneCompare () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("metaphone('telephone') = metaphone('telifon')");
        Assert.assertTrue(result);
    }

    /**
     * <p>stringNoSpaces.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringNoSpaces () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("'TRIMMED'='TRIMMED'");
        Assert.assertTrue(result.booleanValue());
    }

    /**
     * <p>stringNotEmpty.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringNotEmpty () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("not(empty(match('ABC123XYZ', '123')))");
        Assert.assertTrue(result.booleanValue());
    }

    /**
     * <p>stringReplaceWithEqual.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringReplaceWithEqual () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("replace('ABC123XYZ', '[0-9]', '#')");
        Assert.assertEquals("ABC###XYZ", result);
    }

    /**
     * <p>stringReplaceWithLonger.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringReplaceWithLonger () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("replace('ABC123XYZ', '[0-9]', '(NUMBER)')");
        Assert.assertEquals("ABC(NUMBER)(NUMBER)(NUMBER)XYZ", result);
    }

    /**
     * <p>stringReplaceWithShorter.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringReplaceWithShorter () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("replace('ABC123XYZ', '[0-9]{2}', '#')");
        Assert.assertEquals("ABC#3XYZ", result);
    }

    /**
     * <p>stringRightTrim.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringRightTrim () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("rtrim(' ABC ')");
        Assert.assertEquals(" ABC", result);
    }

    /**
     * <p>stringSubstring.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringSubstring () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("substr('ABC123XYZ', 2, 3)");
        Assert.assertEquals("C12", result);
    }

    /**
     * <p>stringTrailingSpaces.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringTrailingSpaces () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("'TRIMMED '='TRIMMED '");
        Assert.assertTrue(result.booleanValue());
    }

    /**
     * <p>stringTrim.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringTrim () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("trim(' ABC ')");
        Assert.assertEquals("ABC", result);
    }

    /**
     * <p>stringUntrimmed.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringUntrimmed () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("' TRIMMED '=' TRIMMED '");
        Assert.assertTrue(result.booleanValue());
    }

    /**
     * <p>stringUppercase.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void stringUppercase () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final String result = (String) equ.evaluate("ucase('abcDEF')");
        Assert.assertEquals("ABCDEF", result);
    }

    /**
     * <p>unquotedLiteral.</p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void unquotedLiteral () throws Exception
    {
        final Equ equ = Equ.getInstance();
        final Boolean result = (Boolean) equ.evaluate("rtrim('Illinois') = Illinois");
        Assert.assertTrue(result.booleanValue());
    }
}
