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
        String destination = "index.jsp";
        if (action != null) {
            RequestHandler handler;
            handler = controllerFactory.getController(action, service);
            destination = handler.handleRequest(request, response);
        }
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
    }

}
