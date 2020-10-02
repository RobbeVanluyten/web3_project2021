package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogIn extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = getService().getPersonIfAuthenticated(request.getParameter("logInPersonid"),
                request.getParameter("logInPassword"));//getService() methode staat in requestHandler
        if(person == null){
            request.setAttribute("error","No valid userid/password");
        }
        else{
            request.getSession().setAttribute("person", person);
        }
        return "index.jsp";
    }
}
