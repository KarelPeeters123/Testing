package ui.controller;

import domain.db.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProductOverview extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        return handleProductOverviewRequest(request, response);
    }

    public String handleProductOverviewRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("products", getService().getProducts());

        Cart cart;
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            cart = new Cart(getService());
        } else {
            cart = (Cart) session.getAttribute("cart");
        }

        request.setAttribute("total", cart.totalAmountOfProducts());

        return "productoverview.jsp";
    }

}
