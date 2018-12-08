package ui.controller;

import domain.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyProduct extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Product product = getService().getProduct(Integer.parseInt(request.getParameter("id")));
        try {
            int amount = Integer.parseInt(request.getParameter("amount"));
            request.setAttribute("amount", amount);
        } catch (Exception e) {
            request.setAttribute("error", "Invalid amount.");
//            request.setAttribute("user", getCurrentUser(request));
            // TODO cart maken
            request.setAttribute("product", product);
            return "buyProductConfirmation.jsp";
        }
        request.setAttribute("product", product);
        return "buyProduct.jsp";
    }
}
