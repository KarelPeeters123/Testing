package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends Index {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String userid = request.getParameter("userid");
        String password = request.getParameter("passwd");

        try {
            if (getService().getPerson(userid).isCorrectPassword(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("user", getService().getPerson(userid));
                return super.handleRequest(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("error", "Invalid login credentials.");
        return super.handleRequest(request, response);
    }

}
