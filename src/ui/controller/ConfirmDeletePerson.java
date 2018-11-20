package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmDeletePerson extends UserOverview {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        getService().deletePerson(id);
        return super.handleUserOverviewRequest(request, response);
    }
}
