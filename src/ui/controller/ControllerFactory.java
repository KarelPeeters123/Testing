package ui.controller;

import domain.model.ShopService;

public class ControllerFactory {

    public RequestHandler getController(String action, ShopService service) {
        return createHandler(action, service);
    }

    private RequestHandler createHandler(String handlerName, ShopService service) {
        RequestHandler handler = null;
        try {
            Class<?> handlerClass = Class.forName("ui.controller."+ handlerName);
            Object handlerObject = handlerClass.newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setService(service);
        } catch (Exception e) {
            throw new RuntimeException("The requested page doesn’t exist");
        }
        return handler;
    }
}
