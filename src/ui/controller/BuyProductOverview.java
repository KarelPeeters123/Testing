package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyProductOverview extends ProductOverview {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//        if (getCurrentUser(request).isEmpty()) {
//            request.setAttribute("error", "You have to log in to buy a product.");
//            return super.handleProductOverviewRequest(request, response);
//        } else {
//            int id = Integer.valueOf(request.getParameter("id"));
//            request.setAttribute("product", getService().getProduct(id));
//            request.setAttribute("user", getCurrentUser(request));
//            return "buyProductConfirmation.jsp";
        return null;
    }
    // TODO cart maken
}
