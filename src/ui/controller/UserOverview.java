package ui.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserOverview extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return handleUserOverviewRequest(request, response);
    }

    public String handleUserOverviewRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("users", getService().getPersons());

        if (getCurrentUser(request).equals("admin")) {
            return "personoverviewAdmin.jsp";
        } else {
            return "personoverview.jsp";
        }
    }

    private String getCurrentUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("loggedin"))
                    return cookie.getValue();
        return "";
    }
}
