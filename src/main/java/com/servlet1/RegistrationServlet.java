package com.servlet1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //processing post form request
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        if(email == null || name == null || age == null || password == null || confirmPassword == null){
            req.setAttribute("error", "Your are missing one of the inputs!");
            doGet(req, resp);
        }else{
            if(!password.equalsIgnoreCase(confirmPassword)){
                req.setAttribute("error", "Passwords did not match!");
                doGet(req, resp);
            }else {
                req.setAttribute("name", name);
                doGet(req, resp);
            }
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
    }
}
