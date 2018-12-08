package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Index extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        handleSession(request);
        return "index.jsp";
    }

    private void handleSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") != null) {
            request.setAttribute("loggedIn", true);
        } else {
            request.setAttribute("loggedIn", false);
        }
    }

}
