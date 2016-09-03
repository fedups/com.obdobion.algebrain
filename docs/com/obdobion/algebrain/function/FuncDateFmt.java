package com.obdobion.algebrain.function;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;
import com.obdobion.calendar.CalendarFactory;

/**
 * <p>
 * FuncDateTimeFmt class.
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
     * Constructor for FuncDateTimeFmt.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
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

            if (getParameterCount() == 3)
                adjustments = values.popString();

            final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(values.popString());

            final String dateInputObject = values.popString();
            final LocalDate convertedInputDate = LocalDate.parse(dateInputObject, dtf);

            final LocalDateTime adjLdt = CalendarFactory.modify(convertedInputDate, adjustments);
            if (adjLdt.toLocalTime() != LocalTime.MIN)
                throw new ParseException("Adjustments to time are not allowed", 0);
            values.push(adjLdt);

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
