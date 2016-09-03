package com.obdobion.algebrain.operator;

import java.text.ParseException;

import com.obdobion.algebrain.Equ;
import com.obdobion.algebrain.EquPart;
import com.obdobion.algebrain.Operation;
import com.obdobion.algebrain.Operator;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;

/**
 * <p>
 * OpAssignment class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class OpAssignment extends Operator
{
    /**
     * <p>
     * Constructor for OpAssignment.
     * </p>
     */
    public OpAssignment()
    {
        super();
    }

    /**
     * <p>
     * Constructor for OpAssignment.
     * </p>
     *
     * @param opTok a {@link com.obdobion.algebrain.EquPart} object.
     */
    public OpAssignment(final EquPart opTok)
    {
        super(opTok);
    }

    /** {@inheritDoc} */
    @Override
    protected int precedence()
    {
        return 990;
    }

    /** {@inheritDoc} */
    @Override
    public boolean preceeds(final Operation rightOp)
    {
        /*
         * This allows for assigning the same value to multiple variables. <br>
         * a := b := 1
         */
        if (rightOp instanceof OpAssignment)
            return false;

        return super.preceeds(rightOp);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());
        try
        {
            final Object op2 = values.popWhatever();
            final Object op1 = values.popWhatever();

            if (op2 instanceof TokVariable) { throw new Exception("invalid assignment value: " + op2.toString()); }

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

        } catch (final ParseException e)
        {
            e.fillInStackTrace();
            throw new Exception(toString() + "; " + e.getMessage(), e);
        }
    }

    /** {@inheritDoc} */
    @Override
    public String toString()
    {
        return "op(assignment)";
    }
}
