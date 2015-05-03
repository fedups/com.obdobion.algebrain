package com.obdobion.algebrain;

/**
 * @author Chris DeGreef
 * 
 */
public class TestReuse extends junit.framework.TestCase {

    public TestReuse(final String name) {

        super(name);
    }

    @SuppressWarnings("null")
    public void testReuseEqu () throws Exception {

        final Equ equ = Equ.getInstance();

        long start, dur;
        Double result = null;
        equ.getSupport().assignVariable("x", new Double(5));
        start = System.currentTimeMillis();
        for (int x = 0; x <= 1000; x++) {
            result = (Double) equ.evaluate("2x");
        }
        dur = System.currentTimeMillis() - start;
        System.out.println(dur);
        assertEquals("ReuseEqu result1 ", 10D, result.doubleValue(), 0D);

        equ.getSupport().assignVariable("x", new Double(5));
        start = System.currentTimeMillis();
        for (int x = 0; x <= 1000; x++) {
            equ.compile("2x");
        }
        dur = System.currentTimeMillis() - start;
        System.out.println(dur);

        start = System.currentTimeMillis();
        for (long x = 0; x <= 400000; x++) {
            equ.getSupport().assignVariable("x", new Double(x));
            result = (Double) equ.evaluate();
        }
        dur = System.currentTimeMillis() - start;
        System.out.println(dur);
        assertEquals("ReuseEqu result2 ", 800000D, result.doubleValue(), 0D);
    }
}
