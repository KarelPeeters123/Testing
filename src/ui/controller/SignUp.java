package ui.controller;

import domain.db.DbException;
import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class SignUp extends UserOverview {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ArrayList<String> errors = new ArrayList<>();

        Person person = new Person();
        setUserId(person, request, errors);
        setFirstName(person, request, errors);
        setLastName(person, request, errors);
        setEmail(person, request, errors);
        setPassword(person, request, errors);

        if (errors.size() == 0) {
            try {
                getService().addPerson(person);
                return super.handleUserOverviewRequest(request, response);  // DIT IS JUIST
            } catch (DbException e) {
                if (e.getMessage().contains("duplicate key value")) {
                    errors.add("User already exists");
                } else {
                    errors.add(e.getMessage());
                }
                request.setAttribute("errors", errors);
                return "signUp.jsp";
            }
        } else {
            request.setAttribute("errors", errors);
            return "signUp.jsp";
        }
    }

    private void setUserId(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String userId = request.getParameter("userid");
        try {
            person.setUserid(userId);
            request.setAttribute("userIdPreviousValue", userId);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setFirstName(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String firstName = request.getParameter("firstName");
        try {
            person.setFirstName(firstName);
            request.setAttribute("firstNamePreviousValue", firstName);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setLastName(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String lastName = request.getParameter("lastName");
        try {
            person.setLastName(lastName);
            request.setAttribute("lastNamePreviousValue", lastName);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setEmail(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String email = request.getParameter("email");
        try {
            person.setEmail(email);
            request.setAttribute("emailPreviousValue", email);
        } catch (IllegalArgumentException e) {
            errors.add(e.getMessage());
        }
    }

    private void setPassword(Person person, HttpServletRequest request, ArrayList<String> errors) {
        String password = request.getParameter("password");
        try {
            person.setPasswordHashed(password);
        } catch (Exception e) {
            errors.add(e.getMessage());
        }
    }
}
