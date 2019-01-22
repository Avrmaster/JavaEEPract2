package com.leskivproduction;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;
public class MyServlet extends HTMLServlet {
    private final String SECURE_STORED_USERNAME = "user1";
    private final String SECURE_STORED_PASSWORD = "Year2019";

    @Override
    protected String getHtmlPath() {
        return "C:\\Users\\Sasha\\IdeaProjects\\JavaEE\\web\\static\\loginPage.html";
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getQueryString() != null) {
            Map<String, String> queryPairs = new LinkedHashMap<>();
            String[] pairs = request.getQueryString().split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                queryPairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"), URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            }

            if (queryPairs.containsKey("username") && queryPairs.containsKey("password")) {
                var loggedIn = checkUser(queryPairs.get("username"), queryPairs.get("password"));
                System.out.println("HERE " + loggedIn);

                response.sendRedirect(loggedIn
                        ? "/success"
                        : "/error"
                );
            }
        } else {
            printHTML(response);
        }

    }

    private boolean checkUser(final String username, final String password) {
        return username.equals(SECURE_STORED_USERNAME) &&
                password.equals(SECURE_STORED_PASSWORD);
    }

}
