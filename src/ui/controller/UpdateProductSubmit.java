package ui.controller;

import domain.db.DbException;
import domain.model.DomainException;
import domain.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class UpdateProductSubmit extends ProductOverview {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        int id = Integer.parseInt(request.getParameter("id"));
        Product product = getService().getProduct(id);
        Product copy = new Product(product.getProductId(), product.getName(), product.getDescription(), product.getPrice());

        setProductName(copy, request, errors);
        setProductDescription(copy, request, errors);
        setProductPrice(copy, request, errors);

        if (errors.size() == 0) {
            try {
                getService().updateProduct(copy);
                return super.handleProductOverviewRequest(request, response);
            } catch (DbException e) {
                errors.add(e.getMessage());
                request.setAttribute("errors", errors);
                request.setAttribute("product", copy);
                return "Controller?action=ToProductUpdate&id=" + product.getProductId();
            }
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("product", copy);
            return "Controller?action=ToProductUpdate&id=" + product.getProductId();
        }
    }

    private void setProductName(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String name = request.getParameter("name");
        try {
            product.setName(name);
            request.setAttribute("namePreviousValue", name);
        } catch (DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private void setProductDescription(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String description = request.getParameter("description");
        try {
            product.setDescription(description);
            request.setAttribute("descriptionPreviousValue", description);
        } catch (DomainException e) {
            errors.add(e.getMessage());
        }
    }

    private void setProductPrice(Product product, HttpServletRequest request, ArrayList<String> errors) {
        String price = request.getParameter("price");
        try {
            double priceDouble = Double.parseDouble(price);
            product.setPrice(priceDouble);
            request.setAttribute("pricePreviousValue", price);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }
}
