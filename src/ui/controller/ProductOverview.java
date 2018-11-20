package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductOverview extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return handleProductOverviewRequest(request, response);
    }

    public String handleProductOverviewRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", getService().getProducts());

        if (getCurrentUser(request).equals("admin")) {
            return "productoverviewAdmin.jsp";
        } else {
            return "productoverview.jsp";
        }
    }

}
