package ui.controller;

import domain.db.PersonService;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PersonService service = new PersonService();
    private HandlerFactory handlerFactory = new HandlerFactory();

    public Servlet() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String destination = "index.jsp";
        if (command != null) {
            try {
                RequestHandler handler = handlerFactory.getHandler(command, service); //handler aanmaken
               destination = handler.handleRequest(request, response);
            } catch (Exception exc) {
                request.setAttribute("error", exc.getMessage());
                destination = "error.jsp";
            }
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }
}
