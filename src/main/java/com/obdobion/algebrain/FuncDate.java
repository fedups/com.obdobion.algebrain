package com.obdobion.algebrain;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

import com.obdobion.calendar.CalendarFactory;

/**
 * @author Chris DeGreef
 * 
 */
public class FuncDate extends Function
{

    public FuncDate()
    {
        super();
    }

    public FuncDate(final TokVariable var)
    {
        super(var);
    }

    @Override
    public void resolve (final Stack<Object> values) throws Exception
    {
        if (values.size() < 1)
            throw new Exception("missing operands for " + toString());

        String adjustments = "";
        if (getParameterCount() == 3)
            adjustments = (String) values.pop();

        String dateFormat = "";
        if (getParameterCount() > 1)
            dateFormat = (String) values.pop();

        final Object dateInput = values.pop();
        boolean today = false;
        boolean now = false;

        Date convertedInputDate = null;
        if (dateInput instanceof String)
        {
            if (((String) dateInput).equalsIgnoreCase("today"))
                today = true;
            else if (((String) dateInput).equalsIgnoreCase("now"))
                now = true;
            else
            {
                SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
                convertedInputDate = sdf.parse((String) dateInput);
            }
        } else if (dateInput instanceof Long)
        {
            convertedInputDate = new Date((Long) dateInput);
        } else if (dateInput instanceof Double)
        {
            convertedInputDate = new Date(((Double) dateInput).longValue());
        } else
            convertedInputDate = ((Calendar) dateInput).getTime();

        if (today) {
            /*
             * format contains the adjustments for today and now.
             */
            values.push(CalendarFactory.today(dateFormat));
            return;
        }
        if (now) {
            values.push(CalendarFactory.now(dateFormat));
            return;
        }
        values.push(CalendarFactory.modify(convertedInputDate, adjustments));
    }

    @Override
    public String toString ()
    {
        return "function(date)";
    }
}
