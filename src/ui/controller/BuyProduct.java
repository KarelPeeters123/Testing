package ui.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuyProduct extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("amount", request.getParameter("amount"));
        request.setAttribute("naam", getService().getProduct(Integer.valueOf(request.getParameter("id"))));
        return "buyProduct.jsp";

    }
}
