package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncTrunc extends Function {

    public FuncTrunc() {
        super();
    }

    public FuncTrunc(final TokVariable var) {
        super(var);
    }

    /**
     * The trunc function uses one operands.
     * 
     * @see com.obdobion.algebrain.EquPart#resolve(java.util.Stack)
     */
    @Override
    public void resolve (final Stack<Object> values) throws Exception {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());
        final double[] data = convertToDouble(values.pop());
        values.push(new Double(Math.floor(data[0])));
    }

    @Override
    public String toString () {
        return "function(round)";
    }
}
