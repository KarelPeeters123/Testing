package ui.controller;

import domain.model.Address;
import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ToOrderSuccessful extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        Address address = person.getAddress();
        request.setAttribute("address", address.toString());
        return "orderSuccessful.jsp";
    }
}
