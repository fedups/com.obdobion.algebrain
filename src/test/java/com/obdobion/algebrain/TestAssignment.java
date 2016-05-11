package com.obdobion.algebrain;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Chris DeGreef
 *
 */
public class TestAssignment
{
    @Test
    public void conditionalAssignmentTarget () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("if (1=2, a, b) := 1");
        Assert.assertEquals("result", 1D, result, 0);
        Assert.assertNull("unassigned variable", Equ.getInstance().getSupport().resolveVariable("a", null));
        Assert.assertEquals("assigned variable", 1D, Equ.getInstance().getSupport().resolveVariable("b", null));
    }

    @Test
    public void equalsInsteadOfAssignment () throws Exception
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
                "op(compare equal); supports same type comparisons only, found TokVariable and Double",
                e.getMessage());
        }
    }

    @Test
    public void finalized () throws Exception
    {
        try
        {
            Equ.getInstance(true);
            Equ.getInstance().evaluate("max (a := 1, a :=2)");
            Assert.fail("expected exception");
        } catch (final Exception e)
        {
            Assert.assertEquals("exception", "invalid assignment target: 1.0", e.getMessage());
        }
    }

    @Test
    public void internalAssignments () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("c:=max (a := 1, b :=2)");
        Assert.assertEquals("result", 2D, result, 0);
        Assert.assertEquals(
            "assigned variable",
            1D,
            (double) Equ.getInstance().getSupport().resolveVariable("a", null),
            0);
        Assert.assertEquals(
            "assigned variable",
            2D,
            (double) Equ.getInstance().getSupport().resolveVariable("b", null),
            0);
        Assert.assertEquals(
            "assigned variable",
            2D,
            (double) Equ.getInstance().getSupport().resolveVariable("c", null),
            0);
    }

    @Test
    public void invalidTarget () throws Exception
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

    @Test
    public void multipleAssignments () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a := (b := 3)");
        Assert.assertEquals("result", 3D, result, 0);
        Assert.assertEquals("assigned variable", 3D, Equ.getInstance().getSupport().resolveVariable("a", null));
        Assert.assertEquals("assigned variable", 3D, Equ.getInstance().getSupport().resolveVariable("b", null));
    }

    @Test
    public void multipleAssignments2 () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a := b := 3");
        Assert.assertEquals("result", 3D, result, 0);
        Assert.assertEquals("assigned variable", 3D, Equ.getInstance().getSupport().resolveVariable("a", null));
        Assert.assertEquals("assigned variable", 3D, Equ.getInstance().getSupport().resolveVariable("b", null));
    }

    @Test
    public void multipleAssignments3 () throws Exception
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

    @Test
    public void unknownVariableInComparison () throws Exception
    {
        Equ.getInstance(true);
        try
        {
            final Object result = Equ.getInstance().evaluate("b=2");
        } catch (final Exception e)
        {
            Assert.assertEquals(
                "exception",
                "op(compare equal); supports same type comparisons only, found TokVariable and Double",
                e.getMessage());
        }
    }

    @Test
    public void withoutSupport () throws Exception
    {
        Equ.getInstance().setSupport(null);
        final Double result = (Double) Equ.getInstance().evaluate("a := 1");
        Assert.assertEquals("result", 1D, result, 0);
        Assert.assertEquals("variable", 1D, Equ.getInstance().getSupport().resolveVariable("a", null));

    }

    @Test
    public void withSupport () throws Exception
    {
        Equ.getInstance(true);
        final Double result = (Double) Equ.getInstance().evaluate("a := 1");
        Assert.assertEquals("result", 1D, result, 0);
        Assert.assertEquals("variable", 1D, Equ.getInstance().getSupport().resolveVariable("a", null));
    }
}
