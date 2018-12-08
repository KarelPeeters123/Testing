package ui.controller;

import domain.model.Person;
import domain.model.Role;
import domain.model.ShopService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {

    private ShopService service;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);

    public ShopService getService() {
        return service;
    }

    public void setService(ShopService service) {
        this.service = service;
    }

    public void checkRole(HttpServletRequest request, Role[] roles) {
        boolean found = false;
        Person person = (Person) request.getSession().getAttribute("user");
        if (person != null)
            for (Role role : roles) {
                if (person.getRole().equals(role))
                    found = true;
            }
        if (!found)
            throw new NotAuthorizedException();
    }
}
