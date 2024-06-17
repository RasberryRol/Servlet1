package com.servlet1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="SecondaryServlet", urlPatterns = "/secondary", initParams = {@WebInitParam(name = "copyrightYear", value = "2000")})
public class SecondaryServlet extends HelloServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getServletContext().getRequestDispatcher("/anotherPic.jsp").forward(req, resp);

        //accessing attributes and forwarding them
      /*  if(req.getAttribute("error")== null){
            String firstname = (String) req.getAttribute("firstname");
            String lastname = (String) req.getAttribute("lastname");
            String age = (String) req.getAttribute("age");

            System.out.println(firstname + " " + lastname + " " + age);
        }*/

        //using annotation to set servlet initialization rather than .xml file
        //,so we added: initParams = {@WebInitParam(name = "copyrightYear", value = "2000")}
        String copyrightYear = getServletConfig().getInitParameter("copyrightYear");
        if(copyrightYear != null){
            System.out.println("Year: " + copyrightYear);
        }

    }
}
