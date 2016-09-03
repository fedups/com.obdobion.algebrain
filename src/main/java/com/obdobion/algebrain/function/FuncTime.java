package com.obdobion.algebrain.function;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.obdobion.algebrain.Function;
import com.obdobion.algebrain.ValueStack;
import com.obdobion.algebrain.token.TokVariable;
import com.obdobion.calendar.CalendarFactory;
import com.obdobion.calendar.TemporalHelper;

/**
 * <p>
 * FuncDate class.
 * </p>
 *
 * @author Chris DeGreef fedupforone@gmail.com
 * @since 1.3.9
 */
public class FuncTime extends Function
{

    /**
     * <p>
     * Constructor for FuncDate.
     * </p>
     */
    public FuncTime()
    {
        super();
    }

    /**
     * <p>
     * Constructor for FuncDate.
     * </p>
     *
     * @param var a {@link com.obdobion.algebrain.token.TokVariable} object.
     */
    public FuncTime(final TokVariable var)
    {
        super(var);
    }

    /** {@inheritDoc} */
    @Override
    public void resolve(final ValueStack values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());

        try
        {
            String adjustments = "";
            if (getParameterCount() == 2)
                adjustments = values.popString();

            final Object dateInputObject = values.popWhatever();
            LocalTime convertedInputDate = null;

            if (dateInputObject instanceof String)
                convertedInputDate = TemporalHelper.parseWithPredefinedParsers((String) dateInputObject).toLocalTime();
            else

            if (dateInputObject instanceof TokVariable)
                throw new Exception("unresolved variable: " + ((TokVariable) dateInputObject).getName());
            else if (dateInputObject instanceof Long)
                convertedInputDate = CalendarFactory.at((Long) dateInputObject).toLocalTime();
            else if (dateInputObject instanceof Double)
                convertedInputDate = CalendarFactory.at(((Double) dateInputObject).longValue()).toLocalTime();
            else
                convertedInputDate = ((LocalDateTime) dateInputObject).toLocalTime();

            final LocalDateTime adjLdt = CalendarFactory.modify(convertedInputDate, adjustments);
            if (adjLdt.toLocalDate() != LocalDate.MIN)
                throw new ParseException("Adjustments to date are not allowed", 0);
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
        return "function(time)";
    }
}
