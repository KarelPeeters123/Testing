package ui.controller;

import domain.db.Cart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CartOverview extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("cart") != null) {
            Cart cart = (Cart) session.getAttribute("cart");
            request.setAttribute("products", cart.getProducts());
            request.setAttribute("total", cart.totalPrice());
        } else {
            request.setAttribute("products", null);
        }
        return "cartOverview.jsp";
    }
}
