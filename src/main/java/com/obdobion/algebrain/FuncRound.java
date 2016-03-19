package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncRound extends Function {

    public FuncRound() {
        super();
    }

    public FuncRound(final TokVariable var) {
        super(var);
    }

    /**
     * The round function uses two operands. The second one is the number of
     * decimal places in which to round to.
     * 
     * @see com.obdobion.algebrain.EquPart#resolve(java.util.Stack)
     */
    @Override
    public void resolve (final Stack<Object> values) throws Exception {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        final double[] data = convertToDouble(values.pop(), values.pop());
        final double multiplier = Math.pow(10, data[0]);
        values.push(new Double(Math.round(data[1] * multiplier) / multiplier));
    }

    @Override
    public String toString () {
        return "function(round)";
    }
}
