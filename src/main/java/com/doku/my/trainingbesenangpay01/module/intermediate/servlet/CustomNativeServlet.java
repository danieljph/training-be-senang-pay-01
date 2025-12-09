package com.doku.my.trainingbesenangpay01.module.intermediate.servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class CustomNativeServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        var xPartnerId = request.getHeader("X-Partner-Id");

        var param1 = request.getParameter("param-1");
        var param2 = request.getParameter("param-2");

        response.setContentType("text/plain");

        response.getWriter().write("[GET] Request URI          : " + request.getRequestURI() + "\n");
        response.getWriter().write("[GET] Header[X-PARTNER-ID] : " + xPartnerId + "\n");
        response.getWriter().write("[GET] Param-1              : " + param1 + "\n");
        response.getWriter().write("[GET] Param-2              : " + param2 + "\n");
        response.getWriter().write("[GET] Response             : Hello from Native Java Servlet.\n");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        var xPartnerId = request.getHeader("X-Partner-Id");

        var param1 = request.getParameter("param-1");
        var param2 = request.getParameter("param-2");

        response.setContentType("text/plain");

        response.getWriter().write("[POST] Request URI          : " + request.getRequestURI() + "\n");
        response.getWriter().write("[POST] Header[X-PARTNER-ID] : " + xPartnerId + "\n");
        response.getWriter().write("[POST] Param-1              : " + param1 + "\n");
        response.getWriter().write("[POST] Param-2              : " + param2 + "\n");
        response.getWriter().write("[POST] Response             : Hello from Native Java Servlet.\n");
    }
}
