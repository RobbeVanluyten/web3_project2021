package ui.controller;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class Add extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Person person = new Person();
        List<String> result = new ArrayList<String>();
        getEmail(person,request,result);
        getFirstName(person,request,result);
        getLastName(person,request,result);
        getPassword(person,request,result);
        getUserid(person,request,result);

        String destination;
        if (result.size() > 0) {//als er exceptions in result zitten
            request.setAttribute("result", result);
            destination = "register.jsp";
        }
        else {
            service.add(person);
            destination = "index.jsp";//gaat naar index.jsp
        }

        return destination;
    }
    public void getUserid(Person person, HttpServletRequest request, List<String> result) {
        String userid = request.getParameter("userid");
        request.setAttribute("useridPreviousValue", userid);
        try {
            person.setUserid(userid);
            request.setAttribute("useridClass", "has-success");
        }
        catch (Exception exc) {
            request.setAttribute("useridClass", "has-error");
            result.add(exc.getMessage());
        }
    }

    public void getEmail(Person person, HttpServletRequest request, List<String> result) {
        String email = request.getParameter("email");
        request.setAttribute("emailPreviousValue", email);
        try {
            person.setEmail(email);
            request.setAttribute("emailClass", "has-success");
        }
        catch (Exception exc) {
            request.setAttribute("emailClass", "has-error");
            result.add(exc.getMessage());
        }
    }

    private void getPassword(Person person, HttpServletRequest request, List<String> result) {
        String password = request.getParameter("password");
        request.setAttribute("passwordPreviousValue", password);
        try {
            person.setPassword(password);
            request.setAttribute("passwordClass", "has-success");
        }
        catch (Exception exc) {
            request.setAttribute("passwordClass", "has-error");
            result.add(exc.getMessage());
        }
    }

    public void getFirstName(Person person, HttpServletRequest request, List<String> result) {
        String firstName = request.getParameter("firstName");
        request.setAttribute("firstNamePreviousValue", firstName);
        try {
            person.setFirstName(firstName);
            request.setAttribute("firstNameClass", "has-success");
        }
        catch (Exception exc) {
            request.setAttribute("firstNameClass", "has-error");
            result.add(exc.getMessage());
        }
    }

    public void getLastName(Person person, HttpServletRequest request, List<String> result) {
        String lastName = request.getParameter("lastName");
        request.setAttribute("lastNamePreviousValue", lastName);
        try {
            person.setLastName(lastName);
            request.setAttribute("lastNameClass", "has-success");
        }
        catch (Exception exc) {
            request.setAttribute("lastNameClass", "has-error");
            result.add(exc.getMessage());
        }
    }


}

