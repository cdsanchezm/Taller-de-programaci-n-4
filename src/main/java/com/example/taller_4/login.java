package com.example.taller_4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", value = "/Login")
public class login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String dire="localhost:8080/taller-4-1.0-SNAPSHOT/Formimage.html";
        response.sendRedirect("http://"+dire);
        String userName = request.getParameter("userName");
        response.addCookie(new Cookie("userName",userName));
    }

}