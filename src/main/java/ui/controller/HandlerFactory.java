package ui.controller;


import domain.db.PersonService;

public class HandlerFactory {
    public RequestHandler getHandler(String handlerName, PersonService model) {//in handlerName komt de waarde die mee gegeven is in de command
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("ui.controller."+ handlerName);
                                //in ui.controller. kijken of er een handler bestaat met die mee gegeven handlerName(value van command)
            // Java 8/9
            Object handlerObject = handlerClass.newInstance();
            // Java 10
            // Object handlerObject = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) handlerObject;
            handler.setModel(model);//lijst van personen (model) toegekend aan de handler
        } catch (Exception e) {
            throw new RuntimeException("Deze pagina bestaat niet!!!!");
        }

        return handler;
    }
}
