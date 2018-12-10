package ui.controller;

import domain.db.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddToCart extends ProductOverview {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String error = "";

        int productId = Integer.parseInt(request.getParameter("id"));
        int quantity = 0;
        try {
            quantity = Integer.parseInt(request.getParameter("quantity"));
        } catch (NumberFormatException e) {
            error = "Invalid amount";
        }

        if (!error.isEmpty()) {
            request.setAttribute("error", error);
            return super.handleProductOverviewRequest(request, response);
        } else {
            HttpSession session = request.getSession();

            Cart cart;

            if (session.getAttribute("cart") == null) {
                cart = new Cart(getService());
            } else {
                cart = (Cart) session.getAttribute("cart");
            }

            try {
                cart.add(productId, quantity);
            } catch (IllegalArgumentException e) {
                request.setAttribute("error", e.getMessage());
            }

            session.setAttribute("cart", cart);

            return super.handleProductOverviewRequest(request, response);
        }
    }
}
