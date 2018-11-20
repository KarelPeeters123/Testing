package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckPassword extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String personId = request.getParameter("id");
        request.setAttribute("id", personId);
        return "checkPassword.jsp";
    }
}
