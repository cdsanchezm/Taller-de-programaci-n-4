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


        String dire="Formimage.html";

        String userName = request.getParameter("userName");
        PrintWriter out = response.getWriter();
        if (!userName.isEmpty()){
            response.addCookie(new Cookie("userName",userName));
            response.sendRedirect(dire);
        }else {


            out.println("<script type=\"text/javascript\">");
            out.println("alert('Por favor ingrese un usuario');");
            out.println("location='index.html';");
            out.println("</script>");

        }


    }

}