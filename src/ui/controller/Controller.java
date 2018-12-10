package ui.controller;


import domain.model.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private ShopService service;
    private ControllerFactory controllerFactory = new ControllerFactory();

    public Controller() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        service = new ShopService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        RequestHandler handler = controllerFactory.getController("Index", service);
        String destination = handler.handleRequest(request, response);
        if (action != null) {
            handler = controllerFactory.getController(action, service);
            try {
                destination = handler.handleRequest(request, response);
            } catch (NotAuthorizedException e) {
                request.setAttribute("notAuthorized",
                        "You have to log in or you have insufficient rights to have a look at the requested page.");
                destination = "error.jsp";
            }
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

}
