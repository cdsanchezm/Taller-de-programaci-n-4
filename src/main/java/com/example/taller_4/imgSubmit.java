package com.example.taller_4;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@MultipartConfig
@WebServlet(name = "submit-img", value = "/Submit-IMG")
public class imgSubmit extends HttpServlet {
    usuario user = new usuario();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Cookie[] Cookies = request.getCookies();
            for (int i = 0; i < Cookies.length; i++) {
                if (Cookies[i].getName().equals("userName")) {
                    user.setName(Cookies[i].getValue());
                }
            }
            Part imagPart = request.getPart("image");
            int imagSize = (int) imagPart.getSize();
            byte[] image = null;
            if (imagSize > 0) {
                image = new byte[imagSize];
                try (DataInputStream dis = new DataInputStream(imagPart.getInputStream())) {
                    dis.readFully(image);
                }
            }
            if (imagSize > 0) {
                user.setImage(image);
            }
            user.setDescription(request.getParameter("descriptionIMG"));

            Date f = new Date();
            user.setFecha(f);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}
