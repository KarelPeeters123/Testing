package ui.controller;

import domain.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ToProductUpdate extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = getService().getProduct(id);
        request.setAttribute("id", product.getProductId());
        request.setAttribute("namePreviousValue", product.getName());
        request.setAttribute("descriptionPreviousValue", product.getDescription());
        request.setAttribute("pricePreviousValue", product.getPrice());
        return "updateProduct.jsp";
    }
}
