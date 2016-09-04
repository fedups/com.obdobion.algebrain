package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>
 * TestAssignment class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class TestAssignment
{
    /**
     * <p>
     * conditionalAssignmentTarget.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void conditionalAssignmentTarget() throws Exception
    {
        Equ.getInstance(true);
        final long result = (long) Equ.getInstance().evaluate("if (1=2, a, b) := 1");
        Assert.assertEquals("result", 1, result);
        Assert.assertNull("unassigned variable", Equ.getInstance().getSupport().resolveVariable("a", null));
        Assert.assertEquals("assigned variable", new Long(1),
                Equ.getInstance().getSupport().resolveVariable("b", null));
    }

    /**
     * <p>
     * equalsInsteadOfAssignment.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void equalsInsteadOfAssignment() throws Exception
    {
        try
        {
            Equ.getInstance(true);
            Equ.getInstance().evaluate("max (a := 1, b=2)");
            Assert.fail("expected exception");
        } catch (final Exception e)
        {
            Assert.assertEquals(
                    "exception",
                    "op(compare equal); \"b\" is unassigned",
                    e.getMessage());
        }
    }

    /**
     * <p>
     * finalized.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void finalized() throws Exception
    {
        try
        {
            Equ.getInstance(true);
            Equ.getInstance().evaluate("max (a := 1, a :=2)");
            Assert.fail("expected exception");
        } catch (final Exception e)
        {
            Assert.assertEquals("exception", "invalid assignment target: 1", e.getMessage());
        }
    }

    /**
     * <p>
     * internalAssignments.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void internalAssignments() throws Exception
    {
        Equ.getInstance(true);
        final Long result = (Long) Equ.getInstance().evaluate("c:=max (a := 1, b :=2)");
        Assert.assertEquals("result", 2, result.intValue());
        Assert.assertEquals("assigned variable", new Long(1),
                Equ.getInstance().getSupport().resolveVariable("a", null));
        Assert.assertEquals("assigned variable", new Long(2),
                Equ.getInstance().getSupport().resolveVariable("b", null));
        Assert.assertEquals("assigned variable", new Long(2),
                Equ.getInstance().getSupport().resolveVariable("c", null));
    }

    /**
     * <p>
     * invalidTarget.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void invalidTarget() throws Exception
    {
        try
        {
            Equ.getInstance(true);
            Equ.getInstance().evaluate("'target' :=2");
            Assert.fail("expected exception");
        } catch (final Exception e)
        {
            Assert.assertEquals("exception", "invalid assignment target: target", e.getMessage());
        }
    }

    /**
     * <p>
     * multipleAssignments.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void multipleAssignments() throws Exception
    {
        Equ.getInstance(true);
        final Long result = (Long) Equ.getInstance().evaluate("a := (b := 3)");
        Assert.assertEquals("result", 3, result.intValue());
        Assert.assertEquals("assigned variable", new Long(3),
                Equ.getInstance().getSupport().resolveVariable("a", null));
        Assert.assertEquals("assigned variable", new Long(3),
                Equ.getInstance().getSupport().resolveVariable("b", null));
    }

    /**
     * <p>
     * multipleAssignments2.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void multipleAssignments2() throws Exception
    {
        Equ.getInstance(true);
        final Long result = (Long) Equ.getInstance().evaluate("a := b := 3");
        Assert.assertEquals("result", 3, result.intValue());
        Assert.assertEquals("assigned variable", new Long(3),
                Equ.getInstance().getSupport().resolveVariable("a", null));
        Assert.assertEquals("assigned variable", new Long(3),
                Equ.getInstance().getSupport().resolveVariable("b", null));
    }

    /**
     * <p>
     * multipleAssignments3.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void multipleAssignments3() throws Exception
    {
        try
        {
            Equ.getInstance(true);
            Equ.getInstance().evaluate("a := 3 := b");
            Assert.fail("expected exception");
        } catch (final Exception e)
        {
            Assert.assertEquals("exception", "invalid assignment value: var(b)", e.getMessage());
        }
    }

    /**
     * <p>
     * unknownVariableInComparison.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void unknownVariableInComparison() throws Exception
    {
        Equ.getInstance(true);
        try
        {
            Equ.getInstance().evaluate("b=2");
        } catch (final Exception e)
        {
            Assert.assertEquals(
                    "exception",
                    "op(compare equal); \"b\" is unassigned",
                    e.getMessage());
        }
    }

    /**
     * <p>
     * withoutSupport.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void withoutSupport() throws Exception
    {
        Equ.getInstance().setSupport(null);
        final Long result = (Long) Equ.getInstance().evaluate("a := 1");
        Assert.assertEquals("result", 1, result.intValue());
        Assert.assertEquals("variable", new Long(1), Equ.getInstance().getSupport().resolveVariable("a", null));

    }

    /**
     * <p>
     * withSupport.
     * </p>
     *
     * @throws java.lang.Exception if any.
     */
    @Test
    public void withSupport() throws Exception
    {
        Equ.getInstance(true);
        final Long result = (Long) Equ.getInstance().evaluate("a := 1");
        Assert.assertEquals("result", 1, result.intValue());
        Assert.assertEquals("variable", new Long(1), Equ.getInstance().getSupport().resolveVariable("a", null));
    }
}
