package com.servlet1;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "HelloServlet", urlPatterns = {"/pictures"})
public class HelloServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("My post servlet is working as expected!");
    }

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
        }else{
            req.setAttribute("firstname", firstname);
            req.setAttribute("lastname", lastname);
            req.setAttribute("age", age);
        }

        getServletContext().getRequestDispatcher("/secondary").forward(req, resp);
    }

    //protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getServletContext().getRequestDispatcher("/secondary").forward(req, resp);
        //resp.sendRedirect("https://mymapplan.com/login");

        //accessing Get request parameters
//        String firstName = req.getParameter("firstname");
//        String lastName = req.getParameter("lastname");
//
//        if(firstName == null || lastName == null){
//            System.out.println("Full name required!");
//        }else {
//            System.out.println("Your parameters were successfully read.");
//        }
    //}

}