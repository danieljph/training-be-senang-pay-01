package com.doku.my.trainingbesenangpay01.module.miniproject.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class AppUtils
{
    private AppUtils()
    {
    }

    public static String toString(Throwable throwable)
    {
        var sw = new StringWriter();
        var pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        return sw.toString();
    }
}
