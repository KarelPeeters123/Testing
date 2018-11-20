package ui.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String currentUser = getCurrentUser(request);
        if (!currentUser.isEmpty()) {
            request.setAttribute("currentUser", currentUser);
        } else {
            request.setAttribute("currentUser", "None");
        }
        return "index.jsp";
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
