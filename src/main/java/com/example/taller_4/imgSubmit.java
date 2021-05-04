package com.example.taller_4;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.xml.crypto.Data;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import static com.example.taller_4.Constants.UPLOAD_DIRECTORY;

@WebServlet(name = "submit-img", value = "/Submit-IMG")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class imgSubmit extends HttpServlet {
    private String ImageName;

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Description = request.getParameter("descriptionIMG");
        String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists())
            uploadDir.mkdir();
        try {

            String fileName = "";
            for (Part part : request.getParts()) {
                fileName = getFileName(part);
                part.write(uploadPath + File.separator + fileName);
            }


            request.setAttribute("message", "File " + fileName + " has uploaded successfully!");
            setImageName(fileName);

            setImageName(fileName);
            response.addCookie(new Cookie("ImageName", getImageName()));
            String fecha = String.valueOf(LocalDateTime.now());
            response.addCookie(new Cookie("Fecha",fecha));
            response.addCookie(new Cookie("Description", Description));

        } catch (FileNotFoundException fne) {
            request.setAttribute("message", "There was an error: " + fne.getMessage());
        }
        getServletContext().getRequestDispatcher("/Formimage.html").forward(request, response);
    }


    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return Constants.DEFAULT_FILENAME;
    }


    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }
}

