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
        String sort = getSortChoice(request);
        switch (sort) {
            case "email":
                request.setAttribute("email", true);
                break;
            case "firstname":
                request.setAttribute("firstname", true);
                break;
            case "name":
                request.setAttribute("name", true);
                break;
        }

        request.setAttribute("users", getService().getPersons());
        return "personoverview.jsp";
    }

    private String getSortChoice(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("sort"))
                    return cookie.getValue();
        return "";
    }
}
