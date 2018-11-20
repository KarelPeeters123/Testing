package ui.controller;

import domain.model.ShopService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class RequestHandler {

    private ShopService service;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response);

    public void setService(ShopService service) {
        this.service = service;
    }

    public ShopService getService() {
        return service;
    }

    public String getCurrentUser(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("loggedin"))
                    return cookie.getValue();
        return "";
    }
}
