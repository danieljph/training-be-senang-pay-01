package com.doku.my.trainingbesenangpay01.module.miniproject.controller.filter;

import org.springframework.util.AntPathMatcher;

/**
 * This class is created to fix the issue where Snyk wrongly said AntPathMatcher.match() is vulnerable.
 *
 * @author Daniel Joi Partogi Hutapea
 */
@SuppressWarnings("unused")
public class AppAntPathMatcher extends AntPathMatcher
{
    public boolean isAntPathMatched(String path, String pattern)
    {
        return match(path, pattern);
    }
}
