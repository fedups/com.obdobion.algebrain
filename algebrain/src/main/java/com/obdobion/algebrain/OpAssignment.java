package com.obdobion.algebrain;

import java.util.Stack;

/**
 * @author Chris DeGreef
 * 
 */
public class OpAssignment extends Operator
{
    public OpAssignment()
    {
        super();
    }

    public OpAssignment(final EquPart opTok)
    {
        super(opTok);
    }

    @Override
    protected int precedence ()
    {
        return 990;
    }

    @Override
    public boolean preceeds (final Operation rightOp)
    {
        /*
         * This allows for assigning the same value to multiple variables. <br>
         * a := b := 1
         */
        if (rightOp instanceof OpAssignment)
            return false;

        return super.preceeds(rightOp);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());

        final Object op2 = values.pop();
        final Object op1 = values.pop();

        if (op2 instanceof TokVariable)
        {
            throw new Exception("invalid assignment value: " + op2.toString());
        }

        if (op1 instanceof TokVariable && !(op2 instanceof TokVariable))
        {
            /*
             * Assign the value on the right side of the assignment to the
             * variable on the left.
             */
            Equ.getInstance().getSupport().assignVariable(((TokVariable) op1).getValue().toString(), op2);
            /*
             * leave the result (value of the assignment) on the stack.
             */
            values.push(op2);
            return;
        }

        throw new Exception("invalid assignment target: " + op1.toString());
    }

    @Override
    public String toString ()
    {
        return "op(assignment)";
    }
}
