package ui.controller;

import domain.model.Address;
import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ConfirmAddress extends ToOrderSuccessful {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Person person = getPersonFromSession(request);
        if (person == null) {
            errors.add("You have to log in");
        }

        Address address = new Address();

        setAddress(address, request, errors);
        setPlace(address, request, errors);
        setPostalCode(address, request, errors);
        setHouseNumber(address, request, errors);

        if (errors.size() == 0) {
            try {
                person.setAddress(address);
                return super.handleRequest(request, response);
            } catch (Exception e) {
                errors.add(e.getMessage());
                request.setAttribute("errors", errors);
                return "address.jsp";
            }
        } else {
            request.setAttribute("errors", errors);
            return "address.jsp";
        }
    }

    private Person getPersonFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("user") != null) {
            return (Person) session.getAttribute("user");
        }
        return null;
    }

    private void setAddress(Address address, HttpServletRequest request, ArrayList<String> errors) {
        String addressParam = request.getParameter("address");
        try {
            address.setAddress(addressParam);
            request.setAttribute("addressPreviousValue", addressParam);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setPlace(Address address, HttpServletRequest request, ArrayList<String> errors) {
        String place = request.getParameter("place");
        try {
            address.setPlace(place);
            request.setAttribute("placePreviousValue", place);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setPostalCode(Address address, HttpServletRequest request, ArrayList<String> errors) {
        String postalCode = request.getParameter("postalCode");
        try {
            int postalCodeInt = Integer.parseInt(postalCode);
            address.setPostalCode(postalCodeInt);
            request.setAttribute("postalCodePreviousValue", postalCode);
        } catch (NumberFormatException e) {
            errors.add("Invalid postal code");
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setHouseNumber(Address address, HttpServletRequest request, ArrayList<String> errors) {
        String houseNumber = request.getParameter("houseNumber");
        try {
            int houseNumberInt = Integer.parseInt(houseNumber);
            address.setHouseNumber(houseNumberInt);
            request.setAttribute("houseNumberPreviousValue", houseNumber);
        } catch (NumberFormatException e) {
            errors.add("Invalid house number");
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

}
