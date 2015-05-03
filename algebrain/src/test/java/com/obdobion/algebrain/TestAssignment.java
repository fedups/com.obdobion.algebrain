package com.obdobion.algebrain;


/**
 * @author Chris DeGreef
 * 
 */
public class TestAssignment extends junit.framework.TestCase {

    public TestAssignment(final String name) {

        super(name);
    }

    public void testConditionalAssignmentTarget () throws Exception {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("if (1=2, a, b) := 1");
        assertEquals("result", 1D, result);
        assertNull("unassigned variable", Equ.getInstance().getSupport().resolveVariable("a", null));
        assertEquals("assigned variable", 1D, Equ.getInstance().getSupport().resolveVariable("b", null));
    }

    public void testEqualsInsteadOfAssignment () throws Exception {

        try {
            Equ.getInstance().setSupport(new DefaultEquationSupport());
            Equ.getInstance().evaluate("max (a := 1, b=2)");
            fail("expected exception");
        } catch (final Exception e) {
            assertEquals("exception", "invalid type for function(max-2); Boolean ", e.getMessage());
        }
    }

    public void testFinalized () throws Exception {

        try {
            Equ.getInstance().setSupport(new DefaultEquationSupport());
            Equ.getInstance().evaluate("max (a := 1, a :=2)");
            fail("expected exception");
        } catch (final Exception e) {
            assertEquals("exception", "invalid assignment target: 1.0", e.getMessage());
        }
    }

    public void testInternalAssignments () throws Exception {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("c:=max (a := 1, b :=2)");
        assertEquals("result", 2D, result);
        assertEquals("assigned variable", 1D, Equ.getInstance().getSupport().resolveVariable("a", null));
        assertEquals("assigned variable", 2D, Equ.getInstance().getSupport().resolveVariable("b", null));
        assertEquals("assigned variable", 2D, Equ.getInstance().getSupport().resolveVariable("c", null));
    }

    public void testInvalidTarget () throws Exception {

        try {
            Equ.getInstance().setSupport(new DefaultEquationSupport());
            Equ.getInstance().evaluate("'target' :=2");
            fail("expected exception");
        } catch (final Exception e) {
            assertEquals("exception", "invalid assignment target: target", e.getMessage());
        }
    }

    public void testMultipleAssignments () throws Exception {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("a := (b := 3)");
        assertEquals("result", 3D, result);
        assertEquals("assigned variable", 3D, Equ.getInstance().getSupport().resolveVariable("a", null));
        assertEquals("assigned variable", 3D, Equ.getInstance().getSupport().resolveVariable("b", null));
    }

    public void testMultipleAssignments2 () throws Exception {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("a := b := 3");
        assertEquals("result", 3D, result);
        assertEquals("assigned variable", 3D, Equ.getInstance().getSupport().resolveVariable("a", null));
        assertEquals("assigned variable", 3D, Equ.getInstance().getSupport().resolveVariable("b", null));
    }

    public void testMultipleAssignments3 () throws Exception {

        try {
            Equ.getInstance().setSupport(new DefaultEquationSupport());
            Equ.getInstance().evaluate("a := 3 := b");
            fail("expected exception");
        } catch (final Exception e) {
            assertEquals("exception", "invalid assignment value: var(b)", e.getMessage());
        }
    }

    public void testUnknownVariableInComparison () throws Exception {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Object result = Equ.getInstance().evaluate("b=2");
        assertTrue("result type", result instanceof Boolean);
        assertFalse("result", ((Boolean) result).booleanValue());
    }

    public void testWithoutSupport () throws Exception {

        Equ.getInstance().setSupport(null);
        final Double result = (Double) Equ.getInstance().evaluate("a := 1");
        assertEquals("result", 1D, result);
        assertEquals("variable", 1D, Equ.getInstance().getSupport().resolveVariable("a", null));

    }

    public void testWithSupport () throws Exception {

        Equ.getInstance().setSupport(new DefaultEquationSupport());
        final Double result = (Double) Equ.getInstance().evaluate("a := 1");
        assertEquals("result", 1D, result);
        assertEquals("variable", 1D, Equ.getInstance().getSupport().resolveVariable("a", null));
    }
}
