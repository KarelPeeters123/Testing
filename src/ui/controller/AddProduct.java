package ui.controller;

import domain.db.DbException;
import domain.model.DomainException;
import domain.model.Product;
import domain.model.Role;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AddProduct extends ProductOverview {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Role[] roles = {Role.ADMIN};
        try {
            checkRole(request, roles);
        } catch (NotAuthorizedException e) {
            errors.add("Not authorized.");
        }

        Product product = new Product();
        setProductName(product, request, errors);
        setProductDescription(product, request, errors);
        setProductPrice(product, request, errors);

        if (errors.size() == 0) {
            try {
                getService().addProduct(product);
                return super.handleProductOverviewRequest(request, response);
            } catch (DbException e) {
                if (e.getMessage().contains("duplicate key value")) {
                    errors.add("Product already exists");
                } else {
                    errors.add(e.getMessage());
                }
                request.setAttribute("errors", errors);
                return "addProduct.jsp";
            }
        } else {
            request.setAttribute("errors", errors);
            return "addProduct.jsp";
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
