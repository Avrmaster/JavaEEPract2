package com.leskivproduction;

import java.io.*;

import javax.servlet.*;

import javax.servlet.http.*;

public abstract class HTMLServlet extends HttpServlet {

    protected abstract String getHtmlPath();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        printHTML(response);
    }

    protected void printHTML(HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try (var htmlReader = new BufferedReader(new FileReader(getHtmlPath()))) {
            htmlReader
                    .lines()
                    .forEach(out::println);
        } catch (IOException e) {
            out.println(e.getMessage());
        } finally {
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
