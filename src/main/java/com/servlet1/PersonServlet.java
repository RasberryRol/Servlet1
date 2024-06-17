package com.servlet1;

import com.servlet1.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "PersonServlet", urlPatterns = "/person")
public class PersonServlet extends HttpServlet {

    //accessing attributes using objects
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //accessing attributes
        String firstname = req.getParameter("firstname");
        String lastname = req.getParameter("lastname");
        String age = req.getParameter("age");

        StringBuilder error = new StringBuilder();
        if(firstname == null){
            error.append("A first name was not provided.");
        } else if (lastname == null) {
            error.append("A last name was not provided.");
        } else if (age == null) {
            error.append("An age was not provided.");
        }

        if(error.length() > 0){
            req.setAttribute("error", error.toString());
            req.setAttribute("user", new User());
        }else{
            req.setAttribute("user", new User(firstname, lastname, Integer.parseInt(age)));
        }

        getServletContext().getRequestDispatcher("/attributes.jsp").forward(req, resp);
    }
}


