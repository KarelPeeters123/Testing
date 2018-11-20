package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmDeleteProduct extends ProductOverview {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        getService().deleteProduct(idInt);
        return super.handleProductOverviewRequest(request, response);
    }
}
