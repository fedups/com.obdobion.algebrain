package com.obdobion.algebrain.function;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;
import com.obdobion.calendar.CalendarFactory;

/**
 * <p>
 * FuncDateFmt class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 */
public class FuncDateFmt extends Function
{

    /**
     * <p>
     * Constructor for FuncDate.
     * </p>
     */
    public FuncDateFmt()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncDateFmt.
     * </p>
     *
     * @param var
     *            a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncDateFmt(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 2)
            throw new Exception("missing operands for " + toString());

        try
        {
            String adjustments = "";
            String dateFormat = "";

            if (getParameterCount() == 3)
                adjustments = values.popString();

            if (getParameterCount() > 1)
                dateFormat = values.popString();

            final Double dateInput = values.popDouble();
            Date convertedInputDate = null;
            final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            convertedInputDate = sdf.parse("" + dateInput.longValue());
            values.push(CalendarFactory.modify(convertedInputDate, adjustments));

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
        return "function(dateFmt)";
    }
}
