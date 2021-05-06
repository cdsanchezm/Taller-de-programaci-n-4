package com.example.taller_4;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name ="Cookie_Img", value = "/cookie_img")
public class Cookie_Img extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


        String dire="index.html";
        String dire2 ="Formimage.html";
        String img = request.getParameter("image");
        PrintWriter out = response.getWriter();


        if (!img.isEmpty()){
            System.out.println(img);
            response.addCookie(new Cookie("img",img));
    }else {


                out.println("<script type=\"text/javascript\">");
                out.println("alert('Por favor ingrese una imagen');");
                out.println("location='Formimage.html';");
                out.println("</script>");

        }
}

}
