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
        return "productoverview.jsp";
    }
}


// DIT IS JUIST
