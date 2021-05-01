package com.example.taller_4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", value = "/Login")
public class login extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String userName = request.getParameter("userName");
        PrintWriter out = response.getWriter();
        if (!userName.isEmpty()){
            System.out.println("ingreso exitoso mi pez");
        }else
            System.out.println("nel perro estas pendejo");


    }

}