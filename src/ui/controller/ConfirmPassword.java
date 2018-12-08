package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmPassword extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String message = "NOT";
        try {
            if (getService().getPerson(id).isCorrectPassword(password)) {
                message = "";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        request.setAttribute("isCorrect", message);
        return "passwordConfirmation.jsp";
    }
}
